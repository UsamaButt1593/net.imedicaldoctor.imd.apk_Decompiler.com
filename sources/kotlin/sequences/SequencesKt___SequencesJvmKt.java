package kotlin.sequences;

import com.itextpdf.text.Annotation;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
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

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001aC\u0010\t\u001a\u00028\u0000\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u0000*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\t\u0010\n\u001a-\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a?\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0012\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0010j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0011¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a+\u0010\u001b\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001aI\u0010\u001f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001dH\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a=\u0010!\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0012\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0010j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0011H\u0007¢\u0006\u0004\b!\u0010\"\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0015*\b\u0012\u0004\u0012\u00020\u00150\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\u0017\u001a\u001b\u0010#\u001a\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00180\u0001H\u0007¢\u0006\u0004\b#\u0010\u001a\u001a+\u0010$\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007¢\u0006\u0004\b$\u0010\u001c\u001aI\u0010%\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f\"\u000e\b\u0001\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00010\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001dH\bø\u0001\u0000¢\u0006\u0004\b%\u0010 \u001a=\u0010&\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u001a\u0010\u0012\u001a\u0016\u0012\u0006\b\u0000\u0012\u00028\u00000\u0010j\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u0011H\u0007¢\u0006\u0004\b&\u0010\"\u001a7\u0010(\u001a\u00020'\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020'0\u001dH\bø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a7\u0010+\u001a\u00020*\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020*0\u001dH\bø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0002\u0007\n\u0005\b20\u0001¨\u0006-"}, d2 = {"R", "Lkotlin/sequences/Sequence;", "Ljava/lang/Class;", "klass", "u", "(Lkotlin/sequences/Sequence;Ljava/lang/Class;)Lkotlin/sequences/Sequence;", "", "C", "destination", "v", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "", "T", "Ljava/util/SortedSet;", "I", "(Lkotlin/sequences/Sequence;)Ljava/util/SortedSet;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "J", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/util/SortedSet;", "", "x", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "", "y", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "w", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "Lkotlin/Function1;", "selector", "z", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "A", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "D", "B", "E", "F", "Ljava/math/BigDecimal;", "G", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "H", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/sequences/SequencesKt")
@SourceDebugExtension({"SMAP\n_SequencesJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,172:1\n1433#2,14:173\n1839#2,14:187\n*S KotlinDebug\n*F\n+ 1 _SequencesJvm.kt\nkotlin/sequences/SequencesKt___SequencesJvmKt\n*L\n89#1:173,14\n126#1:187,14\n*E\n"})
class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object A(Sequence sequence, Comparator comparator) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(comparator, "comparator");
        return SequencesKt___SequencesKt.I1(sequence, comparator);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T E(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
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
    public static final /* synthetic */ Object F(Sequence sequence, Comparator comparator) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(comparator, "comparator");
        return SequencesKt___SequencesKt.a2(sequence, comparator);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final <T> BigDecimal G(Sequence<? extends T> sequence, Function1<? super T, ? extends BigDecimal> function1) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (Object f2 : sequence) {
            valueOf = valueOf.add((BigDecimal) function1.f(f2));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final <T> BigInteger H(Sequence<? extends T> sequence, Function1<? super T, ? extends BigInteger> function1) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (Object f2 : sequence) {
            valueOf = valueOf.add((BigInteger) function1.f(f2));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final <T extends Comparable<? super T>> SortedSet<T> I(@NotNull Sequence<? extends T> sequence) {
        Intrinsics.p(sequence, "<this>");
        return (SortedSet) SequencesKt___SequencesKt.a3(sequence, new TreeSet());
    }

    @NotNull
    public static final <T> SortedSet<T> J(@NotNull Sequence<? extends T> sequence, @NotNull Comparator<? super T> comparator) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(comparator, "comparator");
        return (SortedSet) SequencesKt___SequencesKt.a3(sequence, new TreeSet(comparator));
    }

    @NotNull
    public static final <R> Sequence<R> u(@NotNull Sequence<?> sequence, @NotNull Class<R> cls) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(cls, "klass");
        Sequence<R> p0 = SequencesKt.p0(sequence, new SequencesKt___SequencesJvmKt$filterIsInstance$1(cls));
        Intrinsics.n(p0, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return p0;
    }

    @NotNull
    public static final <C extends Collection<? super R>, R> C v(@NotNull Sequence<?> sequence, @NotNull C c2, @NotNull Class<R> cls) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(c2, Annotation.l3);
        Intrinsics.p(cls, "klass");
        for (Object next : sequence) {
            if (cls.isInstance(next)) {
                c2.add(next);
            }
        }
        return c2;
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T z(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1) {
        Intrinsics.p(sequence, "<this>");
        Intrinsics.p(function1, "selector");
        Iterator<? extends T> it2 = sequence.iterator();
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
}
