package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0010\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\b\u0010\u0006\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\t\u0010\u0003\u001a\u0014\u0010\n\u001a\u00020\u0001*\u00020\u0004H\b¢\u0006\u0004\b\n\u0010\u0006\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\u0000H\b¢\u0006\u0004\b\f\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\u000b*\u00020\u0000H\b¢\u0006\u0004\b\u000e\u0010\r\u001a\u001c\u0010\u0011\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0014\u001a\u00020\u0013*\u00020\u0004H\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0013*\u00020\u0004H\b¢\u0006\u0004\b\u0016\u0010\u0015\u001a\u001c\u0010\u0018\u001a\u00020\u0004*\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0013H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0014\u0010\u001a\u001a\u00020\u0013*\u00020\u0013H\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u0013*\u00020\u0013H\b¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u0014\u0010\u001d\u001a\u00020\u0013*\u00020\u0013H\b¢\u0006\u0004\b\u001d\u0010\u001b\u001a\u0014\u0010\u001e\u001a\u00020\u0013*\u00020\u0013H\b¢\u0006\u0004\b\u001e\u0010\u001b\u001a\u0014\u0010\u001f\u001a\u00020\u0013*\u00020\u0013H\b¢\u0006\u0004\b\u001f\u0010\u001b\u001a\u001c\u0010!\u001a\u00020\u0013*\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\b¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0013*\u00020\u00132\u0006\u0010 \u001a\u00020\u0013H\b¢\u0006\u0004\b#\u0010\"\u001a\u0014\u0010$\u001a\u00020\u0013*\u00020\u000bH\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010&\u001a\u00020\u0013*\u00020\u000bH\b¢\u0006\u0004\b&\u0010%\u001a\u0014\u0010'\u001a\u00020\u0013*\u00020\u000bH\b¢\u0006\u0004\b'\u0010%\u001a\u0014\u0010(\u001a\u00020\u000b*\u00020\u000bH\b¢\u0006\u0004\b(\u0010)\u001a\u0014\u0010*\u001a\u00020\u000b*\u00020\u000bH\b¢\u0006\u0004\b*\u0010)\u001a\u001c\u0010+\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\b¢\u0006\u0004\b+\u0010,\u001a\u001c\u0010-\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010 \u001a\u00020\u0013H\b¢\u0006\u0004\b-\u0010,¨\u0006."}, d2 = {"", "", "F0", "(D)Z", "", "G0", "(F)Z", "D0", "E0", "B0", "C0", "", "Q0", "(D)J", "S0", "Lkotlin/Double$Companion;", "bits", "z0", "(Lkotlin/jvm/internal/DoubleCompanionObject;J)D", "", "P0", "(F)I", "R0", "Lkotlin/Float$Companion;", "A0", "(Lkotlin/jvm/internal/FloatCompanionObject;I)F", "v0", "(I)I", "t0", "x0", "L0", "N0", "bitCount", "H0", "(II)I", "J0", "w0", "(J)I", "u0", "y0", "M0", "(J)J", "O0", "I0", "(JI)J", "K0", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/NumbersKt")
class NumbersKt__NumbersJVMKt extends NumbersKt__FloorDivModKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float A0(FloatCompanionObject floatCompanionObject, int i2) {
        Intrinsics.p(floatCompanionObject, "<this>");
        return Float.intBitsToFloat(i2);
    }

    @InlineOnly
    private static final boolean B0(double d2) {
        return !Double.isInfinite(d2) && !Double.isNaN(d2);
    }

    @InlineOnly
    private static final boolean C0(float f2) {
        return !Float.isInfinite(f2) && !Float.isNaN(f2);
    }

    @InlineOnly
    private static final boolean D0(double d2) {
        return Double.isInfinite(d2);
    }

    @InlineOnly
    private static final boolean E0(float f2) {
        return Float.isInfinite(f2);
    }

    @InlineOnly
    private static final boolean F0(double d2) {
        return Double.isNaN(d2);
    }

    @InlineOnly
    private static final boolean G0(float f2) {
        return Float.isNaN(f2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int H0(int i2, int i3) {
        return Integer.rotateLeft(i2, i3);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long I0(long j2, int i2) {
        return Long.rotateLeft(j2, i2);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int J0(int i2, int i3) {
        return Integer.rotateRight(i2, i3);
    }

    @SinceKotlin(version = "1.6")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long K0(long j2, int i2) {
        return Long.rotateRight(j2, i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int L0(int i2) {
        return Integer.highestOneBit(i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long M0(long j2) {
        return Long.highestOneBit(j2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int N0(int i2) {
        return Integer.lowestOneBit(i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final long O0(long j2) {
        return Long.lowestOneBit(j2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int P0(float f2) {
        return Float.floatToIntBits(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long Q0(double d2) {
        return Double.doubleToLongBits(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int R0(float f2) {
        return Float.floatToRawIntBits(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long S0(double d2) {
        return Double.doubleToRawLongBits(d2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int t0(int i2) {
        return Integer.numberOfLeadingZeros(i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int u0(long j2) {
        return Long.numberOfLeadingZeros(j2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int v0(int i2) {
        return Integer.bitCount(i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int w0(long j2) {
        return Long.bitCount(j2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int x0(int i2) {
        return Integer.numberOfTrailingZeros(i2);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final int y0(long j2) {
        return Long.numberOfTrailingZeros(j2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double z0(DoubleCompanionObject doubleCompanionObject, long j2) {
        Intrinsics.p(doubleCompanionObject, "<this>");
        return Double.longBitsToDouble(j2);
    }
}
