package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", ""}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    int X2;
    /* synthetic */ Object Y2;
    /* synthetic */ long Z2;
    final /* synthetic */ long a3;
    final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> b3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$3(long j2, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super FlowKt__ErrorsKt$retry$3> continuation) {
        super(4, continuation);
        this.a3 = j2;
        this.b3 = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L_0x003b;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object D(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r1 = r7.X2
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.n(r8)
            goto L_0x0031
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.ResultKt.n(r8)
            java.lang.Object r8 = r7.Y2
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.Z2
            long r5 = r7.a3
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x003a
            kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r7.b3
            r7.X2 = r2
            java.lang.Object r8 = r1.d0(r8, r7)
            if (r8 != r0) goto L_0x0031
            return r0
        L_0x0031:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.a(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.D(java.lang.Object):java.lang.Object");
    }

    public /* bridge */ /* synthetic */ Object O(Object obj, Object obj2, Object obj3, Object obj4) {
        return U((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4);
    }

    @Nullable
    public final Object U(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j2, @Nullable Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.a3, this.b3, continuation);
        flowKt__ErrorsKt$retry$3.Y2 = th;
        flowKt__ErrorsKt$retry$3.Z2 = j2;
        return flowKt__ErrorsKt$retry$3.D(Unit.f28779a);
    }
}
