package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.utils.CustomRecyclerViewUtils;
import java.lang.ref.WeakReference;

class RemovingItemDecorator extends RecyclerView.ItemDecoration {

    /* renamed from: m  reason: collision with root package name */
    private static final String f25506m = "RemovingItemDecorator";

    /* renamed from: n  reason: collision with root package name */
    private static final int f25507n = 0;
    private static final int o = 1;
    private static final long p = 100;

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f25508a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView.ViewHolder f25509b;

    /* renamed from: c  reason: collision with root package name */
    private long f25510c;

    /* renamed from: d  reason: collision with root package name */
    private Rect f25511d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private int f25512e;

    /* renamed from: f  reason: collision with root package name */
    private int f25513f;

    /* renamed from: g  reason: collision with root package name */
    private long f25514g;

    /* renamed from: h  reason: collision with root package name */
    private long f25515h;

    /* renamed from: i  reason: collision with root package name */
    private long f25516i;

    /* renamed from: j  reason: collision with root package name */
    private Interpolator f25517j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f25518k;

    /* renamed from: l  reason: collision with root package name */
    private int f25519l = 0;

    private static class DelayedNotificationRunner implements Runnable {
        private final int X;
        private WeakReference<RemovingItemDecorator> s;

        public DelayedNotificationRunner(RemovingItemDecorator removingItemDecorator, int i2) {
            this.s = new WeakReference<>(removingItemDecorator);
            this.X = i2;
        }

        public void run() {
            RemovingItemDecorator removingItemDecorator = this.s.get();
            this.s.clear();
            this.s = null;
            if (removingItemDecorator != null) {
                removingItemDecorator.q(this.X);
            }
        }
    }

    public RemovingItemDecorator(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, long j2, long j3) {
        this.f25508a = recyclerView;
        this.f25509b = viewHolder;
        this.f25510c = viewHolder.E();
        this.f25515h = j2 + p;
        this.f25516i = j3;
        this.f25512e = (int) (ViewCompat.B0(viewHolder.f15587a) + 0.5f);
        CustomRecyclerViewUtils.k(this.f25509b.f15587a, this.f25511d);
    }

    private float l(long j2) {
        long j3 = this.f25515h;
        if (j2 < j3) {
            return 1.0f;
        }
        long j4 = this.f25516i;
        if (j2 >= j3 + j4 || j4 == 0) {
            return 0.0f;
        }
        float f2 = 1.0f - (((float) (j2 - j3)) / ((float) j4));
        Interpolator interpolator = this.f25517j;
        return interpolator != null ? interpolator.getInterpolation(f2) : f2;
    }

    private void m(Canvas canvas, Drawable drawable, int i2) {
        Rect rect = this.f25511d;
        int i3 = this.f25512e;
        int i4 = this.f25513f;
        if (i2 < 0) {
            i2 = rect.height();
        }
        if (i2 != 0 && drawable != null) {
            int save = canvas.save();
            int i5 = rect.top;
            canvas.clipRect(rect.left + i3, i5 + i4, rect.right + i3, i5 + i4 + i2);
            canvas.translate((float) (rect.left + i3), (float) ((rect.top + i4) - ((rect.height() - i2) / 2)));
            drawable.setBounds(0, 0, rect.width(), rect.height());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    private void n() {
        this.f25508a.A1(this);
        r();
        this.f25508a = null;
        this.f25509b = null;
        this.f25513f = 0;
        this.f25517j = null;
    }

    protected static long o(long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= j2) {
            return currentTimeMillis - j2;
        }
        return Long.MAX_VALUE;
    }

    private void p(int i2, long j2) {
        int i3 = 1 << i2;
        int i4 = this.f25519l;
        if ((i4 & i3) == 0) {
            this.f25519l = i3 | i4;
            ViewCompat.w1(this.f25508a, new DelayedNotificationRunner(this, i2), j2);
        }
    }

    private void r() {
        ViewCompat.t1(this.f25508a);
    }

    private boolean s(long j2) {
        long j3 = this.f25515h;
        return j2 >= j3 && j2 < j3 + this.f25516i;
    }

    public void i(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        long o2 = o(this.f25514g);
        Rect rect = this.f25511d;
        m(canvas, this.f25518k, (int) ((l(o2) * ((float) rect.height())) + 0.5f));
        if (this.f25510c == this.f25509b.E()) {
            this.f25513f = (int) (ViewCompat.C0(this.f25509b.f15587a) + 0.5f);
        }
        if (s(o2)) {
            r();
        }
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        long o2 = o(this.f25514g);
        this.f25519l = (~(1 << i2)) & this.f25519l;
        if (i2 == 0) {
            long j2 = this.f25515h;
            if (o2 < j2) {
                p(0, j2 - o2);
                return;
            }
            r();
            p(1, this.f25516i);
        } else if (i2 == 1) {
            n();
        }
    }

    public void t(Interpolator interpolator) {
        this.f25517j = interpolator;
    }

    public void u() {
        ViewCompat.g(((SwipeableItemViewHolder) this.f25509b).e()).d();
        this.f25508a.p(this);
        this.f25514g = System.currentTimeMillis();
        this.f25513f = (int) (ViewCompat.C0(this.f25509b.f15587a) + 0.5f);
        this.f25518k = this.f25509b.f15587a.getBackground();
        r();
        p(0, this.f25515h);
    }
}
