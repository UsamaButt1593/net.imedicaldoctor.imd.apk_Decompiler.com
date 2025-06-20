package org.apache.commons.codec.binary;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import java.math.BigInteger;
import okio.Utf8;
import org.apache.commons.codec.binary.BaseNCodec;

public class Base64 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 6;
    private static final int BYTES_PER_ENCODED_BLOCK = 4;
    private static final int BYTES_PER_UNENCODED_BLOCK = 3;
    static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, DocWriter.f3, -1, DocWriter.f3, -1, Utf8.f31404a, 52, 53, 54, 55, 56, 57, 58, 59, DocWriter.b3, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, Ascii.x, Ascii.y, Ascii.z, Ascii.A, Ascii.B, Ascii.C, -1, -1, -1, -1, Utf8.f31404a, -1, Ascii.D, Ascii.E, Ascii.F, Ascii.G, Ascii.H, Ascii.I, 32, 33, DocWriter.e3, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, DocWriter.g3, ByteBuffer.X2, 49, 50, 51};
    private static final int MASK_6BITS = 63;
    private static final byte[] STANDARD_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.g3};
    private static final byte[] URL_SAFE_ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base64() {
        this(0);
    }

    public static byte[] decodeBase64(String str) {
        return new Base64().decode(str);
    }

    public static BigInteger decodeInteger(byte[] bArr) {
        return new BigInteger(1, decodeBase64(bArr));
    }

    public static byte[] encodeBase64(byte[] bArr) {
        return encodeBase64(bArr, false);
    }

    public static byte[] encodeBase64Chunked(byte[] bArr) {
        return encodeBase64(bArr, true);
    }

    public static String encodeBase64String(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false));
    }

    public static byte[] encodeBase64URLSafe(byte[] bArr) {
        return encodeBase64(bArr, false, true);
    }

    public static String encodeBase64URLSafeString(byte[] bArr) {
        return StringUtils.newStringUsAscii(encodeBase64(bArr, false, true));
    }

    public static byte[] encodeInteger(BigInteger bigInteger) {
        if (bigInteger != null) {
            return encodeBase64(toIntegerBytes(bigInteger), false);
        }
        throw new NullPointerException("encodeInteger called with null parameter");
    }

    @Deprecated
    public static boolean isArrayByteBase64(byte[] bArr) {
        return isBase64(bArr);
    }

    public static boolean isBase64(byte b2) {
        if (b2 != 61) {
            if (b2 >= 0) {
                byte[] bArr = DECODE_TABLE;
                if (b2 >= bArr.length || bArr[b2] == -1) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    static byte[] toIntegerBytes(BigInteger bigInteger) {
        int bitLength = ((bigInteger.bitLength() + 7) >> 3) << 3;
        byte[] byteArray = bigInteger.toByteArray();
        int i2 = 1;
        if (bigInteger.bitLength() % 8 != 0 && (bigInteger.bitLength() / 8) + 1 == bitLength / 8) {
            return byteArray;
        }
        int length = byteArray.length;
        if (bigInteger.bitLength() % 8 == 0) {
            length--;
        } else {
            i2 = 0;
        }
        int i3 = bitLength / 8;
        int i4 = i3 - length;
        byte[] bArr = new byte[i3];
        System.arraycopy(byteArray, i2, bArr, i4, length);
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public void decode(byte[] bArr, int i2, int i3, BaseNCodec.Context context) {
        byte b2;
        if (!context.eof) {
            if (i3 < 0) {
                context.eof = true;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
                int i5 = i2 + 1;
                byte b3 = bArr[i2];
                if (b3 == this.pad) {
                    context.eof = true;
                    break;
                }
                if (b3 >= 0) {
                    byte[] bArr2 = DECODE_TABLE;
                    if (b3 < bArr2.length && (b2 = bArr2[b3]) >= 0) {
                        int i6 = (context.modulus + 1) % 4;
                        context.modulus = i6;
                        int i7 = (context.ibitWorkArea << 6) + b2;
                        context.ibitWorkArea = i7;
                        if (i6 == 0) {
                            int i8 = context.pos;
                            int i9 = i8 + 1;
                            context.pos = i9;
                            ensureBufferSize[i8] = (byte) ((i7 >> 16) & 255);
                            int i10 = i8 + 2;
                            context.pos = i10;
                            ensureBufferSize[i9] = (byte) ((i7 >> 8) & 255);
                            context.pos = i8 + 3;
                            ensureBufferSize[i10] = (byte) (i7 & 255);
                        }
                    }
                }
                i4++;
                i2 = i5;
            }
            if (context.eof && context.modulus != 0) {
                byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
                int i11 = context.modulus;
                if (i11 == 1) {
                    return;
                }
                if (i11 == 2) {
                    int i12 = context.ibitWorkArea >> 4;
                    context.ibitWorkArea = i12;
                    int i13 = context.pos;
                    context.pos = i13 + 1;
                    ensureBufferSize2[i13] = (byte) (i12 & 255);
                } else if (i11 == 3) {
                    int i14 = context.ibitWorkArea;
                    int i15 = i14 >> 2;
                    context.ibitWorkArea = i15;
                    int i16 = context.pos;
                    int i17 = i16 + 1;
                    context.pos = i17;
                    ensureBufferSize2[i16] = (byte) ((i14 >> 10) & 255);
                    context.pos = i16 + 2;
                    ensureBufferSize2[i17] = (byte) (i15 & 255);
                } else {
                    throw new IllegalStateException("Impossible modulus " + context.modulus);
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v19, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void encode(byte[] r11, int r12, int r13, org.apache.commons.codec.binary.BaseNCodec.Context r14) {
        /*
            r10 = this;
            boolean r0 = r14.eof
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r1 = 1
            if (r13 >= 0) goto L_0x00bf
            r14.eof = r1
            int r11 = r14.modulus
            if (r11 != 0) goto L_0x0014
            int r11 = r10.lineLength
            if (r11 != 0) goto L_0x0014
            return
        L_0x0014:
            int r11 = r10.encodeSize
            byte[] r11 = r10.ensureBufferSize(r11, r14)
            int r12 = r14.pos
            int r13 = r14.modulus
            if (r13 == 0) goto L_0x00a1
            if (r13 == r1) goto L_0x0073
            r1 = 2
            if (r13 != r1) goto L_0x005a
            int r13 = r12 + 1
            r14.pos = r13
            byte[] r2 = r10.encodeTable
            int r3 = r14.ibitWorkArea
            int r4 = r3 >> 10
            r4 = r4 & 63
            byte r4 = r2[r4]
            r11[r12] = r4
            int r4 = r12 + 2
            r14.pos = r4
            int r5 = r3 >> 4
            r5 = r5 & 63
            byte r5 = r2[r5]
            r11[r13] = r5
            int r13 = r12 + 3
            r14.pos = r13
            int r1 = r3 << 2
            r1 = r1 & 63
            byte r1 = r2[r1]
            r11[r4] = r1
            byte[] r1 = STANDARD_ENCODE_TABLE
            if (r2 != r1) goto L_0x00a1
            int r1 = r12 + 4
            r14.pos = r1
            byte r1 = r10.pad
            r11[r13] = r1
            goto L_0x00a1
        L_0x005a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = "Impossible modulus "
            r12.append(r13)
            int r13 = r14.modulus
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12)
            throw r11
        L_0x0073:
            int r13 = r12 + 1
            r14.pos = r13
            byte[] r1 = r10.encodeTable
            int r2 = r14.ibitWorkArea
            int r3 = r2 >> 2
            r3 = r3 & 63
            byte r3 = r1[r3]
            r11[r12] = r3
            int r3 = r12 + 2
            r14.pos = r3
            int r2 = r2 << 4
            r2 = r2 & 63
            byte r2 = r1[r2]
            r11[r13] = r2
            byte[] r13 = STANDARD_ENCODE_TABLE
            if (r1 != r13) goto L_0x00a1
            int r13 = r12 + 3
            r14.pos = r13
            byte r1 = r10.pad
            r11[r3] = r1
            int r2 = r12 + 4
            r14.pos = r2
            r11[r13] = r1
        L_0x00a1:
            int r13 = r14.currentLinePos
            int r1 = r14.pos
            int r12 = r1 - r12
            int r13 = r13 + r12
            r14.currentLinePos = r13
            int r12 = r10.lineLength
            if (r12 <= 0) goto L_0x0132
            if (r13 <= 0) goto L_0x0132
            byte[] r12 = r10.lineSeparator
            int r13 = r12.length
            java.lang.System.arraycopy(r12, r0, r11, r1, r13)
            int r11 = r14.pos
            byte[] r12 = r10.lineSeparator
            int r12 = r12.length
            int r11 = r11 + r12
            r14.pos = r11
            goto L_0x0132
        L_0x00bf:
            r2 = 0
        L_0x00c0:
            if (r2 >= r13) goto L_0x0132
            int r3 = r10.encodeSize
            byte[] r3 = r10.ensureBufferSize(r3, r14)
            int r4 = r14.modulus
            int r4 = r4 + r1
            int r4 = r4 % 3
            r14.modulus = r4
            int r5 = r12 + 1
            byte r12 = r11[r12]
            if (r12 >= 0) goto L_0x00d7
            int r12 = r12 + 256
        L_0x00d7:
            int r6 = r14.ibitWorkArea
            int r6 = r6 << 8
            int r6 = r6 + r12
            r14.ibitWorkArea = r6
            if (r4 != 0) goto L_0x012e
            int r12 = r14.pos
            int r4 = r12 + 1
            r14.pos = r4
            byte[] r7 = r10.encodeTable
            int r8 = r6 >> 18
            r8 = r8 & 63
            byte r8 = r7[r8]
            r3[r12] = r8
            int r8 = r12 + 2
            r14.pos = r8
            int r9 = r6 >> 12
            r9 = r9 & 63
            byte r9 = r7[r9]
            r3[r4] = r9
            int r4 = r12 + 3
            r14.pos = r4
            int r9 = r6 >> 6
            r9 = r9 & 63
            byte r9 = r7[r9]
            r3[r8] = r9
            int r12 = r12 + 4
            r14.pos = r12
            r6 = r6 & 63
            byte r6 = r7[r6]
            r3[r4] = r6
            int r4 = r14.currentLinePos
            int r4 = r4 + 4
            r14.currentLinePos = r4
            int r6 = r10.lineLength
            if (r6 <= 0) goto L_0x012e
            if (r6 > r4) goto L_0x012e
            byte[] r4 = r10.lineSeparator
            int r6 = r4.length
            java.lang.System.arraycopy(r4, r0, r3, r12, r6)
            int r12 = r14.pos
            byte[] r3 = r10.lineSeparator
            int r3 = r3.length
            int r12 = r12 + r3
            r14.pos = r12
            r14.currentLinePos = r0
        L_0x012e:
            int r2 = r2 + 1
            r12 = r5
            goto L_0x00c0
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.encode(byte[], int, int, org.apache.commons.codec.binary.BaseNCodec$Context):void");
    }

    /* access modifiers changed from: protected */
    public boolean isInAlphabet(byte b2) {
        if (b2 >= 0) {
            byte[] bArr = this.decodeTable;
            return b2 < bArr.length && bArr[b2] != -1;
        }
    }

    public boolean isUrlSafe() {
        return this.encodeTable == URL_SAFE_ENCODE_TABLE;
    }

    public Base64(int i2) {
        this(i2, CHUNK_SEPARATOR);
    }

    public static byte[] decodeBase64(byte[] bArr) {
        return new Base64().decode(bArr);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z) {
        return encodeBase64(bArr, z, false);
    }

    public static boolean isBase64(String str) {
        return isBase64(StringUtils.getBytesUtf8(str));
    }

    public Base64(int i2, byte[] bArr) {
        this(i2, bArr, false);
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2) {
        return encodeBase64(bArr, z, z2, Integer.MAX_VALUE);
    }

    public static boolean isBase64(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!isBase64(bArr[i2]) && !BaseNCodec.isWhiteSpace(bArr[i2])) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Base64(int r5, byte[] r6, boolean r7) {
        /*
            r4 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0005
            r1 = 0
            goto L_0x0006
        L_0x0005:
            int r1 = r6.length
        L_0x0006:
            r2 = 3
            r3 = 4
            r4.<init>(r2, r3, r5, r1)
            byte[] r1 = DECODE_TABLE
            r4.decodeTable = r1
            r1 = 0
            if (r6 == 0) goto L_0x0028
            boolean r2 = r4.containsAlphabetOrPad(r6)
            if (r2 != 0) goto L_0x002d
            if (r5 <= 0) goto L_0x0028
            int r5 = r6.length
            int r5 = r5 + r3
            r4.encodeSize = r5
            int r5 = r6.length
            byte[] r5 = new byte[r5]
            r4.lineSeparator = r5
            int r1 = r6.length
            java.lang.System.arraycopy(r6, r0, r5, r0, r1)
            goto L_0x004d
        L_0x0028:
            r4.encodeSize = r3
            r4.lineSeparator = r1
            goto L_0x004d
        L_0x002d:
            java.lang.String r5 = org.apache.commons.codec.binary.StringUtils.newStringUtf8(r6)
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "lineSeparator must not contain base64 characters: ["
            r7.append(r0)
            r7.append(r5)
            java.lang.String r5 = "]"
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L_0x004d:
            int r5 = r4.encodeSize
            int r5 = r5 + -1
            r4.decodeSize = r5
            if (r7 == 0) goto L_0x0058
            byte[] r5 = URL_SAFE_ENCODE_TABLE
            goto L_0x005a
        L_0x0058:
            byte[] r5 = STANDARD_ENCODE_TABLE
        L_0x005a:
            r4.encodeTable = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.binary.Base64.<init>(int, byte[], boolean):void");
    }

    public static byte[] encodeBase64(byte[] bArr, boolean z, boolean z2, int i2) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        Base64 base64 = z ? new Base64(z2) : new Base64(0, CHUNK_SEPARATOR, z2);
        long encodedLength = base64.getEncodedLength(bArr);
        if (encodedLength <= ((long) i2)) {
            return base64.encode(bArr);
        }
        throw new IllegalArgumentException("Input array too big, the output array would be bigger (" + encodedLength + ") than the specified maximum size of " + i2);
    }

    public Base64(boolean z) {
        this(76, CHUNK_SEPARATOR, z);
    }
}
