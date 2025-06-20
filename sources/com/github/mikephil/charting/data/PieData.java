package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;

public class PieData extends ChartData<IPieDataSet> {
    public PieData() {
    }

    public IPieDataSet Q() {
        return (IPieDataSet) this.f18988i.get(0);
    }

    /* renamed from: R */
    public IPieDataSet k(int i2) {
        if (i2 == 0) {
            return Q();
        }
        return null;
    }

    /* renamed from: S */
    public IPieDataSet l(String str, boolean z) {
        if (z) {
            if (!str.equalsIgnoreCase(((IPieDataSet) this.f18988i.get(0)).H())) {
                return null;
            }
        } else if (!str.equals(((IPieDataSet) this.f18988i.get(0)).H())) {
            return null;
        }
        return (IPieDataSet) this.f18988i.get(0);
    }

    public float T() {
        float f2 = 0.0f;
        for (int i2 = 0; i2 < Q().e1(); i2++) {
            f2 += ((PieEntry) Q().X(i2)).c();
        }
        return f2;
    }

    public void U(IPieDataSet iPieDataSet) {
        this.f18988i.clear();
        this.f18988i.add(iPieDataSet);
        E();
    }

    public Entry s(Highlight highlight) {
        return Q().X((int) highlight.h());
    }

    public PieData(IPieDataSet iPieDataSet) {
        super((T[]) new IPieDataSet[]{iPieDataSet});
    }
}
