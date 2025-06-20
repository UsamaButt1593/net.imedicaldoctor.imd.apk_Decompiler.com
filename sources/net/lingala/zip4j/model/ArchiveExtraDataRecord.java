package net.lingala.zip4j.model;

public class ArchiveExtraDataRecord extends ZipHeader {

    /* renamed from: b  reason: collision with root package name */
    private int f30600b;

    /* renamed from: c  reason: collision with root package name */
    private String f30601c;

    public String c() {
        return this.f30601c;
    }

    public int d() {
        return this.f30600b;
    }

    public void e(String str) {
        this.f30601c = str;
    }

    public void f(int i2) {
        this.f30600b = i2;
    }
}
