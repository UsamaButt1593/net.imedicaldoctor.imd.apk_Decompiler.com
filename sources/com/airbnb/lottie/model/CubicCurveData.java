package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class CubicCurveData {

    /* renamed from: a  reason: collision with root package name */
    private final PointF f17094a;

    /* renamed from: b  reason: collision with root package name */
    private final PointF f17095b;

    /* renamed from: c  reason: collision with root package name */
    private final PointF f17096c;

    public CubicCurveData() {
        this.f17094a = new PointF();
        this.f17095b = new PointF();
        this.f17096c = new PointF();
    }

    public PointF a() {
        return this.f17094a;
    }

    public PointF b() {
        return this.f17095b;
    }

    public PointF c() {
        return this.f17096c;
    }

    public void d(float f2, float f3) {
        this.f17094a.set(f2, f3);
    }

    public void e(float f2, float f3) {
        this.f17095b.set(f2, f3);
    }

    public void f(float f2, float f3) {
        this.f17096c.set(f2, f3);
    }

    public CubicCurveData(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f17094a = pointF;
        this.f17095b = pointF2;
        this.f17096c = pointF3;
    }
}
