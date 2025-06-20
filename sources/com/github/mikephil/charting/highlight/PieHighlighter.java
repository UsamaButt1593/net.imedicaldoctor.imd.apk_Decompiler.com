package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

public class PieHighlighter extends PieRadarHighlighter<PieChart> {
    public PieHighlighter(PieChart pieChart) {
        super(pieChart);
    }

    /* access modifiers changed from: protected */
    public Highlight b(int i2, float f2, float f3) {
        IPieDataSet Q = ((PieData) ((PieChart) this.f19031a).getData()).Q();
        return new Highlight((float) i2, Q.X(i2).c(), f2, f3, 0, Q.a1());
    }
}
