package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0017\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0017\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0017\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0017\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u001f\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\n\u001a\u0017\u0010\r\u001a\u00020\u0001*\u00020\fH\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u0001*\u00020\fH\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001a\u0017\u0010\u0010\u001a\u00020\u0001*\u00020\fH\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\f*\u00020\fH\bø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0013\u001a\u00020\f*\u00020\fH\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0012\u001a\u001f\u0010\u0014\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001f\u0010\u0016\u001a\u00020\f*\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u0017\u0010\u0018\u001a\u00020\u0001*\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001a\u001a\u00020\u0001*\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0019\u001a\u0017\u0010\u001b\u001a\u00020\u0001*\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019\u001a\u0017\u0010\u001c\u001a\u00020\u0017*\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0017\u0010\u001e\u001a\u00020\u0017*\u00020\u0017H\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001d\u001a\u001f\u0010\u001f\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a\u001f\u0010!\u001a\u00020\u0017*\u00020\u00172\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b!\u0010 \u001a\u0017\u0010#\u001a\u00020\u0001*\u00020\"H\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a\u0017\u0010%\u001a\u00020\u0001*\u00020\"H\bø\u0001\u0000¢\u0006\u0004\b%\u0010$\u001a\u0017\u0010&\u001a\u00020\u0001*\u00020\"H\bø\u0001\u0000¢\u0006\u0004\b&\u0010$\u001a\u0017\u0010'\u001a\u00020\"*\u00020\"H\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u001a\u0017\u0010)\u001a\u00020\"*\u00020\"H\bø\u0001\u0000¢\u0006\u0004\b)\u0010(\u001a\u001f\u0010*\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u001f\u0010,\u001a\u00020\"*\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\bø\u0001\u0000¢\u0006\u0004\b,\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lkotlin/UInt;", "", "g", "(I)I", "c", "k", "w", "A", "bitCount", "o", "(II)I", "s", "Lkotlin/ULong;", "f", "(J)I", "b", "j", "v", "(J)J", "z", "m", "(JI)J", "q", "Lkotlin/UByte;", "e", "(B)I", "a", "i", "u", "(B)B", "y", "n", "(BI)B", "r", "Lkotlin/UShort;", "h", "(S)I", "d", "l", "x", "(S)S", "B", "p", "(SI)S", "t", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@JvmName(name = "UNumbersKt")
public final class UNumbersKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int A(int i2) {
        return UInt.i(Integer.lowestOneBit(i2));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final short B(short s) {
        return UShort.i((short) Integer.lowestOneBit(s & UShort.Z));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int a(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int b(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int c(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int d(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.Z) - 16;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int e(byte b2) {
        return Integer.bitCount(UInt.i(b2 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int f(long j2) {
        return Long.bitCount(j2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int g(int i2) {
        return Integer.bitCount(i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int h(short s) {
        return Integer.bitCount(UInt.i(s & UShort.Z));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int i(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int j(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int k(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int l(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final long m(long j2, int i2) {
        return ULong.i(Long.rotateLeft(j2, i2));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final byte n(byte b2, int i2) {
        return UByte.i(NumbersKt__NumbersKt.Z0(b2, i2));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final int o(int i2, int i3) {
        return UInt.i(Integer.rotateLeft(i2, i3));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final short p(short s, int i2) {
        return UShort.i(NumbersKt__NumbersKt.a1(s, i2));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final long q(long j2, int i2) {
        return ULong.i(Long.rotateRight(j2, i2));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final byte r(byte b2, int i2) {
        return UByte.i(NumbersKt__NumbersKt.b1(b2, i2));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final int s(int i2, int i3) {
        return UInt.i(Integer.rotateRight(i2, i3));
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class, ExperimentalUnsignedTypes.class})
    private static final short t(short s, int i2) {
        return UShort.i(NumbersKt__NumbersKt.c1(s, i2));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final byte u(byte b2) {
        return UByte.i((byte) Integer.highestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final long v(long j2) {
        return ULong.i(Long.highestOneBit(j2));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final int w(int i2) {
        return UInt.i(Integer.highestOneBit(i2));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final short x(short s) {
        return UShort.i((short) Integer.highestOneBit(s & UShort.Z));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final byte y(byte b2) {
        return UByte.i((byte) Integer.lowestOneBit(b2 & 255));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class, ExperimentalStdlibApi.class})
    private static final long z(long j2) {
        return ULong.i(Long.lowestOneBit(j2));
    }
}
