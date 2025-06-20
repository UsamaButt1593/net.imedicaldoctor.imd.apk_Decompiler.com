package com.itextpdf.xmp.options;

import com.itextpdf.xmp.XMPException;
import org.apache.commons.lang3.StringUtils;

public final class SerializeOptions extends Options {

    /* renamed from: h  reason: collision with root package name */
    public static final int f27831h = 16;

    /* renamed from: i  reason: collision with root package name */
    public static final int f27832i = 32;

    /* renamed from: j  reason: collision with root package name */
    public static final int f27833j = 64;

    /* renamed from: k  reason: collision with root package name */
    public static final int f27834k = 128;

    /* renamed from: l  reason: collision with root package name */
    public static final int f27835l = 256;

    /* renamed from: m  reason: collision with root package name */
    public static final int f27836m = 512;

    /* renamed from: n  reason: collision with root package name */
    public static final int f27837n = 4096;
    public static final int o = 8192;
    private static final int p = 1;
    private static final int q = 2;
    public static final int r = 0;
    public static final int s = 2;
    public static final int t = 3;
    private static final int u = 3;

    /* renamed from: c  reason: collision with root package name */
    private int f27838c = 2048;

    /* renamed from: d  reason: collision with root package name */
    private String f27839d = StringUtils.LF;

    /* renamed from: e  reason: collision with root package name */
    private String f27840e = "  ";

    /* renamed from: f  reason: collision with root package name */
    private int f27841f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27842g = false;

    public SerializeOptions() {
    }

    public int A() {
        return this.f27838c;
    }

    public boolean B() {
        return g(32);
    }

    public boolean C() {
        return g(8192);
    }

    public boolean D() {
        return g(128);
    }

    public boolean E() {
        return g(64);
    }

    public SerializeOptions F(int i2) {
        this.f27841f = i2;
        return this;
    }

    public SerializeOptions G(boolean z) {
        n(3, false);
        n(2, z);
        return this;
    }

    public SerializeOptions H(boolean z) {
        n(3, false);
        n(3, z);
        return this;
    }

    public SerializeOptions I(boolean z) {
        n(512, z);
        return this;
    }

    public SerializeOptions J(boolean z) {
        n(256, z);
        return this;
    }

    public SerializeOptions K(String str) {
        this.f27840e = str;
        return this;
    }

    public SerializeOptions L(String str) {
        this.f27839d = str;
        return this;
    }

    public SerializeOptions M(boolean z) {
        n(16, z);
        return this;
    }

    public SerializeOptions N(boolean z) {
        n(4096, z);
        return this;
    }

    public SerializeOptions O(int i2) {
        this.f27838c = i2;
        return this;
    }

    public SerializeOptions P(boolean z) {
        n(32, z);
        return this;
    }

    public SerializeOptions Q(boolean z) {
        n(8192, z);
        return this;
    }

    public SerializeOptions R(boolean z) {
        n(128, z);
        return this;
    }

    public SerializeOptions S(boolean z) {
        n(64, z);
        return this;
    }

    public Object clone() throws CloneNotSupportedException {
        try {
            SerializeOptions serializeOptions = new SerializeOptions(i());
            serializeOptions.F(this.f27841f);
            serializeOptions.K(this.f27840e);
            serializeOptions.L(this.f27839d);
            serializeOptions.O(this.f27838c);
            return serializeOptions;
        } catch (XMPException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public String f(int i2) {
        if (i2 == 16) {
            return "OMIT_PACKET_WRAPPER";
        }
        if (i2 == 32) {
            return "READONLY_PACKET";
        }
        if (i2 == 64) {
            return "USE_COMPACT_FORMAT";
        }
        if (i2 == 256) {
            return "INCLUDE_THUMBNAIL_PAD";
        }
        if (i2 == 512) {
            return "EXACT_PACKET_LENGTH";
        }
        if (i2 == 4096) {
            return "OMIT_XMPMETA_ELEMENT";
        }
        if (i2 != 8192) {
            return null;
        }
        return "NORMALIZED";
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 13168;
    }

    public int p() {
        return this.f27841f;
    }

    public boolean q() {
        return (i() & 3) == 2;
    }

    public boolean r() {
        return (i() & 3) == 3;
    }

    public String s() {
        if (q()) {
            return "UTF-16BE";
        }
        return r() ? "UTF-16LE" : "UTF-8";
    }

    public boolean t() {
        return g(512);
    }

    public boolean u() {
        return g(256);
    }

    public String v() {
        return this.f27840e;
    }

    public String w() {
        return this.f27839d;
    }

    public boolean x() {
        return g(16);
    }

    public boolean y() {
        return this.f27842g;
    }

    public boolean z() {
        return g(4096);
    }

    public SerializeOptions(int i2) throws XMPException {
        super(i2);
    }
}
