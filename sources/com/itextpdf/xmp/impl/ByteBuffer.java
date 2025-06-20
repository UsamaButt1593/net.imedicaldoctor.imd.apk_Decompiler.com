package com.itextpdf.xmp.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteBuffer {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f27743a;

    /* renamed from: b  reason: collision with root package name */
    private int f27744b;

    /* renamed from: c  reason: collision with root package name */
    private String f27745c;

    public ByteBuffer(int i2) {
        this.f27745c = null;
        this.f27743a = new byte[i2];
        this.f27744b = 0;
    }

    private void g(int i2) {
        byte[] bArr = this.f27743a;
        if (i2 > bArr.length) {
            byte[] bArr2 = new byte[(bArr.length * 2)];
            this.f27743a = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public void a(byte b2) {
        g(this.f27744b + 1);
        byte[] bArr = this.f27743a;
        int i2 = this.f27744b;
        this.f27744b = i2 + 1;
        bArr[i2] = b2;
    }

    public void b(ByteBuffer byteBuffer) {
        d(byteBuffer.f27743a, 0, byteBuffer.f27744b);
    }

    public void c(byte[] bArr) {
        d(bArr, 0, bArr.length);
    }

    public void d(byte[] bArr, int i2, int i3) {
        g(this.f27744b + i3);
        System.arraycopy(bArr, i2, this.f27743a, this.f27744b, i3);
        this.f27744b += i3;
    }

    public byte e(int i2) {
        if (i2 < this.f27744b) {
            return this.f27743a[i2];
        }
        throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
    }

    public int f(int i2) {
        if (i2 < this.f27744b) {
            return this.f27743a[i2] & 255;
        }
        throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
    }

    public InputStream h() {
        return new ByteArrayInputStream(this.f27743a, 0, this.f27744b);
    }

    public String i() {
        String str;
        if (this.f27745c == null) {
            int i2 = this.f27744b;
            if (i2 >= 2) {
                byte[] bArr = this.f27743a;
                byte b2 = bArr[0];
                if (b2 == 0) {
                    if (i2 < 4 || bArr[1] != 0) {
                        str = "UTF-16BE";
                    } else {
                        if ((bArr[2] & 255) == 254 && (bArr[3] & 255) == 255) {
                            str = "UTF-32BE";
                        }
                        this.f27745c = "UTF-32";
                    }
                } else if ((b2 & 255) < 128) {
                    if (bArr[1] == 0) {
                        str = (i2 < 4 || bArr[2] != 0) ? "UTF-16LE" : "UTF-32LE";
                    }
                } else if ((b2 & 255) != 239) {
                    if ((b2 & 255) == 254 || i2 < 4 || bArr[2] != 0) {
                        this.f27745c = "UTF-16";
                    }
                    this.f27745c = "UTF-32";
                }
                this.f27745c = str;
            }
            this.f27745c = "UTF-8";
        }
        return this.f27745c;
    }

    public int j() {
        return this.f27744b;
    }

    public ByteBuffer(InputStream inputStream) throws IOException {
        this.f27745c = null;
        this.f27744b = 0;
        this.f27743a = new byte[16384];
        while (true) {
            int read = inputStream.read(this.f27743a, this.f27744b, 16384);
            if (read > 0) {
                int i2 = this.f27744b + read;
                this.f27744b = i2;
                if (read == 16384) {
                    g(i2 + 16384);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public ByteBuffer(byte[] bArr) {
        this.f27745c = null;
        this.f27743a = bArr;
        this.f27744b = bArr.length;
    }

    public ByteBuffer(byte[] bArr, int i2) {
        this.f27745c = null;
        if (i2 <= bArr.length) {
            this.f27743a = bArr;
            this.f27744b = i2;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Valid length exceeds the buffer length.");
    }

    public ByteBuffer(byte[] bArr, int i2, int i3) {
        this.f27745c = null;
        if (i3 <= bArr.length - i2) {
            byte[] bArr2 = new byte[i3];
            this.f27743a = bArr2;
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            this.f27744b = i3;
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Valid length exceeds the buffer length.");
    }
}
