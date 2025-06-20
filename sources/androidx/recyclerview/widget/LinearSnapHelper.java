package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class LinearSnapHelper extends SnapHelper {

    /* renamed from: g  reason: collision with root package name */
    private static final float f15433g = 1.0f;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private OrientationHelper f15434e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private OrientationHelper f15435f;

    private float m(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int max;
        int V = layoutManager.V();
        if (V == 0) {
            return 1.0f;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < V; i4++) {
            View U = layoutManager.U(i4);
            int w0 = layoutManager.w0(U);
            if (w0 != -1) {
                if (w0 < i2) {
                    view = U;
                    i2 = w0;
                }
                if (w0 > i3) {
                    view2 = U;
                    i3 = w0;
                }
            }
        }
        if (view == null || view2 == null || (max = Math.max(orientationHelper.d(view), orientationHelper.d(view2)) - Math.min(orientationHelper.g(view), orientationHelper.g(view2))) == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i3 - i2) + 1));
    }

    private int n(@NonNull View view, OrientationHelper orientationHelper) {
        return (orientationHelper.g(view) + (orientationHelper.e(view) / 2)) - (orientationHelper.n() + (orientationHelper.o() / 2));
    }

    private int o(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i2, int i3) {
        int[] d2 = d(i2, i3);
        float m2 = m(layoutManager, orientationHelper);
        if (m2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(d2[0]) > Math.abs(d2[1]) ? d2[0] : d2[1])) / m2);
    }

    @Nullable
    private View p(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
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
    private OrientationHelper q(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f15435f;
        if (orientationHelper == null || orientationHelper.f15480a != layoutManager) {
            this.f15435f = OrientationHelper.a(layoutManager);
        }
        return this.f15435f;
    }

    @NonNull
    private OrientationHelper r(@NonNull RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f15434e;
        if (orientationHelper == null || orientationHelper.f15480a != layoutManager) {
            this.f15434e = OrientationHelper.c(layoutManager);
        }
        return this.f15434e;
    }

    public int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.s()) {
            iArr[0] = n(view, q(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.t()) {
            iArr[1] = n(view, r(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    public View h(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper q;
        if (layoutManager.t()) {
            q = r(layoutManager);
        } else if (!layoutManager.s()) {
            return null;
        } else {
            q = q(layoutManager);
        }
        return p(layoutManager, q);
    }

    public int i(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int b2;
        View h2;
        int w0;
        int i4;
        PointF a2;
        int i5;
        int i6;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (b2 = layoutManager.b()) == 0 || (h2 = h(layoutManager)) == null || (w0 = layoutManager.w0(h2)) == -1 || (a2 = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(i4)) == null) {
            return -1;
        }
        int i7 = 0;
        if (layoutManager.s()) {
            i5 = o(layoutManager, q(layoutManager), i2, 0);
            if (a2.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (layoutManager.t()) {
            i6 = o(layoutManager, r(layoutManager), 0, i3);
            if (a2.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (layoutManager.t()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i8 = w0 + i5;
        if (i8 >= 0) {
            i7 = i8;
        }
        return i7 >= b2 ? b2 - 1 : i7;
    }
}
