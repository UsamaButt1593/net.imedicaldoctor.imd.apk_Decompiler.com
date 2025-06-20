package com.github.chrisbanes.photoview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

class CustomGestureDetector {

    /* renamed from: k  reason: collision with root package name */
    private static final int f18721k = -1;

    /* renamed from: a  reason: collision with root package name */
    private int f18722a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f18723b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ScaleGestureDetector f18724c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f18725d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18726e;

    /* renamed from: f  reason: collision with root package name */
    private float f18727f;

    /* renamed from: g  reason: collision with root package name */
    private float f18728g;

    /* renamed from: h  reason: collision with root package name */
    private final float f18729h;

    /* renamed from: i  reason: collision with root package name */
    private final float f18730i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public OnGestureListener f18731j;

    CustomGestureDetector(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f18730i = (float) viewConfiguration.getScaledMinimumFlingVelocity();
        this.f18729h = (float) viewConfiguration.getScaledTouchSlop();
        this.f18731j = onGestureListener;
        this.f18724c = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() {
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                    return false;
                }
                if (scaleFactor < 0.0f) {
                    return true;
                }
                CustomGestureDetector.this.f18731j.b(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }

            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            }
        });
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f18723b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f18723b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r0 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00db, code lost:
        if (r0 != null) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x00df
            r4 = 0
            if (r0 == r2) goto L_0x008e
            r5 = 2
            if (r0 == r5) goto L_0x004f
            r5 = 3
            if (r0 == r5) goto L_0x0042
            r4 = 6
            if (r0 == r4) goto L_0x0019
            goto L_0x00fe
        L_0x0019:
            int r0 = r13.getAction()
            int r0 = com.github.chrisbanes.photoview.Util.b(r0)
            int r4 = r13.getPointerId(r0)
            int r5 = r12.f18722a
            if (r4 != r5) goto L_0x00fe
            if (r0 != 0) goto L_0x002d
            r0 = 1
            goto L_0x002e
        L_0x002d:
            r0 = 0
        L_0x002e:
            int r4 = r13.getPointerId(r0)
            r12.f18722a = r4
            float r4 = r13.getX(r0)
            r12.f18727f = r4
            float r0 = r13.getY(r0)
            r12.f18728g = r0
            goto L_0x00fe
        L_0x0042:
            r12.f18722a = r1
            android.view.VelocityTracker r0 = r12.f18725d
            if (r0 == 0) goto L_0x00fe
        L_0x0048:
            r0.recycle()
            r12.f18725d = r4
            goto L_0x00fe
        L_0x004f:
            float r0 = r12.b(r13)
            float r4 = r12.c(r13)
            float r5 = r12.f18727f
            float r5 = r0 - r5
            float r6 = r12.f18728g
            float r6 = r4 - r6
            boolean r7 = r12.f18726e
            if (r7 != 0) goto L_0x0079
            float r7 = r5 * r5
            float r8 = r6 * r6
            float r7 = r7 + r8
            double r7 = (double) r7
            double r7 = java.lang.Math.sqrt(r7)
            float r9 = r12.f18729h
            double r9 = (double) r9
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L_0x0076
            r7 = 1
            goto L_0x0077
        L_0x0076:
            r7 = 0
        L_0x0077:
            r12.f18726e = r7
        L_0x0079:
            boolean r7 = r12.f18726e
            if (r7 == 0) goto L_0x00fe
            com.github.chrisbanes.photoview.OnGestureListener r7 = r12.f18731j
            r7.a(r5, r6)
            r12.f18727f = r0
            r12.f18728g = r4
            android.view.VelocityTracker r0 = r12.f18725d
            if (r0 == 0) goto L_0x00fe
            r0.addMovement(r13)
            goto L_0x00fe
        L_0x008e:
            r12.f18722a = r1
            boolean r0 = r12.f18726e
            if (r0 == 0) goto L_0x00d9
            android.view.VelocityTracker r0 = r12.f18725d
            if (r0 == 0) goto L_0x00d9
            float r0 = r12.b(r13)
            r12.f18727f = r0
            float r0 = r12.c(r13)
            r12.f18728g = r0
            android.view.VelocityTracker r0 = r12.f18725d
            r0.addMovement(r13)
            android.view.VelocityTracker r0 = r12.f18725d
            r5 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r5)
            android.view.VelocityTracker r0 = r12.f18725d
            float r0 = r0.getXVelocity()
            android.view.VelocityTracker r5 = r12.f18725d
            float r5 = r5.getYVelocity()
            float r6 = java.lang.Math.abs(r0)
            float r7 = java.lang.Math.abs(r5)
            float r6 = java.lang.Math.max(r6, r7)
            float r7 = r12.f18730i
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x00d9
            com.github.chrisbanes.photoview.OnGestureListener r6 = r12.f18731j
            float r7 = r12.f18727f
            float r8 = r12.f18728g
            float r0 = -r0
            float r5 = -r5
            r6.c(r7, r8, r0, r5)
        L_0x00d9:
            android.view.VelocityTracker r0 = r12.f18725d
            if (r0 == 0) goto L_0x00fe
            goto L_0x0048
        L_0x00df:
            int r0 = r13.getPointerId(r3)
            r12.f18722a = r0
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r12.f18725d = r0
            if (r0 == 0) goto L_0x00f0
            r0.addMovement(r13)
        L_0x00f0:
            float r0 = r12.b(r13)
            r12.f18727f = r0
            float r0 = r12.c(r13)
            r12.f18728g = r0
            r12.f18726e = r3
        L_0x00fe:
            int r0 = r12.f18722a
            if (r0 == r1) goto L_0x0103
            r3 = r0
        L_0x0103:
            int r13 = r13.findPointerIndex(r3)
            r12.f18723b = r13
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.chrisbanes.photoview.CustomGestureDetector.g(android.view.MotionEvent):boolean");
    }

    public boolean d() {
        return this.f18726e;
    }

    public boolean e() {
        return this.f18724c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f18724c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
