package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;

class SwipingItemOperator {

    /* renamed from: l  reason: collision with root package name */
    private static final String f25531l = "SwipingItemOperator";

    /* renamed from: m  reason: collision with root package name */
    private static final int f25532m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f25533n = 1;
    private static final int o = 2;
    private static final float p = 0.15f;
    private static final int q = 48;
    private static final Interpolator r = new RubberBandInterpolator(p);

    /* renamed from: a  reason: collision with root package name */
    private RecyclerViewSwipeManager f25534a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.ViewHolder f25535b;

    /* renamed from: c  reason: collision with root package name */
    private int f25536c;

    /* renamed from: d  reason: collision with root package name */
    private View f25537d;

    /* renamed from: e  reason: collision with root package name */
    private int f25538e;

    /* renamed from: f  reason: collision with root package name */
    private int f25539f;

    /* renamed from: g  reason: collision with root package name */
    private int f25540g;

    /* renamed from: h  reason: collision with root package name */
    private float f25541h;

    /* renamed from: i  reason: collision with root package name */
    private int f25542i;

    /* renamed from: j  reason: collision with root package name */
    private float f25543j;

    /* renamed from: k  reason: collision with root package name */
    private int f25544k;

    public SwipingItemOperator(RecyclerViewSwipeManager recyclerViewSwipeManager, RecyclerView.ViewHolder viewHolder, int i2, int i3) {
        this.f25534a = recyclerViewSwipeManager;
        this.f25535b = viewHolder;
        this.f25536c = i2;
        this.f25538e = SwipeReactionUtils.c(i3);
        this.f25539f = SwipeReactionUtils.d(i3);
        View e2 = ((SwipeableItemViewHolder) viewHolder).e();
        this.f25537d = e2;
        int width = e2.getWidth();
        this.f25540g = width;
        this.f25541h = width != 0 ? 1.0f / ((float) width) : 0.0f;
    }

    public void a() {
        this.f25534a = null;
        this.f25535b = null;
        this.f25542i = 0;
        this.f25540g = 0;
        this.f25541h = 0.0f;
        this.f25538e = 0;
        this.f25539f = 0;
        this.f25543j = 0.0f;
        this.f25544k = 0;
        this.f25537d = null;
    }

    public void b() {
        int max = Math.max(0, this.f25540g - ((int) (this.f25535b.f15587a.getResources().getDisplayMetrics().density * 48.0f)));
        int k2 = this.f25534a.k(this.f25535b);
        this.f25544k = k2;
        int min = Math.min(k2, max);
        this.f25544k = min;
        this.f25544k = Math.max(min, -max);
    }

    public void c(int i2) {
        if (this.f25542i != i2) {
            this.f25542i = i2;
            int i3 = i2 + this.f25544k;
            int i4 = i3 > 0 ? this.f25539f : this.f25538e;
            float min = i4 != 1 ? i4 != 2 ? 0.0f : Math.min(Math.max(((float) i3) * this.f25541h, -1.0f), 1.0f) : Math.signum((float) i3) * r.getInterpolation(((float) Math.min(Math.abs(i3), this.f25540g)) * this.f25541h);
            this.f25534a.a(this.f25535b, this.f25536c, this.f25543j, min, false);
            this.f25543j = min;
        }
    }
}
