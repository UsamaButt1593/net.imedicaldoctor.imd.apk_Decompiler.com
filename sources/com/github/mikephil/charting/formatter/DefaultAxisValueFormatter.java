package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class DefaultAxisValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f19003a;

    /* renamed from: b  reason: collision with root package name */
    protected int f19004b;

    public DefaultAxisValueFormatter(int i2) {
        this.f19004b = i2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f19003a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public String h(float f2) {
        return this.f19003a.format((double) f2);
    }

    public int l() {
        return this.f19004b;
    }
}
