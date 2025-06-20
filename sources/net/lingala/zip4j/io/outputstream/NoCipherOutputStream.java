package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

class NoCipherOutputStream extends CipherOutputStream<NoEncrypter> {

    static class NoEncrypter implements Encrypter {
        NoEncrypter() {
        }

        public int a(byte[] bArr, int i2, int i3) {
            return i3;
        }

        public int b(byte[] bArr) {
            return a(bArr, 0, bArr.length);
        }
    }

    public NoCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(zipEntryOutputStream, zipParameters, cArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public NoEncrypter e(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) {
        return new NoEncrypter();
    }
}
