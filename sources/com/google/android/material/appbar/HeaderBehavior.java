package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int d3 = -1;
    OverScroller X2;
    private boolean Y2;
    @Nullable
    private Runnable Z;
    private int Z2 = -1;
    private int a3;
    private int b3 = -1;
    @Nullable
    private VelocityTracker c3;

    private class FlingRunnable implements Runnable {
        private final V X;
        private final CoordinatorLayout s;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.s = coordinatorLayout;
            this.X = v;
        }

        public void run() {
            OverScroller overScroller;
            if (this.X != null && (overScroller = HeaderBehavior.this.X2) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.e0(this.s, this.X, headerBehavior.X2.getCurrY());
                    ViewCompat.v1(this.X, this);
                    return;
                }
                HeaderBehavior.this.c0(this.s, this.X);
            }
        }
    }

    public HeaderBehavior() {
    }

    private void X() {
        if (this.c3 == null) {
            this.c3 = VelocityTracker.obtain();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:32:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean L(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x004e
            r4 = 2
            if (r0 == r4) goto L_0x002d
            r12 = 3
            if (r0 == r12) goto L_0x0072
            r12 = 6
            if (r0 == r12) goto L_0x0013
            goto L_0x004c
        L_0x0013:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L_0x001b
            r12 = 1
            goto L_0x001c
        L_0x001b:
            r12 = 0
        L_0x001c:
            int r13 = r14.getPointerId(r12)
            r11.Z2 = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.a3 = r12
            goto L_0x004c
        L_0x002d:
            int r0 = r11.Z2
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L_0x0036
            return r3
        L_0x0036:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.a3
            int r7 = r1 - r0
            r11.a3 = r0
            int r8 = r11.Z(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.d0(r5, r6, r7, r8, r9)
        L_0x004c:
            r12 = 0
            goto L_0x0081
        L_0x004e:
            android.view.VelocityTracker r0 = r11.c3
            if (r0 == 0) goto L_0x0072
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.c3
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.c3
            int r4 = r11.Z2
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.a0(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.Y(r6, r7, r8, r9, r10)
            r12 = 1
            goto L_0x0073
        L_0x0072:
            r12 = 0
        L_0x0073:
            r11.Y2 = r3
            r11.Z2 = r1
            android.view.VelocityTracker r13 = r11.c3
            if (r13 == 0) goto L_0x0081
            r13.recycle()
            r13 = 0
            r11.c3 = r13
        L_0x0081:
            android.view.VelocityTracker r13 = r11.c3
            if (r13 == 0) goto L_0x0088
            r13.addMovement(r14)
        L_0x0088:
            boolean r13 = r11.Y2
            if (r13 != 0) goto L_0x0090
            if (r12 == 0) goto L_0x008f
            goto L_0x0090
        L_0x008f:
            r2 = 0
        L_0x0090:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.L(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public boolean W(V v) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean Y(CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, float f2) {
        V v2 = v;
        Runnable runnable = this.Z;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.Z = null;
        }
        if (this.X2 == null) {
            this.X2 = new OverScroller(v.getContext());
        }
        this.X2.fling(0, O(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.X2.computeScrollOffset()) {
            CoordinatorLayout coordinatorLayout2 = coordinatorLayout;
            FlingRunnable flingRunnable = new FlingRunnable(coordinatorLayout, v);
            this.Z = flingRunnable;
            ViewCompat.v1(v, flingRunnable);
            return true;
        }
        CoordinatorLayout coordinatorLayout3 = coordinatorLayout;
        c0(coordinatorLayout, v);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int Z(@NonNull V v) {
        return -v.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int a0(@NonNull V v) {
        return v.getHeight();
    }

    /* access modifiers changed from: package-private */
    public int b0() {
        return O();
    }

    /* access modifiers changed from: package-private */
    public void c0(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* access modifiers changed from: package-private */
    public final int d0(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return f0(coordinatorLayout, v, b0() - i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public int e0(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return f0(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* access modifiers changed from: package-private */
    public int f0(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        int e2;
        int O = O();
        if (i3 == 0 || O < i3 || O > i4 || O == (e2 = MathUtils.e(i2, i3, i4))) {
            return 0;
        }
        U(e2);
        return O - e2;
    }

    public boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.b3 < 0) {
            this.b3 = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.Y2) {
            int i2 = this.Z2;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.a3) > this.b3) {
                this.a3 = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.Z2 = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = W(v) && coordinatorLayout.G(v, x, y2);
            this.Y2 = z;
            if (z) {
                this.a3 = y2;
                this.Z2 = motionEvent.getPointerId(0);
                X();
                OverScroller overScroller = this.X2;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.X2.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.c3;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
