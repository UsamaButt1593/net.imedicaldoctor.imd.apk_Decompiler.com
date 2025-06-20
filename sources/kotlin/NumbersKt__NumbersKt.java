package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u000b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\u0007\u001a\u001b\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\f\u0010\u000b\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\rH\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\rH\b¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u0014\u0010\u0011\u001a\u00020\u0001*\u00020\rH\b¢\u0006\u0004\b\u0011\u0010\u000f\u001a\u0014\u0010\u0012\u001a\u00020\r*\u00020\rH\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u0014\u0010\u0014\u001a\u00020\r*\u00020\rH\b¢\u0006\u0004\b\u0014\u0010\u0013\u001a\u001b\u0010\u0015\u001a\u00020\r*\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\r*\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"", "", "V0", "(B)I", "T0", "X0", "d1", "(B)B", "f1", "bitCount", "Z0", "(BI)B", "b1", "", "W0", "(S)I", "U0", "Y0", "e1", "(S)S", "g1", "a1", "(SI)S", "c1", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int T0(byte b2) {
        return Integer.numberOfLeadingZeros(b2 & 255) - 24;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int U0(short s) {
        return Integer.numberOfLeadingZeros(s & UShort.Z) - 16;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int V0(byte b2) {
        return Integer.bitCount(b2 & 255);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int W0(short s) {
        return Integer.bitCount(s & UShort.Z);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int X0(byte b2) {
        return Integer.numberOfTrailingZeros(b2 | 256);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int Y0(short s) {
        return Integer.numberOfTrailingZeros(s | 65536);
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte Z0(byte b2, int i2) {
        byte b3 = i2 & 7;
        return (byte) (((b2 & 255) >>> (8 - b3)) | (b2 << b3));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short a1(short s, int i2) {
        short s2 = i2 & 15;
        return (short) (((s & UShort.Z) >>> (16 - s2)) | (s << s2));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final byte b1(byte b2, int i2) {
        byte b3 = i2 & 7;
        return (byte) (((b2 & 255) >>> b3) | (b2 << (8 - b3)));
    }

    @SinceKotlin(version = "1.6")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final short c1(short s, int i2) {
        short s2 = i2 & 15;
        return (short) (((s & UShort.Z) >>> s2) | (s << (16 - s2)));
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final byte d1(byte b2) {
        return (byte) Integer.highestOneBit(b2 & 255);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final short e1(short s) {
        return (short) Integer.highestOneBit(s & UShort.Z);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final byte f1(byte b2) {
        return (byte) Integer.lowestOneBit(b2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final short g1(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
