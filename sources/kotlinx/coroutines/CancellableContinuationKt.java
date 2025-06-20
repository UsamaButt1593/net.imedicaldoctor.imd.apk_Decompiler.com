package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001HHø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001HHø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001f\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", "", "block", "d", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CancellableContinuationImpl;", "b", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "c", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "Lkotlinx/coroutines/DisposableHandle;", "handle", "a", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/DisposableHandle;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CancellableContinuationKt {
    @InternalCoroutinesApi
    public static final void a(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull DisposableHandle disposableHandle) {
        cancellableContinuation.M(new DisposeOnCancel(disposableHandle));
    }

    @NotNull
    public static final <T> CancellableContinuationImpl<T> b(@NotNull Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> m2 = ((DispatchedContinuation) continuation).m();
        if (m2 != null) {
            if (!m2.I()) {
                m2 = null;
            }
            if (m2 != null) {
                return m2;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void c(@NotNull CancellableContinuation<?> cancellableContinuation, @NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.M(new RemoveOnCancel(lockFreeLinkedListNode));
    }

    @Nullable
    public static final <T> Object d(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> function1, @NotNull Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        function1.f(cancellableContinuationImpl);
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }

    private static final <T> Object e(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.e(0);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
        cancellableContinuationImpl.W();
        function1.f(cancellableContinuationImpl);
        Object y = cancellableContinuationImpl.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return y;
    }

    @Nullable
    public static final <T> Object f(@NotNull Function1<? super CancellableContinuation<? super T>, Unit> function1, @NotNull Continuation<? super T> continuation) {
        CancellableContinuationImpl<? super T> b2 = b(IntrinsicsKt.e(continuation));
        function1.f(b2);
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }

    private static final <T> Object g(Function1<? super CancellableContinuation<? super T>, Unit> function1, Continuation<? super T> continuation) {
        InlineMarker.e(0);
        CancellableContinuationImpl<? super T> b2 = b(IntrinsicsKt.e(continuation));
        function1.f(b2);
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        InlineMarker.e(1);
        return y;
    }
}
