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
import androidx.annotation.CallSuper;
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

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {
    private static final String Z2 = "ViewTarget";
    private static boolean a3;
    private static int b3 = R.id.f17690l;
    protected final T X;
    private boolean X2;
    private final SizeDeterminer Y;
    private boolean Y2;
    @Nullable
    private View.OnAttachStateChangeListener Z;

    @VisibleForTesting
    static final class SizeDeterminer {

        /* renamed from: e  reason: collision with root package name */
        private static final int f18487e = 0;
        @VisibleForTesting
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        static Integer f18488f;

        /* renamed from: a  reason: collision with root package name */
        private final View f18489a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f18490b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f18491c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private SizeDeterminerLayoutListener f18492d;

        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {
            private final WeakReference<SizeDeterminer> s;

            SizeDeterminerLayoutListener(@NonNull SizeDeterminer sizeDeterminer) {
                this.s = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable(ViewTarget.Z2, 2)) {
                    Log.v(ViewTarget.Z2, "OnGlobalLayoutListener called attachStateListener=" + this);
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
            this.f18489a = view;
        }

        private static int c(@NonNull Context context) {
            if (f18488f == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f18488f = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f18488f.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f18491c && this.f18489a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f18489a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable(ViewTarget.Z2, 4)) {
                Log.i(ViewTarget.Z2, "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f18489a.getContext());
        }

        private int f() {
            int paddingTop = this.f18489a.getPaddingTop() + this.f18489a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f18489a.getLayoutParams();
            return e(this.f18489a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f18489a.getPaddingLeft() + this.f18489a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f18489a.getLayoutParams();
            return e(this.f18489a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it2 = new ArrayList(this.f18490b).iterator();
            while (it2.hasNext()) {
                ((SizeReadyCallback) it2.next()).e(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f18490b.isEmpty()) {
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
            ViewTreeObserver viewTreeObserver = this.f18489a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f18492d);
            }
            this.f18492d = null;
            this.f18490b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull SizeReadyCallback sizeReadyCallback) {
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                sizeReadyCallback.e(g2, f2);
                return;
            }
            if (!this.f18490b.contains(sizeReadyCallback)) {
                this.f18490b.add(sizeReadyCallback);
            }
            if (this.f18492d == null) {
                ViewTreeObserver viewTreeObserver = this.f18489a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f18492d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(@NonNull SizeReadyCallback sizeReadyCallback) {
            this.f18490b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(@NonNull T t) {
        this.X = (View) Preconditions.d(t);
        this.Y = new SizeDeterminer(t);
    }

    @Nullable
    private Object l() {
        return this.X.getTag(b3);
    }

    private void m() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Z;
        if (onAttachStateChangeListener != null && !this.Y2) {
            this.X.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.Y2 = true;
        }
    }

    private void n() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.Z;
        if (onAttachStateChangeListener != null && this.Y2) {
            this.X.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.Y2 = false;
        }
    }

    private void u(@Nullable Object obj) {
        a3 = true;
        this.X.setTag(b3, obj);
    }

    @Deprecated
    public static void v(int i2) {
        if (!a3) {
            b3 = i2;
            return;
        }
        throw new IllegalArgumentException("You cannot set the tag id more than once or change the tag id after the first request has been made");
    }

    @CallSuper
    public void c(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.Y.k(sizeReadyCallback);
    }

    @NonNull
    public T g() {
        return this.X;
    }

    @NonNull
    public final ViewTarget<T, Z> i() {
        if (this.Z != null) {
            return this;
        }
        this.Z = new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
                ViewTarget.this.t();
            }

            public void onViewDetachedFromWindow(View view) {
                ViewTarget.this.o();
            }
        };
        m();
        return this;
    }

    public void j(@Nullable Request request) {
        u(request);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        Request q = q();
        if (q != null) {
            this.X2 = true;
            q.clear();
            this.X2 = false;
        }
    }

    @CallSuper
    public void p(@Nullable Drawable drawable) {
        super.p(drawable);
        m();
    }

    @Nullable
    public Request q() {
        Object l2 = l();
        if (l2 == null) {
            return null;
        }
        if (l2 instanceof Request) {
            return (Request) l2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @CallSuper
    public void r(@Nullable Drawable drawable) {
        super.r(drawable);
        this.Y.b();
        if (!this.X2) {
            n();
        }
    }

    @CallSuper
    public void s(@NonNull SizeReadyCallback sizeReadyCallback) {
        this.Y.d(sizeReadyCallback);
    }

    /* access modifiers changed from: package-private */
    public void t() {
        Request q = q();
        if (q != null && q.f()) {
            q.j();
        }
    }

    public String toString() {
        return "Target for: " + this.X;
    }

    @NonNull
    public final ViewTarget<T, Z> w() {
        this.Y.f18491c = true;
        return this;
    }

    @Deprecated
    public ViewTarget(@NonNull T t, boolean z) {
        this(t);
        if (z) {
            w();
        }
    }
}
