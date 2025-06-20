package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.builders.MapBuilder;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a9\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001aP\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012#\u0010\u000b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001aX\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u000f\u001a\u00020\u000e2#\u0010\u000b\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0001¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bH\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u001d\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00192\u0006\u0010\u001a\u001a\u00028\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u001bH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aA\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 \"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b!\u0010\"\u001aG\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 \"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010$\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000#¢\u0006\u0004\b%\u0010&\u001a[\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 \"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u001f\"\u0004\b\u0001\u0010\u00012*\u0010(\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020'\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b)\u0010*\u001ac\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010 \"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010$\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000#2*\u0010(\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020'\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b+\u0010,\u001a \u0010/\u001a\u00020.*\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020-0\u0004H\b¢\u0006\u0004\b/\u00100\u001a8\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\b¢\u0006\u0004\b1\u0010\u0018\u001a9\u00102\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000¢\u0006\u0004\b2\u0010\u0018\u001a\u0017\u00104\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000eH\u0001¢\u0006\u0004\b4\u00105\"\u0014\u00108\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b6\u00107\u0002\u0007\n\u0005\b20\u0001¨\u00069"}, d2 = {"K", "V", "Lkotlin/Pair;", "pair", "", "k", "(Lkotlin/Pair;)Ljava/util/Map;", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "builderAction", "f", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "capacity", "e", "(ILkotlin/jvm/functions/Function1;)Ljava/util/Map;", "g", "()Ljava/util/Map;", "h", "(I)Ljava/util/Map;", "builder", "d", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/util/concurrent/ConcurrentMap;", "key", "Lkotlin/Function0;", "defaultValue", "i", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Ljava/util/SortedMap;", "q", "(Ljava/util/Map;)Ljava/util/SortedMap;", "Ljava/util/Comparator;", "comparator", "r", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/SortedMap;", "", "pairs", "m", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "l", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "Ljava/util/Properties;", "n", "(Ljava/util/Map;)Ljava/util/Properties;", "p", "o", "expectedSize", "j", "(I)I", "a", "I", "INT_MAX_POWER_OF_TWO", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/MapsKt")
@SourceDebugExtension({"SMAP\nMapsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapsJVM.kt\nkotlin/collections/MapsKt__MapsJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,157:1\n1#2:158\n*E\n"})
class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f28799a = 1073741824;

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> d(@NotNull Map<K, V> map) {
        Intrinsics.p(map, "builder");
        return ((MapBuilder) map).k();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> e(int i2, Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Map h2 = MapsKt.h(i2);
        function1.f(h2);
        return MapsKt.d(h2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> f(Function1<? super Map<K, V>, Unit> function1) {
        Intrinsics.p(function1, "builderAction");
        Map g2 = g();
        function1.f(g2);
        return MapsKt.d(g2);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static final <K, V> Map<K, V> g() {
        return new MapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> h(int i2) {
        return new MapBuilder(i2);
    }

    public static final <K, V> V i(@NotNull ConcurrentMap<K, V> concurrentMap, K k2, @NotNull Function0<? extends V> function0) {
        Intrinsics.p(concurrentMap, "<this>");
        Intrinsics.p(function0, "defaultValue");
        V v = concurrentMap.get(k2);
        if (v != null) {
            return v;
        }
        V o = function0.o();
        V putIfAbsent = concurrentMap.putIfAbsent(k2, o);
        return putIfAbsent == null ? o : putIfAbsent;
    }

    @PublishedApi
    public static int j(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static final <K, V> Map<K, V> k(@NotNull Pair<? extends K, ? extends V> pair) {
        Intrinsics.p(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.e(), pair.f());
        Intrinsics.o(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <K, V> SortedMap<K, V> l(@NotNull Comparator<? super K> comparator, @NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(pairArr, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        MapsKt__MapsKt.y0(treeMap, pairArr);
        return treeMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        Intrinsics.p(pairArr, "pairs");
        TreeMap treeMap = new TreeMap();
        MapsKt__MapsKt.y0(treeMap, pairArr);
        return treeMap;
    }

    @InlineOnly
    private static final Properties n(Map<String, String> map) {
        Intrinsics.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @NotNull
    public static final <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        Map.Entry next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.o(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return o(map);
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.p(map, "<this>");
        return new TreeMap(map);
    }

    @NotNull
    public static final <K, V> SortedMap<K, V> r(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
