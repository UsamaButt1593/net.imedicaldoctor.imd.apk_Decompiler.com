package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private boolean f19015a;

    /* renamed from: b  reason: collision with root package name */
    private String f19016b;

    /* renamed from: c  reason: collision with root package name */
    private DecimalFormat f19017c;

    public StackedValueFormatter(boolean z, String str, int i2) {
        this.f19015a = z;
        this.f19016b = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f19017c = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String e(float f2, BarEntry barEntry) {
        float[] I;
        if (this.f19015a || (I = barEntry.I()) == null) {
            return this.f19017c.format((double) f2) + this.f19016b;
        } else if (I[I.length - 1] != f2) {
            return "";
        } else {
            return this.f19017c.format((double) barEntry.c()) + this.f19016b;
        }
    }
}
