package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import java.io.IOException;

public class MetaBrush extends MetaObject {

    /* renamed from: i  reason: collision with root package name */
    public static final int f26712i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26713j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f26714k = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f26715l = 3;

    /* renamed from: m  reason: collision with root package name */
    public static final int f26716m = 5;

    /* renamed from: n  reason: collision with root package name */
    public static final int f26717n = 0;
    public static final int o = 1;
    public static final int p = 2;
    public static final int q = 3;
    public static final int r = 4;
    public static final int s = 5;

    /* renamed from: f  reason: collision with root package name */
    int f26718f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f26719g;

    /* renamed from: h  reason: collision with root package name */
    BaseColor f26720h = BaseColor.f25673b;

    public MetaBrush() {
        this.f26748a = 2;
    }

    public BaseColor b() {
        return this.f26720h;
    }

    public int c() {
        return this.f26719g;
    }

    public int d() {
        return this.f26718f;
    }

    public void e(InputMeta inputMeta) throws IOException {
        this.f26718f = inputMeta.f();
        this.f26720h = inputMeta.c();
        this.f26719g = inputMeta.f();
    }
}
