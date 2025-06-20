package com.itextpdf.xmp.impl.xpath;

public class XMPPathSegment {

    /* renamed from: a  reason: collision with root package name */
    private String f27799a;

    /* renamed from: b  reason: collision with root package name */
    private int f27800b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27801c;

    /* renamed from: d  reason: collision with root package name */
    private int f27802d;

    public XMPPathSegment(String str) {
        this.f27799a = str;
    }

    public int a() {
        return this.f27802d;
    }

    public int b() {
        return this.f27800b;
    }

    public String c() {
        return this.f27799a;
    }

    public boolean d() {
        return this.f27801c;
    }

    public void e(boolean z) {
        this.f27801c = z;
    }

    public void f(int i2) {
        this.f27802d = i2;
    }

    public void g(int i2) {
        this.f27800b = i2;
    }

    public void h(String str) {
        this.f27799a = str;
    }

    public String toString() {
        switch (this.f27800b) {
            case 1:
            case 2:
            case 3:
            case 4:
                return this.f27799a;
            case 5:
            case 6:
                return this.f27799a;
            default:
                return this.f27799a;
        }
    }

    public XMPPathSegment(String str, int i2) {
        this.f27799a = str;
        this.f27800b = i2;
    }
}
