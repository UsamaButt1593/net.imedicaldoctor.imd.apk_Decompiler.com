package kotlin.text;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.WasExperimental;
import kotlin.a;
import kotlin.d;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001e\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u001e\u0010\r\u001a\u00020\u0003*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0016\u0010\u000f\u001a\u00020\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0011\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0016\u0010\u0013\u001a\u00020\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001e\u0010\u0015\u001a\u00020\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0016\u0010\u0017\u001a\u00020\t*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001e\u0010\u0019\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0016\u0010\u001b\u001a\u00020\f*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001e\u0010\u001d\u001a\u00020\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u0000*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a \u0010!\u001a\u0004\u0018\u00010\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001a\u0018\u0010#\u001a\u0004\u0018\u00010\u0006*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a \u0010%\u001a\u0004\u0018\u00010\u0006*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a\u0018\u0010'\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a \u0010)\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a\u0018\u0010+\u001a\u0004\u0018\u00010\f*\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u001a \u0010-\u001a\u0004\u0018\u00010\f*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlin/UByte;", "", "radix", "", "b", "(BI)Ljava/lang/String;", "Lkotlin/UShort;", "d", "(SI)Ljava/lang/String;", "Lkotlin/UInt;", "c", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "a", "(JI)Ljava/lang/String;", "e", "(Ljava/lang/String;)B", "f", "(Ljava/lang/String;I)B", "q", "(Ljava/lang/String;)S", "r", "(Ljava/lang/String;I)S", "i", "(Ljava/lang/String;)I", "j", "(Ljava/lang/String;I)I", "m", "(Ljava/lang/String;)J", "n", "(Ljava/lang/String;I)J", "g", "(Ljava/lang/String;)Lkotlin/UByte;", "h", "(Ljava/lang/String;I)Lkotlin/UByte;", "s", "(Ljava/lang/String;)Lkotlin/UShort;", "t", "(Ljava/lang/String;I)Lkotlin/UShort;", "k", "(Ljava/lang/String;)Lkotlin/UInt;", "l", "(Ljava/lang/String;I)Lkotlin/UInt;", "o", "(Ljava/lang/String;)Lkotlin/ULong;", "p", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "UStringsKt")
public final class UStringsKt {
    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final String a(long j2, int i2) {
        return UnsignedKt.l(j2, CharsKt.a(i2));
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final String b(byte b2, int i2) {
        String num = Integer.toString(b2 & 255, CharsKt.a(i2));
        Intrinsics.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final String c(int i2, int i3) {
        String l2 = Long.toString(((long) i2) & InternalZipConstants.f30717k, CharsKt.a(i3));
        Intrinsics.o(l2, "toString(this, checkRadix(radix))");
        return l2;
    }

    @NotNull
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final String d(short s, int i2) {
        String num = Integer.toString(s & UShort.Z, CharsKt.a(i2));
        Intrinsics.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte e(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        UByte g2 = g(str);
        if (g2 != null) {
            return g2.r0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte f(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        UByte h2 = h(str, i2);
        if (h2 != null) {
            return h2.r0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte g(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return h(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UByte h(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        UInt l2 = l(str, i2);
        if (l2 == null) {
            return null;
        }
        int v0 = l2.v0();
        if (Integer.compare(v0 ^ Integer.MIN_VALUE, UInt.i(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UByte.b(UByte.i((byte) v0));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int i(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        UInt k2 = k(str);
        if (k2 != null) {
            return k2.v0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final int j(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        UInt l2 = l(str, i2);
        if (l2 != null) {
            return l2.v0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt k(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return l(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UInt l(@NotNull String str, int i2) {
        int i3;
        Intrinsics.p(str, "<this>");
        CharsKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.t(charAt, 48) < 0) {
            i3 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i3 = 0;
        }
        int i5 = UInt.i(i2);
        int i6 = 119304647;
        while (i3 < length) {
            int b2 = CharsKt__CharJVMKt.b(str.charAt(i3), i2);
            if (b2 < 0) {
                return null;
            }
            if (Integer.compare(i4 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE) > 0) {
                if (i6 == 119304647) {
                    i6 = a.a(-1, i5);
                    if (Integer.compare(i4 ^ Integer.MIN_VALUE, i6 ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int i7 = UInt.i(i4 * i5);
            int i8 = UInt.i(UInt.i(b2) + i7);
            if (Integer.compare(i8 ^ Integer.MIN_VALUE, i7 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i3++;
            i4 = i8;
        }
        return UInt.b(i4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long m(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        ULong o = o(str);
        if (o != null) {
            return o.v0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final long n(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        ULong p = p(str, i2);
        if (p != null) {
            return p.v0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong o(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return p(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final ULong p(@NotNull String str, int i2) {
        String str2 = str;
        int i3 = i2;
        Intrinsics.p(str2, "<this>");
        CharsKt.a(i2);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char charAt = str2.charAt(0);
        if (Intrinsics.t(charAt, 48) < 0) {
            i4 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long i5 = ULong.i((long) i3);
        long j2 = 0;
        long j3 = 512409557603043100L;
        while (i4 < length) {
            int b2 = CharsKt__CharJVMKt.b(str2.charAt(i4), i3);
            if (b2 < 0) {
                return null;
            }
            if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) > 0) {
                if (j3 == 512409557603043100L) {
                    j3 = d.a(-1, i5);
                    if (Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long i6 = ULong.i(j2 * i5);
            long i7 = ULong.i(ULong.i(((long) UInt.i(b2)) & InternalZipConstants.f30717k) + i6);
            if (Long.compare(i7 ^ Long.MIN_VALUE, i6 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i4++;
            j2 = i7;
        }
        return ULong.b(j2);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short q(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        UShort s = s(str);
        if (s != null) {
            return s.r0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short r(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        UShort t = t(str, i2);
        if (t != null) {
            return t.r0();
        }
        StringsKt__StringNumberConversionsKt.U0(str);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort s(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return t(str, 10);
    }

    @SinceKotlin(version = "1.5")
    @Nullable
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final UShort t(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        UInt l2 = l(str, i2);
        if (l2 == null) {
            return null;
        }
        int v0 = l2.v0();
        if (Integer.compare(v0 ^ Integer.MIN_VALUE, UInt.i(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return UShort.b(UShort.i((short) v0));
    }
}
