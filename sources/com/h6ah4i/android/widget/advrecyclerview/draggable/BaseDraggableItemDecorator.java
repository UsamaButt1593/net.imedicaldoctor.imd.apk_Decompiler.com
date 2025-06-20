package com.h6ah4i.android.widget.advrecyclerview.draggable;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;

abstract class BaseDraggableItemDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: f  reason: collision with root package name */
    private static final int f25374f = 2;

    /* renamed from: g  reason: collision with root package name */
    private static final int f25375g = 20;

    /* renamed from: a  reason: collision with root package name */
    private int f25376a = 200;

    /* renamed from: b  reason: collision with root package name */
    private int f25377b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f25378c;

    /* renamed from: d  reason: collision with root package name */
    protected RecyclerView f25379d;

    /* renamed from: e  reason: collision with root package name */
    protected RecyclerView.ViewHolder f25380e;

    public BaseDraggableItemDecorator(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        this.f25379d = recyclerView;
        this.f25380e = viewHolder;
        this.f25377b = (int) ((recyclerView.getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
    }

    protected static void m(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f2) {
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.k(viewHolder);
        }
        ViewCompat.F2(viewHolder.f15587a, f2);
    }

    private static boolean p() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void l(View view, boolean z) {
        int C0 = (int) ViewCompat.C0(view);
        int height = view.getHeight() / 2;
        float min = 1.0f - Math.min(height > 0 ? Math.abs(((float) C0) / ((float) height)) : 0.0f, 1.0f);
        int i2 = (int) ((((float) this.f25376a) * (1.0f - (min * min))) + 0.5f);
        if (!p() || !z || i2 <= 20 || Math.abs(C0) <= this.f25377b) {
            ViewCompat.F2(view, 0.0f);
            return;
        }
        final ViewPropertyAnimatorCompat g2 = ViewCompat.g(view);
        g2.d();
        g2.s((long) i2);
        g2.t(this.f25378c);
        g2.B(0.0f);
        g2.u(new ViewPropertyAnimatorListener() {
            public void a(View view) {
            }

            public void b(View view) {
                g2.u((ViewPropertyAnimatorListener) null);
                ViewCompat.F2(view, 0.0f);
                if (view.getParent() instanceof RecyclerView) {
                    ViewCompat.t1((RecyclerView) view.getParent());
                }
            }

            public void c(View view) {
            }
        });
        g2.y();
    }

    public void n(int i2) {
        this.f25376a = i2;
    }

    public void o(Interpolator interpolator) {
        this.f25378c = interpolator;
    }
}
