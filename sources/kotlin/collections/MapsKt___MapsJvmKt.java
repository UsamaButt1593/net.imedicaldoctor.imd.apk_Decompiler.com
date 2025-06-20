package kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001ao\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001ap\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010\f\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\nj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`\u000bH\b¢\u0006\u0004\b\r\u0010\u000e\u001ao\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u000e\b\u0002\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00020\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0004\u0012\u00028\u00020\u0005H\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\t\u001ao\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000422\u0010\f\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00060\nj\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006`\u000bH\u0007¢\u0006\u0004\b\u0010\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"K", "V", "", "R", "", "Lkotlin/Function1;", "", "selector", "L0", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map$Entry;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "M0", "(Ljava/util/Map;Ljava/util/Comparator;)Ljava/util/Map$Entry;", "N0", "O0", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/MapsKt")
class MapsKt___MapsJvmKt extends MapsKt__MapsKt {
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> L0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        T t;
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            t = null;
        } else {
            T next = it2.next();
            if (!it2.hasNext()) {
                t = next;
            } else {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) < 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            t = next;
        }
        return (Map.Entry) t;
    }

    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @InlineOnly
    private static final /* synthetic */ <K, V> Map.Entry<K, V> M0(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.S3(map.entrySet(), comparator);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> N0(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        T t;
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<T> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            t = null;
        } else {
            T next = it2.next();
            if (!it2.hasNext()) {
                t = next;
            } else {
                Comparable comparable = (Comparable) function1.f(next);
                do {
                    T next2 = it2.next();
                    Comparable comparable2 = (Comparable) function1.f(next2);
                    if (comparable.compareTo(comparable2) > 0) {
                        next = next2;
                        comparable = comparable2;
                    }
                } while (it2.hasNext());
            }
            t = next;
        }
        return (Map.Entry) t;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Map.Entry O0(Map map, Comparator comparator) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (Map.Entry) CollectionsKt___CollectionsKt.k4(map.entrySet(), comparator);
    }
}
