package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/CompletableJob;", "Lkotlinx/coroutines/Job;", "", "c", "()Z", "", "exception", "k", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface CompletableJob extends Job {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R b(@NotNull CompletableJob completableJob, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.d(completableJob, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E c(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.e(completableJob, key);
        }

        @NotNull
        public static CoroutineContext d(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.g(completableJob, key);
        }

        @NotNull
        public static CoroutineContext e(@NotNull CompletableJob completableJob, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.h(completableJob, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job f(@NotNull CompletableJob completableJob, @NotNull Job job) {
            return Job.DefaultImpls.i(completableJob, job);
        }
    }

    boolean c();

    boolean k(@NotNull Throwable th);
}
