package com.github.mikephil.charting.data;

import android.graphics.Paint;
import com.github.mikephil.charting.interfaces.datasets.ICandleDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CandleDataSet extends LineScatterCandleRadarDataSet<CandleEntry> implements ICandleDataSet {
    private float C = 3.0f;
    private boolean D = true;
    private float E = 0.1f;
    private boolean F = false;
    protected Paint.Style G = Paint.Style.STROKE;
    protected Paint.Style H = Paint.Style.FILL;
    protected int I = ColorTemplate.f19137b;
    protected int J = ColorTemplate.f19137b;
    protected int K = ColorTemplate.f19137b;
    protected int L = ColorTemplate.f19137b;

    public CandleDataSet(List<CandleEntry> list, String str) {
        super(list, str);
    }

    public DataSet<CandleEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((CandleEntry) this.s.get(i2)).k());
        }
        CandleDataSet candleDataSet = new CandleDataSet(arrayList, H());
        e2(candleDataSet);
        return candleDataSet;
    }

    public int Q0() {
        return this.L;
    }

    public Paint.Style R() {
        return this.H;
    }

    public float V() {
        return this.E;
    }

    public int X0() {
        return this.J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c2 */
    public void K1(CandleEntry candleEntry) {
        if (candleEntry.B() < this.u) {
            this.u = candleEntry.B();
        }
        if (candleEntry.z() > this.t) {
            this.t = candleEntry.z();
        }
        L1(candleEntry);
    }

    public int d() {
        return this.I;
    }

    public boolean d1() {
        return this.D;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d2 */
    public void M1(CandleEntry candleEntry) {
        if (candleEntry.z() < this.u) {
            this.u = candleEntry.z();
        }
        if (candleEntry.z() > this.t) {
            this.t = candleEntry.z();
        }
        if (candleEntry.B() < this.u) {
            this.u = candleEntry.B();
        }
        if (candleEntry.B() > this.t) {
            this.t = candleEntry.B();
        }
    }

    /* access modifiers changed from: protected */
    public void e2(CandleDataSet candleDataSet) {
        super.U1(candleDataSet);
        candleDataSet.C = this.C;
        candleDataSet.D = this.D;
        candleDataSet.E = this.E;
        candleDataSet.F = this.F;
        candleDataSet.x = this.x;
        candleDataSet.G = this.G;
        candleDataSet.H = this.H;
        candleDataSet.I = this.I;
        candleDataSet.J = this.J;
        candleDataSet.K = this.K;
        candleDataSet.L = this.L;
    }

    public void f2(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 0.45f) {
            f2 = 0.45f;
        }
        this.E = f2;
    }

    public void g2(int i2) {
        this.K = i2;
    }

    public void h2(Paint.Style style) {
        this.H = style;
    }

    public void i2(int i2) {
        this.J = i2;
    }

    public Paint.Style j0() {
        return this.G;
    }

    public void j2(Paint.Style style) {
        this.G = style;
    }

    public void k2(int i2) {
        this.I = i2;
    }

    public void l2(int i2) {
        this.L = i2;
    }

    public void m2(boolean z) {
        this.F = z;
    }

    public void n2(float f2) {
        this.C = Utils.e(f2);
    }

    public void o2(boolean z) {
        this.D = z;
    }

    public int p1() {
        return this.K;
    }

    public float r() {
        return this.C;
    }

    public boolean y0() {
        return this.F;
    }
}
