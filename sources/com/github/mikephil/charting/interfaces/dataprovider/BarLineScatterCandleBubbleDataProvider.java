package com.github.mikephil.charting.interfaces.dataprovider;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {
    Transformer a(YAxis.AxisDependency axisDependency);

    boolean f(YAxis.AxisDependency axisDependency);

    BarLineScatterCandleBubbleData getData();

    float getHighestVisibleX();

    float getLowestVisibleX();
}
