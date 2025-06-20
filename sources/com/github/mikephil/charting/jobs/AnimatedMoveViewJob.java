package com.github.mikephil.charting.jobs;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

@SuppressLint({"NewApi"})
public class AnimatedMoveViewJob extends AnimatedViewPortJob {
    private static ObjectPool<AnimatedMoveViewJob> f3;

    static {
        ObjectPool<AnimatedMoveViewJob> a2 = ObjectPool.a(4, new AnimatedMoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null, 0.0f, 0.0f, 0));
        f3 = a2;
        a2.l(0.5f);
    }

    public AnimatedMoveViewJob(ViewPortHandler viewPortHandler, float f2, float f4, Transformer transformer, View view, float f5, float f6, long j2) {
        super(viewPortHandler, f2, f4, transformer, view, f5, f6, j2);
    }

    public static AnimatedMoveViewJob j(ViewPortHandler viewPortHandler, float f2, float f4, Transformer transformer, View view, float f5, float f6, long j2) {
        AnimatedMoveViewJob b2 = f3.b();
        b2.Z = viewPortHandler;
        b2.X2 = f2;
        b2.Y2 = f4;
        b2.Z2 = transformer;
        b2.a3 = view;
        b2.d3 = f5;
        b2.e3 = f6;
        b2.b3.setDuration(j2);
        return b2;
    }

    public static void k(AnimatedMoveViewJob animatedMoveViewJob) {
        f3.g(animatedMoveViewJob);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new AnimatedMoveViewJob((ViewPortHandler) null, 0.0f, 0.0f, (Transformer) null, (View) null, 0.0f, 0.0f, 0);
    }

    public void g() {
        k(this);
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float[] fArr = this.Y;
        float f2 = this.d3;
        float f4 = this.c3;
        fArr[0] = f2 + ((this.X2 - f2) * f4);
        float f5 = this.e3;
        fArr[1] = f5 + ((this.Y2 - f5) * f4);
        this.Z2.o(fArr);
        this.Z.e(this.Y, this.a3);
    }
}
