package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0018\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\b¢\u0006\u0004\b\u0007\u0010\b\u001a \u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\b¢\u0006\u0004\b\n\u0010\u000b\u001a \u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\b¢\u0006\u0004\b\r\u0010\u000e\u001a \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0012H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a7\u0010\u0019\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a(\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a(\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a(\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\b¢\u0006\u0004\b\u001f\u0010 \u001a(\u0010!\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\b¢\u0006\u0004\b!\u0010\"\u001a(\u0010#\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\b¢\u0006\u0004\b#\u0010$\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\b¢\u0006\u0004\b%\u0010&\u001a;\u0010)\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000'\"\u00028\u0000H\u0007¢\u0006\u0004\b)\u0010*\u001a#\u0010,\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010(\u001a\u00020+\"\u00020\u0006H\u0007¢\u0006\u0004\b,\u0010-\u001a#\u0010/\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010(\u001a\u00020.\"\u00020\tH\u0007¢\u0006\u0004\b/\u00100\u001a#\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010(\u001a\u000201\"\u00020\fH\u0007¢\u0006\u0004\b\u0001\u00102\u001a#\u00104\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010(\u001a\u000203\"\u00020\u000fH\u0007¢\u0006\u0004\b4\u00105\u001a#\u00107\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\n\u0010(\u001a\u000206\"\u00020\u0012H\u0007¢\u0006\u0004\b7\u00108\u001a#\u0010:\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010(\u001a\u000209\"\u00020\u0015H\u0007¢\u0006\u0004\b:\u0010;\u001a/\u0010<\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b<\u0010\u0005\u001a \u0010=\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\b¢\u0006\u0004\b=\u0010\b\u001a \u0010>\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\b¢\u0006\u0004\b>\u0010\u000b\u001a \u0010?\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\b¢\u0006\u0004\b?\u0010\u000e\u001a \u0010@\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\b¢\u0006\u0004\b@\u0010\u0011\u001a \u0010A\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0012H\b¢\u0006\u0004\bA\u0010\u0014\u001a \u0010B\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\b¢\u0006\u0004\bB\u0010\u0017\u001a7\u0010C\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u0000H\u0007¢\u0006\u0004\bC\u0010\u001a\u001a(\u0010D\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\b¢\u0006\u0004\bD\u0010\u001c\u001a(\u0010E\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\b¢\u0006\u0004\bE\u0010\u001e\u001a(\u0010F\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\b¢\u0006\u0004\bF\u0010 \u001a(\u0010G\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\b¢\u0006\u0004\bG\u0010\"\u001a(\u0010H\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0012H\b¢\u0006\u0004\bH\u0010$\u001a(\u0010I\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\b¢\u0006\u0004\bI\u0010&\u001a;\u0010J\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010(\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000'\"\u00028\u0000H\u0007¢\u0006\u0004\bJ\u0010*\u001a#\u0010K\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010(\u001a\u00020+\"\u00020\u0006H\u0007¢\u0006\u0004\bK\u0010-\u001a#\u0010L\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010(\u001a\u00020.\"\u00020\tH\u0007¢\u0006\u0004\bL\u00100\u001a#\u0010M\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010(\u001a\u000201\"\u00020\fH\u0007¢\u0006\u0004\bM\u00102\u001a#\u0010N\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010(\u001a\u000203\"\u00020\u000fH\u0007¢\u0006\u0004\bN\u00105\u001a#\u0010O\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00122\n\u0010(\u001a\u000206\"\u00020\u0012H\u0007¢\u0006\u0004\bO\u00108\u001a#\u0010P\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010(\u001a\u000209\"\u00020\u0015H\u0007¢\u0006\u0004\bP\u0010;¨\u0006Q"}, d2 = {"", "T", "a", "b", "X", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "I", "(BB)B", "", "a0", "(SS)S", "", "R", "(II)I", "", "U", "(JJ)J", "", "O", "(FF)F", "", "L", "(DD)D", "c", "Y", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "J", "(BBB)B", "b0", "(SSS)S", "S", "(III)I", "V", "(JJJ)J", "P", "(FFF)F", "M", "(DDD)D", "", "other", "Z", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "K", "(B[B)B", "", "c0", "(S[S)S", "", "(I[I)I", "", "W", "(J[J)J", "", "Q", "(F[F)F", "", "N", "(D[D)D", "s0", "d0", "v0", "m0", "p0", "j0", "g0", "t0", "e0", "w0", "n0", "q0", "k0", "h0", "u0", "f0", "x0", "o0", "r0", "l0", "i0", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xs = "kotlin/comparisons/ComparisonsKt")
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte I(byte b2, byte b3) {
        return (byte) Math.max(b2, b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte J(byte b2, byte b3, byte b4) {
        return (byte) Math.max(b2, Math.max(b3, b4));
    }

    @SinceKotlin(version = "1.4")
    public static final byte K(byte b2, @NotNull byte... bArr) {
        Intrinsics.p(bArr, "other");
        for (byte max : bArr) {
            b2 = (byte) Math.max(b2, max);
        }
        return b2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double L(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double M(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @SinceKotlin(version = "1.4")
    public static final double N(double d2, @NotNull double... dArr) {
        Intrinsics.p(dArr, "other");
        for (double max : dArr) {
            d2 = Math.max(d2, max);
        }
        return d2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float O(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float P(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @SinceKotlin(version = "1.4")
    public static final float Q(float f2, @NotNull float... fArr) {
        Intrinsics.p(fArr, "other");
        for (float max : fArr) {
            f2 = Math.max(f2, max);
        }
        return f2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int R(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int S(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @SinceKotlin(version = "1.4")
    public static final int T(int i2, @NotNull int... iArr) {
        Intrinsics.p(iArr, "other");
        for (int max : iArr) {
            i2 = Math.max(i2, max);
        }
        return i2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long U(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long V(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @SinceKotlin(version = "1.4")
    public static final long W(long j2, @NotNull long... jArr) {
        Intrinsics.p(jArr, "other");
        for (long max : jArr) {
            j2 = Math.max(j2, max);
        }
        return j2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static <T extends Comparable<? super T>> T X(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "a");
        Intrinsics.p(t2, "b");
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T Y(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.p(t, "a");
        Intrinsics.p(t2, "b");
        Intrinsics.p(t3, "c");
        return ComparisonsKt.X(t, ComparisonsKt.X(t2, t3));
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T Z(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.p(t, "a");
        Intrinsics.p(tArr, "other");
        for (T X : tArr) {
            t = ComparisonsKt.X(t, X);
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short a0(short s, short s2) {
        return (short) Math.max(s, s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short b0(short s, short s2, short s3) {
        return (short) Math.max(s, Math.max(s2, s3));
    }

    @SinceKotlin(version = "1.4")
    public static final short c0(short s, @NotNull short... sArr) {
        Intrinsics.p(sArr, "other");
        for (short max : sArr) {
            s = (short) Math.max(s, max);
        }
        return s;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte d0(byte b2, byte b3) {
        return (byte) Math.min(b2, b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte e0(byte b2, byte b3, byte b4) {
        return (byte) Math.min(b2, Math.min(b3, b4));
    }

    @SinceKotlin(version = "1.4")
    public static final byte f0(byte b2, @NotNull byte... bArr) {
        Intrinsics.p(bArr, "other");
        for (byte min : bArr) {
            b2 = (byte) Math.min(b2, min);
        }
        return b2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double g0(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double h0(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }

    @SinceKotlin(version = "1.4")
    public static final double i0(double d2, @NotNull double... dArr) {
        Intrinsics.p(dArr, "other");
        for (double min : dArr) {
            d2 = Math.min(d2, min);
        }
        return d2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float j0(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float k0(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @SinceKotlin(version = "1.4")
    public static final float l0(float f2, @NotNull float... fArr) {
        Intrinsics.p(fArr, "other");
        for (float min : fArr) {
            f2 = Math.min(f2, min);
        }
        return f2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int m0(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int n0(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @SinceKotlin(version = "1.4")
    public static final int o0(int i2, @NotNull int... iArr) {
        Intrinsics.p(iArr, "other");
        for (int min : iArr) {
            i2 = Math.min(i2, min);
        }
        return i2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long p0(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long q0(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @SinceKotlin(version = "1.4")
    public static final long r0(long j2, @NotNull long... jArr) {
        Intrinsics.p(jArr, "other");
        for (long min : jArr) {
            j2 = Math.min(j2, min);
        }
        return j2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T s0(@NotNull T t, @NotNull T t2) {
        Intrinsics.p(t, "a");
        Intrinsics.p(t2, "b");
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @NotNull
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T t0(@NotNull T t, @NotNull T t2, @NotNull T t3) {
        Intrinsics.p(t, "a");
        Intrinsics.p(t2, "b");
        Intrinsics.p(t3, "c");
        return s0(t, s0(t2, t3));
    }

    @NotNull
    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T u0(@NotNull T t, @NotNull T... tArr) {
        Intrinsics.p(t, "a");
        Intrinsics.p(tArr, "other");
        for (T s0 : tArr) {
            t = s0(t, s0);
        }
        return t;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short v0(short s, short s2) {
        return (short) Math.min(s, s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short w0(short s, short s2, short s3) {
        return (short) Math.min(s, Math.min(s2, s3));
    }

    @SinceKotlin(version = "1.4")
    public static final short x0(short s, @NotNull short... sArr) {
        Intrinsics.p(sArr, "other");
        for (short min : sArr) {
            s = (short) Math.min(s, min);
        }
        return s;
    }
}
