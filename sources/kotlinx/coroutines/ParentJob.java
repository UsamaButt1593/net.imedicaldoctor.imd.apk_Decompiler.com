package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "h0", "()Ljava/util/concurrent/CancellationException;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
public interface ParentJob extends Job {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R b(@NotNull ParentJob parentJob, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.d(parentJob, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E c(@NotNull ParentJob parentJob, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.e(parentJob, key);
        }

        @NotNull
        public static CoroutineContext d(@NotNull ParentJob parentJob, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.g(parentJob, key);
        }

        @NotNull
        public static CoroutineContext e(@NotNull ParentJob parentJob, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.h(parentJob, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job f(@NotNull ParentJob parentJob, @NotNull Job job) {
            return Job.DefaultImpls.i(parentJob, job);
        }
    }

    @NotNull
    @InternalCoroutinesApi
    CancellationException h0();
}
