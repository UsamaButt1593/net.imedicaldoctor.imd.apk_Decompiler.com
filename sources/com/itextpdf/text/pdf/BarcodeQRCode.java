package com.itextpdf.text.pdf;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.codec.CCITTG4Encoder;
import com.itextpdf.text.pdf.qrcode.ByteMatrix;
import com.itextpdf.text.pdf.qrcode.EncodeHintType;
import com.itextpdf.text.pdf.qrcode.QRCodeWriter;
import com.itextpdf.text.pdf.qrcode.WriterException;
import java.util.Map;

public class BarcodeQRCode {

    /* renamed from: a  reason: collision with root package name */
    ByteMatrix f25923a;

    public BarcodeQRCode(String str, int i2, int i3, Map<EncodeHintType, Object> map) {
        try {
            this.f25923a = new QRCodeWriter().b(str, i2, i3, map);
        } catch (WriterException e2) {
            throw new ExceptionConverter(e2);
        }
    }

    private byte[] a() {
        int e2 = this.f25923a.e();
        int d2 = this.f25923a.d();
        int i2 = (e2 + 7) / 8;
        byte[] bArr = new byte[(i2 * d2)];
        byte[][] c2 = this.f25923a.c();
        for (int i3 = 0; i3 < d2; i3++) {
            byte[] bArr2 = c2[i3];
            for (int i4 = 0; i4 < e2; i4++) {
                if (bArr2[i4] != 0) {
                    int i5 = (i2 * i3) + (i4 / 8);
                    bArr[i5] = (byte) (bArr[i5] | ((byte) (128 >> (i4 % 8))));
                }
            }
        }
        return bArr;
    }

    public Image b() throws BadElementException {
        return Image.W0(this.f25923a.e(), this.f25923a.d(), false, 256, 1, CCITTG4Encoder.d(a(), this.f25923a.e(), this.f25923a.d()), (int[]) null);
    }
}
