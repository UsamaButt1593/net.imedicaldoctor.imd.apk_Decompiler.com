package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a=\u0010\u000b\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\bH\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a9\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0004\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0003¢\u0006\u0004\b\u0010\u0010\u0007\u001a(\u0010\u0012\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0011\u001a\u00028\u0000H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\b¢\u0006\u0004\b\u0014\u0010\u000f\u001a(\u0010\u0017\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0016\u001a\u00020\u0015H\b¢\u0006\u0004\b\u0017\u0010\u0018\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0019"}, d2 = {"T", "", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "", "k0", "(Ljava/util/List;Ljava/util/Comparator;)V", "Lkotlin/Function2;", "", "comparison", "l0", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)V", "", "j0", "(Ljava/util/List;)V", "m0", "value", "g0", "(Ljava/util/List;Ljava/lang/Object;)V", "h0", "Ljava/util/Random;", "random", "i0", "(Ljava/util/List;Ljava/util/Random;)V", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void g0(List<T> list, T t) {
        Intrinsics.p(list, "<this>");
        Collections.fill(list, t);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void h0(List<T> list) {
        Intrinsics.p(list, "<this>");
        Collections.shuffle(list);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final <T> void i0(List<T> list, Random random) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(random, "random");
        Collections.shuffle(list, random);
    }

    public static <T extends Comparable<? super T>> void j0(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(comparator) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(comparator)", imports = {}))
    @InlineOnly
    private static final <T> void k0(List<T> list, Comparator<? super T> comparator) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(comparator, "comparator");
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use sortWith(Comparator(comparison)) instead.", replaceWith = @ReplaceWith(expression = "this.sortWith(Comparator(comparison))", imports = {}))
    @InlineOnly
    private static final <T> void l0(List<T> list, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(function2, "comparison");
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    public static <T> void m0(@NotNull List<T> list, @NotNull Comparator<? super T> comparator) {
        Intrinsics.p(list, "<this>");
        Intrinsics.p(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
