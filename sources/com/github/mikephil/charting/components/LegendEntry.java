package com.github.mikephil.charting.components;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.utils.ColorTemplate;

public class LegendEntry {

    /* renamed from: a  reason: collision with root package name */
    public String f18952a;

    /* renamed from: b  reason: collision with root package name */
    public Legend.LegendForm f18953b;

    /* renamed from: c  reason: collision with root package name */
    public float f18954c;

    /* renamed from: d  reason: collision with root package name */
    public float f18955d;

    /* renamed from: e  reason: collision with root package name */
    public DashPathEffect f18956e;

    /* renamed from: f  reason: collision with root package name */
    public int f18957f;

    public LegendEntry() {
        this.f18953b = Legend.LegendForm.DEFAULT;
        this.f18954c = Float.NaN;
        this.f18955d = Float.NaN;
        this.f18956e = null;
        this.f18957f = ColorTemplate.f19136a;
    }

    public LegendEntry(String str, Legend.LegendForm legendForm, float f2, float f3, DashPathEffect dashPathEffect, int i2) {
        Legend.LegendForm legendForm2 = Legend.LegendForm.DEFAULT;
        this.f18952a = str;
        this.f18953b = legendForm;
        this.f18954c = f2;
        this.f18955d = f3;
        this.f18956e = dashPathEffect;
        this.f18957f = i2;
    }
}
