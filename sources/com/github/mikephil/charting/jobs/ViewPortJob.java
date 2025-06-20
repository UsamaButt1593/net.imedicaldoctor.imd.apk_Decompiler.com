package com.github.mikephil.charting.jobs;

import android.view.View;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ViewPortJob extends ObjectPool.Poolable implements Runnable {
    protected float X2;
    protected float[] Y = new float[2];
    protected float Y2;
    protected ViewPortHandler Z;
    protected Transformer Z2;
    protected View a3;

    public ViewPortJob(ViewPortHandler viewPortHandler, float f2, float f3, Transformer transformer, View view) {
        this.Z = viewPortHandler;
        this.X2 = f2;
        this.Y2 = f3;
        this.Z2 = transformer;
        this.a3 = view;
    }

    public float b() {
        return this.X2;
    }

    public float c() {
        return this.Y2;
    }
}
