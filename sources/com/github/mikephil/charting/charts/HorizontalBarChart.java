package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.highlight.HorizontalBarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.renderer.HorizontalBarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.renderer.YAxisRendererHorizontalBarChart;
import com.github.mikephil.charting.utils.HorizontalViewPortHandler;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.TransformerHorizontalBarChart;
import com.github.mikephil.charting.utils.Utils;

public class HorizontalBarChart extends BarChart {
    private RectF v4 = new RectF();
    protected float[] w4 = new float[2];

    public HorizontalBarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void G0() {
        Transformer transformer = this.f4;
        YAxis yAxis = this.b4;
        float f2 = yAxis.H;
        float f3 = yAxis.I;
        XAxis xAxis = this.e3;
        transformer.q(f2, f3, xAxis.I, xAxis.H);
        Transformer transformer2 = this.e4;
        YAxis yAxis2 = this.a4;
        float f4 = yAxis2.H;
        float f5 = yAxis2.I;
        XAxis xAxis2 = this.e3;
        transformer2.q(f4, f5, xAxis2.I, xAxis2.H);
    }

    /* access modifiers changed from: protected */
    public void H() {
        this.p3 = new HorizontalViewPortHandler();
        super.H();
        this.e4 = new TransformerHorizontalBarChart(this.p3);
        this.f4 = new TransformerHorizontalBarChart(this.p3);
        this.n3 = new HorizontalBarChartRenderer(this, this.q3, this.p3);
        setHighlighter(new HorizontalBarHighlighter(this));
        this.c4 = new YAxisRendererHorizontalBarChart(this.p3, this.a4, this.e4);
        this.d4 = new YAxisRendererHorizontalBarChart(this.p3, this.b4, this.f4);
        this.g4 = new XAxisRendererHorizontalBarChart(this.p3, this.e3, this.e4, this);
    }

    public void M0(float f2, float f3) {
        float f4 = this.e3.I;
        this.p3.b0(f4 / f2, f4 / f3);
    }

    public void N0(float f2, float f3, YAxis.AxisDependency axisDependency) {
        this.p3.a0(g0(axisDependency) / f2, g0(axisDependency) / f3);
    }

    public void O0(float f2, YAxis.AxisDependency axisDependency) {
        this.p3.c0(g0(axisDependency) / f2);
    }

    public void P0(float f2, YAxis.AxisDependency axisDependency) {
        this.p3.Y(g0(axisDependency) / f2);
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
        rectF.set(f4, f2, c2, f3);
        a(iBarDataSet.a1()).t(rectF);
    }

    public float getHighestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.p3.h(), this.p3.j(), this.p4);
        return (float) Math.min((double) this.e3.G, this.p4.Z);
    }

    public float getLowestVisibleX() {
        a(YAxis.AxisDependency.LEFT).k(this.p3.h(), this.p3.f(), this.o4);
        return (float) Math.max((double) this.e3.H, this.o4.Z);
    }

    public MPPointF k0(Entry entry, YAxis.AxisDependency axisDependency) {
        if (entry == null) {
            return null;
        }
        float[] fArr = this.w4;
        fArr[0] = entry.c();
        fArr[1] = entry.m();
        a(axisDependency).o(fArr);
        return MPPointF.c(fArr[0], fArr[1]);
    }

    public void p() {
        a0(this.v4);
        RectF rectF = this.v4;
        float f2 = rectF.left + 0.0f;
        float f3 = rectF.top + 0.0f;
        float f4 = rectF.right + 0.0f;
        float f5 = rectF.bottom + 0.0f;
        if (this.a4.L0()) {
            f3 += this.a4.z0(this.c4.c());
        }
        if (this.b4.L0()) {
            f5 += this.b4.z0(this.d4.c());
        }
        XAxis xAxis = this.e3;
        float f6 = (float) xAxis.L;
        if (xAxis.f()) {
            if (this.e3.w0() == XAxis.XAxisPosition.BOTTOM) {
                f2 += f6;
            } else {
                if (this.e3.w0() != XAxis.XAxisPosition.TOP) {
                    if (this.e3.w0() == XAxis.XAxisPosition.BOTH_SIDED) {
                        f2 += f6;
                    }
                }
                f4 += f6;
            }
        }
        float extraTopOffset = f3 + getExtraTopOffset();
        float extraRightOffset = f4 + getExtraRightOffset();
        float extraBottomOffset = f5 + getExtraBottomOffset();
        float extraLeftOffset = f2 + getExtraLeftOffset();
        float e2 = Utils.e(this.X3);
        this.p3.U(Math.max(e2, extraLeftOffset), Math.max(e2, extraTopOffset), Math.max(e2, extraRightOffset), Math.max(e2, extraBottomOffset));
        if (this.s) {
            Log.i(Chart.C3, "offsetLeft: " + extraLeftOffset + ", offsetTop: " + extraTopOffset + ", offsetRight: " + extraRightOffset + ", offsetBottom: " + extraBottomOffset);
            StringBuilder sb = new StringBuilder();
            sb.append("Content: ");
            sb.append(this.p3.q().toString());
            Log.i(Chart.C3, sb.toString());
        }
        F0();
        G0();
    }

    public void setVisibleXRangeMaximum(float f2) {
        this.p3.d0(this.e3.I / f2);
    }

    public void setVisibleXRangeMinimum(float f2) {
        this.p3.Z(this.e3.I / f2);
    }

    public Highlight x(float f2, float f3) {
        if (this.X2 != null) {
            return getHighlighter().a(f3, f2);
        }
        if (!this.s) {
            return null;
        }
        Log.e(Chart.C3, "Can't select by touch. No data set.");
        return null;
    }

    /* access modifiers changed from: protected */
    public float[] y(Highlight highlight) {
        return new float[]{highlight.f(), highlight.e()};
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HorizontalBarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
