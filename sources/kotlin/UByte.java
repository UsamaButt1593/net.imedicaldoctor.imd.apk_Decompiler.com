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
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b@\u0018\u0000 Z2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001[B\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\tJ\u001b\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\fJ\u001b\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u000fJ\u001b\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\tJ\u001b\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u001b\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0017J\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\tJ\u001b\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\fJ\u001b\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000fJ\u001b\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0017J\u001b\u0010 \u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\tJ\u001b\u0010!\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b!\u0010\fJ\u001b\u0010\"\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000fJ\u001b\u0010#\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0017J\u001b\u0010$\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b$\u0010\tJ\u001b\u0010%\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b%\u0010\fJ\u001b\u0010&\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u000fJ\u001b\u0010'\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b'\u0010\u0017J\u001b\u0010(\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\tJ\u001b\u0010)\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b)\u0010\fJ\u001b\u0010*\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010+\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u0017J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001b\u0010.\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u001b\u00100\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\bø\u0001\u0000¢\u0006\u0004\b0\u0010\u000fJ\u001b\u00101\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0017J\u0016\u00102\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005J\u0016\u00103\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u001b\u00105\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001b\u00107\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00106J\u001b\u00108\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b8\u0010-J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b9\u0010-J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b:\u0010-J\u0016\u0010;\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b;\u0010\u0005J\u0010\u0010<\u001a\u00020\u0002H\b¢\u0006\u0004\b<\u0010\u0005J\u0010\u0010>\u001a\u00020=H\b¢\u0006\u0004\b>\u0010?J\u0010\u0010@\u001a\u00020\u0007H\b¢\u0006\u0004\b@\u0010AJ\u0010\u0010C\u001a\u00020BH\b¢\u0006\u0004\bC\u0010DJ\u0016\u0010E\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bE\u0010\u0005J\u0016\u0010F\u001a\u00020\nH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bF\u0010?J\u0016\u0010G\u001a\u00020\rH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010AJ\u0016\u0010H\u001a\u00020\u0010H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010DJ\u0010\u0010J\u001a\u00020IH\b¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\bR\u0010AJ\u001a\u0010U\u001a\u00020T2\b\u0010\u0006\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bU\u0010VR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b*\u0010W\u0012\u0004\bX\u0010Y\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\\"}, d2 = {"Lkotlin/UByte;", "", "", "data", "i", "(B)B", "other", "", "e", "(BB)I", "Lkotlin/UShort;", "h", "(BS)I", "Lkotlin/UInt;", "g", "(BI)I", "Lkotlin/ULong;", "f", "(BJ)I", "J", "N", "L", "K", "(BJ)J", "z", "D", "C", "A", "U", "a0", "Z", "W", "k", "n", "m", "l", "Q", "T", "S", "R", "q", "u", "s", "r", "E", "(BB)B", "H", "(BS)S", "G", "F", "x", "j", "Lkotlin/ranges/UIntRange;", "O", "(BB)Lkotlin/ranges/UIntRange;", "P", "a", "I", "s0", "y", "c0", "", "i0", "(B)S", "g0", "(B)I", "", "h0", "(B)J", "k0", "q0", "m0", "p0", "", "e0", "(B)F", "", "d0", "(B)D", "", "j0", "(B)Ljava/lang/String;", "w", "", "", "o", "(BLjava/lang/Object;)Z", "B", "v", "()V", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UByte implements Comparable<UByte> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    public static final int X2 = 1;
    public static final byte Y = 0;
    public static final int Y2 = 8;
    public static final byte Z = -1;
    private final byte s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UByte(byte b2) {
        this.s = b2;
    }

    @InlineOnly
    private static final long A(byte b2, long j2) {
        return ULong.i(ULong.i(((long) b2) & 255) - j2);
    }

    @InlineOnly
    private static final int C(byte b2, int i2) {
        return UInt.i(UInt.i(b2 & 255) - i2);
    }

    @InlineOnly
    private static final int D(byte b2, short s2) {
        return UInt.i(UInt.i(b2 & 255) - UInt.i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final byte E(byte b2, byte b3) {
        return i((byte) b.a(UInt.i(b2 & 255), UInt.i(b3 & 255)));
    }

    @InlineOnly
    private static final long F(byte b2, long j2) {
        return c.a(ULong.i(((long) b2) & 255), j2);
    }

    @InlineOnly
    private static final int G(byte b2, int i2) {
        return b.a(UInt.i(b2 & 255), i2);
    }

    @InlineOnly
    private static final short H(byte b2, short s2) {
        return UShort.i((short) b.a(UInt.i(b2 & 255), UInt.i(s2 & UShort.Z)));
    }

    @InlineOnly
    private static final byte I(byte b2, byte b3) {
        return i((byte) (b2 | b3));
    }

    @InlineOnly
    private static final int J(byte b2, byte b3) {
        return UInt.i(UInt.i(b2 & 255) + UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final long K(byte b2, long j2) {
        return ULong.i(ULong.i(((long) b2) & 255) + j2);
    }

    @InlineOnly
    private static final int L(byte b2, int i2) {
        return UInt.i(UInt.i(b2 & 255) + i2);
    }

    @InlineOnly
    private static final int N(byte b2, short s2) {
        return UInt.i(UInt.i(b2 & 255) + UInt.i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final UIntRange O(byte b2, byte b3) {
        return new UIntRange(UInt.i(b2 & 255), UInt.i(b3 & 255), (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final UIntRange P(byte b2, byte b3) {
        return URangesKt.V(UInt.i(b2 & 255), UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final int Q(byte b2, byte b3) {
        return b.a(UInt.i(b2 & 255), UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final long R(byte b2, long j2) {
        return c.a(ULong.i(((long) b2) & 255), j2);
    }

    @InlineOnly
    private static final int S(byte b2, int i2) {
        return b.a(UInt.i(b2 & 255), i2);
    }

    @InlineOnly
    private static final int T(byte b2, short s2) {
        return b.a(UInt.i(b2 & 255), UInt.i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final int U(byte b2, byte b3) {
        return UInt.i(UInt.i(b2 & 255) * UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final long W(byte b2, long j2) {
        return ULong.i(ULong.i(((long) b2) & 255) * j2);
    }

    @InlineOnly
    private static final int Z(byte b2, int i2) {
        return UInt.i(UInt.i(b2 & 255) * i2);
    }

    @InlineOnly
    private static final byte a(byte b2, byte b3) {
        return i((byte) (b2 & b3));
    }

    @InlineOnly
    private static final int a0(byte b2, short s2) {
        return UInt.i(UInt.i(b2 & 255) * UInt.i(s2 & UShort.Z));
    }

    public static final /* synthetic */ UByte b(byte b2) {
        return new UByte(b2);
    }

    @InlineOnly
    private int c(byte b2) {
        return Intrinsics.t(r0() & 255, b2 & 255);
    }

    @InlineOnly
    private static final byte c0(byte b2) {
        return b2;
    }

    @InlineOnly
    private static final double d0(byte b2) {
        return (double) (b2 & 255);
    }

    @InlineOnly
    private static int e(byte b2, byte b3) {
        return Intrinsics.t(b2 & 255, b3 & 255);
    }

    @InlineOnly
    private static final float e0(byte b2) {
        return (float) (b2 & 255);
    }

    @InlineOnly
    private static final int f(byte b2, long j2) {
        return Long.compare(ULong.i(((long) b2) & 255) ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final int g(byte b2, int i2) {
        return Integer.compare(UInt.i(b2 & 255) ^ Integer.MIN_VALUE, i2 ^ Integer.MIN_VALUE);
    }

    @InlineOnly
    private static final int g0(byte b2) {
        return b2 & 255;
    }

    @InlineOnly
    private static final int h(byte b2, short s2) {
        return Intrinsics.t(b2 & 255, s2 & UShort.Z);
    }

    @InlineOnly
    private static final long h0(byte b2) {
        return ((long) b2) & 255;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static byte i(byte b2) {
        return b2;
    }

    @InlineOnly
    private static final short i0(byte b2) {
        return (short) (((short) b2) & 255);
    }

    @InlineOnly
    private static final byte j(byte b2) {
        return i((byte) (b2 - 1));
    }

    @NotNull
    public static String j0(byte b2) {
        return String.valueOf(b2 & 255);
    }

    @InlineOnly
    private static final int k(byte b2, byte b3) {
        return a.a(UInt.i(b2 & 255), UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final byte k0(byte b2) {
        return b2;
    }

    @InlineOnly
    private static final long l(byte b2, long j2) {
        return d.a(ULong.i(((long) b2) & 255), j2);
    }

    @InlineOnly
    private static final int m(byte b2, int i2) {
        return a.a(UInt.i(b2 & 255), i2);
    }

    @InlineOnly
    private static final int m0(byte b2) {
        return UInt.i(b2 & 255);
    }

    @InlineOnly
    private static final int n(byte b2, short s2) {
        return a.a(UInt.i(b2 & 255), UInt.i(s2 & UShort.Z));
    }

    public static boolean o(byte b2, Object obj) {
        return (obj instanceof UByte) && b2 == ((UByte) obj).r0();
    }

    public static final boolean p(byte b2, byte b3) {
        return b2 == b3;
    }

    @InlineOnly
    private static final long p0(byte b2) {
        return ULong.i(((long) b2) & 255);
    }

    @InlineOnly
    private static final int q(byte b2, byte b3) {
        return a.a(UInt.i(b2 & 255), UInt.i(b3 & 255));
    }

    @InlineOnly
    private static final short q0(byte b2) {
        return UShort.i((short) (((short) b2) & 255));
    }

    @InlineOnly
    private static final long r(byte b2, long j2) {
        return d.a(ULong.i(((long) b2) & 255), j2);
    }

    @InlineOnly
    private static final int s(byte b2, int i2) {
        return a.a(UInt.i(b2 & 255), i2);
    }

    @InlineOnly
    private static final byte s0(byte b2, byte b3) {
        return i((byte) (b2 ^ b3));
    }

    @InlineOnly
    private static final int u(byte b2, short s2) {
        return a.a(UInt.i(b2 & 255), UInt.i(s2 & UShort.Z));
    }

    @PublishedApi
    public static /* synthetic */ void v() {
    }

    public static int w(byte b2) {
        return b2;
    }

    @InlineOnly
    private static final byte x(byte b2) {
        return i((byte) (b2 + 1));
    }

    @InlineOnly
    private static final byte y(byte b2) {
        return i((byte) (~b2));
    }

    @InlineOnly
    private static final int z(byte b2, byte b3) {
        return UInt.i(UInt.i(b2 & 255) - UInt.i(b3 & 255));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.t(r0() & 255, ((UByte) obj).r0() & 255);
    }

    public boolean equals(Object obj) {
        return o(this.s, obj);
    }

    public int hashCode() {
        return w(this.s);
    }

    public final /* synthetic */ byte r0() {
        return this.s;
    }

    @NotNull
    public String toString() {
        return j0(this.s);
    }
}
