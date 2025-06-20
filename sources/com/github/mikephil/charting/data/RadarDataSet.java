package com.github.mikephil.charting.data;

import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
import java.util.List;

public class RadarDataSet extends LineRadarDataSet<RadarEntry> implements IRadarDataSet {
    protected boolean H = false;
    protected int I = -1;
    protected int J = ColorTemplate.f19136a;
    protected int K = 76;
    protected float L = 3.0f;
    protected float M = 4.0f;
    protected float N = 2.0f;

    public RadarDataSet(List<RadarEntry> list, String str) {
        super(list, str);
    }

    public void F0(boolean z) {
        this.H = z;
    }

    public float K() {
        return this.M;
    }

    public DataSet<RadarEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((RadarEntry) this.s.get(i2)).k());
        }
        RadarDataSet radarDataSet = new RadarDataSet(arrayList, H());
        h2(radarDataSet);
        return radarDataSet;
    }

    public float c() {
        return this.N;
    }

    public int h() {
        return this.I;
    }

    /* access modifiers changed from: protected */
    public void h2(RadarDataSet radarDataSet) {
        super.c2(radarDataSet);
        radarDataSet.H = this.H;
        radarDataSet.I = this.I;
        radarDataSet.L = this.L;
        radarDataSet.K = this.K;
        radarDataSet.J = this.J;
        radarDataSet.N = this.N;
    }

    public void i2(int i2) {
        this.I = i2;
    }

    public float j() {
        return this.L;
    }

    public void j2(float f2) {
        this.L = f2;
    }

    public void k2(float f2) {
        this.M = f2;
    }

    public void l2(int i2) {
        this.K = i2;
    }

    public int m() {
        return this.K;
    }

    public void m2(int i2) {
        this.J = i2;
    }

    public void n2(float f2) {
        this.N = f2;
    }

    public int t() {
        return this.J;
    }

    public boolean z() {
        return this.H;
    }
}
