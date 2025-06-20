package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__EmittersKt$onEmpty$1$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> X;
    final /* synthetic */ Ref.BooleanRef s;

    FlowKt__EmittersKt$onEmpty$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector) {
        this.s = booleanRef;
        this.X = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1$emit$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.n(r6)
            goto L_0x0044
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.n(r6)
            kotlin.jvm.internal.Ref$BooleanRef r6 = r4.s
            r2 = 0
            r6.s = r2
            kotlinx.coroutines.flow.FlowCollector<T> r6 = r4.X
            r0.Y2 = r3
            java.lang.Object r5 = r6.h(r5, r0)
            if (r5 != r1) goto L_0x0044
            return r1
        L_0x0044:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
