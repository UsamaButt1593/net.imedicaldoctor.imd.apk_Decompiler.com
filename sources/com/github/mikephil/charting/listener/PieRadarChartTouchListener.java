package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

public class PieRadarChartTouchListener extends ChartTouchListener<PieRadarChartBase<?>> {
    private MPPointF f3 = MPPointF.c(0.0f, 0.0f);
    private float g3 = 0.0f;
    private ArrayList<AngularVelocitySample> h3 = new ArrayList<>();
    private long i3 = 0;
    private float j3 = 0.0f;

    private class AngularVelocitySample {

        /* renamed from: a  reason: collision with root package name */
        public long f19035a;

        /* renamed from: b  reason: collision with root package name */
        public float f19036b;

        public AngularVelocitySample(long j2, float f2) {
            this.f19035a = j2;
            this.f19036b = f2;
        }
    }

    public PieRadarChartTouchListener(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
    }

    private float h() {
        if (this.h3.isEmpty()) {
            return 0.0f;
        }
        boolean z = false;
        AngularVelocitySample angularVelocitySample = this.h3.get(0);
        ArrayList<AngularVelocitySample> arrayList = this.h3;
        AngularVelocitySample angularVelocitySample2 = arrayList.get(arrayList.size() - 1);
        AngularVelocitySample angularVelocitySample3 = angularVelocitySample;
        for (int size = this.h3.size() - 1; size >= 0; size--) {
            angularVelocitySample3 = this.h3.get(size);
            if (angularVelocitySample3.f19036b != angularVelocitySample2.f19036b) {
                break;
            }
        }
        float f2 = ((float) (angularVelocitySample2.f19035a - angularVelocitySample.f19035a)) / 1000.0f;
        if (f2 == 0.0f) {
            f2 = 0.1f;
        }
        float f4 = angularVelocitySample2.f19036b;
        float f5 = angularVelocitySample3.f19036b;
        if (f4 >= f5) {
            z = true;
        }
        if (((double) Math.abs(f4 - f5)) > 270.0d) {
            z = !z;
        }
        float f6 = angularVelocitySample2.f19036b;
        float f7 = angularVelocitySample.f19036b;
        if (((double) (f6 - f7)) > 180.0d) {
            angularVelocitySample.f19036b = (float) (((double) f7) + 360.0d);
        } else if (((double) (f7 - f6)) > 180.0d) {
            angularVelocitySample2.f19036b = (float) (((double) f6) + 360.0d);
        }
        float abs = Math.abs((angularVelocitySample2.f19036b - angularVelocitySample.f19036b) / f2);
        return !z ? -abs : abs;
    }

    private void j() {
        this.h3.clear();
    }

    private void k(float f2, float f4) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.h3.add(new AngularVelocitySample(currentAnimationTimeMillis, ((PieRadarChartBase) this.X2).a0(f2, f4)));
        for (int size = this.h3.size(); size - 2 > 0 && currentAnimationTimeMillis - this.h3.get(0).f19035a > 1000; size--) {
            this.h3.remove(0);
        }
    }

    public void i() {
        if (this.j3 != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.j3 *= ((PieRadarChartBase) this.X2).getDragDecelerationFrictionCoef();
            T t = this.X2;
            ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).getRotationAngle() + (this.j3 * (((float) (currentAnimationTimeMillis - this.i3)) / 1000.0f)));
            this.i3 = currentAnimationTimeMillis;
            if (((double) Math.abs(this.j3)) >= 0.001d) {
                Utils.K(this.X2);
            } else {
                m();
            }
        }
    }

    public void l(float f2, float f4) {
        this.g3 = ((PieRadarChartBase) this.X2).a0(f2, f4) - ((PieRadarChartBase) this.X2).getRawRotationAngle();
    }

    public void m() {
        this.j3 = 0.0f;
    }

    public void n(float f2, float f4) {
        T t = this.X2;
        ((PieRadarChartBase) t).setRotationAngle(((PieRadarChartBase) t).a0(f2, f4) - this.g3);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.s = ChartTouchListener.ChartGesture.LONG_PRESS;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.e(motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.s = ChartTouchListener.ChartGesture.SINGLE_TAP;
        OnChartGestureListener onChartGestureListener = ((PieRadarChartBase) this.X2).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.d(motionEvent);
        }
        if (!((PieRadarChartBase) this.X2).M()) {
            return false;
        }
        e(((PieRadarChartBase) this.X2).x(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.Z.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.X2).e0()) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    if (((PieRadarChartBase) this.X2).I()) {
                        m();
                        k(x, y);
                        float h2 = h();
                        this.j3 = h2;
                        if (h2 != 0.0f) {
                            this.i3 = AnimationUtils.currentAnimationTimeMillis();
                            Utils.K(this.X2);
                        }
                    }
                    ((PieRadarChartBase) this.X2).w();
                    this.X = 0;
                } else if (action == 2) {
                    if (((PieRadarChartBase) this.X2).I()) {
                        k(x, y);
                    }
                    if (this.X == 0) {
                        MPPointF mPPointF = this.f3;
                        if (ChartTouchListener.a(x, mPPointF.Y, y, mPPointF.Z) > Utils.e(8.0f)) {
                            this.s = ChartTouchListener.ChartGesture.ROTATE;
                            this.X = 6;
                            ((PieRadarChartBase) this.X2).t();
                        }
                    }
                    if (this.X == 6) {
                        n(x, y);
                        ((PieRadarChartBase) this.X2).invalidate();
                    }
                }
                b(motionEvent);
            } else {
                g(motionEvent);
                m();
                j();
                if (((PieRadarChartBase) this.X2).I()) {
                    k(x, y);
                }
                l(x, y);
                MPPointF mPPointF2 = this.f3;
                mPPointF2.Y = x;
                mPPointF2.Z = y;
            }
        }
        return true;
    }
}
