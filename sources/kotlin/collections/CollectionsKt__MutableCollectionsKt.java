package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u001d\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u000e\u001a/\u0010\u0005\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\t\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\b¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u000b\u001a\u00020\u0004\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\b¢\u0006\u0004\b\u000b\u0010\n\u001a*\u0010\r\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u0010\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a0\u0010\u0013\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\n¢\u0006\u0004\b\u0013\u0010\u0014\u001a0\u0010\u0016\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\n¢\u0006\u0004\b\u0016\u0010\u0017\u001a*\u0010\u0018\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0018\u0010\u000e\u001a0\u0010\u0019\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\n¢\u0006\u0004\b\u0019\u0010\u0011\u001a0\u0010\u001a\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\n¢\u0006\u0004\b\u001a\u0010\u0014\u001a0\u0010\u001b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\n¢\u0006\u0004\b\u001b\u0010\u0017\u001a-\u0010\u001c\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u001e\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b\u001e\u0010\u001f\u001a/\u0010 \u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0012¢\u0006\u0004\b \u0010!\u001a%\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0000¢\u0006\u0004\b\"\u0010#\u001a-\u0010$\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b$\u0010\u001d\u001a-\u0010%\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b%\u0010\u001f\u001a/\u0010&\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0012¢\u0006\u0004\b&\u0010!\u001a-\u0010'\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b'\u0010\u001d\u001a/\u0010(\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0012¢\u0006\u0004\b(\u0010!\u001a-\u0010)\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015¢\u0006\u0004\b)\u0010\u001f\u001a\u0017\u0010*\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0002H\u0002¢\u0006\u0004\b*\u0010+\u001a1\u0010/\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b/\u00100\u001a1\u00101\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b1\u00100\u001a;\u00103\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000,2\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-2\u0006\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\b3\u00104\u001a(\u00108\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u0000052\u0006\u00107\u001a\u000206H\b¢\u0006\u0004\b8\u00109\u001a\u001f\u0010:\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000005H\u0007¢\u0006\u0004\b:\u0010;\u001a!\u0010<\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000005H\u0007¢\u0006\u0004\b<\u0010;\u001a\u001f\u0010=\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000005H\u0007¢\u0006\u0004\b=\u0010;\u001a!\u0010>\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u000005H\u0007¢\u0006\u0004\b>\u0010;\u001a1\u0010?\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u0000052\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\b?\u0010@\u001a1\u0010A\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u0000052\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0004\bA\u0010@\u001a;\u0010B\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u0000052\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040-2\u0006\u00102\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u0010C¨\u0006D"}, d2 = {"Lkotlin/internal/OnlyInputTypes;", "T", "", "element", "", "C0", "(Ljava/util/Collection;Ljava/lang/Object;)Z", "", "elements", "F0", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "P0", "", "y0", "(Ljava/util/Collection;Ljava/lang/Object;)V", "", "x0", "(Ljava/util/Collection;Ljava/lang/Iterable;)V", "", "A0", "(Ljava/util/Collection;[Ljava/lang/Object;)V", "Lkotlin/sequences/Sequence;", "z0", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)V", "u0", "t0", "w0", "v0", "n0", "(Ljava/util/Collection;Ljava/lang/Iterable;)Z", "o0", "(Ljava/util/Collection;Lkotlin/sequences/Sequence;)Z", "p0", "(Ljava/util/Collection;[Ljava/lang/Object;)Z", "q0", "(Ljava/lang/Iterable;)Ljava/util/Collection;", "E0", "G0", "H0", "O0", "R0", "Q0", "T0", "(Ljava/util/Collection;)Z", "", "Lkotlin/Function1;", "predicate", "D0", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Z", "N0", "predicateResultToRemove", "r0", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;Z)Z", "", "", "index", "B0", "(Ljava/util/List;I)Ljava/lang/Object;", "J0", "(Ljava/util/List;)Ljava/lang/Object;", "K0", "L0", "M0", "I0", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Z", "S0", "s0", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Z)Z", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    @InlineOnly
    private static final <T> void A0(Collection<? super T> collection, T[] tArr) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(tArr, "elements");
        p0(collection, tArr);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use removeAt(index) instead.", replaceWith = @ReplaceWith(expression = "removeAt(index)", imports = {}))
    @InlineOnly
    private static final <T> T B0(List<T> list, int i2) {
        Intrinsics.p(list, "<this>");
        return list.remove(i2);
    }

    @InlineOnly
    private static final <T> boolean C0(Collection<? extends T> collection, T t) {
        Intrinsics.p(collection, "<this>");
        return TypeIntrinsics.a(collection).remove(t);
    }

    public static final <T> boolean D0(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "predicate");
        return r0(iterable, function1, true);
    }

    public static final <T> boolean E0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(iterable, "elements");
        return collection.removeAll(CollectionsKt.q0(iterable));
    }

    @InlineOnly
    private static final <T> boolean F0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(collection2, "elements");
        return TypeIntrinsics.a(collection).removeAll(collection2);
    }

    public static final <T> boolean G0(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(sequence, "elements");
        List<? extends T> c3 = SequencesKt.c3(sequence);
        return (c3.isEmpty() ^ true) && collection.removeAll(c3);
    }

    public static final <T> boolean H0(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(tArr, "elements");
        return ((tArr.length == 0) ^ true) && collection.removeAll(ArraysKt.t(tArr));
    }

    public static final <T> boolean I0(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(function1, "predicate");
        return s0(list, function1, true);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T J0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T> T K0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(0);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T L0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt.G(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    @SinceKotlin(version = "1.4")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static <T> T M0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt.G(list));
    }

    public static <T> boolean N0(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "predicate");
        return r0(iterable, function1, false);
    }

    public static final <T> boolean O0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(iterable, "elements");
        return collection.retainAll(CollectionsKt.q0(iterable));
    }

    @InlineOnly
    private static final <T> boolean P0(Collection<? extends T> collection, Collection<? extends T> collection2) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(collection2, "elements");
        return TypeIntrinsics.a(collection).retainAll(collection2);
    }

    public static final <T> boolean Q0(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(sequence, "elements");
        List<? extends T> c3 = SequencesKt.c3(sequence);
        return c3.isEmpty() ^ true ? collection.retainAll(c3) : T0(collection);
    }

    public static final <T> boolean R0(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(tArr, "elements");
        return (tArr.length == 0) ^ true ? collection.retainAll(ArraysKt.t(tArr)) : T0(collection);
    }

    public static final <T> boolean S0(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(function1, "predicate");
        return s0(list, function1, false);
    }

    private static final boolean T0(Collection<?> collection) {
        boolean z = !collection.isEmpty();
        collection.clear();
        return z;
    }

    public static <T> boolean n0(@NotNull Collection<? super T> collection, @NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static <T> boolean o0(@NotNull Collection<? super T> collection, @NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(sequence, "elements");
        boolean z = false;
        for (Object add : sequence) {
            if (collection.add(add)) {
                z = true;
            }
        }
        return z;
    }

    public static final <T> boolean p0(@NotNull Collection<? super T> collection, @NotNull T[] tArr) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(tArr, "elements");
        return collection.addAll(ArraysKt.t(tArr));
    }

    @NotNull
    public static <T> Collection<T> q0(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(iterable, "<this>");
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt.S5(iterable);
    }

    private static final <T> boolean r0(Iterable<? extends T> iterable, Function1<? super T, Boolean> function1, boolean z) {
        Iterator<? extends T> it2 = iterable.iterator();
        boolean z2 = false;
        while (it2.hasNext()) {
            if (function1.f(it2.next()).booleanValue() == z) {
                it2.remove();
                z2 = true;
            }
        }
        return z2;
    }

    private static final <T> boolean s0(List<T> list, Function1<? super T, Boolean> function1, boolean z) {
        if (!(list instanceof RandomAccess)) {
            Intrinsics.n(list, "null cannot be cast to non-null type kotlin.collections.MutableIterable<T of kotlin.collections.CollectionsKt__MutableCollectionsKt.filterInPlace>");
            return r0(TypeIntrinsics.c(list), function1, z);
        }
        IntIterator n2 = new IntRange(0, CollectionsKt.G(list)).iterator();
        int i2 = 0;
        while (n2.hasNext()) {
            int b2 = n2.b();
            T t = list.get(b2);
            if (function1.f(t).booleanValue() != z) {
                if (i2 != b2) {
                    list.set(i2, t);
                }
                i2++;
            }
        }
        if (i2 >= list.size()) {
            return false;
        }
        int G = CollectionsKt.G(list);
        if (i2 > G) {
            return true;
        }
        while (true) {
            list.remove(G);
            if (G == i2) {
                return true;
            }
            G--;
        }
    }

    @InlineOnly
    private static final <T> void t0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(iterable, "elements");
        E0(collection, iterable);
    }

    @InlineOnly
    private static final <T> void u0(Collection<? super T> collection, T t) {
        Intrinsics.p(collection, "<this>");
        collection.remove(t);
    }

    @InlineOnly
    private static final <T> void v0(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(sequence, "elements");
        G0(collection, sequence);
    }

    @InlineOnly
    private static final <T> void w0(Collection<? super T> collection, T[] tArr) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(tArr, "elements");
        H0(collection, tArr);
    }

    @InlineOnly
    private static final <T> void x0(Collection<? super T> collection, Iterable<? extends T> iterable) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(iterable, "elements");
        CollectionsKt.n0(collection, iterable);
    }

    @InlineOnly
    private static final <T> void y0(Collection<? super T> collection, T t) {
        Intrinsics.p(collection, "<this>");
        collection.add(t);
    }

    @InlineOnly
    private static final <T> void z0(Collection<? super T> collection, Sequence<? extends T> sequence) {
        Intrinsics.p(collection, "<this>");
        Intrinsics.p(sequence, "elements");
        CollectionsKt.o0(collection, sequence);
    }
}
