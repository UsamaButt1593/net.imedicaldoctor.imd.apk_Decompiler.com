package androidx.constraintlayout.core.motion.utils;

public class VelocityMatrix {

    /* renamed from: g  reason: collision with root package name */
    private static String f4053g = "VelocityMatrix";

    /* renamed from: a  reason: collision with root package name */
    float f4054a;

    /* renamed from: b  reason: collision with root package name */
    float f4055b;

    /* renamed from: c  reason: collision with root package name */
    float f4056c;

    /* renamed from: d  reason: collision with root package name */
    float f4057d;

    /* renamed from: e  reason: collision with root package name */
    float f4058e;

    /* renamed from: f  reason: collision with root package name */
    float f4059f;

    public void a(float f2, float f3, int i2, int i3, float[] fArr) {
        int i4 = i2;
        float f4 = fArr[0];
        float f5 = fArr[1];
        float f6 = (f2 - 0.5f) * 2.0f;
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f4 + this.f4056c;
        float f9 = f5 + this.f4057d;
        float f10 = f8 + (this.f4054a * f6);
        float f11 = f9 + (this.f4055b * f7);
        float radians = (float) Math.toRadians((double) this.f4058e);
        double radians2 = (double) ((float) Math.toRadians((double) this.f4059f));
        double d2 = (double) (((float) i3) * f7);
        fArr[0] = f10 + (((float) ((((double) (((float) (-i4)) * f6)) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
        fArr[1] = f11 + (radians * ((float) ((((double) (((float) i4) * f6)) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
    }

    public void b() {
        this.f4058e = 0.0f;
        this.f4057d = 0.0f;
        this.f4056c = 0.0f;
        this.f4055b = 0.0f;
        this.f4054a = 0.0f;
    }

    public void c(KeyCycleOscillator keyCycleOscillator, float f2) {
        if (keyCycleOscillator != null) {
            this.f4058e = keyCycleOscillator.c(f2);
        }
    }

    public void d(SplineSet splineSet, float f2) {
        if (splineSet != null) {
            this.f4058e = splineSet.c(f2);
            this.f4059f = splineSet.a(f2);
        }
    }

    public void e(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.f4054a = keyCycleOscillator.c(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.f4055b = keyCycleOscillator2.c(f2);
        }
    }

    public void f(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.f4054a = splineSet.c(f2);
        }
        if (splineSet2 != null) {
            this.f4055b = splineSet2.c(f2);
        }
    }

    public void g(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        if (keyCycleOscillator != null) {
            this.f4056c = keyCycleOscillator.c(f2);
        }
        if (keyCycleOscillator2 != null) {
            this.f4057d = keyCycleOscillator2.c(f2);
        }
    }

    public void h(SplineSet splineSet, SplineSet splineSet2, float f2) {
        if (splineSet != null) {
            this.f4056c = splineSet.c(f2);
        }
        if (splineSet2 != null) {
            this.f4057d = splineSet2.c(f2);
        }
    }
}
