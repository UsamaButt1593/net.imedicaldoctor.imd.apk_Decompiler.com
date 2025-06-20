package net.imedicaldoctor.imd.CollapsingToolbar;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import net.imedicaldoctor.imd.CollapsingToolbar.ValueAnimatorCompat;

class ValueAnimatorCompatImplGingerbread extends ValueAnimatorCompat.Impl {

    /* renamed from: k  reason: collision with root package name */
    private static final int f29514k = 10;

    /* renamed from: l  reason: collision with root package name */
    private static final int f29515l = 200;

    /* renamed from: m  reason: collision with root package name */
    private static final Handler f29516m = new Handler(Looper.getMainLooper());

    /* renamed from: a  reason: collision with root package name */
    private long f29517a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29518b;

    /* renamed from: c  reason: collision with root package name */
    private float f29519c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f29520d = new int[2];

    /* renamed from: e  reason: collision with root package name */
    private final float[] f29521e = new float[2];

    /* renamed from: f  reason: collision with root package name */
    private long f29522f = 200;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f29523g;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> f29524h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy> f29525i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f29526j = new Runnable() {
        public void run() {
            ValueAnimatorCompatImplGingerbread.this.t();
        }
    };

    ValueAnimatorCompatImplGingerbread() {
    }

    private void o() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.f29524h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f29524h.get(i2).b();
            }
        }
    }

    private void p() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.f29524h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f29524h.get(i2).a();
            }
        }
    }

    private void q() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorListenerProxy> arrayList = this.f29524h;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f29524h.get(i2).c();
            }
        }
    }

    private void r() {
        ArrayList<ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy> arrayList = this.f29525i;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f29525i.get(i2).a();
            }
        }
    }

    public void a(ValueAnimatorCompat.Impl.AnimatorListenerProxy animatorListenerProxy) {
        if (this.f29524h == null) {
            this.f29524h = new ArrayList<>();
        }
        this.f29524h.add(animatorListenerProxy);
    }

    public void b(ValueAnimatorCompat.Impl.AnimatorUpdateListenerProxy animatorUpdateListenerProxy) {
        if (this.f29525i == null) {
            this.f29525i = new ArrayList<>();
        }
        this.f29525i.add(animatorUpdateListenerProxy);
    }

    public void c() {
        this.f29518b = false;
        f29516m.removeCallbacks(this.f29526j);
        o();
        p();
    }

    public void d() {
        if (this.f29518b) {
            this.f29518b = false;
            f29516m.removeCallbacks(this.f29526j);
            this.f29519c = 1.0f;
            r();
            p();
        }
    }

    public float e() {
        float[] fArr = this.f29521e;
        return AnimationUtils.a(fArr[0], fArr[1], f());
    }

    public float f() {
        return this.f29519c;
    }

    public int g() {
        int[] iArr = this.f29520d;
        return AnimationUtils.b(iArr[0], iArr[1], f());
    }

    public long h() {
        return this.f29522f;
    }

    public boolean i() {
        return this.f29518b;
    }

    public void j(long j2) {
        this.f29522f = j2;
    }

    public void k(float f2, float f3) {
        float[] fArr = this.f29521e;
        fArr[0] = f2;
        fArr[1] = f3;
    }

    public void l(int i2, int i3) {
        int[] iArr = this.f29520d;
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public void m(Interpolator interpolator) {
        this.f29523g = interpolator;
    }

    public void n() {
        if (!this.f29518b) {
            if (this.f29523g == null) {
                this.f29523g = new AccelerateDecelerateInterpolator();
            }
            this.f29518b = true;
            this.f29519c = 0.0f;
            s();
        }
    }

    /* access modifiers changed from: package-private */
    public final void s() {
        this.f29517a = SystemClock.uptimeMillis();
        r();
        q();
        f29516m.postDelayed(this.f29526j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void t() {
        if (this.f29518b) {
            float a2 = MathUtils.a(((float) (SystemClock.uptimeMillis() - this.f29517a)) / ((float) this.f29522f), 0.0f, 1.0f);
            Interpolator interpolator = this.f29523g;
            if (interpolator != null) {
                a2 = interpolator.getInterpolation(a2);
            }
            this.f29519c = a2;
            r();
            if (SystemClock.uptimeMillis() >= this.f29517a + this.f29522f) {
                this.f29518b = false;
                p();
            }
        }
        if (this.f29518b) {
            f29516m.postDelayed(this.f29526j, 10);
        }
    }
}
