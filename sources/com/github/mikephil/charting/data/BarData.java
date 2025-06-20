package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.List;

public class BarData extends BarLineScatterCandleBubbleData<IBarDataSet> {

    /* renamed from: j  reason: collision with root package name */
    private float f18965j = 0.85f;

    public BarData() {
    }

    public float Q() {
        return this.f18965j;
    }

    public float R(float f2, float f3) {
        return (((float) this.f18988i.size()) * (this.f18965j + f3)) + f2;
    }

    public void S(float f2, float f3, float f4) {
        BarEntry barEntry;
        if (this.f18988i.size() > 1) {
            int e1 = ((IBarDataSet) w()).e1();
            float f5 = f3 / 2.0f;
            float f6 = f4 / 2.0f;
            float f7 = this.f18965j / 2.0f;
            float R = R(f3, f4);
            for (int i2 = 0; i2 < e1; i2++) {
                float f8 = f2 + f5;
                for (T t : this.f18988i) {
                    float f9 = f8 + f6 + f7;
                    if (i2 < t.e1() && (barEntry = (BarEntry) t.X(i2)) != null) {
                        barEntry.o(f9);
                    }
                    f8 = f9 + f7 + f6;
                }
                float f10 = f8 + f5;
                float f11 = R - (f10 - f2);
                if (f11 > 0.0f || f11 < 0.0f) {
                    f10 += f11;
                }
                f2 = f10;
            }
            E();
            return;
        }
        throw new RuntimeException("BarData needs to hold at least 2 BarDataSets to allow grouping.");
    }

    public void T(float f2) {
        this.f18965j = f2;
    }

    public BarData(List<IBarDataSet> list) {
        super(list);
    }

    public BarData(IBarDataSet... iBarDataSetArr) {
        super((T[]) iBarDataSetArr);
    }
}
