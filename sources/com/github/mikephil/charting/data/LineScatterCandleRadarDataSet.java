package com.github.mikephil.charting.data;

import android.graphics.DashPathEffect;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineScatterCandleRadarDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineScatterCandleRadarDataSet<T extends Entry> extends BarLineScatterCandleBubbleDataSet<T> implements ILineScatterCandleRadarDataSet<T> {
    protected float A;
    protected DashPathEffect B;
    protected boolean y;
    protected boolean z;

    public LineScatterCandleRadarDataSet(List<T> list, String str) {
        super(list, str);
        this.y = true;
        this.z = true;
        this.A = 0.5f;
        this.B = null;
        this.A = Utils.e(0.5f);
    }

    public float I() {
        return this.A;
    }

    /* access modifiers changed from: protected */
    public void U1(LineScatterCandleRadarDataSet lineScatterCandleRadarDataSet) {
        super.S1(lineScatterCandleRadarDataSet);
        lineScatterCandleRadarDataSet.z = this.z;
        lineScatterCandleRadarDataSet.y = this.y;
        lineScatterCandleRadarDataSet.A = this.A;
        lineScatterCandleRadarDataSet.B = this.B;
    }

    public void V1() {
        this.B = null;
    }

    public void W1(float f2, float f3, float f4) {
        this.B = new DashPathEffect(new float[]{f2, f3}, f4);
    }

    public boolean X1() {
        return this.B != null;
    }

    public void Y1(boolean z2) {
        a2(z2);
        Z1(z2);
    }

    public void Z1(boolean z2) {
        this.z = z2;
    }

    public void a2(boolean z2) {
        this.y = z2;
    }

    public void b2(float f2) {
        this.A = Utils.e(f2);
    }

    public boolean j1() {
        return this.y;
    }

    public boolean n1() {
        return this.z;
    }

    public DashPathEffect v0() {
        return this.B;
    }
}
