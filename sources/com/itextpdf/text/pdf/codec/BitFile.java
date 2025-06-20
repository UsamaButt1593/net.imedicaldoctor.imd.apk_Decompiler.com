package com.itextpdf.text.pdf.codec;

import java.io.IOException;
import java.io.OutputStream;

public class BitFile {

    /* renamed from: a  reason: collision with root package name */
    OutputStream f26536a;

    /* renamed from: b  reason: collision with root package name */
    byte[] f26537b = new byte[256];

    /* renamed from: c  reason: collision with root package name */
    int f26538c = 0;

    /* renamed from: d  reason: collision with root package name */
    int f26539d = 8;

    /* renamed from: e  reason: collision with root package name */
    boolean f26540e;

    public BitFile(OutputStream outputStream, boolean z) {
        this.f26536a = outputStream;
        this.f26540e = z;
    }

    public void a() throws IOException {
        int i2 = this.f26538c + (this.f26539d == 8 ? 0 : 1);
        if (i2 > 0) {
            if (this.f26540e) {
                this.f26536a.write(i2);
            }
            this.f26536a.write(this.f26537b, 0, i2);
            this.f26537b[0] = 0;
            this.f26538c = 0;
            this.f26539d = 8;
        }
    }

    public void b(int i2, int i3) throws IOException {
        do {
            int i4 = this.f26538c;
            if ((i4 == 254 && this.f26539d == 0) || i4 > 254) {
                if (this.f26540e) {
                    this.f26536a.write(255);
                }
                this.f26536a.write(this.f26537b, 0, 255);
                this.f26537b[0] = 0;
                this.f26538c = 0;
                this.f26539d = 8;
            }
            int i5 = this.f26539d;
            if (i3 <= i5) {
                if (this.f26540e) {
                    byte[] bArr = this.f26537b;
                    int i6 = this.f26538c;
                    bArr[i6] = (byte) (((i2 & ((1 << i3) - 1)) << (8 - i5)) | bArr[i6]);
                } else {
                    byte[] bArr2 = this.f26537b;
                    int i7 = this.f26538c;
                    bArr2[i7] = (byte) (((i2 & ((1 << i3) - 1)) << (i5 - i3)) | bArr2[i7]);
                }
                this.f26539d = i5 - i3;
                i3 = 0;
                continue;
            } else {
                if (this.f26540e) {
                    byte[] bArr3 = this.f26537b;
                    int i8 = this.f26538c;
                    bArr3[i8] = (byte) (bArr3[i8] | ((((1 << i5) - 1) & i2) << (8 - i5)));
                    i2 >>= i5;
                    i3 -= i5;
                    int i9 = i8 + 1;
                    this.f26538c = i9;
                    bArr3[i9] = 0;
                } else {
                    byte[] bArr4 = this.f26537b;
                    int i10 = this.f26538c;
                    bArr4[i10] = (byte) (((i2 >>> (i3 - i5)) & ((1 << i5) - 1)) | bArr4[i10]);
                    i3 -= i5;
                    int i11 = i10 + 1;
                    this.f26538c = i11;
                    bArr4[i11] = 0;
                }
                this.f26539d = 8;
                continue;
            }
        } while (i3 != 0);
    }
}
