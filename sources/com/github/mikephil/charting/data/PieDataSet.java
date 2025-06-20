package com.github.mikephil.charting.data;

import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PieDataSet extends DataSet<PieEntry> implements IPieDataSet {
    private ValuePosition A;
    private ValuePosition B;
    private boolean C;
    private int D;
    private float E;
    private float F;
    private float G;
    private float H;
    private boolean I;
    private float x = 0.0f;
    private boolean y;
    private float z = 18.0f;

    public enum ValuePosition {
        INSIDE_SLICE,
        OUTSIDE_SLICE
    }

    public PieDataSet(List<PieEntry> list, String str) {
        super(list, str);
        ValuePosition valuePosition = ValuePosition.INSIDE_SLICE;
        this.A = valuePosition;
        this.B = valuePosition;
        this.C = false;
        this.D = ViewCompat.y;
        this.E = 1.0f;
        this.F = 75.0f;
        this.G = 0.3f;
        this.H = 0.4f;
        this.I = true;
    }

    public boolean A0() {
        return this.I;
    }

    public float D0() {
        return this.H;
    }

    public boolean L0() {
        return this.C;
    }

    public DataSet<PieEntry> N1() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.s.size(); i2++) {
            arrayList.add(((PieEntry) this.s.get(i2)).k());
        }
        PieDataSet pieDataSet = new PieDataSet(arrayList, H());
        T1(pieDataSet);
        return pieDataSet;
    }

    public float P0() {
        return this.z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: S1 */
    public void K1(PieEntry pieEntry) {
        if (pieEntry != null) {
            M1(pieEntry);
        }
    }

    public float T0() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public void T1(PieDataSet pieDataSet) {
        super.O1(pieDataSet);
    }

    public boolean U() {
        return this.y;
    }

    public void U1(boolean z2) {
        this.y = z2;
    }

    public void V1(float f2) {
        this.z = Utils.e(f2);
    }

    public void W1(float f2) {
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.x = Utils.e(f2);
    }

    public void X1(boolean z2) {
        this.C = z2;
    }

    public void Y1(int i2) {
        this.D = i2;
    }

    public void Z1(float f2) {
        this.G = f2;
    }

    public int a0() {
        return this.D;
    }

    public void a2(float f2) {
        this.F = f2;
    }

    public void b2(float f2) {
        this.H = f2;
    }

    public void c2(boolean z2) {
        this.I = z2;
    }

    public void d2(float f2) {
        this.E = f2;
    }

    public float e0() {
        return this.E;
    }

    public void e2(ValuePosition valuePosition) {
        this.A = valuePosition;
    }

    public float f0() {
        return this.G;
    }

    public void f2(ValuePosition valuePosition) {
        this.B = valuePosition;
    }

    public ValuePosition h0() {
        return this.A;
    }

    public float i() {
        return this.x;
    }

    public ValuePosition w0() {
        return this.B;
    }
}
