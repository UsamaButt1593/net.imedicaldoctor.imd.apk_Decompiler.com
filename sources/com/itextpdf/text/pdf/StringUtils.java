package com.itextpdf.text.pdf;

import com.itextpdf.text.DocWriter;

public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f26413a = DocWriter.E("\\r");

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f26414b = DocWriter.E("\\n");

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f26415c = DocWriter.E("\\t");

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f26416d = DocWriter.E("\\b");

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f26417e = DocWriter.E("\\f");

    private StringUtils() {
    }

    public static byte[] a(char[] cArr) {
        byte[] bArr = new byte[(cArr.length * 2)];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            int i3 = i2 * 2;
            char c2 = cArr[i2];
            bArr[i3] = (byte) (c2 / 256);
            bArr[i3 + 1] = (byte) (c2 % 256);
        }
        return bArr;
    }

    public static void b(byte[] bArr, ByteBuffer byteBuffer) {
        byteBuffer.r(40);
        for (byte b2 : bArr) {
            if (b2 == 12) {
                byteBuffer.n(f26417e);
            } else if (b2 != 13) {
                if (b2 != 40 && b2 != 41 && b2 != 92) {
                    switch (b2) {
                        case 8:
                            byteBuffer.n(f26416d);
                            break;
                        case 9:
                            byteBuffer.n(f26415c);
                            break;
                        case 10:
                            byteBuffer.n(f26414b);
                            break;
                        default:
                            byteBuffer.r(b2);
                            break;
                    }
                } else {
                    byteBuffer.r(92).r(b2);
                }
            } else {
                byteBuffer.n(f26413a);
            }
        }
        byteBuffer.r(41);
    }

    public static byte[] c(byte[] bArr) {
        ByteBuffer byteBuffer = new ByteBuffer();
        b(bArr, byteBuffer);
        return byteBuffer.F();
    }
}
