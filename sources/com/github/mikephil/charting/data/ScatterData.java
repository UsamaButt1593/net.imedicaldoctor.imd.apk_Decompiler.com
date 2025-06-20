package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import java.util.List;

public class ScatterData extends BarLineScatterCandleBubbleData<IScatterDataSet> {
    public ScatterData() {
    }

    public float Q() {
        float f2 = 0.0f;
        for (T p0 : this.f18988i) {
            float p02 = p0.p0();
            if (p02 > f2) {
                f2 = p02;
            }
        }
        return f2;
    }

    public ScatterData(List<IScatterDataSet> list) {
        super(list);
    }

    public ScatterData(IScatterDataSet... iScatterDataSetArr) {
        super((T[]) iScatterDataSetArr);
    }
}
