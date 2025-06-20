package net.lingala.zip4j.crypto;

import java.util.Arrays;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.AESExtraDataRecord;
import net.lingala.zip4j.model.enums.AesKeyStrength;

public class AESDecrypter implements Decrypter {

    /* renamed from: a  reason: collision with root package name */
    private AESExtraDataRecord f30525a;

    /* renamed from: b  reason: collision with root package name */
    private char[] f30526b;

    /* renamed from: c  reason: collision with root package name */
    private AESEngine f30527c;

    /* renamed from: d  reason: collision with root package name */
    private MacBasedPRF f30528d;

    /* renamed from: e  reason: collision with root package name */
    private int f30529e = 1;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f30530f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f30531g;

    public AESDecrypter(AESExtraDataRecord aESExtraDataRecord, char[] cArr, byte[] bArr, byte[] bArr2) throws ZipException {
        this.f30525a = aESExtraDataRecord;
        this.f30526b = cArr;
        this.f30530f = new byte[16];
        this.f30531g = new byte[16];
        c(bArr, bArr2);
    }

    private void c(byte[] bArr, byte[] bArr2) throws ZipException {
        char[] cArr = this.f30526b;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("empty or null password provided for AES decryption");
        }
        AesKeyStrength c2 = this.f30525a.c();
        byte[] a2 = AesCipherUtil.a(bArr, this.f30526b, c2);
        if (Arrays.equals(bArr2, AesCipherUtil.b(a2, c2))) {
            this.f30527c = AesCipherUtil.c(a2, c2);
            this.f30528d = AesCipherUtil.d(a2, c2);
            return;
        }
        throw new ZipException("Wrong Password", ZipException.Type.WRONG_PASSWORD);
    }

    public int a(byte[] bArr, int i2, int i3) throws ZipException {
        int i4 = i2;
        while (true) {
            int i5 = i2 + i3;
            if (i4 >= i5) {
                return i3;
            }
            int i6 = i4 + 16;
            int i7 = i6 <= i5 ? 16 : i5 - i4;
            this.f30528d.f(bArr, i4, i7);
            AesCipherUtil.e(this.f30530f, this.f30529e);
            this.f30527c.e(this.f30530f, this.f30531g);
            for (int i8 = 0; i8 < i7; i8++) {
                int i9 = i4 + i8;
                bArr[i9] = (byte) (bArr[i9] ^ this.f30531g[i8]);
            }
            this.f30529e++;
            i4 = i6;
        }
    }

    public byte[] b() {
        return this.f30528d.d();
    }
}
