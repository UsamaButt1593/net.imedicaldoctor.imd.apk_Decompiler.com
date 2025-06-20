package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Canvas;
import androidx.core.view.ViewCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.recyclerview.widget.RecyclerView;

public class EdgeEffectDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f25400a;

    /* renamed from: b  reason: collision with root package name */
    private EdgeEffectCompat f25401b;

    /* renamed from: c  reason: collision with root package name */
    private EdgeEffectCompat f25402c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25403d;

    public EdgeEffectDecorator(RecyclerView recyclerView) {
        this.f25400a = recyclerView;
    }

    private void l(RecyclerView recyclerView) {
        if (this.f25402c == null) {
            this.f25402c = new EdgeEffectCompat(recyclerView.getContext());
        }
        u(recyclerView, this.f25402c);
    }

    private void m(RecyclerView recyclerView) {
        if (this.f25401b == null) {
            this.f25401b = new EdgeEffectCompat(recyclerView.getContext());
        }
        u(recyclerView, this.f25401b);
    }

    private static boolean o(RecyclerView recyclerView) {
        return recyclerView.getLayoutManager().Z();
    }

    private static void u(RecyclerView recyclerView, EdgeEffectCompat edgeEffectCompat) {
        int measuredWidth = recyclerView.getMeasuredWidth();
        int measuredHeight = recyclerView.getMeasuredHeight();
        if (o(recyclerView)) {
            measuredWidth -= recyclerView.getPaddingLeft() - recyclerView.getPaddingRight();
            measuredHeight -= recyclerView.getPaddingTop() - recyclerView.getPaddingBottom();
        }
        edgeEffectCompat.l(Math.max(0, measuredWidth), Math.max(0, measuredHeight));
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean z;
        float f2;
        int i2;
        EdgeEffectCompat edgeEffectCompat = this.f25401b;
        if (edgeEffectCompat == null || edgeEffectCompat.e()) {
            z = false;
        } else {
            int save = canvas.save();
            if (o(recyclerView)) {
                canvas.translate((float) recyclerView.getPaddingLeft(), (float) recyclerView.getPaddingTop());
            }
            z = this.f25401b.b(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffectCompat edgeEffectCompat2 = this.f25402c;
        if (edgeEffectCompat2 != null && !edgeEffectCompat2.e()) {
            int save2 = canvas.save();
            canvas.rotate(180.0f);
            if (o(recyclerView)) {
                f2 = (float) ((-recyclerView.getWidth()) + recyclerView.getPaddingRight());
                i2 = (-recyclerView.getHeight()) + recyclerView.getPaddingBottom();
            } else {
                f2 = (float) (-recyclerView.getWidth());
                i2 = -recyclerView.getHeight();
            }
            canvas.translate(f2, (float) i2);
            z |= this.f25402c.b(canvas);
            canvas.restoreToCount(save2);
        }
        if (z) {
            ViewCompat.t1(recyclerView);
        }
    }

    public void n() {
        if (this.f25403d) {
            this.f25400a.A1(this);
        }
        r();
        this.f25400a = null;
        this.f25403d = false;
    }

    public void p(float f2) {
        l(this.f25400a);
        if (this.f25402c.i(f2, 0.5f)) {
            ViewCompat.t1(this.f25400a);
        }
    }

    public void q(float f2) {
        m(this.f25400a);
        if (this.f25401b.i(f2, 0.5f)) {
            ViewCompat.t1(this.f25400a);
        }
    }

    public void r() {
        EdgeEffectCompat edgeEffectCompat = this.f25401b;
        boolean k2 = edgeEffectCompat != null ? edgeEffectCompat.k() : false;
        EdgeEffectCompat edgeEffectCompat2 = this.f25402c;
        if (edgeEffectCompat2 != null) {
            k2 |= edgeEffectCompat2.k();
        }
        if (k2) {
            ViewCompat.t1(this.f25400a);
        }
    }

    public void s() {
        if (this.f25403d) {
            this.f25400a.A1(this);
            this.f25400a.p(this);
        }
    }

    public void t() {
        if (!this.f25403d) {
            this.f25400a.p(this);
            this.f25403d = true;
        }
    }
}
