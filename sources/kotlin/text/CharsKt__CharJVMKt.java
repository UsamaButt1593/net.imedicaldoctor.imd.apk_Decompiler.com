package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\u0003\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\n\u0010\u0003\u001a\u0011\u0010\u000b\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u000b\u0010\u0003\u001a\u0014\u0010\f\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\f\u0010\u0003\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u0003\u001a\u0014\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u0000H\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001b\u0010\u0016\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0018\u0010\u000f\u001a\u0014\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0019\u0010\u000f\u001a\u0014\u0010\u001a\u001a\u00020\u0011*\u00020\u0000H\b¢\u0006\u0004\b\u001a\u0010\u0013\u001a\u001b\u0010\u001b\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001b\u0010\u0017\u001a\u0014\u0010\u001c\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u001c\u0010\u0003\u001a\u0014\u0010\u001d\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001d\u0010\u000f\u001a\u0014\u0010\u001e\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u001e\u0010\u000f\u001a\u001b\u0010\u001f\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0007¢\u0006\u0004\b\u001f\u0010\u0017\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b \u0010\u0003\u001a\u0014\u0010!\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b!\u0010\u0003\u001a\u001f\u0010%\u001a\u00020#2\u0006\u0010\"\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#H\u0000¢\u0006\u0004\b%\u0010&\u001a\u0017\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b'\u0010(\"\u0015\u0010,\u001a\u00020)*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0015\u00100\u001a\u00020-*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"", "", "e", "(C)Z", "l", "m", "f", "i", "h", "j", "k", "r", "q", "o", "z", "(C)C", "C", "", "A", "(C)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "B", "(CLjava/util/Locale;)Ljava/lang/String;", "x", "u", "s", "t", "p", "y", "w", "v", "g", "n", "char", "", "radix", "b", "(CI)I", "a", "(I)I", "Lkotlin/text/CharCategory;", "c", "(C)Lkotlin/text/CharCategory;", "category", "Lkotlin/text/CharDirectionality;", "d", "(C)Lkotlin/text/CharDirectionality;", "directionality", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String A(char c2) {
        String valueOf = String.valueOf(c2);
        Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String B(char c2, @NotNull Locale locale) {
        Intrinsics.p(locale, "locale");
        String valueOf = String.valueOf(c2);
        Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char C(char c2) {
        return Character.toUpperCase(c2);
    }

    @PublishedApi
    public static int a(int i2) {
        if (new IntRange(2, 36).q(i2)) {
            return i2;
        }
        throw new IllegalArgumentException("radix " + i2 + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int b(char c2, int i2) {
        return Character.digit(c2, i2);
    }

    @NotNull
    public static final CharCategory c(char c2) {
        return CharCategory.Y.a(Character.getType(c2));
    }

    @NotNull
    public static final CharDirectionality d(char c2) {
        return CharDirectionality.X.b(Character.getDirectionality(c2));
    }

    @InlineOnly
    private static final boolean e(char c2) {
        return Character.isDefined(c2);
    }

    @InlineOnly
    private static final boolean f(char c2) {
        return Character.isDigit(c2);
    }

    @InlineOnly
    private static final boolean g(char c2) {
        return Character.isHighSurrogate(c2);
    }

    @InlineOnly
    private static final boolean h(char c2) {
        return Character.isISOControl(c2);
    }

    @InlineOnly
    private static final boolean i(char c2) {
        return Character.isIdentifierIgnorable(c2);
    }

    @InlineOnly
    private static final boolean j(char c2) {
        return Character.isJavaIdentifierPart(c2);
    }

    @InlineOnly
    private static final boolean k(char c2) {
        return Character.isJavaIdentifierStart(c2);
    }

    @InlineOnly
    private static final boolean l(char c2) {
        return Character.isLetter(c2);
    }

    @InlineOnly
    private static final boolean m(char c2) {
        return Character.isLetterOrDigit(c2);
    }

    @InlineOnly
    private static final boolean n(char c2) {
        return Character.isLowSurrogate(c2);
    }

    @InlineOnly
    private static final boolean o(char c2) {
        return Character.isLowerCase(c2);
    }

    @InlineOnly
    private static final boolean p(char c2) {
        return Character.isTitleCase(c2);
    }

    @InlineOnly
    private static final boolean q(char c2) {
        return Character.isUpperCase(c2);
    }

    public static final boolean r(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final String s(char c2) {
        String valueOf = String.valueOf(c2);
        Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(Locale.ROOT);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String t(char c2, @NotNull Locale locale) {
        Intrinsics.p(locale, "locale");
        String valueOf = String.valueOf(c2);
        Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = valueOf.toLowerCase(locale);
        Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char u(char c2) {
        return Character.toLowerCase(c2);
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final String v(char c2, @NotNull Locale locale) {
        Intrinsics.p(locale, "locale");
        String B = B(c2, locale);
        if (B.length() <= 1) {
            String valueOf = String.valueOf(c2);
            Intrinsics.n(valueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            Intrinsics.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !Intrinsics.g(B, upperCase) ? B : String.valueOf(Character.toTitleCase(c2));
        } else if (c2 == 329) {
            return B;
        } else {
            char charAt = B.charAt(0);
            Intrinsics.n(B, "null cannot be cast to non-null type java.lang.String");
            String substring = B.substring(1);
            Intrinsics.o(substring, "this as java.lang.String).substring(startIndex)");
            Intrinsics.n(substring, "null cannot be cast to non-null type java.lang.String");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            Intrinsics.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return charAt + lowerCase;
        }
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final char w(char c2) {
        return Character.toTitleCase(c2);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char x(char c2) {
        return Character.toLowerCase(c2);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char y(char c2) {
        return Character.toTitleCase(c2);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @InlineOnly
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char z(char c2) {
        return Character.toUpperCase(c2);
    }
}
