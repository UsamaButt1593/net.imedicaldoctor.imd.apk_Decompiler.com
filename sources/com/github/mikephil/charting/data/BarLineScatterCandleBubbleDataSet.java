package com.github.mikephil.charting.data;

import android.graphics.Color;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.List;

public abstract class BarLineScatterCandleBubbleDataSet<T extends Entry> extends DataSet<T> implements IBarLineScatterCandleBubbleDataSet<T> {
    protected int x = Color.rgb(255, 187, 115);

    public BarLineScatterCandleBubbleDataSet(List<T> list, String str) {
        super(list, str);
    }

    /* access modifiers changed from: protected */
    public void S1(BarLineScatterCandleBubbleDataSet barLineScatterCandleBubbleDataSet) {
        super.O1(barLineScatterCandleBubbleDataSet);
        barLineScatterCandleBubbleDataSet.x = this.x;
    }

    public void T1(int i2) {
        this.x = i2;
    }

    public int Y0() {
        return this.x;
    }
}
