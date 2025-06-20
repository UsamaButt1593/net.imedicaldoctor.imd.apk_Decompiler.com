package com.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.renderer.DataRenderer;
import com.github.mikephil.charting.renderer.LineChartRenderer;

public class LineChart extends BarLineChartBase<LineData> implements LineDataProvider {
    public LineChart(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void H() {
        super.H();
        this.n3 = new LineChartRenderer(this, this.q3, this.p3);
    }

    public LineData getLineData() {
        return (LineData) this.X2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        DataRenderer dataRenderer = this.n3;
        if (dataRenderer != null && (dataRenderer instanceof LineChartRenderer)) {
            ((LineChartRenderer) dataRenderer).A();
        }
        super.onDetachedFromWindow();
    }

    public LineChart(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineChart(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
