package com.github.mikephil.charting.listener;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;

public abstract class ChartTouchListener<T extends Chart<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    protected static final int Y2 = 0;
    protected static final int Z2 = 1;
    protected static final int a3 = 2;
    protected static final int b3 = 3;
    protected static final int c3 = 4;
    protected static final int d3 = 5;
    protected static final int e3 = 6;
    protected int X = 0;
    protected T X2;
    protected Highlight Y;
    protected GestureDetector Z;
    protected ChartGesture s = ChartGesture.NONE;

    public enum ChartGesture {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public ChartTouchListener(T t) {
        this.X2 = t;
        this.Z = new GestureDetector(t.getContext(), this);
    }

    protected static float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public void b(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.X2.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.h(motionEvent, this.s);
        }
    }

    public ChartGesture c() {
        return this.s;
    }

    public int d() {
        return this.X;
    }

    /* access modifiers changed from: protected */
    public void e(Highlight highlight, MotionEvent motionEvent) {
        if (highlight == null || highlight.a(this.Y)) {
            this.X2.F((Highlight) null, true);
            this.Y = null;
            return;
        }
        this.X2.F(highlight, true);
        this.Y = highlight;
    }

    public void f(Highlight highlight) {
        this.Y = highlight;
    }

    public void g(MotionEvent motionEvent) {
        OnChartGestureListener onChartGestureListener = this.X2.getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, this.s);
        }
    }
}
