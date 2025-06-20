package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b@\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001]B\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\tJ\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\fJ\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000eJ\u001b\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\tJ\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\fJ\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u000eJ\u001b\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\tJ\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\fJ\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000eJ\u001b\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\tJ\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b \u0010\fJ\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b!\u0010\u000eJ\u001b\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0016J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b#\u0010\tJ\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\nø\u0001\u0000¢\u0006\u0004\b$\u0010\fJ\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b%\u0010\u000eJ\u001b\u0010&\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0016J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b'\u0010\tJ\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b(\u0010\fJ\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u000eJ\u001b\u0010*\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0016J\u001b\u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\bø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b/\u0010\u000eJ\u001b\u00100\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\bø\u0001\u0000¢\u0006\u0004\b0\u0010\u0016J\u0016\u00101\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0016\u00102\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u0010\u0005J\u001b\u00104\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b4\u00105J\u001b\u00106\u001a\u0002032\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b6\u00105J\u001e\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0002H\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u0010\u000eJ\u001e\u00109\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0002H\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010\u000eJ\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b:\u0010\u000eJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b;\u0010\u000eJ\u001b\u0010<\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u000eJ\u0016\u0010=\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010\u0005J\u0010\u0010?\u001a\u00020>H\b¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\b¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0002H\b¢\u0006\u0004\bD\u0010\u0005J\u0010\u0010F\u001a\u00020EH\b¢\u0006\u0004\bF\u0010GJ\u0016\u0010H\u001a\u00020\u0006H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bH\u0010@J\u0016\u0010I\u001a\u00020\nH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bI\u0010CJ\u0016\u0010J\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bJ\u0010\u0005J\u0016\u0010K\u001a\u00020\u000fH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010GJ\u0010\u0010M\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OH\b¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bU\u0010\u0005J\u001a\u0010X\u001a\u00020W2\b\u0010\u0007\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bX\u0010YR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b)\u0010;\u0012\u0004\bZ\u0010[\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006^"}, d2 = {"Lkotlin/UInt;", "", "", "data", "i", "(I)I", "Lkotlin/UByte;", "other", "c", "(IB)I", "Lkotlin/UShort;", "h", "(IS)I", "g", "(II)I", "Lkotlin/ULong;", "e", "(IJ)I", "J", "N", "L", "K", "(IJ)J", "z", "D", "C", "A", "Z", "d0", "c0", "a0", "k", "n", "m", "l", "Q", "T", "S", "R", "q", "u", "s", "r", "E", "(IB)B", "H", "(IS)S", "G", "F", "x", "j", "Lkotlin/ranges/UIntRange;", "O", "(II)Lkotlin/ranges/UIntRange;", "P", "bitCount", "U", "W", "a", "I", "x0", "y", "", "e0", "(I)B", "", "k0", "(I)S", "i0", "", "j0", "(I)J", "p0", "s0", "q0", "r0", "", "h0", "(I)F", "", "g0", "(I)D", "", "m0", "(I)Ljava/lang/String;", "w", "", "", "o", "(ILjava/lang/Object;)Z", "v", "()V", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class UInt implements Comparable<UInt> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    public static final int X2 = 4;
    public static final int Y = 0;
    public static final int Y2 = 32;
    public static final int Z = -1;
    private final int s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UInt(int i2) {
        this.s = i2;
    }

    @InlineOnly
    private static final long A(int i2, long j2) {
        return ULong.i(ULong.i(((long) i2) & InternalZipConstants.f30717k) - j2);
    }

    @InlineOnly
    private static final int C(int i2, int i3) {
        return i(i2 - i3);
    }

    @InlineOnly
    private static final int D(int i2, short s2) {
        return i(i2 - i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final byte E(int i2, byte b2) {
        return UByte.i((byte) b.a(i2, i(b2 & 255)));
    }

    @InlineOnly
    private static final long F(int i2, long j2) {
        return c.a(ULong.i(((long) i2) & InternalZipConstants.f30717k), j2);
    }

    @InlineOnly
    private static final int G(int i2, int i3) {
        return b.a(i2, i3);
    }

    @InlineOnly
    private static final short H(int i2, short s2) {
        return UShort.i((short) b.a(i2, i(s2 & UShort.Z)));
    }

    @InlineOnly
    private static final int I(int i2, int i3) {
        return i(i2 | i3);
    }

    @InlineOnly
    private static final int J(int i2, byte b2) {
        return i(i2 + i(b2 & 255));
    }

    @InlineOnly
    private static final long K(int i2, long j2) {
        return ULong.i(ULong.i(((long) i2) & InternalZipConstants.f30717k) + j2);
    }

    @InlineOnly
    private static final int L(int i2, int i3) {
        return i(i2 + i3);
    }

    @InlineOnly
    private static final int N(int i2, short s2) {
        return i(i2 + i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final UIntRange O(int i2, int i3) {
        return new UIntRange(i2, i3, (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final UIntRange P(int i2, int i3) {
        return URangesKt.V(i2, i3);
    }

    @InlineOnly
    private static final int Q(int i2, byte b2) {
        return b.a(i2, i(b2 & 255));
    }

    @InlineOnly
    private static final long R(int i2, long j2) {
        return c.a(ULong.i(((long) i2) & InternalZipConstants.f30717k), j2);
    }

    @InlineOnly
    private static final int S(int i2, int i3) {
        return UnsignedKt.e(i2, i3);
    }

    @InlineOnly
    private static final int T(int i2, short s2) {
        return b.a(i2, i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final int U(int i2, int i3) {
        return i(i2 << i3);
    }

    @InlineOnly
    private static final int W(int i2, int i3) {
        return i(i2 >>> i3);
    }

    @InlineOnly
    private static final int Z(int i2, byte b2) {
        return i(i2 * i(b2 & 255));
    }

    @InlineOnly
    private static final int a(int i2, int i3) {
        return i(i2 & i3);
    }

    @InlineOnly
    private static final long a0(int i2, long j2) {
        return ULong.i(ULong.i(((long) i2) & InternalZipConstants.f30717k) * j2);
    }

    public static final /* synthetic */ UInt b(int i2) {
        return new UInt(i2);
    }

    @InlineOnly
    private static final int c(int i2, byte b2) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i(b2 & 255) ^ Integer.MIN_VALUE);
    }

    @InlineOnly
    private static final int c0(int i2, int i3) {
        return i(i2 * i3);
    }

    @InlineOnly
    private static final int d0(int i2, short s2) {
        return i(i2 * i(s2 & UShort.Z));
    }

    @InlineOnly
    private static final int e(int i2, long j2) {
        return Long.compare(ULong.i(((long) i2) & InternalZipConstants.f30717k) ^ Long.MIN_VALUE, j2 ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final byte e0(int i2) {
        return (byte) i2;
    }

    @InlineOnly
    private int f(int i2) {
        return UnsignedKt.c(v0(), i2);
    }

    @InlineOnly
    private static int g(int i2, int i3) {
        return UnsignedKt.c(i2, i3);
    }

    @InlineOnly
    private static final double g0(int i2) {
        return UnsignedKt.f(i2);
    }

    @InlineOnly
    private static final int h(int i2, short s2) {
        return Integer.compare(i2 ^ Integer.MIN_VALUE, i(s2 & UShort.Z) ^ Integer.MIN_VALUE);
    }

    @InlineOnly
    private static final float h0(int i2) {
        return (float) UnsignedKt.f(i2);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static int i(int i2) {
        return i2;
    }

    @InlineOnly
    private static final int i0(int i2) {
        return i2;
    }

    @InlineOnly
    private static final int j(int i2) {
        return i(i2 - 1);
    }

    @InlineOnly
    private static final long j0(int i2) {
        return ((long) i2) & InternalZipConstants.f30717k;
    }

    @InlineOnly
    private static final int k(int i2, byte b2) {
        return a.a(i2, i(b2 & 255));
    }

    @InlineOnly
    private static final short k0(int i2) {
        return (short) i2;
    }

    @InlineOnly
    private static final long l(int i2, long j2) {
        return d.a(ULong.i(((long) i2) & InternalZipConstants.f30717k), j2);
    }

    @InlineOnly
    private static final int m(int i2, int i3) {
        return UnsignedKt.d(i2, i3);
    }

    @NotNull
    public static String m0(int i2) {
        return String.valueOf(((long) i2) & InternalZipConstants.f30717k);
    }

    @InlineOnly
    private static final int n(int i2, short s2) {
        return a.a(i2, i(s2 & UShort.Z));
    }

    public static boolean o(int i2, Object obj) {
        return (obj instanceof UInt) && i2 == ((UInt) obj).v0();
    }

    public static final boolean p(int i2, int i3) {
        return i2 == i3;
    }

    @InlineOnly
    private static final byte p0(int i2) {
        return UByte.i((byte) i2);
    }

    @InlineOnly
    private static final int q(int i2, byte b2) {
        return a.a(i2, i(b2 & 255));
    }

    @InlineOnly
    private static final int q0(int i2) {
        return i2;
    }

    @InlineOnly
    private static final long r(int i2, long j2) {
        return d.a(ULong.i(((long) i2) & InternalZipConstants.f30717k), j2);
    }

    @InlineOnly
    private static final long r0(int i2) {
        return ULong.i(((long) i2) & InternalZipConstants.f30717k);
    }

    @InlineOnly
    private static final int s(int i2, int i3) {
        return a.a(i2, i3);
    }

    @InlineOnly
    private static final short s0(int i2) {
        return UShort.i((short) i2);
    }

    @InlineOnly
    private static final int u(int i2, short s2) {
        return a.a(i2, i(s2 & UShort.Z));
    }

    @PublishedApi
    public static /* synthetic */ void v() {
    }

    public static int w(int i2) {
        return i2;
    }

    @InlineOnly
    private static final int x(int i2) {
        return i(i2 + 1);
    }

    @InlineOnly
    private static final int x0(int i2, int i3) {
        return i(i2 ^ i3);
    }

    @InlineOnly
    private static final int y(int i2) {
        return i(~i2);
    }

    @InlineOnly
    private static final int z(int i2, byte b2) {
        return i(i2 - i(b2 & 255));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.c(v0(), ((UInt) obj).v0());
    }

    public boolean equals(Object obj) {
        return o(this.s, obj);
    }

    public int hashCode() {
        return w(this.s);
    }

    @NotNull
    public String toString() {
        return m0(this.s);
    }

    public final /* synthetic */ int v0() {
        return this.s;
    }
}
