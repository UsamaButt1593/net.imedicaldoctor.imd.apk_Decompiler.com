package com.github.mikephil.charting.highlight;

public final class Range {

    /* renamed from: a  reason: collision with root package name */
    public float f19033a;

    /* renamed from: b  reason: collision with root package name */
    public float f19034b;

    public Range(float f2, float f3) {
        this.f19033a = f2;
        this.f19034b = f3;
    }

    public boolean a(float f2) {
        return f2 > this.f19033a && f2 <= this.f19034b;
    }

    public boolean b(float f2) {
        return f2 > this.f19034b;
    }

    public boolean c(float f2) {
        return f2 < this.f19033a;
    }
}
