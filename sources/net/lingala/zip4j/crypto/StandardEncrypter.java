package net.lingala.zip4j.crypto;

import java.security.SecureRandom;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardEncrypter implements Encrypter {

    /* renamed from: a  reason: collision with root package name */
    private ZipCryptoEngine f30560a = new ZipCryptoEngine();

    /* renamed from: b  reason: collision with root package name */
    private byte[] f30561b = new byte[12];

    public StandardEncrypter(char[] cArr, long j2) throws ZipException {
        f(cArr, j2);
    }

    private void f(char[] cArr, long j2) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("input password is null or empty, cannot initialize standard encrypter");
        }
        this.f30560a.c(cArr);
        this.f30561b = d(12);
        this.f30560a.c(cArr);
        byte[] bArr = this.f30561b;
        bArr[11] = (byte) ((int) (j2 >>> 24));
        bArr[10] = (byte) ((int) (j2 >>> 16));
        if (bArr.length >= 12) {
            b(bArr);
            return;
        }
        throw new ZipException("invalid header bytes generated, cannot perform standard encryption");
    }

    public int a(byte[] bArr, int i2, int i3) throws ZipException {
        if (i3 >= 0) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                bArr[i4] = c(bArr[i4]);
            }
            return i3;
        }
        throw new ZipException("invalid length specified to decrpyt data");
    }

    public int b(byte[] bArr) throws ZipException {
        bArr.getClass();
        return a(bArr, 0, bArr.length);
    }

    /* access modifiers changed from: protected */
    public byte c(byte b2) {
        byte b3 = (byte) ((this.f30560a.b() & 255) ^ b2);
        this.f30560a.d(b2);
        return b3;
    }

    /* access modifiers changed from: protected */
    public byte[] d(int i2) throws ZipException {
        if (i2 > 0) {
            byte[] bArr = new byte[i2];
            SecureRandom secureRandom = new SecureRandom();
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = c((byte) secureRandom.nextInt(256));
            }
            return bArr;
        }
        throw new ZipException("size is either 0 or less than 0, cannot generate header for standard encryptor");
    }

    public byte[] e() {
        return this.f30561b;
    }
}
