package net.lingala.zip4j.model;

public class DigitalSignature extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30607b;

    /* renamed from: c  reason: collision with root package name */
    private String f30608c;

    public String c() {
        return this.f30608c;
    }

    public int d() {
        return this.f30607b;
    }

    public void e(String str) {
        this.f30608c = str;
    }

    public void f(int i2) {
        this.f30607b = i2;
    }
}
