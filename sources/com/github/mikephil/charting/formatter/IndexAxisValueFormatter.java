package com.github.mikephil.charting.formatter;

import java.util.Collection;

public class IndexAxisValueFormatter extends ValueFormatter {

    /* renamed from: a  reason: collision with root package name */
    private String[] f19007a = new String[0];

    /* renamed from: b  reason: collision with root package name */
    private int f19008b = 0;

    public IndexAxisValueFormatter() {
    }

    public String h(float f2) {
        int round = Math.round(f2);
        return (round < 0 || round >= this.f19008b || round != ((int) f2)) ? "" : this.f19007a[round];
    }

    public String[] l() {
        return this.f19007a;
    }

    public void m(String[] strArr) {
        if (strArr == null) {
            strArr = new String[0];
        }
        this.f19007a = strArr;
        this.f19008b = strArr.length;
    }

    public IndexAxisValueFormatter(Collection<String> collection) {
        if (collection != null) {
            m((String[]) collection.toArray(new String[collection.size()]));
        }
    }

    public IndexAxisValueFormatter(String[] strArr) {
        if (strArr != null) {
            m(strArr);
        }
    }
}
