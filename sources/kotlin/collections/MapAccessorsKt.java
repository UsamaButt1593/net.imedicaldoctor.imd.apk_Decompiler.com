package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00040\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u000b\b\u0001\u0012\u00078\u0000¢\u0006\u0002\b\u00040\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\n¢\u0006\u0004\b\f\u0010\n\u001aH\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\r\u001a\u00028\u0000H\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"V", "V1", "", "", "Lkotlin/internal/Exact;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "", "b", "value", "", "c", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "MapAccessorsKt")
public final class MapAccessorsKt {
    @InlineOnly
    private static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(kProperty, "property");
        return MapsKt__MapWithDefaultKt.a(map, kProperty.getName());
    }

    @InlineOnly
    @JvmName(name = "getVar")
    private static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, KProperty<?> kProperty) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(kProperty, "property");
        return MapsKt__MapWithDefaultKt.a(map, kProperty.getName());
    }

    @InlineOnly
    private static final <V> void c(Map<? super String, ? super V> map, Object obj, KProperty<?> kProperty, V v) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(kProperty, "property");
        map.put(kProperty.getName(), v);
    }
}
