package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty1;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00028\u0000H\n¢\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\n¢\u0006\u0004\b\u000f\u0010\u0010\u001aH\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"V", "Lkotlin/reflect/KProperty0;", "", "thisRef", "Lkotlin/reflect/KProperty;", "property", "a", "(Lkotlin/reflect/KProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/reflect/KMutableProperty0;", "value", "", "c", "(Lkotlin/reflect/KMutableProperty0;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "T", "Lkotlin/reflect/KProperty1;", "b", "(Lkotlin/reflect/KProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "Lkotlin/reflect/KMutableProperty1;", "d", "(Lkotlin/reflect/KMutableProperty1;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
public final class PropertyReferenceDelegatesKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> V a(KProperty0<? extends V> kProperty0, Object obj, KProperty<?> kProperty) {
        Intrinsics.p(kProperty0, "<this>");
        Intrinsics.p(kProperty, "property");
        return kProperty0.get();
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> V b(KProperty1<T, ? extends V> kProperty1, T t, KProperty<?> kProperty) {
        Intrinsics.p(kProperty1, "<this>");
        Intrinsics.p(kProperty, "property");
        return kProperty1.get(t);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> void c(KMutableProperty0<V> kMutableProperty0, Object obj, KProperty<?> kProperty, V v) {
        Intrinsics.p(kMutableProperty0, "<this>");
        Intrinsics.p(kProperty, "property");
        kMutableProperty0.set(v);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> void d(KMutableProperty1<T, V> kMutableProperty1, T t, KProperty<?> kProperty, V v) {
        Intrinsics.p(kMutableProperty1, "<this>");
        Intrinsics.p(kProperty, "property");
        kMutableProperty1.Y(t, v);
    }
}
