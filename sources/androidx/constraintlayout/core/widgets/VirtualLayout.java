package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;

public class VirtualLayout extends HelperWidget {
    private int C1 = 0;
    private int D1 = 0;
    private int E1 = 0;
    private int F1 = 0;
    private int G1 = 0;
    private int H1 = 0;
    private int I1 = 0;
    private int J1 = 0;
    private boolean K1 = false;
    private int L1 = 0;
    private int M1 = 0;
    protected BasicMeasure.Measure N1 = new BasicMeasure.Measure();
    BasicMeasure.Measurer O1 = null;

    public void A2(int i2, int i3) {
        this.L1 = i2;
        this.M1 = i3;
    }

    public void B2(int i2) {
        this.E1 = i2;
        this.C1 = i2;
        this.F1 = i2;
        this.D1 = i2;
        this.G1 = i2;
        this.H1 = i2;
    }

    public void C2(int i2) {
        this.D1 = i2;
    }

    public void D2(int i2) {
        this.H1 = i2;
    }

    public void E2(int i2) {
        this.E1 = i2;
        this.I1 = i2;
    }

    public void F2(int i2) {
        this.F1 = i2;
        this.J1 = i2;
    }

    public void G2(int i2) {
        this.G1 = i2;
        this.I1 = i2;
        this.J1 = i2;
    }

    public void H2(int i2) {
        this.C1 = i2;
    }

    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
        n2();
    }

    public void m2(boolean z) {
        int i2 = this.G1;
        if (i2 <= 0 && this.H1 <= 0) {
            return;
        }
        if (z) {
            this.I1 = this.H1;
            this.J1 = i2;
            return;
        }
        this.I1 = i2;
        this.J1 = this.H1;
    }

    public void n2() {
        for (int i2 = 0; i2 < this.B1; i2++) {
            ConstraintWidget constraintWidget = this.A1[i2];
            if (constraintWidget != null) {
                constraintWidget.I1(true);
            }
        }
    }

    public boolean o2(HashSet<ConstraintWidget> hashSet) {
        for (int i2 = 0; i2 < this.B1; i2++) {
            if (hashSet.contains(this.A1[i2])) {
                return true;
            }
        }
        return false;
    }

    public int p2() {
        return this.M1;
    }

    public int q2() {
        return this.L1;
    }

    public int r2() {
        return this.D1;
    }

    public int s2() {
        return this.I1;
    }

    public int t2() {
        return this.J1;
    }

    public int u2() {
        return this.C1;
    }

    public void v2(int i2, int i3, int i4, int i5) {
    }

    /* access modifiers changed from: protected */
    public void w2(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        while (this.O1 == null && U() != null) {
            this.O1 = ((ConstraintWidgetContainer) U()).G2();
        }
        BasicMeasure.Measure measure = this.N1;
        measure.f4251a = dimensionBehaviour;
        measure.f4252b = dimensionBehaviour2;
        measure.f4253c = i2;
        measure.f4254d = i3;
        this.O1.b(constraintWidget, measure);
        constraintWidget.c2(this.N1.f4255e);
        constraintWidget.y1(this.N1.f4256f);
        constraintWidget.x1(this.N1.f4258h);
        constraintWidget.g1(this.N1.f4257g);
    }

    /* access modifiers changed from: protected */
    public boolean x2() {
        ConstraintWidget constraintWidget = this.c0;
        BasicMeasure.Measurer G2 = constraintWidget != null ? ((ConstraintWidgetContainer) constraintWidget).G2() : null;
        if (G2 == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.B1; i2++) {
            ConstraintWidget constraintWidget2 = this.A1[i2];
            if (constraintWidget2 != null && !(constraintWidget2 instanceof Guideline)) {
                ConstraintWidget.DimensionBehaviour z = constraintWidget2.z(0);
                ConstraintWidget.DimensionBehaviour z2 = constraintWidget2.z(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (z != dimensionBehaviour || constraintWidget2.w == 1 || z2 != dimensionBehaviour || constraintWidget2.x == 1) {
                    if (z == dimensionBehaviour) {
                        z = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (z2 == dimensionBehaviour) {
                        z2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    }
                    BasicMeasure.Measure measure = this.N1;
                    measure.f4251a = z;
                    measure.f4252b = z2;
                    measure.f4253c = constraintWidget2.m0();
                    this.N1.f4254d = constraintWidget2.D();
                    G2.b(constraintWidget2, this.N1);
                    constraintWidget2.c2(this.N1.f4255e);
                    constraintWidget2.y1(this.N1.f4256f);
                    constraintWidget2.g1(this.N1.f4257g);
                }
            }
        }
        return true;
    }

    public boolean y2() {
        return this.K1;
    }

    /* access modifiers changed from: protected */
    public void z2(boolean z) {
        this.K1 = z;
    }
}
