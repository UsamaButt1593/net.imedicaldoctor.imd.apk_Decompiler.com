package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

class SwapTargetItemOperator extends BaseDraggableItemDecorator {
    private static final String u = "SwapTargetItemOperator";

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView.ViewHolder f25426h;

    /* renamed from: i  reason: collision with root package name */
    private Interpolator f25427i;

    /* renamed from: j  reason: collision with root package name */
    private int f25428j;

    /* renamed from: k  reason: collision with root package name */
    private int f25429k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f25430l = new Rect();

    /* renamed from: m  reason: collision with root package name */
    private Rect f25431m = new Rect();

    /* renamed from: n  reason: collision with root package name */
    private Rect f25432n = new Rect();
    private Rect o = new Rect();
    private boolean p;
    private float q;
    private float r;
    private long s = this.f25380e.E();
    private ItemDraggableRange t;

    public SwapTargetItemOperator(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange) {
        super(recyclerView, viewHolder);
        this.t = itemDraggableRange;
        CustomRecyclerViewUtils.i(this.f25380e.f15587a, this.f25432n);
        CustomRecyclerViewUtils.h(this.f25379d.getLayoutManager(), this.f25380e.f15587a, this.o);
    }

    private static float q(float f2, float f3) {
        float f4 = (f2 * 0.7f) + (0.3f * f3);
        return Math.abs(f4 - f3) < 0.01f ? f3 : f4;
    }

    private float r(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        View view = viewHolder2.f15587a;
        int G = viewHolder.G();
        int G2 = viewHolder2.G();
        CustomRecyclerViewUtils.h(this.f25379d.getLayoutManager(), view, this.f25430l);
        CustomRecyclerViewUtils.i(view, this.f25431m);
        Rect rect = this.f25431m;
        Rect rect2 = this.f25430l;
        int height = view.getHeight() + rect.top + rect.bottom + rect2.top + rect2.bottom;
        float top = height != 0 ? ((float) (viewHolder.f15587a.getTop() - this.f25428j)) / ((float) height) : 0.0f;
        if (G <= G2) {
            top += 1.0f;
        }
        return Math.min(Math.max(top, 0.0f), 1.0f);
    }

    private void w(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, float f2) {
        View view = viewHolder2.f15587a;
        int G = viewHolder.G();
        int G2 = viewHolder2.G();
        Rect rect = this.f25432n;
        Rect rect2 = this.o;
        int i2 = this.f25429k + rect.top + rect.bottom + rect2.top + rect2.bottom;
        Interpolator interpolator = this.f25427i;
        if (interpolator != null) {
            f2 = interpolator.getInterpolation(f2);
        }
        if (G <= G2) {
            f2 -= 1.0f;
        }
        ViewCompat.F2(view, f2 * ((float) i2));
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.ViewHolder viewHolder = this.f25380e;
        if (viewHolder != null) {
            long E = viewHolder.E();
            long j2 = this.s;
            if (E == j2) {
                RecyclerView.ViewHolder p2 = RecyclerViewDragDropManager.p(this.f25379d, viewHolder, j2, this.f25428j, this.t);
                RecyclerView.ViewHolder viewHolder2 = this.f25426h;
                if (!(viewHolder2 == p2 || viewHolder2 == null)) {
                    BaseDraggableItemDecorator.m(this.f25379d, viewHolder2, 0.0f);
                }
                if (p2 != null) {
                    float r2 = r(viewHolder, p2);
                    this.q = r2;
                    if (this.f25426h == p2) {
                        r2 = q(this.r, r2);
                    }
                    this.r = r2;
                    w(viewHolder, p2, this.r);
                }
                this.f25426h = p2;
            }
        }
    }

    public void s(boolean z) {
        if (this.p) {
            this.f25379d.A1(this);
        }
        RecyclerView.ItemAnimator itemAnimator = this.f25379d.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.l();
        }
        this.f25379d.b2();
        RecyclerView.ViewHolder viewHolder = this.f25426h;
        if (viewHolder != null) {
            w(this.f25380e, viewHolder, this.r);
            l(this.f25426h.f15587a, z);
            this.f25426h = null;
        }
        this.t = null;
        this.f25380e = null;
        this.f25428j = 0;
        this.f25429k = 0;
        this.r = 0.0f;
        this.q = 0.0f;
        this.p = false;
    }

    public void t(Interpolator interpolator) {
        this.f25427i = interpolator;
    }

    public void u() {
        if (!this.p) {
            this.f25429k = this.f25380e.f15587a.getHeight();
            this.f25379d.q(this, 0);
            this.p = true;
        }
    }

    public void v(int i2) {
        this.f25428j = i2;
    }
}
