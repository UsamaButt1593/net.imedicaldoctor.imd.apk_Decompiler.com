package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDataSet<T extends Entry> implements IDataSet<T> {

    /* renamed from: a  reason: collision with root package name */
    protected List<Integer> f18966a;

    /* renamed from: b  reason: collision with root package name */
    protected GradientColor f18967b;

    /* renamed from: c  reason: collision with root package name */
    protected List<GradientColor> f18968c;

    /* renamed from: d  reason: collision with root package name */
    protected List<Integer> f18969d;

    /* renamed from: e  reason: collision with root package name */
    private String f18970e;

    /* renamed from: f  reason: collision with root package name */
    protected YAxis.AxisDependency f18971f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f18972g;

    /* renamed from: h  reason: collision with root package name */
    protected transient ValueFormatter f18973h;

    /* renamed from: i  reason: collision with root package name */
    protected Typeface f18974i;

    /* renamed from: j  reason: collision with root package name */
    private Legend.LegendForm f18975j;

    /* renamed from: k  reason: collision with root package name */
    private float f18976k;

    /* renamed from: l  reason: collision with root package name */
    private float f18977l;

    /* renamed from: m  reason: collision with root package name */
    private DashPathEffect f18978m;

    /* renamed from: n  reason: collision with root package name */
    protected boolean f18979n;
    protected boolean o;
    protected MPPointF p;
    protected float q;
    protected boolean r;

    public BaseDataSet() {
        this.f18966a = null;
        this.f18967b = null;
        this.f18968c = null;
        this.f18969d = null;
        this.f18970e = "DataSet";
        this.f18971f = YAxis.AxisDependency.LEFT;
        this.f18972g = true;
        this.f18975j = Legend.LegendForm.DEFAULT;
        this.f18976k = Float.NaN;
        this.f18977l = Float.NaN;
        this.f18978m = null;
        this.f18979n = true;
        this.o = true;
        this.p = new MPPointF();
        this.q = 17.0f;
        this.r = true;
        this.f18966a = new ArrayList();
        this.f18969d = new ArrayList();
        this.f18966a.add(Integer.valueOf(Color.rgb(140, 234, 255)));
        this.f18969d.add(Integer.valueOf(ViewCompat.y));
    }

    public void A1(List<Integer> list) {
        this.f18966a = list;
    }

    public boolean B() {
        return this.o;
    }

    public List<Integer> B0() {
        return this.f18966a;
    }

    public void B1(int... iArr) {
        this.f18966a = ColorTemplate.c(iArr);
    }

    public Legend.LegendForm C() {
        return this.f18975j;
    }

    public void C1(int[] iArr, int i2) {
        x1();
        for (int i3 : iArr) {
            t1(Color.argb(i2, Color.red(i3), Color.green(i3), Color.blue(i3)));
        }
    }

    public void D(Typeface typeface) {
        this.f18974i = typeface;
    }

    public void D1(int[] iArr, Context context) {
        if (this.f18966a == null) {
            this.f18966a = new ArrayList();
        }
        this.f18966a.clear();
        for (int color : iArr) {
            this.f18966a.add(Integer.valueOf(context.getResources().getColor(color)));
        }
    }

    public void E1(Legend.LegendForm legendForm) {
        this.f18975j = legendForm;
    }

    public void F1(DashPathEffect dashPathEffect) {
        this.f18978m = dashPathEffect;
    }

    public int G() {
        return this.f18969d.get(0).intValue();
    }

    public void G0(List<Integer> list) {
        this.f18969d = list;
    }

    public void G1(float f2) {
        this.f18977l = f2;
    }

    public String H() {
        return this.f18970e;
    }

    public void H1(float f2) {
        this.f18976k = f2;
    }

    public void I0(MPPointF mPPointF) {
        MPPointF mPPointF2 = this.p;
        mPPointF2.Y = mPPointF.Y;
        mPPointF2.Z = mPPointF.Z;
    }

    public void I1(int i2, int i3) {
        this.f18967b = new GradientColor(i2, i3);
    }

    public void J1(List<GradientColor> list) {
        this.f18968c = list;
    }

    public GradientColor M() {
        return this.f18967b;
    }

    public int N(int i2) {
        for (int i3 = 0; i3 < e1(); i3++) {
            if (((float) i2) == X(i3).m()) {
                return i3;
            }
        }
        return -1;
    }

    public List<GradientColor> N0() {
        return this.f18968c;
    }

    public void P(int i2) {
        this.f18969d.clear();
        this.f18969d.add(Integer.valueOf(i2));
    }

    public float S() {
        return this.q;
    }

    public ValueFormatter T() {
        return m0() ? Utils.s() : this.f18973h;
    }

    public boolean V0() {
        return this.f18979n;
    }

    public float W() {
        return this.f18977l;
    }

    public YAxis.AxisDependency a1() {
        return this.f18971f;
    }

    public void b(boolean z) {
        this.f18972g = z;
    }

    public float b0() {
        return this.f18976k;
    }

    public boolean b1(int i2) {
        return n0(X(i2));
    }

    public void c1(boolean z) {
        this.f18979n = z;
    }

    public int d0(int i2) {
        List<Integer> list = this.f18966a;
        return list.get(i2 % list.size()).intValue();
    }

    public MPPointF f1() {
        return this.p;
    }

    public int g1() {
        return this.f18966a.get(0).intValue();
    }

    public void i0(boolean z) {
        this.o = z;
    }

    public boolean i1() {
        return this.f18972g;
    }

    public boolean isVisible() {
        return this.r;
    }

    public void k(YAxis.AxisDependency axisDependency) {
        this.f18971f = axisDependency;
    }

    public Typeface k0() {
        return this.f18974i;
    }

    public boolean m0() {
        return this.f18973h == null;
    }

    public GradientColor m1(int i2) {
        List<GradientColor> list = this.f18968c;
        return list.get(i2 % list.size());
    }

    public void o1(String str) {
        this.f18970e = str;
    }

    public boolean q(float f2) {
        return n0(x(f2, Float.NaN));
    }

    public boolean removeFirst() {
        if (e1() > 0) {
            return n0(X(0));
        }
        return false;
    }

    public boolean removeLast() {
        if (e1() > 0) {
            return n0(X(e1() - 1));
        }
        return false;
    }

    public void s0(ValueFormatter valueFormatter) {
        if (valueFormatter != null) {
            this.f18973h = valueFormatter;
        }
    }

    public void setVisible(boolean z) {
        this.r = z;
    }

    public void t1(int i2) {
        if (this.f18966a == null) {
            this.f18966a = new ArrayList();
        }
        this.f18966a.add(Integer.valueOf(i2));
    }

    public int u0(int i2) {
        List<Integer> list = this.f18969d;
        return list.get(i2 % list.size()).intValue();
    }

    /* access modifiers changed from: protected */
    public void u1(BaseDataSet baseDataSet) {
        baseDataSet.f18971f = this.f18971f;
        baseDataSet.f18966a = this.f18966a;
        baseDataSet.o = this.o;
        baseDataSet.f18979n = this.f18979n;
        baseDataSet.f18975j = this.f18975j;
        baseDataSet.f18978m = this.f18978m;
        baseDataSet.f18977l = this.f18977l;
        baseDataSet.f18976k = this.f18976k;
        baseDataSet.f18967b = this.f18967b;
        baseDataSet.f18968c = this.f18968c;
        baseDataSet.f18972g = this.f18972g;
        baseDataSet.p = this.p;
        baseDataSet.f18969d = this.f18969d;
        baseDataSet.f18973h = this.f18973h;
        baseDataSet.f18969d = this.f18969d;
        baseDataSet.q = this.q;
        baseDataSet.r = this.r;
    }

    public List<Integer> v1() {
        return this.f18969d;
    }

    public DashPathEffect w() {
        return this.f18978m;
    }

    public void w1() {
        K0();
    }

    public boolean x0(T t) {
        for (int i2 = 0; i2 < e1(); i2++) {
            if (X(i2).equals(t)) {
                return true;
            }
        }
        return false;
    }

    public void x1() {
        if (this.f18966a == null) {
            this.f18966a = new ArrayList();
        }
        this.f18966a.clear();
    }

    public void y1(int i2) {
        x1();
        this.f18966a.add(Integer.valueOf(i2));
    }

    public void z0(float f2) {
        this.q = Utils.e(f2);
    }

    public void z1(int i2, int i3) {
        y1(Color.argb(i3, Color.red(i2), Color.green(i2), Color.blue(i2)));
    }

    public BaseDataSet(String str) {
        this();
        this.f18970e = str;
    }
}
