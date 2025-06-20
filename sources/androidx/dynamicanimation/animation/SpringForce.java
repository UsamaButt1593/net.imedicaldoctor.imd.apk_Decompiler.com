package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringForce implements Force {

    /* renamed from: k  reason: collision with root package name */
    public static final float f7554k = 10000.0f;

    /* renamed from: l  reason: collision with root package name */
    public static final float f7555l = 1500.0f;

    /* renamed from: m  reason: collision with root package name */
    public static final float f7556m = 200.0f;

    /* renamed from: n  reason: collision with root package name */
    public static final float f7557n = 50.0f;
    public static final float o = 0.2f;
    public static final float p = 0.5f;
    public static final float q = 0.75f;
    public static final float r = 1.0f;
    private static final double s = 62.5d;
    private static final double t = Double.MAX_VALUE;

    /* renamed from: a  reason: collision with root package name */
    double f7558a = Math.sqrt(1500.0d);

    /* renamed from: b  reason: collision with root package name */
    double f7559b = 0.5d;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7560c = false;

    /* renamed from: d  reason: collision with root package name */
    private double f7561d;

    /* renamed from: e  reason: collision with root package name */
    private double f7562e;

    /* renamed from: f  reason: collision with root package name */
    private double f7563f;

    /* renamed from: g  reason: collision with root package name */
    private double f7564g;

    /* renamed from: h  reason: collision with root package name */
    private double f7565h;

    /* renamed from: i  reason: collision with root package name */
    private double f7566i = Double.MAX_VALUE;

    /* renamed from: j  reason: collision with root package name */
    private final DynamicAnimation.MassState f7567j = new DynamicAnimation.MassState();

    public SpringForce() {
    }

    private void f() {
        if (!this.f7560c) {
            if (this.f7566i != Double.MAX_VALUE) {
                double d2 = this.f7559b;
                if (d2 > 1.0d) {
                    double d3 = this.f7558a;
                    this.f7563f = ((-d2) * d3) + (d3 * Math.sqrt((d2 * d2) - 1.0d));
                    double d4 = this.f7559b;
                    double d5 = this.f7558a;
                    this.f7564g = ((-d4) * d5) - (d5 * Math.sqrt((d4 * d4) - 1.0d));
                } else if (d2 >= 0.0d && d2 < 1.0d) {
                    this.f7565h = this.f7558a * Math.sqrt(1.0d - (d2 * d2));
                }
                this.f7560c = true;
                return;
            }
            throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(float f2, float f3) {
        return ((double) Math.abs(f3)) < this.f7562e && ((double) Math.abs(f2 - d())) < this.f7561d;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public float b(float f2, float f3) {
        float d2 = f2 - d();
        double d3 = this.f7558a;
        return (float) (((-(d3 * d3)) * ((double) d2)) - (((d3 * 2.0d) * this.f7559b) * ((double) f3)));
    }

    public float c() {
        return (float) this.f7559b;
    }

    public float d() {
        return (float) this.f7566i;
    }

    public float e() {
        double d2 = this.f7558a;
        return (float) (d2 * d2);
    }

    public SpringForce g(@FloatRange(from = 0.0d) float f2) {
        if (f2 >= 0.0f) {
            this.f7559b = (double) f2;
            this.f7560c = false;
            return this;
        }
        throw new IllegalArgumentException("Damping ratio must be non-negative");
    }

    public SpringForce h(float f2) {
        this.f7566i = (double) f2;
        return this;
    }

    public SpringForce i(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.f7558a = Math.sqrt((double) f2);
            this.f7560c = false;
            return this;
        }
        throw new IllegalArgumentException("Spring stiffness constant must be positive.");
    }

    /* access modifiers changed from: package-private */
    public void j(double d2) {
        double abs = Math.abs(d2);
        this.f7561d = abs;
        this.f7562e = abs * s;
    }

    /* access modifiers changed from: package-private */
    public DynamicAnimation.MassState k(double d2, double d3, long j2) {
        double d4;
        double d5;
        f();
        double d6 = ((double) j2) / 1000.0d;
        double d7 = d2 - this.f7566i;
        double d8 = this.f7559b;
        if (d8 > 1.0d) {
            double d9 = this.f7564g;
            double d10 = this.f7563f;
            double d11 = d7 - (((d9 * d7) - d3) / (d9 - d10));
            double d12 = ((d7 * d9) - d3) / (d9 - d10);
            d5 = (Math.pow(2.718281828459045d, d9 * d6) * d11) + (Math.pow(2.718281828459045d, this.f7563f * d6) * d12);
            double d13 = this.f7564g;
            double pow = d11 * d13 * Math.pow(2.718281828459045d, d13 * d6);
            double d14 = this.f7563f;
            d4 = pow + (d12 * d14 * Math.pow(2.718281828459045d, d14 * d6));
        } else if (d8 == 1.0d) {
            double d15 = this.f7558a;
            double d16 = d3 + (d15 * d7);
            double d17 = d7 + (d16 * d6);
            d5 = Math.pow(2.718281828459045d, (-d15) * d6) * d17;
            double pow2 = d17 * Math.pow(2.718281828459045d, (-this.f7558a) * d6);
            double d18 = this.f7558a;
            d4 = (d16 * Math.pow(2.718281828459045d, (-d18) * d6)) + (pow2 * (-d18));
        } else {
            double d19 = 1.0d / this.f7565h;
            double d20 = this.f7558a;
            double d21 = d19 * ((d8 * d20 * d7) + d3);
            double pow3 = Math.pow(2.718281828459045d, (-d8) * d20 * d6) * ((Math.cos(this.f7565h * d6) * d7) + (Math.sin(this.f7565h * d6) * d21));
            double d22 = this.f7558a;
            double d23 = this.f7559b;
            double d24 = (-d22) * pow3 * d23;
            double pow4 = Math.pow(2.718281828459045d, (-d23) * d22 * d6);
            double d25 = this.f7565h;
            double d26 = pow3;
            double sin = (-d25) * d7 * Math.sin(d25 * d6);
            double d27 = this.f7565h;
            d4 = d24 + (pow4 * (sin + (d21 * d27 * Math.cos(d27 * d6))));
            d5 = d26;
        }
        DynamicAnimation.MassState massState = this.f7567j;
        massState.f7544a = (float) (d5 + this.f7566i);
        massState.f7545b = (float) d4;
        return massState;
    }

    public SpringForce(float f2) {
        this.f7566i = (double) f2;
    }
}
