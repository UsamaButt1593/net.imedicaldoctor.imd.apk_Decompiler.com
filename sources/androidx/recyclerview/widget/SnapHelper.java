package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: d  reason: collision with root package name */
    static final float f15608d = 100.0f;

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f15609a;

    /* renamed from: b  reason: collision with root package name */
    private Scroller f15610b;

    /* renamed from: c  reason: collision with root package name */
    private final RecyclerView.OnScrollListener f15611c = new RecyclerView.OnScrollListener() {

        /* renamed from: a  reason: collision with root package name */
        boolean f15612a = false;

        public void a(RecyclerView recyclerView, int i2) {
            super.a(recyclerView, i2);
            if (i2 == 0 && this.f15612a) {
                this.f15612a = false;
                SnapHelper.this.l();
            }
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.f15612a = true;
            }
        }
    };

    private void g() {
        this.f15609a.E1(this.f15611c);
        this.f15609a.setOnFlingListener((RecyclerView.OnFlingListener) null);
    }

    private void j() throws IllegalStateException {
        if (this.f15609a.getOnFlingListener() == null) {
            this.f15609a.t(this.f15611c);
            this.f15609a.setOnFlingListener(this);
            return;
        }
        throw new IllegalStateException("An instance of OnFlingListener already set.");
    }

    private boolean k(@NonNull RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        RecyclerView.SmoothScroller e2;
        int i4;
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (e2 = e(layoutManager)) == null || (i4 = i(layoutManager, i2, i3)) == -1) {
            return false;
        }
        e2.q(i4);
        layoutManager.k2(e2);
        return true;
    }

    public boolean a(int i2, int i3) {
        RecyclerView.LayoutManager layoutManager = this.f15609a.getLayoutManager();
        if (layoutManager == null || this.f15609a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f15609a.getMinFlingVelocity();
        return (Math.abs(i3) > minFlingVelocity || Math.abs(i2) > minFlingVelocity) && k(layoutManager, i2, i3);
    }

    public void b(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.f15609a;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                g();
            }
            this.f15609a = recyclerView;
            if (recyclerView != null) {
                j();
                this.f15610b = new Scroller(this.f15609a.getContext(), new DecelerateInterpolator());
                l();
            }
        }
    }

    @Nullable
    public abstract int[] c(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View view);

    @SuppressLint({"UnknownNullness"})
    public int[] d(int i2, int i3) {
        this.f15610b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.f15610b.getFinalX(), this.f15610b.getFinalY()};
    }

    /* access modifiers changed from: protected */
    @Nullable
    public RecyclerView.SmoothScroller e(@NonNull RecyclerView.LayoutManager layoutManager) {
        return f(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    @Nullable
    public LinearSmoothScroller f(@NonNull RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider)) {
            return null;
        }
        return new LinearSmoothScroller(this.f15609a.getContext()) {
            /* access modifiers changed from: protected */
            public void p(View view, RecyclerView.State state, RecyclerView.SmoothScroller.Action action) {
                SnapHelper snapHelper = SnapHelper.this;
                RecyclerView recyclerView = snapHelper.f15609a;
                if (recyclerView != null) {
                    int[] c2 = snapHelper.c(recyclerView.getLayoutManager(), view);
                    int i2 = c2[0];
                    int i3 = c2[1];
                    int x2 = x(Math.max(Math.abs(i2), Math.abs(i3)));
                    if (x2 > 0) {
                        action.l(i2, i3, x2, this.f15428j);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public float w(DisplayMetrics displayMetrics) {
                return SnapHelper.f15608d / ((float) displayMetrics.densityDpi);
            }
        };
    }

    @SuppressLint({"UnknownNullness"})
    @Nullable
    public abstract View h(RecyclerView.LayoutManager layoutManager);

    @SuppressLint({"UnknownNullness"})
    public abstract int i(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    /* access modifiers changed from: package-private */
    public void l() {
        RecyclerView.LayoutManager layoutManager;
        View h2;
        RecyclerView recyclerView = this.f15609a;
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null && (h2 = h(layoutManager)) != null) {
            int[] c2 = c(layoutManager, h2);
            int i2 = c2[0];
            if (i2 != 0 || c2[1] != 0) {
                this.f15609a.T1(i2, c2[1]);
            }
        }
    }
}
