package kotlin;

import com.google.firebase.sessions.j;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import net.lingala.zip4j.util.InternalZipConstants;
import org.jetbrains.annotations.NotNull;

@JvmInline
@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b@\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001`B\u0014\b\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0014J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0016J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0018J\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001aJ\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0014J\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0016J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u001b\u0010\"\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u001aJ\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0014J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0016J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b%\u0010\u0018J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u001aJ\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\nø\u0001\u0000¢\u0006\u0004\b'\u0010\u0014J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\nø\u0001\u0000¢\u0006\u0004\b(\u0010\u0016J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u0018J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u001aJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b+\u0010\u0014J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b,\u0010\u0016J\u001b\u0010-\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u001aJ\u001b\u0010/\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\bø\u0001\u0000¢\u0006\u0004\b/\u00100J\u001b\u00101\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000bH\bø\u0001\u0000¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b3\u0010\u0010J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b4\u0010\u001aJ\u0016\u00105\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b5\u0010\u0005J\u0016\u00106\u001a\u00020\u0000H\nø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b6\u0010\u0005J\u001b\u00108\u001a\u0002072\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b8\u00109J\u001b\u0010:\u001a\u0002072\u0006\u0010\u0007\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b:\u00109J\u001e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bH\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010\u0018J\u001e\u0010=\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\bH\fø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b>\u0010\u001aJ\u001b\u0010?\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b?\u0010\u001aJ\u001b\u0010@\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b@\u0010\u001aJ\u0016\u0010A\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bA\u0010\u0005J\u0010\u0010C\u001a\u00020BH\b¢\u0006\u0004\bC\u0010DJ\u0010\u0010F\u001a\u00020EH\b¢\u0006\u0004\bF\u0010GJ\u0010\u0010H\u001a\u00020\bH\b¢\u0006\u0004\bH\u0010IJ\u0010\u0010J\u001a\u00020\u0002H\b¢\u0006\u0004\bJ\u0010\u0005J\u0016\u0010K\u001a\u00020\u0006H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bK\u0010DJ\u0016\u0010L\u001a\u00020\u000bH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010GJ\u0016\u0010M\u001a\u00020\u000eH\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bM\u0010IJ\u0016\u0010N\u001a\u00020\u0000H\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010\u0005J\u0010\u0010P\u001a\u00020OH\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010S\u001a\u00020RH\b¢\u0006\u0004\bS\u0010TJ\u000f\u0010V\u001a\u00020UH\u0016¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020\bHÖ\u0001¢\u0006\u0004\bX\u0010IJ\u001a\u0010[\u001a\u00020Z2\b\u0010\u0007\u001a\u0004\u0018\u00010YHÖ\u0003¢\u0006\u0004\b[\u0010\\R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0004¢\u0006\f\n\u0004\b-\u0010\u0013\u0012\u0004\b]\u0010^\u0001\u0003\u0001\u00020\u0002ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006a"}, d2 = {"Lkotlin/ULong;", "", "", "data", "i", "(J)J", "Lkotlin/UByte;", "other", "", "c", "(JB)I", "Lkotlin/UShort;", "h", "(JS)I", "Lkotlin/UInt;", "g", "(JI)I", "f", "(JJ)I", "J", "(JB)J", "N", "(JS)J", "L", "(JI)J", "K", "(JJ)J", "z", "D", "C", "A", "Z", "d0", "c0", "a0", "k", "n", "m", "l", "Q", "T", "S", "R", "q", "u", "s", "r", "E", "(JB)B", "H", "(JS)S", "G", "F", "x", "j", "Lkotlin/ranges/ULongRange;", "O", "(JJ)Lkotlin/ranges/ULongRange;", "P", "bitCount", "U", "W", "a", "I", "x0", "y", "", "e0", "(J)B", "", "k0", "(J)S", "i0", "(J)I", "j0", "p0", "s0", "q0", "r0", "", "h0", "(J)F", "", "g0", "(J)D", "", "m0", "(J)Ljava/lang/String;", "w", "", "", "o", "(JLjava/lang/Object;)Z", "v", "()V", "X", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
public final class ULong implements Comparable<ULong> {
    @NotNull
    public static final Companion X = new Companion((DefaultConstructorMarker) null);
    public static final int X2 = 8;
    public static final long Y = 0;
    public static final int Y2 = 64;
    public static final long Z = -1;
    private final long s;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ ULong(long j2) {
        this.s = j2;
    }

    @InlineOnly
    private static final long A(long j2, long j3) {
        return i(j2 - j3);
    }

    @InlineOnly
    private static final long C(long j2, int i2) {
        return i(j2 - i(((long) i2) & InternalZipConstants.f30717k));
    }

    @InlineOnly
    private static final long D(long j2, short s2) {
        return i(j2 - i(((long) s2) & 65535));
    }

    @InlineOnly
    private static final byte E(long j2, byte b2) {
        return UByte.i((byte) ((int) c.a(j2, i(((long) b2) & 255))));
    }

    @InlineOnly
    private static final long F(long j2, long j3) {
        return c.a(j2, j3);
    }

    @InlineOnly
    private static final int G(long j2, int i2) {
        return UInt.i((int) c.a(j2, i(((long) i2) & InternalZipConstants.f30717k)));
    }

    @InlineOnly
    private static final short H(long j2, short s2) {
        return UShort.i((short) ((int) c.a(j2, i(((long) s2) & 65535))));
    }

    @InlineOnly
    private static final long I(long j2, long j3) {
        return i(j2 | j3);
    }

    @InlineOnly
    private static final long J(long j2, byte b2) {
        return i(j2 + i(((long) b2) & 255));
    }

    @InlineOnly
    private static final long K(long j2, long j3) {
        return i(j2 + j3);
    }

    @InlineOnly
    private static final long L(long j2, int i2) {
        return i(j2 + i(((long) i2) & InternalZipConstants.f30717k));
    }

    @InlineOnly
    private static final long N(long j2, short s2) {
        return i(j2 + i(((long) s2) & 65535));
    }

    @InlineOnly
    private static final ULongRange O(long j2, long j3) {
        return new ULongRange(j2, j3, (DefaultConstructorMarker) null);
    }

    @SinceKotlin(version = "1.9")
    @InlineOnly
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    private static final ULongRange P(long j2, long j3) {
        return URangesKt.X(j2, j3);
    }

    @InlineOnly
    private static final long Q(long j2, byte b2) {
        return c.a(j2, i(((long) b2) & 255));
    }

    @InlineOnly
    private static final long R(long j2, long j3) {
        return UnsignedKt.i(j2, j3);
    }

    @InlineOnly
    private static final long S(long j2, int i2) {
        return c.a(j2, i(((long) i2) & InternalZipConstants.f30717k));
    }

    @InlineOnly
    private static final long T(long j2, short s2) {
        return c.a(j2, i(((long) s2) & 65535));
    }

    @InlineOnly
    private static final long U(long j2, int i2) {
        return i(j2 << i2);
    }

    @InlineOnly
    private static final long W(long j2, int i2) {
        return i(j2 >>> i2);
    }

    @InlineOnly
    private static final long Z(long j2, byte b2) {
        return i(j2 * i(((long) b2) & 255));
    }

    @InlineOnly
    private static final long a(long j2, long j3) {
        return i(j2 & j3);
    }

    @InlineOnly
    private static final long a0(long j2, long j3) {
        return i(j2 * j3);
    }

    public static final /* synthetic */ ULong b(long j2) {
        return new ULong(j2);
    }

    @InlineOnly
    private static final int c(long j2, byte b2) {
        return Long.compare(j2 ^ Long.MIN_VALUE, i(((long) b2) & 255) ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final long c0(long j2, int i2) {
        return i(j2 * i(((long) i2) & InternalZipConstants.f30717k));
    }

    @InlineOnly
    private static final long d0(long j2, short s2) {
        return i(j2 * i(((long) s2) & 65535));
    }

    @InlineOnly
    private int e(long j2) {
        return UnsignedKt.g(v0(), j2);
    }

    @InlineOnly
    private static final byte e0(long j2) {
        return (byte) ((int) j2);
    }

    @InlineOnly
    private static int f(long j2, long j3) {
        return UnsignedKt.g(j2, j3);
    }

    @InlineOnly
    private static final int g(long j2, int i2) {
        return Long.compare(j2 ^ Long.MIN_VALUE, i(((long) i2) & InternalZipConstants.f30717k) ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final double g0(long j2) {
        return UnsignedKt.j(j2);
    }

    @InlineOnly
    private static final int h(long j2, short s2) {
        return Long.compare(j2 ^ Long.MIN_VALUE, i(((long) s2) & 65535) ^ Long.MIN_VALUE);
    }

    @InlineOnly
    private static final float h0(long j2) {
        return (float) UnsignedKt.j(j2);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    public static long i(long j2) {
        return j2;
    }

    @InlineOnly
    private static final int i0(long j2) {
        return (int) j2;
    }

    @InlineOnly
    private static final long j(long j2) {
        return i(j2 - 1);
    }

    @InlineOnly
    private static final long j0(long j2) {
        return j2;
    }

    @InlineOnly
    private static final long k(long j2, byte b2) {
        return d.a(j2, i(((long) b2) & 255));
    }

    @InlineOnly
    private static final short k0(long j2) {
        return (short) ((int) j2);
    }

    @InlineOnly
    private static final long l(long j2, long j3) {
        return UnsignedKt.h(j2, j3);
    }

    @InlineOnly
    private static final long m(long j2, int i2) {
        return d.a(j2, i(((long) i2) & InternalZipConstants.f30717k));
    }

    @NotNull
    public static String m0(long j2) {
        return UnsignedKt.k(j2);
    }

    @InlineOnly
    private static final long n(long j2, short s2) {
        return d.a(j2, i(((long) s2) & 65535));
    }

    public static boolean o(long j2, Object obj) {
        return (obj instanceof ULong) && j2 == ((ULong) obj).v0();
    }

    public static final boolean p(long j2, long j3) {
        return j2 == j3;
    }

    @InlineOnly
    private static final byte p0(long j2) {
        return UByte.i((byte) ((int) j2));
    }

    @InlineOnly
    private static final long q(long j2, byte b2) {
        return d.a(j2, i(((long) b2) & 255));
    }

    @InlineOnly
    private static final int q0(long j2) {
        return UInt.i((int) j2);
    }

    @InlineOnly
    private static final long r(long j2, long j3) {
        return d.a(j2, j3);
    }

    @InlineOnly
    private static final long r0(long j2) {
        return j2;
    }

    @InlineOnly
    private static final long s(long j2, int i2) {
        return d.a(j2, i(((long) i2) & InternalZipConstants.f30717k));
    }

    @InlineOnly
    private static final short s0(long j2) {
        return UShort.i((short) ((int) j2));
    }

    @InlineOnly
    private static final long u(long j2, short s2) {
        return d.a(j2, i(((long) s2) & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void v() {
    }

    public static int w(long j2) {
        return j.a(j2);
    }

    @InlineOnly
    private static final long x(long j2) {
        return i(j2 + 1);
    }

    @InlineOnly
    private static final long x0(long j2, long j3) {
        return i(j2 ^ j3);
    }

    @InlineOnly
    private static final long y(long j2) {
        return i(~j2);
    }

    @InlineOnly
    private static final long z(long j2, byte b2) {
        return i(j2 - i(((long) b2) & 255));
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.g(v0(), ((ULong) obj).v0());
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

    public final /* synthetic */ long v0() {
        return this.s;
    }
}
