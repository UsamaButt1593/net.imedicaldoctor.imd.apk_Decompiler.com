package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.DispatchedContinuationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0003"}, d2 = {"", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class YieldKt {
    @Nullable
    public static final Object a(@NotNull Continuation<? super Unit> continuation) {
        Object obj;
        CoroutineContext g2 = continuation.g();
        JobKt.z(g2);
        Continuation<? super Unit> e2 = IntrinsicsKt.e(continuation);
        DispatchedContinuation dispatchedContinuation = e2 instanceof DispatchedContinuation ? (DispatchedContinuation) e2 : null;
        if (dispatchedContinuation == null) {
            obj = Unit.f28779a;
        } else {
            if (dispatchedContinuation.Z.T(g2)) {
                dispatchedContinuation.n(g2, Unit.f28779a);
            } else {
                YieldContext yieldContext = new YieldContext();
                CoroutineContext v = g2.v(yieldContext);
                Unit unit = Unit.f28779a;
                dispatchedContinuation.n(v, unit);
                if (yieldContext.X && !DispatchedContinuationKt.h(dispatchedContinuation)) {
                    obj = unit;
                }
            }
            obj = IntrinsicsKt.l();
        }
        if (obj == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return obj == IntrinsicsKt.l() ? obj : Unit.f28779a;
    }
}
