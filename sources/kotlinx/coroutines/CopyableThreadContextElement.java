package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DelicateCoroutinesApi
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002J\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/CopyableThreadContextElement;", "S", "Lkotlinx/coroutines/ThreadContextElement;", "a0", "()Lkotlinx/coroutines/CopyableThreadContextElement;", "Lkotlin/coroutines/CoroutineContext$Element;", "overwritingElement", "Lkotlin/coroutines/CoroutineContext;", "u", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@ExperimentalCoroutinesApi
public interface CopyableThreadContextElement<S> extends ThreadContextElement<S> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <S, R> R a(@NotNull CopyableThreadContextElement<S> copyableThreadContextElement, R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return ThreadContextElement.DefaultImpls.a(copyableThreadContextElement, r, function2);
        }

        @Nullable
        public static <S, E extends CoroutineContext.Element> E b(@NotNull CopyableThreadContextElement<S> copyableThreadContextElement, @NotNull CoroutineContext.Key<E> key) {
            return ThreadContextElement.DefaultImpls.b(copyableThreadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext c(@NotNull CopyableThreadContextElement<S> copyableThreadContextElement, @NotNull CoroutineContext.Key<?> key) {
            return ThreadContextElement.DefaultImpls.c(copyableThreadContextElement, key);
        }

        @NotNull
        public static <S> CoroutineContext d(@NotNull CopyableThreadContextElement<S> copyableThreadContextElement, @NotNull CoroutineContext coroutineContext) {
            return ThreadContextElement.DefaultImpls.d(copyableThreadContextElement, coroutineContext);
        }
    }

    @NotNull
    CopyableThreadContextElement<S> a0();

    @NotNull
    CoroutineContext u(@NotNull CoroutineContext.Element element);
}
