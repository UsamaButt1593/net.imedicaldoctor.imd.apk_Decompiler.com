package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.MPPointD;

public class BarHighlighter extends ChartHighlighter<BarDataProvider> {
    public BarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    public Highlight a(float f2, float f3) {
        Highlight a2 = super.a(f2, f3);
        if (a2 == null) {
            return null;
        }
        MPPointD j2 = j(f2, f3);
        IBarDataSet iBarDataSet = (IBarDataSet) ((BarDataProvider) this.f19018a).getBarData().k(a2.d());
        if (iBarDataSet.U0()) {
            return l(a2, iBarDataSet, (float) j2.Y, (float) j2.Z);
        }
        MPPointD.c(j2);
        return a2;
    }

    /* access modifiers changed from: protected */
    public BarLineScatterCandleBubbleData d() {
        return ((BarDataProvider) this.f19018a).getBarData();
    }

    /* access modifiers changed from: protected */
    public float e(float f2, float f3, float f4, float f5) {
        return Math.abs(f2 - f4);
    }

    /* access modifiers changed from: protected */
    public int k(Range[] rangeArr, float f2) {
        if (rangeArr == null || rangeArr.length == 0) {
            return 0;
        }
        int i2 = 0;
        for (Range a2 : rangeArr) {
            if (a2.a(f2)) {
                return i2;
            }
            i2++;
        }
        int max = Math.max(rangeArr.length - 1, 0);
        if (f2 > rangeArr[max].f19034b) {
            return max;
        }
        return 0;
    }

    public Highlight l(Highlight highlight, IBarDataSet iBarDataSet, float f2, float f3) {
        BarEntry barEntry = (BarEntry) iBarDataSet.x(f2, f3);
        if (barEntry == null) {
            return null;
        }
        if (barEntry.I() == null) {
            return highlight;
        }
        Range[] E = barEntry.E();
        if (E.length <= 0) {
            return null;
        }
        int k2 = k(E, f3);
        MPPointD f4 = ((BarDataProvider) this.f19018a).a(iBarDataSet.a1()).f(highlight.h(), E[k2].f19034b);
        Highlight highlight2 = new Highlight(barEntry.m(), barEntry.c(), (float) f4.Y, (float) f4.Z, highlight.d(), k2, highlight.b());
        MPPointD.c(f4);
        return highlight2;
    }
}
