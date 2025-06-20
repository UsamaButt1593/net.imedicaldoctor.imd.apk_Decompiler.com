package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public class DefaultFillFormatter implements IFillFormatter {
    public float a(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        float yChartMax = lineDataProvider.getYChartMax();
        float yChartMin = lineDataProvider.getYChartMin();
        LineData lineData = lineDataProvider.getLineData();
        if (iLineDataSet.p() > 0.0f && iLineDataSet.J() < 0.0f) {
            return 0.0f;
        }
        if (lineData.z() > 0.0f) {
            yChartMax = 0.0f;
        }
        if (lineData.B() < 0.0f) {
            yChartMin = 0.0f;
        }
        return iLineDataSet.J() >= 0.0f ? yChartMin : yChartMax;
    }
}
