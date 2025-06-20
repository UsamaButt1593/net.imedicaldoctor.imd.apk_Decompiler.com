package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\u001a[\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\b\u0010\t\u001aG\u0010\n\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002 \u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003H\u0002¢\u0006\u0004\b\n\u0010\t\u001aC\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a_\u0010\u0012\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u0006\u0010\u0001\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a/\u0010\u0014\u001a\u00020\u0007\"\f\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0001\u001a\u0004\u0018\u00018\u00002\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a[\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u000026\u0010\u0006\u001a\u001c\u0012\u0018\b\u0001\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u00040\u0003\"\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0016\u0010\u0017\u001aE\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aa\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aE\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0019\u001aa\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001b\u001aY\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001b\u001au\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001aY\u0010!\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b!\u0010\u001b\u001au\u0010\"\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u000e*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00010\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0001`\u00102\u0014\b\u0004\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\bø\u0001\u0000¢\u0006\u0004\b\"\u0010 \u001aw\u0010'\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u001028\b\u0004\u0010&\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00070#H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001aV\u0010)\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0004¢\u0006\u0004\b)\u0010*\u001aV\u0010+\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u00102\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010H\u0004¢\u0006\u0004\b+\u0010*\u001aG\u0010-\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020,2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010¢\u0006\u0004\b-\u0010.\u001a4\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\b¢\u0006\u0004\b/\u00100\u001aG\u00101\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\b\b\u0000\u0010\u0000*\u00020,2\u001a\u0010\u0011\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u000fj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0010¢\u0006\u0004\b1\u0010.\u001a4\u00102\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\b¢\u0006\u0004\b2\u00100\u001a-\u00103\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b3\u00100\u001a-\u00104\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b4\u00100\u001a7\u00105\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010¢\u0006\u0004\b5\u0010.\u0002\u0007\n\u0005\b20\u0001¨\u00066"}, d2 = {"T", "a", "b", "", "Lkotlin/Function1;", "", "selectors", "", "o", "(Ljava/lang/Object;Ljava/lang/Object;[Lkotlin/jvm/functions/Function1;)I", "p", "selector", "n", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "K", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "m", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)I", "l", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "h", "([Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "g", "(Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "f", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "k", "j", "C", "B", "(Ljava/util/Comparator;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/util/Comparator;", "E", "D", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "comparison", "F", "(Ljava/util/Comparator;Lkotlin/jvm/functions/Function2;)Ljava/util/Comparator;", "z", "(Ljava/util/Comparator;Ljava/util/Comparator;)Ljava/util/Comparator;", "G", "", "s", "(Ljava/util/Comparator;)Ljava/util/Comparator;", "r", "()Ljava/util/Comparator;", "v", "u", "q", "x", "y", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt__ComparisonsKt {
    /* access modifiers changed from: private */
    public static final int A(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        Intrinsics.p(comparator, "$this_then");
        Intrinsics.p(comparator2, "$comparator");
        int compare = comparator.compare(obj, obj2);
        return compare != 0 ? compare : comparator2.compare(obj, obj2);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> B(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(comparator2, "comparator");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$thenBy$2(comparator, comparator2, function1);
    }

    @InlineOnly
    private static final <T> Comparator<T> C(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$thenBy$1(comparator, function1);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> D(Comparator<T> comparator, Comparator<? super K> comparator2, Function1<? super T, ? extends K> function1) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(comparator2, "comparator");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$thenByDescending$2(comparator, comparator2, function1);
    }

    @InlineOnly
    private static final <T> Comparator<T> E(Comparator<T> comparator, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$thenByDescending$1(comparator, function1);
    }

    @InlineOnly
    private static final <T> Comparator<T> F(Comparator<T> comparator, Function2<? super T, ? super T, Integer> function2) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(function2, "comparison");
        return new ComparisonsKt__ComparisonsKt$thenComparator$1(comparator, function2);
    }

    @NotNull
    public static final <T> Comparator<T> G(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(comparator2, "comparator");
        return new b(comparator, comparator2);
    }

    /* access modifiers changed from: private */
    public static final int H(Comparator comparator, Comparator comparator2, Object obj, Object obj2) {
        Intrinsics.p(comparator, "$this_thenDescending");
        Intrinsics.p(comparator2, "$comparator");
        int compare = comparator.compare(obj, obj2);
        return compare != 0 ? compare : comparator2.compare(obj2, obj);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> f(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareBy$3(comparator, function1);
    }

    @InlineOnly
    private static final <T> Comparator<T> g(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareBy$2(function1);
    }

    @NotNull
    public static final <T> Comparator<T> h(@NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.p(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return new d(function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    /* access modifiers changed from: private */
    public static final int i(Function1[] function1Arr, Object obj, Object obj2) {
        Intrinsics.p(function1Arr, "$selectors");
        return p(obj, obj2, function1Arr);
    }

    @InlineOnly
    private static final <T, K> Comparator<T> j(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$2(comparator, function1);
    }

    @InlineOnly
    private static final <T> Comparator<T> k(Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.p(function1, "selector");
        return new ComparisonsKt__ComparisonsKt$compareByDescending$1(function1);
    }

    public static <T extends Comparable<?>> int l(@Nullable T t, @Nullable T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    @InlineOnly
    private static final <T, K> int m(T t, T t2, Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        Intrinsics.p(comparator, "comparator");
        Intrinsics.p(function1, "selector");
        return comparator.compare(function1.f(t), function1.f(t2));
    }

    @InlineOnly
    private static final <T> int n(T t, T t2, Function1<? super T, ? extends Comparable<?>> function1) {
        Intrinsics.p(function1, "selector");
        return ComparisonsKt.l((Comparable) function1.f(t), (Comparable) function1.f(t2));
    }

    public static <T> int o(T t, T t2, @NotNull Function1<? super T, ? extends Comparable<?>>... function1Arr) {
        Intrinsics.p(function1Arr, "selectors");
        if (function1Arr.length > 0) {
            return p(t, t2, function1Arr);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final <T> int p(T t, T t2, Function1<? super T, ? extends Comparable<?>>[] function1Arr) {
        for (Function1<? super T, ? extends Comparable<?>> function1 : function1Arr) {
            int l2 = ComparisonsKt.l((Comparable) function1.f(t), (Comparable) function1.f(t2));
            if (l2 != 0) {
                return l2;
            }
        }
        return 0;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> Comparator<T> q() {
        NaturalOrderComparator naturalOrderComparator = NaturalOrderComparator.s;
        Intrinsics.n(naturalOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return naturalOrderComparator;
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> r() {
        return s(q());
    }

    @NotNull
    public static final <T> Comparator<T> s(@NotNull Comparator<? super T> comparator) {
        Intrinsics.p(comparator, "comparator");
        return new e(comparator);
    }

    /* access modifiers changed from: private */
    public static final int t(Comparator comparator, Object obj, Object obj2) {
        Intrinsics.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    @InlineOnly
    private static final <T extends Comparable<? super T>> Comparator<T> u() {
        return v(q());
    }

    @NotNull
    public static final <T> Comparator<T> v(@NotNull Comparator<? super T> comparator) {
        Intrinsics.p(comparator, "comparator");
        return new a(comparator);
    }

    /* access modifiers changed from: private */
    public static final int w(Comparator comparator, Object obj, Object obj2) {
        Intrinsics.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    @NotNull
    public static <T extends Comparable<? super T>> Comparator<T> x() {
        ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.s;
        Intrinsics.n(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return reverseOrderComparator;
    }

    @NotNull
    public static final <T> Comparator<T> y(@NotNull Comparator<T> comparator) {
        Intrinsics.p(comparator, "<this>");
        if (comparator instanceof ReversedComparator) {
            return ((ReversedComparator) comparator).a();
        }
        Comparator<T> comparator2 = NaturalOrderComparator.s;
        if (Intrinsics.g(comparator, comparator2)) {
            ReverseOrderComparator reverseOrderComparator = ReverseOrderComparator.s;
            Intrinsics.n(reverseOrderComparator, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return reverseOrderComparator;
        }
        if (Intrinsics.g(comparator, ReverseOrderComparator.s)) {
            Intrinsics.n(comparator2, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            comparator2 = new ReversedComparator<>(comparator);
        }
        return comparator2;
    }

    @NotNull
    public static final <T> Comparator<T> z(@NotNull Comparator<T> comparator, @NotNull Comparator<? super T> comparator2) {
        Intrinsics.p(comparator, "<this>");
        Intrinsics.p(comparator2, "comparator");
        return new c(comparator, comparator2);
    }
}
