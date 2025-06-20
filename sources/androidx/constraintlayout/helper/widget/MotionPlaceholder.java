package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

public class MotionPlaceholder extends VirtualLayout {
    private static final String i3 = "MotionPlaceholder";
    Placeholder h3;

    public MotionPlaceholder(Context context) {
        super(context);
    }

    public void G(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
    }

    public void J(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i2, int i4) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (virtualLayout != null) {
            virtualLayout.v2(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.q2(), virtualLayout.p2());
            return;
        }
        setMeasuredDimension(0, 0);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i2, int i4) {
        J(this.h3, i2, i4);
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        this.Z2 = new Placeholder();
        I();
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MotionPlaceholder(Context context, AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2);
    }
}
