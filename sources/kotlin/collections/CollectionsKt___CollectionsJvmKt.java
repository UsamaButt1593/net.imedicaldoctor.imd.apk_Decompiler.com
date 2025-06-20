package kotlin.collections;

import com.itextpdf.text.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001aC\u0010\n\u001a\u00028\u0000\"\u0010\b\u0000\u0010\b*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0007\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\t\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010\u001a-\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0011*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0013\u0010\u0014\u001a?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001b\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001a0\u0001H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001d*\b\u0012\u0004\u0012\u00020\u001d0\u0001H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a+\u0010 \u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0011*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b \u0010!\u001aI\u0010$\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\bø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a=\u0010&\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0016H\u0007¢\u0006\u0004\b&\u0010'\u001a\u001b\u0010(\u001a\u0004\u0018\u00010\u001a*\b\u0012\u0004\u0012\u00020\u001a0\u0001H\u0007¢\u0006\u0004\b(\u0010\u001c\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u001d*\b\u0012\u0004\u0012\u00020\u001d0\u0001H\u0007¢\u0006\u0004\b)\u0010\u001f\u001a+\u0010*\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u0011*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b*\u0010!\u001aI\u0010+\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\u0011*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\"H\bø\u0001\u0000¢\u0006\u0004\b+\u0010%\u001a=\u0010,\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0017\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0015j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0016H\u0007¢\u0006\u0004\b,\u0010'\u001a7\u0010.\u001a\u00020-\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020-0\"H\bø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a7\u00101\u001a\u000200\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002000\"H\bø\u0001\u0000¢\u0006\u0004\b1\u00102\u0002\u0007\n\u0005\b20\u0001¨\u00063"}, d2 = {"R", "", "Ljava/lang/Class;", "klass", "", "c1", "(Ljava/lang/Iterable;Ljava/lang/Class;)Ljava/util/List;", "", "C", "destination", "d1", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "T", "", "", "o1", "(Ljava/util/List;)V", "", "Ljava/util/SortedSet;", "r1", "(Ljava/lang/Iterable;)Ljava/util/SortedSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "s1", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/util/SortedSet;", "", "f1", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "", "g1", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "e1", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "Lkotlin/Function1;", "selector", "h1", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "i1", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "k1", "l1", "j1", "m1", "n1", "Ljava/math/BigDecimal;", "p1", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "q1", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/collections/CollectionsKt")
@SourceDebugExtension({"SMAP\n_CollectionsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,168:1\n1963#2,14:169\n2333#2,14:183\n*S KotlinDebug\n*F\n+ 1 _CollectionsJvm.kt\nkotlin/collections/CollectionsKt___CollectionsJvmKt\n*L\n89#1:169,14\n126#1:183,14\n*E\n"})
class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    @NotNull
    public static final <R> List<R> c1(@NotNull Iterable<?> iterable, @NotNull Class<R> cls) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(cls, "klass");
        return (List) d1(iterable, new ArrayList(), cls);
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C d1(@NotNull Iterable<?> iterable, @NotNull C c2, @NotNull Class<R> cls) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(cls, "klass");
        for (Object next : iterable) {
            if (cls.isInstance(next)) {
                c2.add(next);
            }
        }
        return c2;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T h1(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
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
        return next;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object i1(Iterable iterable, Comparator comparator) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.S3(iterable, comparator);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T m1(Iterable<? extends T> iterable, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        if (it2.hasNext()) {
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
        return next;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object n1(Iterable iterable, Comparator comparator) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(comparator, "comparator");
        return CollectionsKt___CollectionsKt.k4(iterable, comparator);
    }

    public static <T> void o1(@NotNull List<T> list) {
        Intrinsics.p(list, "<this>");
        Collections.reverse(list);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final <T> BigDecimal p1(Iterable<? extends T> iterable, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (Object f2 : iterable) {
            valueOf = valueOf.add((BigDecimal) function1.f(f2));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final <T> BigInteger q1(Iterable<? extends T> iterable, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (Object f2 : iterable) {
            valueOf = valueOf.add((BigInteger) function1.f(f2));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> r1(@NotNull Iterable<? extends T> iterable) {
        Intrinsics.p(iterable, "<this>");
        return (SortedSet) CollectionsKt___CollectionsKt.N5(iterable, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> s1(@NotNull Iterable<? extends T> iterable, @NotNull Comparator<? super T> comparator) {
        Intrinsics.p(iterable, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (SortedSet) CollectionsKt___CollectionsKt.N5(iterable, new TreeSet(comparator));
    }
}
