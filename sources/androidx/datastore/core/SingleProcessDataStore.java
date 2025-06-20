package androidx.datastore.core;

import androidx.annotation.GuardedBy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 W*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0003XYZB\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012?\b\u0002\u0010\u0011\u001a9\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t0\b\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001a\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001e\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0013\u0010 \u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b \u0010!J\u0013\u0010\"\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b\"\u0010!J\u0013\u0010#\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0004\b#\u0010!J\u0013\u0010$\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b$\u0010!J\u0013\u0010%\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b%\u0010!JN\u0010)\u001a\u00028\u000021\u0010&\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t2\u0006\u0010(\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u000f*\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010,JF\u0010-\u001a\u00028\u000021\u0010&\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\tH@ø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001b\u00100\u001a\u00020\u000f2\u0006\u0010/\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b0\u00101R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u00102R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R \u0010>\u001a\b\u0012\u0004\u0012\u00028\u0000098\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002XD¢\u0006\u0006\n\u0004\b@\u0010AR\u001b\u0010G\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR&\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000I0H8\u0002X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u0012\u0004\bL\u0010MRR\u0010Q\u001a;\u00125\u00123\b\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t\u0018\u00010\b8\u0002@\u0002X\u000eø\u0001\u0000¢\u0006\u0006\n\u0004\bO\u0010PR \u0010V\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000S0R8\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010U\u0002\u0004\n\u0002\b\u0019¨\u0006["}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore;", "T", "Landroidx/datastore/core/DataStore;", "Lkotlin/Function0;", "Ljava/io/File;", "produceFile", "Landroidx/datastore/core/Serializer;", "serializer", "", "Lkotlin/Function2;", "Landroidx/datastore/core/InitializerApi;", "Lkotlin/ParameterName;", "name", "api", "Lkotlin/coroutines/Continuation;", "", "", "initTasksList", "Landroidx/datastore/core/CorruptionHandler;", "corruptionHandler", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/datastore/core/Serializer;Ljava/util/List;Landroidx/datastore/core/CorruptionHandler;Lkotlinx/coroutines/CoroutineScope;)V", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "read", "s", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Read;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "update", "t", "(Landroidx/datastore/core/SingleProcessDataStore$Message$Update;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "v", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "u", "y", "x", "transform", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "z", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "p", "(Ljava/io/File;)V", "a", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "newData", "A", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function0;", "b", "Landroidx/datastore/core/Serializer;", "c", "Landroidx/datastore/core/CorruptionHandler;", "d", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/Flow;", "e", "Lkotlinx/coroutines/flow/Flow;", "getData", "()Lkotlinx/coroutines/flow/Flow;", "data", "", "f", "Ljava/lang/String;", "SCRATCH_SUFFIX", "g", "Lkotlin/Lazy;", "r", "()Ljava/io/File;", "file", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/datastore/core/State;", "h", "Lkotlinx/coroutines/flow/MutableStateFlow;", "q", "()V", "downstreamFlow", "i", "Ljava/util/List;", "initTasks", "Landroidx/datastore/core/SimpleActor;", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "j", "Landroidx/datastore/core/SimpleActor;", "actor", "k", "Companion", "Message", "UncloseableOutputStream", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class SingleProcessDataStore<T> implements DataStore<T> {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final Companion f6911k = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    @GuardedBy("activeFilesLock")

    /* renamed from: l  reason: collision with root package name */
    public static final Set<String> f6912l = new LinkedHashSet();
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public static final Object f6913m = new Object();
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Function0<File> f6914a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Serializer<T> f6915b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final CorruptionHandler<T> f6916c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineScope f6917d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Flow<T> f6918e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f6919f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final Lazy f6920g;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final MutableStateFlow<State<T>> f6921h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> f6922i;
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final SimpleActor<Message<T>> f6923j;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00018\u0000X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Companion;", "", "<init>", "()V", "", "", "activeFiles", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "activeFilesLock", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final Set<String> a() {
            return SingleProcessDataStore.f6912l;
        }

        @NotNull
        public final Object b() {
            return SingleProcessDataStore.f6913m;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0002\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004R\u001c\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message;", "T", "", "<init>", "()V", "Landroidx/datastore/core/State;", "a", "()Landroidx/datastore/core/State;", "lastState", "Read", "Update", "Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    private static abstract class Message<T> {

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u00038\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Read;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "Landroidx/datastore/core/State;", "lastState", "<init>", "(Landroidx/datastore/core/State;)V", "a", "Landroidx/datastore/core/State;", "()Landroidx/datastore/core/State;", "datastore-core"}, k = 1, mv = {1, 5, 1})
        public static final class Read<T> extends Message<T> {
            @Nullable

            /* renamed from: a  reason: collision with root package name */
            private final State<T> f6924a;

            public Read(@Nullable State<T> state) {
                super((DefaultConstructorMarker) null);
                this.f6924a = state;
            }

            @Nullable
            public State<T> a() {
                return this.f6924a;
            }
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u00028\u00020\u0002Bc\u00121\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011RE\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0002¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00038\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00020\n8\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0002\u0018\u00010\f8\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0012\u0010\u001bR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u0019\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$Message$Update;", "T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "t", "Lkotlin/coroutines/Continuation;", "", "transform", "Lkotlinx/coroutines/CompletableDeferred;", "ack", "Landroidx/datastore/core/State;", "lastState", "Lkotlin/coroutines/CoroutineContext;", "callerContext", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CompletableDeferred;Landroidx/datastore/core/State;Lkotlin/coroutines/CoroutineContext;)V", "a", "Lkotlin/jvm/functions/Function2;", "d", "()Lkotlin/jvm/functions/Function2;", "b", "Lkotlinx/coroutines/CompletableDeferred;", "()Lkotlinx/coroutines/CompletableDeferred;", "c", "Landroidx/datastore/core/State;", "()Landroidx/datastore/core/State;", "Lkotlin/coroutines/CoroutineContext;", "()Lkotlin/coroutines/CoroutineContext;", "datastore-core"}, k = 1, mv = {1, 5, 1})
        public static final class Update<T> extends Message<T> {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final Function2<T, Continuation<? super T>, Object> f6925a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final CompletableDeferred<T> f6926b;
            @Nullable

            /* renamed from: c  reason: collision with root package name */
            private final State<T> f6927c;
            @NotNull

            /* renamed from: d  reason: collision with root package name */
            private final CoroutineContext f6928d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Update(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull CompletableDeferred<T> completableDeferred, @Nullable State<T> state, @NotNull CoroutineContext coroutineContext) {
                super((DefaultConstructorMarker) null);
                Intrinsics.p(function2, "transform");
                Intrinsics.p(completableDeferred, "ack");
                Intrinsics.p(coroutineContext, "callerContext");
                this.f6925a = function2;
                this.f6926b = completableDeferred;
                this.f6927c = state;
                this.f6928d = coroutineContext;
            }

            @Nullable
            public State<T> a() {
                return this.f6927c;
            }

            @NotNull
            public final CompletableDeferred<T> b() {
                return this.f6926b;
            }

            @NotNull
            public final CoroutineContext c() {
                return this.f6928d;
            }

            @NotNull
            public final Function2<T, Continuation<? super T>, Object> d() {
                return this.f6925a;
            }
        }

        private Message() {
        }

        @Nullable
        public abstract State<T> a();

        public /* synthetic */ Message(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0007\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/datastore/core/SingleProcessDataStore$UncloseableOutputStream;", "Ljava/io/OutputStream;", "Ljava/io/FileOutputStream;", "fileOutputStream", "<init>", "(Ljava/io/FileOutputStream;)V", "", "b", "", "write", "(I)V", "", "([B)V", "bytes", "off", "len", "([BII)V", "close", "()V", "flush", "s", "Ljava/io/FileOutputStream;", "()Ljava/io/FileOutputStream;", "datastore-core"}, k = 1, mv = {1, 5, 1})
    private static final class UncloseableOutputStream extends OutputStream {
        @NotNull
        private final FileOutputStream s;

        public UncloseableOutputStream(@NotNull FileOutputStream fileOutputStream) {
            Intrinsics.p(fileOutputStream, "fileOutputStream");
            this.s = fileOutputStream;
        }

        @NotNull
        public final FileOutputStream b() {
            return this.s;
        }

        public void close() {
        }

        public void flush() {
            this.s.flush();
        }

        public void write(int i2) {
            this.s.write(i2);
        }

        public void write(@NotNull byte[] bArr) {
            Intrinsics.p(bArr, "b");
            this.s.write(bArr);
        }

        public void write(@NotNull byte[] bArr, int i2, int i3) {
            Intrinsics.p(bArr, "bytes");
            this.s.write(bArr, i2, i3);
        }
    }

    public SingleProcessDataStore(@NotNull Function0<? extends File> function0, @NotNull Serializer<T> serializer, @NotNull List<? extends Function2<? super InitializerApi<T>, ? super Continuation<? super Unit>, ? extends Object>> list, @NotNull CorruptionHandler<T> corruptionHandler, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.p(function0, "produceFile");
        Intrinsics.p(serializer, "serializer");
        Intrinsics.p(list, "initTasksList");
        Intrinsics.p(corruptionHandler, "corruptionHandler");
        Intrinsics.p(coroutineScope, "scope");
        this.f6914a = function0;
        this.f6915b = serializer;
        this.f6916c = corruptionHandler;
        this.f6917d = coroutineScope;
        this.f6918e = FlowKt.I0(new SingleProcessDataStore$data$1(this, (Continuation<? super SingleProcessDataStore$data$1>) null));
        this.f6919f = ".tmp";
        this.f6920g = LazyKt.c(new SingleProcessDataStore$file$2(this));
        this.f6921h = StateFlowKt.a(UnInitialized.f6933a);
        this.f6922i = CollectionsKt.S5(list);
        this.f6923j = new SimpleActor<>(coroutineScope, new SingleProcessDataStore$actor$1(this), SingleProcessDataStore$actor$2.X, new SingleProcessDataStore$actor$3(this, (Continuation<? super SingleProcessDataStore$actor$3>) null));
    }

    private final void p(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(Intrinsics.C("Unable to create parent directories of ", file));
            }
        }
    }

    private static /* synthetic */ void q() {
    }

    /* access modifiers changed from: private */
    public final File r() {
        return (File) this.f6920g.getValue();
    }

    /* access modifiers changed from: private */
    public final Object s(Message.Read<T> read, Continuation<? super Unit> continuation) {
        State<T> value = this.f6921h.getValue();
        if (!(value instanceof Data)) {
            if (value instanceof ReadException) {
                if (value == read.a()) {
                    Object w = w(continuation);
                    return w == IntrinsicsKt.l() ? w : Unit.f28779a;
                }
            } else if (Intrinsics.g(value, UnInitialized.f6933a)) {
                Object w2 = w(continuation);
                return w2 == IntrinsicsKt.l() ? w2 : Unit.f28779a;
            } else if (value instanceof Final) {
                throw new IllegalStateException("Can't read in final state.".toString());
            }
        }
        return Unit.f28779a;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(androidx.datastore.core.SingleProcessDataStore.Message.Update<T> r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = (androidx.datastore.core.SingleProcessDataStore$handleUpdate$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$handleUpdate$1 r0 = new androidx.datastore.core.SingleProcessDataStore$handleUpdate$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0051
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r9 = r0.Z
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
        L_0x002f:
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00be
        L_0x0034:
            r10 = move-exception
            goto L_0x00db
        L_0x0037:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003f:
            java.lang.Object r9 = r0.Y2
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            java.lang.Object r2 = r0.X2
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            java.lang.Object r4 = r0.Z
            androidx.datastore.core.SingleProcessDataStore$Message$Update r4 = (androidx.datastore.core.SingleProcessDataStore.Message.Update) r4
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0034 }
            r10 = r9
            r9 = r4
            goto L_0x00a6
        L_0x0051:
            java.lang.Object r9 = r0.Z
            kotlinx.coroutines.CompletableDeferred r9 = (kotlinx.coroutines.CompletableDeferred) r9
            goto L_0x002f
        L_0x0056:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.CompletableDeferred r10 = r9.b()
            kotlin.Result$Companion r2 = kotlin.Result.X     // Catch:{ all -> 0x0082 }
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r2 = r8.f6921h     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0082 }
            androidx.datastore.core.State r2 = (androidx.datastore.core.State) r2     // Catch:{ all -> 0x0082 }
            boolean r6 = r2 instanceof androidx.datastore.core.Data     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x0087
            kotlin.jvm.functions.Function2 r2 = r9.d()     // Catch:{ all -> 0x0082 }
            kotlin.coroutines.CoroutineContext r9 = r9.c()     // Catch:{ all -> 0x0082 }
            r0.Z = r10     // Catch:{ all -> 0x0082 }
            r0.b3 = r5     // Catch:{ all -> 0x0082 }
            java.lang.Object r9 = r8.z(r2, r9, r0)     // Catch:{ all -> 0x0082 }
            if (r9 != r1) goto L_0x007e
            return r1
        L_0x007e:
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00be
        L_0x0082:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
            goto L_0x00db
        L_0x0087:
            boolean r6 = r2 instanceof androidx.datastore.core.ReadException     // Catch:{ all -> 0x0082 }
            if (r6 == 0) goto L_0x008c
            goto L_0x008e
        L_0x008c:
            boolean r5 = r2 instanceof androidx.datastore.core.UnInitialized     // Catch:{ all -> 0x0082 }
        L_0x008e:
            if (r5 == 0) goto L_0x00ca
            androidx.datastore.core.State r5 = r9.a()     // Catch:{ all -> 0x0082 }
            if (r2 != r5) goto L_0x00c3
            r0.Z = r9     // Catch:{ all -> 0x0082 }
            r0.X2 = r8     // Catch:{ all -> 0x0082 }
            r0.Y2 = r10     // Catch:{ all -> 0x0082 }
            r0.b3 = r4     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r8.v(r0)     // Catch:{ all -> 0x0082 }
            if (r2 != r1) goto L_0x00a5
            return r1
        L_0x00a5:
            r2 = r8
        L_0x00a6:
            kotlin.jvm.functions.Function2 r4 = r9.d()     // Catch:{ all -> 0x0082 }
            kotlin.coroutines.CoroutineContext r9 = r9.c()     // Catch:{ all -> 0x0082 }
            r0.Z = r10     // Catch:{ all -> 0x0082 }
            r5 = 0
            r0.X2 = r5     // Catch:{ all -> 0x0082 }
            r0.Y2 = r5     // Catch:{ all -> 0x0082 }
            r0.b3 = r3     // Catch:{ all -> 0x0082 }
            java.lang.Object r9 = r2.z(r4, r9, r0)     // Catch:{ all -> 0x0082 }
            if (r9 != r1) goto L_0x007e
            return r1
        L_0x00be:
            java.lang.Object r10 = kotlin.Result.b(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00e5
        L_0x00c3:
            androidx.datastore.core.ReadException r2 = (androidx.datastore.core.ReadException) r2     // Catch:{ all -> 0x0082 }
            java.lang.Throwable r9 = r2.a()     // Catch:{ all -> 0x0082 }
            throw r9     // Catch:{ all -> 0x0082 }
        L_0x00ca:
            boolean r9 = r2 instanceof androidx.datastore.core.Final     // Catch:{ all -> 0x0082 }
            if (r9 == 0) goto L_0x00d5
            androidx.datastore.core.Final r2 = (androidx.datastore.core.Final) r2     // Catch:{ all -> 0x0082 }
            java.lang.Throwable r9 = r2.a()     // Catch:{ all -> 0x0082 }
            throw r9     // Catch:{ all -> 0x0082 }
        L_0x00d5:
            kotlin.NoWhenBranchMatchedException r9 = new kotlin.NoWhenBranchMatchedException     // Catch:{ all -> 0x0082 }
            r9.<init>()     // Catch:{ all -> 0x0082 }
            throw r9     // Catch:{ all -> 0x0082 }
        L_0x00db:
            kotlin.Result$Companion r0 = kotlin.Result.X
            java.lang.Object r10 = kotlin.ResultKt.a(r10)
            java.lang.Object r10 = kotlin.Result.b(r10)
        L_0x00e5:
            kotlinx.coroutines.CompletableDeferredKt.d(r9, r10)
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.t(androidx.datastore.core.SingleProcessDataStore$Message$Update, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0112 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object u(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$1) r0
            int r1 = r0.e3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInit$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$1
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.c3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.e3
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x007b
            if (r2 == r6) goto L_0x0067
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r1 = r0.Z2
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r2 = r0.Y2
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r3 = r0.X2
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.n(r14)
            goto L_0x0115
        L_0x0042:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x004a:
            java.lang.Object r2 = r0.b3
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r8 = r0.a3
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r8 = (androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1) r8
            java.lang.Object r9 = r0.Z2
            kotlin.jvm.internal.Ref$BooleanRef r9 = (kotlin.jvm.internal.Ref.BooleanRef) r9
            java.lang.Object r10 = r0.Y2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.X2
            kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
            java.lang.Object r12 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r12 = (androidx.datastore.core.SingleProcessDataStore) r12
            kotlin.ResultKt.n(r14)
            goto L_0x00d6
        L_0x0067:
            java.lang.Object r2 = r0.Z2
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r8 = r0.Y2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r0.X2
            kotlinx.coroutines.sync.Mutex r9 = (kotlinx.coroutines.sync.Mutex) r9
            java.lang.Object r10 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r10 = (androidx.datastore.core.SingleProcessDataStore) r10
            kotlin.ResultKt.n(r14)
            goto L_0x00b8
        L_0x007b:
            kotlin.ResultKt.n(r14)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.f6921h
            java.lang.Object r14 = r14.getValue()
            androidx.datastore.core.UnInitialized r2 = androidx.datastore.core.UnInitialized.f6933a
            boolean r14 = kotlin.jvm.internal.Intrinsics.g(r14, r2)
            if (r14 != 0) goto L_0x0099
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r14 = r13.f6921h
            java.lang.Object r14 = r14.getValue()
            boolean r14 = r14 instanceof androidx.datastore.core.ReadException
            if (r14 == 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r14 = 0
            goto L_0x009a
        L_0x0099:
            r14 = 1
        L_0x009a:
            if (r14 == 0) goto L_0x0134
            kotlinx.coroutines.sync.Mutex r9 = kotlinx.coroutines.sync.MutexKt.b(r5, r6, r7)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            r0.Z = r13
            r0.X2 = r9
            r0.Y2 = r2
            r0.Z2 = r2
            r0.e3 = r6
            java.lang.Object r14 = r13.y(r0)
            if (r14 != r1) goto L_0x00b6
            return r1
        L_0x00b6:
            r10 = r13
            r8 = r2
        L_0x00b8:
            r2.s = r14
            kotlin.jvm.internal.Ref$BooleanRef r14 = new kotlin.jvm.internal.Ref$BooleanRef
            r14.<init>()
            androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1 r2 = new androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1
            r2.<init>(r9, r14, r8, r10)
            java.util.List<? extends kotlin.jvm.functions.Function2<? super androidx.datastore.core.InitializerApi<T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>> r11 = r10.f6922i
            if (r11 != 0) goto L_0x00cc
            r2 = r14
            r14 = r0
            r0 = r10
            goto L_0x00fc
        L_0x00cc:
            java.util.Iterator r11 = r11.iterator()
            r12 = r10
            r10 = r8
            r8 = r2
            r2 = r11
            r11 = r9
            r9 = r14
        L_0x00d6:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00f7
            java.lang.Object r14 = r2.next()
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r0.Z = r12
            r0.X2 = r11
            r0.Y2 = r10
            r0.Z2 = r9
            r0.a3 = r8
            r0.b3 = r2
            r0.e3 = r4
            java.lang.Object r14 = r14.d0(r8, r0)
            if (r14 != r1) goto L_0x00d6
            return r1
        L_0x00f7:
            r14 = r0
            r2 = r9
            r8 = r10
            r9 = r11
            r0 = r12
        L_0x00fc:
            r0.f6922i = r7
            r14.Z = r0
            r14.X2 = r8
            r14.Y2 = r2
            r14.Z2 = r9
            r14.a3 = r7
            r14.b3 = r7
            r14.e3 = r3
            java.lang.Object r14 = r9.c(r7, r14)
            if (r14 != r1) goto L_0x0113
            return r1
        L_0x0113:
            r3 = r8
            r1 = r9
        L_0x0115:
            r2.s = r6     // Catch:{ all -> 0x012f }
            kotlin.Unit r14 = kotlin.Unit.f28779a     // Catch:{ all -> 0x012f }
            r1.d(r7)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.f6921h
            androidx.datastore.core.Data r1 = new androidx.datastore.core.Data
            T r2 = r3.s
            if (r2 == 0) goto L_0x0128
            int r5 = r2.hashCode()
        L_0x0128:
            r1.<init>(r2, r5)
            r0.setValue(r1)
            return r14
        L_0x012f:
            r14 = move-exception
            r1.d(r7)
            throw r14
        L_0x0134:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r14.<init>(r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.u(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object v(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateAndThrowFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.n(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0045
        L_0x002d:
            r5 = move-exception
            goto L_0x004a
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.n(r5)
            r0.Z = r4     // Catch:{ all -> 0x0048 }
            r0.Z2 = r3     // Catch:{ all -> 0x0048 }
            java.lang.Object r5 = r4.u(r0)     // Catch:{ all -> 0x0048 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            return r5
        L_0x0048:
            r5 = move-exception
            r0 = r4
        L_0x004a:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.f6921h
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.v(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object w(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readAndInitOrPropagateFailure$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.n(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0051
        L_0x002d:
            r5 = move-exception
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.n(r5)
            r0.Z = r4     // Catch:{ all -> 0x0045 }
            r0.Z2 = r3     // Catch:{ all -> 0x0045 }
            java.lang.Object r5 = r4.u(r0)     // Catch:{ all -> 0x0045 }
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0045:
            r5 = move-exception
            r0 = r4
        L_0x0047:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r0 = r0.f6921h
            androidx.datastore.core.ReadException r1 = new androidx.datastore.core.ReadException
            r1.<init>(r5)
            r0.setValue(r1)
        L_0x0051:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.w(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        r6 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0068, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        kotlin.io.CloseableKt.a(r2, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006c, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x007f, code lost:
        return r0.f6915b.n();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0080, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:23:0x005f, B:29:0x0067] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object x(kotlin.coroutines.Continuation<? super T> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.core.SingleProcessDataStore$readData$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readData$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readData$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.Y2
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.X2
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.n(r6)     // Catch:{ all -> 0x0035 }
            goto L_0x005f
        L_0x0035:
            r6 = move-exception
            goto L_0x0067
        L_0x0037:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x003f:
            kotlin.ResultKt.n(r6)
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x006d }
            java.io.File r6 = r5.r()     // Catch:{ FileNotFoundException -> 0x006d }
            r2.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006d }
            androidx.datastore.core.Serializer<T> r6 = r5.f6915b     // Catch:{ all -> 0x0065 }
            r0.Z = r5     // Catch:{ all -> 0x0065 }
            r0.X2 = r2     // Catch:{ all -> 0x0065 }
            r4 = 0
            r0.Y2 = r4     // Catch:{ all -> 0x0065 }
            r0.b3 = r3     // Catch:{ all -> 0x0065 }
            java.lang.Object r6 = r6.p(r2, r0)     // Catch:{ all -> 0x0065 }
            if (r6 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r0 = r5
            r1 = r4
        L_0x005f:
            kotlin.io.CloseableKt.a(r2, r1)     // Catch:{ FileNotFoundException -> 0x0063 }
            return r6
        L_0x0063:
            r6 = move-exception
            goto L_0x006f
        L_0x0065:
            r6 = move-exception
            r0 = r5
        L_0x0067:
            throw r6     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r1 = move-exception
            kotlin.io.CloseableKt.a(r2, r6)     // Catch:{ FileNotFoundException -> 0x0063 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0063 }
        L_0x006d:
            r6 = move-exception
            r0 = r5
        L_0x006f:
            java.io.File r1 = r0.r()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0080
            androidx.datastore.core.Serializer<T> r6 = r0.f6915b
            java.lang.Object r6 = r6.n()
            return r6
        L_0x0080:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = (androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1 r0 = new androidx.datastore.core.SingleProcessDataStore$readDataOrHandleCorruption$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r5) goto L_0x004b
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            java.lang.Object r1 = r0.X2
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.CorruptionException r0 = (androidx.datastore.core.CorruptionException) r0
            kotlin.ResultKt.n(r8)     // Catch:{ IOException -> 0x0035 }
            goto L_0x0087
        L_0x0035:
            r8 = move-exception
            goto L_0x008a
        L_0x0037:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003f:
            java.lang.Object r2 = r0.X2
            androidx.datastore.core.CorruptionException r2 = (androidx.datastore.core.CorruptionException) r2
            java.lang.Object r4 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r4 = (androidx.datastore.core.SingleProcessDataStore) r4
            kotlin.ResultKt.n(r8)
            goto L_0x0079
        L_0x004b:
            java.lang.Object r2 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.ResultKt.n(r8)     // Catch:{ CorruptionException -> 0x0053 }
            goto L_0x0063
        L_0x0053:
            r8 = move-exception
            goto L_0x0066
        L_0x0055:
            kotlin.ResultKt.n(r8)
            r0.Z = r7     // Catch:{ CorruptionException -> 0x0064 }
            r0.a3 = r5     // Catch:{ CorruptionException -> 0x0064 }
            java.lang.Object r8 = r7.x(r0)     // Catch:{ CorruptionException -> 0x0064 }
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x0063:
            return r8
        L_0x0064:
            r8 = move-exception
            r2 = r7
        L_0x0066:
            androidx.datastore.core.CorruptionHandler<T> r5 = r2.f6916c
            r0.Z = r2
            r0.X2 = r8
            r0.a3 = r4
            java.lang.Object r4 = r5.a(r8, r0)
            if (r4 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r6 = r2
            r2 = r8
            r8 = r4
            r4 = r6
        L_0x0079:
            r0.Z = r2     // Catch:{ IOException -> 0x0088 }
            r0.X2 = r8     // Catch:{ IOException -> 0x0088 }
            r0.a3 = r3     // Catch:{ IOException -> 0x0088 }
            java.lang.Object r0 = r4.A(r8, r0)     // Catch:{ IOException -> 0x0088 }
            if (r0 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r1 = r8
        L_0x0087:
            return r1
        L_0x0088:
            r8 = move-exception
            r0 = r2
        L_0x008a:
            kotlin.ExceptionsKt.a(r0, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.y(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object z(kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r8, kotlin.coroutines.CoroutineContext r9, kotlin.coroutines.Continuation<? super T> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = (androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1) r0
            int r1 = r0.b3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1 r0 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.Z2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.b3
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r8 = r0.X2
            java.lang.Object r9 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r9 = (androidx.datastore.core.SingleProcessDataStore) r9
            kotlin.ResultKt.n(r10)
            goto L_0x008e
        L_0x0033:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003b:
            java.lang.Object r8 = r0.Y2
            java.lang.Object r9 = r0.X2
            androidx.datastore.core.Data r9 = (androidx.datastore.core.Data) r9
            java.lang.Object r2 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r2 = (androidx.datastore.core.SingleProcessDataStore) r2
            kotlin.ResultKt.n(r10)
            goto L_0x0073
        L_0x0049:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r10 = r7.f6921h
            java.lang.Object r10 = r10.getValue()
            androidx.datastore.core.Data r10 = (androidx.datastore.core.Data) r10
            r10.a()
            java.lang.Object r2 = r10.c()
            androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1 r6 = new androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1
            r6.<init>(r8, r2, r3)
            r0.Z = r7
            r0.X2 = r10
            r0.Y2 = r2
            r0.b3 = r5
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.h(r9, r6, r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r9 = r10
            r10 = r8
            r8 = r2
            r2 = r7
        L_0x0073:
            r9.a()
            boolean r9 = kotlin.jvm.internal.Intrinsics.g(r8, r10)
            if (r9 == 0) goto L_0x007d
            goto L_0x00a0
        L_0x007d:
            r0.Z = r2
            r0.X2 = r10
            r0.Y2 = r3
            r0.b3 = r4
            java.lang.Object r8 = r2.A(r10, r0)
            if (r8 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r8 = r10
            r9 = r2
        L_0x008e:
            kotlinx.coroutines.flow.MutableStateFlow<androidx.datastore.core.State<T>> r9 = r9.f6921h
            androidx.datastore.core.Data r10 = new androidx.datastore.core.Data
            if (r8 == 0) goto L_0x0099
            int r0 = r8.hashCode()
            goto L_0x009a
        L_0x0099:
            r0 = 0
        L_0x009a:
            r10.<init>(r8, r0)
            r9.setValue(r10)
        L_0x00a0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.z(kotlin.jvm.functions.Function2, kotlin.coroutines.CoroutineContext, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bc, code lost:
        r8 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00bd, code lost:
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c2, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        kotlin.io.CloseableKt.a(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c6, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        r9.delete();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:25:0x0092, B:35:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009f A[Catch:{ all -> 0x00c2, IOException -> 0x00bc }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a0 A[Catch:{ all -> 0x00c2, IOException -> 0x00bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object A(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof androidx.datastore.core.SingleProcessDataStore$writeData$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = (androidx.datastore.core.SingleProcessDataStore$writeData$1) r0
            int r1 = r0.d3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d3 = r1
            goto L_0x0018
        L_0x0013:
            androidx.datastore.core.SingleProcessDataStore$writeData$1 r0 = new androidx.datastore.core.SingleProcessDataStore$writeData$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.b3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.d3
            r3 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 != r3) goto L_0x0040
            java.lang.Object r8 = r0.a3
            java.io.FileOutputStream r8 = (java.io.FileOutputStream) r8
            java.lang.Object r1 = r0.Z2
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.Object r2 = r0.Y2
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r3 = r0.X2
            java.io.File r3 = (java.io.File) r3
            java.lang.Object r0 = r0.Z
            androidx.datastore.core.SingleProcessDataStore r0 = (androidx.datastore.core.SingleProcessDataStore) r0
            kotlin.ResultKt.n(r9)     // Catch:{ all -> 0x003d }
            goto L_0x0089
        L_0x003d:
            r8 = move-exception
            goto L_0x00c1
        L_0x0040:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0048:
            kotlin.ResultKt.n(r9)
            java.io.File r9 = r7.r()
            r7.p(r9)
            java.io.File r9 = new java.io.File
            java.io.File r2 = r7.r()
            java.lang.String r2 = r2.getAbsolutePath()
            java.lang.String r4 = r7.f6919f
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.C(r2, r4)
            r9.<init>(r2)
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c7 }
            r2.<init>(r9)     // Catch:{ IOException -> 0x00c7 }
            androidx.datastore.core.Serializer<T> r4 = r7.f6915b     // Catch:{ all -> 0x00bf }
            androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream r5 = new androidx.datastore.core.SingleProcessDataStore$UncloseableOutputStream     // Catch:{ all -> 0x00bf }
            r5.<init>(r2)     // Catch:{ all -> 0x00bf }
            r0.Z = r7     // Catch:{ all -> 0x00bf }
            r0.X2 = r9     // Catch:{ all -> 0x00bf }
            r0.Y2 = r2     // Catch:{ all -> 0x00bf }
            r6 = 0
            r0.Z2 = r6     // Catch:{ all -> 0x00bf }
            r0.a3 = r2     // Catch:{ all -> 0x00bf }
            r0.d3 = r3     // Catch:{ all -> 0x00bf }
            java.lang.Object r8 = r4.o(r8, r5, r0)     // Catch:{ all -> 0x00bf }
            if (r8 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r0 = r7
            r3 = r9
            r8 = r2
            r1 = r6
        L_0x0089:
            java.io.FileDescriptor r8 = r8.getFD()     // Catch:{ all -> 0x003d }
            r8.sync()     // Catch:{ all -> 0x003d }
            kotlin.Unit r8 = kotlin.Unit.f28779a     // Catch:{ all -> 0x003d }
            kotlin.io.CloseableKt.a(r2, r1)     // Catch:{ IOException -> 0x00bc }
            java.io.File r9 = r0.r()     // Catch:{ IOException -> 0x00bc }
            boolean r9 = r3.renameTo(r9)     // Catch:{ IOException -> 0x00bc }
            if (r9 == 0) goto L_0x00a0
            return r8
        L_0x00a0:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00bc }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bc }
            r9.<init>()     // Catch:{ IOException -> 0x00bc }
            java.lang.String r0 = "Unable to rename "
            r9.append(r0)     // Catch:{ IOException -> 0x00bc }
            r9.append(r3)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r0 = ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file."
            r9.append(r0)     // Catch:{ IOException -> 0x00bc }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x00bc }
            r8.<init>(r9)     // Catch:{ IOException -> 0x00bc }
            throw r8     // Catch:{ IOException -> 0x00bc }
        L_0x00bc:
            r8 = move-exception
            r9 = r3
            goto L_0x00c8
        L_0x00bf:
            r8 = move-exception
            r3 = r9
        L_0x00c1:
            throw r8     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            r9 = move-exception
            kotlin.io.CloseableKt.a(r2, r8)     // Catch:{ IOException -> 0x00bc }
            throw r9     // Catch:{ IOException -> 0x00bc }
        L_0x00c7:
            r8 = move-exception
        L_0x00c8:
            boolean r0 = r9.exists()
            if (r0 == 0) goto L_0x00d1
            r9.delete()
        L_0x00d1:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.A(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public Object a(@NotNull Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, @NotNull Continuation<? super T> continuation) {
        CompletableDeferred c2 = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        this.f6923j.e(new Message.Update(function2, c2, this.f6921h.getValue(), continuation.g()));
        return c2.J(continuation);
    }

    @NotNull
    public Flow<T> getData() {
        return this.f6918e;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SingleProcessDataStore(kotlin.jvm.functions.Function0 r7, androidx.datastore.core.Serializer r8, java.util.List r9, androidx.datastore.core.CorruptionHandler r10, kotlinx.coroutines.CoroutineScope r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 4
            if (r13 == 0) goto L_0x0008
            java.util.List r9 = kotlin.collections.CollectionsKt.E()
        L_0x0008:
            r3 = r9
            r9 = r12 & 8
            if (r9 == 0) goto L_0x0012
            androidx.datastore.core.handlers.NoOpCorruptionHandler r10 = new androidx.datastore.core.handlers.NoOpCorruptionHandler
            r10.<init>()
        L_0x0012:
            r4 = r10
            r9 = r12 & 16
            if (r9 == 0) goto L_0x002b
            kotlinx.coroutines.Dispatchers r9 = kotlinx.coroutines.Dispatchers.f29186a
            kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.c()
            r10 = 1
            r11 = 0
            kotlinx.coroutines.CompletableJob r10 = kotlinx.coroutines.SupervisorKt.c(r11, r10, r11)
            kotlin.coroutines.CoroutineContext r9 = r9.v(r10)
            kotlinx.coroutines.CoroutineScope r11 = kotlinx.coroutines.CoroutineScopeKt.a(r9)
        L_0x002b:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.SingleProcessDataStore.<init>(kotlin.jvm.functions.Function0, androidx.datastore.core.Serializer, java.util.List, androidx.datastore.core.CorruptionHandler, kotlinx.coroutines.CoroutineScope, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
