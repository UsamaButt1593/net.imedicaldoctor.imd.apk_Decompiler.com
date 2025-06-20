package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class ChartHighlighter<T extends BarLineScatterCandleBubbleDataProvider> implements IHighlighter {

    /* renamed from: a  reason: collision with root package name */
    protected T f19018a;

    /* renamed from: b  reason: collision with root package name */
    protected List<Highlight> f19019b = new ArrayList();

    public ChartHighlighter(T t) {
        this.f19018a = t;
    }

    public Highlight a(float f2, float f3) {
        MPPointD j2 = j(f2, f3);
        MPPointD.c(j2);
        return f((float) j2.Y, f2, f3);
    }

    /* access modifiers changed from: protected */
    public List<Highlight> b(IDataSet iDataSet, int i2, float f2, DataSet.Rounding rounding) {
        Entry t0;
        ArrayList arrayList = new ArrayList();
        List<Entry> J0 = iDataSet.J0(f2);
        if (J0.size() == 0 && (t0 = iDataSet.t0(f2, Float.NaN, rounding)) != null) {
            J0 = iDataSet.J0(t0.m());
        }
        if (J0.size() == 0) {
            return arrayList;
        }
        for (Entry entry : J0) {
            MPPointD f3 = this.f19018a.a(iDataSet.a1()).f(entry.m(), entry.c());
            arrayList.add(new Highlight(entry.m(), entry.c(), (float) f3.Y, (float) f3.Z, i2, iDataSet.a1()));
        }
        return arrayList;
    }

    public Highlight c(List<Highlight> list, float f2, float f3, YAxis.AxisDependency axisDependency, float f4) {
        Highlight highlight = null;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Highlight highlight2 = list.get(i2);
            if (axisDependency == null || highlight2.b() == axisDependency) {
                float e2 = e(f2, f3, highlight2.i(), highlight2.k());
                if (e2 < f4) {
                    highlight = highlight2;
                    f4 = e2;
                }
            }
        }
        return highlight;
    }

    /* access modifiers changed from: protected */
    public BarLineScatterCandleBubbleData d() {
        return this.f19018a.getData();
    }

    /* access modifiers changed from: protected */
    public float e(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f2 - f4), (double) (f3 - f5));
    }

    /* access modifiers changed from: protected */
    public Highlight f(float f2, float f3, float f4) {
        List<Highlight> h2 = h(f2, f3, f4);
        if (h2.isEmpty()) {
            return null;
        }
        YAxis.AxisDependency axisDependency = YAxis.AxisDependency.LEFT;
        float i2 = i(h2, f4, axisDependency);
        YAxis.AxisDependency axisDependency2 = YAxis.AxisDependency.RIGHT;
        return c(h2, f3, f4, i2 < i(h2, f4, axisDependency2) ? axisDependency : axisDependency2, this.f19018a.getMaxHighlightDistance());
    }

    /* access modifiers changed from: protected */
    public float g(Highlight highlight) {
        return highlight.k();
    }

    /* access modifiers changed from: protected */
    public List<Highlight> h(float f2, float f3, float f4) {
        this.f19019b.clear();
        BarLineScatterCandleBubbleData d2 = d();
        if (d2 == null) {
            return this.f19019b;
        }
        int m2 = d2.m();
        for (int i2 = 0; i2 < m2; i2++) {
            IDataSet k2 = d2.k(i2);
            if (k2.i1()) {
                this.f19019b.addAll(b(k2, i2, f2, DataSet.Rounding.CLOSEST));
            }
        }
        return this.f19019b;
    }

    /* access modifiers changed from: protected */
    public float i(List<Highlight> list, float f2, YAxis.AxisDependency axisDependency) {
        float f3 = Float.MAX_VALUE;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Highlight highlight = list.get(i2);
            if (highlight.b() == axisDependency) {
                float abs = Math.abs(g(highlight) - f2);
                if (abs < f3) {
                    f3 = abs;
                }
            }
        }
        return f3;
    }

    /* access modifiers changed from: protected */
    public MPPointD j(float f2, float f3) {
        return this.f19018a.a(YAxis.AxisDependency.LEFT).j(f2, f3);
    }
}
