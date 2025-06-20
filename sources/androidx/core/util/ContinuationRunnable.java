package androidx.core.util;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/core/util/ContinuationRunnable;", "Ljava/lang/Runnable;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/coroutines/Continuation;", "", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "run", "()V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/Continuation;", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
final class ContinuationRunnable extends AtomicBoolean implements Runnable {
    @NotNull
    private final Continuation<Unit> s;

    public ContinuationRunnable(@NotNull Continuation<? super Unit> continuation) {
        super(false);
        this.s = continuation;
    }

    public void run() {
        if (compareAndSet(false, true)) {
            Continuation<Unit> continuation = this.s;
            Result.Companion companion = Result.X;
            continuation.w(Result.b(Unit.f28779a));
        }
    }

    @NotNull
    public String toString() {
        return "ContinuationRunnable(ran = " + get() + ASCIIPropertyListParser.f18650h;
    }
}
