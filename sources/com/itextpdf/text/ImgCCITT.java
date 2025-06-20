package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.codec.TIFFFaxDecoder;
import java.net.URL;

public class ImgCCITT extends Image {
    public ImgCCITT(int i2, int i3, boolean z, int i4, int i5, byte[] bArr) throws BadElementException {
        super((URL) null);
        if (i4 == 256 || i4 == 257 || i4 == 258) {
            if (z) {
                TIFFFaxDecoder.l(bArr);
            }
            this.s3 = 34;
            float f2 = (float) i3;
            this.E3 = f2;
            z0(f2);
            float f3 = (float) i2;
            this.D3 = f3;
            x0(f3);
            this.e4 = i5;
            this.v3 = i4;
            this.u3 = bArr;
            this.B3 = a0();
            this.C3 = N();
            return;
        }
        throw new BadElementException(MessageLocalization.b("the.ccitt.compression.type.must.be.ccittg4.ccittg3.1d.or.ccittg3.2d", new Object[0]));
    }

    ImgCCITT(Image image) {
        super(image);
    }
}
