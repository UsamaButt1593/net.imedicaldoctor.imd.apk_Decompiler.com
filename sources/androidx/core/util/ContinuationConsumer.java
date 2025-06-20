package androidx.core.util;

import androidx.annotation.RequiresApi;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;

@RequiresApi(24)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/core/util/ContinuationConsumer;", "T", "Ljava/util/function/Consumer;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlin/coroutines/Continuation;)V", "value", "", "accept", "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/coroutines/Continuation;", "core-ktx_release"}, k = 1, mv = {1, 8, 0})
final class ContinuationConsumer<T> extends AtomicBoolean implements Consumer<T> {
    @NotNull
    private final Continuation<T> s;

    public ContinuationConsumer(@NotNull Continuation<? super T> continuation) {
        super(false);
        this.s = continuation;
    }

    public void accept(T t) {
        if (compareAndSet(false, true)) {
            Continuation<T> continuation = this.s;
            Result.Companion companion = Result.X;
            continuation.w(Result.b(t));
        }
    }

    @NotNull
    public String toString() {
        return "ContinuationConsumer(resultAccepted = " + get() + ASCIIPropertyListParser.f18650h;
    }
}
