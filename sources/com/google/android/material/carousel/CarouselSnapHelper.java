package com.google.android.material.carousel;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

public class CarouselSnapHelper extends SnapHelper {

    /* renamed from: g  reason: collision with root package name */
    private static final float f20939g = 100.0f;

    /* renamed from: h  reason: collision with root package name */
    private static final float f20940h = 50.0f;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20941e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f20942f;

    public CarouselSnapHelper() {
        this(true);
    }

    /* access modifiers changed from: private */
    public int[] o(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view, boolean z) {
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        int p = p(view, (CarouselLayoutManager) layoutManager, z);
        if (layoutManager.s()) {
            return new int[]{p, 0};
        }
        return layoutManager.t() ? new int[]{0, p} : new int[]{0, 0};
    }

    private int p(@NonNull View view, CarouselLayoutManager carouselLayoutManager, boolean z) {
        return carouselLayoutManager.S2(carouselLayoutManager.w0(view), z);
    }

    @Nullable
    private View q(RecyclerView.LayoutManager layoutManager) {
        int V = layoutManager.V();
        View view = null;
        if (V != 0 && (layoutManager instanceof CarouselLayoutManager)) {
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < V; i3++) {
                View U = layoutManager.U(i3);
                int abs = Math.abs(carouselLayoutManager.S2(layoutManager.w0(U), false));
                if (abs < i2) {
                    view = U;
                    i2 = abs;
                }
            }
        }
        return view;
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

    public void b(@Nullable RecyclerView recyclerView) {
        super.b(recyclerView);
        this.f20942f = recyclerView;
    }

    @Nullable
    public int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view) {
        return o(layoutManager, view, false);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public RecyclerView.SmoothScroller e(@NonNull final RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f20942f.getContext()) {
                /* access modifiers changed from: protected */
                public void p(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                    if (CarouselSnapHelper.this.f20942f != null) {
                        CarouselSnapHelper carouselSnapHelper = CarouselSnapHelper.this;
                        int[] n2 = carouselSnapHelper.o(carouselSnapHelper.f20942f.getLayoutManager(), view, true);
                        int i2 = n2[0];
                        int i3 = n2[1];
                        int x2 = x(Math.max(Math.abs(i2), Math.abs(i3)));
                        if (x2 > 0) {
                            action.l(i2, i3, x2, this.f15428j);
                        }
                    }
                }

                /* access modifiers changed from: protected */
                public float w(DisplayMetrics displayMetrics) {
                    boolean t = layoutManager.t();
                    return (t ? 50.0f : CarouselSnapHelper.f20939g) / ((float) displayMetrics.densityDpi);
                }
            };
        }
        return null;
    }

    @Nullable
    public View h(RecyclerView.LayoutManager layoutManager) {
        return q(layoutManager);
    }

    public int i(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int b2;
        if (!this.f20941e || (b2 = layoutManager.b()) == 0) {
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
                int p = p(U, (CarouselLayoutManager) layoutManager, false);
                if (p <= 0 && p > i4) {
                    view2 = U;
                    i4 = p;
                }
                if (p >= 0 && p < i5) {
                    view = U;
                    i5 = p;
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

    public CarouselSnapHelper(boolean z) {
        this.f20941e = z;
    }
}
