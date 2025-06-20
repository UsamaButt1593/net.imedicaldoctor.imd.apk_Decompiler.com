package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._SegmentedByteStringKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0016\u0010\nJ\u000f\u0010\u0017\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\nJ\u0017\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0010H\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001e\u0010\u0014J\u001f\u0010\"\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020\u001fH\u0010¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u001fH\u0010¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0003H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00102\u001a\u0002012\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b2\u00103J'\u00108\u001a\u0002012\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0010¢\u0006\u0004\b8\u00109J/\u0010=\u001a\u00020<2\u0006\u00106\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0016¢\u0006\u0004\b=\u0010>J/\u0010?\u001a\u00020<2\u0006\u00106\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0016¢\u0006\u0004\b?\u0010@J/\u0010C\u001a\u0002012\u0006\u00106\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001fH\u0016¢\u0006\u0004\bC\u0010DJ\u001f\u0010F\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u001fH\u0016¢\u0006\u0004\bF\u0010GJ\u001f\u0010H\u001a\u00020\u001f2\u0006\u0010:\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u001fH\u0016¢\u0006\u0004\bH\u0010GJ\u000f\u0010I\u001a\u00020\u0003H\u0010¢\u0006\u0004\bI\u0010+J\u001a\u0010K\u001a\u00020<2\b\u0010:\u001a\u0004\u0018\u00010JH\u0002¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u001fH\u0016¢\u0006\u0004\bM\u0010)J\u000f\u0010N\u001a\u00020\u0010H\u0016¢\u0006\u0004\bN\u0010\u0014R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0004¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0004¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "", "", "segments", "", "directory", "<init>", "([[B[I)V", "Q0", "()Lokio/ByteString;", "Ljava/lang/Object;", "R0", "()Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "", "r0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "e", "()Ljava/lang/String;", "w", "C0", "D0", "algorithm", "l", "(Ljava/lang/String;)Lokio/ByteString;", "key", "x", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "f", "", "beginIndex", "endIndex", "A0", "(II)Lokio/ByteString;", "pos", "", "K", "(I)B", "u", "()I", "G0", "()[B", "Ljava/nio/ByteBuffer;", "c", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "out", "", "J0", "(Ljava/io/OutputStream;)V", "Lokio/Buffer;", "buffer", "offset", "byteCount", "K0", "(Lokio/Buffer;II)V", "other", "otherOffset", "", "Z", "(ILokio/ByteString;II)Z", "a0", "(I[BII)Z", "target", "targetOffset", "h", "(I[BII)V", "fromIndex", "F", "([BI)I", "P", "J", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "Z2", "[[B", "P0", "()[[B", "a3", "[I", "N0", "()[I", "okio"}, k = 1, mv = {1, 5, 1})
public final class SegmentedByteString extends ByteString {
    @NotNull
    private final transient byte[][] Z2;
    @NotNull
    private final transient int[] a3;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@NotNull byte[][] bArr, @NotNull int[] iArr) {
        super(ByteString.Y2.r());
        Intrinsics.p(bArr, "segments");
        Intrinsics.p(iArr, "directory");
        this.Z2 = bArr;
        this.a3 = iArr;
    }

    private final ByteString Q0() {
        return new ByteString(G0());
    }

    private final Object R0() {
        return Q0();
    }

    @NotNull
    public ByteString A0(int i2, int i3) {
        int l2 = _UtilKt.l(this, i3);
        int i4 = 0;
        if (i2 >= 0) {
            if (l2 <= m0()) {
                int i5 = l2 - i2;
                if (!(i5 >= 0)) {
                    throw new IllegalArgumentException(("endIndex=" + l2 + " < beginIndex=" + i2).toString());
                } else if (i2 == 0 && l2 == m0()) {
                    return this;
                } else {
                    if (i2 == l2) {
                        return ByteString.Y2;
                    }
                    int n2 = _SegmentedByteStringKt.n(this, i2);
                    int n3 = _SegmentedByteStringKt.n(this, l2 - 1);
                    byte[][] bArr = (byte[][]) ArraysKt.l1(P0(), n2, n3 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (n2 <= n3) {
                        int i6 = n2;
                        int i7 = 0;
                        while (true) {
                            int i8 = i6 + 1;
                            iArr[i7] = Math.min(N0()[i6] - i2, i5);
                            int i9 = i7 + 1;
                            iArr[i7 + bArr.length] = N0()[P0().length + i6];
                            if (i6 == n3) {
                                break;
                            }
                            i6 = i8;
                            i7 = i9;
                        }
                    }
                    if (n2 != 0) {
                        i4 = N0()[n2 - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i2 - i4);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + l2 + " > length(" + m0() + ASCIIPropertyListParser.f18650h).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
    }

    @NotNull
    public ByteString C0() {
        return Q0().C0();
    }

    @NotNull
    public ByteString D0() {
        return Q0().D0();
    }

    public int F(@NotNull byte[] bArr, int i2) {
        Intrinsics.p(bArr, "other");
        return Q0().F(bArr, i2);
    }

    @NotNull
    public byte[] G0() {
        byte[] bArr = new byte[m0()];
        int length = P0().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = N0()[length + i2];
            int i6 = N0()[i2];
            int i7 = i6 - i3;
            ArraysKt.v0(P0()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    @NotNull
    public byte[] J() {
        return G0();
    }

    public void J0(@NotNull OutputStream outputStream) throws IOException {
        Intrinsics.p(outputStream, "out");
        int length = P0().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = N0()[length + i2];
            int i5 = N0()[i2];
            outputStream.write(P0()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
    }

    public byte K(int i2) {
        _UtilKt.e((long) N0()[P0().length - 1], (long) i2, 1);
        int n2 = _SegmentedByteStringKt.n(this, i2);
        return P0()[n2][(i2 - (n2 == 0 ? 0 : N0()[n2 - 1])) + N0()[P0().length + n2]];
    }

    public void K0(@NotNull Buffer buffer, int i2, int i3) {
        Intrinsics.p(buffer, "buffer");
        int i4 = i2 + i3;
        int n2 = _SegmentedByteStringKt.n(this, i2);
        while (i2 < i4) {
            int i5 = n2 == 0 ? 0 : N0()[n2 - 1];
            int i6 = N0()[P0().length + n2];
            int min = Math.min(i4, (N0()[n2] - i5) + i5) - i2;
            int i7 = i6 + (i2 - i5);
            Segment segment = new Segment(P0()[n2], i7, i7 + min, true, false);
            Segment segment2 = buffer.s;
            if (segment2 == null) {
                segment.f31388g = segment;
                segment.f31387f = segment;
                buffer.s = segment;
            } else {
                Intrinsics.m(segment2);
                Segment segment3 = segment2.f31388g;
                Intrinsics.m(segment3);
                segment3.c(segment);
            }
            i2 += min;
            n2++;
        }
        buffer.C0(buffer.L0() + ((long) i3));
    }

    @NotNull
    public final int[] N0() {
        return this.a3;
    }

    public int P(@NotNull byte[] bArr, int i2) {
        Intrinsics.p(bArr, "other");
        return Q0().P(bArr, i2);
    }

    @NotNull
    public final byte[][] P0() {
        return this.Z2;
    }

    public boolean Z(int i2, @NotNull ByteString byteString, int i3, int i4) {
        Intrinsics.p(byteString, "other");
        if (i2 < 0 || i2 > m0() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n2 = _SegmentedByteStringKt.n(this, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : N0()[n2 - 1];
            int i7 = N0()[P0().length + n2];
            int min = Math.min(i5, (N0()[n2] - i6) + i6) - i2;
            if (!byteString.a0(i3, P0()[n2], i7 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n2++;
        }
        return true;
    }

    public boolean a0(int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(bArr, "other");
        if (i2 < 0 || i2 > m0() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n2 = _SegmentedByteStringKt.n(this, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : N0()[n2 - 1];
            int i7 = N0()[P0().length + n2];
            int min = Math.min(i5, (N0()[n2] - i6) + i6) - i2;
            if (!_UtilKt.d(P0()[n2], i7 + (i2 - i6), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n2++;
        }
        return true;
    }

    @NotNull
    public ByteBuffer c() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(G0()).asReadOnlyBuffer();
        Intrinsics.o(asReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @NotNull
    public String e() {
        return Q0().e();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.m0() == m0() && Z(0, byteString, 0, m0());
        }
    }

    @NotNull
    public String f() {
        return Q0().f();
    }

    public void h(int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(bArr, TypedValues.AttributesType.M);
        long j2 = (long) i4;
        _UtilKt.e((long) m0(), (long) i2, j2);
        _UtilKt.e((long) bArr.length, (long) i3, j2);
        int i5 = i4 + i2;
        int n2 = _SegmentedByteStringKt.n(this, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : N0()[n2 - 1];
            int i7 = N0()[P0().length + n2];
            int min = Math.min(i5, (N0()[n2] - i6) + i6) - i2;
            int i8 = i7 + (i2 - i6);
            ArraysKt.v0(P0()[n2], bArr, i3, i8, i8 + min);
            i3 += min;
            i2 += min;
            n2++;
        }
    }

    public int hashCode() {
        int s = s();
        if (s != 0) {
            return s;
        }
        int length = P0().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = N0()[length + i2];
            int i6 = N0()[i2];
            byte[] bArr = P0()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        e0(i3);
        return i3;
    }

    @NotNull
    public ByteString l(@NotNull String str) {
        Intrinsics.p(str, "algorithm");
        MessageDigest instance = MessageDigest.getInstance(str);
        int length = P0().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = N0()[length + i2];
            int i5 = N0()[i2];
            instance.update(P0()[i2], i4, i5 - i3);
            i2++;
            i3 = i5;
        }
        byte[] digest = instance.digest();
        Intrinsics.o(digest, "digestBytes");
        return new ByteString(digest);
    }

    @NotNull
    public String r0(@NotNull Charset charset) {
        Intrinsics.p(charset, "charset");
        return Q0().r0(charset);
    }

    @NotNull
    public String toString() {
        return Q0().toString();
    }

    public int u() {
        return N0()[P0().length - 1];
    }

    @NotNull
    public String w() {
        return Q0().w();
    }

    @NotNull
    public ByteString x(@NotNull String str, @NotNull ByteString byteString) {
        Intrinsics.p(str, "algorithm");
        Intrinsics.p(byteString, "key");
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(byteString.G0(), str));
            int length = P0().length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                int i4 = N0()[length + i2];
                int i5 = N0()[i2];
                instance.update(P0()[i2], i4, i5 - i3);
                i2++;
                i3 = i5;
            }
            byte[] doFinal = instance.doFinal();
            Intrinsics.o(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
