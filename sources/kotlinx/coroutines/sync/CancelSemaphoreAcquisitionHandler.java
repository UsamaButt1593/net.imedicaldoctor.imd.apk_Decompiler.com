package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CancelHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/sync/CancelSemaphoreAcquisitionHandler;", "Lkotlinx/coroutines/CancelHandler;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "segment", "", "index", "<init>", "(Lkotlinx/coroutines/sync/SemaphoreSegment;I)V", "", "cause", "", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "X", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class CancelSemaphoreAcquisitionHandler extends CancelHandler {
    private final int X;
    @NotNull
    private final SemaphoreSegment s;

    public CancelSemaphoreAcquisitionHandler(@NotNull SemaphoreSegment semaphoreSegment, int i2) {
        this.s = semaphoreSegment;
        this.X = i2;
    }

    public void b(@Nullable Throwable th) {
        this.s.s(this.X);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }

    @NotNull
    public String toString() {
        return "CancelSemaphoreAcquisitionHandler[" + this.s + ", " + this.X + ']';
    }
}
