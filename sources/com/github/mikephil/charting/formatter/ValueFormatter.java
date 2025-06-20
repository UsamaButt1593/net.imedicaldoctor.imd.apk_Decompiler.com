package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class ValueFormatter implements IAxisValueFormatter, IValueFormatter {
    @Deprecated
    public String a(float f2, AxisBase axisBase) {
        return h(f2);
    }

    @Deprecated
    public String b(float f2, Entry entry, int i2, ViewPortHandler viewPortHandler) {
        return h(f2);
    }

    public String c(float f2, AxisBase axisBase) {
        return h(f2);
    }

    public String d(BarEntry barEntry) {
        return h(barEntry.c());
    }

    public String e(float f2, BarEntry barEntry) {
        return h(f2);
    }

    public String f(BubbleEntry bubbleEntry) {
        return h(bubbleEntry.t());
    }

    public String g(CandleEntry candleEntry) {
        return h(candleEntry.z());
    }

    public String h(float f2) {
        return String.valueOf(f2);
    }

    public String i(float f2, PieEntry pieEntry) {
        return h(f2);
    }

    public String j(Entry entry) {
        return h(entry.c());
    }

    public String k(RadarEntry radarEntry) {
        return h(radarEntry.c());
    }
}
