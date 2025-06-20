package com.airbnb.lottie.utils;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;

public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {
    private long X2 = 0;
    private float Y = 1.0f;
    private float Y2 = 0.0f;
    private boolean Z = false;
    private int Z2 = 0;
    private float a3 = -2.14748365E9f;
    private float b3 = 2.14748365E9f;
    @Nullable
    private LottieComposition c3;
    @VisibleForTesting
    protected boolean d3 = false;

    private void E() {
        if (this.c3 != null) {
            float f2 = this.Y2;
            if (f2 < this.a3 || f2 > this.b3) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.a3), Float.valueOf(this.b3), Float.valueOf(this.Y2)}));
            }
        }
    }

    private float l() {
        LottieComposition lottieComposition = this.c3;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / lottieComposition.h()) / Math.abs(this.Y);
    }

    private boolean p() {
        return o() < 0.0f;
    }

    public void A(float f2, float f3) {
        if (f2 <= f3) {
            LottieComposition lottieComposition = this.c3;
            float p = lottieComposition == null ? -3.4028235E38f : lottieComposition.p();
            LottieComposition lottieComposition2 = this.c3;
            float f4 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.f();
            this.a3 = MiscUtils.b(f2, p, f4);
            this.b3 = MiscUtils.b(f3, p, f4);
            y((float) ((int) MiscUtils.b(this.Y2, f2, f3)));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", new Object[]{Float.valueOf(f2), Float.valueOf(f3)}));
    }

    public void B(int i2) {
        A((float) i2, (float) ((int) this.b3));
    }

    public void D(float f2) {
        this.Y = f2;
    }

    @MainThread
    public void cancel() {
        a();
        t();
    }

    public void doFrame(long j2) {
        s();
        if (this.c3 != null && isRunning()) {
            L.a("LottieValueAnimator#doFrame");
            long j3 = this.X2;
            long j4 = 0;
            if (j3 != 0) {
                j4 = j2 - j3;
            }
            float l2 = ((float) j4) / l();
            float f2 = this.Y2;
            if (p()) {
                l2 = -l2;
            }
            float f3 = f2 + l2;
            this.Y2 = f3;
            boolean z = !MiscUtils.d(f3, n(), m());
            this.Y2 = MiscUtils.b(this.Y2, n(), m());
            this.X2 = j2;
            e();
            if (z) {
                if (getRepeatCount() == -1 || this.Z2 < getRepeatCount()) {
                    c();
                    this.Z2++;
                    if (getRepeatMode() == 2) {
                        this.Z = !this.Z;
                        w();
                    } else {
                        this.Y2 = p() ? m() : n();
                    }
                    this.X2 = j2;
                } else {
                    this.Y2 = this.Y < 0.0f ? n() : m();
                    t();
                    b(p());
                }
            }
            E();
            L.b("LottieValueAnimator#doFrame");
        }
    }

    public void f() {
        this.c3 = null;
        this.a3 = -2.14748365E9f;
        this.b3 = 2.14748365E9f;
    }

    @MainThread
    public void g() {
        t();
        b(p());
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getAnimatedFraction() {
        float f2;
        float n2;
        if (this.c3 == null) {
            return 0.0f;
        }
        if (p()) {
            f2 = m();
            n2 = this.Y2;
        } else {
            f2 = this.Y2;
            n2 = n();
        }
        return (f2 - n2) / (m() - n());
    }

    public Object getAnimatedValue() {
        return Float.valueOf(h());
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.c3;
        if (lottieComposition == null) {
            return 0;
        }
        return (long) lottieComposition.d();
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float h() {
        LottieComposition lottieComposition = this.c3;
        if (lottieComposition == null) {
            return 0.0f;
        }
        return (this.Y2 - lottieComposition.p()) / (this.c3.f() - this.c3.p());
    }

    public float i() {
        return this.Y2;
    }

    public boolean isRunning() {
        return this.d3;
    }

    public float m() {
        LottieComposition lottieComposition = this.c3;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.b3;
        return f2 == 2.14748365E9f ? lottieComposition.f() : f2;
    }

    public float n() {
        LottieComposition lottieComposition = this.c3;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.a3;
        return f2 == -2.14748365E9f ? lottieComposition.p() : f2;
    }

    public float o() {
        return this.Y;
    }

    @MainThread
    public void q() {
        t();
    }

    @MainThread
    public void r() {
        this.d3 = true;
        d(p());
        y((float) ((int) (p() ? m() : n())));
        this.X2 = 0;
        this.Z2 = 0;
        s();
    }

    /* access modifiers changed from: protected */
    public void s() {
        if (isRunning()) {
            u(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 != 2 && this.Z) {
            this.Z = false;
            w();
        }
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void t() {
        u(true);
    }

    /* access modifiers changed from: protected */
    @MainThread
    public void u(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.d3 = false;
        }
    }

    @MainThread
    public void v() {
        float n2;
        this.d3 = true;
        s();
        this.X2 = 0;
        if (p() && i() == n()) {
            n2 = m();
        } else if (!p() && i() == m()) {
            n2 = n();
        } else {
            return;
        }
        this.Y2 = n2;
    }

    public void w() {
        D(-o());
    }

    public void x(LottieComposition lottieComposition) {
        float p;
        float f2;
        boolean z = this.c3 == null;
        this.c3 = lottieComposition;
        if (z) {
            p = (float) ((int) Math.max(this.a3, lottieComposition.p()));
            f2 = Math.min(this.b3, lottieComposition.f());
        } else {
            p = (float) ((int) lottieComposition.p());
            f2 = lottieComposition.f();
        }
        A(p, (float) ((int) f2));
        float f3 = this.Y2;
        this.Y2 = 0.0f;
        y((float) ((int) f3));
        e();
    }

    public void y(float f2) {
        if (this.Y2 != f2) {
            this.Y2 = MiscUtils.b(f2, n(), m());
            this.X2 = 0;
            e();
        }
    }

    public void z(float f2) {
        A(this.a3, f2);
    }
}
