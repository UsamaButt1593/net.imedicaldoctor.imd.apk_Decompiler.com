package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.dd.plist.ASCIIPropertyListParser;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import okio.ByteString;
import okio._Base64Kt;
import okio._JvmPlatformKt;
import okio._UtilKt;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\b\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\t\u0010\b\u001a$\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u0011\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\nH\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0014\u0010\u0013\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0014\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0014\u0010\u0018\u001a\u00020\u0015*\u00020\u0000H\b¢\u0006\u0004\b\u0018\u0010\u0017\u001a4\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a4\u0010 \u001a\u00020\u001d*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b \u0010!\u001a4\u0010%\u001a\u00020$*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b%\u0010&\u001a\u001c\u0010(\u001a\u00020\u001d*\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010*\u001a\u00020\u001d*\u00020\u00002\u0006\u0010'\u001a\u00020\u0015H\b¢\u0006\u0004\b*\u0010+\u001a\u001c\u0010-\u001a\u00020\u001d*\u00020\u00002\u0006\u0010,\u001a\u00020\u0000H\b¢\u0006\u0004\b-\u0010)\u001a\u001c\u0010.\u001a\u00020\u001d*\u00020\u00002\u0006\u0010,\u001a\u00020\u0015H\b¢\u0006\u0004\b.\u0010+\u001a$\u00100\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\nH\b¢\u0006\u0004\b0\u00101\u001a$\u00102\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\nH\b¢\u0006\u0004\b2\u00103\u001a$\u00104\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\nH\b¢\u0006\u0004\b4\u00101\u001a\u001e\u00106\u001a\u00020\u001d*\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u000105H\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\b8\u0010\u0014\u001a\u001c\u00109\u001a\u00020\n*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0000H\b¢\u0006\u0004\b9\u0010:\u001a\u0018\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020\u0015H\b¢\u0006\u0004\b<\u0010=\u001a$\u0010>\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\b¢\u0006\u0004\b>\u0010?\u001a\u0014\u0010@\u001a\u00020\u0000*\u00020\u0001H\b¢\u0006\u0004\b@\u0010A\u001a\u0016\u0010B\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\b¢\u0006\u0004\bB\u0010A\u001a\u0014\u0010C\u001a\u00020\u0000*\u00020\u0001H\b¢\u0006\u0004\bC\u0010A\u001a+\u0010F\u001a\u00020$*\u00020\u00002\u0006\u0010E\u001a\u00020D2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0000¢\u0006\u0004\bF\u0010G\u001a\u0017\u0010J\u001a\u00020\n2\u0006\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bJ\u0010K\u001a\u0014\u0010L\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\bL\u0010\u0003\u001a\u001f\u0010I\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010M\u001a\u00020\nH\u0002¢\u0006\u0004\bI\u0010N\" \u0010V\u001a\u00020O8\u0000X\u0004¢\u0006\u0012\n\u0004\bP\u0010Q\u0012\u0004\bT\u0010U\u001a\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lokio/ByteString;", "", "G", "(Lokio/ByteString;)Ljava/lang/String;", "d", "e", "q", "B", "(Lokio/ByteString;)Lokio/ByteString;", "C", "", "beginIndex", "endIndex", "A", "(Lokio/ByteString;II)Lokio/ByteString;", "pos", "", "n", "(Lokio/ByteString;I)B", "o", "(Lokio/ByteString;)I", "", "D", "(Lokio/ByteString;)[B", "s", "offset", "other", "otherOffset", "byteCount", "", "w", "(Lokio/ByteString;ILokio/ByteString;II)Z", "x", "(Lokio/ByteString;I[BII)Z", "target", "targetOffset", "", "g", "(Lokio/ByteString;I[BII)V", "prefix", "y", "(Lokio/ByteString;Lokio/ByteString;)Z", "z", "(Lokio/ByteString;[B)Z", "suffix", "k", "l", "fromIndex", "r", "(Lokio/ByteString;[BI)I", "t", "(Lokio/ByteString;Lokio/ByteString;I)I", "u", "", "m", "(Lokio/ByteString;Ljava/lang/Object;)Z", "p", "f", "(Lokio/ByteString;Lokio/ByteString;)I", "data", "v", "([B)Lokio/ByteString;", "E", "([BII)Lokio/ByteString;", "j", "(Ljava/lang/String;)Lokio/ByteString;", "h", "i", "Lokio/Buffer;", "buffer", "H", "(Lokio/ByteString;Lokio/Buffer;II)V", "", "c", "I", "(C)I", "F", "codePointCount", "([BI)I", "", "a", "[C", "J", "()[C", "K", "()V", "HEX_DIGIT_CHARS", "okio"}, k = 2, mv = {1, 5, 1})
public final class _ByteStringKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f31454a = {'0', '1', PdfWriter.p4, PdfWriter.q4, PdfWriter.r4, PdfWriter.s4, PdfWriter.t4, PdfWriter.u4, '8', '9', 'a', 'b', Barcode128.F, Barcode128.G, Barcode128.H, Barcode128.I};

    @NotNull
    public static final ByteString A(@NotNull ByteString byteString, int i2, int i3) {
        Intrinsics.p(byteString, "<this>");
        int l2 = _UtilKt.l(byteString, i3);
        boolean z = false;
        if (i2 >= 0) {
            if (l2 <= byteString.r().length) {
                if (l2 - i2 >= 0) {
                    z = true;
                }
                if (z) {
                    return (i2 == 0 && l2 == byteString.r().length) ? byteString : new ByteString(ArraysKt.f1(byteString.r(), i2, l2));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.r().length + ASCIIPropertyListParser.f18650h).toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public static final ByteString B(@NotNull ByteString byteString) {
        byte b2;
        Intrinsics.p(byteString, "<this>");
        int i2 = 0;
        while (i2 < byteString.r().length) {
            byte b3 = byteString.r()[i2];
            byte b4 = (byte) 65;
            if (b3 < b4 || b3 > (b2 = (byte) 90)) {
                i2++;
            } else {
                byte[] r = byteString.r();
                byte[] copyOf = Arrays.copyOf(r, r.length);
                Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final ByteString C(@NotNull ByteString byteString) {
        byte b2;
        Intrinsics.p(byteString, "<this>");
        int i2 = 0;
        while (i2 < byteString.r().length) {
            byte b3 = byteString.r()[i2];
            byte b4 = (byte) 97;
            if (b3 < b4 || b3 > (b2 = (byte) 122)) {
                i2++;
            } else {
                byte[] r = byteString.r();
                byte[] copyOf = Arrays.copyOf(r, r.length);
                Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i2] = (byte) (b3 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b5 = copyOf[i3];
                    if (b5 >= b4 && b5 <= b2) {
                        copyOf[i3] = (byte) (b5 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return byteString;
    }

    @NotNull
    public static final byte[] D(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        byte[] r = byteString.r();
        byte[] copyOf = Arrays.copyOf(r, r.length);
        Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString E(@NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.p(bArr, "<this>");
        _UtilKt.e((long) bArr.length, (long) i2, (long) i3);
        return new ByteString(ArraysKt.f1(bArr, i2, i3 + i2));
    }

    @NotNull
    public static final String F(@NotNull ByteString byteString) {
        StringBuilder sb;
        ByteString byteString2 = byteString;
        Intrinsics.p(byteString2, "<this>");
        if (byteString.r().length == 0) {
            return "[size=0]";
        }
        int a2 = c(byteString.r(), 64);
        if (a2 == -1) {
            if (byteString.r().length <= 64) {
                sb = new StringBuilder();
                sb.append("[hex=");
                sb.append(byteString.w());
                sb.append(']');
            } else {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(byteString.r().length);
                sb.append(" hex=");
                int l2 = _UtilKt.l(byteString2, 64);
                boolean z = true;
                if (l2 <= byteString.r().length) {
                    if (l2 < 0) {
                        z = false;
                    }
                    if (z) {
                        if (l2 != byteString.r().length) {
                            byteString2 = new ByteString(ArraysKt.f1(byteString.r(), 0, l2));
                        }
                        sb.append(byteString2.w());
                        sb.append("…]");
                    } else {
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                } else {
                    throw new IllegalArgumentException(("endIndex > length(" + byteString.r().length + ASCIIPropertyListParser.f18650h).toString());
                }
            }
            return sb.toString();
        }
        String I0 = byteString.I0();
        if (I0 != null) {
            String substring = I0.substring(0, a2);
            Intrinsics.o(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String i2 = StringsKt.i2(StringsKt.i2(StringsKt.i2(substring, "\\", "\\\\", false, 4, (Object) null), StringUtils.LF, "\\n", false, 4, (Object) null), StringUtils.CR, "\\r", false, 4, (Object) null);
            if (a2 < I0.length()) {
                return "[size=" + byteString.r().length + " text=" + i2 + "…]";
            }
            return "[text=" + i2 + ']';
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final String G(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        String v = byteString.v();
        if (v != null) {
            return v;
        }
        String c2 = _JvmPlatformKt.c(byteString.J());
        byteString.h0(c2);
        return c2;
    }

    public static final void H(@NotNull ByteString byteString, @NotNull Buffer buffer, int i2, int i3) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(buffer, "buffer");
        buffer.write(byteString.r(), i2, i3);
    }

    /* access modifiers changed from: private */
    public static final int I(char c2) {
        if ('0' <= c2 && c2 <= '9') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 <= 'f') {
            return c2 - 'W';
        }
        if ('A' <= c2 && c2 <= 'F') {
            return c2 - '7';
        }
        throw new IllegalArgumentException(Intrinsics.C("Unexpected hex digit: ", Character.valueOf(c2)));
    }

    @NotNull
    public static final char[] J() {
        return f31454a;
    }

    public static /* synthetic */ void K() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x005c, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c(byte[] r18, int r19) {
        /*
            r0 = r18
            r1 = r19
            int r2 = r0.length
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0008:
            if (r3 >= r2) goto L_0x019f
            byte r6 = r0[r3]
            r7 = 65533(0xfffd, float:9.1831E-41)
            r8 = 159(0x9f, float:2.23E-43)
            r9 = 127(0x7f, float:1.78E-43)
            r10 = 31
            r11 = 13
            r12 = 10
            r13 = 65536(0x10000, float:9.18355E-41)
            r16 = -1
            if (r6 < 0) goto L_0x0064
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x0024
            return r4
        L_0x0024:
            if (r6 == r12) goto L_0x0032
            if (r6 == r11) goto L_0x0032
            if (r6 < 0) goto L_0x002d
            if (r6 > r10) goto L_0x002d
            goto L_0x0034
        L_0x002d:
            if (r9 > r6) goto L_0x0032
            if (r6 > r8) goto L_0x0032
            goto L_0x0034
        L_0x0032:
            if (r6 != r7) goto L_0x0035
        L_0x0034:
            return r16
        L_0x0035:
            if (r6 >= r13) goto L_0x0039
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 2
        L_0x003a:
            int r4 = r4 + r5
            int r3 = r3 + 1
        L_0x003d:
            r5 = r17
            if (r3 >= r2) goto L_0x0008
            byte r6 = r0[r3]
            if (r6 < 0) goto L_0x0008
            int r3 = r3 + 1
            int r17 = r5 + 1
            if (r5 != r1) goto L_0x004c
            return r4
        L_0x004c:
            if (r6 == r12) goto L_0x005a
            if (r6 == r11) goto L_0x005a
            if (r6 < 0) goto L_0x0055
            if (r6 > r10) goto L_0x0055
            goto L_0x005c
        L_0x0055:
            if (r9 > r6) goto L_0x005a
            if (r6 > r8) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            if (r6 != r7) goto L_0x005d
        L_0x005c:
            return r16
        L_0x005d:
            if (r6 >= r13) goto L_0x0061
            r5 = 1
            goto L_0x0062
        L_0x0061:
            r5 = 2
        L_0x0062:
            int r4 = r4 + r5
            goto L_0x003d
        L_0x0064:
            int r14 = r6 >> 5
            r15 = -2
            r13 = 128(0x80, float:1.794E-43)
            if (r14 != r15) goto L_0x00ad
            int r14 = r3 + 1
            if (r2 > r14) goto L_0x0073
            if (r5 != r1) goto L_0x0072
            return r4
        L_0x0072:
            return r16
        L_0x0073:
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x00a9
            r14 = r14 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r14
            if (r6 >= r13) goto L_0x0084
            if (r5 != r1) goto L_0x0083
            return r4
        L_0x0083:
            return r16
        L_0x0084:
            int r13 = r5 + 1
            if (r5 != r1) goto L_0x0089
            return r4
        L_0x0089:
            if (r6 == r12) goto L_0x0097
            if (r6 == r11) goto L_0x0097
            if (r6 < 0) goto L_0x0092
            if (r6 > r10) goto L_0x0092
            goto L_0x0099
        L_0x0092:
            if (r9 > r6) goto L_0x0097
            if (r6 > r8) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            if (r6 != r7) goto L_0x009a
        L_0x0099:
            return r16
        L_0x009a:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x00a0
            r14 = 1
            goto L_0x00a1
        L_0x00a0:
            r14 = 2
        L_0x00a1:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.f28779a
            int r3 = r3 + 2
            r5 = r13
            goto L_0x0008
        L_0x00a9:
            if (r5 != r1) goto L_0x00ac
            return r4
        L_0x00ac:
            return r16
        L_0x00ad:
            int r14 = r6 >> 4
            r7 = 57343(0xdfff, float:8.0355E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r14 != r15) goto L_0x011b
            int r14 = r3 + 2
            if (r2 > r14) goto L_0x00bf
            if (r5 != r1) goto L_0x00be
            return r4
        L_0x00be:
            return r16
        L_0x00bf:
            int r15 = r3 + 1
            byte r15 = r0[r15]
            r9 = r15 & 192(0xc0, float:2.69E-43)
            if (r9 != r13) goto L_0x0117
            byte r9 = r0[r14]
            r14 = r9 & 192(0xc0, float:2.69E-43)
            if (r14 != r13) goto L_0x0113
            r13 = -123008(0xfffffffffffe1f80, float:NaN)
            r9 = r9 ^ r13
            int r13 = r15 << 6
            r9 = r9 ^ r13
            int r6 = r6 << 12
            r6 = r6 ^ r9
            r9 = 2048(0x800, float:2.87E-42)
            if (r6 >= r9) goto L_0x00df
            if (r5 != r1) goto L_0x00de
            return r4
        L_0x00de:
            return r16
        L_0x00df:
            if (r8 > r6) goto L_0x00e7
            if (r6 > r7) goto L_0x00e7
            if (r5 != r1) goto L_0x00e6
            return r4
        L_0x00e6:
            return r16
        L_0x00e7:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x00ec
            return r4
        L_0x00ec:
            if (r6 == r12) goto L_0x00fe
            if (r6 == r11) goto L_0x00fe
            if (r6 < 0) goto L_0x00f5
            if (r6 > r10) goto L_0x00f5
            goto L_0x0103
        L_0x00f5:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x00fe
            r5 = 159(0x9f, float:2.23E-43)
            if (r6 > r5) goto L_0x00fe
            goto L_0x0103
        L_0x00fe:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x0104
        L_0x0103:
            return r16
        L_0x0104:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x010a
            r14 = 1
            goto L_0x010b
        L_0x010a:
            r14 = 2
        L_0x010b:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.f28779a
            int r3 = r3 + 3
        L_0x0110:
            r5 = r7
            goto L_0x0008
        L_0x0113:
            if (r5 != r1) goto L_0x0116
            return r4
        L_0x0116:
            return r16
        L_0x0117:
            if (r5 != r1) goto L_0x011a
            return r4
        L_0x011a:
            return r16
        L_0x011b:
            int r9 = r6 >> 3
            if (r9 != r15) goto L_0x019b
            int r9 = r3 + 3
            if (r2 > r9) goto L_0x0127
            if (r5 != r1) goto L_0x0126
            return r4
        L_0x0126:
            return r16
        L_0x0127:
            int r14 = r3 + 1
            byte r14 = r0[r14]
            r15 = r14 & 192(0xc0, float:2.69E-43)
            if (r15 != r13) goto L_0x0197
            int r15 = r3 + 2
            byte r15 = r0[r15]
            r10 = r15 & 192(0xc0, float:2.69E-43)
            if (r10 != r13) goto L_0x0193
            byte r9 = r0[r9]
            r10 = r9 & 192(0xc0, float:2.69E-43)
            if (r10 != r13) goto L_0x018f
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r9 = r9 ^ r10
            int r10 = r15 << 6
            r9 = r9 ^ r10
            int r10 = r14 << 12
            r9 = r9 ^ r10
            int r6 = r6 << 18
            r6 = r6 ^ r9
            r9 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r9) goto L_0x0153
            if (r5 != r1) goto L_0x0152
            return r4
        L_0x0152:
            return r16
        L_0x0153:
            if (r8 > r6) goto L_0x015b
            if (r6 > r7) goto L_0x015b
            if (r5 != r1) goto L_0x015a
            return r4
        L_0x015a:
            return r16
        L_0x015b:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x0163
            if (r5 != r1) goto L_0x0162
            return r4
        L_0x0162:
            return r16
        L_0x0163:
            int r7 = r5 + 1
            if (r5 != r1) goto L_0x0168
            return r4
        L_0x0168:
            if (r6 == r12) goto L_0x017c
            if (r6 == r11) goto L_0x017c
            if (r6 < 0) goto L_0x0173
            r5 = 31
            if (r6 > r5) goto L_0x0173
            goto L_0x0181
        L_0x0173:
            r5 = 127(0x7f, float:1.78E-43)
            if (r5 > r6) goto L_0x017c
            r5 = 159(0x9f, float:2.23E-43)
            if (r6 > r5) goto L_0x017c
            goto L_0x0181
        L_0x017c:
            r5 = 65533(0xfffd, float:9.1831E-41)
            if (r6 != r5) goto L_0x0182
        L_0x0181:
            return r16
        L_0x0182:
            r5 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r5) goto L_0x0188
            r14 = 1
            goto L_0x0189
        L_0x0188:
            r14 = 2
        L_0x0189:
            int r4 = r4 + r14
            kotlin.Unit r5 = kotlin.Unit.f28779a
            int r3 = r3 + 4
            goto L_0x0110
        L_0x018f:
            if (r5 != r1) goto L_0x0192
            return r4
        L_0x0192:
            return r16
        L_0x0193:
            if (r5 != r1) goto L_0x0196
            return r4
        L_0x0196:
            return r16
        L_0x0197:
            if (r5 != r1) goto L_0x019a
            return r4
        L_0x019a:
            return r16
        L_0x019b:
            if (r5 != r1) goto L_0x019e
            return r4
        L_0x019e:
            return r16
        L_0x019f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._ByteStringKt.c(byte[], int):int");
    }

    @NotNull
    public static final String d(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        return _Base64Kt.c(byteString.r(), (byte[]) null, 1, (Object) null);
    }

    @NotNull
    public static final String e(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        return _Base64Kt.b(byteString.r(), _Base64Kt.f());
    }

    public static final int f(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(byteString2, "other");
        int m0 = byteString.m0();
        int m02 = byteString2.m0();
        int min = Math.min(m0, m02);
        for (int i2 = 0; i2 < min; i2++) {
            byte q = byteString.q(i2) & 255;
            byte q2 = byteString2.q(i2) & 255;
            if (q != q2) {
                return q < q2 ? -1 : 1;
            }
        }
        if (m0 == m02) {
            return 0;
        }
        return m0 < m02 ? -1 : 1;
    }

    public static final void g(@NotNull ByteString byteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, TypedValues.AttributesType.M);
        ArraysKt.v0(byteString.r(), bArr, i3, i2, i4 + i2);
    }

    @Nullable
    public static final ByteString h(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        byte[] a2 = _Base64Kt.a(str);
        if (a2 != null) {
            return new ByteString(a2);
        }
        return null;
    }

    @NotNull
    public static final ByteString i(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        int i2 = 0;
        if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i3 = length - 1;
            if (i3 >= 0) {
                while (true) {
                    int i4 = i2 + 1;
                    int i5 = i2 * 2;
                    bArr[i2] = (byte) ((I(str.charAt(i5)) << 4) + I(str.charAt(i5 + 1)));
                    if (i4 > i3) {
                        break;
                    }
                    i2 = i4;
                }
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(Intrinsics.C("Unexpected hex string: ", str).toString());
    }

    @NotNull
    public static final ByteString j(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        ByteString byteString = new ByteString(_JvmPlatformKt.a(str));
        byteString.h0(str);
        return byteString;
    }

    public static final boolean k(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(byteString2, "suffix");
        return byteString.Z(byteString.m0() - byteString2.m0(), byteString2, 0, byteString2.m0());
    }

    public static final boolean l(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, "suffix");
        return byteString.a0(byteString.m0() - bArr.length, bArr, 0, bArr.length);
    }

    public static final boolean m(@NotNull ByteString byteString, @Nullable Object obj) {
        Intrinsics.p(byteString, "<this>");
        if (obj == byteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString2 = (ByteString) obj;
            return byteString2.m0() == byteString.r().length && byteString2.a0(0, byteString.r(), 0, byteString.r().length);
        }
    }

    public static final byte n(@NotNull ByteString byteString, int i2) {
        Intrinsics.p(byteString, "<this>");
        return byteString.r()[i2];
    }

    public static final int o(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        return byteString.r().length;
    }

    public static final int p(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        int s = byteString.s();
        if (s != 0) {
            return s;
        }
        int hashCode = Arrays.hashCode(byteString.r());
        byteString.e0(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String q(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        char[] cArr = new char[(byteString.r().length * 2)];
        byte[] r = byteString.r();
        int length = r.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            byte b2 = r[i2];
            i2++;
            int i4 = i3 + 1;
            cArr[i3] = J()[(b2 >> 4) & 15];
            i3 += 2;
            cArr[i4] = J()[b2 & 15];
        }
        return StringsKt.t1(cArr);
    }

    public static final int r(@NotNull ByteString byteString, @NotNull byte[] bArr, int i2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, "other");
        int length = byteString.r().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max > length) {
            return -1;
        }
        while (true) {
            int i3 = max + 1;
            if (_UtilKt.d(byteString.r(), max, bArr, 0, bArr.length)) {
                return max;
            }
            if (max == length) {
                return -1;
            }
            max = i3;
        }
    }

    @NotNull
    public static final byte[] s(@NotNull ByteString byteString) {
        Intrinsics.p(byteString, "<this>");
        return byteString.r();
    }

    public static final int t(@NotNull ByteString byteString, @NotNull ByteString byteString2, int i2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(byteString2, "other");
        return byteString.P(byteString2.J(), i2);
    }

    public static final int u(@NotNull ByteString byteString, @NotNull byte[] bArr, int i2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, "other");
        int min = Math.min(_UtilKt.l(byteString, i2), byteString.r().length - bArr.length);
        if (min < 0) {
            return -1;
        }
        while (true) {
            int i3 = min - 1;
            if (_UtilKt.d(byteString.r(), min, bArr, 0, bArr.length)) {
                return min;
            }
            if (i3 < 0) {
                return -1;
            }
            min = i3;
        }
    }

    @NotNull
    public static final ByteString v(@NotNull byte[] bArr) {
        Intrinsics.p(bArr, "data");
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean w(@NotNull ByteString byteString, int i2, @NotNull ByteString byteString2, int i3, int i4) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(byteString2, "other");
        return byteString2.a0(i3, byteString.r(), i2, i4);
    }

    public static final boolean x(@NotNull ByteString byteString, int i2, @NotNull byte[] bArr, int i3, int i4) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, "other");
        return i2 >= 0 && i2 <= byteString.r().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && _UtilKt.d(byteString.r(), i2, bArr, i3, i4);
    }

    public static final boolean y(@NotNull ByteString byteString, @NotNull ByteString byteString2) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(byteString2, "prefix");
        return byteString.Z(0, byteString2, 0, byteString2.m0());
    }

    public static final boolean z(@NotNull ByteString byteString, @NotNull byte[] bArr) {
        Intrinsics.p(byteString, "<this>");
        Intrinsics.p(bArr, "prefix");
        return byteString.a0(0, bArr, 0, bArr.length);
    }
}
