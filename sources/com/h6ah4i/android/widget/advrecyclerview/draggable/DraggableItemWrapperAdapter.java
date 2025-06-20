package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.h6ah4i.android.widget.advrecyclerview.swipeable.SwipeableItemAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.BaseWrapperAdapter;
import com.h6ah4i.android.widget.advrecyclerview.utils.WrapperAdapterUtils;

class DraggableItemWrapperAdapter<VH extends RecyclerView.ViewHolder> extends BaseWrapperAdapter<VH> implements SwipeableItemAdapter<VH> {
    private static final String o = "ARVDraggableWrapper";
    private static final int p = -1;
    private static final boolean q = false;
    private static final boolean r = false;
    private static final boolean s = true;
    private static final boolean t = false;

    /* renamed from: h  reason: collision with root package name */
    private RecyclerViewDragDropManager f25386h;

    /* renamed from: i  reason: collision with root package name */
    private DraggableItemAdapter f25387i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.ViewHolder f25388j;

    /* renamed from: k  reason: collision with root package name */
    private ItemDraggableRange f25389k;

    /* renamed from: l  reason: collision with root package name */
    private long f25390l = -1;

    /* renamed from: m  reason: collision with root package name */
    private int f25391m = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f25392n = -1;

    public DraggableItemWrapperAdapter(RecyclerViewDragDropManager recyclerViewDragDropManager, RecyclerView.Adapter<VH> adapter) {
        super(adapter);
        this.f25387i = t0(adapter);
        if (t0(adapter) == null) {
            throw new IllegalArgumentException("adapter does not implement DraggableItemAdapter");
        } else if (recyclerViewDragDropManager != null) {
            this.f25386h = recyclerViewDragDropManager;
        } else {
            throw new IllegalArgumentException("manager cannot be null");
        }
    }

