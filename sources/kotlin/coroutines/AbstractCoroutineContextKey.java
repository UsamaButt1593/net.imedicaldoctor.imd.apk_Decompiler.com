package kotlin.coroutines;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u0004\u0018\u00018\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\u0011\u0010\u0012R1\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlin/coroutines/CoroutineContext$Element;", "B", "E", "Lkotlin/coroutines/CoroutineContext$Key;", "baseKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "element", "safeCast", "<init>", "(Lkotlin/coroutines/CoroutineContext$Key;Lkotlin/jvm/functions/Function1;)V", "b", "(Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext$Element;", "key", "", "a", "(Lkotlin/coroutines/CoroutineContext$Key;)Z", "s", "Lkotlin/jvm/functions/Function1;", "X", "Lkotlin/coroutines/CoroutineContext$Key;", "topmostKey", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@ExperimentalStdlibApi
public abstract class AbstractCoroutineContextKey<B extends CoroutineContext.Element, E extends B> implements CoroutineContext.Key<E> {
    @NotNull
    private final CoroutineContext.Key<?> X;
    @NotNull
    private final Function1<CoroutineContext.Element, E> s;

    public AbstractCoroutineContextKey(@NotNull CoroutineContext.Key<B> key, @NotNull Function1<? super CoroutineContext.Element, ? extends E> function1) {
        Intrinsics.p(key, "baseKey");
        Intrinsics.p(function1, "safeCast");
        this.s = function1;
        this.X = key instanceof AbstractCoroutineContextKey ? ((AbstractCoroutineContextKey) key).X : key;
    }

    public final boolean a(@NotNull CoroutineContext.Key<?> key) {
        Intrinsics.p(key, "key");
        return key == this || this.X == key;
    }

    @Nullable
    public final E b(@NotNull CoroutineContext.Element element) {
        Intrinsics.p(element, "element");
        return (CoroutineContext.Element) this.s.f(element);
    }
}
