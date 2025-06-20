package com.itextpdf.tool.xml.html.table;

import com.itextpdf.text.BaseColor;

public class TableStyleValues {

    /* renamed from: a  reason: collision with root package name */
    private float f27638a;

    /* renamed from: b  reason: collision with root package name */
    private float f27639b;

    /* renamed from: c  reason: collision with root package name */
    private Float f27640c = null;

    /* renamed from: d  reason: collision with root package name */
    private BaseColor f27641d;

    /* renamed from: e  reason: collision with root package name */
    private Float f27642e = null;

    /* renamed from: f  reason: collision with root package name */
    private BaseColor f27643f;

    /* renamed from: g  reason: collision with root package name */
    private Float f27644g = null;

    /* renamed from: h  reason: collision with root package name */
    private BaseColor f27645h;

    /* renamed from: i  reason: collision with root package name */
    private Float f27646i = null;

    /* renamed from: j  reason: collision with root package name */
    private BaseColor f27647j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f27648k = false;

    /* renamed from: l  reason: collision with root package name */
    private BaseColor f27649l;

    public void A(float f2) {
        this.f27644g = Float.valueOf(f2);
    }

    public void B(float f2) {
        this.f27638a = f2;
    }

    public void C(boolean z) {
        this.f27648k = z;
    }

    public void D(float f2) {
        this.f27639b = f2;
    }

    public BaseColor a() {
        return this.f27649l;
    }

    public BaseColor b() {
        return this.f27647j;
    }

    public BaseColor c() {
        return this.f27641d;
    }

    public BaseColor d() {
        return this.f27643f;
    }

    public BaseColor e() {
        return this.f27645h;
    }

    public float f() {
        return g(true).floatValue();
    }

    public Float g(boolean z) {
        Float f2 = this.f27646i;
        return (f2 != null || !z) ? f2 : Float.valueOf(0.0f);
    }

    public float h() {
        return i(true).floatValue();
    }

    public Float i(boolean z) {
        Float f2 = this.f27640c;
        return (f2 != null || !z) ? f2 : Float.valueOf(0.0f);
    }

    public float j() {
        return k(true).floatValue();
    }

    public Float k(boolean z) {
        Float f2 = this.f27642e;
        return (f2 != null || !z) ? f2 : Float.valueOf(0.0f);
    }

    public float l() {
        return m(true).floatValue();
    }

    public Float m(boolean z) {
        Float f2 = this.f27644g;
        return (f2 != null || !z) ? f2 : Float.valueOf(0.0f);
    }

    public float n() {
        return this.f27638a;
    }

    public float o() {
        return this.f27639b;
    }

    public boolean p() {
        return this.f27648k;
    }

    public void q(BaseColor baseColor) {
        this.f27649l = baseColor;
    }

    public void r(BaseColor baseColor) {
        this.f27647j = baseColor;
        this.f27641d = baseColor;
        this.f27643f = baseColor;
        this.f27645h = baseColor;
    }

    public void s(BaseColor baseColor) {
        this.f27647j = baseColor;
    }

    public void t(BaseColor baseColor) {
        this.f27641d = baseColor;
    }

    public void u(BaseColor baseColor) {
        this.f27643f = baseColor;
    }

    public void v(BaseColor baseColor) {
        this.f27645h = baseColor;
    }

    public void w(float f2) {
        this.f27646i = Float.valueOf(f2);
        this.f27640c = Float.valueOf(f2);
        this.f27642e = Float.valueOf(f2);
        this.f27644g = Float.valueOf(f2);
    }

    public void x(float f2) {
        this.f27646i = Float.valueOf(f2);
    }

    public void y(float f2) {
        this.f27640c = Float.valueOf(f2);
    }

    public void z(float f2) {
        this.f27642e = Float.valueOf(f2);
    }
}
