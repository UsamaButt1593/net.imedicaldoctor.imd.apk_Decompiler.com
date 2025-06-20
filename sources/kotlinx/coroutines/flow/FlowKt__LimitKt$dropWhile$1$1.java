package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "value", "", "h", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class FlowKt__LimitKt$dropWhile$1$1<T> implements FlowCollector {
    final /* synthetic */ FlowCollector<T> X;
    final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> Y;
    final /* synthetic */ Ref.BooleanRef s;

    FlowKt__LimitKt$dropWhile$1$1(Ref.BooleanRef booleanRef, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        this.s = booleanRef;
        this.X = flowCollector;
        this.Y = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object h(T r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1) r0
            int r1 = r0.a3
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.a3 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1$emit$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.Y2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.a3
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.n(r8)
            goto L_0x0088
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            java.lang.Object r7 = r0.X2
            java.lang.Object r2 = r0.Z
            kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1) r2
            kotlin.ResultKt.n(r8)
            goto L_0x006c
        L_0x0041:
            kotlin.ResultKt.n(r8)
            goto L_0x0059
        L_0x0045:
            kotlin.ResultKt.n(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = r6.s
            boolean r8 = r8.s
            if (r8 == 0) goto L_0x005c
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r6.X
            r0.a3 = r5
            java.lang.Object r7 = r8.h(r7, r0)
            if (r7 != r1) goto L_0x0059
            return r1
        L_0x0059:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        L_0x005c:
            kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r8 = r6.Y
            r0.Z = r6
            r0.X2 = r7
            r0.a3 = r4
            java.lang.Object r8 = r8.d0(r7, r0)
            if (r8 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r6
        L_0x006c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x008b
            kotlin.jvm.internal.Ref$BooleanRef r8 = r2.s
            r8.s = r5
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r2.X
            r2 = 0
            r0.Z = r2
            r0.X2 = r2
            r0.a3 = r3
            java.lang.Object r7 = r8.h(r7, r0)
            if (r7 != r1) goto L_0x0088
            return r1
        L_0x0088:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        L_0x008b:
            kotlin.Unit r7 = kotlin.Unit.f28779a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1.h(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
