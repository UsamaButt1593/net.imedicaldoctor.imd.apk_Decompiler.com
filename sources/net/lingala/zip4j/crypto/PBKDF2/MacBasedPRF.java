package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MacBasedPRF implements PRF {

    /* renamed from: a  reason: collision with root package name */
    private Mac f30546a;

    /* renamed from: b  reason: collision with root package name */
    private int f30547b;

    /* renamed from: c  reason: collision with root package name */
    private String f30548c;

    public MacBasedPRF(String str) {
        this.f30548c = str;
        try {
            Mac instance = Mac.getInstance(str);
            this.f30546a = instance;
            this.f30547b = instance.getMacLength();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
    }

    public byte[] a(byte[] bArr) {
        return this.f30546a.doFinal(bArr);
    }

    public int b() {
        return this.f30547b;
    }

    public void c(byte[] bArr) {
        try {
            this.f30546a.init(new SecretKeySpec(bArr, this.f30548c));
        } catch (InvalidKeyException e2) {
            throw new RuntimeException(e2);
        }
    }

    public byte[] d() {
        return this.f30546a.doFinal();
    }

    public void e(byte[] bArr) {
        try {
            this.f30546a.update(bArr);
        } catch (IllegalStateException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void f(byte[] bArr, int i2, int i3) {
        try {
            this.f30546a.update(bArr, i2, i3);
        } catch (IllegalStateException e2) {
            throw new RuntimeException(e2);
        }
    }
}
