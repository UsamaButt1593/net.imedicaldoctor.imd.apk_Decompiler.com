package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001c\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u001c\u0010\t\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\t\u0010\n\u001a\u001c\u0010\f\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\f\u0010\r\u001a\u0016\u0010\u000f\u001a\u00020\u000e*\u0004\u0018\u00010\u0003H\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0014\u0010\u0011\u001a\u00020\u0000*\u00020\u0003H\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001c\u0010\u0013\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\u0006*\u00020\u0003H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\u0001*\u00020\u0003H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\u000b*\u00020\u0003H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010\"\u001a\u00020!*\u00020\u0003H\b¢\u0006\u0004\b\"\u0010#\u001a\u0014\u0010%\u001a\u00020$*\u00020\u0003H\b¢\u0006\u0004\b%\u0010&\u001a\u0015\u0010'\u001a\u0004\u0018\u00010!*\u00020\u0003H\u0007¢\u0006\u0004\b'\u0010(\u001a\u0015\u0010)\u001a\u0004\u0018\u00010$*\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010,\u001a\u00020+*\u00020\u0003H\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020+*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\b¢\u0006\u0004\b.\u0010/\u001a\u0015\u00100\u001a\u0004\u0018\u00010+*\u00020\u0003H\u0007¢\u0006\u0004\b0\u0010-\u001a\u001d\u00101\u001a\u0004\u0018\u00010+*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b1\u0010/\u001a\u0014\u00103\u001a\u000202*\u00020\u0003H\b¢\u0006\u0004\b3\u00104\u001a\u001c\u00107\u001a\u000202*\u00020\u00032\u0006\u00106\u001a\u000205H\b¢\u0006\u0004\b7\u00108\u001a\u0015\u00109\u001a\u0004\u0018\u000102*\u00020\u0003H\u0007¢\u0006\u0004\b9\u00104\u001a\u001d\u0010:\u001a\u0004\u0018\u000102*\u00020\u00032\u0006\u00106\u001a\u000205H\u0007¢\u0006\u0004\b:\u00108\u001a4\u0010?\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010;2\u0006\u0010<\u001a\u00020\u00032\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000=H\b¢\u0006\u0004\b?\u0010@¨\u0006A"}, d2 = {"", "", "radix", "", "Q0", "(BI)Ljava/lang/String;", "", "T0", "(SI)Ljava/lang/String;", "R0", "(II)Ljava/lang/String;", "", "S0", "(JI)Ljava/lang/String;", "", "D0", "(Ljava/lang/String;)Z", "E0", "(Ljava/lang/String;)B", "F0", "(Ljava/lang/String;I)B", "O0", "(Ljava/lang/String;)S", "P0", "(Ljava/lang/String;I)S", "K0", "(Ljava/lang/String;)I", "L0", "(Ljava/lang/String;I)I", "M0", "(Ljava/lang/String;)J", "N0", "(Ljava/lang/String;I)J", "", "I0", "(Ljava/lang/String;)F", "", "G0", "(Ljava/lang/String;)D", "J0", "(Ljava/lang/String;)Ljava/lang/Float;", "H0", "(Ljava/lang/String;)Ljava/lang/Double;", "Ljava/math/BigInteger;", "z0", "(Ljava/lang/String;)Ljava/math/BigInteger;", "A0", "(Ljava/lang/String;I)Ljava/math/BigInteger;", "B0", "C0", "Ljava/math/BigDecimal;", "v0", "(Ljava/lang/String;)Ljava/math/BigDecimal;", "Ljava/math/MathContext;", "mathContext", "w0", "(Ljava/lang/String;Ljava/math/MathContext;)Ljava/math/BigDecimal;", "x0", "y0", "T", "str", "Lkotlin/Function1;", "parse", "u0", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/text/StringsKt")
@SourceDebugExtension({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,274:1\n265#1,7:275\n265#1,7:282\n265#1,7:289\n265#1,7:296\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n142#1:275,7\n149#1:282,7\n229#1:289,7\n240#1:296,7\n*E\n"})
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger A0(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return new BigInteger(str, CharsKt.a(i2));
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger B0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return C0(str, 10);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger C0(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        CharsKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        if (length != 1) {
            if (str.charAt(0) == '-') {
                i3 = 1;
            }
            while (i3 < length) {
                if (CharsKt__CharJVMKt.b(str.charAt(i3), i2) < 0) {
                    return null;
                }
                i3++;
            }
        } else if (CharsKt__CharJVMKt.b(str.charAt(0), i2) < 0) {
            return null;
        }
        return new BigInteger(str, CharsKt.a(i2));
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final boolean D0(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    private static final byte E0(String str) {
        Intrinsics.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte F0(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return Byte.parseByte(str, CharsKt.a(i2));
    }

    @InlineOnly
    private static final double G0(String str) {
        Intrinsics.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Double H0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f29108b.k(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final float I0(String str) {
        Intrinsics.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Float J0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f29108b.k(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final int K0(String str) {
        Intrinsics.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int L0(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return Integer.parseInt(str, CharsKt.a(i2));
    }

    @InlineOnly
    private static final long M0(String str) {
        Intrinsics.p(str, "<this>");
        return Long.parseLong(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long N0(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return Long.parseLong(str, CharsKt.a(i2));
    }

    @InlineOnly
    private static final short O0(String str) {
        Intrinsics.p(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short P0(String str, int i2) {
        Intrinsics.p(str, "<this>");
        return Short.parseShort(str, CharsKt.a(i2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String Q0(byte b2, int i2) {
        String num = Integer.toString(b2, CharsKt.a(CharsKt.a(i2)));
        Intrinsics.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String R0(int i2, int i3) {
        String num = Integer.toString(i2, CharsKt.a(i3));
        Intrinsics.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String S0(long j2, int i2) {
        String l2 = Long.toString(j2, CharsKt.a(i2));
        Intrinsics.o(l2, "toString(this, checkRadix(radix))");
        return l2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String T0(short s, int i2) {
        String num = Integer.toString(s, CharsKt.a(CharsKt.a(i2)));
        Intrinsics.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    private static final <T> T u0(String str, Function1<? super String, ? extends T> function1) {
        try {
            if (ScreenFloatValueRegEx.f29108b.k(str)) {
                return function1.f(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal v0(String str) {
        Intrinsics.p(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal w0(String str, MathContext mathContext) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal x0(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f29108b.k(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal y0(@NotNull String str, @NotNull MathContext mathContext) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(mathContext, "mathContext");
        try {
            if (ScreenFloatValueRegEx.f29108b.k(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger z0(String str) {
        Intrinsics.p(str, "<this>");
        return new BigInteger(str);
    }
}
