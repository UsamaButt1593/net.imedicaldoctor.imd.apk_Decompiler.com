package net.lingala.zip4j.io.inputstream;

import java.io.IOException;
import net.lingala.zip4j.crypto.StandardDecrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.LocalFileHeader;

class ZipStandardCipherInputStream extends CipherInputStream<StandardDecrypter> {
    public ZipStandardCipherInputStream(ZipEntryInputStream zipEntryInputStream, LocalFileHeader localFileHeader, char[] cArr) throws IOException, ZipException {
        super(zipEntryInputStream, localFileHeader, cArr);
    }

    private byte[] n() throws IOException {
        byte[] bArr = new byte[12];
        k(bArr);
        return bArr;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public StandardDecrypter i(LocalFileHeader localFileHeader, char[] cArr) throws ZipException, IOException {
        return new StandardDecrypter(cArr, localFileHeader.g(), n());
    }
}
