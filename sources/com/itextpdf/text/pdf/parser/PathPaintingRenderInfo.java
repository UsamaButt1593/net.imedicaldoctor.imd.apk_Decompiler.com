package com.itextpdf.text.pdf.parser;

public class PathPaintingRenderInfo {

    /* renamed from: d  reason: collision with root package name */
    public static final int f26995d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f26996e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f26997f = 0;

    /* renamed from: g  reason: collision with root package name */
    public static final int f26998g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f26999h = 2;

    /* renamed from: a  reason: collision with root package name */
    private int f27000a;

    /* renamed from: b  reason: collision with root package name */
    private int f27001b;

    /* renamed from: c  reason: collision with root package name */
    private GraphicsState f27002c;

    public PathPaintingRenderInfo(int i2, int i3, GraphicsState graphicsState) {
        this.f27000a = i2;
        this.f27001b = i3;
        this.f27002c = graphicsState;
    }

    public Matrix a() {
        return this.f27002c.f26927a;
    }

    public int b() {
        return this.f27002c.j();
    }

    public LineDashPattern c() {
        return this.f27002c.k();
    }

    public int d() {
        return this.f27002c.l();
    }

    public float e() {
        return this.f27002c.m();
    }

    public float f() {
        return this.f27002c.n();
    }

    public int g() {
        return this.f27000a;
    }

    public int h() {
        return this.f27001b;
    }

    public PathPaintingRenderInfo(int i2, GraphicsState graphicsState) {
        this(i2, 1, graphicsState);
    }
}
