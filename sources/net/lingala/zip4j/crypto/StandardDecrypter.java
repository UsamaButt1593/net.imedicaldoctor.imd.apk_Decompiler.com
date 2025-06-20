package net.lingala.zip4j.crypto;

import com.google.common.base.Ascii;
import net.lingala.zip4j.crypto.engine.ZipCryptoEngine;
import net.lingala.zip4j.exception.ZipException;

public class StandardDecrypter implements Decrypter {

    /* renamed from: a  reason: collision with root package name */
    private char[] f30556a;

    /* renamed from: b  reason: collision with root package name */
    private byte[] f30557b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f30558c = new byte[4];

    /* renamed from: d  reason: collision with root package name */
    private ZipCryptoEngine f30559d;

    public StandardDecrypter(char[] cArr, byte[] bArr, byte[] bArr2) throws ZipException {
        this.f30556a = cArr;
        this.f30557b = bArr;
        this.f30559d = new ZipCryptoEngine();
        b(bArr2);
    }

    private void b(byte[] bArr) throws ZipException {
        byte[] bArr2 = this.f30558c;
        byte[] bArr3 = this.f30557b;
        bArr2[3] = (byte) (bArr3[3] & 255);
        byte b2 = bArr3[3];
        byte b3 = (byte) ((b2 >> 8) & 255);
        bArr2[2] = b3;
        byte b4 = (byte) ((b2 >> 16) & 255);
        bArr2[1] = b4;
        byte b5 = (byte) ((b2 >> Ascii.B) & 255);
        int i2 = 0;
        bArr2[0] = b5;
        if (b3 > 0 || b4 > 0 || b5 > 0) {
            throw new IllegalStateException("Invalid CRC in File Header");
        }
        char[] cArr = this.f30556a;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
        }
        this.f30559d.c(cArr);
        byte b6 = bArr[0];
        while (i2 < 12) {
            ZipCryptoEngine zipCryptoEngine = this.f30559d;
            zipCryptoEngine.d((byte) (zipCryptoEngine.b() ^ b6));
            i2++;
            if (i2 != 12) {
                b6 = bArr[i2];
            }
        }
    }

    public int a(byte[] bArr, int i2, int i3) throws ZipException {
        if (i2 < 0 || i3 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            byte b2 = (byte) (((bArr[i4] & 255) ^ this.f30559d.b()) & 255);
            this.f30559d.d(b2);
            bArr[i4] = b2;
        }
        return i3;
    }
}
