package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.utils.BaseWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

class SwipeableItemWrapperAdapter<VH extends RecyclerView.ViewHolder> extends BaseWrapperAdapter<VH> {

    /* renamed from: k  reason: collision with root package name */
    private static final String f25524k = "ARVSwipeableWrapper";

    /* renamed from: l  reason: collision with root package name */
    private static final int f25525l = -1;

    /* renamed from: m  reason: collision with root package name */
    private static final boolean f25526m = false;

    /* renamed from: n  reason: collision with root package name */
    private static final boolean f25527n = false;

    /* renamed from: h  reason: collision with root package name */
    private SwipeableItemAdapter f25528h;

    /* renamed from: i  reason: collision with root package name */
    private RecyclerViewSwipeManager f25529i;

    /* renamed from: j  reason: collision with root package name */
    private int f25530j = -1;

    public SwipeableItemWrapperAdapter(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        SwipeableItemAdapter t0 = t0(adapter);
        this.f25528h = t0;
        if (t0 == null) {
            throw new IllegalArgumentException("adapter does not implement SwipeableItemAdapter");
        } else if (recyclerViewSwipeManager != null) {
            this.f25529i = recyclerViewSwipeManager;
        } else {
            throw new IllegalArgumentException("manager cannot be null");
        }
    }

    private void q0() {
        RecyclerViewSwipeManager recyclerViewSwipeManager = this.f25529i;
        if (recyclerViewSwipeManager != null) {
            recyclerViewSwipeManager.d();
        }
    }

    private static float r0(int i2, int i3) {
        if (i3 == 1 || i3 == 2) {
            return i2 == 2 ? -3.4028235E38f : Float.MAX_VALUE;
        }
        return 0.0f;
    }

    private static SwipeableItemAdapter t0(RecyclerView.Adapter adapter) {
        return (SwipeableItemAdapter) WrapperAdapterUtils.a(adapter, SwipeableItemAdapter.class);
    }

    private static void y0(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
            int p = swipeableItemViewHolder.p();
            if (p == -1 || ((p ^ i2) & Integer.MAX_VALUE) != 0) {
                i2 |= Integer.MIN_VALUE;
            }
            swipeableItemViewHolder.c(i2);
        }
    }

    public void R(VH vh, int i2) {
        boolean z = vh instanceof SwipeableItemViewHolder;
        float k2 = z ? ((SwipeableItemViewHolder) vh).k() : 0.0f;
        y0(vh, u0() ? i2 == this.f25530j ? 3 : 1 : 0);
        super.R(vh, i2);
        if (z) {
            float k3 = ((SwipeableItemViewHolder) vh).k();
            if (k2 != k3 || (!this.f25529i.t() && !this.f25529i.r(vh))) {
                this.f25529i.a(vh, i2, k2, k3, true);
            }
        }
    }

    public VH T(ViewGroup viewGroup, int i2) {
        VH T = super.T(viewGroup, i2);
        if (T instanceof SwipeableItemViewHolder) {
            ((SwipeableItemViewHolder) T).c(-1);
        }
        return T;
    }

    public void Y(VH vh) {
        super.Y(vh);
        if (vh instanceof SwipeableItemViewHolder) {
            this.f25529i.c(vh);
            SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) vh;
            swipeableItemViewHolder.g(0.0f);
            View e2 = swipeableItemViewHolder.e();
            if (e2 != null) {
                ViewCompat.g(e2).d();
                ViewCompat.E2(e2, 0.0f);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void e0() {
        if (u0()) {
            q0();
        } else {
            super.e0();
        }
    }

    /* access modifiers changed from: protected */
    public void f0(int i2, int i3) {
        if (u0()) {
            q0();
        } else {
            super.f0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void g0(int i2, int i3) {
        if (u0()) {
            q0();
        } else {
            super.g0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void h0(int i2, int i3) {
        if (u0()) {
            q0();
        } else {
            super.h0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void i0(int i2, int i3, int i4) {
        if (u0()) {
            q0();
        } else {
            super.i0(i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
        super.j0();
        this.f25528h = null;
        this.f25529i = null;
        this.f25530j = -1;
    }

    /* access modifiers changed from: package-private */
    public int s0(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        return this.f25528h.s(viewHolder, i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public boolean u0() {
        return this.f25530j != -1;
    }

    /* access modifiers changed from: package-private */
    public int v0(RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        this.f25530j = -1;
        return this.f25528h.c(viewHolder, i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void w0(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        SwipeableItemViewHolder swipeableItemViewHolder = (SwipeableItemViewHolder) viewHolder;
        swipeableItemViewHolder.h(i3);
        swipeableItemViewHolder.o(i4);
        swipeableItemViewHolder.g(r0(i3, i4));
        this.f25528h.t(viewHolder, i2, i3, i4);
        G();
    }

    /* access modifiers changed from: package-private */
    public void x0(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.ViewHolder viewHolder, int i2) {
        this.f25530j = i2;
        G();
    }

    /* access modifiers changed from: package-private */
    public void z0(RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        this.f25528h.l(viewHolder, i2, i3);
    }
}
