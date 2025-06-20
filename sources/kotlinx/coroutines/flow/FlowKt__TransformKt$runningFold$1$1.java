package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__TransformKt$runningFold$1$1<T> implements FlowCollector {
    final /* synthetic */ Function3<R, T, Continuation<? super R>, Object> X;
    final /* synthetic */ FlowCollector<R> Y;
    final /* synthetic */ Ref.ObjectRef<R> s;

    FlowKt__TransformKt$runningFold$1$1(Ref.ObjectRef<R> objectRef, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
        this.s = objectRef;
        this.X = function3;
        this.Y = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1$emit$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.n(r9)
            goto L_0x0070
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.X2
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1) r2
            kotlin.ResultKt.n(r9)
            goto L_0x005a
        L_0x0040:
            kotlin.ResultKt.n(r9)
            kotlin.jvm.internal.Ref$ObjectRef<R> r9 = r7.s
            kotlin.jvm.functions.Function3<R, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r7.X
            T r5 = r9.s
            r0.Z = r7
            r0.X2 = r9
            r0.a3 = r4
            java.lang.Object r8 = r2.A(r5, r8, r0)
            if (r8 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r2 = r7
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005a:
            r8.s = r9
            kotlinx.coroutines.flow.FlowCollector<R> r8 = r2.Y
            kotlin.jvm.internal.Ref$ObjectRef<R> r9 = r2.s
            T r9 = r9.s
            r2 = 0
            r0.Z = r2
            r0.X2 = r2
            r0.a3 = r3
            java.lang.Object r8 = r8.h(r9, r0)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            kotlin.Unit r8 = kotlin.Unit.f28779a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningFold$1$1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
