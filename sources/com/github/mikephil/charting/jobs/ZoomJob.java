package com.github.mikephil.charting.jobs;

import android.graphics.Matrix;
import android.view.View;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class ZoomJob extends ViewPortJob {
    private static ObjectPool<ZoomJob> f3;
    protected float b3;
    protected float c3;
    protected YAxis.AxisDependency d3;
    protected Matrix e3 = new Matrix();

    static {
        ObjectPool<ZoomJob> a2 = ObjectPool.a(1, new ZoomJob((ViewPortHandler) null, 0.0f, 0.0f, 0.0f, 0.0f, (Transformer) null, (YAxis.AxisDependency) null, (View) null));
        f3 = a2;
        a2.l(0.5f);
    }

    public ZoomJob(ViewPortHandler viewPortHandler, float f2, float f4, float f5, float f6, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        super(viewPortHandler, f5, f6, transformer, view);
        this.b3 = f2;
        this.c3 = f4;
        this.d3 = axisDependency;
    }

    public static ZoomJob d(ViewPortHandler viewPortHandler, float f2, float f4, float f5, float f6, Transformer transformer, YAxis.AxisDependency axisDependency, View view) {
        ZoomJob b2 = f3.b();
        b2.X2 = f5;
        b2.Y2 = f6;
        b2.b3 = f2;
        b2.c3 = f4;
        b2.Z = viewPortHandler;
        b2.Z2 = transformer;
        b2.d3 = axisDependency;
        b2.a3 = view;
        return b2;
    }

    public static void e(ZoomJob zoomJob) {
        f3.g(zoomJob);
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable a() {
        return new ZoomJob((ViewPortHandler) null, 0.0f, 0.0f, 0.0f, 0.0f, (Transformer) null, (YAxis.AxisDependency) null, (View) null);
    }

    public void run() {
        Matrix matrix = this.e3;
        this.Z.m0(this.b3, this.c3, matrix);
        this.Z.S(matrix, this.a3, false);
        float x = ((BarLineChartBase) this.a3).e(this.d3).I / this.Z.x();
        float w = ((BarLineChartBase) this.a3).getXAxis().I / this.Z.w();
        float[] fArr = this.Y;
        fArr[0] = this.X2 - (w / 2.0f);
        fArr[1] = this.Y2 + (x / 2.0f);
        this.Z2.o(fArr);
        this.Z.i0(this.Y, matrix);
        this.Z.S(matrix, this.a3, false);
        ((BarLineChartBase) this.a3).p();
        this.a3.postInvalidate();
        e(this);
    }
}
