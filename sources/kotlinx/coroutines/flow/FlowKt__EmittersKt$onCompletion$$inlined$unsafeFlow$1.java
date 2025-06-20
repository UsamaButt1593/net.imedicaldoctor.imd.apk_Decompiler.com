package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "a", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function3 X;
    final /* synthetic */ Flow s;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.s = flow;
        this.X = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.X2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.X2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.X2
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.Z2
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x0088
        L_0x0034:
            r10 = move-exception
            goto L_0x0092
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            java.lang.Object r9 = r0.Z2
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.n(r10)
            goto L_0x00ac
        L_0x0046:
            java.lang.Object r9 = r0.a3
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r2 = r0.Z2
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.ResultKt.n(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x0067
        L_0x0052:
            r9 = move-exception
            goto L_0x0098
        L_0x0054:
            kotlin.ResultKt.n(r10)
            kotlinx.coroutines.flow.Flow r10 = r8.s     // Catch:{ all -> 0x0096 }
            r0.Z2 = r8     // Catch:{ all -> 0x0096 }
            r0.a3 = r9     // Catch:{ all -> 0x0096 }
            r0.X2 = r5     // Catch:{ all -> 0x0096 }
            java.lang.Object r10 = r10.a(r9, r0)     // Catch:{ all -> 0x0096 }
            if (r10 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r8
        L_0x0067:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r4 = r0.g()
            r10.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r9 = r2.X     // Catch:{ all -> 0x008e }
            r0.Z2 = r10     // Catch:{ all -> 0x008e }
            r0.a3 = r6     // Catch:{ all -> 0x008e }
            r0.X2 = r3     // Catch:{ all -> 0x008e }
            r2 = 6
            kotlin.jvm.internal.InlineMarker.e(r2)     // Catch:{ all -> 0x008e }
            java.lang.Object r9 = r9.A(r10, r6, r0)     // Catch:{ all -> 0x008e }
            r0 = 7
            kotlin.jvm.internal.InlineMarker.e(r0)     // Catch:{ all -> 0x008e }
            if (r9 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r9 = r10
        L_0x0088:
            r9.I()
            kotlin.Unit r9 = kotlin.Unit.f28779a
            return r9
        L_0x008e:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0092:
            r9.I()
            throw r10
        L_0x0096:
            r9 = move-exception
            r2 = r8
        L_0x0098:
            kotlinx.coroutines.flow.ThrowingCollector r10 = new kotlinx.coroutines.flow.ThrowingCollector
            r10.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = r2.X
            r0.Z2 = r9
            r0.a3 = r6
            r0.X2 = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.c(r10, r2, r9, r0)
            if (r10 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.a(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
