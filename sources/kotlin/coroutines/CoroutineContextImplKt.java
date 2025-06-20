package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext$Element;", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "key", "a", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "b", "(Lkotlin/coroutines/CoroutineContext$Element;Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class CoroutineContextImplKt {
    @SinceKotlin(version = "1.3")
    @Nullable
    @ExperimentalStdlibApi
    public static final <E extends CoroutineContext.Element> E a(@NotNull CoroutineContext.Element element, @NotNull CoroutineContext.Key<E> key) {
        Intrinsics.p(element, "<this>");
        Intrinsics.p(key, "key");
        if (key instanceof AbstractCoroutineContextKey) {
            AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
            if (!abstractCoroutineContextKey.a(element.getKey())) {
                return null;
            }
            E b2 = abstractCoroutineContextKey.b(element);
            if (b2 instanceof CoroutineContext.Element) {
                return b2;
            }
            return null;
        } else if (element.getKey() == key) {
            return element;
        } else {
            return null;
        }
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    @ExperimentalStdlibApi
    public static final CoroutineContext b(@NotNull CoroutineContext.Element element, @NotNull CoroutineContext.Key<?> key) {
        Intrinsics.p(element, "<this>");
        Intrinsics.p(key, "key");
        if (!(key instanceof AbstractCoroutineContextKey)) {
            return element.getKey() == key ? EmptyCoroutineContext.s : element;
        }
        AbstractCoroutineContextKey abstractCoroutineContextKey = (AbstractCoroutineContextKey) key;
        return (!abstractCoroutineContextKey.a(element.getKey()) || abstractCoroutineContextKey.b(element) == null) ? element : EmptyCoroutineContext.s;
    }
}
