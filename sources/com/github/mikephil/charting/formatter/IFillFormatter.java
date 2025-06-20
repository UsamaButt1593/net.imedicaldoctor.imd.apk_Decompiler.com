package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

public interface IFillFormatter {
    float a(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider);
}
