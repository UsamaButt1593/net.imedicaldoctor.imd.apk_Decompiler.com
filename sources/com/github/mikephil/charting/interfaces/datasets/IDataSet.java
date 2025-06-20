package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;
import java.util.List;

public interface IDataSet<T extends Entry> {
    boolean B();

    List<Integer> B0();

    Legend.LegendForm C();

    void D(Typeface typeface);

    void E0(float f2, float f3);

    int G();

    void G0(List<Integer> list);

    String H();

    void I0(MPPointF mPPointF);

    float J();

    List<T> J0(float f2);

    void K0();

    GradientColor M();

    int N(int i2);

    List<GradientColor> N0();

    void P(int i2);

    float R0();

    float S();

    ValueFormatter T();

    boolean V0();

    float W();

    T X(int i2);

    YAxis.AxisDependency a1();

    void b(boolean z);

    float b0();

    boolean b1(int i2);

    void c1(boolean z);

    void clear();

    int d0(int i2);

    int e1();

    MPPointF f1();

    int g1();

    void i0(boolean z);

    boolean i1();

    boolean isVisible();

    void k(YAxis.AxisDependency axisDependency);

    Typeface k0();

    void l1(T t);

    boolean m0();

    GradientColor m1(int i2);

    float n();

    boolean n0(T t);

    int o0(float f2, float f3, DataSet.Rounding rounding);

    void o1(String str);

    float p();

    boolean q(float f2);

    boolean r0(T t);

    boolean removeFirst();

    boolean removeLast();

    int s(T t);

    void s0(ValueFormatter valueFormatter);

    void setVisible(boolean z);

    T t0(float f2, float f3, DataSet.Rounding rounding);

    int u0(int i2);

    DashPathEffect w();

    T x(float f2, float f3);

    boolean x0(T t);

    void z0(float f2);
}
