package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] A1 = new ConstraintWidget[4];
    public int B1 = 0;

    public void a() {
        this.B1 = 0;
        Arrays.fill(this.A1, (Object) null);
    }

    public void b(ConstraintWidget constraintWidget) {
        if (constraintWidget != this && constraintWidget != null) {
            int i2 = this.B1 + 1;
            ConstraintWidget[] constraintWidgetArr = this.A1;
            if (i2 > constraintWidgetArr.length) {
                this.A1 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
            }
            ConstraintWidget[] constraintWidgetArr2 = this.A1;
            int i3 = this.B1;
            constraintWidgetArr2[i3] = constraintWidget;
            this.B1 = i3 + 1;
        }
    }

    public void c(ConstraintWidgetContainer constraintWidgetContainer) {
    }

    public void k2(ArrayList<WidgetGroup> arrayList, int i2, WidgetGroup widgetGroup) {
        for (int i3 = 0; i3 < this.B1; i3++) {
            widgetGroup.a(this.A1[i3]);
        }
        for (int i4 = 0; i4 < this.B1; i4++) {
            Grouping.a(this.A1[i4], i2, arrayList, widgetGroup);
        }
    }

    public int l2(int i2) {
        int i3;
        int i4;
        for (int i5 = 0; i5 < this.B1; i5++) {
            ConstraintWidget constraintWidget = this.A1[i5];
            if (i2 == 0 && (i4 = constraintWidget.S0) != -1) {
                return i4;
            }
            if (i2 == 1 && (i3 = constraintWidget.T0) != -1) {
                return i3;
            }
        }
        return -1;
    }

    public void n(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.n(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.B1 = 0;
        int i2 = helperWidget.B1;
        for (int i3 = 0; i3 < i2; i3++) {
            b(hashMap.get(helperWidget.A1[i3]));
        }
    }
}
