package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.AESEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

class AesCipherOutputStream extends CipherOutputStream<AESEncrypter> {
    private byte[] Y = new byte[16];
    private int Z = 0;

    public AesCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(zipEntryOutputStream, zipParameters, cArr);
    }

    private void i(AESEncrypter aESEncrypter) throws IOException {
        f(aESEncrypter.f());
        f(aESEncrypter.d());
    }

    public void b() throws IOException {
        int i2 = this.Z;
        if (i2 != 0) {
            super.write(this.Y, 0, i2);
            this.Z = 0;
        }
        f(((AESEncrypter) c()).e());
        super.b();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public AESEncrypter e(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        AESEncrypter aESEncrypter = new AESEncrypter(cArr, zipParameters.a());
        i(aESEncrypter);
        return aESEncrypter;
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        int i4;
        int i5 = this.Z;
        if (i3 >= 16 - i5) {
            System.arraycopy(bArr, i2, this.Y, i5, 16 - i5);
            byte[] bArr2 = this.Y;
            super.write(bArr2, 0, bArr2.length);
            int i6 = 16 - this.Z;
            int i7 = i3 - i6;
            this.Z = 0;
            if (!(i7 == 0 || (i4 = i7 % 16) == 0)) {
                System.arraycopy(bArr, (i7 + i6) - i4, this.Y, 0, i4);
                this.Z = i4;
                i7 -= i4;
            }
            super.write(bArr, i6, i7);
            return;
        }
        System.arraycopy(bArr, i2, this.Y, i5, i3);
        this.Z += i3;
    }
}
