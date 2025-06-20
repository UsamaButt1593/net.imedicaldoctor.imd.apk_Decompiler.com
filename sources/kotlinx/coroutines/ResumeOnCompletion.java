package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "", "cause", "X0", "(Ljava/lang/Throwable;)V", "X2", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class ResumeOnCompletion extends JobNode {
    @NotNull
    private final Continuation<Unit> X2;

    public ResumeOnCompletion(@NotNull Continuation<? super Unit> continuation) {
        this.X2 = continuation;
    }

    public void X0(@Nullable Throwable th) {
        Continuation<Unit> continuation = this.X2;
        Result.Companion companion = Result.X;
        continuation.w(Result.b(Unit.f28779a));
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        X0((Throwable) obj);
        return Unit.f28779a;
    }
}
