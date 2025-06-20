package kotlin;

import com.google.common.base.Ascii;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;

@Metadata(d1 = {"\u0000.\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b.\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\u001a\u001c\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\n\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b\f\u0010\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b\u000e\u0010\r\u001a\u001c\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0012\u0010\u0011\u001a\u001c\u0010\u0013\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0015\u001a\u00020\u0000*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001c\u0010\u0017\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001c\u0010\u0019\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001b\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001d\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001c\u0010 \u001a\u00020\u000f*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b \u0010\u001f\u001a\u001c\u0010!\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b!\u0010\"\u001a\u001c\u0010#\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b#\u0010$\u001a\u001c\u0010%\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010'\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b'\u0010(\u001a\u001c\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b+\u0010*\u001a\u001c\u0010,\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b,\u0010-\u001a\u001c\u0010.\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b.\u0010-\u001a\u001c\u0010/\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b/\u00100\u001a\u001c\u00101\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b1\u00102\u001a\u001c\u00103\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b3\u00104\u001a\u001c\u00105\u001a\u00020\u0007*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0007H\b¢\u0006\u0004\b5\u00106\u001a\u001c\u00107\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b7\u00108\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u0002H\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010;\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b;\u0010<\u001a\u001c\u0010=\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u000fH\b¢\u0006\u0004\b=\u0010<\u001a\u001c\u0010?\u001a\u00020>*\u00020>2\u0006\u0010\u0001\u001a\u00020>H\b¢\u0006\u0004\b?\u0010@\u001a\u001c\u0010B\u001a\u00020A*\u00020>2\u0006\u0010\u0001\u001a\u00020AH\b¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010D\u001a\u00020A*\u00020A2\u0006\u0010\u0001\u001a\u00020>H\b¢\u0006\u0004\bD\u0010E\u001a\u001c\u0010F\u001a\u00020A*\u00020A2\u0006\u0010\u0001\u001a\u00020AH\b¢\u0006\u0004\bF\u0010G¨\u0006H"}, d2 = {"", "other", "", "J", "(BB)I", "Z", "(BB)B", "", "L", "(BS)I", "p0", "(BS)S", "K", "(BI)I", "h0", "", "S", "(BJ)J", "l0", "P", "(SB)I", "c0", "(SB)B", "R", "(SS)I", "s0", "(SS)S", "Q", "(SI)I", "k0", "Y", "(SJ)J", "o0", "M", "(IB)I", "a0", "(IB)B", "O", "(IS)I", "q0", "(IS)S", "N", "(II)I", "i0", "T", "(IJ)J", "m0", "U", "(JB)J", "b0", "(JB)B", "X", "(JS)J", "r0", "(JS)S", "V", "(JI)J", "j0", "(JI)I", "W", "(JJ)J", "n0", "", "g0", "(FF)F", "", "f0", "(FD)D", "e0", "(DF)D", "d0", "(DD)D", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int J(byte b2, byte b3) {
        int i2 = b2 / b3;
        return ((b2 ^ b3) >= 0 || b3 * i2 == b2) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int K(byte b2, int i2) {
        int i3 = b2 / i2;
        return ((b2 ^ i2) >= 0 || i2 * i3 == b2) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int L(byte b2, short s) {
        int i2 = b2 / s;
        return ((b2 ^ s) >= 0 || s * i2 == b2) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int M(int i2, byte b2) {
        int i3 = i2 / b2;
        return ((i2 ^ b2) >= 0 || b2 * i3 == i2) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int N(int i2, int i3) {
        int i4 = i2 / i3;
        return ((i2 ^ i3) >= 0 || i3 * i4 == i2) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int O(int i2, short s) {
        int i3 = i2 / s;
        return ((i2 ^ s) >= 0 || s * i3 == i2) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int P(short s, byte b2) {
        int i2 = s / b2;
        return ((s ^ b2) >= 0 || b2 * i2 == s) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int Q(short s, int i2) {
        int i3 = s / i2;
        return ((s ^ i2) >= 0 || i2 * i3 == s) ? i3 : i3 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int R(short s, short s2) {
        int i2 = s / s2;
        return ((s ^ s2) >= 0 || s2 * i2 == s) ? i2 : i2 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long S(byte b2, long j2) {
        long j3 = (long) b2;
        long j4 = j3 / j2;
        return ((j3 ^ j2) >= 0 || j2 * j4 == j3) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long T(int i2, long j2) {
        long j3 = (long) i2;
        long j4 = j3 / j2;
        return ((j3 ^ j2) >= 0 || j2 * j4 == j3) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long U(long j2, byte b2) {
        long j3 = (long) b2;
        long j4 = j2 / j3;
        return ((j2 ^ j3) >= 0 || j3 * j4 == j2) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long V(long j2, int i2) {
        long j3 = (long) i2;
        long j4 = j2 / j3;
        return ((j2 ^ j3) >= 0 || j3 * j4 == j2) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long W(long j2, long j3) {
        long j4 = j2 / j3;
        return ((j2 ^ j3) >= 0 || j3 * j4 == j2) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long X(long j2, short s) {
        long j3 = (long) s;
        long j4 = j2 / j3;
        return ((j2 ^ j3) >= 0 || j3 * j4 == j2) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long Y(short s, long j2) {
        long j3 = (long) s;
        long j4 = j3 / j2;
        return ((j3 ^ j2) >= 0 || j2 * j4 == j3) ? j4 : j4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte Z(byte b2, byte b3) {
        int i2 = b2 % b3;
        return (byte) (i2 + (b3 & (((i2 ^ b3) & ((-i2) | i2)) >> Ascii.I)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte a0(int i2, byte b2) {
        int i3 = i2 % b2;
        return (byte) (i3 + (b2 & (((i3 ^ b2) & ((-i3) | i3)) >> Ascii.I)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte b0(long j2, byte b2) {
        long j3 = (long) b2;
        long j4 = j2 % j3;
        return (byte) ((int) (j4 + (j3 & (((j4 ^ j3) & ((-j4) | j4)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final byte c0(short s, byte b2) {
        int i2 = s % b2;
        return (byte) (i2 + (b2 & (((i2 ^ b2) & ((-i2) | i2)) >> Ascii.I)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double d0(double d2, double d3) {
        double d4 = d2 % d3;
        return (d4 == 0.0d || Math.signum(d4) == Math.signum(d3)) ? d4 : d4 + d3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double e0(double d2, float f2) {
        double d3 = (double) f2;
        double d4 = d2 % d3;
        return (d4 == 0.0d || Math.signum(d4) == Math.signum(d3)) ? d4 : d4 + d3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final double f0(float f2, double d2) {
        double d3 = ((double) f2) % d2;
        return (d3 == 0.0d || Math.signum(d3) == Math.signum(d2)) ? d3 : d3 + d2;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final float g0(float f2, float f3) {
        float f4 = f2 % f3;
        return (f4 == 0.0f || Math.signum(f4) == Math.signum(f3)) ? f4 : f4 + f3;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int h0(byte b2, int i2) {
        int i3 = b2 % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int i0(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 + (i3 & (((i4 ^ i3) & ((-i4) | i4)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int j0(long j2, int i2) {
        long j3 = (long) i2;
        long j4 = j2 % j3;
        return (int) (j4 + (j3 & (((j4 ^ j3) & ((-j4) | j4)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final int k0(short s, int i2) {
        int i3 = s % i2;
        return i3 + (i2 & (((i3 ^ i2) & ((-i3) | i3)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long l0(byte b2, long j2) {
        long j3 = ((long) b2) % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long m0(int i2, long j2) {
        long j3 = ((long) i2) % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long n0(long j2, long j3) {
        long j4 = j2 % j3;
        return j4 + (j3 & (((j4 ^ j3) & ((-j4) | j4)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final long o0(short s, long j2) {
        long j3 = ((long) s) % j2;
        return j3 + (j2 & (((j3 ^ j2) & ((-j3) | j3)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short p0(byte b2, short s) {
        int i2 = b2 % s;
        return (short) (i2 + (s & (((i2 ^ s) & ((-i2) | i2)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short q0(int i2, short s) {
        int i3 = i2 % s;
        return (short) (i3 + (s & (((i3 ^ s) & ((-i3) | i3)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short r0(long j2, short s) {
        long j3 = (long) s;
        long j4 = j2 % j3;
        return (short) ((int) (j4 + (j3 & (((j4 ^ j3) & ((-j4) | j4)) >> 63))));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @IntrinsicConstEvaluation
    private static final short s0(short s, short s2) {
        int i2 = s % s2;
        return (short) (i2 + (s2 & (((i2 ^ s2) & ((-i2) | i2)) >> 31)));
    }
}
