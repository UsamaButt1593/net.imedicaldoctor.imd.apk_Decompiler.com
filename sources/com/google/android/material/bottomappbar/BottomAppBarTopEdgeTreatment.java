package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int Z2 = 90;
    private static final int a3 = 180;
    private static final int b3 = 270;
    private static final int c3 = 180;
    private static final float d3 = 1.75f;
    private float X;
    private float X2;
    private float Y;
    private float Y2 = -1.0f;
    private float Z;
    private float s;

    public BottomAppBarTopEdgeTreatment(float f2, float f3, float f4) {
        this.X = f2;
        this.s = f3;
        l(f4);
        this.X2 = 0.0f;
    }

    public void b(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13 = f2;
        ShapePath shapePath2 = shapePath;
        float f14 = this.Y;
        if (f14 == 0.0f) {
            shapePath2.n(f13, 0.0f);
            return;
        }
        float f15 = ((this.X * 2.0f) + f14) / 2.0f;
        float f16 = f4 * this.s;
        float f17 = f3 + this.X2;
        float f18 = (this.Z * f4) + ((1.0f - f4) * f15);
        if (f18 / f15 >= 1.0f) {
            shapePath2.n(f13, 0.0f);
            return;
        }
        float f19 = this.Y2;
        float f20 = f19 * f4;
        boolean z = f19 == -1.0f || Math.abs((f19 * 2.0f) - f14) < 0.1f;
        if (!z) {
            f6 = d3;
            f5 = 0.0f;
        } else {
            f5 = f18;
            f6 = 0.0f;
        }
        float f21 = f15 + f16;
        float f22 = f5 + f16;
        float sqrt = (float) Math.sqrt((double) ((f21 * f21) - (f22 * f22)));
        float f23 = f17 - sqrt;
        float f24 = f17 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan((double) (sqrt / f22)));
        float f25 = (90.0f - degrees) + f6;
        shapePath2.n(f23, 0.0f);
        float f26 = f16 * 2.0f;
        float f27 = degrees;
        shapePath.a(f23 - f16, 0.0f, f23 + f16, f26, 270.0f, degrees);
        if (z) {
            f8 = f17 - f15;
            f9 = (-f15) - f5;
            f7 = f17 + f15;
            f10 = f15 - f5;
            f12 = 180.0f - f25;
            f11 = (f25 * 2.0f) - 180.0f;
        } else {
            float f28 = this.X;
            float f29 = f20 * 2.0f;
            float f30 = f17 - f15;
            shapePath.a(f30, -(f20 + f28), f30 + f28 + f29, f28 + f20, 180.0f - f25, ((f25 * 2.0f) - 180.0f) / 2.0f);
            f7 = f17 + f15;
            float f31 = this.X;
            shapePath2.n(f7 - ((f31 / 2.0f) + f20), f31 + f20);
            float f32 = this.X;
            f8 = f7 - (f29 + f32);
            f9 = -(f20 + f32);
            f10 = f32 + f20;
            f11 = f25 - 0.049804688f;
            f12 = 90.0f;
        }
        shapePath.a(f8, f9, f7, f10, f12, f11);
        shapePath.a(f24 - f16, 0.0f, f24 + f16, f26, 270.0f - f27, f27);
        shapePath2.n(f13, 0.0f);
    }

    /* access modifiers changed from: package-private */
    public float d() {
        return this.Z;
    }

    public float e() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public float f() {
        return this.X;
    }

    /* access modifiers changed from: package-private */
    public float g() {
        return this.s;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float h() {
        return this.Y;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float i() {
        return this.X2;
    }

    /* access modifiers changed from: package-private */
    public void l(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.Z = f2;
            return;
        }
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void m(float f2) {
        this.Y2 = f2;
    }

    /* access modifiers changed from: package-private */
    public void n(float f2) {
        this.X = f2;
    }

    /* access modifiers changed from: package-private */
    public void o(float f2) {
        this.s = f2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void p(float f2) {
        this.Y = f2;
    }

    /* access modifiers changed from: package-private */
    public void q(float f2) {
        this.X2 = f2;
    }
}
