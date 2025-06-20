package net.lingala.zip4j.crypto;

import java.security.SecureRandom;
import net.lingala.zip4j.crypto.PBKDF2.MacBasedPRF;
import net.lingala.zip4j.crypto.engine.AESEngine;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.AesKeyStrength;

public class AESEncrypter implements Encrypter {

    /* renamed from: a  reason: collision with root package name */
    private char[] f30532a;

    /* renamed from: b  reason: collision with root package name */
    private AesKeyStrength f30533b;

    /* renamed from: c  reason: collision with root package name */
    private AESEngine f30534c;

    /* renamed from: d  reason: collision with root package name */
    private MacBasedPRF f30535d;

    /* renamed from: e  reason: collision with root package name */
    private SecureRandom f30536e = new SecureRandom();

    /* renamed from: f  reason: collision with root package name */
    private boolean f30537f;

    /* renamed from: g  reason: collision with root package name */
    private int f30538g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f30539h = 0;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f30540i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f30541j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f30542k;

    /* renamed from: l  reason: collision with root package name */
    private byte[] f30543l;

    public AESEncrypter(char[] cArr, AesKeyStrength aesKeyStrength) throws ZipException {
        if (cArr == null || cArr.length == 0) {
            throw new ZipException("input password is empty or null");
        } else if (aesKeyStrength == AesKeyStrength.KEY_STRENGTH_128 || aesKeyStrength == AesKeyStrength.KEY_STRENGTH_256) {
            this.f30532a = cArr;
            this.f30533b = aesKeyStrength;
            this.f30537f = false;
            this.f30541j = new byte[16];
            this.f30540i = new byte[16];
            g();
        } else {
            throw new ZipException("Invalid AES key strength");
        }
    }

    private byte[] c(int i2) throws ZipException {
        if (i2 == 8 || i2 == 16) {
            int i3 = i2 == 8 ? 2 : i2 == 16 ? 4 : 0;
            byte[] bArr = new byte[i2];
            for (int i4 = 0; i4 < i3; i4++) {
                int nextInt = this.f30536e.nextInt();
                int i5 = i4 * 4;
                bArr[i5] = (byte) (nextInt >> 24);
                bArr[i5 + 1] = (byte) (nextInt >> 16);
                bArr[i5 + 2] = (byte) (nextInt >> 8);
                bArr[i5 + 3] = (byte) nextInt;
            }
            return bArr;
        }
        throw new ZipException("invalid salt size, cannot generate salt");
    }

    private void g() throws ZipException {
        byte[] c2 = c(this.f30533b.f());
        this.f30543l = c2;
        byte[] a2 = AesCipherUtil.a(c2, this.f30532a, this.f30533b);
        this.f30542k = AesCipherUtil.b(a2, this.f30533b);
        this.f30534c = AesCipherUtil.c(a2, this.f30533b);
        this.f30535d = AesCipherUtil.d(a2, this.f30533b);
    }

    public int a(byte[] bArr, int i2, int i3) throws ZipException {
        int i4;
        if (!this.f30537f) {
            if (i3 % 16 != 0) {
                this.f30537f = true;
            }
            int i5 = i2;
            while (true) {
                int i6 = i2 + i3;
                if (i5 >= i6) {
                    return i3;
                }
                int i7 = i5 + 16;
                this.f30539h = i7 <= i6 ? 16 : i6 - i5;
                AesCipherUtil.e(this.f30540i, this.f30538g);
                this.f30534c.e(this.f30540i, this.f30541j);
                int i8 = 0;
                while (true) {
                    i4 = this.f30539h;
                    if (i8 >= i4) {
                        break;
                    }
                    int i9 = i5 + i8;
                    bArr[i9] = (byte) (bArr[i9] ^ this.f30541j[i8]);
                    i8++;
                }
                this.f30535d.f(bArr, i5, i4);
                this.f30538g++;
                i5 = i7;
            }
        } else {
            throw new ZipException("AES Encrypter is in finished state (A non 16 byte block has already been passed to encrypter)");
        }
    }

    public int b(byte[] bArr) throws ZipException {
        if (bArr != null) {
            return a(bArr, 0, bArr.length);
        }
        throw new ZipException("input bytes are null, cannot perform AES encryption");
    }

    public byte[] d() {
        return this.f30542k;
    }

    public byte[] e() {
        byte[] bArr = new byte[10];
        System.arraycopy(this.f30535d.d(), 0, bArr, 0, 10);
        return bArr;
    }

    public byte[] f() {
        return this.f30543l;
    }
}
