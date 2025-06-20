package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int A3 = 500;
    public static final float k3 = 0.0f;
    public static final float l3 = Float.MAX_VALUE;
    public static final float m3 = 0.0f;
    public static final int n3 = 0;
    public static final int o3 = 1;
    public static final int p3 = 2;
    private static final int q3 = 0;
    private static final int r3 = 1;
    private static final int s3 = 1;
    private static final int t3 = 315;
    private static final int u3 = 1575;
    private static final float v3 = Float.MAX_VALUE;
    private static final float w3 = 0.2f;
    private static final float x3 = 1.0f;
    private static final int y3 = ViewConfiguration.getTapTimeout();
    private static final int z3 = 500;
    private final Interpolator X = new AccelerateInterpolator();
    private float[] X2 = {0.0f, 0.0f};
    final View Y;
    private float[] Y2 = {Float.MAX_VALUE, Float.MAX_VALUE};
    private Runnable Z;
    private int Z2;
    private int a3;
    private float[] b3 = {0.0f, 0.0f};
    private float[] c3 = {0.0f, 0.0f};
    private float[] d3 = {Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean e3;
    boolean f3;
    boolean g3;
    boolean h3;
    private boolean i3;
    private boolean j3;
    final ClampedScroller s = new ClampedScroller();

    private static class ClampedScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f6739a;

        /* renamed from: b  reason: collision with root package name */
        private int f6740b;

        /* renamed from: c  reason: collision with root package name */
        private float f6741c;

        /* renamed from: d  reason: collision with root package name */
        private float f6742d;

        /* renamed from: e  reason: collision with root package name */
        private long f6743e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f6744f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f6745g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f6746h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f6747i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f6748j;

        /* renamed from: k  reason: collision with root package name */
        private int f6749k;

        ClampedScroller() {
        }

        private float e(long j2) {
            long j3 = this.f6743e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f6747i;
            if (j4 < 0 || j2 < j4) {
                return AutoScrollHelper.e(((float) (j2 - j3)) / ((float) this.f6739a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f6748j;
            return (1.0f - f2) + (f2 * AutoScrollHelper.e(((float) (j2 - j4)) / ((float) this.f6749k), 0.0f, 1.0f));
        }

        private float g(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f6744f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g2 = g(e(currentAnimationTimeMillis));
                this.f6744f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f6744f)) * g2;
                this.f6745g = (int) (this.f6741c * f2);
                this.f6746h = (int) (f2 * this.f6742d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f6745g;
        }

        public int c() {
            return this.f6746h;
        }

        public int d() {
            float f2 = this.f6741c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f6742d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            return this.f6747i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f6747i + ((long) this.f6749k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f6749k = AutoScrollHelper.f((int) (currentAnimationTimeMillis - this.f6743e), 0, this.f6740b);
            this.f6748j = e(currentAnimationTimeMillis);
            this.f6747i = currentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f6740b = i2;
        }

        public void k(int i2) {
            this.f6739a = i2;
        }

        public void l(float f2, float f3) {
            this.f6741c = f2;
            this.f6742d = f3;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f6743e = currentAnimationTimeMillis;
            this.f6747i = -1;
            this.f6744f = currentAnimationTimeMillis;
            this.f6748j = 0.5f;
            this.f6745g = 0;
            this.f6746h = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.h3) {
                if (autoScrollHelper.f3) {
                    autoScrollHelper.f3 = false;
                    autoScrollHelper.s.m();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.s;
                if (clampedScroller.h() || !AutoScrollHelper.this.x()) {
                    AutoScrollHelper.this.h3 = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.g3) {
                    autoScrollHelper2.g3 = false;
                    autoScrollHelper2.c();
                }
                clampedScroller.a();
                AutoScrollHelper.this.l(clampedScroller.b(), clampedScroller.c());
                ViewCompat.v1(AutoScrollHelper.this.Y, this);
            }
        }
    }

    public AutoScrollHelper(@NonNull View view) {
        this.Y = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f4 = (float) ((int) ((1575.0f * f2) + 0.5f));
        r(f4, f4);
        float f5 = (float) ((int) ((f2 * 315.0f) + 0.5f));
        s(f5, f5);
        n(1);
        q(Float.MAX_VALUE, Float.MAX_VALUE);
        v(0.2f, 0.2f);
        w(1.0f, 1.0f);
        m(y3);
        u(500);
        t(500);
    }

    private float d(int i2, float f2, float f4, float f5) {
        float h2 = h(this.X2[i2], f4, this.Y2[i2], f2);
        int i4 = (h2 > 0.0f ? 1 : (h2 == 0.0f ? 0 : -1));
        if (i4 == 0) {
            return 0.0f;
        }
        float f6 = this.b3[i2];
        float f7 = this.c3[i2];
        float f8 = this.d3[i2];
        float f9 = f6 * f5;
        return i4 > 0 ? e(h2 * f9, f7, f8) : -e((-h2) * f9, f7, f8);
    }

    static float e(float f2, float f4, float f5) {
        if (f2 > f5) {
            return f5;
        }
        return f2 < f4 ? f4 : f2;
    }

    static int f(int i2, int i4, int i5) {
        if (i2 > i5) {
            return i5;
        }
        return i2 < i4 ? i4 : i2;
    }

    private float g(float f2, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.Z2;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f4) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f4);
                }
                return (!this.h3 || i2 != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f4);
        }
    }

    private float h(float f2, float f4, float f5, float f6) {
        float f7;
        float e2 = e(f2 * f4, 0.0f, f5);
        float g2 = g(f4 - f6, e2) - g(f6, e2);
        if (g2 < 0.0f) {
            f7 = -this.X.getInterpolation(-g2);
        } else if (g2 <= 0.0f) {
            return 0.0f;
        } else {
            f7 = this.X.getInterpolation(g2);
        }
        return e(f7, -1.0f, 1.0f);
    }

    private void k() {
        if (this.f3) {
            this.h3 = false;
        } else {
            this.s.i();
        }
    }

    private void y() {
        int i2;
        if (this.Z == null) {
            this.Z = new ScrollAnimationRunnable();
        }
        this.h3 = true;
        this.f3 = true;
        if (this.e3 || (i2 = this.a3) <= 0) {
            this.Z.run();
        } else {
            ViewCompat.w1(this.Y, this.Z, (long) i2);
        }
        this.e3 = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.Y.onTouchEvent(obtain);
        obtain.recycle();
    }

    public boolean i() {
        return this.i3;
    }

    public boolean j() {
        return this.j3;
    }

    public abstract void l(int i2, int i4);

    @NonNull
    public AutoScrollHelper m(int i2) {
        this.a3 = i2;
        return this;
    }

    @NonNull
    public AutoScrollHelper n(int i2) {
        this.Z2 = i2;
        return this;
    }

    public AutoScrollHelper o(boolean z) {
        if (this.i3 && !z) {
            k();
        }
        this.i3 = z;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.i3
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.k()
            goto L_0x0058
        L_0x001a:
            r5.g3 = r2
            r5.e3 = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.Y
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.Y
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.s
            r7.l(r0, r6)
            boolean r6 = r5.h3
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.x()
            if (r6 == 0) goto L_0x0058
            r5.y()
        L_0x0058:
            boolean r6 = r5.j3
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.h3
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public AutoScrollHelper p(boolean z) {
        this.j3 = z;
        return this;
    }

    @NonNull
    public AutoScrollHelper q(float f2, float f4) {
        float[] fArr = this.Y2;
        fArr[0] = f2;
        fArr[1] = f4;
        return this;
    }

    @NonNull
    public AutoScrollHelper r(float f2, float f4) {
        float[] fArr = this.d3;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper s(float f2, float f4) {
        float[] fArr = this.c3;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    @NonNull
    public AutoScrollHelper t(int i2) {
        this.s.j(i2);
        return this;
    }

    @NonNull
    public AutoScrollHelper u(int i2) {
        this.s.k(i2);
        return this;
    }

    @NonNull
    public AutoScrollHelper v(float f2, float f4) {
        float[] fArr = this.X2;
        fArr[0] = f2;
        fArr[1] = f4;
        return this;
    }

    @NonNull
    public AutoScrollHelper w(float f2, float f4) {
        float[] fArr = this.b3;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f4 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        ClampedScroller clampedScroller = this.s;
        int f2 = clampedScroller.f();
        int d2 = clampedScroller.d();
        return (f2 != 0 && b(f2)) || (d2 != 0 && a(d2));
    }
}
