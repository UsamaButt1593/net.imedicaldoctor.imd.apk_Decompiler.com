package net.lingala.zip4j.crypto.PBKDF2;

import net.lingala.zip4j.util.Zip4jUtil;

public class PBKDF2Engine {

    /* renamed from: a  reason: collision with root package name */
    private PBKDF2Parameters f30549a;

    /* renamed from: b  reason: collision with root package name */
    private PRF f30550b;

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters) {
        this(pBKDF2Parameters, (PRF) null);
    }

    private byte[] b(PRF prf, byte[] bArr, int i2, int i3) {
        int i4 = i3;
        byte[] bArr2 = bArr == null ? new byte[0] : bArr;
        int b2 = prf.b();
        int e2 = e(i4, b2);
        int i5 = i4 - ((e2 - 1) * b2);
        byte[] bArr3 = new byte[(e2 * b2)];
        int i6 = 0;
        for (int i7 = 1; i7 <= e2; i7++) {
            c(bArr3, i6, prf, bArr2, i2, i7);
            i6 += b2;
        }
        if (i5 >= b2) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        return bArr4;
    }

    private void c(byte[] bArr, int i2, PRF prf, byte[] bArr2, int i3, int i4) {
        int b2 = prf.b();
        byte[] bArr3 = new byte[b2];
        byte[] bArr4 = new byte[(bArr2.length + 4)];
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
        a(bArr4, bArr2.length, i4);
        for (int i5 = 0; i5 < i3; i5++) {
            bArr4 = prf.a(bArr4);
            m(bArr3, bArr4);
        }
        System.arraycopy(bArr3, 0, bArr, i2, b2);
    }

    private void d(byte[] bArr) {
        if (this.f30550b == null) {
            this.f30550b = new MacBasedPRF(this.f30549a.b());
        }
        this.f30550b.c(bArr);
    }

    private int e(int i2, int i3) {
        return (i2 / i3) + (i2 % i3 > 0 ? 1 : 0);
    }

    private void m(byte[] bArr, byte[] bArr2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2]);
        }
    }

    /* access modifiers changed from: protected */
    public void a(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 / 16777216);
        bArr[i2 + 1] = (byte) (i3 / 65536);
        bArr[i2 + 2] = (byte) (i3 / 256);
        bArr[i2 + 3] = (byte) i3;
    }

    public byte[] f(char[] cArr) {
        return g(cArr, 0);
    }

    public byte[] g(char[] cArr, int i2) {
        cArr.getClass();
        d(Zip4jUtil.a(cArr));
        if (i2 == 0) {
            i2 = this.f30550b.b();
        }
        return b(this.f30550b, this.f30549a.e(), this.f30549a.d(), i2);
    }

    public PBKDF2Parameters h() {
        return this.f30549a;
    }

    public PRF i() {
        return this.f30550b;
    }

    public void j(PBKDF2Parameters pBKDF2Parameters) {
        this.f30549a = pBKDF2Parameters;
    }

    public void k(PRF prf) {
        this.f30550b = prf;
    }

    public boolean l(char[] cArr) {
        byte[] g2;
        byte[] a2 = h().a();
        if (a2 == null || a2.length == 0 || (g2 = g(cArr, a2.length)) == null || g2.length != a2.length) {
            return false;
        }
        for (int i2 = 0; i2 < g2.length; i2++) {
            if (g2[i2] != a2[i2]) {
                return false;
            }
        }
        return true;
    }

    public PBKDF2Engine(PBKDF2Parameters pBKDF2Parameters, PRF prf) {
        this.f30549a = pBKDF2Parameters;
        this.f30550b = prf;
    }
}
