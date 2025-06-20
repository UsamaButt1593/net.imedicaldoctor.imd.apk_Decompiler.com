package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "b", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
final class TasksKt$asTask$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellationTokenSource X;
    final /* synthetic */ Deferred<T> Y;
    final /* synthetic */ TaskCompletionSource<T> Z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TasksKt$asTask$1(CancellationTokenSource cancellationTokenSource, Deferred<? extends T> deferred, TaskCompletionSource<T> taskCompletionSource) {
        super(1);
        this.X = cancellationTokenSource;
        this.Y = deferred;
        this.Z = taskCompletionSource;
    }

    public final void b(@Nullable Throwable th) {
        if (th instanceof CancellationException) {
            this.X.a();
            return;
        }
        Throwable A = this.Y.A();
        if (A == null) {
            this.Z.c(this.Y.s());
            return;
        }
        TaskCompletionSource<T> taskCompletionSource = this.Z;
        Exception exc = A instanceof Exception ? (Exception) A : null;
        if (exc == null) {
            exc = new RuntimeExecutionException(A);
        }
        taskCompletionSource.b(exc);
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        b((Throwable) obj);
        return Unit.f28779a;
    }
}
