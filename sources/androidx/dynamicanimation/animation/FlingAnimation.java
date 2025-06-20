package androidx.dynamicanimation.animation;

import androidx.annotation.FloatRange;
import androidx.dynamicanimation.animation.DynamicAnimation;

public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce G;

    static final class DragForce implements Force {

        /* renamed from: d  reason: collision with root package name */
        private static final float f7546d = -4.2f;

        /* renamed from: e  reason: collision with root package name */
        private static final float f7547e = 62.5f;

        /* renamed from: a  reason: collision with root package name */
        private float f7548a = f7546d;

        /* renamed from: b  reason: collision with root package name */
        private float f7549b;

        /* renamed from: c  reason: collision with root package name */
        private final DynamicAnimation.MassState f7550c = new DynamicAnimation.MassState();

        DragForce() {
        }

        public boolean a(float f2, float f3) {
            return Math.abs(f3) < this.f7549b;
        }

        public float b(float f2, float f3) {
            return f3 * this.f7548a;
        }

        /* access modifiers changed from: package-private */
        public float c() {
            return this.f7548a / f7546d;
        }

        /* access modifiers changed from: package-private */
        public void d(float f2) {
            this.f7548a = f2 * f7546d;
        }

        /* access modifiers changed from: package-private */
        public void e(float f2) {
            this.f7549b = f2 * f7547e;
        }

        /* access modifiers changed from: package-private */
        public DynamicAnimation.MassState f(float f2, float f3, long j2) {
            float f4 = (float) j2;
            this.f7550c.f7545b = (float) (((double) f3) * Math.exp((double) ((f4 / 1000.0f) * this.f7548a)));
            DynamicAnimation.MassState massState = this.f7550c;
            float f5 = this.f7548a;
            massState.f7544a = (float) (((double) (f2 - (f3 / f5))) + (((double) (f3 / f5)) * Math.exp((double) ((f5 * f4) / 1000.0f))));
            DynamicAnimation.MassState massState2 = this.f7550c;
            if (a(massState2.f7544a, massState2.f7545b)) {
                this.f7550c.f7545b = 0.0f;
            }
            return this.f7550c;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        DragForce dragForce = new DragForce();
        this.G = dragForce;
        dragForce.e(i());
    }

    public FlingAnimation A(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        if (f2 > 0.0f) {
            this.G.d(f2);
            return this;
        }
        throw new IllegalArgumentException("Friction must be positive");
    }

    /* renamed from: B */
    public FlingAnimation p(float f2) {
        super.p(f2);
        return this;
    }

    /* renamed from: C */
    public FlingAnimation q(float f2) {
        super.q(f2);
        return this;
    }

    /* renamed from: D */
    public FlingAnimation u(float f2) {
        super.u(f2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public float f(float f2, float f3) {
        return this.G.b(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public boolean j(float f2, float f3) {
        return f2 >= this.f7536g || f2 <= this.f7537h || this.G.a(f2, f3);
    }

    /* access modifiers changed from: package-private */
    public void v(float f2) {
        this.G.e(f2);
    }

    /* access modifiers changed from: package-private */
    public boolean y(long j2) {
        DynamicAnimation.MassState f2 = this.G.f(this.f7531b, this.f7530a, j2);
        float f3 = f2.f7544a;
        this.f7531b = f3;
        float f4 = f2.f7545b;
        this.f7530a = f4;
        float f5 = this.f7537h;
        if (f3 < f5) {
            this.f7531b = f5;
            return true;
        }
        float f6 = this.f7536g;
        if (f3 <= f6) {
            return j(f3, f4);
        }
        this.f7531b = f6;
        return true;
    }

    public float z() {
        return this.G.c();
    }

    public <K> FlingAnimation(K k2, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k2, floatPropertyCompat);
        DragForce dragForce = new DragForce();
        this.G = dragForce;
        dragForce.e(i());
    }
}
