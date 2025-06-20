package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.IntIterator;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0007¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\u000f\u001a\u0004\u0018\u00010\u0003\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\rH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a1\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00030\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0003`\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0003*\u00020\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\n\u001a=\u0010\u0017\u001a\u0004\u0018\u00010\u0003\"\u000e\b\u0000\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u000b*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\rH\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010\u001a1\u0010\u0018\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u001a\u0010\u0013\u001a\u0016\u0012\u0006\b\u0000\u0012\u00020\u00030\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0003`\u0012H\u0007¢\u0006\u0004\b\u0018\u0010\u0015\u001a+\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\rH\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a+\u0010\u001d\u001a\u00020\u001c*\u00020\u00002\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\rH\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001f"}, d2 = {"", "", "index", "", "U5", "(Ljava/lang/CharSequence;I)C", "Ljava/util/SortedSet;", "d6", "(Ljava/lang/CharSequence;)Ljava/util/SortedSet;", "V5", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "", "R", "Lkotlin/Function1;", "selector", "W5", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparator", "X5", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "Y5", "Z5", "a6", "Ljava/math/BigDecimal;", "b6", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "c6", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1239#2,14:109\n1521#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    @InlineOnly
    private static final char U5(CharSequence charSequence, int i2) {
        Intrinsics.p(charSequence, "<this>");
        return charSequence.charAt(i2);
    }

    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character W5(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g3 = StringsKt.g3(charSequence);
        if (g3 != 0) {
            Comparable comparable = (Comparable) function1.f(Character.valueOf(charAt));
            IntIterator n2 = new IntRange(1, g3).iterator();
            while (n2.hasNext()) {
                char charAt2 = charSequence.charAt(n2.b());
                Comparable comparable2 = (Comparable) function1.f(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) < 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
            }
        }
        return Character.valueOf(charAt);
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character X5(CharSequence charSequence, Comparator comparator) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(comparator, "comparator");
        return StringsKt___StringsKt.P7(charSequence, comparator);
    }

    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character Z5(CharSequence charSequence, Function1<? super Character, ? extends R> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char charAt = charSequence.charAt(0);
        int g3 = StringsKt.g3(charSequence);
        if (g3 != 0) {
            Comparable comparable = (Comparable) function1.f(Character.valueOf(charAt));
            IntIterator n2 = new IntRange(1, g3).iterator();
            while (n2.hasNext()) {
                char charAt2 = charSequence.charAt(n2.b());
                Comparable comparable2 = (Comparable) function1.f(Character.valueOf(charAt2));
                if (comparable.compareTo(comparable2) > 0) {
                    charAt = charAt2;
                    comparable = comparable2;
                }
            }
        }
        return Character.valueOf(charAt);
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character a6(CharSequence charSequence, Comparator comparator) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(comparator, "comparator");
        return StringsKt___StringsKt.d8(charSequence, comparator);
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    private static final BigDecimal b6(CharSequence charSequence, Function1<? super Character, ? extends BigDecimal> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add((BigDecimal) function1.f(Character.valueOf(charSequence.charAt(i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @OverloadResolutionByLambdaReturnType
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    private static final BigInteger c6(CharSequence charSequence, Function1<? super Character, ? extends BigInteger> function1) {
        Intrinsics.p(charSequence, "<this>");
        Intrinsics.p(function1, "selector");
        BigInteger valueOf = BigInteger.valueOf(0);
        Intrinsics.o(valueOf, "valueOf(this.toLong())");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add((BigInteger) function1.f(Character.valueOf(charSequence.charAt(i2))));
            Intrinsics.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final SortedSet<Character> d6(@NotNull CharSequence charSequence) {
        Intrinsics.p(charSequence, "<this>");
        return (SortedSet) StringsKt___StringsKt.c9(charSequence, new TreeSet());
    }
}
