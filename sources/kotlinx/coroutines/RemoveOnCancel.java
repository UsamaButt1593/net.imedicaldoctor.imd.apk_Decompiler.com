package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "node", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "", "cause", "", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class RemoveOnCancel extends BeforeResumeCancelHandler {
    @NotNull
    private final LockFreeLinkedListNode s;

    public RemoveOnCancel(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.s = lockFreeLinkedListNode;
    }

    public void b(@Nullable Throwable th) {
        this.s.Q0();
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }

    @NotNull
    public String toString() {
        return "RemoveOnCancel[" + this.s + ']';
    }
}
