package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.dataprovider.CombinedDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import java.util.List;

public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements IHighlighter {

    /* renamed from: c  reason: collision with root package name */
    protected BarHighlighter f19020c;

    public CombinedHighlighter(CombinedDataProvider combinedDataProvider, BarDataProvider barDataProvider) {
        super(combinedDataProvider);
        this.f19020c = barDataProvider.getBarData() == null ? null : new BarHighlighter(barDataProvider);
    }

    /* access modifiers changed from: protected */
    public List<Highlight> h(float f2, float f3, float f4) {
        this.f19019b.clear();
        List<BarLineScatterCandleBubbleData> Q = ((CombinedDataProvider) this.f19018a).getCombinedData().Q();
        for (int i2 = 0; i2 < Q.size(); i2++) {
            ChartData chartData = Q.get(i2);
            BarHighlighter barHighlighter = this.f19020c;
            if (barHighlighter == null || !(chartData instanceof BarData)) {
                int m2 = chartData.m();
                for (int i3 = 0; i3 < m2; i3++) {
                    IDataSet k2 = Q.get(i2).k(i3);
                    if (k2.i1()) {
                        for (Highlight next : b(k2, i3, f2, DataSet.Rounding.CLOSEST)) {
                            next.m(i2);
                            this.f19019b.add(next);
                        }
                    }
                }
            } else {
                Highlight a2 = barHighlighter.a(f3, f4);
                if (a2 != null) {
                    a2.m(i2);
                    this.f19019b.add(a2);
                }
            }
        }
        return this.f19019b;
    }
}
