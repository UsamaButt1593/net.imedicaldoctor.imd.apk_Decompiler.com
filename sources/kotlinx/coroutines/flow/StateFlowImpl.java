package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0006B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\u00020\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0014¢\u0006\u0004\b \u0010!J\u001f\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$2\u0006\u0010#\u001a\u00020\"H\u0014¢\u0006\u0004\b%\u0010&J-\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\"2\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00028\u00008V@VX\u000e¢\u0006\u0012\u0012\u0004\b5\u0010\u001a\u001a\u0004\b2\u00103\"\u0004\b4\u0010\nR\u001a\u00109\u001a\b\u0012\u0004\u0012\u00028\u0000068VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00108\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "expectedState", "newState", "", "u", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "expect", "update", "compareAndSet", "value", "l", "(Ljava/lang/Object;)Z", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "i", "()V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "r", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "s", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "c", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "X2", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "t", "", "b", "()Ljava/util/List;", "replayCache", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, CancellableFlow<T>, FusibleFlow<T> {
    private int X2;
    @NotNull
    private volatile /* synthetic */ Object _state;

    public StateFlowImpl(@NotNull Object obj) {
        this._state = obj;
    }

    public static /* synthetic */ void t() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        if (r8 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
        r2 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0034, code lost:
        if (r3 >= r2) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
        r4 = r8[r3];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0038, code lost:
        if (r4 == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
        r4.f();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0040, code lost:
        monitor-enter(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r8 = r6.X2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0043, code lost:
        if (r8 != r7) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0045, code lost:
        r6.X2 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0048, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0049, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r7 = p();
        r2 = kotlin.Unit.f28779a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0052, code lost:
        monitor-exit(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0053, code lost:
        r5 = r8;
        r8 = r7;
        r7 = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean u(java.lang.Object r7, java.lang.Object r8) {
        /*
            r6 = this;
            r6.p()
            monitor-enter(r6)
            java.lang.Object r0 = r6._state     // Catch:{ all -> 0x0011 }
            r1 = 0
            if (r7 == 0) goto L_0x0013
            boolean r7 = kotlin.jvm.internal.Intrinsics.g(r0, r7)     // Catch:{ all -> 0x0011 }
            if (r7 != 0) goto L_0x0013
            monitor-exit(r6)
            return r1
        L_0x0011:
            r7 = move-exception
            goto L_0x005f
        L_0x0013:
            boolean r7 = kotlin.jvm.internal.Intrinsics.g(r0, r8)     // Catch:{ all -> 0x0011 }
            r0 = 1
            if (r7 == 0) goto L_0x001c
            monitor-exit(r6)
            return r0
        L_0x001c:
            r6._state = r8     // Catch:{ all -> 0x0011 }
            int r7 = r6.X2     // Catch:{ all -> 0x0011 }
            r8 = r7 & 1
            if (r8 != 0) goto L_0x0059
            int r7 = r7 + r0
            r6.X2 = r7     // Catch:{ all -> 0x0011 }
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r8 = r6.p()     // Catch:{ all -> 0x0011 }
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0011 }
            monitor-exit(r6)
        L_0x002e:
            kotlinx.coroutines.flow.StateFlowSlot[] r8 = (kotlinx.coroutines.flow.StateFlowSlot[]) r8
            if (r8 == 0) goto L_0x0040
            int r2 = r8.length
            r3 = 0
        L_0x0034:
            if (r3 >= r2) goto L_0x0040
            r4 = r8[r3]
            if (r4 == 0) goto L_0x003d
            r4.f()
        L_0x003d:
            int r3 = r3 + 1
            goto L_0x0034
        L_0x0040:
            monitor-enter(r6)
            int r8 = r6.X2     // Catch:{ all -> 0x004a }
            if (r8 != r7) goto L_0x004c
            int r7 = r7 + r0
            r6.X2 = r7     // Catch:{ all -> 0x004a }
            monitor-exit(r6)
            return r0
        L_0x004a:
            r7 = move-exception
            goto L_0x0057
        L_0x004c:
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] r7 = r6.p()     // Catch:{ all -> 0x004a }
            kotlin.Unit r2 = kotlin.Unit.f28779a     // Catch:{ all -> 0x004a }
            monitor-exit(r6)
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x002e
        L_0x0057:
            monitor-exit(r6)
            throw r7
        L_0x0059:
            int r7 = r7 + 2
            r6.X2 = r7     // Catch:{ all -> 0x0011 }
            monitor-exit(r6)
            return r0
        L_0x005f:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.u(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.flow.StateFlowSlot} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: kotlinx.coroutines.flow.StateFlowImpl} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00af A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00be A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d3 A[Catch:{ all -> 0x0043 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d4 A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00db A[Catch:{ all -> 0x0043 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof kotlinx.coroutines.flow.StateFlowImpl$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = (kotlinx.coroutines.flow.StateFlowImpl$collect$1) r0
            int r1 = r0.d3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.StateFlowImpl$collect$1 r0 = new kotlinx.coroutines.flow.StateFlowImpl$collect$1
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.b3
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.d3
            r3 = 0
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0077
            if (r2 == r6) goto L_0x0065
            if (r2 == r5) goto L_0x004e
            if (r2 != r4) goto L_0x0046
            java.lang.Object r11 = r0.a3
            java.lang.Object r2 = r0.Z2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.Z
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0043 }
            goto L_0x00ab
        L_0x0043:
            r11 = move-exception
            goto L_0x00ee
        L_0x0046:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x004e:
            java.lang.Object r11 = r0.a3
            java.lang.Object r2 = r0.Z2
            kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
            java.lang.Object r6 = r0.Y2
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r7 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            java.lang.Object r8 = r0.Z
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0043 }
            goto L_0x00d5
        L_0x0065:
            java.lang.Object r11 = r0.Y2
            r6 = r11
            kotlinx.coroutines.flow.StateFlowSlot r6 = (kotlinx.coroutines.flow.StateFlowSlot) r6
            java.lang.Object r11 = r0.X2
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r2 = r0.Z
            r8 = r2
            kotlinx.coroutines.flow.StateFlowImpl r8 = (kotlinx.coroutines.flow.StateFlowImpl) r8
            kotlin.ResultKt.n(r12)     // Catch:{ all -> 0x0043 }
            goto L_0x009c
        L_0x0077:
            kotlin.ResultKt.n(r12)
            kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot r12 = r10.f()
            kotlinx.coroutines.flow.StateFlowSlot r12 = (kotlinx.coroutines.flow.StateFlowSlot) r12
            boolean r2 = r11 instanceof kotlinx.coroutines.flow.SubscribedFlowCollector     // Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x009a
            r2 = r11
            kotlinx.coroutines.flow.SubscribedFlowCollector r2 = (kotlinx.coroutines.flow.SubscribedFlowCollector) r2     // Catch:{ all -> 0x0096 }
            r0.Z = r10     // Catch:{ all -> 0x0096 }
            r0.X2 = r11     // Catch:{ all -> 0x0096 }
            r0.Y2 = r12     // Catch:{ all -> 0x0096 }
            r0.d3 = r6     // Catch:{ all -> 0x0096 }
            java.lang.Object r2 = r2.a(r0)     // Catch:{ all -> 0x0096 }
            if (r2 != r1) goto L_0x009a
            return r1
        L_0x0096:
            r11 = move-exception
            r8 = r10
            r6 = r12
            goto L_0x00ee
        L_0x009a:
            r8 = r10
            r6 = r12
        L_0x009c:
            kotlin.coroutines.CoroutineContext r12 = r0.g()     // Catch:{ all -> 0x0043 }
            kotlinx.coroutines.Job$Key r2 = kotlinx.coroutines.Job.P2     // Catch:{ all -> 0x0043 }
            kotlin.coroutines.CoroutineContext$Element r12 = r12.e(r2)     // Catch:{ all -> 0x0043 }
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12     // Catch:{ all -> 0x0043 }
            r7 = r11
            r2 = r12
            r11 = r3
        L_0x00ab:
            java.lang.Object r12 = r8._state     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x00b2
            kotlinx.coroutines.JobKt.A(r2)     // Catch:{ all -> 0x0043 }
        L_0x00b2:
            if (r11 == 0) goto L_0x00ba
            boolean r9 = kotlin.jvm.internal.Intrinsics.g(r11, r12)     // Catch:{ all -> 0x0043 }
            if (r9 != 0) goto L_0x00d5
        L_0x00ba:
            kotlinx.coroutines.internal.Symbol r11 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29323a     // Catch:{ all -> 0x0043 }
            if (r12 != r11) goto L_0x00c0
            r11 = r3
            goto L_0x00c1
        L_0x00c0:
            r11 = r12
        L_0x00c1:
            r0.Z = r8     // Catch:{ all -> 0x0043 }
            r0.X2 = r7     // Catch:{ all -> 0x0043 }
            r0.Y2 = r6     // Catch:{ all -> 0x0043 }
            r0.Z2 = r2     // Catch:{ all -> 0x0043 }
            r0.a3 = r12     // Catch:{ all -> 0x0043 }
            r0.d3 = r5     // Catch:{ all -> 0x0043 }
            java.lang.Object r11 = r7.h(r11, r0)     // Catch:{ all -> 0x0043 }
            if (r11 != r1) goto L_0x00d4
            return r1
        L_0x00d4:
            r11 = r12
        L_0x00d5:
            boolean r12 = r6.g()     // Catch:{ all -> 0x0043 }
            if (r12 != 0) goto L_0x00ab
            r0.Z = r8     // Catch:{ all -> 0x0043 }
            r0.X2 = r7     // Catch:{ all -> 0x0043 }
            r0.Y2 = r6     // Catch:{ all -> 0x0043 }
            r0.Z2 = r2     // Catch:{ all -> 0x0043 }
            r0.a3 = r11     // Catch:{ all -> 0x0043 }
            r0.d3 = r4     // Catch:{ all -> 0x0043 }
            java.lang.Object r12 = r6.d(r0)     // Catch:{ all -> 0x0043 }
            if (r12 != r1) goto L_0x00ab
            return r1
        L_0x00ee:
            r8.n(r6)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.StateFlowImpl.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    public List<T> b() {
        return CollectionsKt.k(getValue());
    }

    @NotNull
    public Flow<T> c(@NotNull CoroutineContext coroutineContext, int i2, @NotNull BufferOverflow bufferOverflow) {
        return StateFlowKt.d(this, coroutineContext, i2, bufferOverflow);
    }

    public boolean compareAndSet(T t, T t2) {
        if (t == null) {
            t = NullSurrogateKt.f29323a;
        }
        if (t2 == null) {
            t2 = NullSurrogateKt.f29323a;
        }
        return u(t, t2);
    }

    public T getValue() {
        T t = NullSurrogateKt.f29323a;
        T t2 = this._state;
        if (t2 == t) {
            return null;
        }
        return t2;
    }

    @Nullable
    public Object h(T t, @NotNull Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.f28779a;
    }

    public void i() {
        throw new UnsupportedOperationException("MutableStateFlow.resetReplayCache is not supported");
    }

    public boolean l(T t) {
        setValue(t);
        return true;
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: r */
    public StateFlowSlot g() {
        return new StateFlowSlot();
    }

    /* access modifiers changed from: protected */
    @NotNull
    /* renamed from: s */
    public StateFlowSlot[] j(int i2) {
        return new StateFlowSlot[i2];
    }

    public void setValue(T t) {
        if (t == null) {
            t = NullSurrogateKt.f29323a;
        }
        u((Object) null, t);
    }
}
