package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.internal._ByteStringKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\r\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0010\u001a\u00020\n*\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\f¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u001c\u0010\u0012\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\f¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001c\u0010\u0016\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\f¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\f¢\u0006\u0004\b\u0018\u0010\u0017\u001a\u001c\u0010\u0019\u001a\u00020\n*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\f¢\u0006\u0004\b\u0019\u0010\u0017\u001a\u001c\u0010\u001a\u001a\u00020\u0000*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0000H\f¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001c\u0010\u001c\u001a\u00020\u0014*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\f¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u0000*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0000H\f¢\u0006\u0004\b\u001e\u0010\u001f\u001a \u0010 \u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\nH\b¢\u0006\u0004\b \u0010\u0013\u001a \u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0000H\b¢\u0006\u0004\b!\u0010\u001f\u001a7\u0010&\u001a\u00020%2\u0006\u0010\u0019\u001a\u00020\"2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\"2\u0006\u0010$\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0000¢\u0006\u0004\b&\u0010'\u001a\u0013\u0010)\u001a\u00020(*\u00020\u0014H\u0000¢\u0006\u0004\b)\u0010*\u001a\u0013\u0010+\u001a\u00020(*\u00020\nH\u0000¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020(*\u00020\u0000H\u0000¢\u0006\u0004\b-\u0010.\u001a\u0017\u00101\u001a\u00020/2\u0006\u00100\u001a\u00020/H\u0000¢\u0006\u0004\b1\u00102\u001a\u001b\u00105\u001a\u00020\n*\u0002032\u0006\u00104\u001a\u00020\nH\u0000¢\u0006\u0004\b5\u00106\" \u0010<\u001a\u00020/8\u0000X\u0004¢\u0006\u0012\n\u0004\b\u0019\u00107\u0012\u0004\b:\u0010;\u001a\u0004\b8\u00109\"\u001a\u0010@\u001a\u00020\n8\u0000XD¢\u0006\f\n\u0004\b\u001a\u0010=\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"", "size", "offset", "byteCount", "", "e", "(JJJ)V", "", "p", "(S)S", "", "n", "(I)I", "o", "(J)J", "bitCount", "i", "(II)I", "q", "(JI)J", "", "other", "s", "(BI)I", "r", "a", "b", "(BJ)J", "w", "(BB)B", "c", "(IJ)J", "k", "j", "", "aOffset", "bOffset", "", "d", "([BI[BII)Z", "", "t", "(B)Ljava/lang/String;", "u", "(I)Ljava/lang/String;", "v", "(J)Ljava/lang/String;", "Lokio/Buffer$UnsafeCursor;", "unsafeCursor", "m", "(Lokio/Buffer$UnsafeCursor;)Lokio/Buffer$UnsafeCursor;", "Lokio/ByteString;", "position", "l", "(Lokio/ByteString;I)I", "Lokio/Buffer$UnsafeCursor;", "g", "()Lokio/Buffer$UnsafeCursor;", "h", "()V", "DEFAULT__new_UnsafeCursor", "I", "f", "()I", "DEFAULT__ByteString_size", "okio"}, k = 2, mv = {1, 5, 1})
public final class _UtilKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Buffer.UnsafeCursor f31420a = new Buffer.UnsafeCursor();

    /* renamed from: b  reason: collision with root package name */
    private static final int f31421b = -1234567890;

    public static final int a(byte b2, int i2) {
        return b2 & i2;
    }

    public static final long b(byte b2, long j2) {
        return ((long) b2) & j2;
    }

    public static final long c(int i2, long j2) {
        return ((long) i2) & j2;
    }

    public static final boolean d(@NotNull byte[] bArr, int i2, @NotNull byte[] bArr2, int i3, int i4) {
        Intrinsics.p(bArr, "a");
        Intrinsics.p(bArr2, "b");
        if (i4 <= 0) {
            return true;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (bArr[i5 + i2] != bArr2[i5 + i3]) {
                return false;
            }
            if (i6 >= i4) {
                return true;
            }
            i5 = i6;
        }
    }

    public static final void e(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException("size=" + j2 + " offset=" + j3 + " byteCount=" + j4);
        }
    }

    public static final int f() {
        return f31421b;
    }

    @NotNull
    public static final Buffer.UnsafeCursor g() {
        return f31420a;
    }

    public static /* synthetic */ void h() {
    }

    public static final int i(int i2, int i3) {
        return (i2 >>> (32 - i3)) | (i2 << i3);
    }

    public static final long j(int i2, long j2) {
        return Math.min((long) i2, j2);
    }

    public static final long k(long j2, int i2) {
        return Math.min(j2, (long) i2);
    }

    public static final int l(@NotNull ByteString byteString, int i2) {
        Intrinsics.p(byteString, "<this>");
        return i2 == f31421b ? byteString.m0() : i2;
    }

    @NotNull
    public static final Buffer.UnsafeCursor m(@NotNull Buffer.UnsafeCursor unsafeCursor) {
        Intrinsics.p(unsafeCursor, "unsafeCursor");
        return unsafeCursor == f31420a ? new Buffer.UnsafeCursor() : unsafeCursor;
    }

    public static final int n(int i2) {
        return ((i2 & 255) << 24) | ((-16777216 & i2) >>> 24) | ((16711680 & i2) >>> 8) | ((65280 & i2) << 8);
    }

    public static final long o(long j2) {
        return ((j2 & 255) << 56) | ((-72057594037927936L & j2) >>> 56) | ((71776119061217280L & j2) >>> 40) | ((280375465082880L & j2) >>> 24) | ((1095216660480L & j2) >>> 8) | ((4278190080L & j2) << 8) | ((16711680 & j2) << 24) | ((65280 & j2) << 40);
    }

    public static final short p(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final long q(long j2, int i2) {
        return (j2 << (64 - i2)) | (j2 >>> i2);
    }

    public static final int r(byte b2, int i2) {
        return b2 << i2;
    }

    public static final int s(byte b2, int i2) {
        return b2 >> i2;
    }

    @NotNull
    public static final String t(byte b2) {
        return StringsKt.t1(new char[]{_ByteStringKt.J()[(b2 >> 4) & 15], _ByteStringKt.J()[b2 & 15]});
    }

    @NotNull
    public static final String u(int i2) {
        int i3 = 0;
        if (i2 == 0) {
            return "0";
        }
        char[] cArr = {_ByteStringKt.J()[(i2 >> 28) & 15], _ByteStringKt.J()[(i2 >> 24) & 15], _ByteStringKt.J()[(i2 >> 20) & 15], _ByteStringKt.J()[(i2 >> 16) & 15], _ByteStringKt.J()[(i2 >> 12) & 15], _ByteStringKt.J()[(i2 >> 8) & 15], _ByteStringKt.J()[(i2 >> 4) & 15], _ByteStringKt.J()[i2 & 15]};
        while (i3 < 8 && cArr[i3] == '0') {
            i3++;
        }
        return StringsKt.u1(cArr, i3, 8);
    }

    @NotNull
    public static final String v(long j2) {
        if (j2 == 0) {
            return "0";
        }
        char c2 = _ByteStringKt.J()[(int) ((j2 >> 60) & 15)];
        char c3 = _ByteStringKt.J()[(int) ((j2 >> 56) & 15)];
        char c4 = _ByteStringKt.J()[(int) ((j2 >> 52) & 15)];
        char c5 = _ByteStringKt.J()[(int) ((j2 >> 48) & 15)];
        char c6 = _ByteStringKt.J()[(int) ((j2 >> 44) & 15)];
        char c7 = _ByteStringKt.J()[(int) ((j2 >> 40) & 15)];
        char c8 = _ByteStringKt.J()[(int) ((j2 >> 36) & 15)];
        char c9 = _ByteStringKt.J()[(int) ((j2 >> 32) & 15)];
        char c10 = _ByteStringKt.J()[(int) ((j2 >> 28) & 15)];
        char c11 = _ByteStringKt.J()[(int) ((j2 >> 24) & 15)];
        char c12 = _ByteStringKt.J()[(int) ((j2 >> 20) & 15)];
        char c13 = _ByteStringKt.J()[(int) ((j2 >> 16) & 15)];
        char c14 = c13;
        char[] cArr = {c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c14, _ByteStringKt.J()[(int) ((j2 >> 12) & 15)], _ByteStringKt.J()[(int) ((j2 >> 8) & 15)], _ByteStringKt.J()[(int) ((j2 >> 4) & 15)], _ByteStringKt.J()[(int) (j2 & 15)]};
        int i2 = 0;
        while (i2 < 16 && cArr[i2] == '0') {
            i2++;
        }
        return StringsKt.u1(cArr, i2, 16);
    }

    public static final byte w(byte b2, byte b3) {
        return (byte) (b2 ^ b3);
    }
}
