package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.Decrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;

class NoCipherInputStream extends CipherInputStream {

    static class NoDecrypter implements Decrypter {
        NoDecrypter() {
        }

        public int a(byte[] bArr, int i2, int i3) {
            return i3;
        }
    }

    public NoCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException {
        super(zipEntryInputStream, localFileHeader, cArr);
    }

    /* access modifiers changed from: protected */
    public Decrypter i(LocalFileHeader localFileHeader, char[] cArr) {
        return new NoDecrypter();
    }
}
