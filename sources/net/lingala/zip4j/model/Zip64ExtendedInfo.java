package net.lingala.zip4j.model;

public class Zip64ExtendedInfo extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30633b;

    /* renamed from: c  reason: collision with root package name */
    private long f30634c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f30635d = -1;

    /* renamed from: e  reason: collision with root package name */
    private long f30636e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f30637f = -1;

    public long c() {
        return this.f30634c;
    }

    public int d() {
        return this.f30637f;
    }

    public long e() {
        return this.f30636e;
    }

    public int f() {
        return this.f30633b;
    }

    public long g() {
        return this.f30635d;
    }

    public void h(long j2) {
        this.f30634c = j2;
    }

    public void i(int i2) {
        this.f30637f = i2;
    }

    public void j(long j2) {
        this.f30636e = j2;
    }

    public void k(int i2) {
        this.f30633b = i2;
    }

    public void l(long j2) {
        this.f30635d = j2;
    }
}
