package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u001a\"\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a\"\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a&\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a&\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\"\u0010!\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0003\u001a\"\u0010\"\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0006\u001a\"\u0010#\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b#\u0010\t\u001a\"\u0010$\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010\u000b\u001a+\u0010%\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b%\u0010\r\u001a+\u0010&\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000f\u001a+\u0010'\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0011\u001a+\u0010(\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0013\u001a&\u0010)\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\n\u0010\u0015\u001a\u00020\u0014\"\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b)\u0010\u0017\u001a&\u0010*\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00042\n\u0010\u0015\u001a\u00020\u0018\"\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b*\u0010\u001a\u001a&\u0010+\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00072\n\u0010\u0015\u001a\u00020\u001b\"\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001d\u001a&\u0010,\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\n2\n\u0010\u0015\u001a\u00020\u001e\"\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b,\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlin/UInt;", "a", "b", "(II)I", "Lkotlin/ULong;", "j", "(JJ)J", "Lkotlin/UByte;", "c", "(BB)B", "Lkotlin/UShort;", "(SS)S", "g", "(III)I", "k", "(JJJ)J", "i", "(BBB)B", "f", "(SSS)S", "Lkotlin/UIntArray;", "other", "d", "(I[I)I", "Lkotlin/ULongArray;", "e", "(J[J)J", "Lkotlin/UByteArray;", "h", "(B[B)B", "Lkotlin/UShortArray;", "l", "(S[S)S", "n", "v", "o", "m", "s", "w", "u", "r", "p", "q", "t", "x", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/comparisons/UComparisonsKt")
class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short a(short s, short s2) {
        return Intrinsics.t(s & UShort.Z, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static int b(int i2, int i3) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) >= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte c(byte b2, byte b3) {
        return Intrinsics.t(b2 & 255, b3 & 255) >= 0 ? b2 : b3;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final int d(int i2, @NotNull int... iArr) {
        Intrinsics.p(iArr, "other");
        int r = UIntArray.r(iArr);
        for (int i3 = 0; i3 < r; i3++) {
            i2 = UComparisonsKt.b(i2, UIntArray.o(iArr, i3));
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final long e(long j2, @NotNull long... jArr) {
        Intrinsics.p(jArr, "other");
        int r = ULongArray.r(jArr);
        for (int i2 = 0; i2 < r; i2++) {
            j2 = UComparisonsKt.j(j2, ULongArray.o(jArr, i2));
        }
        return j2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final short f(short s, short s2, short s3) {
        return a(s, a(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int g(int i2, int i3, int i4) {
        return UComparisonsKt.b(i2, UComparisonsKt.b(i3, i4));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final byte h(byte b2, @NotNull byte... bArr) {
        Intrinsics.p(bArr, "other");
        int r = UByteArray.r(bArr);
        for (int i2 = 0; i2 < r; i2++) {
            b2 = c(b2, UByteArray.o(bArr, i2));
        }
        return b2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final byte i(byte b2, byte b3, byte b4) {
        return c(b2, c(b3, b4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static long j(long j2, long j3) {
        return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) >= 0 ? j2 : j3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long k(long j2, long j3, long j4) {
        return UComparisonsKt.j(j2, UComparisonsKt.j(j3, j4));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final short l(short s, @NotNull short... sArr) {
        Intrinsics.p(sArr, "other");
        int r = UShortArray.r(sArr);
        for (int i2 = 0; i2 < r; i2++) {
            s = a(s, UShortArray.o(sArr, i2));
        }
        return s;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final short m(short s, short s2) {
        return Intrinsics.t(s & UShort.Z, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static int n(int i2, int i3) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i3 ^ Integer.MIN_VALUE) <= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static final byte o(byte b2, byte b3) {
        return Intrinsics.t(b2 & 255, b3 & 255) <= 0 ? b2 : b3;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final int p(int i2, @NotNull int... iArr) {
        Intrinsics.p(iArr, "other");
        int r = UIntArray.r(iArr);
        for (int i3 = 0; i3 < r; i3++) {
            i2 = UComparisonsKt.n(i2, UIntArray.o(iArr, i3));
        }
        return i2;
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final long q(long j2, @NotNull long... jArr) {
        Intrinsics.p(jArr, "other");
        int r = ULongArray.r(jArr);
        for (int i2 = 0; i2 < r; i2++) {
            j2 = UComparisonsKt.v(j2, ULongArray.o(jArr, i2));
        }
        return j2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final short r(short s, short s2, short s3) {
        return m(s, m(s2, s3));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final int s(int i2, int i3, int i4) {
        return UComparisonsKt.n(i2, UComparisonsKt.n(i3, i4));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final byte t(byte b2, @NotNull byte... bArr) {
        Intrinsics.p(bArr, "other");
        int r = UByteArray.r(bArr);
        for (int i2 = 0; i2 < r; i2++) {
            b2 = o(b2, UByteArray.o(bArr, i2));
        }
        return b2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final byte u(byte b2, byte b3, byte b4) {
        return o(b2, o(b3, b4));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    public static long v(long j2, long j3) {
        return Long.compare(j2 ^ Long.MIN_VALUE, j3 ^ Long.MIN_VALUE) <= 0 ? j2 : j3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final long w(long j2, long j3, long j4) {
        return UComparisonsKt.v(j2, UComparisonsKt.v(j3, j4));
    }

    @ExperimentalUnsignedTypes
    @SinceKotlin(version = "1.4")
    public static final short x(short s, @NotNull short... sArr) {
        Intrinsics.p(sArr, "other");
        int r = UShortArray.r(sArr);
        for (int i2 = 0; i2 < r; i2++) {
            s = m(s, UShortArray.o(sArr, i2));
        }
        return s;
    }
}
