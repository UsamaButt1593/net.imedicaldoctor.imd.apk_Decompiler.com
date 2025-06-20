package net.lingala.zip4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import net.lingala.zip4j.exception.ZipException;

public class RawIO {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f30721a = new byte[2];

    /* renamed from: b  reason: collision with root package name */
    private byte[] f30722b = new byte[4];

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30723c = new byte[8];

    private void a(InputStream inputStream, byte[] bArr, int i2) throws IOException {
        if (Zip4jUtil.j(inputStream, bArr, 0, i2) != i2) {
            throw new ZipException("Could not fill buffer");
        }
    }

    private void n(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = 0;
        }
    }

    public int b(InputStream inputStream) throws IOException {
        a(inputStream, this.f30722b, 4);
        return d(this.f30722b);
    }

    public int c(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f30722b);
        return d(this.f30722b);
    }

    public int d(byte[] bArr) {
        return e(bArr, 0);
    }

    public int e(byte[] bArr, int i2) {
        return ((((bArr[i2 + 3] & 255) << 8) | (bArr[i2 + 2] & 255)) << 16) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
    }

    public long f(InputStream inputStream) throws IOException {
        byte[] bArr = this.f30723c;
        a(inputStream, bArr, bArr.length);
        return j(this.f30723c, 0);
    }

    public long g(InputStream inputStream, int i2) throws IOException {
        n(this.f30723c);
        a(inputStream, this.f30723c, i2);
        return j(this.f30723c, 0);
    }

    public long h(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f30723c);
        return j(this.f30723c, 0);
    }

    public long i(RandomAccessFile randomAccessFile, int i2) throws IOException {
        n(this.f30723c);
        randomAccessFile.readFully(this.f30723c, 0, i2);
        return j(this.f30723c, 0);
    }

    public long j(byte[] bArr, int i2) {
        if (bArr.length - i2 < 8) {
            n(this.f30723c);
        }
        System.arraycopy(bArr, i2, this.f30723c, 0, bArr.length < 8 ? bArr.length - i2 : 8);
        byte[] bArr2 = this.f30723c;
        return ((long) (bArr2[0] & 255)) | (((((((((((((((long) (bArr2[7] & 255)) << 8) | ((long) (bArr2[6] & 255))) << 8) | ((long) (bArr2[5] & 255))) << 8) | ((long) (bArr2[4] & 255))) << 8) | ((long) (bArr2[3] & 255))) << 8) | ((long) (bArr2[2] & 255))) << 8) | ((long) (bArr2[1] & 255))) << 8);
    }

    public int k(InputStream inputStream) throws IOException {
        byte[] bArr = this.f30721a;
        a(inputStream, bArr, bArr.length);
        return m(this.f30721a, 0);
    }

    public int l(RandomAccessFile randomAccessFile) throws IOException {
        randomAccessFile.readFully(this.f30721a);
        return m(this.f30721a, 0);
    }

    public int m(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & 255) << 8) | (bArr[i2] & 255);
    }

    public void o(OutputStream outputStream, int i2) throws IOException {
        p(this.f30722b, 0, i2);
        outputStream.write(this.f30722b);
    }

    public void p(byte[] bArr, int i2, int i3) {
        bArr[i2 + 3] = (byte) (i3 >>> 24);
        bArr[i2 + 2] = (byte) (i3 >>> 16);
        bArr[i2 + 1] = (byte) (i3 >>> 8);
        bArr[i2] = (byte) (i3 & 255);
    }

    public void q(OutputStream outputStream, long j2) throws IOException {
        r(this.f30723c, 0, j2);
        outputStream.write(this.f30723c);
    }

    public void r(byte[] bArr, int i2, long j2) {
        bArr[i2 + 7] = (byte) ((int) (j2 >>> 56));
        bArr[i2 + 6] = (byte) ((int) (j2 >>> 48));
        bArr[i2 + 5] = (byte) ((int) (j2 >>> 40));
        bArr[i2 + 4] = (byte) ((int) (j2 >>> 32));
        bArr[i2 + 3] = (byte) ((int) (j2 >>> 24));
        bArr[i2 + 2] = (byte) ((int) (j2 >>> 16));
        bArr[i2 + 1] = (byte) ((int) (j2 >>> 8));
        bArr[i2] = (byte) ((int) (j2 & 255));
    }

    public void s(OutputStream outputStream, int i2) throws IOException {
        t(this.f30721a, 0, i2);
        outputStream.write(this.f30721a);
    }

    public void t(byte[] bArr, int i2, int i3) {
        bArr[i2 + 1] = (byte) (i3 >>> 8);
        bArr[i2] = (byte) (i3 & 255);
    }
}
