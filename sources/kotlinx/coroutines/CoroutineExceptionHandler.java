package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \t2\u00020\u0001:\u0001\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "j0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Throwable;)V", "O2", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface CoroutineExceptionHandler extends CoroutineContext.Element {
    @NotNull
    public static final Key O2 = Key.s;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R> R a(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.a(coroutineExceptionHandler, r, function2);
        }

        @Nullable
        public static <E extends CoroutineContext.Element> E b(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.b(coroutineExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext c(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(coroutineExceptionHandler, key);
        }

        @NotNull
        public static CoroutineContext d(@NotNull CoroutineExceptionHandler coroutineExceptionHandler, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(coroutineExceptionHandler, coroutineContext);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {
        static final /* synthetic */ Key s = new Key();

        private Key() {
        }
    }

    void j0(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th);
}
