package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieEntry;
import java.text.DecimalFormat;

public class PercentFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f19013a;

    /* renamed from: b  reason: collision with root package name */
    private PieChart f19014b;

    public PercentFormatter() {
        this.f19013a = new DecimalFormat("###,###,##0.0");
    }

    public String h(float f2) {
        return this.f19013a.format((double) f2) + " %";
    }

    public String i(float f2, PieEntry pieEntry) {
        PieChart pieChart = this.f19014b;
        return (pieChart == null || !pieChart.p0()) ? this.f19013a.format((double) f2) : h(f2);
    }

    public PercentFormatter(PieChart pieChart) {
        this();
        this.f19014b = pieChart;
    }
}
