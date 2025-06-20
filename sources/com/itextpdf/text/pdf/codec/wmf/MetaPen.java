package com.itextpdf.text.pdf.codec.wmf;

import com.itextpdf.text.BaseColor;
import java.io.IOException;

public class MetaPen extends MetaObject {

    /* renamed from: i  reason: collision with root package name */
    public static final int f26749i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f26750j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final int f26751k = 2;

    /* renamed from: l  reason: collision with root package name */
    public static final int f26752l = 3;

    /* renamed from: m  reason: collision with root package name */
    public static final int f26753m = 4;

    /* renamed from: n  reason: collision with root package name */
    public static final int f26754n = 5;
    public static final int o = 6;

    /* renamed from: f  reason: collision with root package name */
    int f26755f = 0;

    /* renamed from: g  reason: collision with root package name */
    int f26756g = 1;

    /* renamed from: h  reason: collision with root package name */
    BaseColor f26757h = BaseColor.f25677f;

    public MetaPen() {
        this.f26748a = 1;
    }

    public BaseColor b() {
        return this.f26757h;
    }

    public int c() {
        return this.f26756g;
    }

    public int d() {
        return this.f26755f;
    }

    public void e(InputMeta inputMeta) throws IOException {
        this.f26755f = inputMeta.f();
        this.f26756g = inputMeta.e();
        inputMeta.f();
        this.f26757h = inputMeta.c();
    }
}
