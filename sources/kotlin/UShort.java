package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0005\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b@\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001ZB\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\nJ\u001b\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u001b\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000fJ\u001b\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\nJ\u001b\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u001b\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017J\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\nJ\u001b\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\fJ\u001b\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000fJ\u001b\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0017J\u001b\u0010 \u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b \u0010\nJ\u001b\u0010!\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b!\u0010\fJ\u001b\u0010\"\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000fJ\u001b\u0010#\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0017J\u001b\u0010$\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b$\u0010\nJ\u001b\u0010%\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b%\u0010\fJ\u001b\u0010&\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b'\u0010\u0017J\u001b\u0010(\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\nJ\u001b\u0010)\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\fJ\u001b\u0010*\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010+\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u0017J\u001b\u0010,\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u00101\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u0016\u00102\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005J\u0016\u00103\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u001b\u00105\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0002042\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00106J\u001b\u00108\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b8\u0010/J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b9\u0010/J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b:\u0010/J\u0016\u0010;\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010\u0005J\u0010\u0010=\u001a\u00020<H\b¢\u0006\u0004\b=\u0010>J\u0010\u0010?\u001a\u00020\u0002H\b¢\u0006\u0004\b?\u0010\u0005J\u0010\u0010@\u001a\u00020\bH\b¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BH\b¢\u0006\u0004\bC\u0010DJ\u0016\u0010E\u001a\u00020\u0006H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010>J\u0016\u0010F\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010\u0005J\u0016\u0010G\u001a\u00020\rH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010AJ\u0016\u0010H\u001a\u00020\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ\u0010\u0010J\u001a\u00020IH\b¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\bHÖ\u0001¢\u0006\u0004\bR\u0010AJ\u001a\u0010U\u001a\u00020T2\b\u0010\u0007\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bU\u0010VR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b*\u0010&\u0012\u0004\bW\u0010X\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006["}, d2 = {"Lkotlin/UShort;", "", "", "data", "i", "(S)S", "Lkotlin/UByte;", "other", "", "c", "(SB)I", "h", "(SS)I", "Lkotlin/UInt;", "f", "(SI)I", "Lkotlin/ULong;", "e", "(SJ)I", "J", "N", "L", "K", "(SJ)J", "z", "D", "C", "A", "U", "a0", "Z", "W", "k", "n", "m", "l", "Q", "T", "S", "R", "q", "u", "s", "r", "E", "(SB)B", "H", "(SS)S", "G", "F", "x", "j", "Lkotlin/ranges/UIntRange;", "O", "(SS)Lkotlin/ranges/UIntRange;", "P", "a", "I", "s0", "y", "", "c0", "(S)B", "i0", "g0", "(S)I", "", "h0", "(S)J", "k0", "q0", "m0", "p0", "", "e0", "(S)F", "", "d0", "(S)D", "", "j0", "(S)Ljava/lang/String;", "w", "", "", "o", "(SLjava/lang/Object;)Z", "v", "()V", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UShort implements Comparable<UShort> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    public static final int X2 = 2;
    public static final short Y = 0;
    public static final int Y2 = 16;
    public static final short Z = -1;
    private final short s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UShort(short s2) {
        this.s = s2;
    }

    @InlineOnly
    private static final long A(short s2, long j2) {
        return ULong.i(ULong.i(((long) s2) & 65535) - j2);
    }

    @InlineOnly
    private static final int C(short s2, int i2) {
        return UInt.i(UInt.i(s2 & Z) - i2);
    }

    @InlineOnly
    private static final int D(short s2, short s3) {
        return UInt.i(UInt.i(s2 & Z) - UInt.i(s3 & Z));
    }

    @InlineOnly
    private static final byte E(short s2, byte b2) {
        return UByte.i((byte) b.a(UInt.i(s2 & Z), UInt.i(b2 & 255)));
    }

    @InlineOnly
    private static final long F(short s2, long j2) {
        return c.a(ULong.i(((long) s2) & 65535), j2);
    }

    @InlineOnly
    private static final int G(short s2, int i2) {
        return b.a(UInt.i(s2 & Z), i2);
    }

    @InlineOnly
    private static final short H(short s2, short s3) {
        return i((short) b.a(UInt.i(s2 & Z), UInt.i(s3 & Z)));
    }

    @InlineOnly
    private static final short I(short s2, short s3) {
        return i((short) (s2 | s3));
    }

    @InlineOnly
    private static final int J(short s2, byte b2) {
        return UInt.i(UInt.i(s2 & Z) + UInt.i(b2 & 255));
    }

    @InlineOnly
    private static final long K(short s2, long j2) {
        return ULong.i(ULong.i(((long) s2) & 65535) + j2);
    }

    @InlineOnly
    private static final int L(short s2, int i2) {
        return UInt.i(UInt.i(s2 & Z) + i2);
    }

    @InlineOnly
    private static final int N(short s2, short s3) {
        return UInt.i(UInt.i(s2 & Z) + UInt.i(s3 & Z));
    }

    @InlineOnly
    private static final UIntRange O(short s2, short s3) {
        return new UIntRange(UInt.i(s2 & Z), UInt.i(s3 & Z), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final UIntRange P(short s2, short s3) {
        return URangesKt.V(UInt.i(s2 & Z), UInt.i(s3 & Z));
    }

    @InlineOnly
    private static final int Q(short s2, byte b2) {
        return b.a(UInt.i(s2 & Z), UInt.i(b2 & 255));
    }

    @InlineOnly
    private static final long R(short s2, long j2) {
        return c.a(ULong.i(((long) s2) & 65535), j2);
    }

    @InlineOnly
    private static final int S(short s2, int i2) {
        return b.a(UInt.i(s2 & Z), i2);
    }

    @InlineOnly
    private static final int T(short s2, short s3) {
        return b.a(UInt.i(s2 & Z), UInt.i(s3 & Z));
    }

    @InlineOnly
    private static final int U(short s2, byte b2) {
        return UInt.i(UInt.i(s2 & Z) * UInt.i(b2 & 255));
    }

    @InlineOnly
    private static final long W(short s2, long j2) {
        return ULong.i(ULong.i(((long) s2) & 65535) * j2);
    }

    @InlineOnly
    private static final int Z(short s2, int i2) {
        return UInt.i(UInt.i(s2 & Z) * i2);
    }

    @InlineOnly
    private static final short a(short s2, short s3) {
        return i((short) (s2 & s3));
    }

    @InlineOnly
    private static final int a0(short s2, short s3) {
        return UInt.i(UInt.i(s2 & Z) * UInt.i(s3 & Z));
    }

    public static final /* synthetic */ UShort b(short s2) {
        return new UShort(s2);
    }

    @InlineOnly
    private static final int c(short s2, byte b2) {
        return Intrinsics.t(s2 & Z, b2 & 255);
    }

    @InlineOnly
    private static final byte c0(short s2) {
        return (byte) s2;
    }

    @InlineOnly
    private static final double d0(short s2) {
        return (double) (s2 & Z);
    }

    @InlineOnly
    private static final int e(short s2, long j2) {
        return Long.compare(ULong.i(((long) s2) & 65535) ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final float e0(short s2) {
        return (float) (s2 & Z);
    }

    @InlineOnly
    private static final int f(short s2, int i2) {
        return Integer.compare(UInt.i(s2 & Z) ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @InlineOnly
    private int g(short s2) {
        return Intrinsics.t(r0() & Z, s2 & Z);
    }

    @InlineOnly
    private static final int g0(short s2) {
        return s2 & Z;
    }

    @InlineOnly
    private static int h(short s2, short s3) {
        return Intrinsics.t(s2 & Z, s3 & Z);
    }

    @InlineOnly
    private static final long h0(short s2) {
        return ((long) s2) & 65535;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static short i(short s2) {
        return s2;
    }

    @InlineOnly
    private static final short i0(short s2) {
        return s2;
    }

    @InlineOnly
    private static final short j(short s2) {
        return i((short) (s2 - 1));
    }

    @NotNull
    public static String j0(short s2) {
        return String.valueOf(s2 & Z);
    }

    @InlineOnly
    private static final int k(short s2, byte b2) {
        return a.a(UInt.i(s2 & Z), UInt.i(b2 & 255));
    }

    @InlineOnly
    private static final byte k0(short s2) {
        return UByte.i((byte) s2);
    }

    @InlineOnly
    private static final long l(short s2, long j2) {
        return d.a(ULong.i(((long) s2) & 65535), j2);
    }

    @InlineOnly
    private static final int m(short s2, int i2) {
        return a.a(UInt.i(s2 & Z), i2);
    }

    @InlineOnly
    private static final int m0(short s2) {
        return UInt.i(s2 & Z);
    }

    @InlineOnly
    private static final int n(short s2, short s3) {
        return a.a(UInt.i(s2 & Z), UInt.i(s3 & Z));
    }

    public static boolean o(short s2, Object obj) {
        return (obj instanceof UShort) && s2 == ((UShort) obj).r0();
    }

    public static final boolean p(short s2, short s3) {
        return s2 == s3;
    }

    @InlineOnly
    private static final long p0(short s2) {
        return ULong.i(((long) s2) & 65535);
    }

    @InlineOnly
    private static final int q(short s2, byte b2) {
        return a.a(UInt.i(s2 & Z), UInt.i(b2 & 255));
    }

    @InlineOnly
    private static final short q0(short s2) {
        return s2;
    }

    @InlineOnly
    private static final long r(short s2, long j2) {
        return d.a(ULong.i(((long) s2) & 65535), j2);
    }

    @InlineOnly
    private static final int s(short s2, int i2) {
        return a.a(UInt.i(s2 & Z), i2);
    }

    @InlineOnly
    private static final short s0(short s2, short s3) {
        return i((short) (s2 ^ s3));
    }

    @InlineOnly
    private static final int u(short s2, short s3) {
        return a.a(UInt.i(s2 & Z), UInt.i(s3 & Z));
    }

    @PublishedApi
    public static /* synthetic */ void v() {
    }

    public static int w(short s2) {
        return s2;
    }

    @InlineOnly
    private static final short x(short s2) {
        return i((short) (s2 + 1));
    }

    @InlineOnly
    private static final short y(short s2) {
        return i((short) (~s2));
    }

    @InlineOnly
    private static final int z(short s2, byte b2) {
        return UInt.i(UInt.i(s2 & Z) - UInt.i(b2 & 255));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.t(r0() & Z, ((UShort) obj).r0() & Z);
    }

    public boolean equals(Object obj) {
        return o(this.s, obj);
    }

    public int hashCode() {
        return w(this.s);
    }

    public final /* synthetic */ short r0() {
        return this.s;
    }

    @NotNull
    public String toString() {
        return j0(this.s);
    }
}
