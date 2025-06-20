package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;

public class Highlight {

    /* renamed from: a  reason: collision with root package name */
    private float f19021a;

    /* renamed from: b  reason: collision with root package name */
    private float f19022b;

    /* renamed from: c  reason: collision with root package name */
    private float f19023c;

    /* renamed from: d  reason: collision with root package name */
    private float f19024d;

    /* renamed from: e  reason: collision with root package name */
    private int f19025e;

    /* renamed from: f  reason: collision with root package name */
    private int f19026f;

    /* renamed from: g  reason: collision with root package name */
    private int f19027g;

    /* renamed from: h  reason: collision with root package name */
    private YAxis.AxisDependency f19028h;

    /* renamed from: i  reason: collision with root package name */
    private float f19029i;

    /* renamed from: j  reason: collision with root package name */
    private float f19030j;

    public Highlight(float f2, float f3, float f4, float f5, int i2, int i3, YAxis.AxisDependency axisDependency) {
        this(f2, f3, f4, f5, i2, axisDependency);
        this.f19027g = i3;
    }

    public boolean a(Highlight highlight) {
        return highlight != null && this.f19026f == highlight.f19026f && this.f19021a == highlight.f19021a && this.f19027g == highlight.f19027g && this.f19025e == highlight.f19025e;
    }

    public YAxis.AxisDependency b() {
        return this.f19028h;
    }

    public int c() {
        return this.f19025e;
    }

    public int d() {
        return this.f19026f;
    }

    public float e() {
        return this.f19029i;
    }

    public float f() {
        return this.f19030j;
    }

    public int g() {
        return this.f19027g;
    }

    public float h() {
        return this.f19021a;
    }

    public float i() {
        return this.f19023c;
    }

    public float j() {
        return this.f19022b;
    }

    public float k() {
        return this.f19024d;
    }

    public boolean l() {
        return this.f19027g >= 0;
    }

    public void m(int i2) {
        this.f19025e = i2;
    }

    public void n(float f2, float f3) {
        this.f19029i = f2;
        this.f19030j = f3;
    }

    public String toString() {
        return "Highlight, x: " + this.f19021a + ", y: " + this.f19022b + ", dataSetIndex: " + this.f19026f + ", stackIndex (only stacked barentry): " + this.f19027g;
    }

    public Highlight(float f2, float f3, float f4, float f5, int i2, YAxis.AxisDependency axisDependency) {
        this.f19025e = -1;
        this.f19027g = -1;
        this.f19021a = f2;
        this.f19022b = f3;
        this.f19023c = f4;
        this.f19024d = f5;
        this.f19026f = i2;
        this.f19028h = axisDependency;
    }

    public Highlight(float f2, float f3, int i2) {
        this.f19025e = -1;
        this.f19027g = -1;
        this.f19021a = f2;
        this.f19022b = f3;
        this.f19026f = i2;
    }

    public Highlight(float f2, int i2, int i3) {
        this(f2, Float.NaN, i2);
        this.f19027g = i3;
    }
}
