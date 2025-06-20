package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a.\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\b\u001a4\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a4\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a.\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u000f\u0010\u0004\u001a.\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0010\u0010\u0004\u001a6\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\b\u001a4\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000b\u001a4\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000e\u001a.\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0014\u0010\u0004¨\u0006\u0015"}, d2 = {"T", "", "element", "y", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "", "elements", "A", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "x", "(Ljava/util/Set;Ljava/lang/Iterable;)Ljava/util/Set;", "Lkotlin/sequences/Sequence;", "z", "(Ljava/util/Set;Lkotlin/sequences/Sequence;)Ljava/util/Set;", "B", "D", "F", "C", "E", "G", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/SetsKt")
@SourceDebugExtension({"SMAP\n_Sets.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,139:1\n857#2,2:140\n847#2,2:142\n1#3:144\n*S KotlinDebug\n*F\n+ 1 _Sets.kt\nkotlin/collections/SetsKt___SetsKt\n*L\n28#1:140,2\n52#1:142,2\n*E\n"})
class SetsKt___SetsKt extends SetsKt__SetsKt {
    @NotNull
    public static final <T> Set<T> A(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.p(set, "<this>");
        Intrinsics.p(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.H0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> B(Set<? extends T> set, T t) {
        Intrinsics.p(set, "<this>");
        return y(set, t);
    }

    @NotNull
    public static <T> Set<T> C(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        int i2;
        Intrinsics.p(set, "<this>");
        Intrinsics.p(iterable, "elements");
        Integer Z = CollectionsKt__IterablesKt.Z(iterable);
        if (Z != null) {
            i2 = set.size() + Z.intValue();
        } else {
            i2 = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.j(i2));
        linkedHashSet.addAll(set);
        CollectionsKt.n0(linkedHashSet, iterable);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> D(@NotNull Set<? extends T> set, T t) {
        Intrinsics.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.j(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> E(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(set, "<this>");
        Intrinsics.p(sequence, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.j(set.size() * 2));
        linkedHashSet.addAll(set);
        CollectionsKt.o0(linkedHashSet, sequence);
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> F(@NotNull Set<? extends T> set, @NotNull T[] tArr) {
        Intrinsics.p(set, "<this>");
        Intrinsics.p(tArr, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.j(set.size() + tArr.length));
        linkedHashSet.addAll(set);
        CollectionsKt__MutableCollectionsKt.p0(linkedHashSet, tArr);
        return linkedHashSet;
    }

    @InlineOnly
    private static final <T> Set<T> G(Set<? extends T> set, T t) {
        Intrinsics.p(set, "<this>");
        return D(set, t);
    }

    @NotNull
    public static final <T> Set<T> x(@NotNull Set<? extends T> set, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(set, "<this>");
        Intrinsics.p(iterable, "elements");
        Collection<? extends T> q0 = CollectionsKt.q0(iterable);
        if (q0.isEmpty()) {
            return CollectionsKt.X5(set);
        }
        if (q0 instanceof Set) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (T next : set) {
                if (!q0.contains(next)) {
                    linkedHashSet.add(next);
                }
            }
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet(set);
        linkedHashSet2.removeAll(q0);
        return linkedHashSet2;
    }

    @NotNull
    public static final <T> Set<T> y(@NotNull Set<? extends T> set, T t) {
        Intrinsics.p(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt.j(set.size()));
        boolean z = false;
        for (T next : set) {
            boolean z2 = true;
            if (!z && Intrinsics.g(next, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(next);
            }
        }
        return linkedHashSet;
    }

    @NotNull
    public static final <T> Set<T> z(@NotNull Set<? extends T> set, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(set, "<this>");
        Intrinsics.p(sequence, "elements");
        LinkedHashSet linkedHashSet = new LinkedHashSet(set);
        CollectionsKt__MutableCollectionsKt.G0(linkedHashSet, sequence);
        return linkedHashSet;
    }
}
