package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0005\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "K", "V", "k", "<anonymous parameter 1>", "d0", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
final class ConcurrentWeakMap$keys$1 extends Lambda implements Function2<K, V, K> {
    public static final ConcurrentWeakMap$keys$1 X = new ConcurrentWeakMap$keys$1();

    ConcurrentWeakMap$keys$1() {
        super(2);
    }

    @NotNull
    public final K d0(@NotNull K k2, @NotNull V v) {
        return k2;
    }
}
