package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__CountKt$count$4<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef X;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> s;

    FlowKt__CountKt$count$4(Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Ref.IntRef intRef) {
        this.s = function2;
        this.X = intRef;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$4$emit$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.Z
            kotlinx.coroutines.flow.FlowKt__CountKt$count$4 r5 = (kotlinx.coroutines.flow.FlowKt__CountKt$count$4) r5
            kotlin.ResultKt.n(r6)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.n(r6)
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r6 = r4.s
            r0.Z = r4
            r0.Z2 = r3
            java.lang.Object r6 = r6.d0(r5, r0)
            if (r6 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r5 = r4
        L_0x0046:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x0055
            kotlin.jvm.internal.Ref$IntRef r5 = r5.X
            int r6 = r5.s
            int r6 = r6 + r3
            r5.s = r6
        L_0x0055:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CountKt$count$4.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
