package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010 \n\u0002\b\u0005\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006:\u0001xB\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ9\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001e2\u0010\u0010\u001f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010$\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J/\u0010.\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0013H\u0002¢\u0006\u0004\b0\u0010\u0015J\u0019\u00102\u001a\u0004\u0018\u00010\u001a2\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00104\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u0003H\u0002¢\u0006\u0004\b4\u00105J\u0019\u0010\u0001\u001a\u0004\u0018\u00010\u001a2\u0006\u00106\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0001\u00107J\u001b\u00108\u001a\u00020\u00132\u0006\u00101\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b8\u00109J3\u0010<\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001e2\u0014\u0010;\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001eH\u0002¢\u0006\u0004\b<\u0010=J!\u0010A\u001a\u00020@2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H@ø\u0001\u0000¢\u0006\u0004\bA\u0010BJ\u0017\u0010C\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\bC\u0010\u0011J\u001b\u0010D\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\bD\u0010%J\u000f\u0010E\u001a\u00020\u0016H\u0000¢\u0006\u0004\bE\u0010FJ%\u0010H\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010:0\u001e2\u0006\u0010G\u001a\u00020\u0016H\u0000¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0003H\u0014¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001e2\u0006\u0010L\u001a\u00020\u0007H\u0014¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0013H\u0016¢\u0006\u0004\bO\u0010\u0015J-\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000S2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\bT\u0010UR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010JR\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010JR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\bX\u0010YR \u0010\\\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010MR\u0016\u0010`\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010MR\u0016\u0010b\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\ba\u0010JR\u0016\u0010d\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bc\u0010JR\u0014\u0010f\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\be\u0010FR\u0014\u0010i\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0014\u0010k\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\bj\u0010hR\u0014\u0010m\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010FR\u0014\u0010o\u001a\u00020\u00168BX\u0004¢\u0006\u0006\u001a\u0004\bn\u0010FR\u001a\u0010s\u001a\u00028\u00008DX\u0004¢\u0006\f\u0012\u0004\br\u0010\u0015\u001a\u0004\bp\u0010qR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00028\u00000t8VX\u0004¢\u0006\u0006\u001a\u0004\bu\u0010v\u0002\u0004\n\u0002\b\u0019¨\u0006y"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "replay", "bufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "<init>", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "value", "", "Y", "(Ljava/lang/Object;)Z", "Z", "", "K", "()V", "", "newHead", "H", "(J)V", "", "item", "N", "(Ljava/lang/Object;)V", "", "curBuffer", "curSize", "newSize", "X", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "M", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "emitter", "E", "(Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;)V", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "c0", "(JJJJ)V", "F", "slot", "b0", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)Ljava/lang/Object;", "a0", "(Lkotlinx/coroutines/flow/SharedFlowSlot;)J", "index", "(J)Ljava/lang/Object;", "D", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "resumesIn", "O", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "l", "h", "e0", "()J", "oldIndex", "d0", "(J)[Lkotlin/coroutines/Continuation;", "I", "()Lkotlinx/coroutines/flow/SharedFlowSlot;", "size", "J", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "i", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/flow/Flow;", "c", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "X2", "Y2", "Z2", "Lkotlinx/coroutines/channels/BufferOverflow;", "a3", "[Ljava/lang/Object;", "buffer", "b3", "replayIndex", "c3", "minCollectorIndex", "d3", "bufferSize", "e3", "queueSize", "Q", "head", "V", "()I", "replaySize", "W", "totalSize", "P", "bufferEndIndex", "U", "queueEndIndex", "R", "()Ljava/lang/Object;", "S", "lastReplayedLocked", "", "b", "()Ljava/util/List;", "replayCache", "Emitter", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class SharedFlowImpl<T> extends AbstractSharedFlow<SharedFlowSlot> implements MutableSharedFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private final int X2;
    /* access modifiers changed from: private */
    public final int Y2;
    @NotNull
    private final BufferOverflow Z2;
    @Nullable
    private Object[] a3;
    private long b3;
    private long c3;
    private int d3;
    /* access modifiers changed from: private */
    public int e3;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B3\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "flow", "", "index", "", "value", "Lkotlin/coroutines/Continuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "m", "()V", "s", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "X", "J", "Y", "Ljava/lang/Object;", "Z", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Emitter implements DisposableHandle {
        @JvmField
        public long X;
        @Nullable
        @JvmField
        public final Object Y;
        @NotNull
        @JvmField
        public final Continuation<Unit> Z;
        @NotNull
        @JvmField
        public final SharedFlowImpl<?> s;

        public Emitter(@NotNull SharedFlowImpl<?> sharedFlowImpl, long j2, @Nullable Object obj, @NotNull Continuation<? super Unit> continuation) {
            this.s = sharedFlowImpl;
            this.X = j2;
            this.Y = obj;
            this.Z = continuation;
        }

        public void m() {
            this.s.E(this);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29305a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f29305a = iArr;
        }
    }

    public SharedFlowImpl(int i2, int i3, @NotNull BufferOverflow bufferOverflow) {
        this.X2 = i2;
        this.Y2 = i3;
        this.Z2 = bufferOverflow;
    }

    /* access modifiers changed from: private */
    public final Object D(SharedFlowSlot sharedFlowSlot, Continuation<? super Unit> continuation) {
        Unit unit;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        synchronized (this) {
            try {
                if (a0(sharedFlowSlot) < 0) {
                    sharedFlowSlot.f29308b = cancellableContinuationImpl;
                } else {
                    Result.Companion companion = Result.X;
                    cancellableContinuationImpl.w(Result.b(Unit.f28779a));
                }
                unit = Unit.f28779a;
            } catch (Throwable th) {
                throw th;
            }
        }
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : unit;
    }

    /* access modifiers changed from: private */
    public final void E(Emitter emitter) {
        synchronized (this) {
            if (emitter.X >= Q()) {
                Object[] objArr = this.a3;
                Intrinsics.m(objArr);
                if (SharedFlowKt.f(objArr, emitter.X) == emitter) {
                    SharedFlowKt.h(objArr, emitter.X, SharedFlowKt.f29306a);
                    F();
                    Unit unit = Unit.f28779a;
                }
            }
        }
    }

    private final void F() {
        if (this.Y2 != 0 || this.e3 > 1) {
            Object[] objArr = this.a3;
            Intrinsics.m(objArr);
            while (this.e3 > 0 && SharedFlowKt.f(objArr, (Q() + ((long) W())) - 1) == SharedFlowKt.f29306a) {
                this.e3--;
                SharedFlowKt.h(objArr, Q() + ((long) W()), (Object) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: kotlinx.coroutines.flow.SharedFlowSlot} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b1 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c6 A[Catch:{ all -> 0x00c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object G(kotlinx.coroutines.flow.SharedFlowImpl r8, kotlinx.coroutines.flow.FlowCollector r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.SharedFlowImpl$collect$1) r0
            int r1 = r0.c3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.SharedFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.SharedFlowImpl$collect$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.a3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.c3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0076
            if (r2 == r5) goto L_0x005f
            if (r2 == r4) goto L_0x004a
            if (r2 != r3) goto L_0x0042
            java.lang.Object r8 = r0.Z2
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.Y2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.Z
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
        L_0x003b:
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x003f }
            goto L_0x005b
        L_0x003f:
            r8 = move-exception
            goto L_0x00dc
        L_0x0042:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004a:
            java.lang.Object r8 = r0.Z2
            kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
            java.lang.Object r9 = r0.Y2
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r2 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r5 = r0.Z
            kotlinx.coroutines.flow.SharedFlowImpl r5 = (kotlinx.coroutines.flow.SharedFlowImpl) r5
            goto L_0x003b
        L_0x005b:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L_0x00a9
        L_0x005f:
            java.lang.Object r8 = r0.Y2
            r9 = r8
            kotlinx.coroutines.flow.SharedFlowSlot r9 = (kotlinx.coroutines.flow.SharedFlowSlot) r9
            java.lang.Object r8 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.flow.SharedFlowImpl r2 = (kotlinx.coroutines.flow.SharedFlowImpl) r2
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0072 }
            r10 = r8
            r8 = r2
            goto L_0x009d
        L_0x0072:
            r8 = move-exception
            r5 = r2
            goto L_0x00dc
        L_0x0076:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r10 = r8.f()
            kotlinx.coroutines.flow.SharedFlowSlot r10 = (kotlinx.coroutines.flow.SharedFlowSlot) r10
            boolean r2 = r9 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0095 }
            if (r2 == 0) goto L_0x009a
            r2 = r9
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x0095 }
            r0.Z = r8     // Catch:{ all -> 0x0095 }
            r0.X2 = r9     // Catch:{ all -> 0x0095 }
            r0.Y2 = r10     // Catch:{ all -> 0x0095 }
            r0.c3 = r5     // Catch:{ all -> 0x0095 }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x0095 }
            if (r2 != r1) goto L_0x009a
            return r1
        L_0x0095:
            r9 = move-exception
            r5 = r8
            r8 = r9
            r9 = r10
            goto L_0x00dc
        L_0x009a:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x009d:
            kotlin.coroutines.CoroutineContext r2 = r0.g()     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.P2     // Catch:{ all -> 0x00c2 }
            kotlin.coroutines.CoroutineContext$Element r2 = r2.e(r5)     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2     // Catch:{ all -> 0x00c2 }
        L_0x00a9:
            java.lang.Object r5 = r8.b0(r9)     // Catch:{ all -> 0x00c2 }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.flow.SharedFlowKt.f29306a     // Catch:{ all -> 0x00c2 }
            if (r5 != r6) goto L_0x00c6
            r0.Z = r8     // Catch:{ all -> 0x00c2 }
            r0.X2 = r10     // Catch:{ all -> 0x00c2 }
            r0.Y2 = r9     // Catch:{ all -> 0x00c2 }
            r0.Z2 = r2     // Catch:{ all -> 0x00c2 }
            r0.c3 = r4     // Catch:{ all -> 0x00c2 }
            java.lang.Object r5 = r8.D(r9, r0)     // Catch:{ all -> 0x00c2 }
            if (r5 != r1) goto L_0x00a9
            return r1
        L_0x00c2:
            r10 = move-exception
            r5 = r8
            r8 = r10
            goto L_0x00dc
        L_0x00c6:
            if (r2 == 0) goto L_0x00cb
            kotlinx.coroutines.JobKt.A(r2)     // Catch:{ all -> 0x00c2 }
        L_0x00cb:
            r0.Z = r8     // Catch:{ all -> 0x00c2 }
            r0.X2 = r10     // Catch:{ all -> 0x00c2 }
            r0.Y2 = r9     // Catch:{ all -> 0x00c2 }
            r0.Z2 = r2     // Catch:{ all -> 0x00c2 }
            r0.c3 = r3     // Catch:{ all -> 0x00c2 }
            java.lang.Object r5 = r10.h(r5, r0)     // Catch:{ all -> 0x00c2 }
            if (r5 != r1) goto L_0x00a9
            return r1
        L_0x00dc:
            r5.n(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.G(kotlinx.coroutines.flow.SharedFlowImpl, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void H(long j2) {
        AbstractSharedFlowSlot[] e2;
        if (!(this.X == 0 || (e2 = this.s) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : e2) {
                if (abstractSharedFlowSlot != null) {
                    SharedFlowSlot sharedFlowSlot = (SharedFlowSlot) abstractSharedFlowSlot;
                    long j3 = sharedFlowSlot.f29307a;
                    if (j3 >= 0 && j3 < j2) {
                        sharedFlowSlot.f29307a = j2;
                    }
                }
            }
        }
        this.c3 = j2;
    }

    private final void K() {
        Object[] objArr = this.a3;
        Intrinsics.m(objArr);
        SharedFlowKt.h(objArr, Q(), (Object) null);
        this.d3--;
        long Q = Q() + 1;
        if (this.b3 < Q) {
            this.b3 = Q;
        }
        if (this.c3 < Q) {
            H(Q);
        }
    }

    static /* synthetic */ Object L(SharedFlowImpl sharedFlowImpl, Object obj, Continuation continuation) {
        if (sharedFlowImpl.l(obj)) {
            return Unit.f28779a;
        }
        Object M = sharedFlowImpl.M(obj, continuation);
        return M == IntrinsicsKt.l() ? M : Unit.f28779a;
    }

    /* access modifiers changed from: private */
    public final Object M(T t, Continuation<? super Unit> continuation) {
        Continuation<Unit>[] continuationArr;
        Emitter emitter;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        Continuation<Unit>[] continuationArr2 = AbstractSharedFlowKt.f29322a;
        synchronized (this) {
            try {
                if (Y(t)) {
                    Result.Companion companion = Result.X;
                    cancellableContinuationImpl.w(Result.b(Unit.f28779a));
                    continuationArr = O(continuationArr2);
                    emitter = null;
                } else {
                    Emitter emitter2 = new Emitter(this, ((long) W()) + Q(), t, cancellableContinuationImpl);
                    N(emitter2);
                    this.e3 = this.e3 + 1;
                    if (this.Y2 == 0) {
                        continuationArr2 = O(continuationArr2);
                    }
                    continuationArr = continuationArr2;
                    emitter = emitter2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (emitter != null) {
            CancellableContinuationKt.a(cancellableContinuationImpl, emitter);
        }
        for (Continuation<Unit> continuation2 : continuationArr) {
            if (continuation2 != null) {
                Result.Companion companion2 = Result.X;
                continuation2.w(Result.b(Unit.f28779a));
            }
        }
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    /* access modifiers changed from: private */
    public final void N(Object obj) {
        int W = W();
        Object[] objArr = this.a3;
        if (objArr == null) {
            objArr = X((Object[]) null, 0, 2);
        } else if (W >= objArr.length) {
            objArr = X(objArr, W, objArr.length * 2);
        }
        SharedFlowKt.h(objArr, Q() + ((long) W), obj);
    }

    /* JADX WARNING: type inference failed for: r12v6, types: [java.lang.Object[], java.lang.Object] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r12 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.coroutines.Continuation<kotlin.Unit>[] O(kotlin.coroutines.Continuation<kotlin.Unit>[] r12) {
        /*
            r11 = this;
            int r0 = r12.length
            int r1 = r11.X
            if (r1 == 0) goto L_0x0048
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r1 = r11.s
            if (r1 == 0) goto L_0x0048
            int r2 = r1.length
            r3 = 0
        L_0x000f:
            if (r3 >= r2) goto L_0x0048
            r4 = r1[r3]
            if (r4 == 0) goto L_0x0045
            kotlinx.coroutines.flow.SharedFlowSlot r4 = (kotlinx.coroutines.flow.SharedFlowSlot) r4
            kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = r4.f29308b
            if (r5 != 0) goto L_0x001c
            goto L_0x0045
        L_0x001c:
            long r6 = r11.a0(r4)
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0045
            int r6 = r12.length
            if (r0 < r6) goto L_0x003a
            int r6 = r12.length
            r7 = 2
            int r6 = r6 * 2
            int r6 = java.lang.Math.max(r7, r6)
            java.lang.Object[] r12 = java.util.Arrays.copyOf(r12, r6)
            java.lang.String r6 = "copyOf(this, newSize)"
            kotlin.jvm.internal.Intrinsics.o(r12, r6)
        L_0x003a:
            r6 = r12
            kotlin.coroutines.Continuation[] r6 = (kotlin.coroutines.Continuation[]) r6
            int r7 = r0 + 1
            r6[r0] = r5
            r0 = 0
            r4.f29308b = r0
            r0 = r7
        L_0x0045:
            int r3 = r3 + 1
            goto L_0x000f
        L_0x0048:
            kotlin.coroutines.Continuation[] r12 = (kotlin.coroutines.Continuation[]) r12
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.SharedFlowImpl.O(kotlin.coroutines.Continuation[]):kotlin.coroutines.Continuation[]");
    }

    private final long P() {
        return Q() + ((long) this.d3);
    }

    /* access modifiers changed from: private */
    public final long Q() {
        return Math.min(this.c3, this.b3);
    }

    protected static /* synthetic */ void S() {
    }

    private final Object T(long j2) {
        Object[] objArr = this.a3;
        Intrinsics.m(objArr);
        Object c2 = SharedFlowKt.f(objArr, j2);
        return c2 instanceof Emitter ? ((Emitter) c2).Y : c2;
    }

    private final long U() {
        return Q() + ((long) this.d3) + ((long) this.e3);
    }

    private final int V() {
        return (int) ((Q() + ((long) this.d3)) - this.b3);
    }

    /* access modifiers changed from: private */
    public final int W() {
        return this.d3 + this.e3;
    }

    private final Object[] X(Object[] objArr, int i2, int i3) {
        if (i3 > 0) {
            Object[] objArr2 = new Object[i3];
            this.a3 = objArr2;
            if (objArr == null) {
                return objArr2;
            }
            long Q = Q();
            for (int i4 = 0; i4 < i2; i4++) {
                long j2 = ((long) i4) + Q;
                SharedFlowKt.h(objArr2, j2, SharedFlowKt.f(objArr, j2));
            }
            return objArr2;
        }
        throw new IllegalStateException("Buffer size overflow".toString());
    }

    /* access modifiers changed from: private */
    public final boolean Y(T t) {
        if (o() == 0) {
            return Z(t);
        }
        if (this.d3 >= this.Y2 && this.c3 <= this.b3) {
            int i2 = WhenMappings.f29305a[this.Z2.ordinal()];
            if (i2 == 1) {
                return false;
            }
            if (i2 == 2) {
                return true;
            }
        }
        N(t);
        int i3 = this.d3 + 1;
        this.d3 = i3;
        if (i3 > this.Y2) {
            K();
        }
        if (V() > this.X2) {
            c0(this.b3 + 1, this.c3, P(), U());
        }
        return true;
    }

    private final boolean Z(T t) {
        if (this.X2 == 0) {
            return true;
        }
        N(t);
        int i2 = this.d3 + 1;
        this.d3 = i2;
        if (i2 > this.X2) {
            K();
        }
        this.c3 = Q() + ((long) this.d3);
        return true;
    }

    /* access modifiers changed from: private */
    public final long a0(SharedFlowSlot sharedFlowSlot) {
        long j2 = sharedFlowSlot.f29307a;
        if (j2 < P()) {
            return j2;
        }
        if (this.Y2 <= 0 && j2 <= Q() && this.e3 != 0) {
            return j2;
        }
        return -1;
    }

    private final Object b0(SharedFlowSlot sharedFlowSlot) {
        Object obj;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f29322a;
        synchronized (this) {
            try {
                long a0 = a0(sharedFlowSlot);
                if (a0 < 0) {
                    obj = SharedFlowKt.f29306a;
                } else {
                    long j2 = sharedFlowSlot.f29307a;
                    Object T = T(a0);
                    sharedFlowSlot.f29307a = a0 + 1;
                    Object obj2 = T;
                    continuationArr = d0(j2);
                    obj = obj2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.X;
                continuation.w(Result.b(Unit.f28779a));
            }
        }
        return obj;
    }

    private final void c0(long j2, long j3, long j4, long j5) {
        long min = Math.min(j3, j2);
        for (long Q = Q(); Q < min; Q++) {
            Object[] objArr = this.a3;
            Intrinsics.m(objArr);
            SharedFlowKt.h(objArr, Q, (Object) null);
        }
        this.b3 = j2;
        this.c3 = j3;
        this.d3 = (int) (j4 - min);
        this.e3 = (int) (j5 - j4);
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: I */
    public SharedFlowSlot g() {
        return new SharedFlowSlot();
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: J */
    public SharedFlowSlot[] j(int i2) {
        return new SharedFlowSlot[i2];
    }

    /* access modifiers changed from: protected */
    public final T R() {
        Object[] objArr = this.a3;
        Intrinsics.m(objArr);
        return SharedFlowKt.f(objArr, (this.b3 + ((long) V())) - 1);
    }

    @Nullable
    public Object a(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<?> continuation) {
        return G(this, flowCollector, continuation);
    }

    @NotNull
    public List<T> b() {
        synchronized (this) {
            int V = V();
            if (V == 0) {
                List<T> E = CollectionsKt.E();
                return E;
            }
            ArrayList arrayList = new ArrayList(V);
            Object[] objArr = this.a3;
            Intrinsics.m(objArr);
            for (int i2 = 0; i2 < V; i2++) {
                arrayList.add(SharedFlowKt.f(objArr, this.b3 + ((long) i2)));
            }
            return arrayList;
        }
    }

    @NotNull
    public Flow<T> c(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return SharedFlowKt.e(this, coroutineContext, i2, bufferOverflow);
    }

    @NotNull
    public final Continuation<Unit>[] d0(long j2) {
        long j3;
        long j4;
        long j5;
        AbstractSharedFlowSlot[] e2;
        if (j2 > this.c3) {
            return AbstractSharedFlowKt.f29322a;
        }
        long Q = Q();
        long j6 = ((long) this.d3) + Q;
        if (this.Y2 == 0 && this.e3 > 0) {
            j6++;
        }
        if (!(this.X == 0 || (e2 = this.s) == null)) {
            for (AbstractSharedFlowSlot abstractSharedFlowSlot : e2) {
                if (abstractSharedFlowSlot != null) {
                    long j7 = ((SharedFlowSlot) abstractSharedFlowSlot).f29307a;
                    if (j7 >= 0 && j7 < j6) {
                        j6 = j7;
                    }
                }
            }
        }
        if (j6 <= this.c3) {
            return AbstractSharedFlowKt.f29322a;
        }
        long P = P();
        int min = o() > 0 ? Math.min(this.e3, this.Y2 - ((int) (P - j6))) : this.e3;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f29322a;
        long j8 = ((long) this.e3) + P;
        if (min > 0) {
            continuationArr = new Continuation[min];
            Object[] objArr = this.a3;
            Intrinsics.m(objArr);
            long j9 = P;
            int i2 = 0;
            while (true) {
                if (P >= j8) {
                    j4 = j6;
                    j3 = j8;
                    break;
                }
                Object c2 = SharedFlowKt.f(objArr, P);
                j4 = j6;
                Symbol symbol = SharedFlowKt.f29306a;
                if (c2 == symbol) {
                    j3 = j8;
                    j5 = 1;
                } else if (c2 != null) {
                    Emitter emitter = (Emitter) c2;
                    int i3 = i2 + 1;
                    j3 = j8;
                    continuationArr[i2] = emitter.Z;
                    SharedFlowKt.h(objArr, P, symbol);
                    SharedFlowKt.h(objArr, j9, emitter.Y);
                    j5 = 1;
                    j9++;
                    if (i3 >= min) {
                        break;
                    }
                    i2 = i3;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
                }
                P += j5;
                j6 = j4;
                j8 = j3;
            }
            P = j9;
        } else {
            j4 = j6;
            j3 = j8;
        }
        int i4 = (int) (P - Q);
        long j10 = o() == 0 ? P : j4;
        long max = Math.max(this.b3, P - ((long) Math.min(this.X2, i4)));
        if (this.Y2 == 0 && max < j3) {
            Object[] objArr2 = this.a3;
            Intrinsics.m(objArr2);
            if (Intrinsics.g(SharedFlowKt.f(objArr2, max), SharedFlowKt.f29306a)) {
                P++;
                max++;
            }
        }
        c0(max, j10, P, j3);
        F();
        return (continuationArr.length == 0) ^ true ? O(continuationArr) : continuationArr;
    }

    public final long e0() {
        long j2 = this.b3;
        if (j2 < this.c3) {
            this.c3 = j2;
        }
        return j2;
    }

    @Nullable
    public Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        return L(this, t, continuation);
    }

    public void i() {
        synchronized (this) {
            c0(P(), this.c3, P(), U());
            Unit unit = Unit.f28779a;
        }
    }

    public boolean l(T t) {
        int i2;
        boolean z;
        Continuation<Unit>[] continuationArr = AbstractSharedFlowKt.f29322a;
        synchronized (this) {
            if (Y(t)) {
                continuationArr = O(continuationArr);
                z = true;
            } else {
                z = false;
            }
        }
        for (Continuation<Unit> continuation : continuationArr) {
            if (continuation != null) {
                Result.Companion companion = Result.X;
                continuation.w(Result.b(Unit.f28779a));
            }
        }
        return z;
    }
}
