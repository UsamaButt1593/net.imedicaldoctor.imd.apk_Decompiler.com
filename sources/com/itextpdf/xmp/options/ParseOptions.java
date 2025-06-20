package com.itextpdf.xmp.options;

public final class ParseOptions extends Options {

    /* renamed from: c  reason: collision with root package name */
    public static final int f27814c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27815d = 4;

    /* renamed from: e  reason: collision with root package name */
    public static final int f27816e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f27817f = 16;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27818g = 32;

    public ParseOptions() {
        n(24, true);
    }

    /* access modifiers changed from: protected */
    public String f(int i2) {
        if (i2 == 1) {
            return "REQUIRE_XMP_META";
        }
        if (i2 == 4) {
            return "STRICT_ALIASING";
        }
        if (i2 == 8) {
            return "FIX_CONTROL_CHARS";
        }
        if (i2 == 16) {
            return "ACCEPT_LATIN_1";
        }
        if (i2 != 32) {
            return null;
        }
        return "OMIT_NORMALIZATION";
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 61;
    }

    public boolean p() {
        return g(16);
    }

    public boolean q() {
        return g(8);
    }

    public boolean r() {
        return g(32);
    }

    public boolean s() {
        return g(1);
    }

    public boolean t() {
        return g(4);
    }

    public ParseOptions u(boolean z) {
        n(16, z);
        return this;
    }

    public ParseOptions v(boolean z) {
        n(8, z);
        return this;
    }

    public ParseOptions w(boolean z) {
        n(32, z);
        return this;
    }

    public ParseOptions x(boolean z) {
        n(1, z);
        return this;
    }

    public ParseOptions y(boolean z) {
        n(4, z);
        return this;
    }
}
