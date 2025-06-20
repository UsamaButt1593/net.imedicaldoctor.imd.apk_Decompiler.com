package com.github.mikephil.charting.data;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private int C = Color.rgb(140, 234, 255);
    protected Drawable D;
    private int E = 85;
    private float F = 2.5f;
    private boolean G = false;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
    }

    public Drawable Q() {
        return this.D;
    }

    public boolean Z() {
        return this.G;
    }

    /* access modifiers changed from: protected */
    public void c2(LineRadarDataSet lineRadarDataSet) {
        super.U1(lineRadarDataSet);
        lineRadarDataSet.G = this.G;
        lineRadarDataSet.E = this.E;
        lineRadarDataSet.C = this.C;
        lineRadarDataSet.D = this.D;
        lineRadarDataSet.F = this.F;
    }

    public void d2(int i2) {
        this.E = i2;
    }

    public void e2(int i2) {
        this.C = i2;
        this.D = null;
    }

    @TargetApi(18)
    public void f2(Drawable drawable) {
        this.D = drawable;
    }

    public int g() {
        return this.C;
    }

    public void g2(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 10.0f) {
            f2 = 10.0f;
        }
        this.F = Utils.e(f2);
    }

    public int l() {
        return this.E;
    }

    public void q0(boolean z) {
        this.G = z;
    }

    public float u() {
        return this.F;
    }
}
