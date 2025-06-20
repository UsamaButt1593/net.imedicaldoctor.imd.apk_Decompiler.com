package com.itextpdf.xmp.options;

import com.google.android.material.internal.ViewUtils;
import com.itextpdf.xmp.XMPException;

public final class PropertyOptions extends Options {

    /* renamed from: c  reason: collision with root package name */
    public static final int f27819c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f27820d = 2;

    /* renamed from: e  reason: collision with root package name */
    public static final int f27821e = 16;

    /* renamed from: f  reason: collision with root package name */
    public static final int f27822f = 32;

    /* renamed from: g  reason: collision with root package name */
    public static final int f27823g = 64;

    /* renamed from: h  reason: collision with root package name */
    public static final int f27824h = 128;

    /* renamed from: i  reason: collision with root package name */
    public static final int f27825i = 256;

    /* renamed from: j  reason: collision with root package name */
    public static final int f27826j = 512;

    /* renamed from: k  reason: collision with root package name */
    public static final int f27827k = 1024;

    /* renamed from: l  reason: collision with root package name */
    public static final int f27828l = 2048;

    /* renamed from: m  reason: collision with root package name */
    public static final int f27829m = 4096;

    /* renamed from: n  reason: collision with root package name */
    public static final int f27830n = Integer.MIN_VALUE;
    public static final int o = 536870912;
    public static final int p = 1073741824;

    public PropertyOptions() {
    }

    public boolean A() {
        return g(Integer.MIN_VALUE);
    }

    public boolean B() {
        return (i() & ViewUtils.f21582a) == 0;
    }

    public boolean C() {
        return g(256);
    }

    public boolean D() {
        return g(2);
    }

    public void E(PropertyOptions propertyOptions) throws XMPException {
        if (propertyOptions != null) {
            o(propertyOptions.i() | i());
        }
    }

    public PropertyOptions F(boolean z) {
        n(512, z);
        return this;
    }

    public PropertyOptions G(boolean z) {
        n(4096, z);
        return this;
    }

    public PropertyOptions H(boolean z) {
        n(2048, z);
        return this;
    }

    public PropertyOptions I(boolean z) {
        n(1024, z);
        return this;
    }

    public PropertyOptions J(boolean z) {
        n(64, z);
        return this;
    }

    public PropertyOptions K(boolean z) {
        n(16, z);
        return this;
    }

    public PropertyOptions L(boolean z) {
        n(128, z);
        return this;
    }

    public PropertyOptions M(boolean z) {
        n(32, z);
        return this;
    }

    public PropertyOptions N(boolean z) {
        n(Integer.MIN_VALUE, z);
        return this;
    }

    public PropertyOptions O(boolean z) {
        n(256, z);
        return this;
    }

    public PropertyOptions P(boolean z) {
        n(2, z);
        return this;
    }

    public void a(int i2) throws XMPException {
        if ((i2 & 256) > 0 && (i2 & 512) > 0) {
            throw new XMPException("IsStruct and IsArray options are mutually exclusive", 103);
        } else if ((i2 & 2) > 0 && (i2 & ViewUtils.f21582a) > 0) {
            throw new XMPException("Structs and arrays can't have \"value\" options", 103);
        }
    }

    /* access modifiers changed from: protected */
    public String f(int i2) {
        switch (i2) {
            case Integer.MIN_VALUE:
                return "SCHEMA_NODE";
            case 2:
                return "URI";
            case 16:
                return "HAS_QUALIFIER";
            case 32:
                return "QUALIFIER";
            case 64:
                return "HAS_LANGUAGE";
            case 128:
                return "HAS_TYPE";
            case 256:
                return "STRUCT";
            case 512:
                return "ARRAY";
            case 1024:
                return "ARRAY_ORDERED";
            case 2048:
                return "ARRAY_ALTERNATE";
            case 4096:
                return "ARRAY_ALT_TEXT";
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public int k() {
        return -1073733646;
    }

    public boolean p(PropertyOptions propertyOptions) {
        return t() == propertyOptions.t() && w() == propertyOptions.w() && v() == propertyOptions.v() && u() == propertyOptions.u();
    }

    public boolean q() {
        return g(64);
    }

    public boolean r() {
        return g(16);
    }

    public boolean s() {
        return g(128);
    }

    public boolean t() {
        return g(512);
    }

    public boolean u() {
        return g(4096);
    }

    public boolean v() {
        return g(2048);
    }

    public boolean w() {
        return g(1024);
    }

    public boolean x() {
        return (i() & ViewUtils.f21582a) > 0;
    }

    public boolean y() {
        return (i() & -7681) == 0;
    }

    public boolean z() {
        return g(32);
    }

    public PropertyOptions(int i2) throws XMPException {
        super(i2);
    }
}
