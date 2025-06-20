package com.itextpdf.text.pdf.qrcode;

import java.util.Map;

public final class QRCodeWriter {

    /* renamed from: a  reason: collision with root package name */
    private static final int f27234a = 4;

    private static ByteMatrix c(QRCode qRCode, int i2, int i3) {
        byte b2;
        ByteMatrix d2 = qRCode.d();
        int e2 = d2.e();
        int d3 = d2.d();
        int i4 = e2 + 8;
        int i5 = d3 + 8;
        int max = Math.max(i2, i4);
        int max2 = Math.max(i3, i5);
        int min = Math.min(max / i4, max2 / i5);
        int i6 = e2 * min;
        int i7 = (max - i6) / 2;
        int i8 = d3 * min;
        int i9 = (max2 - i8) / 2;
        ByteMatrix byteMatrix = new ByteMatrix(max, max2);
        byte[][] c2 = byteMatrix.c();
        byte[] bArr = new byte[max];
        int i10 = 0;
        while (true) {
            b2 = -1;
            if (i10 >= i9) {
                break;
            }
            d(c2[i10], (byte) -1);
            i10++;
        }
        byte[][] c3 = d2.c();
        int i11 = 0;
        while (i11 < d3) {
            for (int i12 = 0; i12 < i7; i12++) {
                bArr[i12] = b2;
            }
            int i13 = i7;
            int i14 = 0;
            while (i14 < e2) {
                byte[][] bArr2 = c3;
                byte b3 = c3[i11][i14] == 1 ? (byte) 0 : -1;
                for (int i15 = 0; i15 < min; i15++) {
                    bArr[i13 + i15] = b3;
                }
                i13 += min;
                i14++;
                c3 = bArr2;
            }
            byte[][] bArr3 = c3;
            for (int i16 = i7 + i6; i16 < max; i16++) {
                bArr[i16] = -1;
            }
            int i17 = (i11 * min) + i9;
            int i18 = 0;
            while (i18 < min) {
                System.arraycopy(bArr, 0, c2[i17 + i18], 0, max);
                i18++;
                i17 = i17;
            }
            i11++;
            c3 = bArr3;
            b2 = -1;
        }
        for (int i19 = i9 + i8; i19 < max2; i19++) {
            d(c2[i19], (byte) -1);
        }
        return byteMatrix;
    }

    private static void d(byte[] bArr, byte b2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = b2;
        }
    }

    public ByteMatrix a(String str, int i2, int i3) throws WriterException {
        return b(str, i2, i3, (Map<EncodeHintType, Object>) null);
    }

    public ByteMatrix b(String str, int i2, int i3, Map<EncodeHintType, Object> map) throws WriterException {
        ErrorCorrectionLevel errorCorrectionLevel;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel2 = ErrorCorrectionLevel.f27181d;
            if (!(map == null || (errorCorrectionLevel = (ErrorCorrectionLevel) map.get(EncodeHintType.f27177a)) == null)) {
                errorCorrectionLevel2 = errorCorrectionLevel;
            }
            QRCode qRCode = new QRCode();
            Encoder.n(str, errorCorrectionLevel2, map, qRCode);
            return c(qRCode, i2, i3);
        }
    }
}
