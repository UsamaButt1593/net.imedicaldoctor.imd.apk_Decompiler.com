package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.NinePatchDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;

class DraggingItemDecorator extends BaseDraggableItemDecorator {
    private static final String v = "DraggingItemDecorator";

    /* renamed from: h  reason: collision with root package name */
    private int f25393h;

    /* renamed from: i  reason: collision with root package name */
    private int f25394i;

    /* renamed from: j  reason: collision with root package name */
    private int f25395j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f25396k;

    /* renamed from: l  reason: collision with root package name */
    private int f25397l;

    /* renamed from: m  reason: collision with root package name */
    private int f25398m;

    /* renamed from: n  reason: collision with root package name */
    private int f25399n;
    private int o;
    private NinePatchDrawable p;
    private Rect q = new Rect();
    private Rect r;
    private boolean s;
    private boolean t;
    private ItemDraggableRange u;

    public DraggingItemDecorator(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, ItemDraggableRange itemDraggableRange) {
        super(recyclerView, viewHolder);
        Rect rect = new Rect();
        this.r = rect;
        this.u = itemDraggableRange;
        CustomRecyclerViewUtils.i(this.f25380e.f15587a, rect);
    }

    private void G(int i2) {
        RecyclerView.ViewHolder viewHolder = this.f25380e;
        if (viewHolder != null) {
            BaseDraggableItemDecorator.m(this.f25379d, viewHolder, (float) (i2 - viewHolder.f15587a.getTop()));
        }
    }

    private void H() {
        int i2;
        if (this.f25379d.getChildCount() > 0) {
            this.f25397l = this.f25379d.getPaddingTop();
            this.f25398m = Math.max(0, (this.f25379d.getHeight() - this.f25379d.getPaddingBottom()) - this.f25399n);
            if (!this.t) {
                int e2 = CustomRecyclerViewUtils.e(this.f25379d);
                int g2 = CustomRecyclerViewUtils.g(this.f25379d);
                View r2 = r(this.f25379d, this.u, e2, g2);
                View s2 = s(this.f25379d, this.u, e2, g2);
                if (r2 != null) {
                    this.f25397l = Math.min(this.f25398m, r2.getTop());
                }
                if (s2 != null) {
                    i2 = Math.min(this.f25398m, s2.getTop());
                }
            }
            int i3 = this.o - this.f25393h;
            this.f25394i = i3;
            this.f25394i = Math.min(Math.max(i3, this.f25397l), this.f25398m);
        }
        i2 = this.f25379d.getPaddingTop();
        this.f25397l = i2;
        this.f25398m = i2;
        int i32 = this.o - this.f25393h;
        this.f25394i = i32;
        this.f25394i = Math.min(Math.max(i32, this.f25397l), this.f25398m);
    }

    private Bitmap q(View view, NinePatchDrawable ninePatchDrawable) {
        int width = view.getWidth();
        Rect rect = this.q;
        int i2 = width + rect.left + rect.right;
        int height = view.getHeight();
        Rect rect2 = this.q;
        int i3 = height + rect2.top + rect2.bottom;
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (ninePatchDrawable != null) {
            ninePatchDrawable.setBounds(0, 0, i2, i3);
            ninePatchDrawable.draw(canvas);
        }
        int save = canvas.save(3);
        Rect rect3 = this.q;
        canvas.clipRect(rect3.left, rect3.top, i2 - rect3.right, i3 - rect3.bottom);
        Rect rect4 = this.q;
        canvas.translate((float) rect4.left, (float) rect4.top);
        view.draw(canvas);
        canvas.restoreToCount(save);
        return createBitmap;
    }

    private static View r(RecyclerView recyclerView, ItemDraggableRange itemDraggableRange, int i2, int i3) {
        int G;
        if (i2 == -1 || i3 == -1) {
            return null;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            RecyclerView.ViewHolder y0 = recyclerView.y0(childAt);
            if (y0 != null && (G = y0.G()) >= i2 && G <= i3 && itemDraggableRange.a(G)) {
                return childAt;
            }
        }
        return null;
    }

