package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedZoomJob extends AnimatedViewPortJob implements Animator.AnimatorListener {
    private static ObjectPool<AnimatedZoomJob> m3;
    protected float f3;
    protected float g3;
    protected float h3;
    protected float i3;
    protected YAxis j3;
    protected float k3;
    protected Matrix l3 = new Matrix();

    static {
        AnimatedZoomJob animatedZoomJob = r0;
        AnimatedZoomJob animatedZoomJob2 = new AnimatedZoomJob((ViewPortHandler) null, (View) null, (Transformer) null, (YAxis) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0);
        m3 = ObjectPool.a(8, animatedZoomJob);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SuppressLint({"NewApi"})
    public AnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j2) {
        super(viewPortHandler, f4, f5, transformer, view, f6, f7, j2);
        this.h3 = f8;
        this.i3 = f9;
        this.f3 = f10;
        this.g3 = f11;
        this.b3.addListener(this);
        this.j3 = yAxis;
        this.k3 = f2;
    }

    public static AnimatedZoomJob j(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f2, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long j2) {
        AnimatedZoomJob b2 = m3.b();
        b2.Z = viewPortHandler;
        b2.X2 = f4;
        b2.Y2 = f5;
        b2.Z2 = transformer;
        b2.a3 = view;
        b2.d3 = f6;
        b2.e3 = f7;
        b2.j3 = yAxis;
        b2.k3 = f2;
        b2.h();
        b2.b3.setDuration(j2);
        return b2;
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new AnimatedZoomJob((ViewPortHandler) null, (View) null, (Transformer) null, (YAxis) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0);
    }

    public void g() {
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        ((BarLineChartBase) this.a3).p();
        this.a3.postInvalidate();
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f2 = this.d3;
        float f4 = this.c3;
        float f5 = f2 + ((this.X2 - f2) * f4);
        float f6 = this.e3;
        float f7 = f6 + ((this.Y2 - f6) * f4);
        Matrix matrix = this.l3;
        this.Z.g0(f5, f7, matrix);
        this.Z.S(matrix, this.a3, false);
        float x = this.j3.I / this.Z.x();
        float w = this.k3 / this.Z.w();
        float[] fArr = this.Y;
        float f8 = this.f3;
        float f9 = this.c3;
        fArr[0] = f8 + (((this.h3 - (w / 2.0f)) - f8) * f9);
        float f10 = this.g3;
        fArr[1] = f10 + (((this.i3 + (x / 2.0f)) - f10) * f9);
        this.Z2.o(fArr);
        this.Z.i0(this.Y, matrix);
        this.Z.S(matrix, this.a3, true);
    }
}
