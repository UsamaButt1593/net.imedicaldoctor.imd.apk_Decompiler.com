package com.itextpdf.text.pdf.qrcode;

import androidx.media3.extractor.ts.TsExtractor;

public final class MatrixUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f27202a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b  reason: collision with root package name */
    private static final int[][] f27203b = {new int[]{0, 0, 0, 0, 0, 0, 0, 0}};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f27204c = {new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f27205d = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f27206e = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, TsExtractor.L, -1}, new int[]{6, 30, 56, 82, 108, TsExtractor.T, -1}, new int[]{6, 34, 60, 86, 112, TsExtractor.K, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, TsExtractor.V, 162}, new int[]{6, 26, 54, 82, 110, TsExtractor.K, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    /* renamed from: f  reason: collision with root package name */
    private static final int[][] f27207f = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: g  reason: collision with root package name */
    private static final int f27208g = 7973;

    /* renamed from: h  reason: collision with root package name */
    private static final int f27209h = 1335;

    /* renamed from: i  reason: collision with root package name */
    private static final int f27210i = 21522;

    private MatrixUtil() {
    }

    public static void a(BitVector bitVector, ErrorCorrectionLevel errorCorrectionLevel, int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        c(byteMatrix);
        d(i2, byteMatrix);
        l(errorCorrectionLevel, i3, byteMatrix);
        t(i2, byteMatrix);
        f(bitVector, i3, byteMatrix);
    }

    public static int b(int i2, int i3) {
        int n2 = n(i3);
        int i4 = i2 << (n2 - 1);
        while (n(i4) >= n2) {
            i4 ^= i3 << (n(i4) - n2);
        }
        return i4;
    }

    public static void c(ByteMatrix byteMatrix) {
        byteMatrix.a((byte) -1);
    }

    public static void d(int i2, ByteMatrix byteMatrix) throws WriterException {
        j(byteMatrix);
        e(byteMatrix);
        s(i2, byteMatrix);
        k(byteMatrix);
    }

    private static void e(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.b(8, byteMatrix.d() - 8) != 0) {
            byteMatrix.g(8, byteMatrix.d() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    public static void f(BitVector bitVector, int i2, ByteMatrix byteMatrix) throws WriterException {
        int i3;
        int e2 = byteMatrix.e() - 1;
        int d2 = byteMatrix.d() - 1;
        int i4 = 0;
        int i5 = -1;
        while (e2 > 0) {
            if (e2 == 6) {
                e2--;
            }
            while (d2 >= 0 && d2 < byteMatrix.d()) {
                for (int i6 = 0; i6 < 2; i6++) {
                    int i7 = e2 - i6;
                    if (o(byteMatrix.b(i7, d2))) {
                        if (i4 < bitVector.g()) {
                            i3 = bitVector.e(i4);
                            i4++;
                        } else {
                            i3 = 0;
                        }
                        if (i2 != -1 && MaskUtil.f(i2, i7, d2)) {
                            i3 ^= 1;
                        }
                        byteMatrix.g(i7, d2, i3);
                    }
                }
                d2 += i5;
            }
            i5 = -i5;
            d2 += i5;
            e2 -= 2;
        }
        if (i4 != bitVector.g()) {
            throw new WriterException("Not all bits consumed: " + i4 + '/' + bitVector.g());
        }
    }

    private static void g(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = f27203b;
        if (iArr[0].length == 8 && iArr.length == 1) {
            int i4 = 0;
            while (i4 < 8) {
                int i5 = i2 + i4;
                if (o(byteMatrix.b(i5, i3))) {
                    byteMatrix.g(i5, i3, f27203b[0][i4]);
                    i4++;
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad horizontal separation pattern");
    }

    private static void h(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = f27205d;
        if (iArr[0].length == 5 && iArr.length == 5) {
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = 0;
                while (i5 < 5) {
                    int i6 = i2 + i5;
                    int i7 = i3 + i4;
                    if (o(byteMatrix.b(i6, i7))) {
                        byteMatrix.g(i6, i7, f27205d[i4][i5]);
                        i5++;
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position adjustment");
    }

    private static void i(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = f27202a;
        if (iArr[0].length == 7 && iArr.length == 7) {
            for (int i4 = 0; i4 < 7; i4++) {
                int i5 = 0;
                while (i5 < 7) {
                    int i6 = i2 + i5;
                    int i7 = i3 + i4;
                    if (o(byteMatrix.b(i6, i7))) {
                        byteMatrix.g(i6, i7, f27202a[i4][i5]);
                        i5++;
                    } else {
                        throw new WriterException();
                    }
                }
            }
            return;
        }
        throw new WriterException("Bad position detection pattern");
    }

    private static void j(ByteMatrix byteMatrix) throws WriterException {
        int length = f27202a[0].length;
        i(0, 0, byteMatrix);
        i(byteMatrix.e() - length, 0, byteMatrix);
        i(0, byteMatrix.e() - length, byteMatrix);
        int length2 = f27203b[0].length;
        int i2 = length2 - 1;
        g(0, i2, byteMatrix);
        g(byteMatrix.e() - length2, i2, byteMatrix);
        g(0, byteMatrix.e() - length2, byteMatrix);
        int length3 = f27204c.length;
        m(length3, 0, byteMatrix);
        m((byteMatrix.d() - length3) - 1, 0, byteMatrix);
        m(length3, byteMatrix.d() - length3, byteMatrix);
    }

    private static void k(ByteMatrix byteMatrix) throws WriterException {
        int i2 = 8;
        while (i2 < byteMatrix.e() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (p(byteMatrix.b(i2, 6))) {
                if (o(byteMatrix.b(i2, 6))) {
                    byteMatrix.g(i2, 6, i4);
                }
                if (p(byteMatrix.b(6, i2))) {
                    if (o(byteMatrix.b(6, i2))) {
                        byteMatrix.g(6, i2, i4);
                    }
                    i2 = i3;
                } else {
                    throw new WriterException();
                }
            } else {
                throw new WriterException();
            }
        }
    }

    public static void l(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        BitVector bitVector = new BitVector();
        q(errorCorrectionLevel, i2, bitVector);
        for (int i3 = 0; i3 < bitVector.g(); i3++) {
            int e2 = bitVector.e((bitVector.g() - 1) - i3);
            int[] iArr = f27207f[i3];
            byteMatrix.g(iArr[0], iArr[1], e2);
            if (i3 < 8) {
                byteMatrix.g((byteMatrix.e() - i3) - 1, 8, e2);
            } else {
                byteMatrix.g(8, (byteMatrix.d() - 7) + (i3 - 8), e2);
            }
        }
    }

    private static void m(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        int[][] iArr = f27204c;
        if (iArr[0].length == 1 && iArr.length == 7) {
            int i4 = 0;
            while (i4 < 7) {
                int i5 = i3 + i4;
                if (o(byteMatrix.b(i2, i5))) {
                    byteMatrix.g(i2, i5, f27204c[i4][0]);
                    i4++;
                } else {
                    throw new WriterException();
                }
            }
            return;
        }
        throw new WriterException("Bad vertical separation pattern");
    }

    public static int n(int i2) {
        int i3 = 0;
        while (i2 != 0) {
            i2 >>>= 1;
            i3++;
        }
        return i3;
    }

    private static boolean o(int i2) {
        return i2 == -1;
    }

    private static boolean p(int i2) {
        return i2 == -1 || i2 == 0 || i2 == 1;
    }

    public static void q(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitVector bitVector) throws WriterException {
        if (QRCode.m(i2)) {
            int b2 = (errorCorrectionLevel.b() << 3) | i2;
            bitVector.c(b2, 5);
            bitVector.c(b(b2, f27209h), 10);
            BitVector bitVector2 = new BitVector();
            bitVector2.c(f27210i, 15);
            bitVector.i(bitVector2);
            if (bitVector.g() != 15) {
                throw new WriterException("should not happen but we got: " + bitVector.g());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    public static void r(int i2, BitVector bitVector) throws WriterException {
        bitVector.c(i2, 6);
        bitVector.c(b(i2, f27208g), 12);
        if (bitVector.g() != 18) {
            throw new WriterException("should not happen but we got: " + bitVector.g());
        }
    }

    private static void s(int i2, ByteMatrix byteMatrix) throws WriterException {
        if (i2 >= 2) {
            int[] iArr = f27206e[i2 - 1];
            for (int i3 = 0; i3 < r0; i3++) {
                for (int i4 : iArr) {
                    int i5 = iArr[i3];
                    if (!(i4 == -1 || i5 == -1 || !o(byteMatrix.b(i4, i5)))) {
                        h(i4 - 2, i5 - 2, byteMatrix);
                    }
                }
            }
        }
    }

    public static void t(int i2, ByteMatrix byteMatrix) throws WriterException {
        if (i2 >= 7) {
            BitVector bitVector = new BitVector();
            r(i2, bitVector);
            int i3 = 17;
            for (int i4 = 0; i4 < 6; i4++) {
                for (int i5 = 0; i5 < 3; i5++) {
                    int e2 = bitVector.e(i3);
                    i3--;
                    byteMatrix.g(i4, (byteMatrix.d() - 11) + i5, e2);
                    byteMatrix.g((byteMatrix.d() - 11) + i5, i4, e2);
                }
            }
        }
    }
}
