package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CompletableDeferred;", "T", "Lkotlinx/coroutines/Deferred;", "value", "", "e0", "(Ljava/lang/Object;)Z", "", "exception", "k", "(Ljava/lang/Throwable;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface CompletableDeferred<T> extends Deferred<T> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <T, R> R b(@NotNull CompletableDeferred<T> completableDeferred, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return Deferred.DefaultImpls.b(completableDeferred, r, function2);
        }

        @Nullable
        public static <T, E extends CoroutineContext.Element> E c(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext.Key<E> key) {
            return Deferred.DefaultImpls.c(completableDeferred, key);
        }

        @NotNull
        public static <T> CoroutineContext d(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext.Key<?> key) {
            return Deferred.DefaultImpls.d(completableDeferred, key);
        }

        @NotNull
        public static <T> CoroutineContext e(@NotNull CompletableDeferred<T> completableDeferred, @NotNull CoroutineContext coroutineContext) {
            return Deferred.DefaultImpls.e(completableDeferred, coroutineContext);
        }

        @NotNull
        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static <T> Job f(@NotNull CompletableDeferred<T> completableDeferred, @NotNull Job job) {
            return Deferred.DefaultImpls.f(completableDeferred, job);
        }
    }

    boolean e0(T t);

    boolean k(@NotNull Throwable th);
}
