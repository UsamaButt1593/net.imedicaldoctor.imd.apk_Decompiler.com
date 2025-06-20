package com.github.mikephil.charting.formatter;

import java.text.DecimalFormat;

public class DefaultValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    protected DecimalFormat f19005a;

    /* renamed from: b  reason: collision with root package name */
    protected int f19006b;

    public DefaultValueFormatter(int i2) {
        m(i2);
    }

    public String h(float f2) {
        return this.f19005a.format((double) f2);
    }

    public int l() {
        return this.f19006b;
    }

    public void m(int i2) {
        this.f19006b = i2;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.f19005a = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
