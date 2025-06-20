package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0004\u001a7\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001aa\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\t\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0007\"\u0004\b\u0002\u0010\b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u001e\u0010\f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0004\u0012\u00028\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000f"}, d2 = {"T", "K", "Lkotlin/collections/Grouping;", "", "", "a", "(Lkotlin/collections/Grouping;)Ljava/util/Map;", "V", "R", "", "Lkotlin/Function1;", "", "f", "b", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/GroupingKt")
@SourceDebugExtension({"SMAP\nGroupingJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n+ 2 Grouping.kt\nkotlin/collections/GroupingKt__GroupingKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,52:1\n143#2:53\n80#2,4:54\n85#2:59\n1#3:58\n1855#4,2:60\n*S KotlinDebug\n*F\n+ 1 GroupingJVM.kt\nkotlin/collections/GroupingKt__GroupingJVMKt\n*L\n22#1:53\n22#1:54,4\n22#1:59\n48#1:60,2\n*E\n"})
class GroupingKt__GroupingJVMKt {
    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T, K> Map<K, Integer> a(@NotNull Grouping<T, ? extends K> grouping) {
        Intrinsics.p(grouping, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b2 = grouping.b();
        while (b2.hasNext()) {
            Object a2 = grouping.a(b2.next());
            Object obj = linkedHashMap.get(a2);
            if (obj == null && !linkedHashMap.containsKey(a2)) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.s++;
            linkedHashMap.put(a2, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Intrinsics.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            TypeIntrinsics.m(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).s));
        }
        return TypeIntrinsics.k(linkedHashMap);
    }

    @PublishedApi
    @InlineOnly
    private static final <K, V, R> Map<K, R> b(Map<K, V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.p(map, "<this>");
        Intrinsics.p(function1, "f");
        for (Map.Entry entry : map.entrySet()) {
            Intrinsics.n(entry, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace$lambda$4>");
            TypeIntrinsics.m(entry).setValue(function1.f(entry));
        }
        return TypeIntrinsics.k(map);
    }
}
