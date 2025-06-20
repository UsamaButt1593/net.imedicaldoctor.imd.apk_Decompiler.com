package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.StandardEncrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jUtil;

class ZipStandardCipherOutputStream extends CipherOutputStream<StandardEncrypter> {
    public ZipStandardCipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        super(zipEntryOutputStream, zipParameters, cArr);
    }

    private long h(ZipParameters zipParameters) {
        return zipParameters.u() ? (Zip4jUtil.f(zipParameters.l()) & 65535) << 16 : zipParameters.g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public StandardEncrypter e(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        StandardEncrypter standardEncrypter = new StandardEncrypter(cArr, h(zipParameters));
        f(standardEncrypter.e());
        return standardEncrypter;
    }

    public void write(int i2) throws IOException {
        write(new byte[]{(byte) i2});
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        super.write(bArr, i2, i3);
    }
}
