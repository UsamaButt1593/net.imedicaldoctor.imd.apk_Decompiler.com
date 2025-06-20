package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowTransformLatest$flowCollect$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int X2;
    private /* synthetic */ Object Y2;
    final /* synthetic */ ChannelFlowTransformLatest<T, R> Z2;
    final /* synthetic */ FlowCollector<R> a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowTransformLatest$flowCollect$3(ChannelFlowTransformLatest<T, R> channelFlowTransformLatest, FlowCollector<? super R> flowCollector, Continuation<? super ChannelFlowTransformLatest$flowCollect$3> continuation) {
        super(2, continuation);
        this.Z2 = channelFlowTransformLatest;
        this.a3 = flowCollector;
    }

    @Nullable
    public final Object D(@NotNull Object obj) {
        Object l2 = IntrinsicsKt.l();
        int i2 = this.X2;
        if (i2 == 0) {
            ResultKt.n(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.Y2;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final ChannelFlowTransformLatest<T, R> channelFlowTransformLatest = this.Z2;
            Flow<S> flow = channelFlowTransformLatest.Z;
            final FlowCollector<R> flowCollector = this.a3;
            AnonymousClass1 r5 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object h(final T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r9
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1) r0
                        int r1 = r0.b3
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.b3 = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$emit$1
                        r0.<init>(r7, r9)
                    L_0x0018:
                        java.lang.Object r9 = r0.Z2
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
                        int r2 = r0.b3
                        r3 = 1
                        if (r2 == 0) goto L_0x003b
                        if (r2 != r3) goto L_0x0033
                        java.lang.Object r8 = r0.Y2
                        kotlinx.coroutines.Job r8 = (kotlinx.coroutines.Job) r8
                        java.lang.Object r8 = r0.X2
                        java.lang.Object r0 = r0.Z
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1) r0
                        kotlin.ResultKt.n(r9)
                        goto L_0x005e
                    L_0x0033:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L_0x003b:
                        kotlin.ResultKt.n(r9)
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r1
                        T r9 = r9.s
                        kotlinx.coroutines.Job r9 = (kotlinx.coroutines.Job) r9
                        if (r9 == 0) goto L_0x005d
                        kotlinx.coroutines.flow.internal.ChildCancelledException r2 = new kotlinx.coroutines.flow.internal.ChildCancelledException
                        r2.<init>()
                        r9.i(r2)
                        r0.Z = r7
                        r0.X2 = r8
                        r0.Y2 = r9
                        r0.b3 = r3
                        java.lang.Object r9 = r9.F(r0)
                        if (r9 != r1) goto L_0x005d
                        return r1
                    L_0x005d:
                        r0 = r7
                    L_0x005e:
                        kotlin.jvm.internal.Ref$ObjectRef<kotlinx.coroutines.Job> r9 = r1
                        kotlinx.coroutines.CoroutineScope r1 = r8
                        kotlinx.coroutines.CoroutineStart r3 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2
                        kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest<T, R> r2 = r3
                        kotlinx.coroutines.flow.FlowCollector<R> r0 = r6
                        r5 = 0
                        r4.<init>(r2, r0, r8, r5)
                        r5 = 1
                        r6 = 0
                        r2 = 0
                        kotlinx.coroutines.Job r8 = kotlinx.coroutines.BuildersKt__Builders_commonKt.f(r1, r2, r3, r4, r5, r6)
                        r9.s = r8
                        kotlin.Unit r8 = kotlin.Unit.f28779a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3.AnonymousClass1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.X2 = 1;
            if (flow.a(r5, this) == l2) {
                return l2;
            }
        } else if (i2 == 1) {
            ResultKt.n(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.f28779a;
    }

    @Nullable
    /* renamed from: U */
    public final Object d0(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChannelFlowTransformLatest$flowCollect$3) v(coroutineScope, continuation)).D(Unit.f28779a);
    }

    @NotNull
    public final Continuation<Unit> v(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ChannelFlowTransformLatest$flowCollect$3 channelFlowTransformLatest$flowCollect$3 = new ChannelFlowTransformLatest$flowCollect$3(this.Z2, this.a3, continuation);
        channelFlowTransformLatest$flowCollect$3.Y2 = obj;
        return channelFlowTransformLatest$flowCollect$3;
    }
}
