package com.itextpdf.text.pdf;

import com.itextpdf.text.pdf.crypto.AESCipher;
import com.itextpdf.text.pdf.crypto.ARCFOUREncryption;

public class StandardDecryption {

    /* renamed from: h  reason: collision with root package name */
    private static final int f26404h = 4;

    /* renamed from: i  reason: collision with root package name */
    private static final int f26405i = 5;

    /* renamed from: a  reason: collision with root package name */
    protected ARCFOUREncryption f26406a;

    /* renamed from: b  reason: collision with root package name */
    protected AESCipher f26407b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f26408c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26409d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26410e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f26411f = new byte[16];

    /* renamed from: g  reason: collision with root package name */
    private int f26412g;

    public StandardDecryption(byte[] bArr, int i2, int i3, int i4) {
        boolean z = i4 == 4 || i4 == 5;
        this.f26409d = z;
        if (z) {
            byte[] bArr2 = new byte[i3];
            this.f26408c = bArr2;
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return;
        }
        ARCFOUREncryption aRCFOUREncryption = new ARCFOUREncryption();
        this.f26406a = aRCFOUREncryption;
        aRCFOUREncryption.f(bArr, i2, i3);
    }

    public byte[] a() {
        if (this.f26409d) {
            return this.f26407b.a();
        }
        return null;
    }

    public byte[] b(byte[] bArr, int i2, int i3) {
        if (!this.f26409d) {
            byte[] bArr2 = new byte[i3];
            this.f26406a.c(bArr, i2, i3, bArr2, 0);
            return bArr2;
        } else if (this.f26410e) {
            return this.f26407b.b(bArr, i2, i3);
        } else {
            int min = Math.min(this.f26411f.length - this.f26412g, i3);
            System.arraycopy(bArr, i2, this.f26411f, this.f26412g, min);
            int i4 = i2 + min;
            int i5 = i3 - min;
            int i6 = this.f26412g + min;
            this.f26412g = i6;
            byte[] bArr3 = this.f26411f;
            if (i6 != bArr3.length) {
                return null;
            }
            AESCipher aESCipher = new AESCipher(false, this.f26408c, bArr3);
            this.f26407b = aESCipher;
            this.f26410e = true;
            if (i5 > 0) {
                return aESCipher.b(bArr, i4, i5);
            }
            return null;
        }
    }
}
