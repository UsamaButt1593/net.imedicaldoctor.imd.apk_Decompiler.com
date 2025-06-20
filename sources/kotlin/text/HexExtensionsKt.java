package kotlin.text;

import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.Arrays;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\n\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\t\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\t\u0010\n\u001aG\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001d\u0010\u0014\u001a\u00020\u0000*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u0015\u001a1\u0010\u0016\u001a\u00020\u0000*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0016\u0010\u0017\u001aG\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0019\u0010\u0013\u001a'\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001e\u0010\u001f\u001a'\u0010!\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\"\u001a#\u0010$\u001a\u00020\u0006*\u00020\u00032\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u0003*\u00020&2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b'\u0010(\u001a\u001d\u0010)\u001a\u00020&*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b)\u0010*\u001a1\u0010+\u001a\u00020&*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b+\u0010,\u001a\u001d\u0010.\u001a\u00020\u0003*\u00020-2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010/\u001a\u001d\u00100\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b0\u00101\u001a1\u00102\u001a\u00020-*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b2\u00103\u001a\u001d\u00104\u001a\u00020\u0003*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b4\u00105\u001a\u001d\u00106\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b6\u00107\u001a1\u00108\u001a\u00020\u0006*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b8\u00109\u001a\u001d\u0010:\u001a\u00020\u0003*\u00020\u001a2\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b:\u0010;\u001a\u001d\u0010<\u001a\u00020\u001a*\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b<\u0010=\u001a1\u0010>\u001a\u00020\u001a*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003¢\u0006\u0004\b>\u0010?\u001a#\u0010A\u001a\u00020\u0003*\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010@\u001a\u00020\u0006H\u0003¢\u0006\u0004\bA\u0010B\u001a7\u0010D\u001a\u00020\u001a*\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0006H\u0003¢\u0006\u0004\bD\u0010E\u001a3\u0010H\u001a\u00020\u0006*\u00020\u00032\u0006\u0010F\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u0003H\u0002¢\u0006\u0004\bH\u0010I\u001a3\u0010M\u001a\u00020L*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010K\u001a\u00020JH\u0002¢\u0006\u0004\bM\u0010N\u001a\u001b\u0010O\u001a\u00020\u0006*\u00020\u00032\u0006\u0010#\u001a\u00020\u0006H\u0002¢\u0006\u0004\bO\u0010P\"\u0014\u0010R\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\b\u001e\u0010Q\"\u0014\u0010S\u001a\u00020\u00038\u0002XT¢\u0006\u0006\n\u0004\bH\u0010Q\"\u001a\u0010X\u001a\u00020T8\u0002X\u0004¢\u0006\f\n\u0004\bM\u0010U\u0012\u0004\bV\u0010W¨\u0006Y"}, d2 = {"", "Lkotlin/text/HexFormat;", "format", "", "J", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "", "startIndex", "endIndex", "I", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "totalBytes", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "f", "(IIIIIII)I", "m", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "l", "(Ljava/lang/String;IILkotlin/text/HexFormat;)[B", "stringLength", "D", "", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "a", "(JII)J", "charsPerSet", "R", "(JJI)J", "index", "d", "(Ljava/lang/String;II)I", "", "E", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "i", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "h", "(Ljava/lang/String;IILkotlin/text/HexFormat;)B", "", "H", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "A", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "z", "(Ljava/lang/String;IILkotlin/text/HexFormat;)S", "F", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "q", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "p", "(Ljava/lang/String;IILkotlin/text/HexFormat;)I", "G", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "u", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "t", "(Ljava/lang/String;IILkotlin/text/HexFormat;)J", "bits", "Q", "(JLkotlin/text/HexFormat;I)Ljava/lang/String;", "maxDigits", "x", "(Ljava/lang/String;IILkotlin/text/HexFormat;I)J", "part", "partName", "b", "(Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)I", "", "requireMaxLength", "", "c", "(Ljava/lang/String;IIIZ)V", "e", "(Ljava/lang/String;I)I", "Ljava/lang/String;", "LOWER_CASE_HEX_DIGITS", "UPPER_CASE_HEX_DIGITS", "", "[I", "g", "()V", "HEX_DIGITS_TO_DECIMAL", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nHexExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,594:1\n1#2:595\n1183#3,3:596\n1183#3,3:599\n*S KotlinDebug\n*F\n+ 1 HexExtensions.kt\nkotlin/text/HexExtensionsKt\n*L\n16#1:596,3\n17#1:599,3\n*E\n"})
public final class HexExtensionsKt {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final String f29066a = "0123456789abcdef";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f29067b = "0123456789ABCDEF";
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f29068c;

    static {
        int[] iArr = new int[128];
        int i2 = 0;
        for (int i3 = 0; i3 < 128; i3++) {
            iArr[i3] = -1;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < f29066a.length()) {
            iArr[f29066a.charAt(i4)] = i5;
            i4++;
            i5++;
        }
        int i6 = 0;
        while (i2 < "0123456789ABCDEF".length()) {
            iArr["0123456789ABCDEF".charAt(i2)] = i6;
            i2++;
            i6++;
        }
        f29068c = iArr;
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final short A(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return z(str, 0, str.length(), hexFormat);
    }

    static /* synthetic */ short B(String str, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return z(str, i2, i3, hexFormat);
    }

    public static /* synthetic */ short C(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return A(str, hexFormat);
    }

    public static final int D(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        long j2;
        int i9;
        int i10;
        int i11 = i2;
        int i12 = i3;
        int i13 = i4;
        int i14 = i5;
        int i15 = i6;
        if (i11 > 0) {
            long j3 = ((long) i7) + 2 + ((long) i8);
            long a2 = a(j3, i13, i15);
            if (i12 <= i13) {
                j2 = a(j3, i12, i15);
            } else {
                j2 = a(a2, i12 / i13, i14);
                int i16 = i12 % i13;
                if (i16 != 0) {
                    j2 = j2 + ((long) i14) + a(j3, i16, i15);
                }
            }
            long j4 = (long) i11;
            long R = R(j4, j2, 1);
            long j5 = j4 - ((j2 + 1) * R);
            long R2 = R(j5, a2, i14);
            long j6 = j5 - ((a2 + ((long) i14)) * R2);
            long R3 = R(j6, j3, i15);
            if (j6 - ((j3 + ((long) i15)) * R3) > 0) {
                i9 = i3;
                i10 = 1;
            } else {
                i10 = 0;
                i9 = i3;
            }
            return (int) ((R * ((long) i9)) + (R2 * ((long) i13)) + R3 + ((long) i10));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String E(byte b2, @NotNull HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return Q((long) b2, hexFormat, 8);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String F(int i2, @NotNull HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return Q((long) i2, hexFormat, 32);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String G(long j2, @NotNull HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return Q(j2, hexFormat, 64);
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String H(short s, @NotNull HexFormat hexFormat) {
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return Q((long) s, hexFormat, 16);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083 A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    @kotlin.SinceKotlin(version = "1.9")
    @kotlin.ExperimentalStdlibApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String I(@org.jetbrains.annotations.NotNull byte[] r17, int r18, int r19, @org.jetbrains.annotations.NotNull kotlin.text.HexFormat r20) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r3)
            java.lang.String r3 = "format"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.p(r4, r3)
            kotlin.collections.AbstractList$Companion r3 = kotlin.collections.AbstractList.s
            int r5 = r0.length
            r3.a(r1, r2, r5)
            if (r1 != r2) goto L_0x001d
            java.lang.String r0 = ""
            return r0
        L_0x001d:
            boolean r3 = r20.e()
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = "0123456789ABCDEF"
            goto L_0x0028
        L_0x0026:
            java.lang.String r3 = "0123456789abcdef"
        L_0x0028:
            kotlin.text.HexFormat$BytesHexFormat r4 = r20.c()
            int r12 = r4.g()
            int r13 = r4.f()
            java.lang.String r14 = r4.c()
            java.lang.String r15 = r4.e()
            java.lang.String r11 = r4.d()
            java.lang.String r4 = r4.h()
            int r5 = r2 - r1
            int r8 = r4.length()
            int r9 = r11.length()
            int r10 = r14.length()
            int r16 = r15.length()
            r6 = r12
            r7 = r13
            r1 = r11
            r11 = r16
            int r5 = f(r5, r6, r7, r8, r9, r10, r11)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r8 = r18
            r9 = 0
            r10 = 0
        L_0x0068:
            if (r8 >= r2) goto L_0x00a2
            byte r11 = r0[r8]
            r7 = r11 & 255(0xff, float:3.57E-43)
            if (r9 != r12) goto L_0x0078
            r9 = 10
            r6.append(r9)
            r9 = 0
        L_0x0076:
            r10 = 0
            goto L_0x007e
        L_0x0078:
            if (r10 != r13) goto L_0x007e
            r6.append(r4)
            goto L_0x0076
        L_0x007e:
            if (r10 == 0) goto L_0x0083
            r6.append(r1)
        L_0x0083:
            r6.append(r14)
            int r7 = r7 >> 4
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r7 = r11 & 15
            char r7 = r3.charAt(r7)
            r6.append(r7)
            r6.append(r15)
            int r10 = r10 + 1
            int r9 = r9 + 1
            int r8 = r8 + 1
            goto L_0x0068
        L_0x00a2:
            int r0 = r6.length()
            if (r5 != r0) goto L_0x00b2
            java.lang.String r0 = r6.toString()
            java.lang.String r1 = "StringBuilder(capacity).…builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.o(r0, r1)
            return r0
        L_0x00b2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Check failed."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.HexExtensionsKt.I(byte[], int, int, kotlin.text.HexFormat):java.lang.String");
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final String J(@NotNull byte[] bArr, @NotNull HexFormat hexFormat) {
        Intrinsics.p(bArr, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return I(bArr, 0, bArr.length, hexFormat);
    }

    public static /* synthetic */ String K(byte b2, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return E(b2, hexFormat);
    }

    public static /* synthetic */ String L(int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return F(i2, hexFormat);
    }

    public static /* synthetic */ String M(long j2, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return G(j2, hexFormat);
    }

    public static /* synthetic */ String N(short s, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return H(s, hexFormat);
    }

    public static /* synthetic */ String O(byte[] bArr, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return I(bArr, i2, i3, hexFormat);
    }

    public static /* synthetic */ String P(byte[] bArr, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return J(bArr, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final String Q(long j2, HexFormat hexFormat, int i2) {
        if ((i2 & 3) == 0) {
            String str = hexFormat.e() ? "0123456789ABCDEF" : f29066a;
            String c2 = hexFormat.d().c();
            String e2 = hexFormat.d().e();
            boolean d2 = hexFormat.d().d();
            StringBuilder sb = new StringBuilder(c2.length() + (i2 >> 2) + e2.length());
            sb.append(c2);
            while (i2 > 0) {
                i2 -= 4;
                int i3 = (int) ((j2 >> i2) & 15);
                d2 = d2 && i3 == 0 && i2 > 0;
                if (!d2) {
                    sb.append(str.charAt(i3));
                }
            }
            sb.append(e2);
            String sb2 = sb.toString();
            Intrinsics.o(sb2, "StringBuilder(capacity).…builderAction).toString()");
            return sb2;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final long R(long j2, long j3, int i2) {
        if (j2 <= 0 || j3 <= 0) {
            return 0;
        }
        long j4 = (long) i2;
        return (j2 + j4) / (j3 + j4);
    }

    private static final long a(long j2, int i2, int i3) {
        if (i2 > 0) {
            long j3 = (long) i2;
            return (j2 * j3) + (((long) i3) * (j3 - 1));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int b(String str, String str2, int i2, int i3, String str3) {
        int length = str2.length() + i2;
        if (length <= i3) {
            if (StringsKt.b2(str, i2, str2, 0, str2.length(), true)) {
                return length;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected ");
        sb.append(str3);
        sb.append(" \"");
        sb.append(str2);
        sb.append("\" at index ");
        sb.append(i2);
        sb.append(", but was ");
        int B = RangesKt.B(length, i3);
        Intrinsics.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i2, B);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    private static final void c(String str, int i2, int i3, int i4, boolean z) {
        int i5 = i3 - i2;
        if (z) {
            if (i5 == i4) {
                return;
            }
        } else if (i5 <= i4) {
            return;
        }
        String str2 = z ? "exactly" : "at most";
        Intrinsics.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i2, i3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i4 + " hexadecimal digits at index " + i2 + ", but was " + substring + " of length " + i5);
    }

    private static final int d(String str, int i2, int i3) {
        if (str.charAt(i2) == 13) {
            int i4 = i2 + 1;
            return (i4 >= i3 || str.charAt(i4) != 10) ? i4 : i2 + 2;
        } else if (str.charAt(i2) == 10) {
            return i2 + 1;
        } else {
            throw new NumberFormatException("Expected a new line at index " + i2 + ", but was " + str.charAt(i2));
        }
    }

    private static final int e(String str, int i2) {
        int i3;
        char charAt = str.charAt(i2);
        if (charAt <= 127 && (i3 = f29068c[charAt]) >= 0) {
            return i3;
        }
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i2 + ", but was " + str.charAt(i2));
    }

    public static final int f(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i2 > 0) {
            int i9 = i2 - 1;
            int i10 = i9 / i3;
            int i11 = (i3 - 1) / i4;
            int i12 = i2 % i3;
            if (i12 != 0) {
                i3 = i12;
            }
            int i13 = (i11 * i10) + ((i3 - 1) / i4);
            long j2 = ((long) i10) + (((long) i13) * ((long) i5)) + (((long) ((i9 - i10) - i13)) * ((long) i6)) + (((long) i2) * (((long) i7) + 2 + ((long) i8)));
            if (RangesKt.K0(new IntRange(0, Integer.MAX_VALUE), j2)) {
                return (int) j2;
            }
            throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m0(ULong.i(j2)));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static /* synthetic */ void g() {
    }

    @ExperimentalStdlibApi
    private static final byte h(String str, int i2, int i3, HexFormat hexFormat) {
        return (byte) ((int) x(str, i2, i3, hexFormat, 2));
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte i(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return h(str, 0, str.length(), hexFormat);
    }

    static /* synthetic */ byte j(String str, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return h(str, i2, i3, hexFormat);
    }

    public static /* synthetic */ byte k(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return i(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final byte[] l(String str, int i2, int i3, HexFormat hexFormat) {
        int i4;
        String str2 = str;
        int i5 = i2;
        int i6 = i3;
        AbstractList.s.a(i5, i6, str.length());
        if (i5 == i6) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat c2 = hexFormat.c();
        int g2 = c2.g();
        int f2 = c2.f();
        String c3 = c2.c();
        String e2 = c2.e();
        String d2 = c2.d();
        String h2 = c2.h();
        String str3 = d2;
        int D = D(i6 - i5, g2, f2, h2.length(), d2.length(), c3.length(), e2.length());
        byte[] bArr = new byte[D];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i4 < i6) {
            if (i8 == g2) {
                i4 = d(str2, i4, i6);
                i8 = 0;
            } else if (i9 == f2) {
                i4 = b(str2, h2, i4, i6, "group separator");
            } else {
                if (i9 != 0) {
                    i4 = b(str2, str3, i4, i6, "byte separator");
                }
                i8++;
                i9++;
                int b2 = b(str2, c3, i4, i6, "byte prefix");
                c(str2, b2, RangesKt.B(b2 + 2, i6), 2, true);
                bArr[i7] = (byte) ((e(str2, b2) << 4) | e(str2, b2 + 1));
                i5 = b(str2, e2, b2 + 2, i6, "byte suffix");
                i7++;
                str3 = str3;
            }
            i9 = 0;
            i8++;
            i9++;
            int b22 = b(str2, c3, i4, i6, "byte prefix");
            c(str2, b22, RangesKt.B(b22 + 2, i6), 2, true);
            bArr[i7] = (byte) ((e(str2, b22) << 4) | e(str2, b22 + 1));
            i5 = b(str2, e2, b22 + 2, i6, "byte suffix");
            i7++;
            str3 = str3;
        }
        if (i7 == D) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i7);
        Intrinsics.o(copyOf, "copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final byte[] m(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return l(str, 0, str.length(), hexFormat);
    }

    static /* synthetic */ byte[] n(String str, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return l(str, i2, i3, hexFormat);
    }

    public static /* synthetic */ byte[] o(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return m(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final int p(String str, int i2, int i3, HexFormat hexFormat) {
        return (int) x(str, i2, i3, hexFormat, 8);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final int q(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return p(str, 0, str.length(), hexFormat);
    }

    static /* synthetic */ int r(String str, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return p(str, i2, i3, hexFormat);
    }

    public static /* synthetic */ int s(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return q(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long t(String str, int i2, int i3, HexFormat hexFormat) {
        return x(str, i2, i3, hexFormat, 16);
    }

    @SinceKotlin(version = "1.9")
    @ExperimentalStdlibApi
    public static final long u(@NotNull String str, @NotNull HexFormat hexFormat) {
        Intrinsics.p(str, "<this>");
        Intrinsics.p(hexFormat, DublinCoreProperties.f27400f);
        return t(str, 0, str.length(), hexFormat);
    }

    static /* synthetic */ long v(String str, int i2, int i3, HexFormat hexFormat, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        if ((i4 & 4) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return t(str, i2, i3, hexFormat);
    }

    public static /* synthetic */ long w(String str, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.f29069d.a();
        }
        return u(str, hexFormat);
    }

    @ExperimentalStdlibApi
    private static final long x(String str, int i2, int i3, HexFormat hexFormat, int i4) {
        AbstractList.s.a(i2, i3, str.length());
        String c2 = hexFormat.d().c();
        String e2 = hexFormat.d().e();
        if (c2.length() + e2.length() < i3 - i2) {
            int b2 = b(str, c2, i2, i3, "prefix");
            int length = i3 - e2.length();
            b(str, e2, length, i3, "suffix");
            c(str, b2, length, i4, false);
            long j2 = 0;
            while (b2 < length) {
                j2 = (j2 << 4) | ((long) e(str, b2));
                b2++;
            }
            return j2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected a hexadecimal number with prefix \"");
        sb.append(c2);
        sb.append("\" and suffix \"");
        sb.append(e2);
        sb.append("\", but was ");
        Intrinsics.n(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i2, i3);
        Intrinsics.o(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        throw new NumberFormatException(sb.toString());
    }

    static /* synthetic */ long y(String str, int i2, int i3, HexFormat hexFormat, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = 0;
        }
        if ((i5 & 2) != 0) {
            i3 = str.length();
        }
        return x(str, i2, i3, hexFormat, i4);
    }

    @ExperimentalStdlibApi
    private static final short z(String str, int i2, int i3, HexFormat hexFormat) {
        return (short) ((int) x(str, i2, i3, hexFormat, 4));
    }
}
