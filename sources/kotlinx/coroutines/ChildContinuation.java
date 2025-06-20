package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/ChildContinuation;", "Lkotlinx/coroutines/JobCancellingNode;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "child", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "", "cause", "", "X0", "(Ljava/lang/Throwable;)V", "X2", "Lkotlinx/coroutines/CancellableContinuationImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ChildContinuation extends JobCancellingNode {
    @NotNull
    @JvmField
    public final CancellableContinuationImpl<?> X2;

    public ChildContinuation(@NotNull CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.X2 = cancellableContinuationImpl;
    }

    public void X0(@Nullable Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.X2;
        cancellableContinuationImpl.G(cancellableContinuationImpl.x(Y0()));
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        X0((Throwable) obj);
        return Unit.f28779a;
    }
}
