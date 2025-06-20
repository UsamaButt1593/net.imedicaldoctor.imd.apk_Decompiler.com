package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import java.util.ArrayList;
import java.util.List;

public abstract class PieRadarHighlighter<T extends PieRadarChartBase> implements IHighlighter {

    /* renamed from: a  reason: collision with root package name */
    protected T f19031a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Highlight> f19032b = new ArrayList();

    public PieRadarHighlighter(T t) {
        this.f19031a = t;
    }

    public Highlight a(float f2, float f3) {
        if (this.f19031a.Z(f2, f3) > this.f19031a.getRadius()) {
            return null;
        }
        float a0 = this.f19031a.a0(f2, f3);
        T t = this.f19031a;
        if (t instanceof PieChart) {
            a0 /= t.getAnimator().i();
        }
        int b0 = this.f19031a.b0(a0);
        if (b0 < 0 || b0 >= this.f19031a.getData().w().e1()) {
            return null;
        }
        return b(b0, f2, f3);
    }

    /* access modifiers changed from: protected */
    public abstract Highlight b(int i2, float f2, float f3);
}
