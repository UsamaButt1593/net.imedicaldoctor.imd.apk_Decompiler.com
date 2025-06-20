package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

abstract class CipherInputStream<T extends Decrypter> extends InputStream {
    private T X;
    private LocalFileHeader X2;
    private byte[] Y;
    private byte[] Z = new byte[1];
    private ZipEntryInputStream s;

    public CipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException {
        this.s = zipEntryInputStream;
        this.X = i(localFileHeader, cArr);
        this.X2 = localFileHeader;
        if (Zip4jUtil.g(localFileHeader).equals(CompressionMethod.DEFLATE)) {
            this.Y = new byte[4096];
        }
    }

    private void b(byte[] bArr, int i2) {
        byte[] bArr2 = this.Y;
        if (bArr2 != null) {
            System.arraycopy(bArr, 0, bArr2, 0, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void c(InputStream inputStream) throws IOException {
    }

    public void close() throws IOException {
        this.s.close();
    }

    public T d() {
        return this.X;
    }

    public byte[] e() {
        return this.Y;
    }

    public LocalFileHeader f() {
        return this.X2;
    }

    /* access modifiers changed from: protected */
    public long h() {
        return this.s.b();
    }

    /* access modifiers changed from: protected */
    public abstract T i(LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException;

    /* access modifiers changed from: protected */
    public int k(byte[] bArr) throws IOException {
        return this.s.c(bArr);
    }

    public int read() throws IOException {
        if (read(this.Z) == -1) {
            return -1;
        }
        return this.Z[0] & 255;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        int j2 = Zip4jUtil.j(this.s, bArr, i2, i3);
        if (j2 > 0) {
            b(bArr, j2);
            this.X.a(bArr, i2, j2);
        }
        return j2;
    }
}
