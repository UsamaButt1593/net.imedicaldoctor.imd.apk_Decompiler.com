package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int e3 = 0;
    public static final int f3 = 1;
    public static final int g3 = 2;
    public static final int h3 = 0;
    public static final int i3 = 1;
    public static final int j3 = 2;
    private static final float k3 = 0.5f;
    private static final float l3 = 0.0f;
    private static final float m3 = 0.5f;
    OnDismissListener X;
    private float X2 = 0.0f;
    private boolean Y;
    private boolean Y2;
    /* access modifiers changed from: private */
    public boolean Z;
    int Z2 = 2;
    float a3 = 0.5f;
    float b3 = 0.0f;
    float c3 = 0.5f;
    private final ViewDragHelper.Callback d3 = new ViewDragHelper.Callback() {

        /* renamed from: d  reason: collision with root package name */
        private static final int f20843d = -1;

        /* renamed from: a  reason: collision with root package name */
        private int f20844a;

        /* renamed from: b  reason: collision with root package name */
        private int f20845b = -1;

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x002c A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean n(@androidx.annotation.NonNull android.view.View r7, float r8) {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                r2 = 0
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0034
                int r7 = androidx.core.view.ViewCompat.c0(r7)
                if (r7 != r1) goto L_0x000f
                r7 = 1
                goto L_0x0010
            L_0x000f:
                r7 = 0
            L_0x0010:
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r4 = r4.Z2
                r5 = 2
                if (r4 != r5) goto L_0x0018
                return r1
            L_0x0018:
                if (r4 != 0) goto L_0x0026
                if (r7 == 0) goto L_0x0022
                int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r7 >= 0) goto L_0x0025
            L_0x0020:
                r0 = 1
                goto L_0x0025
            L_0x0022:
                if (r3 <= 0) goto L_0x0025
                goto L_0x0020
            L_0x0025:
                return r0
            L_0x0026:
                if (r4 != r1) goto L_0x0033
                if (r7 == 0) goto L_0x002e
                if (r3 <= 0) goto L_0x0033
            L_0x002c:
                r0 = 1
                goto L_0x0033
            L_0x002e:
                int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r7 >= 0) goto L_0x0033
                goto L_0x002c
            L_0x0033:
                return r0
            L_0x0034:
                int r8 = r7.getLeft()
                int r2 = r6.f20844a
                int r8 = r8 - r2
                int r7 = r7.getWidth()
                float r7 = (float) r7
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                float r2 = r2.a3
                float r7 = r7 * r2
                int r7 = java.lang.Math.round(r7)
                int r8 = java.lang.Math.abs(r8)
                if (r8 < r7) goto L_0x0051
                r0 = 1
            L_0x0051:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.n(android.view.View, float):boolean");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            r5 = r2.f20844a;
            r3 = r3.getWidth() + r5;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int a(@androidx.annotation.NonNull android.view.View r3, int r4, int r5) {
            /*
                r2 = this;
                int r5 = androidx.core.view.ViewCompat.c0(r3)
                r0 = 1
                if (r5 != r0) goto L_0x0009
                r5 = 1
                goto L_0x000a
            L_0x0009:
                r5 = 0
            L_0x000a:
                com.google.android.material.behavior.SwipeDismissBehavior r1 = com.google.android.material.behavior.SwipeDismissBehavior.this
                int r1 = r1.Z2
                if (r1 != 0) goto L_0x0024
                if (r5 == 0) goto L_0x001c
            L_0x0012:
                int r5 = r2.f20844a
                int r3 = r3.getWidth()
                int r5 = r5 - r3
                int r3 = r2.f20844a
                goto L_0x0037
            L_0x001c:
                int r5 = r2.f20844a
                int r3 = r3.getWidth()
                int r3 = r3 + r5
                goto L_0x0037
            L_0x0024:
                if (r1 != r0) goto L_0x0029
                if (r5 == 0) goto L_0x0012
                goto L_0x001c
            L_0x0029:
                int r5 = r2.f20844a
                int r0 = r3.getWidth()
                int r5 = r5 - r0
                int r0 = r2.f20844a
                int r3 = r3.getWidth()
                int r3 = r3 + r0
            L_0x0037:
                int r3 = com.google.android.material.behavior.SwipeDismissBehavior.Q(r5, r4, r3)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.a(android.view.View, int, int):int");
        }

        public int b(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        public int d(@NonNull View view) {
            return view.getWidth();
        }

        public void i(@NonNull View view, int i2) {
            this.f20845b = i2;
            this.f20844a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                boolean unused = SwipeDismissBehavior.this.Z = true;
                parent.requestDisallowInterceptTouchEvent(true);
                boolean unused2 = SwipeDismissBehavior.this.Z = false;
            }
        }

        public void j(int i2) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.X;
            if (onDismissListener != null) {
                onDismissListener.b(i2);
            }
        }

        public void k(@NonNull View view, int i2, int i3, int i4, int i5) {
            float width = ((float) view.getWidth()) * SwipeDismissBehavior.this.b3;
            float width2 = ((float) view.getWidth()) * SwipeDismissBehavior.this.c3;
            float abs = (float) Math.abs(i2 - this.f20844a);
            if (abs <= width) {
                view.setAlpha(1.0f);
            } else if (abs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.P(0.0f, 1.0f - SwipeDismissBehavior.S(width, width2, abs), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
            r4 = r3.getLeft();
            r0 = r2.f20844a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void l(@androidx.annotation.NonNull android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.f20845b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L_0x0023
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L_0x001d
                int r4 = r3.getLeft()
                int r0 = r2.f20844a
                if (r4 >= r0) goto L_0x001b
                goto L_0x001d
            L_0x001b:
                int r0 = r0 + r5
                goto L_0x0021
            L_0x001d:
                int r4 = r2.f20844a
                int r0 = r4 - r5
            L_0x0021:
                r4 = 1
                goto L_0x0026
            L_0x0023:
                int r0 = r2.f20844a
                r4 = 0
            L_0x0026:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.ViewDragHelper r5 = r5.s
                int r1 = r3.getTop()
                boolean r5 = r5.V(r0, r1)
                if (r5 == 0) goto L_0x003f
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r5 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                com.google.android.material.behavior.SwipeDismissBehavior r0 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                androidx.core.view.ViewCompat.v1(r3, r5)
                goto L_0x004a
            L_0x003f:
                if (r4 == 0) goto L_0x004a
                com.google.android.material.behavior.SwipeDismissBehavior r4 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r4 = r4.X
                if (r4 == 0) goto L_0x004a
                r4.a(r3)
            L_0x004a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.l(android.view.View, float, float):void");
        }

        public boolean m(View view, int i2) {
            int i3 = this.f20845b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.O(view);
        }
    };
    ViewDragHelper s;

    public interface OnDismissListener {
        void a(View view);

        void b(int i2);
    }

    private class SettleRunnable implements Runnable {
        private final boolean X;
        private final View s;

        SettleRunnable(View view, boolean z) {
            this.s = view;
            this.X = z;
        }

        public void run() {
            OnDismissListener onDismissListener;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.s;
            if (viewDragHelper != null && viewDragHelper.o(true)) {
                ViewCompat.v1(this.s, this);
            } else if (this.X && (onDismissListener = SwipeDismissBehavior.this.X) != null) {
                onDismissListener.a(this.s);
            }
        }
    }

    static float P(float f2, float f4, float f5) {
        return Math.min(Math.max(f2, f4), f5);
    }

    static int Q(int i2, int i4, int i5) {
        return Math.min(Math.max(i2, i4), i5);
    }

    private void R(ViewGroup viewGroup) {
        if (this.s == null) {
            this.s = this.Y2 ? ViewDragHelper.p(viewGroup, this.X2, this.d3) : ViewDragHelper.q(viewGroup, this.d3);
        }
    }

    static float S(float f2, float f4, float f5) {
        return (f5 - f2) / (f4 - f2);
    }

    private void b0(View view) {
        ViewCompat.x1(view, 1048576);
        if (O(view)) {
            ViewCompat.A1(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.z, (CharSequence) null, new AccessibilityViewCommand() {
                public boolean a(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
                    boolean z = false;
                    if (!SwipeDismissBehavior.this.O(view)) {
                        return false;
                    }
                    if (ViewCompat.c0(view) == 1) {
                        z = true;
                    }
                    int i2 = SwipeDismissBehavior.this.Z2;
                    ViewCompat.i1(view, ((i2 != 0 || !z) && (i2 != 1 || z)) ? view.getWidth() : -view.getWidth());
                    view.setAlpha(0.0f);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.X;
                    if (onDismissListener != null) {
                        onDismissListener.a(view);
                    }
                    return true;
                }
            });
        }
    }

    public boolean L(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.s == null) {
            return false;
        }
        if (this.Z && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.s.M(motionEvent);
        return true;
    }

    public boolean O(@NonNull View view) {
        return true;
    }

    public int T() {
        ViewDragHelper viewDragHelper = this.s;
        if (viewDragHelper != null) {
            return viewDragHelper.F();
        }
        return 0;
    }

    @VisibleForTesting
    @Nullable
    public OnDismissListener U() {
        return this.X;
    }

    public void V(float f2) {
        this.a3 = P(0.0f, f2, 1.0f);
    }

    public void W(float f2) {
        this.c3 = P(0.0f, f2, 1.0f);
    }

    public void X(@Nullable OnDismissListener onDismissListener) {
        this.X = onDismissListener;
    }

    public void Y(float f2) {
        this.X2 = f2;
        this.Y2 = true;
    }

    public void Z(float f2) {
        this.b3 = P(0.0f, f2, 1.0f);
    }

    public void a0(int i2) {
        this.Z2 = i2;
    }

    public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z = this.Y;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.G(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.Y = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.Y = false;
        }
        if (!z) {
            return false;
        }
        R(coordinatorLayout);
        return !this.Z && this.s.W(motionEvent);
    }

    public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        boolean t = super.t(coordinatorLayout, v, i2);
        if (ViewCompat.X(v) == 0) {
            ViewCompat.Z1(v, 1);
            b0(v);
        }
        return t;
    }
}
