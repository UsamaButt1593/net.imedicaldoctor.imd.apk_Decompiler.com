package kotlin.collections.jdk8;

import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aC\u0010\u0006\u001a\u00028\u0001\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000\"\u0004\b\u0001\u0010\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aJ\u0010\u000b\u001a\u00020\n\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000\"\t\b\u0001\u0010\u0002¢\u0006\u0002\b\u0000*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", "K", "V", "", "key", "defaultValue", "a", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "value", "", "b", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "CollectionsJDK8Kt")
public final class CollectionsJDK8Kt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> V a(Map<? extends K, ? extends V> map, K k2, V v) {
        Intrinsics.p(map, "<this>");
        return map.getOrDefault(k2, v);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <K, V> boolean b(Map<? extends K, ? extends V> map, K k2, V v) {
        Intrinsics.p(map, "<this>");
        return TypeIntrinsics.k(map).remove(k2, v);
    }
}
