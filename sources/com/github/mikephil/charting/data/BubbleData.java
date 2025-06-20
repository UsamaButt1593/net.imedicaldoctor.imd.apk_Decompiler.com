package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import java.util.List;

public class BubbleData extends BarLineScatterCandleBubbleData<IBubbleDataSet> {
    public BubbleData() {
    }

    public void Q(float f2) {
        for (T g0 : this.f18988i) {
            g0.g0(f2);
        }
    }

    public BubbleData(List<IBubbleDataSet> list) {
        super(list);
    }

    public BubbleData(IBubbleDataSet... iBubbleDataSetArr) {
        super((T[]) iBubbleDataSetArr);
    }
}
