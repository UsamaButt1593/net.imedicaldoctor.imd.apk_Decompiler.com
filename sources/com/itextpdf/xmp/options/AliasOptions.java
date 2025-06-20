package com.itextpdf.xmp.options;

import androidx.media3.exoplayer.RendererCapabilities;
import com.itextpdf.xmp.XMPException;

public final class AliasOptions extends Options {

    /* renamed from: c  reason: collision with root package name */
    public static final int f27803c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27804d = 512;

    /* renamed from: e  reason: collision with root package name */
    public static final int f27805e = 1024;

    /* renamed from: f  reason: collision with root package name */
    public static final int f27806f = 2048;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27807g = 4096;

    public AliasOptions() {
    }

    /* access modifiers changed from: protected */
    public String f(int i2) {
        if (i2 == 0) {
            return "PROP_DIRECT";
        }
        if (i2 == 512) {
            return "ARRAY";
        }
        if (i2 == 1024) {
            return "ARRAY_ORDERED";
        }
        if (i2 == 2048) {
            return "ARRAY_ALTERNATE";
        }
        if (i2 != 4096) {
            return null;
        }
        return "ARRAY_ALT_TEXT";
    }

    /* access modifiers changed from: protected */
    public int k() {
        return 7680;
    }

    public boolean p() {
        return g(512);
    }

    public boolean q() {
        return g(4096);
    }

    public boolean r() {
        return g(2048);
    }

    public boolean s() {
        return g(1024);
    }

    public boolean t() {
        return i() == 0;
    }

    public AliasOptions u(boolean z) {
        n(512, z);
        return this;
    }

    public AliasOptions v(boolean z) {
        n(7680, z);
        return this;
    }

    public AliasOptions w(boolean z) {
        n(RendererCapabilities.Q, z);
        return this;
    }

    public AliasOptions x(boolean z) {
        n(1536, z);
        return this;
    }

    public PropertyOptions y() throws XMPException {
        return new PropertyOptions(i());
    }

    public AliasOptions(int i2) throws XMPException {
        super(i2);
    }
}
