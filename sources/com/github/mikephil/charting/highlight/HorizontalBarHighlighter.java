package com.github.mikephil.charting.highlight;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.dataprovider.BarDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointD;
import java.util.ArrayList;
import java.util.List;

public class HorizontalBarHighlighter extends BarHighlighter {
    public HorizontalBarHighlighter(BarDataProvider barDataProvider) {
        super(barDataProvider);
    }

    public Highlight a(float f2, float f3) {
        BarData barData = ((BarDataProvider) this.f19018a).getBarData();
        MPPointD j2 = j(f3, f2);
        Highlight f4 = f((float) j2.Z, f3, f2);
        if (f4 == null) {
            return null;
        }
        IBarDataSet iBarDataSet = (IBarDataSet) barData.k(f4.d());
        if (iBarDataSet.U0()) {
            return l(f4, iBarDataSet, (float) j2.Z, (float) j2.Y);
        }
        MPPointD.c(j2);
        return f4;
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
            MPPointD f3 = ((BarDataProvider) this.f19018a).a(iDataSet.a1()).f(entry.c(), entry.m());
            arrayList.add(new Highlight(entry.m(), entry.c(), (float) f3.Y, (float) f3.Z, i2, iDataSet.a1()));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public float e(float f2, float f3, float f4, float f5) {
        return Math.abs(f3 - f5);
    }
}
