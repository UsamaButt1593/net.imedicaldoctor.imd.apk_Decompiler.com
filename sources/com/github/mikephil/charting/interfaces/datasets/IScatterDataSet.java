package com.github.mikephil.charting.interfaces.datasets;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.renderer.scatter.IShapeRenderer;

public interface IScatterDataSet extends ILineScatterCandleRadarDataSet<Entry> {
    int H0();

    IShapeRenderer O0();

    float p0();

    float q1();
}
