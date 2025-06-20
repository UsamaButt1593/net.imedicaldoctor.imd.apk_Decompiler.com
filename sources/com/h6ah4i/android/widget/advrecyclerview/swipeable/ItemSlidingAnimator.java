package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.recyclerview.widget.RecyclerView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ItemSlidingAnimator {

    /* renamed from: h  reason: collision with root package name */
    private static final String f25479h = "ItemSlidingAnimator";

    /* renamed from: a  reason: collision with root package name */
    private Interpolator f25480a = new AccelerateDecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private Interpolator f25481b = new AccelerateInterpolator(0.8f);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public List<RecyclerView.ViewHolder> f25482c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<WeakReference<ViewHolderDeferredProcess>> f25483d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private int[] f25484e = new int[2];

    /* renamed from: f  reason: collision with root package name */
    private Rect f25485f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private int f25486g;

    private static final class DeferredSlideProcess extends ViewHolderDeferredProcess {
        final float X;

        public DeferredSlideProcess(RecyclerView.ViewHolder viewHolder, float f2) {
            super(viewHolder);
            this.X = f2;
        }

        /* access modifiers changed from: protected */
        public void b(RecyclerView.ViewHolder viewHolder) {
            ItemSlidingAnimator.n(viewHolder, (int) ((((float) ((SwipeableItemViewHolder) viewHolder).e().getWidth()) * this.X) + 0.5f));
        }
    }

    private static abstract class ViewHolderDeferredProcess implements Runnable {
        final WeakReference<RecyclerView.ViewHolder> s;

        public ViewHolderDeferredProcess(RecyclerView.ViewHolder viewHolder) {
            this.s = new WeakReference<>(viewHolder);
        }

        public boolean a(RecyclerView.ViewHolder viewHolder) {
            RecyclerView.ViewHolder viewHolder2 = this.s.get();
            return viewHolder2 == null || viewHolder2 == viewHolder;
        }

        /* access modifiers changed from: protected */
        public abstract void b(RecyclerView.ViewHolder viewHolder);

        public void run() {
            RecyclerView.ViewHolder viewHolder = this.s.get();
            if (viewHolder != null) {
                b(viewHolder);
            }
        }
    }

    private boolean b(final RecyclerView.ViewHolder viewHolder, final int i2, long j2, Interpolator interpolator) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return false;
        }
        View e2 = ((SwipeableItemViewHolder) viewHolder).e();
        int B0 = (int) (ViewCompat.B0(e2) + 0.5f);
        e(viewHolder);
        if (((int) (ViewCompat.B0(e2) + 0.5f)) == i2) {
            return false;
        }
        if (j2 == 0 || Math.abs(i2 - B0) <= this.f25486g) {
            ViewCompat.E2(e2, (float) i2);
            return false;
        }
        ViewCompat.E2(e2, (float) B0);
        final ViewPropertyAnimatorCompat g2 = ViewCompat.g(e2);
        g2.s(j2);
        if (interpolator != null) {
            g2.t(interpolator);
        }
        g2.z((float) i2);
        g2.u(new ViewPropertyAnimatorListener() {
            public void a(View view) {
            }

            public void b(View view) {
                g2.u((ViewPropertyAnimatorListener) null);
                ItemSlidingAnimator.this.f25482c.remove(viewHolder);
                ViewCompat.E2(view, (float) i2);
            }

            public void c(View view) {
            }
        });
        this.f25482c.add(viewHolder);
        g2.y();
        return true;
    }

    private boolean c(RecyclerView.ViewHolder viewHolder, int i2, long j2, Interpolator interpolator) {
        return u() ? b(viewHolder, i2, j2, interpolator) : o(viewHolder, i2);
    }

    private void d(RecyclerView.ViewHolder viewHolder) {
        for (int size = this.f25483d.size() - 1; size >= 0; size--) {
            ViewHolderDeferredProcess viewHolderDeferredProcess = (ViewHolderDeferredProcess) this.f25483d.get(size).get();
            if (viewHolderDeferredProcess == null || viewHolderDeferredProcess.a(viewHolder)) {
                this.f25483d.remove(size);
            }
        }
    }

    private static int i(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams = ((SwipeableItemViewHolder) viewHolder).e().getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        }
        Log.w(f25479h, "should use MarginLayoutParams supported view for compatibility on Android 2.3");
        return 0;
    }

    private static void m(RecyclerView.ViewHolder viewHolder, int i2) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            View e2 = ((SwipeableItemViewHolder) viewHolder).e();
            ViewCompat.g(e2).d();
            ViewCompat.E2(e2, (float) i2);
        }
    }

    static void n(RecyclerView.ViewHolder viewHolder, int i2) {
        if (u()) {
            m(viewHolder, i2);
        } else {
            o(viewHolder, i2);
        }
    }

    @SuppressLint({"RtlHardcoded"})
    private static boolean o(RecyclerView.ViewHolder viewHolder, int i2) {
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return false;
        }
        View e2 = ((SwipeableItemViewHolder) viewHolder).e();
        ViewGroup.LayoutParams layoutParams = e2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = i2;
            marginLayoutParams.rightMargin = -i2;
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 51;
            }
            e2.setLayoutParams(marginLayoutParams);
        } else {
            Log.w(f25479h, "should use MarginLayoutParams supported view for compatibility on Android 2.3");
        }
        return false;
    }

    private boolean r(RecyclerView.ViewHolder viewHolder, boolean z, boolean z2, long j2) {
        int i2;
        if (!(viewHolder instanceof SwipeableItemViewHolder)) {
            return false;
        }
        View e2 = ((SwipeableItemViewHolder) viewHolder).e();
        ViewGroup viewGroup = (ViewGroup) e2.getParent();
        if (viewGroup == null) {
            return false;
        }
        int left = e2.getLeft();
        int right = e2.getRight() - left;
        boolean isShown = viewGroup.isShown();
        viewGroup.getWindowVisibleDisplayFrame(this.f25485f);
        if (right == 0 || !isShown) {
            i2 = z ? -this.f25485f.width() : this.f25485f.width();
            z2 = false;
        } else {
            viewGroup.getLocationInWindow(this.f25484e);
            i2 = z ? -(this.f25484e[0] + right) : this.f25485f.width() - (this.f25484e[0] - left);
        }
        if (z2) {
            z2 = e2.isShown();
        }
        if (!z2) {
            j2 = 0;
        }
        return c(viewHolder, i2, j2, this.f25481b);
    }

    private boolean t(RecyclerView.ViewHolder viewHolder, float f2, boolean z, long j2) {
        if (!z) {
            j2 = 0;
        }
        long j3 = j2;
        if (f2 != 0.0f) {
            View e2 = ((SwipeableItemViewHolder) viewHolder).e();
            int width = e2.getWidth();
            if (width != 0) {
                return c(viewHolder, (int) ((((float) width) * f2) + 0.5f), j3, this.f25480a);
            }
            DeferredSlideProcess deferredSlideProcess = new DeferredSlideProcess(viewHolder, f2);
            this.f25483d.add(new WeakReference(deferredSlideProcess));
            e2.post(deferredSlideProcess);
            return false;
        }
        return c(viewHolder, 0, j3, this.f25480a);
    }

    private static boolean u() {
        return true;
    }

    public void e(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof SwipeableItemViewHolder) {
            d(viewHolder);
            ViewCompat.g(((SwipeableItemViewHolder) viewHolder).e()).d();
            if (this.f25482c.remove(viewHolder)) {
                throw new IllegalStateException("after animation is cancelled, item should not be in the active animation list [slide]");
            }
        }
    }

    public void f() {
        for (int size = this.f25482c.size() - 1; size >= 0; size--) {
            e(this.f25482c.get(size));
        }
    }

    public int g() {
        return this.f25486g;
    }

    public int h(RecyclerView.ViewHolder viewHolder) {
        return u() ? (int) (ViewCompat.B0(((SwipeableItemViewHolder) viewHolder).e()) + 0.5f) : i(viewHolder);
    }

    public boolean j() {
        return !this.f25482c.isEmpty();
    }

    public boolean k(RecyclerView.ViewHolder viewHolder) {
        return this.f25482c.contains(viewHolder);
    }

    public void l(int i2) {
        this.f25486g = i2;
    }

    public void p(RecyclerView.ViewHolder viewHolder, boolean z, long j2) {
        d(viewHolder);
        t(viewHolder, 0.0f, z, j2);
    }

    public void q(RecyclerView.ViewHolder viewHolder, boolean z, boolean z2, long j2) {
        d(viewHolder);
        r(viewHolder, z, z2, j2);
    }

    public void s(RecyclerView.ViewHolder viewHolder, float f2) {
        d(viewHolder);
        t(viewHolder, f2, false, 0);
    }
}
