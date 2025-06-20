package net.lingala.zip4j.model;

public class Zip64EndOfCentralDirectoryLocator extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30620b;

    /* renamed from: c  reason: collision with root package name */
    private long f30621c;

    /* renamed from: d  reason: collision with root package name */
    private int f30622d;

    public int c() {
        return this.f30620b;
    }

    public long d() {
        return this.f30621c;
    }

    public int e() {
        return this.f30622d;
    }

    public void f(int i2) {
        this.f30620b = i2;
    }

    public void g(long j2) {
        this.f30621c = j2;
    }

    public void h(int i2) {
        this.f30622d = i2;
    }
}
