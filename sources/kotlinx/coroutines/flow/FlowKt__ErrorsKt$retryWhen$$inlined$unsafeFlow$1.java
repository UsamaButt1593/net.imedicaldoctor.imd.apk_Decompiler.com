package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function4 X;
    final /* synthetic */ Flow s;

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.s = flow;
        this.X = function4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.X2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.X2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.X2
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            long r5 = r0.c3
            java.lang.Object r12 = r0.b3
            java.lang.Throwable r12 = (java.lang.Throwable) r12
            java.lang.Object r2 = r0.a3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.Z2
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r7 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r7
            kotlin.ResultKt.n(r13)
            goto L_0x0099
        L_0x003a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0042:
            int r12 = r0.d3
            long r5 = r0.c3
            java.lang.Object r2 = r0.a3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r7 = r0.Z2
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r7 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r7
            kotlin.ResultKt.n(r13)
            goto L_0x0073
        L_0x0052:
            kotlin.ResultKt.n(r13)
            r5 = 0
            r13 = r11
        L_0x0058:
            kotlinx.coroutines.flow.Flow r2 = r13.s
            r0.Z2 = r13
            r0.a3 = r12
            r7 = 0
            r0.b3 = r7
            r0.c3 = r5
            r7 = 0
            r0.d3 = r7
            r0.X2 = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.v(r2, r12, r0)
            if (r2 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r7 = r13
            r13 = r2
            r2 = r12
            r12 = 0
        L_0x0073:
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            if (r13 == 0) goto L_0x00a8
            kotlin.jvm.functions.Function4 r12 = r7.X
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.g(r5)
            r0.Z2 = r7
            r0.a3 = r2
            r0.b3 = r13
            r0.c3 = r5
            r0.X2 = r3
            r9 = 6
            kotlin.jvm.internal.InlineMarker.e(r9)
            java.lang.Object r12 = r12.O(r2, r13, r8, r0)
            r8 = 7
            kotlin.jvm.internal.InlineMarker.e(r8)
            if (r12 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r10 = r13
            r13 = r12
            r12 = r10
        L_0x0099:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 == 0) goto L_0x00a7
            r12 = 1
            long r5 = r5 + r12
            r13 = r7
            r12 = 1
            goto L_0x00a9
        L_0x00a7:
            throw r12
        L_0x00a8:
            r13 = r7
        L_0x00a9:
            if (r12 != 0) goto L_0x00ae
            kotlin.Unit r12 = kotlin.Unit.f28779a
            return r12
        L_0x00ae:
            r12 = r2
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
