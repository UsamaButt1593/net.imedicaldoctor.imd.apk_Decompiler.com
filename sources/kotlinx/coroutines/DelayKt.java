package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a!\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0007\u001a\u0019\u0010\u000b\u001a\u00020\u0003*\u00020\bH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\"\u0018\u0010\u0011\u001a\u00020\u000e*\u00020\r8@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "", "b", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/time/Duration;", "duration", "c", "e", "(J)J", "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/Delay;", "d", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "delay", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class DelayKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<?> r4) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.DelayKt$awaitCancellation$1
            if (r0 == 0) goto L_0x0013
            r0 = r4
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = (kotlinx.coroutines.DelayKt$awaitCancellation$1) r0
            int r1 = r0.X2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.X2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.DelayKt$awaitCancellation$1 r0 = new kotlinx.coroutines.DelayKt$awaitCancellation$1
            r0.<init>(r4)
        L_0x0018:
            java.lang.Object r4 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.X2
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L_0x002d:
            kotlin.ResultKt.n(r4)
            goto L_0x0052
        L_0x0031:
            kotlin.ResultKt.n(r4)
            r0.X2 = r3
            kotlinx.coroutines.CancellableContinuationImpl r4 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.e(r0)
            r4.<init>(r2, r3)
            r4.W()
            java.lang.Object r4 = r4.y()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            if (r4 != r2) goto L_0x004f
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L_0x004f:
            if (r4 != r1) goto L_0x0052
            return r1
        L_0x0052:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DelayKt.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final Object b(long j2, @NotNull Continuation<? super Unit> continuation) {
        if (j2 <= 0) {
            return Unit.f28779a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        if (j2 < Long.MAX_VALUE) {
            d(cancellableContinuationImpl.g()).r(j2, cancellableContinuationImpl);
        }
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    @Nullable
    public static final Object c(long j2, @NotNull Continuation<? super Unit> continuation) {
        Object b2 = b(e(j2), continuation);
        return b2 == IntrinsicsKt.l() ? b2 : Unit.f28779a;
    }

    @NotNull
    public static final Delay d(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.Element e2 = coroutineContext.e(ContinuationInterceptor.N2);
        Delay delay = e2 instanceof Delay ? (Delay) e2 : null;
        return delay == null ? DefaultExecutorKt.a() : delay;
    }

    public static final long e(long j2) {
        if (Duration.i(j2, Duration.X.W()) > 0) {
            return RangesKt.v(Duration.L(j2), 1);
        }
        return 0;
    }
}
