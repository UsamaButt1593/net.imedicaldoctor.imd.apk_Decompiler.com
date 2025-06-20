package com.itextpdf.xmp.options;

public final class IteratorOptions extends Options {

    /* renamed from: c  reason: collision with root package name */
    public static final int f27808c = 256;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27809d = 512;

    /* renamed from: e  reason: collision with root package name */
    public static final int f27810e = 1024;

    /* renamed from: f  reason: collision with root package name */
    public static final int f27811f = 4096;

    /* access modifiers changed from: protected */
    public String f(int i2) {
        if (i2 == 256) {
            return "JUST_CHILDREN";
        }
        if (i2 == 512) {
            return "JUST_LEAFNODES";
        }
        if (i2 == 1024) {
            return "JUST_LEAFNAME";
        }
        if (i2 != 4096) {
            return null;
        }
        return "OMIT_QUALIFIERS";
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 5888;
    }

    public boolean p() {
        return g(256);
    }

    public boolean q() {
        return g(1024);
    }

    public boolean r() {
        return g(512);
    }

    public boolean s() {
        return g(4096);
    }

    public IteratorOptions t(boolean z) {
        n(256, z);
        return this;
    }

    public IteratorOptions u(boolean z) {
        n(1024, z);
        return this;
    }

    public IteratorOptions v(boolean z) {
        n(512, z);
        return this;
    }

    public IteratorOptions w(boolean z) {
        n(4096, z);
        return this;
    }
}
