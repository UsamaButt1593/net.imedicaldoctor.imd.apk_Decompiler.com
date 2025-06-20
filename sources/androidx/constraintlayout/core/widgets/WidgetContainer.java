package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

public class WidgetContainer extends ConstraintWidget {
    public ArrayList<ConstraintWidget> A1 = new ArrayList<>();

    public WidgetContainer() {
    }

    public void Q1(int i2, int i3) {
        super.Q1(i2, i3);
        int size = this.A1.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.A1.get(i4).Q1(Y(), Z());
        }
    }

    public void R0() {
        this.A1.clear();
        super.R0();
    }

    public void W0(Cache cache) {
        super.W0(cache);
        int size = this.A1.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.A1.get(i2).W0(cache);
        }
    }

    public void b(ConstraintWidget constraintWidget) {
        this.A1.add(constraintWidget);
        if (constraintWidget.U() != null) {
            ((WidgetContainer) constraintWidget.U()).o2(constraintWidget);
        }
        constraintWidget.S1(this);
    }

    public void k2(ConstraintWidget... constraintWidgetArr) {
        for (ConstraintWidget b2 : constraintWidgetArr) {
            b(b2);
        }
    }

    public ArrayList<ConstraintWidget> l2() {
        return this.A1;
    }

    public ConstraintWidgetContainer m2() {
        ConstraintWidget U = U();
        ConstraintWidgetContainer constraintWidgetContainer = this instanceof ConstraintWidgetContainer ? (ConstraintWidgetContainer) this : null;
        while (U != null) {
            ConstraintWidget U2 = U.U();
            if (U instanceof ConstraintWidgetContainer) {
                constraintWidgetContainer = (ConstraintWidgetContainer) U;
            }
            U = U2;
        }
        return constraintWidgetContainer;
    }

    public void n2() {
        ArrayList<ConstraintWidget> arrayList = this.A1;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = this.A1.get(i2);
                if (constraintWidget instanceof WidgetContainer) {
                    ((WidgetContainer) constraintWidget).n2();
                }
            }
        }
    }

    public void o2(ConstraintWidget constraintWidget) {
        this.A1.remove(constraintWidget);
        constraintWidget.R0();
    }

    public void p2() {
        this.A1.clear();
    }

    public WidgetContainer(int i2, int i3) {
        super(i2, i3);
    }

    public WidgetContainer(int i2, int i3, int i4, int i5) {
        super(i2, i3, i4, i5);
    }
}
