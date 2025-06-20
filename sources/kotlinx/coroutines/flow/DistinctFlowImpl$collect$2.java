package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class DistinctFlowImpl$collect$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> X;
    final /* synthetic */ FlowCollector<T> Y;
    final /* synthetic */ DistinctFlowImpl<T> s;

    DistinctFlowImpl$collect$2(DistinctFlowImpl<T> distinctFlowImpl, Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector) {
        this.s = distinctFlowImpl;
        this.X = objectRef;
        this.Y = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(T r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = (kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1 r0 = new kotlinx.coroutines.flow.DistinctFlowImpl$collect$2$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.n(r7)
            goto L_0x0067
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.ResultKt.n(r7)
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r7 = r5.s
            kotlin.jvm.functions.Function1<T, java.lang.Object> r7 = r7.X
            java.lang.Object r7 = r7.f(r6)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.X
            T r2 = r2.s
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.flow.internal.NullSurrogateKt.f29323a
            if (r2 == r4) goto L_0x0058
            kotlinx.coroutines.flow.DistinctFlowImpl<T> r4 = r5.s
            kotlin.jvm.functions.Function2<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.Y
            java.lang.Object r2 = r4.d0(r2, r7)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0055
            goto L_0x0058
        L_0x0055:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        L_0x0058:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r2 = r5.X
            r2.s = r7
            kotlinx.coroutines.flow.FlowCollector<T> r7 = r5.Y
            r0.Y2 = r3
            java.lang.Object r6 = r7.h(r6, r0)
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0067:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.DistinctFlowImpl$collect$2.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
