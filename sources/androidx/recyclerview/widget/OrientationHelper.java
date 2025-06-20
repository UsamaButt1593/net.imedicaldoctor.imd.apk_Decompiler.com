package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class OrientationHelper {

    /* renamed from: d  reason: collision with root package name */
    private static final int f15477d = Integer.MIN_VALUE;

    /* renamed from: e  reason: collision with root package name */
    public static final int f15478e = 0;

    /* renamed from: f  reason: collision with root package name */
    public static final int f15479f = 1;

    /* renamed from: a  reason: collision with root package name */
    protected final RecyclerView.LayoutManager f15480a;

    /* renamed from: b  reason: collision with root package name */
    private int f15481b;

    /* renamed from: c  reason: collision with root package name */
    final Rect f15482c;

    private OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f15481b = Integer.MIN_VALUE;
        this.f15482c = new Rect();
        this.f15480a = layoutManager;
    }

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int d(View view) {
                return this.f15480a.g0(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f15480a.f0(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f15480a.e0(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int g(View view) {
                return this.f15480a.d0(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            public int h() {
                return this.f15480a.D0();
            }

            public int i() {
                return this.f15480a.D0() - this.f15480a.t0();
            }

            public int j() {
                return this.f15480a.t0();
            }

            public int l() {
                return this.f15480a.E0();
            }

            public int m() {
                return this.f15480a.k0();
            }

            public int n() {
                return this.f15480a.s0();
            }

            public int o() {
                return (this.f15480a.D0() - this.f15480a.s0()) - this.f15480a.t0();
            }

            public int q(View view) {
                this.f15480a.C0(view, true, this.f15482c);
                return this.f15482c.right;
            }

            public int r(View view) {
                this.f15480a.C0(view, true, this.f15482c);
                return this.f15482c.left;
            }

            public void s(View view, int i2) {
                view.offsetLeftAndRight(i2);
            }

            public void t(int i2) {
                this.f15480a.X0(i2);
            }
        };
    }

    public static OrientationHelper b(RecyclerView.LayoutManager layoutManager, int i2) {
        if (i2 == 0) {
            return a(layoutManager);
        }
        if (i2 == 1) {
            return c(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper c(RecyclerView.LayoutManager layoutManager) {
        return new OrientationHelper(layoutManager) {
            public int d(View view) {
                return this.f15480a.b0(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
            }

            public int e(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f15480a.e0(view) + layoutParams.topMargin + layoutParams.bottomMargin;
            }

            public int f(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return this.f15480a.f0(view) + layoutParams.leftMargin + layoutParams.rightMargin;
            }

            public int g(View view) {
                return this.f15480a.h0(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            public int h() {
                return this.f15480a.j0();
            }

            public int i() {
                return this.f15480a.j0() - this.f15480a.q0();
            }

            public int j() {
                return this.f15480a.q0();
            }

            public int l() {
                return this.f15480a.k0();
            }

            public int m() {
                return this.f15480a.E0();
            }

            public int n() {
                return this.f15480a.v0();
            }

            public int o() {
                return (this.f15480a.j0() - this.f15480a.v0()) - this.f15480a.q0();
            }

            public int q(View view) {
                this.f15480a.C0(view, true, this.f15482c);
                return this.f15482c.bottom;
            }

            public int r(View view) {
                this.f15480a.C0(view, true, this.f15482c);
                return this.f15482c.top;
            }

            public void s(View view, int i2) {
                view.offsetTopAndBottom(i2);
            }

            public void t(int i2) {
                this.f15480a.Y0(i2);
            }
        };
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public RecyclerView.LayoutManager k() {
        return this.f15480a;
    }

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public abstract int o();

    public int p() {
        if (Integer.MIN_VALUE == this.f15481b) {
            return 0;
        }
        return o() - this.f15481b;
    }

    public abstract int q(View view);

    public abstract int r(View view);

    public abstract void s(View view, int i2);

    public abstract void t(int i2);

    public void u() {
        this.f15481b = o();
    }
}
