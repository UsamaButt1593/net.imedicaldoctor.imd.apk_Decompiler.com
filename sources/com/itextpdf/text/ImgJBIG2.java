package com.itextpdf.text;

import java.net.URL;
import java.security.MessageDigest;

public class ImgJBIG2 extends Image {
    private byte[] M4;
    private byte[] N4;

    public ImgJBIG2() {
        super((Image) null);
    }

    public byte[] y2() {
        return this.M4;
    }

    public byte[] z2() {
        return this.N4;
    }

    public ImgJBIG2(int i2, int i3, byte[] bArr, byte[] bArr2) {
        super((URL) null);
        this.s3 = 36;
        this.Y3 = 9;
        float f2 = (float) i3;
        this.E3 = f2;
        z0(f2);
        float f3 = (float) i2;
        this.D3 = f3;
        x0(f3);
        this.v3 = 1;
        this.e4 = 1;
        this.u3 = bArr;
        this.B3 = a0();
        this.C3 = N();
        if (bArr2 != null) {
            this.M4 = bArr2;
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(this.M4);
                this.N4 = instance.digest();
            } catch (Exception unused) {
            }
        }
    }

    ImgJBIG2(Image image) {
        super(image);
    }
}
