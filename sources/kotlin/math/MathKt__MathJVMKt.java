package kotlin.math;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0006\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\bR\u001a\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0018\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\u0003\u001a \u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\f\u0010\u0003\u001a\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\r\u0010\u0003\u001a\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u000e\u0010\u0003\u001a\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u000f\u0010\u0003\u001a\u0017\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0010\u0010\u0003\u001a\u0017\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0011\u0010\u0003\u001a \u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0012\u0010\u000b\u001a\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0003\u001a\u0018\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0014\u0010\u0003\u001a\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0015\u0010\u0003\u001a\u001f\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u000b\u001a\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0018\u0010\u0003\u001a\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u0019\u0010\u0003\u001a\u0017\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u0003\u001a\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u001b\u0010\u0003\u001a\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\t\u0010\u0003\u001a\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u001c\u0010\u0003\u001a\u0017\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u001d\u0010\u0003\u001a\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u001e\u0010\u0003\u001a\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b\u001f\u0010\u0003\u001a\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b \u0010\u0003\u001a \u0010#\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000H\b¢\u0006\u0004\b#\u0010\u000b\u001a \u0010$\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0000H\b¢\u0006\u0004\b$\u0010\u000b\u001a\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b%\u0010\u0003\u001a\u001c\u0010&\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\b¢\u0006\u0004\b&\u0010\u000b\u001a\u001c\u0010)\u001a\u00020\u0000*\u00020\u00002\u0006\u0010(\u001a\u00020'H\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010,\u001a\u00020\u0000*\u00020\u00002\u0006\u0010+\u001a\u00020\u0000H\b¢\u0006\u0004\b,\u0010\u000b\u001a\u001c\u0010.\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\b¢\u0006\u0004\b.\u0010\u000b\u001a\u001c\u0010/\u001a\u00020\u0000*\u00020\u00002\u0006\u0010-\u001a\u00020'H\b¢\u0006\u0004\b/\u0010*\u001a\u0014\u00100\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b0\u0010\u0003\u001a\u0014\u00101\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b1\u0010\u0003\u001a\u001c\u00103\u001a\u00020\u0000*\u00020\u00002\u0006\u00102\u001a\u00020\u0000H\b¢\u0006\u0004\b3\u0010\u000b\u001a\u0013\u00104\u001a\u00020'*\u00020\u0000H\u0007¢\u0006\u0004\b4\u00105\u001a\u0013\u00107\u001a\u000206*\u00020\u0000H\u0007¢\u0006\u0004\b7\u00108\u001a\u0018\u0010:\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b:\u0010;\u001a\u0018\u0010<\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b<\u0010;\u001a\u0018\u0010=\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b=\u0010;\u001a\u0018\u0010(\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b(\u0010;\u001a\u0018\u0010>\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b>\u0010;\u001a\u0018\u0010?\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b?\u0010;\u001a \u0010@\u001a\u0002092\u0006\u0010\t\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b@\u0010A\u001a\u0018\u0010B\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bB\u0010;\u001a\u0018\u0010C\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bC\u0010;\u001a\u0018\u0010D\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bD\u0010;\u001a\u0018\u0010E\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bE\u0010;\u001a\u0018\u0010F\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bF\u0010;\u001a\u0018\u0010G\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bG\u0010;\u001a \u0010H\u001a\u0002092\u0006\u0010\u0001\u001a\u0002092\u0006\u0010\t\u001a\u000209H\b¢\u0006\u0004\bH\u0010A\u001a\u0018\u0010I\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bI\u0010;\u001a\u0018\u0010J\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bJ\u0010;\u001a\u0018\u0010K\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bK\u0010;\u001a\u001f\u0010L\u001a\u0002092\u0006\u0010\u0001\u001a\u0002092\u0006\u0010\u0016\u001a\u000209H\u0007¢\u0006\u0004\bL\u0010A\u001a\u0018\u0010M\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bM\u0010;\u001a\u0018\u0010N\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bN\u0010;\u001a\u0017\u0010O\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\u0007¢\u0006\u0004\bO\u0010;\u001a\u0018\u0010P\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bP\u0010;\u001a\u0018\u0010Q\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bQ\u0010;\u001a\u0018\u0010R\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bR\u0010;\u001a\u0017\u0010S\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\u0007¢\u0006\u0004\bS\u0010;\u001a\u0018\u0010T\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bT\u0010;\u001a\u0018\u0010U\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bU\u0010;\u001a\u0018\u0010V\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bV\u0010;\u001a \u0010W\u001a\u0002092\u0006\u0010!\u001a\u0002092\u0006\u0010\"\u001a\u000209H\b¢\u0006\u0004\bW\u0010A\u001a \u0010X\u001a\u0002092\u0006\u0010!\u001a\u0002092\u0006\u0010\"\u001a\u000209H\b¢\u0006\u0004\bX\u0010A\u001a\u0018\u0010\u0001\u001a\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\b\u0001\u0010;\u001a\u001c\u0010Y\u001a\u000209*\u0002092\u0006\u0010\u0001\u001a\u000209H\b¢\u0006\u0004\bY\u0010A\u001a\u001c\u0010Z\u001a\u000209*\u0002092\u0006\u0010(\u001a\u00020'H\b¢\u0006\u0004\bZ\u0010[\u001a\u001c\u0010\\\u001a\u000209*\u0002092\u0006\u0010+\u001a\u000209H\b¢\u0006\u0004\b\\\u0010A\u001a\u001c\u0010]\u001a\u000209*\u0002092\u0006\u0010-\u001a\u000209H\b¢\u0006\u0004\b]\u0010A\u001a\u001c\u0010^\u001a\u000209*\u0002092\u0006\u0010-\u001a\u00020'H\b¢\u0006\u0004\b^\u0010[\u001a\u0014\u0010_\u001a\u000209*\u000209H\b¢\u0006\u0004\b_\u0010;\u001a\u0014\u0010`\u001a\u000209*\u000209H\b¢\u0006\u0004\b`\u0010;\u001a\u001c\u0010a\u001a\u000209*\u0002092\u0006\u00102\u001a\u000209H\b¢\u0006\u0004\ba\u0010A\u001a\u0013\u0010b\u001a\u00020'*\u000209H\u0007¢\u0006\u0004\bb\u0010c\u001a\u0013\u0010d\u001a\u000206*\u000209H\u0007¢\u0006\u0004\bd\u0010e\u001a\u0018\u0010f\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\b¢\u0006\u0004\bf\u0010g\u001a \u0010h\u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\b¢\u0006\u0004\bh\u0010i\u001a \u0010j\u001a\u00020'2\u0006\u0010!\u001a\u00020'2\u0006\u0010\"\u001a\u00020'H\b¢\u0006\u0004\bj\u0010i\u001a\u0018\u0010k\u001a\u0002062\u0006\u0010(\u001a\u000206H\b¢\u0006\u0004\bk\u0010l\u001a \u0010m\u001a\u0002062\u0006\u0010!\u001a\u0002062\u0006\u0010\"\u001a\u000206H\b¢\u0006\u0004\bm\u0010n\u001a \u0010o\u001a\u0002062\u0006\u0010!\u001a\u0002062\u0006\u0010\"\u001a\u000206H\b¢\u0006\u0004\bo\u0010n\"\u001f\u0010s\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0004¢\u0006\f\u0012\u0004\bq\u0010r\u001a\u0004\bp\u0010\u0003\"\u001f\u0010-\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0004¢\u0006\f\u0012\u0004\bu\u0010r\u001a\u0004\bt\u0010\u0003\"\u001f\u0010x\u001a\u00020\u0000*\u00020\u00008Æ\u0002X\u0004¢\u0006\f\u0012\u0004\bw\u0010r\u001a\u0004\bv\u0010\u0003\"\u001f\u0010s\u001a\u000209*\u0002098Æ\u0002X\u0004¢\u0006\f\u0012\u0004\bz\u0010{\u001a\u0004\by\u0010;\"\u001f\u0010-\u001a\u000209*\u0002098Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b}\u0010{\u001a\u0004\b|\u0010;\"\u001f\u0010x\u001a\u000209*\u0002098Æ\u0002X\u0004¢\u0006\f\u0012\u0004\b\u0010{\u001a\u0004\b~\u0010;\"\"\u0010s\u001a\u00020'*\u00020'8Æ\u0002X\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010g\"!\u0010-\u001a\u00020'*\u00020'8FX\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010g\"\"\u0010s\u001a\u000206*\u0002068Æ\u0002X\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010l\"\"\u0010-\u001a\u00020'*\u0002068FX\u0004¢\u0006\u0010\u0012\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"", "x", "Q0", "(D)D", "A", "W0", "m", "i", "q", "y", "s", "(DD)D", "S0", "C", "Y0", "o", "k", "u", "e0", "U0", "E", "G", "base", "k0", "g0", "m0", "o0", "i0", "I", "a1", "I0", "e", "O0", "a", "b", "u0", "q0", "w", "E0", "", "n", "F0", "(DI)D", "divisor", "c", "sign", "c1", "d1", "C0", "y0", "to", "A0", "K0", "(D)I", "", "M0", "(D)J", "", "R0", "(F)F", "B", "X0", "j", "r", "t", "(FF)F", "T0", "D", "Z0", "p", "l", "v", "f0", "V0", "F", "H", "l0", "h0", "n0", "p0", "j0", "z", "J", "b1", "J0", "f", "P0", "v0", "r0", "G0", "H0", "(FI)F", "d", "e1", "f1", "D0", "z0", "B0", "L0", "(F)I", "N0", "(F)J", "g", "(I)I", "w0", "(II)I", "s0", "h", "(J)J", "x0", "(JJ)J", "t0", "K", "O", "(D)V", "absoluteValue", "S", "W", "a0", "c0", "ulp", "L", "P", "(F)V", "T", "X", "b0", "d0", "M", "Q", "(I)V", "U", "Y", "N", "R", "(J)V", "V", "(J)I", "Z", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/math/MathKt")
class MathKt__MathJVMKt extends MathKt__MathHKt {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A(double d2) {
        return Math.cos(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double A0(double d2, double d3) {
        return Math.nextAfter(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B(float f2) {
        return (float) Math.cos((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float B0(float f2, float f3) {
        return Math.nextAfter(f2, (double) f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C(double d2) {
        return Math.cosh(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double C0(double d2) {
        return Math.nextUp(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float D(float f2) {
        return (float) Math.cosh((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float D0(float f2) {
        return Math.nextUp(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double E(double d2) {
        return Math.exp(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double E0(double d2, double d3) {
        return Math.pow(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float F(float f2) {
        return (float) Math.exp((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double F0(double d2, int i2) {
        return Math.pow(d2, (double) i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double G(double d2) {
        return Math.expm1(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float G0(float f2, float f3) {
        return (float) Math.pow((double) f2, (double) f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H(float f2) {
        return (float) Math.expm1((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float H0(float f2, int i2) {
        return (float) Math.pow((double) f2, (double) i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double I(double d2) {
        return Math.floor(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double I0(double d2) {
        return Math.rint(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float J(float f2) {
        return (float) Math.floor((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float J0(float f2) {
        return (float) Math.rint((double) f2);
    }

    private static final double K(double d2) {
        return Math.abs(d2);
    }

    @SinceKotlin(version = "1.2")
    public static int K0(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d2 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d2 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d2);
        }
    }

    private static final float L(float f2) {
        return Math.abs(f2);
    }

    @SinceKotlin(version = "1.2")
    public static final int L0(float f2) {
        if (!Float.isNaN(f2)) {
            return Math.round(f2);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final int M(int i2) {
        return Math.abs(i2);
    }

    @SinceKotlin(version = "1.2")
    public static long M0(double d2) {
        if (!Double.isNaN(d2)) {
            return Math.round(d2);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    private static final long N(long j2) {
        return Math.abs(j2);
    }

    @SinceKotlin(version = "1.2")
    public static final long N0(float f2) {
        return MathKt.M0((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void O(double d2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double O0(double d2) {
        return Math.signum(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void P(float f2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float P0(float f2) {
        return Math.signum(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void Q(int i2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double Q0(double d2) {
        return Math.sin(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void R(long j2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float R0(float f2) {
        return (float) Math.sin((double) f2);
    }

    private static final double S(double d2) {
        return Math.signum(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double S0(double d2) {
        return Math.sinh(d2);
    }

    private static final float T(float f2) {
        return Math.signum(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float T0(float f2) {
        return (float) Math.sinh((double) f2);
    }

    public static int U(int i2) {
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double U0(double d2) {
        return Math.sqrt(d2);
    }

    public static int V(long j2) {
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 > 0 ? 1 : 0;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float V0(float f2) {
        return (float) Math.sqrt((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void W(double d2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double W0(double d2) {
        return Math.tan(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void X(float f2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float X0(float f2) {
        return (float) Math.tan((double) f2);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void Y(int i2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double Y0(double d2) {
        return Math.tanh(d2);
    }

    @SinceKotlin(version = "1.2")
    public static /* synthetic */ void Z(long j2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float Z0(float f2) {
        return (float) Math.tanh((double) f2);
    }

    private static final double a0(double d2) {
        return Math.ulp(d2);
    }

    @SinceKotlin(version = "1.2")
    public static final double a1(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            return d2;
        }
        return d2 > 0.0d ? Math.floor(d2) : Math.ceil(d2);
    }

    private static final float b0(float f2) {
        return Math.ulp(f2);
    }

    @SinceKotlin(version = "1.2")
    public static final float b1(float f2) {
        if (Float.isNaN(f2) || Float.isInfinite(f2)) {
            return f2;
        }
        return (float) (f2 > 0.0f ? Math.floor((double) f2) : Math.ceil((double) f2));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c(double d2, double d3) {
        return Math.IEEEremainder(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void c0(double d2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double c1(double d2, double d3) {
        return Math.copySign(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float d(float f2, float f3) {
        return (float) Math.IEEEremainder((double) f2, (double) f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    public static /* synthetic */ void d0(float f2) {
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double d1(double d2, int i2) {
        return Math.copySign(d2, (double) i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e(double d2) {
        return Math.abs(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double e0(double d2, double d3) {
        return Math.hypot(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float e1(float f2, float f3) {
        return Math.copySign(f2, f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f(float f2) {
        return Math.abs(f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f0(float f2, float f3) {
        return (float) Math.hypot((double) f2, (double) f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float f1(float f2, int i2) {
        return Math.copySign(f2, (float) i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int g(int i2) {
        return Math.abs(i2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double g0(double d2) {
        return Math.log(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long h(long j2) {
        return Math.abs(j2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float h0(float f2) {
        return (float) Math.log((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double i(double d2) {
        return Math.acos(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double i0(double d2) {
        return Math.log1p(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float j(float f2) {
        return (float) Math.acos((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float j0(float f2) {
        return (float) Math.log1p((double) f2);
    }

    @SinceKotlin(version = "1.2")
    public static final double k(double d2) {
        if (d2 < 1.0d) {
            return Double.NaN;
        }
        if (d2 > Constants.f28979f) {
            return Math.log(d2) + Constants.f28975b;
        }
        double d3 = (double) 1;
        double d4 = d2 - d3;
        if (d4 >= Constants.f28978e) {
            return Math.log(d2 + Math.sqrt((d2 * d2) - d3));
        }
        double sqrt = Math.sqrt(d4);
        if (sqrt >= Constants.f28977d) {
            sqrt -= ((sqrt * sqrt) * sqrt) / ((double) 12);
        }
        return sqrt * Math.sqrt(2.0d);
    }

    @SinceKotlin(version = "1.2")
    public static final double k0(double d2, double d3) {
        if (d3 <= 0.0d || d3 == 1.0d) {
            return Double.NaN;
        }
        return Math.log(d2) / Math.log(d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float l(float f2) {
        return (float) k((double) f2);
    }

    @SinceKotlin(version = "1.2")
    public static final float l0(float f2, float f3) {
        if (f3 <= 0.0f || f3 == 1.0f) {
            return Float.NaN;
        }
        return (float) (Math.log((double) f2) / Math.log((double) f3));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double m(double d2) {
        return Math.asin(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double m0(double d2) {
        return Math.log10(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float n(float f2) {
        return (float) Math.asin((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float n0(float f2) {
        return (float) Math.log10((double) f2);
    }

    @SinceKotlin(version = "1.2")
    public static final double o(double d2) {
        double sqrt;
        double d3 = Constants.f28978e;
        if (d2 >= d3) {
            if (d2 <= Constants.f28980g) {
                sqrt = Math.sqrt((d2 * d2) + ((double) 1));
            } else if (d2 > Constants.f28979f) {
                return Math.log(d2) + Constants.f28975b;
            } else {
                d2 *= (double) 2;
                sqrt = ((double) 1) / d2;
            }
            return Math.log(d2 + sqrt);
        } else if (d2 <= (-d3)) {
            return -o(-d2);
        } else {
            return Math.abs(d2) >= Constants.f28977d ? d2 - (((d2 * d2) * d2) / ((double) 6)) : d2;
        }
    }

    @SinceKotlin(version = "1.2")
    public static final double o0(double d2) {
        return Math.log(d2) / Constants.f28975b;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float p(float f2) {
        return (float) o((double) f2);
    }

    @SinceKotlin(version = "1.2")
    public static final float p0(float f2) {
        return (float) (Math.log((double) f2) / Constants.f28975b);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double q(double d2) {
        return Math.atan(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double q0(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float r(float f2) {
        return (float) Math.atan((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float r0(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double s(double d2, double d3) {
        return Math.atan2(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int s0(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float t(float f2, float f3) {
        return (float) Math.atan2((double) f2, (double) f3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long t0(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @SinceKotlin(version = "1.2")
    public static final double u(double d2) {
        if (Math.abs(d2) < Constants.f28978e) {
            return Math.abs(d2) > Constants.f28977d ? d2 + (((d2 * d2) * d2) / ((double) 3)) : d2;
        }
        double d3 = (double) 1;
        return Math.log((d3 + d2) / (d3 - d2)) / ((double) 2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double u0(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float v(float f2) {
        return (float) u((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float v0(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @SinceKotlin(version = "1.8")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final double w(double d2) {
        return Math.cbrt(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final int w0(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = "1.8")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final float x(float f2) {
        return (float) Math.cbrt((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final long x0(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y(double d2) {
        return Math.ceil(d2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final double y0(double d2) {
        return Math.nextAfter(d2, Double.NEGATIVE_INFINITY);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z(float f2) {
        return (float) Math.ceil((double) f2);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final float z0(float f2) {
        return Math.nextAfter(f2, Double.NEGATIVE_INFINITY);
    }
}
