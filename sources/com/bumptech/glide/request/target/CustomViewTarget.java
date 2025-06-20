package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.R;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class CustomViewTarget<T extends View, Z> implements Target<Z> {
    private static final String Y2 = "CustomViewTarget";
    @IdRes
    private static final int Z2 = R.id.f17690l;
    protected final T X;
    private boolean X2;
    @Nullable
    private View.OnAttachStateChangeListener Y;
    private boolean Z;
    private final SizeDeterminer s;

    @VisibleForTesting
    static final class SizeDeterminer {

        /* renamed from: e  reason: collision with root package name */
        private static final int f18472e = 0;
        @VisibleForTesting
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        static Integer f18473f;

        /* renamed from: a  reason: collision with root package name */
        private final View f18474a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f18475b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f18476c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private SizeDeterminerLayoutListener f18477d;

        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> s;

            SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                this.s = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(CustomViewTarget.Y2, 2)) {
                    Log.v(CustomViewTarget.Y2, "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.s.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        SizeDeterminer(@NonNull View view) {
            this.f18474a = view;
        }

        private static int c(@NonNull Context context) {
            if (f18473f == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f18473f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f18473f.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f18476c && this.f18474a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f18474a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable(CustomViewTarget.Y2, 4)) {
                Log.i(CustomViewTarget.Y2, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f18474a.getContext());
        }

        private int f() {
            int paddingTop = this.f18474a.getPaddingTop() + this.f18474a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f18474a.getLayoutParams();
            return e(this.f18474a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f18474a.getPaddingLeft() + this.f18474a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f18474a.getLayoutParams();
            return e(this.f18474a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it2 = new ArrayList(this.f18475b).iterator();
            while (it2.hasNext()) {
                ((SizeReadyCallback) it2.next()).e(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f18475b.isEmpty()) {
                int g2 = g();
                int f2 = f();
                if (i(g2, f2)) {
                    j(g2, f2);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f18474a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f18477d);
            }
            this.f18477d = null;
            this.f18475b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                sizeReadyCallback.e(g2, f2);
                return;
            }
            if (!this.f18475b.contains(sizeReadyCallback)) {
                this.f18475b.add(sizeReadyCallback);
            }
            if (this.f18477d == null) {
                ViewTreeObserver viewTreeObserver = this.f18474a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f18477d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f18475b.remove(sizeReadyCallback);
        }
    }

    public CustomViewTarget(@NonNull T t) {
        this.X = (View) Preconditions.d(t);
        this.s = new SizeDeterminer(t);
    }

    @Nullable
    private Object g() {
        return this.X.getTag(Z2);
    }

    private void i() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Y;
        if (onAttachStateChangeListener != null && !this.X2) {
            this.X.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.X2 = true;
        }
    }

    private void l() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Y;
        if (onAttachStateChangeListener != null && this.X2) {
            this.X.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.X2 = false;
        }
    }

    private void u(@Nullable Object obj) {
        this.X.setTag(Z2, obj);
    }

    public void a() {
    }

    public void b() {
    }

    public final void c(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.s.k(sizeReadyCallback);
    }

    public void d() {
    }

    @NonNull
    public final CustomViewTarget<T, Z> f() {
        if (this.Y != null) {
            return this;
        }
        this.Y = new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                CustomViewTarget.this.t();
            }

            public void onViewDetachedFromWindow(View view) {
                CustomViewTarget.this.o();
            }
        };
        i();
        return this;
    }

    @NonNull
    public final T h() {
        return this.X;
    }

    public final void j(@Nullable Request request) {
        u(request);
    }

    /* access modifiers changed from: protected */
    public abstract void m(@Nullable Drawable drawable);

    /* access modifiers changed from: protected */
    public void n(@Nullable Drawable drawable) {
    }

    /* access modifiers changed from: package-private */
    public final void o() {
        Request q = q();
        if (q != null) {
            this.Z = true;
            q.clear();
            this.Z = false;
        }
    }

    public final void p(@Nullable Drawable drawable) {
        i();
        n(drawable);
    }

    @Nullable
    public final Request q() {
        Object g2 = g();
        if (g2 == null) {
            return null;
        }
        if (g2 instanceof Request) {
            return (Request) g2;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void r(@Nullable Drawable drawable) {
        this.s.b();
        m(drawable);
        if (!this.Z) {
            l();
        }
    }

    public final void s(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.s.d(sizeReadyCallback);
    }

    /* access modifiers changed from: package-private */
    public final void t() {
        Request q = q();
        if (q != null && q.f()) {
            q.j();
        }
    }

    public String toString() {
        return "Target for: " + this.X;
    }

    @Deprecated
    public final CustomViewTarget<T, Z> v(@IdRes int i2) {
        return this;
    }

    @NonNull
    public final CustomViewTarget<T, Z> w() {
        this.s.f18476c = true;
        return this;
    }
}
