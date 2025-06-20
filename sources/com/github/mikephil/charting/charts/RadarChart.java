package com.github.mikephil.charting.charts;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.highlight.RadarHighlighter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.renderer.RadarChartRenderer;
import com.github.mikephil.charting.renderer.XAxisRendererRadarChart;
import com.github.mikephil.charting.renderer.YAxisRendererRadarChart;
import com.github.mikephil.charting.utils.Utils;

public class RadarChart extends PieRadarChartBase<RadarData> {
    private float N3 = 2.5f;
    private float O3 = 1.5f;
    private int P3 = Color.rgb(122, 122, 122);
    private int Q3 = Color.rgb(122, 122, 122);
    private int R3 = 150;
    private boolean S3 = true;
    private int T3 = 0;
    private YAxis U3;
    protected YAxisRendererRadarChart V3;
    protected XAxisRendererRadarChart W3;

    public RadarChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.U3 = new YAxis(YAxis.AxisDependency.LEFT);
        this.N3 = Utils.e(1.5f);
        this.O3 = Utils.e(0.75f);
        this.n3 = new RadarChartRenderer(this, this.q3, this.p3);
        this.V3 = new YAxisRendererRadarChart(this.p3, this.U3, this);
        this.W3 = new XAxisRendererRadarChart(this.p3, this.e3, this);
        this.o3 = new RadarHighlighter(this);
    }

    public void O() {
        if (this.X2 != null) {
            o();
            YAxisRendererRadarChart yAxisRendererRadarChart = this.V3;
            YAxis yAxis = this.U3;
            yAxisRendererRadarChart.a(yAxis.H, yAxis.G, yAxis.I0());
            XAxisRendererRadarChart xAxisRendererRadarChart = this.W3;
            XAxis xAxis = this.e3;
            xAxisRendererRadarChart.a(xAxis.H, xAxis.G, false);
            Legend legend = this.h3;
            if (legend != null && !legend.I()) {
                this.m3.a(this.X2);
            }
            p();
        }
    }

    public int b0(float f2) {
        float z = Utils.z(f2 - getRotationAngle());
        float sliceAngle = getSliceAngle();
        int e1 = ((IRadarDataSet) ((RadarData) this.X2).w()).e1();
        int i2 = 0;
        while (i2 < e1) {
            int i3 = i2 + 1;
            if ((((float) i3) * sliceAngle) - (sliceAngle / 2.0f) > z) {
                return i2;
            }
            i2 = i3;
        }
        return 0;
    }

    public float getFactor() {
        RectF q = this.p3.q();
        return Math.min(q.width() / 2.0f, q.height() / 2.0f) / this.U3.I;
    }

    public float getRadius() {
        RectF q = this.p3.q();
        return Math.min(q.width() / 2.0f, q.height() / 2.0f);
    }

    /* access modifiers changed from: protected */
    public float getRequiredBaseOffset() {
        return (!this.e3.f() || !this.e3.P()) ? Utils.e(10.0f) : (float) this.e3.L;
    }

    /* access modifiers changed from: protected */
    public float getRequiredLegendOffset() {
        return this.m3.e().getTextSize() * 4.0f;
    }

    public int getSkipWebLineCount() {
        return this.T3;
    }

    public float getSliceAngle() {
        return 360.0f / ((float) ((IRadarDataSet) ((RadarData) this.X2).w()).e1());
    }

    public int getWebAlpha() {
        return this.R3;
    }

    public int getWebColor() {
        return this.P3;
    }

    public int getWebColorInner() {
        return this.Q3;
    }

    public float getWebLineWidth() {
        return this.N3;
    }

    public float getWebLineWidthInner() {
        return this.O3;
    }

    public YAxis getYAxis() {
        return this.U3;
    }

    public float getYChartMax() {
        return this.U3.G;
    }

    public float getYChartMin() {
        return this.U3.H;
    }

    public float getYRange() {
        return this.U3.I;
    }

    /* access modifiers changed from: protected */
    public void o() {
        super.o();
        YAxis yAxis = this.U3;
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        yAxis.n(((RadarData) this.X2).C(axisDependency), ((RadarData) this.X2).A(axisDependency));
        this.e3.n(0.0f, (float) ((IRadarDataSet) ((RadarData) this.X2).w()).e1());
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.X2 != null) {
            if (this.e3.f()) {
                XAxisRendererRadarChart xAxisRendererRadarChart = this.W3;
                XAxis xAxis = this.e3;
                xAxisRendererRadarChart.a(xAxis.H, xAxis.G, false);
            }
            this.W3.g(canvas);
            if (this.S3) {
                this.n3.c(canvas);
            }
            if (this.U3.f() && this.U3.Q()) {
                this.V3.j(canvas);
            }
            this.n3.b(canvas);
            if (Y()) {
                this.n3.d(canvas, this.w3);
            }
            if (this.U3.f() && !this.U3.Q()) {
                this.V3.j(canvas);
            }
            this.V3.g(canvas);
            this.n3.f(canvas);
            this.m3.f(canvas);
            u(canvas);
            v(canvas);
        }
    }

    public void setDrawWeb(boolean z) {
        this.S3 = z;
    }

    public void setSkipWebLineCount(int i2) {
        this.T3 = Math.max(0, i2);
    }

    public void setWebAlpha(int i2) {
        this.R3 = i2;
    }

    public void setWebColor(int i2) {
        this.P3 = i2;
    }

    public void setWebColorInner(int i2) {
        this.Q3 = i2;
    }

    public void setWebLineWidth(float f2) {
        this.N3 = Utils.e(f2);
    }

    public void setWebLineWidthInner(float f2) {
        this.O3 = Utils.e(f2);
    }

    public RadarChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
