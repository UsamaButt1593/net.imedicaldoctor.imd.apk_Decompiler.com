package com.itextpdf.text.pdf.parser;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.CMapAwareDocumentFont;
import com.itextpdf.text.pdf.PdfName;

public class GraphicsState {

    /* renamed from: a  reason: collision with root package name */
    Matrix f26927a;

    /* renamed from: b  reason: collision with root package name */
    float f26928b;

    /* renamed from: c  reason: collision with root package name */
    float f26929c;

    /* renamed from: d  reason: collision with root package name */
    float f26930d;

    /* renamed from: e  reason: collision with root package name */
    float f26931e;

    /* renamed from: f  reason: collision with root package name */
    CMapAwareDocumentFont f26932f;

    /* renamed from: g  reason: collision with root package name */
    float f26933g;

    /* renamed from: h  reason: collision with root package name */
    int f26934h;

    /* renamed from: i  reason: collision with root package name */
    float f26935i;

    /* renamed from: j  reason: collision with root package name */
    boolean f26936j;

    /* renamed from: k  reason: collision with root package name */
    PdfName f26937k;

    /* renamed from: l  reason: collision with root package name */
    PdfName f26938l;

    /* renamed from: m  reason: collision with root package name */
    BaseColor f26939m;

    /* renamed from: n  reason: collision with root package name */
    BaseColor f26940n;
    private float o;
    private int p;
    private int q;
    private float r;
    private LineDashPattern s;

    public GraphicsState() {
        BaseColor baseColor = BaseColor.f25677f;
        this.f26939m = baseColor;
        this.f26940n = baseColor;
        this.f26927a = new Matrix();
        this.f26928b = 0.0f;
        this.f26929c = 0.0f;
        this.f26930d = 1.0f;
        this.f26931e = 0.0f;
        this.f26932f = null;
        this.f26933g = 0.0f;
        this.f26934h = 0;
        this.f26935i = 0.0f;
        this.f26936j = true;
        this.f26937k = null;
        this.f26938l = null;
        this.f26939m = null;
        this.f26940n = null;
        this.o = 1.0f;
        this.p = 0;
        this.q = 0;
        this.r = 10.0f;
    }

    public float a() {
        return this.f26928b;
    }

    public PdfName b() {
        return this.f26937k;
    }

    public PdfName c() {
        return this.f26938l;
    }

    public Matrix d() {
        return this.f26927a;
    }

    public BaseColor e() {
        return this.f26939m;
    }

    public CMapAwareDocumentFont f() {
        return this.f26932f;
    }

    public float g() {
        return this.f26933g;
    }

    public float h() {
        return this.f26930d;
    }

    public float i() {
        return this.f26931e;
    }

    public int j() {
        return this.p;
    }

    public LineDashPattern k() {
        return this.s;
    }

    public int l() {
        return this.q;
    }

    public float m() {
        return this.o;
    }

    public float n() {
        return this.r;
    }

    public int o() {
        return this.f26934h;
    }

    public float p() {
        return this.f26935i;
    }

    public BaseColor q() {
        return this.f26940n;
    }

    public float r() {
        return this.f26929c;
    }

    public boolean s() {
        return this.f26936j;
    }

    public void t(int i2) {
        this.p = i2;
    }

    public void u(LineDashPattern lineDashPattern) {
        this.s = new LineDashPattern(lineDashPattern.a(), lineDashPattern.b());
    }

    public void v(int i2) {
        this.q = i2;
    }

    public void w(float f2) {
        this.o = f2;
    }

    public void x(float f2) {
        this.r = f2;
    }

    public GraphicsState(GraphicsState graphicsState) {
        BaseColor baseColor = BaseColor.f25677f;
        this.f26939m = baseColor;
        this.f26940n = baseColor;
        this.f26927a = graphicsState.f26927a;
        this.f26928b = graphicsState.f26928b;
        this.f26929c = graphicsState.f26929c;
        this.f26930d = graphicsState.f26930d;
        this.f26931e = graphicsState.f26931e;
        this.f26932f = graphicsState.f26932f;
        this.f26933g = graphicsState.f26933g;
        this.f26934h = graphicsState.f26934h;
        this.f26935i = graphicsState.f26935i;
        this.f26936j = graphicsState.f26936j;
        this.f26937k = graphicsState.f26937k;
        this.f26938l = graphicsState.f26938l;
        this.f26939m = graphicsState.f26939m;
        this.f26940n = graphicsState.f26940n;
        this.o = graphicsState.o;
        this.p = graphicsState.p;
        this.q = graphicsState.q;
        this.r = graphicsState.r;
        LineDashPattern lineDashPattern = graphicsState.s;
        if (lineDashPattern != null) {
            this.s = new LineDashPattern(lineDashPattern.a(), graphicsState.s.b());
        }
    }
}
