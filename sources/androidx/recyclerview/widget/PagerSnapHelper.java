package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class PagerSnapHelper extends SnapHelper {

    /* renamed from: g  reason: collision with root package name */
    private static final int f15483g = 100;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f15484e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private OrientationHelper f15485f;

    private int m(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.n() + (orientationHelper.o() / 2));
    }

    @Nullable
    private View n(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int V = layoutManager.V();
        View view = null;
        if (V == 0) {
            return null;
        }
        int n2 = orientationHelper.n() + (orientationHelper.o() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < V; i3++) {
            View U = layoutManager.U(i3);
            int abs = Math.abs((orientationHelper.g(U) + (orientationHelper.e(U) / 2)) - n2);
            if (abs < i2) {
                view = U;
                i2 = abs;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper o(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f15485f;
        if (orientationHelper == null || orientationHelper.f15480a != layoutManager) {
            this.f15485f = OrientationHelper.a(layoutManager);
        }
        return this.f15485f;
    }

    @Nullable
    private OrientationHelper p(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.t()) {
            return q(layoutManager);
        }
        if (layoutManager.s()) {
            return o(layoutManager);
        }
        return null;
    }

    @NonNull
    private OrientationHelper q(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f15484e;
        if (orientationHelper == null || orientationHelper.f15480a != layoutManager) {
            this.f15484e = OrientationHelper.c(layoutManager);
        }
        return this.f15484e;
    }

    private boolean r(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        return layoutManager.s() ? i2 > 0 : i3 > 0;
    }

    private boolean s(RecyclerView.LayoutManager layoutManager) {
        PointF a2;
        int b2 = layoutManager.b();
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (a2 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(b2 - 1)) == null) {
            return false;
        }
        return a2.x < 0.0f || a2.y < 0.0f;
    }

    @Nullable
    public int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.s()) {
            iArr[0] = m(view, o(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.t()) {
            iArr[1] = m(view, q(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public RecyclerView.SmoothScroller e(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f15609a.getContext()) {
            /* access modifiers changed from: protected */
            public void p(@NonNull View view, @NonNull RecyclerView.State state, @NonNull RecyclerView.SmoothScroller.Action action) {
                PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                int[] c2 = pagerSnapHelper.c(pagerSnapHelper.f15609a.getLayoutManager(), view);
                int i2 = c2[0];
                int i3 = c2[1];
                int x2 = x(Math.max(Math.abs(i2), Math.abs(i3)));
                if (x2 > 0) {
                    action.l(i2, i3, x2, this.f15428j);
                }
            }

            /* access modifiers changed from: protected */
            public float w(@NonNull DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            public int y(int i2) {
                return Math.min(100, super.y(i2));
            }
        };
    }

    @SuppressLint({"UnknownNullness"})
    @Nullable
    public View h(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper o;
        if (layoutManager.t()) {
            o = q(layoutManager);
        } else if (!layoutManager.s()) {
            return null;
        } else {
            o = o(layoutManager);
        }
        return n(layoutManager, o);
    }

    @SuppressLint({"UnknownNullness"})
    public int i(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        OrientationHelper p;
        int b2 = layoutManager.b();
        if (b2 == 0 || (p = p(layoutManager)) == null) {
            return -1;
        }
        int V = layoutManager.V();
        View view = null;
        View view2 = null;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        for (int i6 = 0; i6 < V; i6++) {
            View U = layoutManager.U(i6);
            if (U != null) {
                int m2 = m(U, p);
                if (m2 <= 0 && m2 > i4) {
                    view2 = U;
                    i4 = m2;
                }
                if (m2 >= 0 && m2 < i5) {
                    view = U;
                    i5 = m2;
                }
            }
        }
        boolean r = r(layoutManager, i2, i3);
        if (r && view != null) {
            return layoutManager.w0(view);
        }
        if (!r && view2 != null) {
            return layoutManager.w0(view2);
        }
        if (r) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int w0 = layoutManager.w0(view) + (s(layoutManager) == r ? -1 : 1);
        if (w0 < 0 || w0 >= b2) {
            return -1;
        }
        return w0;
    }
}
