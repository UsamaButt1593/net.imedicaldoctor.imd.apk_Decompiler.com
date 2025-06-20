package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    private static final float J = Float.MAX_VALUE;
    private SpringForce G = null;
    private float H = Float.MAX_VALUE;
    private boolean I = false;

    public SpringAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
    }

    private void C() {
        SpringForce springForce = this.G;
        if (springForce != null) {
            double d2 = (double) springForce.d();
            if (d2 > ((double) this.f7536g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (d2 < ((double) this.f7537h)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public boolean A() {
        return this.G.f7559b > 0.0d;
    }

    public SpringForce B() {
        return this.G;
    }

    public SpringAnimation D(SpringForce springForce) {
        this.G = springForce;
        return this;
    }

    public void E() {
        if (!A()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f7535f) {
            this.I = true;
        }
    }

    /* access modifiers changed from: package-private */
    public float f(float f2, float f3) {
        return this.G.b(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public boolean j(float f2, float f3) {
        return this.G.a(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public void v(float f2) {
    }

    public void w() {
        C();
        this.G.j((double) i());
        super.w();
    }

    /* access modifiers changed from: package-private */
    public boolean y(long j2) {
        SpringForce springForce;
        double d2;
        double d3;
        long j3;
        if (this.I) {
            float f2 = this.H;
            if (f2 != Float.MAX_VALUE) {
                this.G.h(f2);
                this.H = Float.MAX_VALUE;
            }
            this.f7531b = this.G.d();
            this.f7530a = 0.0f;
            this.I = false;
            return true;
        }
        if (this.H != Float.MAX_VALUE) {
            this.G.d();
            j3 = j2 / 2;
            DynamicAnimation.MassState k2 = this.G.k((double) this.f7531b, (double) this.f7530a, j3);
            this.G.h(this.H);
            this.H = Float.MAX_VALUE;
            springForce = this.G;
            d2 = (double) k2.f7544a;
            d3 = (double) k2.f7545b;
        } else {
            springForce = this.G;
            d2 = (double) this.f7531b;
            d3 = (double) this.f7530a;
            j3 = j2;
        }
        DynamicAnimation.MassState k3 = springForce.k(d2, d3, j3);
        this.f7531b = k3.f7544a;
        this.f7530a = k3.f7545b;
        float max = Math.max(this.f7531b, this.f7537h);
        this.f7531b = max;
        float min = Math.min(max, this.f7536g);
        this.f7531b = min;
        if (!j(min, this.f7530a)) {
            return false;
        }
        this.f7531b = this.G.d();
        this.f7530a = 0.0f;
        return true;
    }

    public void z(float f2) {
        if (k()) {
            this.H = f2;
            return;
        }
        if (this.G == null) {
            this.G = new SpringForce(f2);
        }
        this.G.h(f2);
        w();
    }

    public <K> SpringAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k2, floatPropertyCompat);
    }

    public <K> SpringAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat, float f2) {
        super(k2, floatPropertyCompat);
        this.G = new SpringForce(f2);
    }
}
