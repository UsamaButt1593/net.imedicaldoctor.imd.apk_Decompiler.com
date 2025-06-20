package com.github.mikephil.charting.data;

import android.content.Context;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.github.mikephil.charting.formatter.DefaultFillFormatter;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class LineDataSet extends LineRadarDataSet<Entry> implements ILineDataSet {
    private Mode H = Mode.LINEAR;
    private List<Integer> I = null;
    private int J = -1;
    private float K = 8.0f;
    private float L = 4.0f;
    private float M = 0.2f;
    private DashPathEffect N = null;
    private IFillFormatter O = new DefaultFillFormatter();
    private boolean P = true;
    private boolean Q = true;

    public enum Mode {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public LineDataSet(List<Entry> list, String str) {
        super(list, str);
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
        this.I.add(Integer.valueOf(Color.rgb(140, 234, 255)));
    }

    public boolean A() {
        return this.N != null;
    }

    public int E() {
        return this.J;
    }

    public float L() {
        return this.M;
    }

    public DataSet<Entry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((Entry) this.s.get(i2)).k());
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, H());
        h2(lineDataSet);
        return lineDataSet;
    }

    public DashPathEffect O() {
        return this.N;
    }

    public float Y() {
        return this.K;
    }

    public int Z0(int i2) {
        return this.I.get(i2).intValue();
    }

    public Mode c0() {
        return this.H;
    }

    public int f() {
        return this.I.size();
    }

    public boolean h1() {
        return this.P;
    }

    /* access modifiers changed from: protected */
    public void h2(LineDataSet lineDataSet) {
        super.c2(lineDataSet);
        lineDataSet.I = this.I;
        lineDataSet.J = this.J;
        lineDataSet.L = this.L;
        lineDataSet.K = this.K;
        lineDataSet.M = this.M;
        lineDataSet.N = this.N;
        lineDataSet.Q = this.Q;
        lineDataSet.P = this.Q;
        lineDataSet.O = this.O;
        lineDataSet.H = this.H;
    }

    public void i2() {
        this.N = null;
    }

    public void j2(float f2, float f3, float f4) {
        this.N = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public float k1() {
        return this.L;
    }

    public List<Integer> k2() {
        return this.I;
    }

    @Deprecated
    public float l2() {
        return Y();
    }

    public void m2() {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
    }

    public void n2(int i2) {
        m2();
        this.I.add(Integer.valueOf(i2));
    }

    public IFillFormatter o() {
        return this.O;
    }

    public void o2(List<Integer> list) {
        this.I = list;
    }

    public void p2(int... iArr) {
        this.I = ColorTemplate.c(iArr);
    }

    public void q2(int[] iArr, Context context) {
        List<Integer> list = this.I;
        if (list == null) {
            list = new ArrayList<>();
        }
        list.clear();
        for (int color : iArr) {
            list.add(Integer.valueOf(context.getResources().getColor(color)));
        }
        this.I = list;
    }

    public boolean r1() {
        return this.Q;
    }

    public void r2(int i2) {
        this.J = i2;
    }

    @Deprecated
    public boolean s1() {
        return this.H == Mode.STEPPED;
    }

    public void s2(float f2) {
        if (f2 >= 0.5f) {
            this.L = Utils.e(f2);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 0.5");
        }
    }

    public void t2(float f2) {
        if (f2 >= 1.0f) {
            this.K = Utils.e(f2);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    @Deprecated
    public void u2(float f2) {
        t2(f2);
    }

    public void v2(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        if (f2 < 0.05f) {
            f2 = 0.05f;
        }
        this.M = f2;
    }

    public void w2(boolean z) {
        this.Q = z;
    }

    public void x2(boolean z) {
        this.P = z;
    }

    @Deprecated
    public boolean y() {
        return this.H == Mode.CUBIC_BEZIER;
    }

    public void y2(IFillFormatter iFillFormatter) {
        if (iFillFormatter == null) {
            iFillFormatter = new DefaultFillFormatter();
        }
        this.O = iFillFormatter;
    }

    public void z2(Mode mode) {
        this.H = mode;
    }
}
