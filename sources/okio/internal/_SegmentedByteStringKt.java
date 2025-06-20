package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio._UtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001ad\u0010\u0014\u001a\u00020\u0012*\u00020\u00072K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aq\u0010\u0018\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a$\u0010\u001b\u001a\u00020\u001a*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001c\u0010\u001e\u001a\u00020\u001d*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020\u0001*\u00020\u0007H\b¢\u0006\u0004\b \u0010!\u001a\u0014\u0010\"\u001a\u00020\f*\u00020\u0007H\b¢\u0006\u0004\b\"\u0010#\u001a,\u0010&\u001a\u00020\u0012*\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b&\u0010'\u001a4\u0010+\u001a\u00020**\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b+\u0010,\u001a4\u0010-\u001a\u00020**\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b-\u0010.\u001a4\u00101\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b1\u00102\u001a\u001e\u00104\u001a\u00020**\u00020\u00072\b\u0010(\u001a\u0004\u0018\u000103H\b¢\u0006\u0004\b4\u00105\u001a\u0014\u00106\u001a\u00020\u0001*\u00020\u0007H\b¢\u0006\u0004\b6\u0010!\u0002\u0007\n\u0005\b20\u0001¨\u00067"}, d2 = {"", "", "value", "fromIndex", "toIndex", "a", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "n", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "", "action", "m", "(Lokio/SegmentedByteString;Lkotlin/jvm/functions/Function3;)V", "beginIndex", "endIndex", "l", "(Lokio/SegmentedByteString;IILkotlin/jvm/functions/Function3;)V", "Lokio/ByteString;", "i", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "f", "(Lokio/SegmentedByteString;I)B", "d", "(Lokio/SegmentedByteString;)I", "j", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "k", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", "other", "otherOffset", "", "g", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "h", "(Lokio/SegmentedByteString;I[BII)Z", "target", "targetOffset", "b", "(Lokio/SegmentedByteString;I[BII)V", "", "c", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "e", "okio"}, k = 2, mv = {1, 5, 1})
public final class _SegmentedByteStringKt {
    public static final int a(@NotNull int[] iArr, int i2, int i3, int i4) {
        Intrinsics.p(iArr, "<this>");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else if (i7 <= i2) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final void b(@NotNull SegmentedByteString segmentedByteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(segmentedByteString, "<this>");
        Intrinsics.p(bArr, TypedValues.AttributesType.M);
        long j2 = (long) i4;
        _UtilKt.e((long) segmentedByteString.m0(), (long) i2, j2);
        _UtilKt.e((long) bArr.length, (long) i3, j2);
        int i5 = i4 + i2;
        int n2 = n(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1];
            int i7 = segmentedByteString.N0()[segmentedByteString.P0().length + n2];
            int min = Math.min(i5, (segmentedByteString.N0()[n2] - i6) + i6) - i2;
            int i8 = i7 + (i2 - i6);
            ArraysKt.v0(segmentedByteString.P0()[n2], bArr, i3, i8, i8 + min);
            i3 += min;
            i2 += min;
            n2++;
        }
    }

    public static final boolean c(@NotNull SegmentedByteString segmentedByteString, @Nullable Object obj) {
        Intrinsics.p(segmentedByteString, "<this>");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            return byteString.m0() == segmentedByteString.m0() && segmentedByteString.Z(0, byteString, 0, segmentedByteString.m0());
        }
    }

    public static final int d(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.p(segmentedByteString, "<this>");
        return segmentedByteString.N0()[segmentedByteString.P0().length - 1];
    }

    public static final int e(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.p(segmentedByteString, "<this>");
        int s = segmentedByteString.s();
        if (s != 0) {
            return s;
        }
        int length = segmentedByteString.P0().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            int i5 = segmentedByteString.N0()[length + i2];
            int i6 = segmentedByteString.N0()[i2];
            byte[] bArr = segmentedByteString.P0()[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        segmentedByteString.e0(i4);
        return i4;
    }

    public static final byte f(@NotNull SegmentedByteString segmentedByteString, int i2) {
        Intrinsics.p(segmentedByteString, "<this>");
        _UtilKt.e((long) segmentedByteString.N0()[segmentedByteString.P0().length - 1], (long) i2, 1);
        int n2 = n(segmentedByteString, i2);
        return segmentedByteString.P0()[n2][(i2 - (n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1])) + segmentedByteString.N0()[segmentedByteString.P0().length + n2]];
    }

    public static final boolean g(@NotNull SegmentedByteString segmentedByteString, int i2, @NotNull ByteString byteString, int i3, int i4) {
        Intrinsics.p(segmentedByteString, "<this>");
        Intrinsics.p(byteString, "other");
        if (i2 < 0 || i2 > segmentedByteString.m0() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n2 = n(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1];
            int i7 = segmentedByteString.N0()[segmentedByteString.P0().length + n2];
            int min = Math.min(i5, (segmentedByteString.N0()[n2] - i6) + i6) - i2;
            if (!byteString.a0(i3, segmentedByteString.P0()[n2], i7 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n2++;
        }
        return true;
    }

    public static final boolean h(@NotNull SegmentedByteString segmentedByteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(segmentedByteString, "<this>");
        Intrinsics.p(bArr, "other");
        if (i2 < 0 || i2 > segmentedByteString.m0() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int n2 = n(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1];
            int i7 = segmentedByteString.N0()[segmentedByteString.P0().length + n2];
            int min = Math.min(i5, (segmentedByteString.N0()[n2] - i6) + i6) - i2;
            if (!_UtilKt.d(segmentedByteString.P0()[n2], i7 + (i2 - i6), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            n2++;
        }
        return true;
    }

    @NotNull
    public static final ByteString i(@NotNull SegmentedByteString segmentedByteString, int i2, int i3) {
        Intrinsics.p(segmentedByteString, "<this>");
        int l2 = _UtilKt.l(segmentedByteString, i3);
        int i4 = 0;
        if (i2 >= 0) {
            if (l2 <= segmentedByteString.m0()) {
                int i5 = l2 - i2;
                if (!(i5 >= 0)) {
                    throw new IllegalArgumentException(("endIndex=" + l2 + " < beginIndex=" + i2).toString());
                } else if (i2 == 0 && l2 == segmentedByteString.m0()) {
                    return segmentedByteString;
                } else {
                    if (i2 == l2) {
                        return ByteString.Y2;
                    }
                    int n2 = n(segmentedByteString, i2);
                    int n3 = n(segmentedByteString, l2 - 1);
                    byte[][] bArr = (byte[][]) ArraysKt.l1(segmentedByteString.P0(), n2, n3 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (n2 <= n3) {
                        int i6 = n2;
                        int i7 = 0;
                        while (true) {
                            int i8 = i6 + 1;
                            iArr[i7] = Math.min(segmentedByteString.N0()[i6] - i2, i5);
                            int i9 = i7 + 1;
                            iArr[i7 + bArr.length] = segmentedByteString.N0()[segmentedByteString.P0().length + i6];
                            if (i6 == n3) {
                                break;
                            }
                            i6 = i8;
                            i7 = i9;
                        }
                    }
                    if (n2 != 0) {
                        i4 = segmentedByteString.N0()[n2 - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i2 - i4);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + l2 + " > length(" + segmentedByteString.m0() + ASCIIPropertyListParser.f18650h).toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
    }

    @NotNull
    public static final byte[] j(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.p(segmentedByteString, "<this>");
        byte[] bArr = new byte[segmentedByteString.m0()];
        int length = segmentedByteString.P0().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.N0()[length + i2];
            int i6 = segmentedByteString.N0()[i2];
            int i7 = i6 - i3;
            ArraysKt.v0(segmentedByteString.P0()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void k(@NotNull SegmentedByteString segmentedByteString, @NotNull Buffer buffer, int i2, int i3) {
        Intrinsics.p(segmentedByteString, "<this>");
        Intrinsics.p(buffer, "buffer");
        int i4 = i2 + i3;
        int n2 = n(segmentedByteString, i2);
        while (i2 < i4) {
            int i5 = n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1];
            int i6 = segmentedByteString.N0()[segmentedByteString.P0().length + n2];
            int min = Math.min(i4, (segmentedByteString.N0()[n2] - i5) + i5) - i2;
            int i7 = i6 + (i2 - i5);
            Segment segment = new Segment(segmentedByteString.P0()[n2], i7, i7 + min, true, false);
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

    private static final void l(SegmentedByteString segmentedByteString, int i2, int i3, Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        int n2 = n(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = n2 == 0 ? 0 : segmentedByteString.N0()[n2 - 1];
            int i5 = segmentedByteString.N0()[segmentedByteString.P0().length + n2];
            int min = Math.min(i3, (segmentedByteString.N0()[n2] - i4) + i4) - i2;
            function3.A(segmentedByteString.P0()[n2], Integer.valueOf(i5 + (i2 - i4)), Integer.valueOf(min));
            i2 += min;
            n2++;
        }
    }

    public static final void m(@NotNull SegmentedByteString segmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.p(segmentedByteString, "<this>");
        Intrinsics.p(function3, "action");
        int length = segmentedByteString.P0().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = segmentedByteString.N0()[length + i2];
            int i5 = segmentedByteString.N0()[i2];
            function3.A(segmentedByteString.P0()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int n(@NotNull SegmentedByteString segmentedByteString, int i2) {
        Intrinsics.p(segmentedByteString, "<this>");
        int a2 = a(segmentedByteString.N0(), i2 + 1, 0, segmentedByteString.P0().length);
        return a2 >= 0 ? a2 : ~a2;
    }
}
