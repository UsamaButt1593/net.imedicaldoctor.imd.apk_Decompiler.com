package com.github.mikephil.charting.data;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.List;

public class BarDataSet extends BarLineScatterCandleBubbleDataSet<BarEntry> implements IBarDataSet {
    private float A = 0.0f;
    private int B = ViewCompat.y;
    private int C = 120;
    private int D = 0;
    private String[] E = {"Stack"};
    private int y = 1;
    private int z = Color.rgb(215, 215, 215);

    public BarDataSet(List<BarEntry> list, String str) {
        super(list, str);
        this.x = Color.rgb(0, 0, 0);
        W1(list);
        U1(list);
    }

    private void U1(List<BarEntry> list) {
        this.D = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            float[] I = list.get(i2).I();
            if (I == null) {
                this.D++;
            } else {
                this.D += I.length;
            }
        }
    }

    private void W1(List<BarEntry> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            float[] I = list.get(i2).I();
            if (I != null && I.length > this.y) {
                this.y = I.length;
            }
        }
    }

    public int C0() {
        return this.y;
    }

    public float F() {
        return this.A;
    }

    public int M0() {
        return this.C;
    }

    public DataSet<BarEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((BarEntry) this.s.get(i2)).k());
        }
        BarDataSet barDataSet = new BarDataSet(arrayList, H());
        X1(barDataSet);
        return barDataSet;
    }

    public boolean U0() {
        return this.y > 1;
    }

    /* access modifiers changed from: protected */
    /* renamed from: V1 */
    public void K1(BarEntry barEntry) {
        float D2;
        if (barEntry != null && !Float.isNaN(barEntry.c())) {
            if (barEntry.I() == null) {
                if (barEntry.c() < this.u) {
                    this.u = barEntry.c();
                }
                if (barEntry.c() > this.t) {
                    D2 = barEntry.c();
                }
                L1(barEntry);
            }
            if ((-barEntry.C()) < this.u) {
                this.u = -barEntry.C();
            }
            if (barEntry.D() > this.t) {
                D2 = barEntry.D();
            }
            L1(barEntry);
            this.t = D2;
            L1(barEntry);
        }
    }

    public String[] W0() {
        return this.E;
    }

    /* access modifiers changed from: protected */
    public void X1(BarDataSet barDataSet) {
        super.S1(barDataSet);
        barDataSet.y = this.y;
        barDataSet.z = this.z;
        barDataSet.A = this.A;
        barDataSet.E = this.E;
        barDataSet.C = this.C;
    }

    public int Y1() {
        return this.D;
    }

    public void Z1(int i2) {
        this.B = i2;
    }

    public void a2(float f2) {
        this.A = f2;
    }

    public void b2(int i2) {
        this.z = i2;
    }

    public void c2(int i2) {
        this.C = i2;
    }

    public void d2(String[] strArr) {
        this.E = strArr;
    }

    public int l0() {
        return this.z;
    }

    public int v() {
        return this.B;
    }
}
