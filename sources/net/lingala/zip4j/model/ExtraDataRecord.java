package net.lingala.zip4j.model;

public class ExtraDataRecord extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private long f30617b;

    /* renamed from: c  reason: collision with root package name */
    private int f30618c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f30619d;

    public byte[] c() {
        return this.f30619d;
    }

    public long d() {
        return this.f30617b;
    }

    public int e() {
        return this.f30618c;
    }

    public void f(byte[] bArr) {
        this.f30619d = bArr;
    }

    public void g(long j2) {
        this.f30617b = j2;
    }

    public void h(int i2) {
        this.f30618c = i2;
    }
}
