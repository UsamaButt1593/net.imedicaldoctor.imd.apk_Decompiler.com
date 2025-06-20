package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class BarLineChartTouchListener extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>>> {
    private Matrix f3 = new Matrix();
    private Matrix g3 = new Matrix();
    private MPPointF h3 = MPPointF.c(0.0f, 0.0f);
    private MPPointF i3 = MPPointF.c(0.0f, 0.0f);
    private float j3 = 1.0f;
    private float k3 = 1.0f;
    private float l3 = 1.0f;
    private IDataSet m3;
    private VelocityTracker n3;
    private long o3 = 0;
    private MPPointF p3 = MPPointF.c(0.0f, 0.0f);
    private MPPointF q3 = MPPointF.c(0.0f, 0.0f);
    private float r3;
    private float s3;

    public BarLineChartTouchListener(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends IBarLineScatterCandleBubbleDataSet<? extends Entry>>> barLineChartBase, Matrix matrix, float f2) {
        super(barLineChartBase);
        this.f3 = matrix;
        this.r3 = Utils.e(f2);
        this.s3 = Utils.e(3.5f);
    }

    private static float k(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    private static float l(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r2.m3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() {
        /*
            r2 = this;
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r2.m3
            if (r0 != 0) goto L_0x000e
            T r0 = r2.X2
            com.github.mikephil.charting.charts.BarLineChartBase r0 = (com.github.mikephil.charting.charts.BarLineChartBase) r0
            boolean r0 = r0.o0()
            if (r0 != 0) goto L_0x0020
        L_0x000e:
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r2.m3
            if (r0 == 0) goto L_0x0022
            T r1 = r2.X2
            com.github.mikephil.charting.charts.BarLineChartBase r1 = (com.github.mikephil.charting.charts.BarLineChartBase) r1
            com.github.mikephil.charting.components.YAxis$AxisDependency r0 = r0.a1()
            boolean r0 = r1.f(r0)
            if (r0 == 0) goto L_0x0022
        L_0x0020:
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.BarLineChartTouchListener.m():boolean");
    }

    private static void n(MPPointF mPPointF, MotionEvent motionEvent) {
        mPPointF.Y = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        mPPointF.Z = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    private void o(MotionEvent motionEvent, float f2, float f4) {
        this.s = ChartTouchListener.ChartGesture.DRAG;
        this.f3.set(this.g3);
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
        if (m()) {
            if (this.X2 instanceof HorizontalBarChart) {
                f2 = -f2;
            } else {
                f4 = -f4;
            }
        }
        this.f3.postTranslate(f2, f4);
        if (onChartGestureListener != null) {
            onChartGestureListener.g(motionEvent, f2, f4);
        }
    }

    private void p(MotionEvent motionEvent) {
        Highlight x = ((BarLineChartBase) this.X2).x(motionEvent.getX(), motionEvent.getY());
        if (x != null && !x.a(this.Y)) {
            this.Y = x;
            ((BarLineChartBase) this.X2).F(x, true);
        }
    }

    private void q(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() >= 2) {
            OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
            float t = t(motionEvent);
            if (t > this.s3) {
                MPPointF mPPointF = this.i3;
                MPPointF j2 = j(mPPointF.Y, mPPointF.Z);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.X2).getViewPortHandler();
                int i2 = this.X;
                boolean z = false;
                float f2 = 1.0f;
                if (i2 == 4) {
                    this.s = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f4 = t / this.l3;
                    if (f4 < 1.0f) {
                        z = true;
                    }
                    boolean c2 = z ? viewPortHandler.c() : viewPortHandler.a();
                    boolean d2 = z ? viewPortHandler.d() : viewPortHandler.b();
                    float f5 = ((BarLineChartBase) this.X2).A0() ? f4 : 1.0f;
                    if (((BarLineChartBase) this.X2).B0()) {
                        f2 = f4;
                    }
                    if (d2 || c2) {
                        this.f3.set(this.g3);
                        this.f3.postScale(f5, f2, j2.Y, j2.Z);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, f5, f2);
                        }
                    }
                } else if (i2 == 2 && ((BarLineChartBase) this.X2).A0()) {
                    this.s = ChartTouchListener.ChartGesture.X_ZOOM;
                    float k2 = k(motionEvent) / this.j3;
                    if (k2 < 1.0f ? viewPortHandler.c() : viewPortHandler.a()) {
                        this.f3.set(this.g3);
                        this.f3.postScale(k2, 1.0f, j2.Y, j2.Z);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, k2, 1.0f);
                        }
                    }
                } else if (this.X == 3 && ((BarLineChartBase) this.X2).B0()) {
                    this.s = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float l2 = l(motionEvent) / this.k3;
                    if (l2 < 1.0f) {
                        z = true;
                    }
                    if (z ? viewPortHandler.d() : viewPortHandler.b()) {
                        this.f3.set(this.g3);
                        this.f3.postScale(1.0f, l2, j2.Y, j2.Z);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.b(motionEvent, 1.0f, l2);
                        }
                    }
                }
                MPPointF.h(j2);
            }
        }
    }

    private void r(MotionEvent motionEvent) {
        this.g3.set(this.f3);
        this.h3.Y = motionEvent.getX();
        this.h3.Z = motionEvent.getY();
        this.m3 = ((BarLineChartBase) this.X2).h0(motionEvent.getX(), motionEvent.getY());
    }

    private static float t(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x * x) + (y * y)));
    }

    public void h() {
        MPPointF mPPointF = this.q3;
        float f2 = 0.0f;
        if (mPPointF.Y != 0.0f || mPPointF.Z != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.q3.Y *= ((BarLineChartBase) this.X2).getDragDecelerationFrictionCoef();
            this.q3.Z *= ((BarLineChartBase) this.X2).getDragDecelerationFrictionCoef();
            float f4 = ((float) (currentAnimationTimeMillis - this.o3)) / 1000.0f;
            MPPointF mPPointF2 = this.q3;
            float f5 = mPPointF2.Y * f4;
            float f6 = mPPointF2.Z * f4;
            MPPointF mPPointF3 = this.p3;
            float f7 = mPPointF3.Y + f5;
            mPPointF3.Y = f7;
            float f8 = mPPointF3.Z + f6;
            mPPointF3.Z = f8;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f7, f8, 0);
            float f9 = ((BarLineChartBase) this.X2).t0() ? this.p3.Y - this.h3.Y : 0.0f;
            if (((BarLineChartBase) this.X2).u0()) {
                f2 = this.p3.Z - this.h3.Z;
            }
            o(obtain, f9, f2);
            obtain.recycle();
            this.f3 = ((BarLineChartBase) this.X2).getViewPortHandler().S(this.f3, this.X2, false);
            this.o3 = currentAnimationTimeMillis;
            if (((double) Math.abs(this.q3.Y)) >= 0.01d || ((double) Math.abs(this.q3.Z)) >= 0.01d) {
                Utils.K(this.X2);
                return;
            }
            ((BarLineChartBase) this.X2).p();
            ((BarLineChartBase) this.X2).postInvalidate();
            u();
        }
    }

    public Matrix i() {
        return this.f3;
    }

    public MPPointF j(float f2, float f4) {
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.X2).getViewPortHandler();
        return MPPointF.c(f2 - viewPortHandler.P(), m() ? -(f4 - viewPortHandler.R()) : -((((float) ((BarLineChartBase) this.X2).getMeasuredHeight()) - f4) - viewPortHandler.O()));
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.s = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.f(motionEvent);
        }
        if (((BarLineChartBase) this.X2).r0() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.X2).getData()).r() > 0) {
            MPPointF j2 = j(motionEvent.getX(), motionEvent.getY());
            T t = this.X2;
            BarLineChartBase barLineChartBase = (BarLineChartBase) t;
            float f2 = 1.0f;
            float f4 = ((BarLineChartBase) t).A0() ? 1.4f : 1.0f;
            if (((BarLineChartBase) this.X2).B0()) {
                f2 = 1.4f;
            }
            barLineChartBase.Q0(f4, f2, j2.Y, j2.Z);
            if (((BarLineChartBase) this.X2).N()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + j2.Y + ", y: " + j2.Z);
            }
            MPPointF.h(j2);
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f4) {
        this.s = ChartTouchListener.ChartGesture.FLING;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent, motionEvent2, f2, f4);
        }
        return super.onFling(motionEvent, motionEvent2, f2, f4);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.s = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.e(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.s = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((BarLineChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.d(motionEvent);
        }
        if (!((BarLineChartBase) this.X2).M()) {
            return false;
        }
        e(((BarLineChartBase) this.X2).x(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.n3 == null) {
            this.n3 = VelocityTracker.obtain();
        }
        this.n3.addMovement(motionEvent);
        int i2 = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.n3) != null) {
            velocityTracker.recycle();
            this.n3 = null;
        }
        if (this.X == 0) {
            this.Z.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.X2).s0() && !((BarLineChartBase) this.X2).A0() && !((BarLineChartBase) this.X2).B0()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.n3;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, (float) Utils.x());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > ((float) Utils.y()) || Math.abs(yVelocity) > ((float) Utils.y())) && this.X == 1 && ((BarLineChartBase) this.X2).I()) {
                    u();
                    this.o3 = AnimationUtils.currentAnimationTimeMillis();
                    this.p3.Y = motionEvent.getX();
                    this.p3.Z = motionEvent.getY();
                    MPPointF mPPointF = this.q3;
                    mPPointF.Y = xVelocity;
                    mPPointF.Z = yVelocity;
                    Utils.K(this.X2);
                }
                int i4 = this.X;
                if (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5) {
                    ((BarLineChartBase) this.X2).p();
                    ((BarLineChartBase) this.X2).postInvalidate();
                }
                this.X = 0;
                ((BarLineChartBase) this.X2).w();
                VelocityTracker velocityTracker3 = this.n3;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.n3 = null;
                }
            } else if (action == 2) {
                int i5 = this.X;
                if (i5 == 1) {
                    ((BarLineChartBase) this.X2).t();
                    float f2 = 0.0f;
                    float x = ((BarLineChartBase) this.X2).t0() ? motionEvent.getX() - this.h3.Y : 0.0f;
                    if (((BarLineChartBase) this.X2).u0()) {
                        f2 = motionEvent.getY() - this.h3.Z;
                    }
                    o(motionEvent, x, f2);
                } else if (i5 == 2 || i5 == 3 || i5 == 4) {
                    ((BarLineChartBase) this.X2).t();
                    if (((BarLineChartBase) this.X2).A0() || ((BarLineChartBase) this.X2).B0()) {
                        q(motionEvent);
                    }
                } else if (i5 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.h3.Y, motionEvent.getY(), this.h3.Z)) > this.r3 && ((BarLineChartBase) this.X2).s0()) {
                    if (!((BarLineChartBase) this.X2).w0() || !((BarLineChartBase) this.X2).n0()) {
                        float abs = Math.abs(motionEvent.getX() - this.h3.Y);
                        float abs2 = Math.abs(motionEvent.getY() - this.h3.Z);
                        if ((((BarLineChartBase) this.X2).t0() || abs2 >= abs) && (((BarLineChartBase) this.X2).u0() || abs2 <= abs)) {
                            this.s = ChartTouchListener.ChartGesture.DRAG;
                            this.X = 1;
                        }
                    } else if (((BarLineChartBase) this.X2).x0()) {
                        this.s = ChartTouchListener.ChartGesture.DRAG;
                        if (((BarLineChartBase) this.X2).x0()) {
                            p(motionEvent);
                        }
                    }
                }
            } else if (action == 3) {
                this.X = 0;
            } else if (action != 5) {
                if (action == 6) {
                    Utils.M(motionEvent, this.n3);
                    this.X = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ((BarLineChartBase) this.X2).t();
                r(motionEvent);
                this.j3 = k(motionEvent);
                this.k3 = l(motionEvent);
                float t = t(motionEvent);
                this.l3 = t;
                if (t > 10.0f) {
                    if (((BarLineChartBase) this.X2).z0()) {
                        this.X = 4;
                    } else {
                        if (((BarLineChartBase) this.X2).A0() == ((BarLineChartBase) this.X2).B0() ? this.j3 > this.k3 : ((BarLineChartBase) this.X2).A0()) {
                            i2 = 2;
                        }
                        this.X = i2;
                    }
                }
                n(this.i3, motionEvent);
            }
            b(motionEvent);
        } else {
            g(motionEvent);
            u();
            r(motionEvent);
        }
        this.f3 = ((BarLineChartBase) this.X2).getViewPortHandler().S(this.f3, this.X2, true);
        return true;
    }

    public void s(float f2) {
        this.r3 = Utils.e(f2);
    }

    public void u() {
        MPPointF mPPointF = this.q3;
        mPPointF.Y = 0.0f;
        mPPointF.Z = 0.0f;
    }
}
