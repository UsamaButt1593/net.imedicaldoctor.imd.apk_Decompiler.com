package com.itextpdf.text.pdf.codec;

import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;

public class PngWriter {

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f26640b = {-119, 80, 78, 71, 13, 10, Ascii.D, 10};

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f26641c = DocWriter.E(PngImage.M);

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f26642d = DocWriter.E(PngImage.N);

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f26643e = DocWriter.E(PngImage.O);

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f26644f = DocWriter.E(PngImage.P);

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f26645g = DocWriter.E(PngImage.V);

    /* renamed from: h  reason: collision with root package name */
    private static int[] f26646h;

    /* renamed from: a  reason: collision with root package name */
    private OutputStream f26647a;

    public PngWriter(OutputStream outputStream) throws IOException {
        this.f26647a = outputStream;
        outputStream.write(f26640b);
    }

    private static int a(byte[] bArr) {
        return ~f(-1, bArr, 0, bArr.length);
    }

    private static int b(byte[] bArr, int i2, int i3) {
        return ~f(-1, bArr, i2, i3);
    }

    private static void c() {
        if (f26646h == null) {
            int[] iArr = new int[256];
            for (int i2 = 0; i2 < 256; i2++) {
                int i3 = i2;
                for (int i4 = 0; i4 < 8; i4++) {
                    int i5 = i3 & 1;
                    i3 >>>= 1;
                    if (i5 != 0) {
                        i3 ^= -306674912;
                    }
                }
                iArr[i2] = i3;
            }
            f26646h = iArr;
        }
    }

    public static void e(int i2, OutputStream outputStream) throws IOException {
        outputStream.write((byte) (i2 >> 24));
        outputStream.write((byte) (i2 >> 16));
        outputStream.write((byte) (i2 >> 8));
        outputStream.write((byte) i2);
    }

    private static int f(int i2, byte[] bArr, int i3, int i4) {
        if (f26646h == null) {
            c();
        }
        for (int i5 = 0; i5 < i4; i5++) {
            i2 = (i2 >>> 8) ^ f26646h[(bArr[i5 + i3] ^ i2) & 255];
        }
        return i2;
    }

    public void d(int i2) throws IOException {
        e(i2, this.f26647a);
    }

    public void g(byte[] bArr, byte[] bArr2) throws IOException {
        d(bArr2.length);
        this.f26647a.write(bArr, 0, 4);
        this.f26647a.write(bArr2);
        d(~f(f(-1, bArr, 0, bArr.length), bArr2, 0, bArr2.length));
    }

    public void h(byte[] bArr, int i2) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        int i3 = 0;
        while (i3 < bArr.length - i2) {
            deflaterOutputStream.write(0);
            deflaterOutputStream.write(bArr, i3, i2);
            i3 += i2;
        }
        int length = bArr.length - i3;
        if (length > 0) {
            deflaterOutputStream.write(0);
            deflaterOutputStream.write(bArr, i3, length);
        }
        deflaterOutputStream.close();
        g(f26643e, byteArrayOutputStream.toByteArray());
    }

    public void i() throws IOException {
        g(f26644f, new byte[0]);
    }

    public void j(int i2, int i3, int i4, int i5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        e(i2, byteArrayOutputStream);
        e(i3, byteArrayOutputStream);
        byteArrayOutputStream.write(i4);
        byteArrayOutputStream.write(i5);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        g(f26641c, byteArrayOutputStream.toByteArray());
    }

    public void k(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(73);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(67);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
        deflaterOutputStream.write(bArr);
        deflaterOutputStream.close();
        g(f26645g, byteArrayOutputStream.toByteArray());
    }

    public void l(byte[] bArr) throws IOException {
        g(f26642d, bArr);
    }
}
