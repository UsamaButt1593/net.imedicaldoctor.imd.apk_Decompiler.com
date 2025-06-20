package net.lingala.zip4j.io.outputstream;

import java.io.IOException;
import java.io.OutputStream;
import net.lingala.zip4j.crypto.Encrypter;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;

abstract class CipherOutputStream<T extends Encrypter> extends OutputStream {
    private T X;
    private ZipEntryOutputStream s;

    public CipherOutputStream(ZipEntryOutputStream zipEntryOutputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException {
        this.s = zipEntryOutputStream;
        this.X = e(zipEntryOutputStream, zipParameters, cArr);
    }

    public void b() throws IOException {
        this.s.b();
    }

    /* access modifiers changed from: protected */
    public T c() {
        return this.X;
    }

    public void close() throws IOException {
        this.s.close();
    }

    public long d() {
        return this.s.c();
    }

    /* access modifiers changed from: protected */
    public abstract T e(OutputStream outputStream, ZipParameters zipParameters, char[] cArr) throws IOException, ZipException;

    public void f(byte[] bArr) throws IOException {
        this.s.write(bArr);
    }

    public void write(int i2) throws IOException {
        this.s.write(i2);
    }

    public void write(byte[] bArr) throws IOException {
        this.s.write(bArr);
    }

    public void write(byte[] bArr, int i2, int i3) throws IOException {
        this.X.a(bArr, i2, i3);
        this.s.write(bArr, i2, i3);
    }
}