    private static View s(RecyclerView recyclerView, ItemDraggableRange itemDraggableRange, int i2, int i3) {
        int G;
        if (i2 == -1 || i3 == -1) {
            return null;
        }
        for (int childCount = recyclerView.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = recyclerView.getChildAt(childCount);
            RecyclerView.ViewHolder y0 = recyclerView.y0(childAt);
            if (y0 != null && (G = y0.G()) >= i2 && G <= i3 && itemDraggableRange.a(G)) {
                return childAt;
            }
        }
        return null;
    }

    public void A() {
        H();
        G(this.f25394i);
        ViewCompat.t1(this.f25379d);
    }

    public void B(RecyclerView.ViewHolder viewHolder) {
        if (this.f25380e == null) {
            this.f25380e = viewHolder;
            viewHolder.f15587a.setVisibility(4);
            return;
        }
        throw new IllegalStateException("A new view holder is attempt to be assigned before invalidating the older one");
    }

    public void C(boolean z) {
        if (this.t != z) {
            this.t = z;
        }
    }

    public void D(NinePatchDrawable ninePatchDrawable) {
        this.p = ninePatchDrawable;
        if (ninePatchDrawable != null) {
            ninePatchDrawable.getPadding(this.q);
        }
    }

    public void E(MotionEvent motionEvent, float f2) {
        if (!this.s) {
            View view = this.f25380e.f15587a;
            this.f25393h = (int) (f2 + 0.5f);
            this.f25396k = q(view, this.p);
            this.f25399n = view.getHeight();
            this.f25397l = this.f25379d.getPaddingTop();
            this.f25395j = this.f25379d.getPaddingLeft();
            view.setVisibility(4);
            F(motionEvent);
            this.f25379d.p(this);
            this.s = true;
        }
    }

    public void F(MotionEvent motionEvent) {
        this.o = (int) (motionEvent.getY() + 0.5f);
        A();
    }

    public void k(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Bitmap bitmap = this.f25396k;
        if (bitmap != null) {
            int i2 = this.f25395j + this.r.left;
            Rect rect = this.q;
            canvas.drawBitmap(bitmap, (float) (i2 - rect.left), (float) (this.f25394i - rect.top), (Paint) null);
        }
    }

    public void t(boolean z) {
        if (this.s) {
            this.f25379d.A1(this);
        }
        RecyclerView.ItemAnimator itemAnimator = this.f25379d.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.l();
        }
        this.f25379d.b2();
        G(this.f25394i);
        RecyclerView.ViewHolder viewHolder = this.f25380e;
        if (viewHolder != null) {
            l(viewHolder.f15587a, z);
        }
        RecyclerView.ViewHolder viewHolder2 = this.f25380e;
        if (viewHolder2 != null) {
            viewHolder2.f15587a.setVisibility(0);
        }
        this.f25380e = null;
        Bitmap bitmap = this.f25396k;
        if (bitmap != null) {
            bitmap.recycle();
            this.f25396k = null;
        }
        this.u = null;
        this.f25393h = 0;
        this.f25394i = 0;
        this.f25397l = 0;
        this.f25398m = 0;
        this.f25395j = 0;
        this.f25399n = 0;
        this.o = 0;
        this.s = false;
    }

    public int u() {
        return this.f25394i;
    }

    public int v() {
        return this.f25394i + this.f25399n;
    }

    public int w() {
        return this.f25394i;
    }

    public void x() {
        RecyclerView.ViewHolder viewHolder = this.f25380e;
        if (viewHolder != null) {
            viewHolder.f15587a.setVisibility(0);
        }
        this.f25380e = null;
    }

    public boolean y() {
        return this.f25394i == this.f25398m;
    }

    public boolean z() {
        return this.f25394i == this.f25397l;
    }
}
