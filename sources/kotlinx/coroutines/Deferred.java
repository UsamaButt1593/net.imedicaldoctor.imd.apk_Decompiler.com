package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H'¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\n8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/Deferred;", "T", "Lkotlinx/coroutines/Job;", "J", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "s", "()Ljava/lang/Object;", "", "A", "()Ljava/lang/Throwable;", "Lkotlinx/coroutines/selects/SelectClause1;", "x", "()Lkotlinx/coroutines/selects/SelectClause1;", "onAwait", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface Deferred<T> extends Job {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T, R> R b(@NotNull Deferred<? extends T> deferred, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Job.DefaultImpls.d(deferred, r, function2);
        }

        @Nullable
        public static <T, E extends CoroutineContext.Element> E c(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext.Key<E> key) {
            return Job.DefaultImpls.e(deferred, key);
        }

        @NotNull
        public static <T> CoroutineContext d(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext.Key<?> key) {
            return Job.DefaultImpls.g(deferred, key);
        }

        @NotNull
        public static <T> CoroutineContext e(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
            return Job.DefaultImpls.h(deferred, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> Job f(@NotNull Deferred<? extends T> deferred, @NotNull Job job) {
            return Job.DefaultImpls.i(deferred, job);
        }
    }

    @Nullable
    @ExperimentalCoroutinesApi
    Throwable A();

    @Nullable
    Object J(@NotNull Continuation<? super T> continuation);

    @ExperimentalCoroutinesApi
    T s();

    @NotNull
    SelectClause1<T> x();
}
