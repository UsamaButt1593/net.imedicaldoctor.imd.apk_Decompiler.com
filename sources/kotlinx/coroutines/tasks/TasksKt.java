package kotlinx.coroutines.tasks;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a/\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\n\u001a#\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"T", "Lkotlinx/coroutines/Deferred;", "Lcom/google/android/gms/tasks/Task;", "g", "(Lkotlinx/coroutines/Deferred;)Lcom/google/android/gms/tasks/Task;", "c", "(Lcom/google/android/gms/tasks/Task;)Lkotlinx/coroutines/Deferred;", "Lcom/google/android/gms/tasks/CancellationTokenSource;", "cancellationTokenSource", "d", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;)Lkotlinx/coroutines/Deferred;", "e", "i", "(Lcom/google/android/gms/tasks/Task;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "h", "(Lcom/google/android/gms/tasks/Task;Lcom/google/android/gms/tasks/CancellationTokenSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "j", "kotlinx-coroutines-play-services"}, k = 2, mv = {1, 6, 0})
public final class TasksKt {
    @NotNull
    public static final <T> Deferred<T> c(@NotNull Task<T> task) {
        return e(task, (CancellationTokenSource) null);
    }

    @NotNull
    @ExperimentalCoroutinesApi
    public static final <T> Deferred<T> d(@NotNull Task<T> task, @NotNull CancellationTokenSource cancellationTokenSource) {
        return e(task, cancellationTokenSource);
    }

    private static final <T> Deferred<T> e(Task<T> task, CancellationTokenSource cancellationTokenSource) {
        CompletableDeferred c2 = CompletableDeferredKt.c((Job) null, 1, (Object) null);
        if (task.u()) {
            Exception q = task.q();
            if (q != null) {
                c2.k(q);
            } else if (task.t()) {
                Job.DefaultImpls.b(c2, (CancellationException) null, 1, (Object) null);
            } else {
                c2.e0(task.r());
            }
        } else {
            task.f(DirectExecutor.s, new a(c2));
        }
        if (cancellationTokenSource != null) {
            c2.Z(new TasksKt$asDeferredImpl$2(cancellationTokenSource));
        }
        return new TasksKt$asDeferredImpl$3(c2);
    }

    /* access modifiers changed from: private */
    public static final void f(CompletableDeferred completableDeferred, Task task) {
        Exception q = task.q();
        if (q != null) {
            completableDeferred.k(q);
        } else if (task.t()) {
            Job.DefaultImpls.b(completableDeferred, (CancellationException) null, 1, (Object) null);
        } else {
            completableDeferred.e0(task.r());
        }
    }

    @NotNull
    public static final <T> Task<T> g(@NotNull Deferred<? extends T> deferred) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.b());
        deferred.Z(new TasksKt$asTask$1(cancellationTokenSource, deferred, taskCompletionSource));
        return taskCompletionSource.a();
    }

    @Nullable
    @ExperimentalCoroutinesApi
    public static final <T> Object h(@NotNull Task<T> task, @NotNull CancellationTokenSource cancellationTokenSource, @NotNull Continuation<? super T> continuation) {
        return j(task, cancellationTokenSource, continuation);
    }

    @Nullable
    public static final <T> Object i(@NotNull Task<T> task, @NotNull Continuation<? super T> continuation) {
        return j(task, (CancellationTokenSource) null, continuation);
    }

    /* access modifiers changed from: private */
    public static final <T> Object j(Task<T> task, CancellationTokenSource cancellationTokenSource, Continuation<? super T> continuation) {
        if (task.u()) {
            Exception q = task.q();
            if (q != null) {
                throw q;
            } else if (!task.t()) {
                return task.r();
            } else {
                throw new CancellationException("Task " + task + " was cancelled normally.");
            }
        } else {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.e(continuation), 1);
            cancellableContinuationImpl.W();
            task.f(DirectExecutor.s, new TasksKt$awaitImpl$2$1(cancellableContinuationImpl));
            if (cancellationTokenSource != null) {
                cancellableContinuationImpl.M(new TasksKt$awaitImpl$2$2(cancellationTokenSource));
            }
            Object y = cancellableContinuationImpl.y();
            if (y == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            return y;
        }
    }
}
