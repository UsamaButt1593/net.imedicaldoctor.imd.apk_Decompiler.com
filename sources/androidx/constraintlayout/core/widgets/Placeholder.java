package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

public class Placeholder extends VirtualLayout {
    public void g(LinearSystem linearSystem, boolean z) {
        super.g(linearSystem, z);
        if (this.B1 > 0) {
            ConstraintWidget constraintWidget = this.A1[0];
            constraintWidget.S0();
            ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
            constraintWidget.j(type, this, type);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
            constraintWidget.j(type2, this, type2);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
            constraintWidget.j(type3, this, type3);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
            constraintWidget.j(type4, this, type4);
        }
    }

    public void v2(int i2, int i3, int i4, int i5) {
        int s2 = s2() + t2();
        int u2 = u2() + r2();
        boolean z = false;
        if (this.B1 > 0) {
            s2 += this.A1[0].m0();
            u2 += this.A1[0].D();
        }
        int max = Math.max(Q(), s2);
        int max2 = Math.max(P(), u2);
        if (i2 != 1073741824) {
            i3 = i2 == Integer.MIN_VALUE ? Math.min(max, i3) : i2 == 0 ? max : 0;
        }
        if (i4 != 1073741824) {
            i5 = i4 == Integer.MIN_VALUE ? Math.min(max2, i5) : i4 == 0 ? max2 : 0;
        }
        A2(i3, i5);
        c2(i3);
        y1(i5);
        if (this.B1 > 0) {
            z = true;
        }
        z2(z);
    }
}
