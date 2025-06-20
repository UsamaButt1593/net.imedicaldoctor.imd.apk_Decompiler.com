package com.itextpdf.text;

import com.itextpdf.text.error_messages.MessageLocalization;
import java.net.URL;

public class ImgRaw extends Image {
    public ImgRaw(int i2, int i3, int i4, int i5, byte[] bArr) throws BadElementException {
        super((URL) null);
        this.s3 = 34;
        float f2 = (float) i3;
        this.E3 = f2;
        z0(f2);
        float f3 = (float) i2;
        this.D3 = f3;
        x0(f3);
        if (i4 != 1 && i4 != 3 && i4 != 4) {
            throw new BadElementException(MessageLocalization.b("components.must.be.1.3.or.4", new Object[0]));
        } else if (i5 == 1 || i5 == 2 || i5 == 4 || i5 == 8) {
            this.e4 = i4;
            this.v3 = i5;
            this.u3 = bArr;
            this.B3 = a0();
            this.C3 = N();
        } else {
            throw new BadElementException(MessageLocalization.b("bits.per.component.must.be.1.2.4.or.8", new Object[0]));
        }
    }

    ImgRaw(Image image) {
        super(image);
    }
}