    private static void C0(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof DraggableItemViewHolder) {
            DraggableItemViewHolder draggableItemViewHolder = (DraggableItemViewHolder) viewHolder;
            int d2 = draggableItemViewHolder.d();
            if (d2 == -1 || ((d2 ^ i2) & Integer.MAX_VALUE) != 0) {
                i2 |= Integer.MIN_VALUE;
            }
            draggableItemViewHolder.i(i2);
        }
    }

    private boolean D0() {
        return y0();
    }

    private void r0() {
        RecyclerViewDragDropManager recyclerViewDragDropManager = this.f25386h;
        if (recyclerViewDragDropManager != null) {
            recyclerViewDragDropManager.j();
        }
    }

    protected static int s0(int i2, int i3, int i4) {
        if (i3 < 0 || i4 < 0 || i3 == i4) {
            return i2;
        }
        if (i2 < i3 && i2 < i4) {
            return i2;
        }
        if (i2 <= i3 || i2 <= i4) {
            return i4 < i3 ? i2 == i4 ? i3 : i2 - 1 : i2 == i4 ? i3 : i2 + 1;
        }
        return i2;
    }

    private static DraggableItemAdapter t0(RecyclerView.Adapter adapter) {
        return (DraggableItemAdapter) WrapperAdapterUtils.a(adapter, DraggableItemAdapter.class);
    }

    private int x0(int i2) {
        return y0() ? s0(i2, this.f25391m, this.f25392n) : i2;
    }

    /* access modifiers changed from: package-private */
    public void A0(RecyclerView.ViewHolder viewHolder, boolean z) {
        if (viewHolder == null || viewHolder == this.f25388j) {
            if (z && this.f25392n != this.f25391m) {
                ((DraggableItemAdapter) WrapperAdapterUtils.a(d0(), DraggableItemAdapter.class)).h(this.f25391m, this.f25392n);
            }
            this.f25391m = -1;
            this.f25392n = -1;
            this.f25389k = null;
            this.f25390l = -1;
            this.f25388j = null;
            G();
            return;
        }
        throw new IllegalStateException("onDragItemFinished() - may be a bug (mDraggingItem != holder)");
    }

    public long B(int i2) {
        return y0() ? super.B(s0(i2, this.f25391m, this.f25392n)) : super.B(i2);
    }

    /* access modifiers changed from: package-private */
    public void B0(RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange) {
        if (viewHolder.E() != -1) {
            int B = viewHolder.B();
            this.f25391m = B;
            this.f25392n = B;
            this.f25388j = viewHolder;
            this.f25390l = viewHolder.E();
            this.f25389k = itemDraggableRange;
            G();
            return;
        }
        throw new IllegalStateException("dragging target must provides valid ID");
    }

    public int C(int i2) {
        return y0() ? super.C(s0(i2, this.f25391m, this.f25392n)) : super.C(i2);
    }

    public void R(VH vh, int i2) {
        VH vh2;
        if (y0()) {
            long E = vh.E();
            int s0 = s0(i2, this.f25391m, this.f25392n);
            if (E == this.f25390l && vh != (vh2 = this.f25388j)) {
                if (vh2 == null) {
                    Log.i(o, "a new view holder object for the currently dragging item is assigned");
                    this.f25388j = vh;
                    this.f25386h.I(vh);
                } else {
                    Log.e(o, "an another view holder object for the currently dragging item is assigned");
                }
            }
            int i3 = E == this.f25390l ? 3 : 1;
            if (this.f25389k.a(i2)) {
                i3 |= 4;
            }
            C0(vh, i3);
            super.R(vh, s0);
            return;
        }
        C0(vh, 0);
        super.R(vh, i2);
    }

    public VH T(ViewGroup viewGroup, int i2) {
        VH T = super.T(viewGroup, i2);
        if (T instanceof DraggableItemViewHolder) {
            ((DraggableItemViewHolder) T).i(-1);
        }
        return T;
    }

    public void Y(VH vh) {
        if (y0() && vh == this.f25388j) {
            Log.i(o, "a view holder object which is bound to currently dragging item is recycled");
            this.f25388j = null;
            this.f25386h.G();
        }
        super.Y(vh);
    }

    public int c(VH vh, int i2, int i3) {
        RecyclerView.Adapter d0 = d0();
        if (!(d0 instanceof SwipeableItemAdapter)) {
            return 0;
        }
        return ((SwipeableItemAdapter) d0).c(vh, x0(i2), i3);
    }

    /* access modifiers changed from: protected */
    public void e0() {
        if (D0()) {
            r0();
        } else {
            super.e0();
        }
    }

    /* access modifiers changed from: protected */
    public void f0(int i2, int i3) {
        if (D0()) {
            r0();
        } else {
            super.f0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void g0(int i2, int i3) {
        if (D0()) {
            r0();
        } else {
            super.g0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void h0(int i2, int i3) {
        if (D0()) {
            r0();
        } else {
            super.h0(i2, i3);
        }
    }

    /* access modifiers changed from: protected */
    public void i0(int i2, int i3, int i4) {
        if (D0()) {
            r0();
        } else {
            super.i0(i2, i3, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void j0() {
        super.j0();
        this.f25388j = null;
        this.f25387i = null;
        this.f25386h = null;
    }

    public void l(VH vh, int i2, int i3) {
        RecyclerView.Adapter d0 = d0();
        if (d0 instanceof SwipeableItemAdapter) {
            ((SwipeableItemAdapter) d0).l(vh, x0(i2), i3);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean q0(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4) {
        return this.f25387i.k(viewHolder, i2, i3, i4);
    }

    public int s(VH vh, int i2, int i3, int i4) {
        RecyclerView.Adapter d0 = d0();
        if (!(d0 instanceof SwipeableItemAdapter)) {
            return 0;
        }
        return ((SwipeableItemAdapter) d0).s(vh, x0(i2), i3, i4);
    }

    public void t(VH vh, int i2, int i3, int i4) {
        RecyclerView.Adapter d0 = d0();
        if (d0 instanceof SwipeableItemAdapter) {
            ((SwipeableItemAdapter) d0).t(vh, x0(i2), i3, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public int u0() {
        return this.f25392n;
    }

    /* access modifiers changed from: package-private */
    public int v0() {
        return this.f25391m;
    }

    /* access modifiers changed from: package-private */
    public ItemDraggableRange w0(RecyclerView.ViewHolder viewHolder, int i2) {
        return this.f25387i.w(viewHolder, i2);
    }

    /* access modifiers changed from: protected */
    public boolean y0() {
        return this.f25386h.C();
    }

    /* access modifiers changed from: package-private */
    public void z0(int i2, int i3) {
        int s0 = s0(i2, this.f25391m, this.f25392n);
        if (s0 == this.f25391m) {
            this.f25392n = i3;
            K(i2, i3);
            return;
        }
        throw new IllegalStateException("onMoveItem() - may be a bug or has duplicate IDs  --- mDraggingItemInitialPosition = " + this.f25391m + ", " + "mDraggingItemCurrentPosition = " + this.f25392n + ", " + "origFromPosition = " + s0 + ", " + "fromPosition = " + i2 + ", " + "toPosition = " + i3);
    }
}
