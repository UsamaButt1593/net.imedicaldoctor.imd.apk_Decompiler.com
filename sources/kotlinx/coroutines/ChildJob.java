package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ParentJob;", "parentJob", "", "L", "(Lkotlinx/coroutines/ParentJob;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
public interface ChildJob extends Job {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R b(@NotNull ChildJob childJob, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.d(childJob, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E c(@NotNull ChildJob childJob, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.e(childJob, key);
        }

        @NotNull
        public static CoroutineContext d(@NotNull ChildJob childJob, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.g(childJob, key);
        }

        @NotNull
        public static CoroutineContext e(@NotNull ChildJob childJob, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.h(childJob, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job f(@NotNull ChildJob childJob, @NotNull Job job) {
            return Job.DefaultImpls.i(childJob, job);
        }
    }

    @InternalCoroutinesApi
    void L(@NotNull ParentJob parentJob);
}
