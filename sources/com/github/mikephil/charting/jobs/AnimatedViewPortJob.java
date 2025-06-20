package com.github.mikephil.charting.jobs;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public abstract class AnimatedViewPortJob extends ViewPortJob implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    protected ObjectAnimator b3;
    protected float c3;
    protected float d3;
    protected float e3;

    public AnimatedViewPortJob(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view, float f4, float f5, long j2) {
        super(viewPortHandler, f2, f3, transformer, view);
        this.d3 = f4;
        this.e3 = f5;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, TypedValues.CycleType.S, new float[]{0.0f, 1.0f});
        this.b3 = ofFloat;
        ofFloat.setDuration(j2);
        this.b3.addUpdateListener(this);
        this.b3.addListener(this);
    }

    public float d() {
        return this.c3;
    }

    public float e() {
        return this.d3;
    }

    public float f() {
        return this.e3;
    }

    public abstract void g();

    /* access modifiers changed from: protected */
    public void h() {
        this.b3.removeAllListeners();
        this.b3.removeAllUpdateListeners();
        this.b3.reverse();
        this.b3.addUpdateListener(this);
        this.b3.addListener(this);
    }

    public void i(float f2) {
        this.c3 = f2;
    }

    public void onAnimationCancel(Animator animator) {
        try {
            g();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onAnimationEnd(Animator animator) {
        try {
            g();
        } catch (IllegalArgumentException unused) {
        }
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
    }

    @SuppressLint({"NewApi"})
    public void run() {
        this.b3.start();
    }
}
