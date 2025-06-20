package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class Barrier extends ConstraintHelper {
    public static final int i3 = 0;
    public static final int j3 = 2;
    public static final int k3 = 1;
    public static final int l3 = 3;
    public static final int m3 = 5;
    public static final int n3 = 6;
    private int f3;
    private int g3;
    private androidx.constraintlayout.core.widgets.Barrier h3;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r6 == 6) goto L_0x0011;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r6 == 6) goto L_0x000c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void K(androidx.constraintlayout.core.widgets.ConstraintWidget r4, int r5, boolean r6) {
        /*
            r3 = this;
            r3.g3 = r5
            r5 = 0
            r0 = 6
            r1 = 1
            r2 = 5
            if (r6 == 0) goto L_0x0014
            int r6 = r3.f3
            if (r6 != r2) goto L_0x000f
        L_0x000c:
            r3.g3 = r1
            goto L_0x001c
        L_0x000f:
            if (r6 != r0) goto L_0x001c
        L_0x0011:
            r3.g3 = r5
            goto L_0x001c
        L_0x0014:
            int r6 = r3.f3
            if (r6 != r2) goto L_0x0019
            goto L_0x0011
        L_0x0019:
            if (r6 != r0) goto L_0x001c
            goto L_0x000c
        L_0x001c:
            boolean r5 = r4 instanceof androidx.constraintlayout.core.widgets.Barrier
            if (r5 == 0) goto L_0x0027
            androidx.constraintlayout.core.widgets.Barrier r4 = (androidx.constraintlayout.core.widgets.Barrier) r4
            int r5 = r3.g3
            r4.u2(r5)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.Barrier.K(androidx.constraintlayout.core.widgets.ConstraintWidget, int, boolean):void");
    }

    public void B(ConstraintWidget constraintWidget, boolean z) {
        K(constraintWidget, this.f3, z);
    }

    @Deprecated
    public boolean J() {
        return this.h3.o2();
    }

    public boolean getAllowsGoneWidget() {
        return this.h3.o2();
    }

    public int getMargin() {
        return this.h3.q2();
    }

    public int getType() {
        return this.f3;
    }

    public void setAllowsGoneWidget(boolean z) {
        this.h3.t2(z);
    }

    public void setDpMargin(int i2) {
        androidx.constraintlayout.core.widgets.Barrier barrier = this.h3;
        barrier.v2((int) ((((float) i2) * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i2) {
        this.h3.v2(i2);
    }

    public void setType(int i2) {
        this.f3 = i2;
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        this.h3 = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Z6) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.Y6) {
                    this.h3.t2(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == R.styleable.a7) {
                    this.h3.v2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.Z2 = this.h3;
        I();
    }

    public void z(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.z(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            K(barrier, constraint.f4714e.h0, ((ConstraintWidgetContainer) helperWidget.U()).O2());
            barrier.t2(constraint.f4714e.p0);
            barrier.v2(constraint.f4714e.i0);
        }
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
