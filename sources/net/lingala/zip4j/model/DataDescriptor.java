package net.lingala.zip4j.model;

public class DataDescriptor extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private long f30604b;

    /* renamed from: c  reason: collision with root package name */
    private long f30605c;

    /* renamed from: d  reason: collision with root package name */
    private long f30606d;

    public long c() {
        return this.f30605c;
    }

    public long d() {
        return this.f30604b;
    }

    public long e() {
        return this.f30606d;
    }

    public void f(long j2) {
        this.f30605c = j2;
    }

    public void g(long j2) {
        this.f30604b = j2;
    }

    public void h(long j2) {
        this.f30606d = j2;
    }
}
