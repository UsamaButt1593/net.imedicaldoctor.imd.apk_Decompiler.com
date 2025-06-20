package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/ThreadContextElement;", "S", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "context", "k0", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/Object;", "oldState", "", "c0", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface ThreadContextElement<S> extends CoroutineContext.Element {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <S, R> R a(@NotNull ThreadContextElement<S> threadContextElement, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return CoroutineContext.Element.DefaultImpls.a(threadContextElement, r, function2);
        }

        @Nullable
        public static <S, E extends CoroutineContext.Element> E b(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext.Key<E> key) {
            return CoroutineContext.Element.DefaultImpls.b(threadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext c(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(threadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext d(@NotNull ThreadContextElement<S> threadContextElement, @NotNull CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(threadContextElement, coroutineContext);
        }
    }

    void c0(@NotNull CoroutineContext coroutineContext, S s);

    S k0(@NotNull CoroutineContext coroutineContext);
}
