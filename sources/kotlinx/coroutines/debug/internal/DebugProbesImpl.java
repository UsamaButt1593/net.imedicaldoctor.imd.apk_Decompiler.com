package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\u000e\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0003J;\u0010\u0014\u001a\u00020\u0006*\u00020\u000b2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0\f2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\"\b\b\u0000\u0010\u0016*\u00020\u00012\u001e\b\u0004\u0010\u001a\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00028\u00000\u0017H\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u0012*\u00020\u0001H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b$\u0010%J%\u0010(\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u001bH\u0002¢\u0006\u0004\b(\u0010)J5\u0010.\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0006\u0010*\u001a\u00020\u00122\b\u0010,\u001a\u0004\u0018\u00010+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u001bH\u0002¢\u0006\u0004\b.\u0010/J?\u00105\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u000200042\u0006\u00101\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020&022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u001bH\u0002¢\u0006\u0004\b5\u00106J3\u00108\u001a\u0002002\u0006\u00107\u001a\u0002002\f\u00103\u001a\b\u0012\u0004\u0012\u00020&022\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u001bH\u0002¢\u0006\u0004\b8\u00109J#\u0010<\u001a\u00020\u00062\n\u0010;\u001a\u0006\u0012\u0002\b\u00030:2\u0006\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\b<\u0010=J\u001f\u0010\u0016\u001a\u00020\u00062\u0006\u0010;\u001a\u00020>2\u0006\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010?J\u0016\u0010@\u001a\u0004\u0018\u00010>*\u00020>H\u0010¢\u0006\u0004\b@\u0010AJ/\u0010C\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030\u00182\n\u0010;\u001a\u0006\u0012\u0002\b\u00030:2\u0006\u0010*\u001a\u00020\u0012H\u0002¢\u0006\u0004\bC\u0010DJ\u001d\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018*\u0006\u0012\u0002\b\u00030:H\u0002¢\u0006\u0004\bE\u0010FJ\u001a\u0010G\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0018*\u00020>H\u0010¢\u0006\u0004\bG\u0010HJ\u001b\u0010J\u001a\u0004\u0018\u00010I*\b\u0012\u0004\u0012\u00020&0\u001bH\u0002¢\u0006\u0004\bJ\u0010KJ3\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000:\"\u0004\b\u0000\u0010C2\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000:2\b\u0010;\u001a\u0004\u0018\u00010IH\u0002¢\u0006\u0004\bM\u0010NJ\u001b\u0010O\u001a\u00020\u00062\n\u0010B\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0002¢\u0006\u0004\bO\u0010PJ'\u0010S\u001a\b\u0012\u0004\u0012\u00020&0\u001b\"\b\b\u0000\u0010C*\u00020Q2\u0006\u0010R\u001a\u00028\u0000H\u0002¢\u0006\u0004\bS\u0010TJ\r\u0010U\u001a\u00020\u0006¢\u0006\u0004\bU\u0010\u0003J\r\u0010V\u001a\u00020\u0006¢\u0006\u0004\bV\u0010\u0003J\u0015\u0010X\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u000b¢\u0006\u0004\bX\u0010YJ\u0013\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u000102¢\u0006\u0004\bZ\u0010[J\u0015\u0010^\u001a\u00020\u00122\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\b\u0012\u0004\u0012\u00020\\0\u001b¢\u0006\u0004\b`\u0010aJ\u0013\u0010c\u001a\b\u0012\u0004\u0012\u00020b0\u001b¢\u0006\u0004\bc\u0010aJ\u0015\u0010d\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\bd\u0010%J)\u0010e\u001a\b\u0012\u0004\u0012\u00020&0\u001b2\u0006\u0010]\u001a\u00020\\2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\u001b¢\u0006\u0004\be\u0010fJ\u001b\u0010g\u001a\u00020\u00062\n\u0010;\u001a\u0006\u0012\u0002\b\u00030:H\u0000¢\u0006\u0004\bg\u0010hJ\u001b\u0010i\u001a\u00020\u00062\n\u0010;\u001a\u0006\u0012\u0002\b\u00030:H\u0000¢\u0006\u0004\bi\u0010hJ)\u0010j\u001a\b\u0012\u0004\u0012\u00028\u00000:\"\u0004\b\u0000\u0010C2\f\u0010L\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0000¢\u0006\u0004\bj\u0010kR\u0014\u0010n\u001a\u00020\u00128\u0002XT¢\u0006\u0006\n\u0004\bl\u0010mR\u0014\u0010r\u001a\u00020o8\u0002X\u0004¢\u0006\u0006\n\u0004\bp\u0010qR\u0018\u0010t\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010sR$\u0010w\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00050u8\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010vR\u0016\u0010x\u001a\u0002008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bx\u0010@R\u0014\u0010{\u001a\u00020y8\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010zR$\u0010\u0001\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0013\n\u0004\b\u001c\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u0010\u0001R&\u0010\u0001\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0015\n\u0004\b$\u0010|\u001a\u0005\b\u0001\u0010~\"\u0006\b\u0001\u0010\u0001R$\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0007\n\u0005\bc\u0010\u0001R!\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\r0u8\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010vR\"\u0010\u0001\u001a\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u00018BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00020\u0012*\u00020\u000b8BX\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010YR\u001b\u0010\u0001\u001a\u00020\u0005*\u00020&8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u00058@X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010~¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "", "<init>", "()V", "Lkotlin/Function1;", "", "", "t", "()Lkotlin/jvm/functions/Function1;", "M", "N", "Lkotlinx/coroutines/Job;", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "", "indent", "d", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "", "i", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "P", "(Ljava/lang/Object;)Ljava/lang/String;", "y", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "Ljava/io/PrintStream;", "out", "j", "(Ljava/io/PrintStream;)V", "Ljava/lang/StackTraceElement;", "frames", "D", "(Ljava/io/PrintStream;Ljava/util/List;)V", "state", "Ljava/lang/Thread;", "thread", "coroutineTrace", "n", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "", "actualTrace", "Lkotlin/Pair;", "o", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "p", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/coroutines/Continuation;", "frame", "S", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "I", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "owner", "T", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "B", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "C", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "O", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "completion", "e", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "E", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "", "throwable", "J", "(Ljava/lang/Throwable;)Ljava/util/List;", "x", "Q", "job", "w", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "h", "()[Ljava/lang/Object;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "info", "m", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "g", "()Ljava/util/List;", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "k", "f", "l", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "G", "(Lkotlin/coroutines/Continuation;)V", "H", "F", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "b", "Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/text/SimpleDateFormat;", "c", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/lang/Thread;", "weakRefCleanerThread", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "capturedCoroutinesMap", "installations", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Z", "v", "()Z", "L", "(Z)V", "sanitizeStackTraces", "u", "K", "enableCreationStackTraces", "Lkotlin/jvm/functions/Function1;", "dynamicAttach", "callerInfoCache", "", "q", "()Ljava/util/Set;", "capturedCoroutines", "r", "s", "(Lkotlinx/coroutines/Job;)V", "debugString", "A", "(Ljava/lang/StackTraceElement;)Z", "isInternalMethod", "z", "isInstalled", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class DebugProbesImpl {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final DebugProbesImpl f29286a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f29287b = "Coroutine creation stacktrace";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final SimpleDateFormat f29288c = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Thread f29289d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> f29290e = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ SequenceNumberRefVolatile f29291f = new SequenceNumberRefVolatile(0);

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f29292g = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final ReentrantReadWriteLock f29293h = new ReentrantReadWriteLock();

    /* renamed from: i  reason: collision with root package name */
    private static boolean f29294i = true;
    private static volatile int installations;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f29295j = true;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final Function1<Boolean, Unit> f29296k;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> f29297l = new ConcurrentWeakMap<>(true);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "info", "frame", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "Ljava/lang/StackTraceElement;", "K", "()Ljava/lang/StackTraceElement;", "Lkotlin/Result;", "result", "", "w", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/Continuation;", "X", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "Y", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlin/coroutines/CoroutineContext;", "g", "()Lkotlin/coroutines/CoroutineContext;", "context", "j", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        @NotNull
        @JvmField
        public final DebugCoroutineInfoImpl X;
        @Nullable
        private final CoroutineStackFrame Y;
        @NotNull
        @JvmField
        public final Continuation<T> s;

        public CoroutineOwner(@NotNull Continuation<? super T> continuation, @NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @Nullable CoroutineStackFrame coroutineStackFrame) {
            this.s = continuation;
            this.X = debugCoroutineInfoImpl;
            this.Y = coroutineStackFrame;
        }

        @Nullable
        public StackTraceElement K() {
            CoroutineStackFrame coroutineStackFrame = this.Y;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.K();
            }
            return null;
        }

        @NotNull
        public CoroutineContext g() {
            return this.s.g();
        }

        @Nullable
        public CoroutineStackFrame j() {
            CoroutineStackFrame coroutineStackFrame = this.Y;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.j();
            }
            return null;
        }

        @NotNull
        public String toString() {
            return this.s.toString();
        }

        public void w(@NotNull Object obj) {
            DebugProbesImpl.f29286a.E(this);
            this.s.w(obj);
        }
    }

    /* synthetic */ class SequenceNumberRefVolatile {
        volatile long sequenceNumber;

        public SequenceNumberRefVolatile(long j2) {
            this.sequenceNumber = j2;
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        f29286a = debugProbesImpl;
        f29296k = debugProbesImpl.t();
    }

    private DebugProbesImpl() {
    }

    private final boolean A(StackTraceElement stackTraceElement) {
        return StringsKt.s2(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    private final CoroutineOwner<?> B(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return C(coroutineStackFrame);
        }
        return null;
    }

    private final CoroutineOwner<?> C(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.j();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    private final void D(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stackTraceElement : list) {
            printStream.print("\n\tat " + stackTraceElement);
        }
    }

    /* access modifiers changed from: private */
    public final void E(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame I;
        f29290e.remove(coroutineOwner);
        CoroutineStackFrame f2 = coroutineOwner.X.f();
        if (f2 != null && (I = I(f2)) != null) {
            f29297l.remove(I);
        }
    }

    private final CoroutineStackFrame I(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.j();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.K() == null);
        return coroutineStackFrame;
    }

    private final <T extends Throwable> List<StackTraceElement> J(T t) {
        int i2;
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i3 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i4 = length2 - 1;
                if (Intrinsics.g(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i3 = length2;
                    break;
                } else if (i4 < 0) {
                    break;
                } else {
                    length2 = i4;
                }
            }
        }
        if (!f29294i) {
            int i5 = length - i2;
            ArrayList arrayList = new ArrayList(i5);
            int i6 = 0;
            while (i6 < i5) {
                arrayList.add(i6 == 0 ? StackTraceRecoveryKt.d(f29287b) : stackTrace[i6 + i2]);
                i6++;
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i2) + 1);
        arrayList2.add(StackTraceRecoveryKt.d(f29287b));
        while (true) {
            i2++;
            while (i2 < length) {
                if (A(stackTrace[i2])) {
                    arrayList2.add(stackTrace[i2]);
                    int i7 = i2 + 1;
                    while (i7 < length && A(stackTrace[i7])) {
                        i7++;
                    }
                    int i8 = i7 - 1;
                    int i9 = i8;
                    while (i9 > i2 && stackTrace[i9].getFileName() == null) {
                        i9--;
                    }
                    if (i9 > i2 && i9 < i8) {
                        arrayList2.add(stackTrace[i9]);
                    }
                    arrayList2.add(stackTrace[i8]);
                    i2 = i7;
                } else {
                    arrayList2.add(stackTrace[i2]);
                }
            }
            return arrayList2;
        }
    }

    private final void M() {
        f29289d = ThreadsKt.c(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.X, 21, (Object) null);
    }

    private final void N() {
        Thread thread = f29289d;
        if (thread != null) {
            f29289d = null;
            thread.interrupt();
            thread.join();
        }
    }

    private final StackTraceFrame O(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }

    private final String P(Object obj) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(obj);
        sb.append('\"');
        return sb.toString();
    }

    private final void R(CoroutineStackFrame coroutineStackFrame, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f29293h.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f29286a;
            if (!debugProbesImpl.z()) {
                readLock.unlock();
                return;
            }
            ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = f29297l;
            DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
            if (remove == null) {
                CoroutineOwner<?> C = debugProbesImpl.C(coroutineStackFrame);
                if (C != null) {
                    remove = C.X;
                    if (remove != null) {
                        CoroutineStackFrame f2 = remove.f();
                        CoroutineStackFrame I = f2 != null ? debugProbesImpl.I(f2) : null;
                        if (I != null) {
                            concurrentWeakMap.remove(I);
                        }
                    }
                }
                return;
            }
            remove.j(str, (Continuation) coroutineStackFrame);
            CoroutineStackFrame I2 = debugProbesImpl.I(coroutineStackFrame);
            if (I2 == null) {
                readLock.unlock();
                return;
            }
            concurrentWeakMap.put(I2, remove);
            Unit unit = Unit.f28779a;
            readLock.unlock();
        } finally {
            readLock.unlock();
        }
    }

    private final void S(Continuation<?> continuation, String str) {
        if (z()) {
            if (!Intrinsics.g(str, DebugCoroutineInfoImplKt.f29284b) || !KotlinVersion.Z2.g(1, 3, 30)) {
                CoroutineOwner<?> B = B(continuation);
                if (B != null) {
                    T(B, continuation, str);
                    return;
                }
                return;
            }
            CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
            if (coroutineStackFrame != null) {
                R(coroutineStackFrame, str);
            }
        }
    }

    private final void T(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        ReentrantReadWriteLock.ReadLock readLock = f29293h.readLock();
        readLock.lock();
        try {
            if (f29286a.z()) {
                coroutineOwner.X.j(str, continuation);
                Unit unit = Unit.f28779a;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0084 A[LOOP:0: B:8:0x007e->B:10:0x0084, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d(kotlinx.coroutines.Job r7, java.util.Map<kotlinx.coroutines.Job, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> r8, java.lang.StringBuilder r9, java.lang.String r10) {
        /*
            r6 = this;
            java.lang.Object r0 = r8.get(r7)
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r0
            r1 = 9
            r2 = 10
            if (r0 != 0) goto L_0x0039
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.ScopeCoroutine
            if (r0 != 0) goto L_0x0076
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            java.lang.String r3 = r6.r(r7)
            r0.append(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r9.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x002e:
            r0.append(r10)
            r0.append(r1)
            java.lang.String r10 = r0.toString()
            goto L_0x0076
        L_0x0039:
            java.util.List r3 = r0.h()
            java.lang.Object r3 = kotlin.collections.CollectionsKt.D2(r3)
            java.lang.StackTraceElement r3 = (java.lang.StackTraceElement) r3
            java.lang.String r0 = r0.g()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r10)
            java.lang.String r5 = r6.r(r7)
            r4.append(r5)
            java.lang.String r5 = ", continuation is "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " at line "
            r4.append(r0)
            r4.append(r3)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r9.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            goto L_0x002e
        L_0x0076:
            kotlin.sequences.Sequence r7 = r7.y()
            java.util.Iterator r7 = r7.iterator()
        L_0x007e:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x008e
            java.lang.Object r0 = r7.next()
            kotlinx.coroutines.Job r0 = (kotlinx.coroutines.Job) r0
            r6.d(r0, r8, r9, r10)
            goto L_0x007e
        L_0x008e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.d(kotlinx.coroutines.Job, java.util.Map, java.lang.StringBuilder, java.lang.String):void");
    }

    private final <T> Continuation<T> e(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!z()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.g(), stackTraceFrame, f29292g.incrementAndGet(f29291f)), stackTraceFrame);
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = f29290e;
        concurrentWeakMap.put(coroutineOwner, Boolean.TRUE);
        if (!z()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final <R> java.util.List<R> i(kotlin.jvm.functions.Function2<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r8) {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f29293h
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = f29286a     // Catch:{ all -> 0x005c }
            boolean r6 = r5.z()     // Catch:{ all -> 0x005c }
            if (r6 == 0) goto L_0x005e
            java.util.Set r5 = r5.q()     // Catch:{ all -> 0x005c }
            kotlin.sequences.Sequence r5 = kotlin.collections.CollectionsKt.x1(r5)     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x005c }
            r6.<init>()     // Catch:{ all -> 0x005c }
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt.K2(r5, r6)     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3     // Catch:{ all -> 0x005c }
            r6.<init>(r8)     // Catch:{ all -> 0x005c }
            kotlin.sequences.Sequence r8 = kotlin.sequences.SequencesKt.p1(r5, r6)     // Catch:{ all -> 0x005c }
            java.util.List r8 = kotlin.sequences.SequencesKt.c3(r8)     // Catch:{ all -> 0x005c }
            kotlin.jvm.internal.InlineMarker.d(r4)
        L_0x004d:
            if (r3 >= r2) goto L_0x0055
            r1.lock()
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0055:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.c(r4)
            return r8
        L_0x005c:
            r8 = move-exception
            goto L_0x006a
        L_0x005e:
            java.lang.String r8 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005c }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x005c }
            r5.<init>(r8)     // Catch:{ all -> 0x005c }
            throw r5     // Catch:{ all -> 0x005c }
        L_0x006a:
            kotlin.jvm.internal.InlineMarker.d(r4)
        L_0x006d:
            if (r3 >= r2) goto L_0x0075
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0075:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.c(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.i(kotlin.jvm.functions.Function2):java.util.List");
    }

    private final void j(PrintStream printStream) {
        String str;
        ReentrantReadWriteLock reentrantReadWriteLock = f29293h;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f29286a;
            if (debugProbesImpl.z()) {
                printStream.print("Coroutines dump " + f29288c.format(Long.valueOf(System.currentTimeMillis())));
                for (T t : SequencesKt.K2(SequencesKt.p0(CollectionsKt.x1(debugProbesImpl.q()), DebugProbesImpl$dumpCoroutinesSynchronized$1$2.X), new DebugProbesImpl$dumpCoroutinesSynchronized$lambda19$$inlined$sortedBy$1())) {
                    DebugCoroutineInfoImpl debugCoroutineInfoImpl = t.X;
                    List<StackTraceElement> h2 = debugCoroutineInfoImpl.h();
                    DebugProbesImpl debugProbesImpl2 = f29286a;
                    List<StackTraceElement> n2 = debugProbesImpl2.n(debugCoroutineInfoImpl.g(), debugCoroutineInfoImpl.f29281e, h2);
                    if (!Intrinsics.g(debugCoroutineInfoImpl.g(), DebugCoroutineInfoImplKt.f29284b) || n2 != h2) {
                        str = debugCoroutineInfoImpl.g();
                    } else {
                        str = debugCoroutineInfoImpl.g() + " (Last suspension stacktrace, not an actual stacktrace)";
                    }
                    printStream.print("\n\nCoroutine " + t.s + ", state: " + str);
                    if (h2.isEmpty()) {
                        printStream.print("\n\tat " + StackTraceRecoveryKt.d(f29287b));
                        debugProbesImpl2.D(printStream, debugCoroutineInfoImpl.e());
                    } else {
                        debugProbesImpl2.D(printStream, n2);
                    }
                }
                Unit unit = Unit.f28779a;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    private final List<StackTraceElement> n(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        if (!Intrinsics.g(str, DebugCoroutineInfoImplKt.f29284b) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.X;
            obj = Result.b(thread.getStackTrace());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.i(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            if (Intrinsics.g(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.g(stackTraceElement.getMethodName(), "resumeWith") && Intrinsics.g(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i2++;
        }
        Pair<Integer, Integer> o = o(i2, stackTraceElementArr, list);
        int intValue = o.a().intValue();
        int intValue2 = o.b().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i2) - intValue) - 1) - intValue2);
        int i3 = i2 - intValue2;
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(stackTraceElementArr[i4]);
        }
        int size = list.size();
        for (int i5 = intValue + 1; i5 < size; i5++) {
            arrayList.add(list.get(i5));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> o(int i2, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        int i3;
        int i4;
        int i5 = 0;
        while (true) {
            if (i5 >= 3) {
                i3 = -1;
                i4 = 0;
                break;
            }
            int p = f29286a.p((i2 - 1) - i5, stackTraceElementArr, list);
            if (p != -1) {
                i3 = Integer.valueOf(p);
                i4 = Integer.valueOf(i5);
                break;
            }
            i5++;
        }
        return TuplesKt.a(i3, i4);
    }

    private final int p(int i2, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.Pe(stackTraceElementArr, i2);
        if (stackTraceElement == null) {
            return -1;
        }
        int i3 = 0;
        for (StackTraceElement next : list) {
            if (Intrinsics.g(next.getFileName(), stackTraceElement.getFileName()) && Intrinsics.g(next.getClassName(), stackTraceElement.getClassName()) && Intrinsics.g(next.getMethodName(), stackTraceElement.getMethodName())) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    private final Set<CoroutineOwner<?>> q() {
        return f29290e.keySet();
    }

    private final String r(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).z1() : job.toString();
    }

    private static /* synthetic */ void s(Job job) {
    }

    private final Function1<Boolean, Unit> t() {
        Object obj;
        Function1<Boolean, Unit> function1 = null;
        try {
            Result.Companion companion = Result.X;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance((Object[]) null);
            if (newInstance != null) {
                obj = Result.b((Function1) TypeIntrinsics.q(newInstance, 1));
                if (!Result.i(obj)) {
                    function1 = obj;
                }
                return function1;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th) {
            Result.Companion companion2 = Result.X;
            obj = Result.b(ResultKt.a(th));
        }
    }

    /* access modifiers changed from: private */
    public final boolean y(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext c2 = coroutineOwner.X.c();
        if (c2 == null || (job = (Job) c2.e(Job.P2)) == null || !job.p()) {
            return false;
        }
        f29290e.remove(coroutineOwner);
        return true;
    }

    @NotNull
    public final <T> Continuation<T> F(@NotNull Continuation<? super T> continuation) {
        if (!z() || B(continuation) != null) {
            return continuation;
        }
        return e(continuation, f29295j ? O(J(new Exception())) : null);
    }

    public final void G(@NotNull Continuation<?> continuation) {
        S(continuation, DebugCoroutineInfoImplKt.f29284b);
    }

    public final void H(@NotNull Continuation<?> continuation) {
        S(continuation, DebugCoroutineInfoImplKt.f29285c);
    }

    public final void K(boolean z) {
        f29295j = z;
    }

    public final void L(boolean z) {
        f29294i = z;
    }

    public final void Q() {
        ReentrantReadWriteLock reentrantReadWriteLock = f29293h;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f29286a;
            if (debugProbesImpl.z()) {
                installations--;
                if (installations != 0) {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    return;
                }
                debugProbesImpl.N();
                f29290e.clear();
                f29297l.clear();
                if (AgentInstallationType.f29255a.a()) {
                    while (i2 < readHoldCount) {
                        readLock.lock();
                        i2++;
                    }
                    writeLock.unlock();
                    return;
                }
                Function1<Boolean, Unit> function1 = f29296k;
                if (function1 != null) {
                    function1.f(Boolean.FALSE);
                }
                Unit unit = Unit.f28779a;
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            throw new IllegalStateException("Agent was not installed".toString());
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void f(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            f29286a.j(printStream);
            Unit unit = Unit.f28779a;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> g() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f29293h
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = f29286a     // Catch:{ all -> 0x0055 }
            boolean r5 = r4.z()     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0057
            java.util.Set r4 = r4.q()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.x1(r4)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0055 }
            r5.<init>()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.K2(r4, r5)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0055 }
            r5.<init>()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.p1(r4, r5)     // Catch:{ all -> 0x0055 }
            java.util.List r4 = kotlin.sequences.SequencesKt.c3(r4)     // Catch:{ all -> 0x0055 }
        L_0x0049:
            if (r3 >= r2) goto L_0x0051
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0051:
            r0.unlock()
            return r4
        L_0x0055:
            r4 = move-exception
            goto L_0x0063
        L_0x0057:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0055 }
            r5.<init>(r4)     // Catch:{ all -> 0x0055 }
            throw r5     // Catch:{ all -> 0x0055 }
        L_0x0063:
            if (r3 >= r2) goto L_0x006b
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0063
        L_0x006b:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.g():java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0037, code lost:
        r8 = r8.W();
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object[] h() {
        /*
            r14 = this;
            r0 = 0
            java.util.List r1 = r14.g()
            int r2 = r1.size()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r2)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r2)
            java.util.Iterator r2 = r1.iterator()
        L_0x001c:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto L_0x00ba
            java.lang.Object r6 = r2.next()
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo r6 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfo) r6
            kotlin.coroutines.CoroutineContext r7 = r6.a()
            kotlinx.coroutines.CoroutineName$Key r8 = kotlinx.coroutines.CoroutineName.Y
            kotlin.coroutines.CoroutineContext$Element r8 = r7.e(r8)
            kotlinx.coroutines.CoroutineName r8 = (kotlinx.coroutines.CoroutineName) r8
            r9 = 0
            if (r8 == 0) goto L_0x0042
            java.lang.String r8 = r8.W()
            if (r8 == 0) goto L_0x0042
            java.lang.String r8 = r14.P(r8)
            goto L_0x0043
        L_0x0042:
            r8 = r9
        L_0x0043:
            kotlinx.coroutines.CoroutineDispatcher$Key r10 = kotlinx.coroutines.CoroutineDispatcher.X
            kotlin.coroutines.CoroutineContext$Element r10 = r7.e(r10)
            kotlinx.coroutines.CoroutineDispatcher r10 = (kotlinx.coroutines.CoroutineDispatcher) r10
            if (r10 == 0) goto L_0x0052
            java.lang.String r10 = r14.P(r10)
            goto L_0x0053
        L_0x0052:
            r10 = r9
        L_0x0053:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "\n                {\n                    \"name\": "
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ",\n                    \"id\": "
            r11.append(r8)
            kotlinx.coroutines.CoroutineId$Key r8 = kotlinx.coroutines.CoroutineId.Y
            kotlin.coroutines.CoroutineContext$Element r7 = r7.e(r8)
            kotlinx.coroutines.CoroutineId r7 = (kotlinx.coroutines.CoroutineId) r7
            if (r7 == 0) goto L_0x0077
            long r7 = r7.W()
            java.lang.Long r9 = java.lang.Long.valueOf(r7)
        L_0x0077:
            r11.append(r9)
            java.lang.String r7 = ",\n                    \"dispatcher\": "
            r11.append(r7)
            r11.append(r10)
            java.lang.String r7 = ",\n                    \"sequenceNumber\": "
            r11.append(r7)
            long r7 = r6.f()
            r11.append(r7)
            java.lang.String r7 = ",\n                    \"state\": \""
            r11.append(r7)
            java.lang.String r7 = r6.g()
            r11.append(r7)
            java.lang.String r7 = "\"\n                } \n                "
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            java.lang.String r7 = kotlin.text.StringsKt.p(r7)
            r5.add(r7)
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r6.d()
            r4.add(r7)
            java.lang.Thread r6 = r6.e()
            r3.add(r6)
            goto L_0x001c
        L_0x00ba:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r6 = 91
            r2.append(r6)
            r12 = 63
            r13 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            java.lang.String r5 = kotlin.collections.CollectionsKt.j3(r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r2.append(r5)
            r5 = 93
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            java.lang.Thread[] r5 = new java.lang.Thread[r0]
            java.lang.Object[] r3 = r3.toArray(r5)
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            if (r3 == 0) goto L_0x0112
            kotlin.coroutines.jvm.internal.CoroutineStackFrame[] r6 = new kotlin.coroutines.jvm.internal.CoroutineStackFrame[r0]
            java.lang.Object[] r4 = r4.toArray(r6)
            if (r4 == 0) goto L_0x010c
            kotlinx.coroutines.debug.internal.DebugCoroutineInfo[] r6 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfo[r0]
            java.lang.Object[] r1 = r1.toArray(r6)
            if (r1 == 0) goto L_0x0106
            r5 = 4
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r0] = r2
            r0 = 1
            r5[r0] = r3
            r0 = 2
            r5[r0] = r4
            r0 = 3
            r5[r0] = r1
            return r5
        L_0x0106:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x010c:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        L_0x0112:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.h():java.lang.Object[]");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> k() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = f29293h
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r4 = 0
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = f29286a     // Catch:{ all -> 0x0055 }
            boolean r5 = r4.z()     // Catch:{ all -> 0x0055 }
            if (r5 == 0) goto L_0x0057
            java.util.Set r4 = r4.q()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.x1(r4)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0055 }
            r5.<init>()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.K2(r4, r5)     // Catch:{ all -> 0x0055 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0055 }
            r5.<init>()     // Catch:{ all -> 0x0055 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.p1(r4, r5)     // Catch:{ all -> 0x0055 }
            java.util.List r4 = kotlin.sequences.SequencesKt.c3(r4)     // Catch:{ all -> 0x0055 }
        L_0x0049:
            if (r3 >= r2) goto L_0x0051
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0051:
            r0.unlock()
            return r4
        L_0x0055:
            r4 = move-exception
            goto L_0x0063
        L_0x0057:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0055 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0055 }
            r5.<init>(r4)     // Catch:{ all -> 0x0055 }
            throw r5     // Catch:{ all -> 0x0055 }
        L_0x0063:
            if (r3 >= r2) goto L_0x006b
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0063
        L_0x006b:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.k():java.util.List");
    }

    @NotNull
    public final List<StackTraceElement> l(@NotNull DebugCoroutineInfo debugCoroutineInfo, @NotNull List<StackTraceElement> list) {
        return n(debugCoroutineInfo.g(), debugCoroutineInfo.e(), list);
    }

    @NotNull
    public final String m(@NotNull DebugCoroutineInfo debugCoroutineInfo) {
        List<StackTraceElement> l2 = l(debugCoroutineInfo, debugCoroutineInfo.h());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement next : l2) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append(next.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(next.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = next.getFileName();
            sb.append(fileName != null ? P(fileName) : null);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(next.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(StringsKt.p(sb.toString()));
        }
        return '[' + CollectionsKt.j3(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + ']';
    }

    public final boolean u() {
        return f29295j;
    }

    public final boolean v() {
        return f29294i;
    }

    @NotNull
    public final String w(@NotNull Job job) {
        ReentrantReadWriteLock reentrantReadWriteLock = f29293h;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = f29286a;
            if (debugProbesImpl.z()) {
                Set<CoroutineOwner<?>> q = debugProbesImpl.q();
                ArrayList arrayList = new ArrayList();
                for (T next : q) {
                    if (((CoroutineOwner) next).s.g().e(Job.P2) != null) {
                        arrayList.add(next);
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.u(MapsKt.j(CollectionsKt.Y(arrayList, 10)), 16));
                for (Object next2 : arrayList) {
                    linkedHashMap.put(JobKt.B(((CoroutineOwner) next2).s.g()), ((CoroutineOwner) next2).X);
                }
                StringBuilder sb = new StringBuilder();
                f29286a.d(job, linkedHashMap, sb, "");
                String sb2 = sb.toString();
                Intrinsics.o(sb2, "StringBuilder().apply(builderAction).toString()");
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return sb2;
            }
            throw new IllegalStateException("Debug probes are not installed".toString());
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final void x() {
        ReentrantReadWriteLock reentrantReadWriteLock = f29293h;
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        int i2 = 0;
        int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
        for (int i3 = 0; i3 < readHoldCount; i3++) {
            readLock.unlock();
        }
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        try {
            installations++;
            if (installations > 1) {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            f29286a.M();
            if (AgentInstallationType.f29255a.a()) {
                while (i2 < readHoldCount) {
                    readLock.lock();
                    i2++;
                }
                writeLock.unlock();
                return;
            }
            Function1<Boolean, Unit> function1 = f29296k;
            if (function1 != null) {
                function1.f(Boolean.TRUE);
            }
            Unit unit = Unit.f28779a;
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
        } catch (Throwable th) {
            while (i2 < readHoldCount) {
                readLock.lock();
                i2++;
            }
            writeLock.unlock();
            throw th;
        }
    }

    public final boolean z() {
        return installations > 0;
    }
}
