package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContrastCurve {

    /* renamed from: a  reason: collision with root package name */
    private final double f21168a;

    /* renamed from: b  reason: collision with root package name */
    private final double f21169b;

    /* renamed from: c  reason: collision with root package name */
    private final double f21170c;

    /* renamed from: d  reason: collision with root package name */
    private final double f21171d;

    public ContrastCurve(double d2, double d3, double d4, double d5) {
        this.f21168a = d2;
        this.f21169b = d3;
        this.f21170c = d4;
        this.f21171d = d5;
    }

    public double a(double d2) {
        if (d2 <= -1.0d) {
            return this.f21168a;
        }
        if (d2 < 0.0d) {
            return MathUtils.d(this.f21168a, this.f21169b, (d2 - -1.0d) / 1.0d);
        }
        if (d2 < 0.5d) {
            return MathUtils.d(this.f21169b, this.f21170c, (d2 - 0.0d) / 0.5d);
        }
        return d2 < 1.0d ? MathUtils.d(this.f21170c, this.f21171d, (d2 - 0.5d) / 0.5d) : this.f21171d;
    }
}
