package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010&\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"K", "V", "", "it", "", "b", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 9, 0})
final class AbstractMap$toString$1 extends Lambda implements Function1<Map.Entry<? extends K, ? extends V>, CharSequence> {
    final /* synthetic */ AbstractMap<K, V> X;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractMap$toString$1(AbstractMap<K, ? extends V> abstractMap) {
        super(1);
        this.X = abstractMap;
    }

    @NotNull
    /* renamed from: b */
    public final CharSequence f(@NotNull Map.Entry<? extends K, ? extends V> entry) {
        Intrinsics.p(entry, "it");
        return this.X.j(entry);
    }
}
