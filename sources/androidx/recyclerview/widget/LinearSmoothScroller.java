package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

public class LinearSmoothScroller extends RecyclerView.SmoothScroller {
    private static final boolean q = false;
    private static final float r = 25.0f;
    private static final int s = 10000;
    public static final int t = -1;
    public static final int u = 1;
    public static final int v = 0;
    private static final float w = 1.2f;

    /* renamed from: i  reason: collision with root package name */
    protected final LinearInterpolator f15427i = new LinearInterpolator();

    /* renamed from: j  reason: collision with root package name */
    protected final DecelerateInterpolator f15428j = new DecelerateInterpolator();
    @SuppressLint({"UnknownNullness"})

    /* renamed from: k  reason: collision with root package name */
    protected PointF f15429k;

    /* renamed from: l  reason: collision with root package name */
    private final DisplayMetrics f15430l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15431m = false;

    /* renamed from: n  reason: collision with root package name */
    private float f15432n;
    protected int o = 0;
    protected int p = 0;

    @SuppressLint({"UnknownNullness"})
    public LinearSmoothScroller(Context context) {
        this.f15430l = context.getResources().getDisplayMetrics();
    }

    private float B() {
        if (!this.f15431m) {
            this.f15432n = w(this.f15430l);
            this.f15431m = true;
        }
        return this.f15432n;
    }

    private int z(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    /* access modifiers changed from: protected */
    public int A() {
        PointF pointF = this.f15429k;
        if (pointF != null) {
            float f2 = pointF.x;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int C() {
        PointF pointF = this.f15429k;
        if (pointF != null) {
            float f2 = pointF.y;
            if (f2 != 0.0f) {
                return f2 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void D(RecyclerView.SmoothScroller.Action action) {
        PointF a2 = a(f());
        if (a2 == null || (a2.x == 0.0f && a2.y == 0.0f)) {
            action.f(f());
            s();
            return;
        }
        j(a2);
        this.f15429k = a2;
        this.o = (int) (a2.x * 10000.0f);
        this.p = (int) (a2.y * 10000.0f);
        action.l((int) (((float) this.o) * w), (int) (((float) this.p) * w), (int) (((float) y(10000)) * w), this.f15427i);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void m(int i2, int i3, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        if (c() == 0) {
            s();
            return;
        }
        this.o = z(this.o, i2);
        int z = z(this.p, i3);
        this.p = z;
        if (this.o == 0 && z == 0) {
            D(action);
        }
    }

    /* access modifiers changed from: protected */
    public void n() {
    }

    /* access modifiers changed from: protected */
    public void o() {
        this.p = 0;
        this.o = 0;
        this.f15429k = null;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public void p(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
        int u2 = u(view, A());
        int v2 = v(view, C());
        int x = x((int) Math.sqrt((double) ((u2 * u2) + (v2 * v2))));
        if (x > 0) {
            action.l(-u2, -v2, x, this.f15428j);
        }
    }

    public int t(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 == 0) {
            int i7 = i4 - i2;
            if (i7 > 0) {
                return i7;
            }
            int i8 = i5 - i3;
            if (i8 < 0) {
                return i8;
            }
            return 0;
        } else if (i6 == 1) {
            return i5 - i3;
        } else {
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    @SuppressLint({"UnknownNullness"})
    public int u(View view, int i2) {
        RecyclerView.LayoutManager e2 = e();
        if (e2 == null || !e2.s()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return t(e2.d0(view) - layoutParams.leftMargin, e2.g0(view) + layoutParams.rightMargin, e2.s0(), e2.D0() - e2.t0(), i2);
    }

    @SuppressLint({"UnknownNullness"})
    public int v(View view, int i2) {
        RecyclerView.LayoutManager e2 = e();
        if (e2 == null || !e2.t()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return t(e2.h0(view) - layoutParams.topMargin, e2.b0(view) + layoutParams.bottomMargin, e2.v0(), e2.j0() - e2.q0(), i2);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"UnknownNullness"})
    public float w(DisplayMetrics displayMetrics) {
        return r / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int x(int i2) {
        return (int) Math.ceil(((double) y(i2)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int y(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * B()));
    }
}
