package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/UndispatchedMarker;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext$Key;", "()V", "key", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class UndispatchedMarker implements CoroutineContext.Element, CoroutineContext.Key<UndispatchedMarker> {
    @NotNull
    public static final UndispatchedMarker s = new UndispatchedMarker();

    private UndispatchedMarker() {
    }

    @Nullable
    public <E extends CoroutineContext.Element> E e(@NotNull CoroutineContext.Key<E> key) {
        return CoroutineContext.Element.DefaultImpls.b(this, key);
    }

    @NotNull
    public CoroutineContext f(@NotNull CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.c(this, key);
    }

    @NotNull
    public CoroutineContext.Key<?> getKey() {
        return this;
    }

    public <R> R n(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.a(this, r, function2);
    }

    @NotNull
    public CoroutineContext v(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.d(this, coroutineContext);
    }
}
