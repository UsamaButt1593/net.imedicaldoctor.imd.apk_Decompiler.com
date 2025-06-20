package com.itextpdf.xmp.impl;

import com.itextpdf.text.DocWriter;
import com.itextpdf.text.pdf.ByteBuffer;
import okio.Utf8;

public class Base64 {

    /* renamed from: a  reason: collision with root package name */
    private static final byte f27738a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final byte f27739b = -2;

    /* renamed from: c  reason: collision with root package name */
    private static final byte f27740c = -3;

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f27741d = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, ByteBuffer.X2, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, DocWriter.g3};

    /* renamed from: e  reason: collision with root package name */
    private static byte[] f27742e = new byte[255];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            f27742e[i3] = -1;
        }
        while (true) {
            byte[] bArr = f27741d;
            if (i2 < bArr.length) {
                f27742e[bArr[i2]] = (byte) i2;
                i2++;
            } else {
                byte[] bArr2 = f27742e;
                bArr2[9] = f27739b;
                bArr2[10] = f27739b;
                bArr2[13] = f27739b;
                bArr2[32] = f27739b;
                bArr2[61] = f27740c;
                return;
            }
        }
    }

    public static final String a(String str) {
        return new String(b(str.getBytes()));
    }

    public static final byte[] b(byte[] bArr) throws IllegalArgumentException {
        int i2 = 0;
        int i3 = 0;
        for (byte b2 : bArr) {
            byte b3 = f27742e[b2];
            if (b3 >= 0) {
                bArr[i3] = b3;
                i3++;
            } else if (b3 == -1) {
                throw new IllegalArgumentException("Invalid base 64 string");
            }
        }
        while (i3 > 0 && bArr[i3 - 1] == -3) {
            i3--;
        }
        int i4 = (i3 * 3) / 4;
        byte[] bArr2 = new byte[i4];
        int i5 = 0;
        while (i2 < i4 - 2) {
            int i6 = i5 + 1;
            bArr2[i2] = (byte) (((bArr[i5] << 2) & 255) | ((bArr[i6] >>> 4) & 3));
            int i7 = i5 + 2;
            bArr2[i2 + 1] = (byte) (((bArr[i6] << 4) & 255) | ((bArr[i7] >>> 2) & 15));
            bArr2[i2 + 2] = (byte) (((bArr[i7] << 6) & 255) | (bArr[i5 + 3] & Utf8.f31404a));
            i5 += 4;
            i2 += 3;
        }
        if (i2 < i4) {
            bArr2[i2] = (byte) (((bArr[i5] << 2) & 255) | ((bArr[i5 + 1] >>> 4) & 3));
        }
        int i8 = i2 + 1;
        if (i8 < i4) {
            bArr2[i8] = (byte) (((bArr[i5 + 2] >>> 2) & 15) | ((bArr[i5 + 1] << 4) & 255));
        }
        return bArr2;
    }

    public static final String c(String str) {
        return new String(d(str.getBytes()));
    }

    public static final byte[] d(byte[] bArr) {
        return e(bArr, 0);
    }

    public static final byte[] e(byte[] bArr, int i2) {
        int i3 = (i2 / 4) * 4;
        int i4 = 0;
        if (i3 < 0) {
            i3 = 0;
        }
        int length = ((bArr.length + 2) / 3) * 4;
        if (i3 > 0) {
            length += (length - 1) / i3;
        }
        byte[] bArr2 = new byte[length];
        int i5 = 0;
        int i6 = 0;
        while (i4 + 3 <= bArr.length) {
            int i7 = i4 + 2;
            int i8 = (bArr[i4 + 1] & 255) << 8;
            i4 += 3;
            byte b2 = i8 | ((bArr[i4] & 255) << 16) | (bArr[i7] & 255);
            byte[] bArr3 = f27741d;
            bArr2[i5] = bArr3[(b2 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr3[(b2 & 258048) >> 12];
            bArr2[i5 + 2] = bArr3[(b2 & 4032) >> 6];
            int i9 = i5 + 4;
            bArr2[i5 + 3] = bArr3[b2 & Utf8.f31404a];
            i6 += 4;
            if (i9 >= length || i3 <= 0 || i6 % i3 != 0) {
                i5 = i9;
            } else {
                i5 += 5;
                bArr2[i9] = 10;
            }
        }
        if (bArr.length - i4 == 2) {
            int i10 = ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4] & 255) << 16);
            byte[] bArr4 = f27741d;
            bArr2[i5] = bArr4[(i10 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr4[(i10 & 258048) >> 12];
            bArr2[i5 + 2] = bArr4[(i10 & 4032) >> 6];
            bArr2[i5 + 3] = 61;
        } else if (bArr.length - i4 == 1) {
            int i11 = (bArr[i4] & 255) << 16;
            byte[] bArr5 = f27741d;
            bArr2[i5] = bArr5[(i11 & 16515072) >> 18];
            bArr2[i5 + 1] = bArr5[(i11 & 258048) >> 12];
            bArr2[i5 + 2] = 61;
            bArr2[i5 + 3] = 61;
        }
        return bArr2;
    }
}
