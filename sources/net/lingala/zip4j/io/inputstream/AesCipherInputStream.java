package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import net.lingala.zip4j.crypto.AESDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.util.Zip4jUtil;

class AesCipherInputStream extends CipherInputStream<AESDecrypter> {
    private byte[] Y2 = new byte[1];
    private byte[] Z2 = new byte[16];
    private int a3 = 0;
    private int b3 = 0;
    private int c3 = 0;
    private int d3 = 0;
    private int e3 = 0;
    private int f3 = 0;
    private int g3 = 0;

    public AesCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        super(zipEntryInputStream, localFileHeader, cArr);
    }

    private void n(byte[] bArr, int i2) {
        int i3 = this.c3;
        int i4 = this.b3;
        if (i3 >= i4) {
            i3 = i4;
        }
        this.f3 = i3;
        System.arraycopy(this.Z2, this.a3, bArr, i2, i3);
        s(this.f3);
        p(this.f3);
        int i5 = this.e3;
        int i6 = this.f3;
        this.e3 = i5 + i6;
        this.c3 -= i6;
        this.d3 += i6;
    }

    private void p(int i2) {
        int i3 = this.b3 - i2;
        this.b3 = i3;
        if (i3 <= 0) {
            this.b3 = 0;
        }
    }

    private byte[] q() throws IOException {
        byte[] bArr = new byte[2];
        k(bArr);
        return bArr;
    }

    private byte[] r(LocalFileHeader localFileHeader) throws IOException {
        if (localFileHeader.c() != null) {
            byte[] bArr = new byte[localFileHeader.c().c().f()];
            k(bArr);
            return bArr;
        }
        throw new IOException("invalid aes extra data record");
    }

    private void s(int i2) {
        int i3 = this.a3 + i2;
        this.a3 = i3;
        if (i3 >= 15) {
            this.a3 = 15;
        }
    }

    private void v(byte[] bArr) throws IOException {
        if (!f().s() || !CompressionMethod.DEFLATE.equals(Zip4jUtil.g(f()))) {
            byte[] bArr2 = new byte[10];
            System.arraycopy(((AESDecrypter) d()).b(), 0, bArr2, 0, 10);
            if (!Arrays.equals(bArr, bArr2)) {
                throw new IOException("Reached end of data for this entry, but aes verification failed");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c(InputStream inputStream) throws IOException {
        v(u(inputStream));
    }

    public int read() throws IOException {
        if (read(this.Y2) == -1) {
            return -1;
        }
        return this.Y2[0];
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public AESDecrypter i(LocalFileHeader localFileHeader, char[] cArr) throws IOException {
        return new AESDecrypter(localFileHeader.c(), cArr, r(localFileHeader), q());
    }

    /* access modifiers changed from: protected */
    public byte[] u(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[10];
        if (Zip4jUtil.i(inputStream, bArr) == 10) {
            return bArr;
        }
        throw new ZipException("Invalid AES Mac bytes. Could not read sufficient data");
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i2, int i3) throws IOException {
        this.c3 = i3;
        this.d3 = i2;
        this.e3 = 0;
        if (this.b3 != 0) {
            n(bArr, i2);
            int i4 = this.e3;
            if (i4 == i3) {
                return i4;
            }
        }
        if (this.c3 < 16) {
            byte[] bArr2 = this.Z2;
            int read = super.read(bArr2, 0, bArr2.length);
            this.g3 = read;
            this.a3 = 0;
            if (read == -1) {
                this.b3 = 0;
                int i5 = this.e3;
                if (i5 > 0) {
                    return i5;
                }
                return -1;
            }
            this.b3 = read;
            n(bArr, this.d3);
            int i6 = this.e3;
            if (i6 == i3) {
                return i6;
            }
        }
        int i7 = this.d3;
        int i8 = this.c3;
        int read2 = super.read(bArr, i7, i8 - (i8 % 16));
        if (read2 != -1) {
            return read2 + this.e3;
        }
        int i9 = this.e3;
        if (i9 > 0) {
            return i9;
        }
        return -1;
    }
}
