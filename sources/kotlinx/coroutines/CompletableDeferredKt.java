package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\n\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"T", "Lkotlinx/coroutines/CompletableDeferred;", "Lkotlin/Result;", "result", "", "d", "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/Job;", "parent", "b", "(Lkotlinx/coroutines/Job;)Lkotlinx/coroutines/CompletableDeferred;", "value", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class CompletableDeferredKt {
    @NotNull
    public static final <T> CompletableDeferred<T> a(T t) {
        CompletableDeferredImpl completableDeferredImpl = new CompletableDeferredImpl((Job) null);
        completableDeferredImpl.e0(t);
        return completableDeferredImpl;
    }

    @NotNull
    public static final <T> CompletableDeferred<T> b(@Nullable Job job) {
        return new CompletableDeferredImpl(job);
    }

    public static /* synthetic */ CompletableDeferred c(Job job, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            job = null;
        }
        return b(job);
    }

    public static final <T> boolean d(@NotNull CompletableDeferred<T> completableDeferred, @NotNull Object obj) {
        Throwable e2 = Result.e(obj);
        return e2 == null ? completableDeferred.e0(obj) : completableDeferred.k(e2);
    }
}
