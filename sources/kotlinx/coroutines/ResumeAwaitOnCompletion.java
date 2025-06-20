package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/CancellableContinuationImpl;", "continuation", "<init>", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "", "cause", "", "X0", "(Ljava/lang/Throwable;)V", "X2", "Lkotlinx/coroutines/CancellableContinuationImpl;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class ResumeAwaitOnCompletion<T> extends JobNode {
    @NotNull
    private final CancellableContinuationImpl<T> X2;

    public ResumeAwaitOnCompletion(@NotNull CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.X2 = cancellableContinuationImpl;
    }

    public void X0(@Nullable Throwable th) {
        CancellableContinuationImpl<T> cancellableContinuationImpl;
        Object o;
        Object T0 = Y0().T0();
        if (T0 instanceof CompletedExceptionally) {
            cancellableContinuationImpl = this.X2;
            Result.Companion companion = Result.X;
            o = ResultKt.a(((CompletedExceptionally) T0).f29164a);
        } else {
            cancellableContinuationImpl = this.X2;
            Result.Companion companion2 = Result.X;
            o = JobSupportKt.o(T0);
        }
        cancellableContinuationImpl.w(Result.b(o));
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        X0((Throwable) obj);
        return Unit.f28779a;
    }
}
