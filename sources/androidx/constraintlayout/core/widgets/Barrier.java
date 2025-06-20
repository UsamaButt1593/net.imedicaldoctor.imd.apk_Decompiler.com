package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

public class Barrier extends HelperWidget {
    public static final int G1 = 0;
    public static final int H1 = 1;
    public static final int I1 = 2;
    public static final int J1 = 3;
    private static final boolean K1 = true;
    private static final boolean L1 = false;
    private int C1 = 0;
    private boolean D1 = true;
    private int E1 = 0;
    boolean F1 = false;

    public Barrier() {
    }

    public boolean G0() {
        return this.F1;
    }

    public boolean H0() {
        return this.F1;
    }

    public void g(LinearSystem linearSystem, boolean z) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z2;
        SolverVariable solverVariable;
        ConstraintAnchor constraintAnchor;
        int i2;
        int i3;
        int i4;
        SolverVariable solverVariable2;
        int i5;
        ConstraintAnchor[] constraintAnchorArr2 = this.Y;
        constraintAnchorArr2[0] = this.Q;
        constraintAnchorArr2[2] = this.R;
        constraintAnchorArr2[1] = this.S;
        constraintAnchorArr2[3] = this.T;
        int i6 = 0;
        while (true) {
            constraintAnchorArr = this.Y;
            if (i6 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i6];
            constraintAnchor2.f4186i = linearSystem.u(constraintAnchor2);
            i6++;
        }
        int i7 = this.C1;
        if (i7 >= 0 && i7 < 4) {
            ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i7];
            if (!this.F1) {
                m2();
            }
            if (this.F1) {
                this.F1 = false;
                int i8 = this.C1;
                if (i8 == 0 || i8 == 1) {
                    linearSystem.f(this.Q.f4186i, this.h0);
                    solverVariable2 = this.S.f4186i;
                    i5 = this.h0;
                } else if (i8 == 2 || i8 == 3) {
                    linearSystem.f(this.R.f4186i, this.i0);
                    solverVariable2 = this.T.f4186i;
                    i5 = this.i0;
                } else {
                    return;
                }
                linearSystem.f(solverVariable2, i5);
                return;
            }
            int i9 = 0;
            while (true) {
                if (i9 >= this.B1) {
                    z2 = false;
                    break;
                }
                ConstraintWidget constraintWidget = this.A1[i9];
                if ((this.D1 || constraintWidget.h()) && ((((i3 = this.C1) == 0 || i3 == 1) && constraintWidget.H() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.Q.f4183f != null && constraintWidget.S.f4183f != null) || (((i4 = this.C1) == 2 || i4 == 3) && constraintWidget.j0() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.R.f4183f != null && constraintWidget.T.f4183f != null))) {
                    z2 = true;
                } else {
                    i9++;
                }
            }
            z2 = true;
            boolean z3 = this.Q.m() || this.S.m();
            boolean z4 = this.R.m() || this.T.m();
            int i10 = !(!z2 && (((i2 = this.C1) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4))))) ? 4 : 5;
            for (int i11 = 0; i11 < this.B1; i11++) {
                ConstraintWidget constraintWidget2 = this.A1[i11];
                if (this.D1 || constraintWidget2.h()) {
                    SolverVariable u = linearSystem.u(constraintWidget2.Y[this.C1]);
                    ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.Y;
                    int i12 = this.C1;
                    ConstraintAnchor constraintAnchor4 = constraintAnchorArr3[i12];
                    constraintAnchor4.f4186i = u;
                    ConstraintAnchor constraintAnchor5 = constraintAnchor4.f4183f;
                    int i13 = (constraintAnchor5 == null || constraintAnchor5.f4181d != this) ? 0 : constraintAnchor4.f4184g;
                    if (i12 == 0 || i12 == 2) {
                        linearSystem.j(constraintAnchor3.f4186i, u, this.E1 - i13, z2);
                    } else {
                        linearSystem.h(constraintAnchor3.f4186i, u, this.E1 + i13, z2);
                    }
                    linearSystem.e(constraintAnchor3.f4186i, u, this.E1 + i13, i10);
                }
            }
            int i14 = this.C1;
            if (i14 == 0) {
                linearSystem.e(this.S.f4186i, this.Q.f4186i, 0, 8);
                linearSystem.e(this.Q.f4186i, this.c0.S.f4186i, 0, 4);
                solverVariable = this.Q.f4186i;
                constraintAnchor = this.c0.Q;
            } else if (i14 == 1) {
                linearSystem.e(this.Q.f4186i, this.S.f4186i, 0, 8);
                linearSystem.e(this.Q.f4186i, this.c0.Q.f4186i, 0, 4);
                solverVariable = this.Q.f4186i;
                constraintAnchor = this.c0.S;
            } else if (i14 == 2) {
                linearSystem.e(this.T.f4186i, this.R.f4186i, 0, 8);
                linearSystem.e(this.R.f4186i, this.c0.T.f4186i, 0, 4);
                solverVariable = this.R.f4186i;
                constraintAnchor = this.c0.R;
            } else if (i14 == 3) {
                linearSystem.e(this.R.f4186i, this.T.f4186i, 0, 8);
                linearSystem.e(this.R.f4186i, this.c0.R.f4186i, 0, 4);
                solverVariable = this.R.f4186i;
                constraintAnchor = this.c0.T;
            } else {
                return;
            }
            linearSystem.e(solverVariable, constraintAnchor.f4186i, 0, 0);
        }
    }

    public boolean h() {
        return true;
    }

    public boolean m2() {
        int i2;
        ConstraintAnchor.Type type;
        ConstraintAnchor.Type type2;
        ConstraintAnchor.Type type3;
        int i3;
        int i4;
        int i5 = 0;
        boolean z = true;
        while (true) {
            i2 = this.B1;
            if (i5 >= i2) {
                break;
            }
            ConstraintWidget constraintWidget = this.A1[i5];
            if ((this.D1 || constraintWidget.h()) && ((((i3 = this.C1) == 0 || i3 == 1) && !constraintWidget.G0()) || (((i4 = this.C1) == 2 || i4 == 3) && !constraintWidget.H0()))) {
                z = false;
            }
            i5++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int i6 = 0;
        boolean z2 = false;
        for (int i7 = 0; i7 < this.B1; i7++) {
            ConstraintWidget constraintWidget2 = this.A1[i7];
            if (this.D1 || constraintWidget2.h()) {
                if (!z2) {
                    int i8 = this.C1;
                    if (i8 == 0) {
                        type3 = ConstraintAnchor.Type.LEFT;
                    } else if (i8 == 1) {
                        type3 = ConstraintAnchor.Type.RIGHT;
                    } else if (i8 == 2) {
                        type3 = ConstraintAnchor.Type.TOP;
                    } else {
                        if (i8 == 3) {
                            type3 = ConstraintAnchor.Type.BOTTOM;
                        }
                        z2 = true;
                    }
                    i6 = constraintWidget2.r(type3).f();
                    z2 = true;
                }
                int i9 = this.C1;
                if (i9 == 0) {
                    type2 = ConstraintAnchor.Type.LEFT;
                } else {
                    if (i9 == 1) {
                        type = ConstraintAnchor.Type.RIGHT;
                    } else if (i9 == 2) {
                        type2 = ConstraintAnchor.Type.TOP;
                    } else if (i9 == 3) {
                        type = ConstraintAnchor.Type.BOTTOM;
                    }
                    i6 = Math.max(i6, constraintWidget2.r(type).f());
                }
                i6 = Math.min(i6, constraintWidget2.r(type2).f());
            }
        }
        int i10 = i6 + this.E1;
        int i11 = this.C1;
        if (i11 == 0 || i11 == 1) {
            q1(i10, i10);
        } else {
            t1(i10, i10);
        }
        this.F1 = true;
        return true;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.n(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.C1 = barrier.C1;
        this.D1 = barrier.D1;
        this.E1 = barrier.E1;
    }

    @Deprecated
    public boolean n2() {
        return this.D1;
    }

    public boolean o2() {
        return this.D1;
    }

    public int p2() {
        return this.C1;
    }

    public int q2() {
        return this.E1;
    }

    public int r2() {
        int i2 = this.C1;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public void s2() {
        for (int i2 = 0; i2 < this.B1; i2++) {
            ConstraintWidget constraintWidget = this.A1[i2];
            if (this.D1 || constraintWidget.h()) {
                int i3 = this.C1;
                if (i3 == 0 || i3 == 1) {
                    constraintWidget.G1(0, true);
                } else if (i3 == 2 || i3 == 3) {
                    constraintWidget.G1(1, true);
                }
            }
        }
    }

    public void t2(boolean z) {
        this.D1 = z;
    }

    public String toString() {
        String str = "[Barrier] " + y() + " {";
        for (int i2 = 0; i2 < this.B1; i2++) {
            ConstraintWidget constraintWidget = this.A1[i2];
            if (i2 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.y();
        }
        return str + "}";
    }

    public void u2(int i2) {
        this.C1 = i2;
    }

    public void v2(int i2) {
        this.E1 = i2;
    }

    public Barrier(String str) {
        j1(str);
    }
}
