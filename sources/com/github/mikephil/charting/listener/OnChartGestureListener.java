package com.github.mikephil.charting.listener;

import android.view.MotionEvent;
import com.github.mikephil.charting.listener.ChartTouchListener;

public interface OnChartGestureListener {
    void a(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);

    void b(MotionEvent motionEvent, float f2, float f3);

    void c(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);

    void d(MotionEvent motionEvent);

    void e(MotionEvent motionEvent);

    void f(MotionEvent motionEvent);

    void g(MotionEvent motionEvent, float f2, float f3);

    void h(MotionEvent motionEvent, ChartTouchListener.ChartGesture chartGesture);
}
