package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    private TimeListener G3;
    private long H3 = -1;

    public interface TimeListener {
        void a(TimeAnimator timeAnimator, long j2, long j3);
    }

    /* access modifiers changed from: package-private */
    public void G(float f2) {
    }

    /* access modifiers changed from: package-private */
    public boolean J(long j2) {
        long j3 = 0;
        if (this.b3 == 0) {
            this.b3 = 1;
            long j4 = this.Y;
            if (j4 < 0) {
                this.X = j2;
            } else {
                this.X = j2 - j4;
                this.Y = -1;
            }
        }
        TimeListener timeListener = this.G3;
        if (timeListener == null) {
            return false;
        }
        long j5 = j2 - this.X;
        long j6 = this.H3;
        if (j6 >= 0) {
            j3 = j2 - j6;
        }
        long j7 = j3;
        this.H3 = j2;
        timeListener.a(this, j5, j7);
        return false;
    }

    public void L0(TimeListener timeListener) {
        this.G3 = timeListener;
    }

    /* access modifiers changed from: package-private */
    public void k0() {
    }
}
