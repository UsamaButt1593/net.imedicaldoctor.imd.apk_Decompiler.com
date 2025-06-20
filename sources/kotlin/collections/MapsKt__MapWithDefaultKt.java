package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\u001a3\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001aX\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\n\u0010\u000b\u001aZ\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\f2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006H\u0007¢\u0006\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"K", "V", "", "key", "a", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "defaultValue", "b", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "", "c", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/MapsKt")
@SourceDebugExtension({"SMAP\nMapWithDefault.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,104:1\n341#2,6:105\n*S KotlinDebug\n*F\n+ 1 MapWithDefault.kt\nkotlin/collections/MapsKt__MapWithDefaultKt\n*L\n24#1:105,6\n*E\n"})
class MapsKt__MapWithDefaultKt {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V a(@NotNull Map<K, ? extends V> map, K k2) {
        Intrinsics.p(map, "<this>");
        if (map instanceof MapWithDefault) {
            return ((MapWithDefault) map).q0(k2);
        }
        V v = map.get(k2);
        if (v != null || map.containsKey(k2)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k2 + " is missing in the map.");
    }

    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "defaultValue");
        return map instanceof MapWithDefault ? b(((MapWithDefault) map).x(), function1) : new MapWithDefaultImpl(map, function1);
    }

    @NotNull
    @JvmName(name = "withDefaultMutable")
    public static final <K, V> Map<K, V> c(@NotNull Map<K, V> map, @NotNull Function1<? super K, ? extends V> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "defaultValue");
        return map instanceof MutableMapWithDefault ? c(((MutableMapWithDefault) map).x(), function1) : new MutableMapWithDefaultImpl(map, function1);
    }
}
