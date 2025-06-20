package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;

final class FakeDrag {

    /* renamed from: a  reason: collision with root package name */
    private final ViewPager2 f16561a;

    /* renamed from: b  reason: collision with root package name */
    private final ScrollEventAdapter f16562b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView f16563c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f16564d;

    /* renamed from: e  reason: collision with root package name */
    private int f16565e;

    /* renamed from: f  reason: collision with root package name */
    private float f16566f;

    /* renamed from: g  reason: collision with root package name */
    private int f16567g;

    /* renamed from: h  reason: collision with root package name */
    private long f16568h;

    FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f16561a = viewPager2;
        this.f16562b = scrollEventAdapter;
        this.f16563c = recyclerView;
    }

    private void a(long j2, int i2, float f2, float f3) {
        MotionEvent obtain = MotionEvent.obtain(this.f16568h, j2, i2, f2, f3, 0);
        this.f16564d.addMovement(obtain);
        obtain.recycle();
    }

    private void c() {
        VelocityTracker velocityTracker = this.f16564d;
        if (velocityTracker == null) {
            this.f16564d = VelocityTracker.obtain();
            this.f16565e = ViewConfiguration.get(this.f16561a.getContext()).getScaledMaximumFlingVelocity();
            return;
        }
        velocityTracker.clear();
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean b() {
        if (this.f16562b.i()) {
            return false;
        }
        this.f16567g = 0;
        this.f16566f = (float) 0;
        this.f16568h = SystemClock.uptimeMillis();
        c();
        this.f16562b.m();
        if (!this.f16562b.k()) {
            this.f16563c.b2();
        }
        a(this.f16568h, 0, 0.0f, 0.0f);
        return true;
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean d() {
        if (!this.f16562b.j()) {
            return false;
        }
        this.f16562b.o();
        VelocityTracker velocityTracker = this.f16564d;
        velocityTracker.computeCurrentVelocity(1000, (float) this.f16565e);
        if (this.f16563c.r0((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f16561a.v();
        return true;
    }

    /* access modifiers changed from: package-private */
    @UiThread
    public boolean e(float f2) {
        int i2 = 0;
        if (!this.f16562b.j()) {
            return false;
        }
        float f3 = this.f16566f - f2;
        this.f16566f = f3;
        int round = Math.round(f3 - ((float) this.f16567g));
        this.f16567g += round;
        long uptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.f16561a.getOrientation() == 0;
        int i3 = z ? round : 0;
        if (!z) {
            i2 = round;
        }
        float f4 = z ? this.f16566f : 0.0f;
        float f5 = z ? 0.0f : this.f16566f;
        this.f16563c.scrollBy(i3, i2);
        a(uptimeMillis, 2, f4, f5);
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return this.f16562b.j();
    }
}
