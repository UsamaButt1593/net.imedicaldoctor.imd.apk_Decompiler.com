package kotlin.text;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001d\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\u000b\u001a\u00020\u0000*\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\r\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000fH\n¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0017\u001a\u00020\u0015*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0011\u0010\u0019\u001a\u00020\u0015*\u00020\u0000¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"", "", "F", "(C)I", "radix", "G", "(CI)I", "H", "(C)Ljava/lang/Integer;", "I", "(CI)Ljava/lang/Integer;", "D", "(I)C", "E", "(II)C", "", "N", "(C)Ljava/lang/String;", "other", "M", "(CLjava/lang/String;)Ljava/lang/String;", "", "ignoreCase", "J", "(CCZ)Z", "L", "(C)Z", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/CharsKt")
@SourceDebugExtension({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char D(int i2) {
        if (new IntRange(0, 9).q(i2)) {
            return (char) (i2 + 48);
        }
        throw new IllegalArgumentException("Int " + i2 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final char E(int i2, int i3) {
        if (!new IntRange(2, 36).q(i3)) {
            throw new IllegalArgumentException("Invalid radix: " + i3 + ". Valid radix values are in range 2..36");
        } else if (i2 < 0 || i2 >= i3) {
            throw new IllegalArgumentException("Digit " + i2 + " does not represent a valid digit in radix " + i3);
        } else {
            return (char) (i2 < 10 ? i2 + 48 : ((char) (i2 + 65)) - 10);
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int F(char c2) {
        int b2 = CharsKt__CharJVMKt.b(c2, 10);
        if (b2 >= 0) {
            return b2;
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a decimal digit");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final int G(char c2, int i2) {
        Integer I = I(c2, i2);
        if (I != null) {
            return I.intValue();
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a digit in the given radix=" + i2);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer H(char c2) {
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.b(c2, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final Integer I(char c2, int i2) {
        CharsKt.a(i2);
        Integer valueOf = Integer.valueOf(CharsKt__CharJVMKt.b(c2, i2));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final boolean J(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static /* synthetic */ boolean K(char c2, char c3, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return J(c2, c3, z);
    }

    public static final boolean L(char c2) {
        return new CharRange(55296, 57343).q(c2);
    }

    @InlineOnly
    private static final String M(char c2, String str) {
        Intrinsics.p(str, "other");
        return c2 + str;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    public static final String N(char c2) {
        return _OneToManyTitlecaseMappingsKt.a(c2);
    }
}
