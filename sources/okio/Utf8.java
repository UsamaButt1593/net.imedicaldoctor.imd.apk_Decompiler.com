package okio;

import androidx.media3.extractor.ts.PsExtractor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0011\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\b¢\u0006\u0004\b\t\u0010\n\u001a\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\b¢\u0006\u0004\b\r\u0010\u000e\u001a;\u0010\u0012\u001a\u00020\u0010*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a;\u0010\u0015\u001a\u00020\u0010*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a;\u0010\u0018\u001a\u00020\u0010*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0016\u001a;\u0010\u0019\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a;\u0010\u001b\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001a\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00100\u000fH\bø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001a\"\u0014\u0010\u001e\u001a\u00020\u000b8\u0000XT¢\u0006\u0006\n\u0004\b\t\u0010\u001d\"\u0014\u0010 \u001a\u00020\u00178\u0000XT¢\u0006\u0006\n\u0004\b\r\u0010\u001f\"\u0014\u0010\"\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u0019\u0010!\"\u0014\u0010#\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u001b\u0010!\"\u0014\u0010$\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u001c\u0010!\"\u0014\u0010%\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u0018\u0010!\"\u0014\u0010&\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u0012\u0010!\"\u0014\u0010'\u001a\u00020\u00018\u0000XT¢\u0006\u0006\n\u0004\b\u0015\u0010!\u0002\u0007\n\u0005\b20\u0001¨\u0006("}, d2 = {"", "", "beginIndex", "endIndex", "", "k", "(Ljava/lang/String;II)J", "codePoint", "", "a", "(I)Z", "", "byte", "b", "(B)Z", "Lkotlin/Function1;", "", "yield", "g", "(Ljava/lang/String;IILkotlin/jvm/functions/Function1;)V", "", "h", "([BIILkotlin/jvm/functions/Function1;)V", "", "f", "c", "([BIILkotlin/jvm/functions/Function1;)I", "d", "e", "B", "REPLACEMENT_BYTE", "C", "REPLACEMENT_CHARACTER", "I", "REPLACEMENT_CODE_POINT", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "okio"}, k = 2, mv = {1, 5, 1})
@JvmName(name = "Utf8")
public final class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte f31404a = 63;

    /* renamed from: b  reason: collision with root package name */
    public static final char f31405b = '�';

    /* renamed from: c  reason: collision with root package name */
    public static final int f31406c = 65533;

    /* renamed from: d  reason: collision with root package name */
    public static final int f31407d = 55232;

    /* renamed from: e  reason: collision with root package name */
    public static final int f31408e = 56320;

    /* renamed from: f  reason: collision with root package name */
    public static final int f31409f = 3968;

    /* renamed from: g  reason: collision with root package name */
    public static final int f31410g = -123008;

    /* renamed from: h  reason: collision with root package name */
    public static final int f31411h = 3678080;

    public static final boolean a(int i2) {
        return (i2 >= 0 && i2 <= 31) || (127 <= i2 && i2 <= 159);
    }

    public static final boolean b(byte b2) {
        return (b2 & 192) == 128;
    }

    public static final int c(@NotNull byte[] bArr, int i2, int i3, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.p(bArr, "<this>");
        Intrinsics.p(function1, "yield");
        int i4 = i2 + 1;
        Integer valueOf = Integer.valueOf(f31406c);
        if (i3 <= i4) {
            function1.f(valueOf);
            return 1;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i4];
        if ((b3 & 192) == 128) {
            byte b4 = (b3 ^ 3968) ^ (b2 << 6);
            if (b4 < 128) {
                function1.f(valueOf);
                return 2;
            }
            function1.f(Integer.valueOf(b4));
            return 2;
        }
        function1.f(valueOf);
        return 1;
    }

    public static final int d(@NotNull byte[] bArr, int i2, int i3, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.p(bArr, "<this>");
        Intrinsics.p(function1, "yield");
        int i4 = i2 + 2;
        Integer valueOf = Integer.valueOf(f31406c);
        if (i3 <= i4) {
            function1.f(valueOf);
            int i5 = i2 + 1;
            return (i3 <= i5 || (bArr[i5] & 192) != 128) ? 1 : 2;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if ((b3 & 192) == 128) {
            byte b4 = bArr[i4];
            if ((b4 & 192) == 128) {
                byte b5 = ((b4 ^ -123008) ^ (b3 << 6)) ^ (b2 << 12);
                if (b5 >= 2048 && (55296 > b5 || b5 > 57343)) {
                    function1.f(Integer.valueOf(b5));
                    return 3;
                }
                function1.f(valueOf);
                return 3;
            }
            function1.f(valueOf);
            return 2;
        }
        function1.f(valueOf);
        return 1;
    }

    public static final int e(@NotNull byte[] bArr, int i2, int i3, @NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.p(bArr, "<this>");
        Intrinsics.p(function1, "yield");
        int i4 = i2 + 3;
        Integer valueOf = Integer.valueOf(f31406c);
        if (i3 <= i4) {
            function1.f(valueOf);
            int i5 = i2 + 1;
            if (i3 <= i5 || (bArr[i5] & 192) != 128) {
                return 1;
            }
            int i6 = i2 + 2;
            return (i3 <= i6 || (bArr[i6] & 192) != 128) ? 2 : 3;
        }
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        if ((b3 & 192) == 128) {
            byte b4 = bArr[i2 + 2];
            if ((b4 & 192) == 128) {
                byte b5 = bArr[i4];
                if ((b5 & 192) == 128) {
                    byte b6 = (((b5 ^ 3678080) ^ (b4 << 6)) ^ (b3 << 12)) ^ (b2 << 18);
                    if (b6 <= 1114111 && ((55296 > b6 || b6 > 57343) && b6 >= 65536)) {
                        function1.f(Integer.valueOf(b6));
                        return 4;
                    }
                    function1.f(valueOf);
                    return 4;
                }
                function1.f(valueOf);
                return 3;
            }
            function1.f(valueOf);
            return 2;
        }
        function1.f(valueOf);
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if ((r11[r0] & 192) == 128) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e7, code lost:
        if ((r11[r0] & 192) == 128) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void f(@org.jetbrains.annotations.NotNull byte[] r11, int r12, int r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Character, kotlin.Unit> r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)
            java.lang.String r0 = "yield"
            kotlin.jvm.internal.Intrinsics.p(r14, r0)
        L_0x000a:
            if (r12 >= r13) goto L_0x0173
            byte r0 = r11[r12]
            if (r0 < 0) goto L_0x002b
            char r0 = (char) r0
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            int r12 = r12 + 1
        L_0x001a:
            if (r12 >= r13) goto L_0x000a
            byte r0 = r11[r12]
            if (r0 < 0) goto L_0x000a
            int r12 = r12 + 1
            char r0 = (char) r0
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            goto L_0x001a
        L_0x002b:
            int r1 = r0 >> 5
            r2 = -2
            r3 = 2
            r4 = 128(0x80, float:1.794E-43)
            r5 = 1
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r1 != r2) goto L_0x0063
            int r1 = r12 + 1
            if (r13 > r1) goto L_0x0047
        L_0x003b:
            char r0 = (char) r6
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
        L_0x0045:
            r3 = 1
            goto L_0x0061
        L_0x0047:
            byte r1 = r11[r1]
            r2 = r1 & 192(0xc0, float:2.69E-43)
            if (r2 != r4) goto L_0x003b
            r1 = r1 ^ 3968(0xf80, float:5.56E-42)
            int r0 = r0 << 6
            r0 = r0 ^ r1
            if (r0 >= r4) goto L_0x005f
            char r0 = (char) r6
        L_0x0055:
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
        L_0x005c:
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0061
        L_0x005f:
            char r0 = (char) r0
            goto L_0x0055
        L_0x0061:
            int r12 = r12 + r3
            goto L_0x000a
        L_0x0063:
            int r1 = r0 >> 4
            r7 = 57343(0xdfff, float:8.0355E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            r9 = 3
            if (r1 != r2) goto L_0x00c4
            int r1 = r12 + 2
            if (r13 > r1) goto L_0x0087
            char r0 = (char) r6
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            int r0 = r12 + 1
            if (r13 <= r0) goto L_0x0045
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0045
            goto L_0x0061
        L_0x0087:
            int r2 = r12 + 1
            byte r2 = r11[r2]
            r10 = r2 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x00b9
            byte r1 = r11[r1]
            r5 = r1 & 192(0xc0, float:2.69E-43)
            if (r5 != r4) goto L_0x00b7
            r3 = -123008(0xfffffffffffe1f80, float:NaN)
            r1 = r1 ^ r3
            int r2 = r2 << 6
            r1 = r1 ^ r2
            int r0 = r0 << 12
            r0 = r0 ^ r1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L_0x00ae
        L_0x00a3:
            char r0 = (char) r6
        L_0x00a4:
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x00b5
        L_0x00ae:
            if (r8 > r0) goto L_0x00b3
            if (r0 > r7) goto L_0x00b3
            goto L_0x00a3
        L_0x00b3:
            char r0 = (char) r0
            goto L_0x00a4
        L_0x00b5:
            r3 = 3
            goto L_0x0061
        L_0x00b7:
            char r0 = (char) r6
            goto L_0x0055
        L_0x00b9:
            char r0 = (char) r6
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0045
        L_0x00c4:
            int r1 = r0 >> 3
            if (r1 != r2) goto L_0x0168
            int r1 = r12 + 3
            if (r13 > r1) goto L_0x00ea
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            int r0 = r12 + 1
            if (r13 <= r0) goto L_0x0045
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0045
            int r0 = r12 + 2
            if (r13 <= r0) goto L_0x0061
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0061
        L_0x00e9:
            goto L_0x00b5
        L_0x00ea:
            int r2 = r12 + 1
            byte r2 = r11[r2]
            r10 = r2 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x015d
            int r5 = r12 + 2
            byte r5 = r11[r5]
            r10 = r5 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x0154
            byte r1 = r11[r1]
            r3 = r1 & 192(0xc0, float:2.69E-43)
            if (r3 != r4) goto L_0x014a
            r3 = 3678080(0x381f80, float:5.154088E-39)
            r1 = r1 ^ r3
            int r3 = r5 << 6
            r1 = r1 ^ r3
            int r2 = r2 << 12
            r1 = r1 ^ r2
            int r0 = r0 << 18
            r0 = r0 ^ r1
            r1 = 1114111(0x10ffff, float:1.561202E-39)
            if (r0 <= r1) goto L_0x011c
        L_0x0112:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
        L_0x0116:
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0147
        L_0x011c:
            if (r8 > r0) goto L_0x0121
            if (r0 > r7) goto L_0x0121
            goto L_0x0112
        L_0x0121:
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r0 >= r1) goto L_0x0126
            goto L_0x0112
        L_0x0126:
            if (r0 == r6) goto L_0x0142
            int r1 = r0 >>> 10
            r2 = 55232(0xd7c0, float:7.7397E-41)
            int r1 = r1 + r2
            char r1 = (char) r1
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r14.f(r1)
            r0 = r0 & 1023(0x3ff, float:1.434E-42)
            r1 = 56320(0xdc00, float:7.8921E-41)
            int r0 = r0 + r1
            char r0 = (char) r0
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            goto L_0x0116
        L_0x0142:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            goto L_0x0116
        L_0x0147:
            r3 = 4
            goto L_0x0061
        L_0x014a:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x00e9
        L_0x0154:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            r14.f(r0)
            goto L_0x005c
        L_0x015d:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0045
        L_0x0168:
            java.lang.Character r0 = java.lang.Character.valueOf(r6)
            r14.f(r0)
            int r12 = r12 + 1
            goto L_0x000a
        L_0x0173:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.f(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    public static final void g(@NotNull String str, int i2, int i3, @NotNull Function1<? super Byte, Unit> function1) {
        int i4;
        Byte valueOf;
        int i5;
        char charAt;
        Intrinsics.p(str, "<this>");
        Intrinsics.p(function1, "yield");
        while (i2 < i3) {
            char charAt2 = str.charAt(i2);
            if (Intrinsics.t(charAt2, 128) < 0) {
                function1.f(Byte.valueOf((byte) charAt2));
                i2++;
                while (i2 < i3 && Intrinsics.t(str.charAt(i2), 128) < 0) {
                    function1.f(Byte.valueOf((byte) str.charAt(i2)));
                    i2++;
                }
            } else {
                if (Intrinsics.t(charAt2, 2048) < 0) {
                    i4 = (charAt2 >> 6) | PsExtractor.x;
                } else if (55296 > charAt2 || charAt2 > 57343) {
                    function1.f(Byte.valueOf((byte) ((charAt2 >> 12) | 224)));
                    i4 = ((charAt2 >> 6) & 63) | 128;
                } else if (Intrinsics.t(charAt2, 56319) > 0 || i3 <= (i5 = i2 + 1) || 56320 > (charAt = str.charAt(i5)) || charAt > 57343) {
                    valueOf = Byte.valueOf(f31404a);
                    function1.f(valueOf);
                    i2++;
                } else {
                    int charAt3 = ((charAt2 << 10) + str.charAt(i5)) - 56613888;
                    function1.f(Byte.valueOf((byte) ((charAt3 >> 18) | PsExtractor.A)));
                    function1.f(Byte.valueOf((byte) (((charAt3 >> 12) & 63) | 128)));
                    function1.f(Byte.valueOf((byte) (((charAt3 >> 6) & 63) | 128)));
                    function1.f(Byte.valueOf((byte) ((charAt3 & 63) | 128)));
                    i2 += 2;
                }
                function1.f(Byte.valueOf((byte) i4));
                valueOf = Byte.valueOf((byte) ((charAt2 & '?') | 128));
                function1.f(valueOf);
                i2++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0082, code lost:
        if ((r11[r0] & 192) == 128) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ea, code lost:
        if ((r11[r0] & 192) == 128) goto L_0x00b5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void h(@org.jetbrains.annotations.NotNull byte[] r11, int r12, int r13, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)
            java.lang.String r0 = "yield"
            kotlin.jvm.internal.Intrinsics.p(r14, r0)
        L_0x000a:
            if (r12 >= r13) goto L_0x0151
            byte r0 = r11[r12]
            if (r0 < 0) goto L_0x0029
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.f(r0)
            int r12 = r12 + 1
        L_0x0019:
            if (r12 >= r13) goto L_0x000a
            byte r0 = r11[r12]
            if (r0 < 0) goto L_0x000a
            int r12 = r12 + 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r14.f(r0)
            goto L_0x0019
        L_0x0029:
            int r1 = r0 >> 5
            r2 = -2
            r3 = 2
            r4 = 128(0x80, float:1.794E-43)
            r5 = 1
            r6 = 65533(0xfffd, float:9.1831E-41)
            if (r1 != r2) goto L_0x0062
            int r1 = r12 + 1
            if (r13 > r1) goto L_0x0044
        L_0x0039:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
        L_0x0042:
            r3 = 1
            goto L_0x0060
        L_0x0044:
            byte r1 = r11[r1]
            r2 = r1 & 192(0xc0, float:2.69E-43)
            if (r2 != r4) goto L_0x0039
            r1 = r1 ^ 3968(0xf80, float:5.56E-42)
            int r0 = r0 << 6
            r0 = r0 ^ r1
            if (r0 >= r4) goto L_0x005b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
        L_0x0055:
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0060
        L_0x005b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0055
        L_0x0060:
            int r12 = r12 + r3
            goto L_0x000a
        L_0x0062:
            int r1 = r0 >> 4
            r7 = 57343(0xdfff, float:8.0355E-41)
            r8 = 55296(0xd800, float:7.7486E-41)
            r9 = 3
            if (r1 != r2) goto L_0x00c7
            int r1 = r12 + 2
            if (r13 > r1) goto L_0x0085
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            int r0 = r12 + 1
            if (r13 <= r0) goto L_0x0042
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0042
            goto L_0x0060
        L_0x0085:
            int r2 = r12 + 1
            byte r2 = r11[r2]
            r10 = r2 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x00bc
            byte r1 = r11[r1]
            r5 = r1 & 192(0xc0, float:2.69E-43)
            if (r5 != r4) goto L_0x00b7
            r3 = -123008(0xfffffffffffe1f80, float:NaN)
            r1 = r1 ^ r3
            int r2 = r2 << 6
            r1 = r1 ^ r2
            int r0 = r0 << 12
            r0 = r0 ^ r1
            r1 = 2048(0x800, float:2.87E-42)
            if (r0 >= r1) goto L_0x00ab
        L_0x00a1:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
        L_0x00a5:
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x00b5
        L_0x00ab:
            if (r8 > r0) goto L_0x00b0
            if (r0 > r7) goto L_0x00b0
            goto L_0x00a1
        L_0x00b0:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00a5
        L_0x00b5:
            r3 = 3
            goto L_0x0060
        L_0x00b7:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            goto L_0x0055
        L_0x00bc:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0042
        L_0x00c7:
            int r1 = r0 >> 3
            if (r1 != r2) goto L_0x0146
            int r1 = r12 + 3
            if (r13 > r1) goto L_0x00ed
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            int r0 = r12 + 1
            if (r13 <= r0) goto L_0x0042
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0042
            int r0 = r12 + 2
            if (r13 <= r0) goto L_0x0060
            byte r0 = r11[r0]
            r0 = r0 & 192(0xc0, float:2.69E-43)
            if (r0 != r4) goto L_0x0060
        L_0x00ec:
            goto L_0x00b5
        L_0x00ed:
            int r2 = r12 + 1
            byte r2 = r11[r2]
            r10 = r2 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x013b
            int r5 = r12 + 2
            byte r5 = r11[r5]
            r10 = r5 & 192(0xc0, float:2.69E-43)
            if (r10 != r4) goto L_0x00b7
            byte r1 = r11[r1]
            r3 = r1 & 192(0xc0, float:2.69E-43)
            if (r3 != r4) goto L_0x0131
            r3 = 3678080(0x381f80, float:5.154088E-39)
            r1 = r1 ^ r3
            int r3 = r5 << 6
            r1 = r1 ^ r3
            int r2 = r2 << 12
            r1 = r1 ^ r2
            int r0 = r0 << 18
            r0 = r0 ^ r1
            r1 = 1114111(0x10ffff, float:1.561202E-39)
            if (r0 <= r1) goto L_0x011f
        L_0x0115:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
        L_0x0119:
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x012e
        L_0x011f:
            if (r8 > r0) goto L_0x0124
            if (r0 > r7) goto L_0x0124
            goto L_0x0115
        L_0x0124:
            r1 = 65536(0x10000, float:9.18355E-41)
            if (r0 >= r1) goto L_0x0129
            goto L_0x0115
        L_0x0129:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0119
        L_0x012e:
            r3 = 4
            goto L_0x0060
        L_0x0131:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x00ec
        L_0x013b:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            kotlin.Unit r0 = kotlin.Unit.f28779a
            goto L_0x0042
        L_0x0146:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r6)
            r14.f(r0)
            int r12 = r12 + 1
            goto L_0x000a
        L_0x0151:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Utf8.h(byte[], int, int, kotlin.jvm.functions.Function1):void");
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long i(@NotNull String str) {
        Intrinsics.p(str, "<this>");
        return l(str, 0, 0, 3, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long j(@NotNull String str, int i2) {
        Intrinsics.p(str, "<this>");
        return l(str, i2, 0, 2, (Object) null);
    }

    @JvmOverloads
    @JvmName(name = "size")
    public static final long k(@NotNull String str, int i2, int i3) {
        int i4;
        Intrinsics.p(str, "<this>");
        boolean z = true;
        if (i2 >= 0) {
            if (i3 >= i2) {
                if (i3 > str.length()) {
                    z = false;
                }
                if (z) {
                    long j2 = 0;
                    while (i2 < i3) {
                        char charAt = str.charAt(i2);
                        if (charAt < 128) {
                            j2++;
                        } else {
                            if (charAt < 2048) {
                                i4 = 2;
                            } else if (charAt < 55296 || charAt > 57343) {
                                i4 = 3;
                            } else {
                                int i5 = i2 + 1;
                                char charAt2 = i5 < i3 ? str.charAt(i5) : 0;
                                if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                    j2++;
                                    i2 = i5;
                                } else {
                                    j2 += (long) 4;
                                    i2 += 2;
                                }
                            }
                            j2 += (long) i4;
                        }
                        i2++;
                    }
                    return j2;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        throw new IllegalArgumentException(Intrinsics.C("beginIndex < 0: ", Integer.valueOf(i2)).toString());
    }

    public static /* synthetic */ long l(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return k(str, i2, i3);
    }
}
