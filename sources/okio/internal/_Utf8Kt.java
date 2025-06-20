package okio.internal;

import androidx.media3.extractor.ts.PsExtractor;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "beginIndex", "endIndex", "", "b", "([BII)Ljava/lang/String;", "a", "(Ljava/lang/String;)[B", "okio"}, k = 2, mv = {1, 5, 1})
public final class _Utf8Kt {
    @NotNull
    public static final byte[] a(@NotNull String str) {
        int i2;
        int i3;
        char charAt;
        Intrinsics.p(str, "<this>");
        byte[] bArr = new byte[(str.length() * 4)];
        int length = str.length();
        if (length > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i2 + 1;
                char charAt2 = str.charAt(i2);
                if (Intrinsics.t(charAt2, 128) >= 0) {
                    int length2 = str.length();
                    int i6 = i2;
                    while (i2 < length2) {
                        char charAt3 = str.charAt(i2);
                        if (Intrinsics.t(charAt3, 128) < 0) {
                            int i7 = i6 + 1;
                            bArr[i6] = (byte) charAt3;
                            i2++;
                            while (true) {
                                i6 = i7;
                                if (i2 >= length2 || Intrinsics.t(str.charAt(i2), 128) >= 0) {
                                    break;
                                }
                                i7 = i6 + 1;
                                bArr[i6] = (byte) str.charAt(i2);
                                i2++;
                            }
                        } else {
                            if (Intrinsics.t(charAt3, 2048) < 0) {
                                bArr[i6] = (byte) ((charAt3 >> 6) | PsExtractor.x);
                                i6 += 2;
                                bArr[i6 + 1] = (byte) ((charAt3 & '?') | 128);
                            } else if (55296 > charAt3 || charAt3 > 57343) {
                                bArr[i6] = (byte) ((charAt3 >> 12) | 224);
                                bArr[i6 + 1] = (byte) (((charAt3 >> 6) & 63) | 128);
                                i6 += 3;
                                bArr[i6 + 2] = (byte) ((charAt3 & '?') | 128);
                            } else if (Intrinsics.t(charAt3, 56319) > 0 || length2 <= (i3 = i2 + 1) || 56320 > (charAt = str.charAt(i3)) || charAt > 57343) {
                                bArr[i6] = Utf8.f31404a;
                                i2++;
                                i6++;
                            } else {
                                int charAt4 = ((charAt3 << 10) + str.charAt(i3)) - 56613888;
                                bArr[i6] = (byte) ((charAt4 >> 18) | PsExtractor.A);
                                bArr[i6 + 1] = (byte) (((charAt4 >> 12) & 63) | 128);
                                bArr[i6 + 2] = (byte) (((charAt4 >> 6) & 63) | 128);
                                i6 += 4;
                                bArr[i6 + 3] = (byte) ((charAt4 & 63) | 128);
                                i2 += 2;
                            }
                            i2++;
                        }
                    }
                    byte[] copyOf = Arrays.copyOf(bArr, i6);
                    Intrinsics.o(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return copyOf;
                }
                bArr[i2] = (byte) charAt2;
                if (i5 >= length) {
                    break;
                }
                i4 = i5;
            }
        }
        byte[] copyOf2 = Arrays.copyOf(bArr, str.length());
        Intrinsics.o(copyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0091, code lost:
        if ((r0[r5] & 192) == 128) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00fc, code lost:
        if ((r0[r5] & 192) == 128) goto L_0x00fe;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String b(@org.jetbrains.annotations.NotNull byte[] r16, int r17, int r18) {
        /*
            r0 = r16
            r1 = r17
            r2 = r18
            java.lang.String r3 = "<this>"
            kotlin.jvm.internal.Intrinsics.p(r0, r3)
            if (r1 < 0) goto L_0x018d
            int r3 = r0.length
            if (r2 > r3) goto L_0x018d
            if (r1 > r2) goto L_0x018d
            int r3 = r2 - r1
            char[] r3 = new char[r3]
            r4 = 0
            r5 = 0
        L_0x0018:
            if (r1 >= r2) goto L_0x0188
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0034
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            int r1 = r1 + 1
        L_0x0025:
            r5 = r7
            if (r1 >= r2) goto L_0x0018
            byte r6 = r0[r1]
            if (r6 < 0) goto L_0x0018
            int r1 = r1 + 1
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0025
        L_0x0034:
            int r7 = r6 >> 5
            r8 = -2
            r10 = 128(0x80, float:1.794E-43)
            r11 = 65533(0xfffd, float:9.1831E-41)
            r12 = 1
            if (r7 != r8) goto L_0x0073
            int r7 = r1 + 1
            if (r2 > r7) goto L_0x004d
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x0048:
            kotlin.Unit r5 = kotlin.Unit.f28779a
        L_0x004a:
            r5 = r7
        L_0x004b:
            r9 = 1
            goto L_0x0071
        L_0x004d:
            byte r7 = r0[r7]
            r8 = r7 & 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x006b
            r7 = r7 ^ 3968(0xf80, float:5.56E-42)
            int r6 = r6 << 6
            r6 = r6 ^ r7
            if (r6 >= r10) goto L_0x0062
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x005f:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x0068
        L_0x0062:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x005f
        L_0x0068:
            r5 = r7
        L_0x0069:
            r9 = 2
            goto L_0x0071
        L_0x006b:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x0048
        L_0x0071:
            int r1 = r1 + r9
            goto L_0x0018
        L_0x0073:
            int r7 = r6 >> 4
            r13 = 57343(0xdfff, float:8.0355E-41)
            r14 = 55296(0xd800, float:7.7486E-41)
            r15 = 3
            if (r7 != r8) goto L_0x00dc
            int r7 = r1 + 2
            if (r2 > r7) goto L_0x0094
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f28779a
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x004a
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x004a
        L_0x0093:
            goto L_0x0068
        L_0x0094:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00d3
            byte r7 = r0[r7]
            r9 = r7 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x00cb
            r9 = -123008(0xfffffffffffe1f80, float:NaN)
            r7 = r7 ^ r9
            int r8 = r8 << 6
            r7 = r7 ^ r8
            int r6 = r6 << 12
            r6 = r6 ^ r7
            r7 = 2048(0x800, float:2.87E-42)
            if (r6 >= r7) goto L_0x00b8
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
        L_0x00b5:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x00c8
        L_0x00b8:
            if (r14 > r6) goto L_0x00c2
            if (r6 > r13) goto L_0x00c2
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00b5
        L_0x00c2:
            char r6 = (char) r6
            int r7 = r5 + 1
            r3[r5] = r6
            goto L_0x00b5
        L_0x00c8:
            r5 = r7
        L_0x00c9:
            r9 = 3
            goto L_0x0071
        L_0x00cb:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x0093
        L_0x00d3:
            char r6 = (char) r11
            int r7 = r5 + 1
            r3[r5] = r6
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x004a
        L_0x00dc:
            int r7 = r6 >> 3
            if (r7 != r8) goto L_0x017f
            int r7 = r1 + 3
            if (r2 > r7) goto L_0x0106
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f28779a
            int r5 = r1 + 1
            if (r2 <= r5) goto L_0x0103
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0103
            int r5 = r1 + 2
            if (r2 <= r5) goto L_0x0100
            byte r5 = r0[r5]
            r5 = r5 & 192(0xc0, float:2.69E-43)
            if (r5 != r10) goto L_0x0100
        L_0x00fe:
            r5 = r6
            goto L_0x00c9
        L_0x0100:
            r5 = r6
            goto L_0x0069
        L_0x0103:
            r5 = r6
            goto L_0x004b
        L_0x0106:
            int r8 = r1 + 1
            byte r8 = r0[r8]
            r9 = r8 & 192(0xc0, float:2.69E-43)
            if (r9 != r10) goto L_0x0178
            int r9 = r1 + 2
            byte r9 = r0[r9]
            r12 = r9 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x0171
            byte r7 = r0[r7]
            r12 = r7 & 192(0xc0, float:2.69E-43)
            if (r12 != r10) goto L_0x016a
            r10 = 3678080(0x381f80, float:5.154088E-39)
            r7 = r7 ^ r10
            int r9 = r9 << 6
            r7 = r7 ^ r9
            int r8 = r8 << 12
            r7 = r7 ^ r8
            int r6 = r6 << 18
            r6 = r6 ^ r7
            r7 = 1114111(0x10ffff, float:1.561202E-39)
            if (r6 <= r7) goto L_0x0135
            int r6 = r5 + 1
            r3[r5] = r11
        L_0x0132:
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x0166
        L_0x0135:
            if (r14 > r6) goto L_0x013e
            if (r6 > r13) goto L_0x013e
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0132
        L_0x013e:
            r7 = 65536(0x10000, float:9.18355E-41)
            if (r6 >= r7) goto L_0x0147
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0132
        L_0x0147:
            if (r6 == r11) goto L_0x0161
            int r7 = r6 >>> 10
            r8 = 55232(0xd7c0, float:7.7397E-41)
            int r7 = r7 + r8
            char r7 = (char) r7
            int r8 = r5 + 1
            r3[r5] = r7
            r6 = r6 & 1023(0x3ff, float:1.434E-42)
            r7 = 56320(0xdc00, float:7.8921E-41)
            int r6 = r6 + r7
            char r6 = (char) r6
            int r5 = r5 + 2
            r3[r8] = r6
            r6 = r5
            goto L_0x0132
        L_0x0161:
            int r6 = r5 + 1
            r3[r5] = r11
            goto L_0x0132
        L_0x0166:
            r9 = 4
            r5 = r6
            goto L_0x0071
        L_0x016a:
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x00fe
        L_0x0171:
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x0100
        L_0x0178:
            int r6 = r5 + 1
            r3[r5] = r11
            kotlin.Unit r5 = kotlin.Unit.f28779a
            goto L_0x0103
        L_0x017f:
            int r6 = r5 + 1
            r3[r5] = r11
            int r1 = r1 + 1
            r5 = r6
            goto L_0x0018
        L_0x0188:
            java.lang.String r0 = kotlin.text.StringsKt.u1(r3, r4, r5)
            return r0
        L_0x018d:
            java.lang.ArrayIndexOutOfBoundsException r3 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "size="
            r4.append(r5)
            int r0 = r0.length
            r4.append(r0)
            java.lang.String r0 = " beginIndex="
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = " endIndex="
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._Utf8Kt.b(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String c(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return b(bArr, i2, i3);
    }
}
