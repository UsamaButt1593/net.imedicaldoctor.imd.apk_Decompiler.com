package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0014\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0002*\u0004\u0018\u00018\u00008\u00000\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lcom/google/android/gms/tasks/Task;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/google/android/gms/tasks/Task;)V"}, k = 3, mv = {1, 6, 0})
final class TasksKt$awaitImpl$2$1<TResult> implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation<T> f29469a;

    TasksKt$awaitImpl$2$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.f29469a = cancellableContinuation;
    }

    public final void a(@NotNull Task<T> task) {
        Exception q = task.q();
        if (q != null) {
            CancellableContinuation<T> cancellableContinuation = this.f29469a;
            Result.Companion companion = Result.X;
            cancellableContinuation.w(Result.b(ResultKt.a(q)));
        } else if (task.t()) {
            CancellableContinuation.DefaultImpls.a(this.f29469a, (Throwable) null, 1, (Object) null);
        } else {
            CancellableContinuation<T> cancellableContinuation2 = this.f29469a;
            Result.Companion companion2 = Result.X;
            cancellableContinuation2.w(Result.b(task.r()));
        }
    }
}
