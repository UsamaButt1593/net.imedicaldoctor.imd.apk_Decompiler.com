package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;

public interface ILineDataSet extends ILineRadarDataSet<Entry> {
    boolean A();

    int E();

    float L();

    DashPathEffect O();

    float Y();

    int Z0(int i2);

    LineDataSet.Mode c0();

    int f();

    boolean h1();

    float k1();

    IFillFormatter o();

    boolean r1();

    @Deprecated
    boolean s1();

    @Deprecated
    boolean y();
}
