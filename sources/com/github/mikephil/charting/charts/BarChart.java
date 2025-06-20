package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.highlight.BarHighlighter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.BarChartRenderer;

public class BarChart extends BarLineChartBase<BarData> implements BarDataProvider {
    protected boolean r4 = false;
    private boolean s4 = true;
    private boolean t4 = false;
    private boolean u4 = false;

    public BarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new BarChartRenderer(this, this.q3, this.p3);
        setHighlighter(new BarHighlighter(this));
        getXAxis().t0(0.5f);
        getXAxis().s0(0.5f);
    }

    public RectF W0(BarEntry barEntry) {
        RectF rectF = new RectF();
        X0(barEntry, rectF);
        return rectF;
    }

    public void X0(BarEntry barEntry, RectF rectF) {
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarData) this.X2).n(barEntry);
        if (iBarDataSet == null) {
            rectF.set(Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE, Float.MIN_VALUE);
            return;
        }
        float c2 = barEntry.c();
        float m2 = barEntry.m();
        float Q = ((BarData) this.X2).Q() / 2.0f;
        float f2 = m2 - Q;
        float f3 = m2 + Q;
        float f4 = c2 >= 0.0f ? c2 : 0.0f;
        if (c2 > 0.0f) {
            c2 = 0.0f;
        }
        rectF.set(f2, f4, f3, c2);
        a(iBarDataSet.a1()).t(rectF);
    }

    public void Y0(float f2, float f3, float f4) {
        if (getBarData() != null) {
            getBarData().S(f2, f3, f4);
            O();
            return;
        }
        throw new RuntimeException("You need to set data for the chart before grouping bars.");
    }

    public void Z0(float f2, int i2, int i3) {
        F(new Highlight(f2, i2, i3), false);
    }

    public boolean b() {
        return this.t4;
    }

    public boolean c() {
        return this.s4;
    }

    public boolean d() {
        return this.r4;
    }

    public BarData getBarData() {
        return (BarData) this.X2;
    }

    /* access modifiers changed from: protected */
    public void o() {
        XAxis xAxis;
        float y;
        float x;
        if (this.u4) {
            xAxis = this.e3;
            y = ((BarData) this.X2).y() - (((BarData) this.X2).Q() / 2.0f);
            x = ((BarData) this.X2).x() + (((BarData) this.X2).Q() / 2.0f);
        } else {
            xAxis = this.e3;
            y = ((BarData) this.X2).y();
            x = ((BarData) this.X2).x();
        }
        xAxis.n(y, x);
        YAxis yAxis = this.a4;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(((BarData) this.X2).C(axisDependency), ((BarData) this.X2).A(axisDependency));
        YAxis yAxis2 = this.b4;
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        yAxis2.n(((BarData) this.X2).C(axisDependency2), ((BarData) this.X2).A(axisDependency2));
    }

    public void setDrawBarShadow(boolean z) {
        this.t4 = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.s4 = z;
    }

    public void setFitBars(boolean z) {
        this.u4 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.r4 = z;
    }

    public Highlight x(float f2, float f3) {
        if (this.X2 == null) {
            Log.e(Chart.C3, "Can't select by touch. No data set.");
            return null;
        }
        Highlight a2 = getHighlighter().a(f2, f3);
        return (a2 == null || !d()) ? a2 : new Highlight(a2.h(), a2.j(), a2.i(), a2.k(), a2.d(), -1, a2.b());
    }

    public BarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
