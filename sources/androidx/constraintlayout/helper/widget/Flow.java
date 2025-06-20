package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

public class Flow extends VirtualLayout {
    private static final String i3 = "Flow";
    public static final int j3 = 0;
    public static final int k3 = 1;
    public static final int l3 = 0;
    public static final int m3 = 1;
    public static final int n3 = 2;
    public static final int o3 = 0;
    public static final int p3 = 1;
    public static final int q3 = 2;
    public static final int r3 = 0;
    public static final int s3 = 1;
    public static final int t3 = 2;
    public static final int u3 = 0;
    public static final int v3 = 1;
    public static final int w3 = 2;
    public static final int x3 = 3;
    private androidx.constraintlayout.core.widgets.Flow h3;

    public Flow(Context context) {
        super(context);
    }

    public void B(ConstraintWidget constraintWidget, boolean z) {
        this.h3.m2(z);
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

    public void setFirstHorizontalBias(float f2) {
        this.h3.k3(f2);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i2) {
        this.h3.l3(i2);
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.h3.m3(f2);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i2) {
        this.h3.n3(i2);
        requestLayout();
    }

    public void setHorizontalAlign(int i2) {
        this.h3.o3(i2);
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.h3.p3(f2);
        requestLayout();
    }

    public void setHorizontalGap(int i2) {
        this.h3.q3(i2);
        requestLayout();
    }

    public void setHorizontalStyle(int i2) {
        this.h3.r3(i2);
        requestLayout();
    }

    public void setLastHorizontalBias(float f2) {
        this.h3.s3(f2);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i2) {
        this.h3.t3(i2);
        requestLayout();
    }

    public void setLastVerticalBias(float f2) {
        this.h3.u3(f2);
        requestLayout();
    }

    public void setLastVerticalStyle(int i2) {
        this.h3.v3(i2);
        requestLayout();
    }

    public void setMaxElementsWrap(int i2) {
        this.h3.w3(i2);
        requestLayout();
    }

    public void setOrientation(int i2) {
        this.h3.x3(i2);
        requestLayout();
    }

    public void setPadding(int i2) {
        this.h3.B2(i2);
        requestLayout();
    }

    public void setPaddingBottom(int i2) {
        this.h3.C2(i2);
        requestLayout();
    }

    public void setPaddingLeft(int i2) {
        this.h3.E2(i2);
        requestLayout();
    }

    public void setPaddingRight(int i2) {
        this.h3.F2(i2);
        requestLayout();
    }

    public void setPaddingTop(int i2) {
        this.h3.H2(i2);
        requestLayout();
    }

    public void setVerticalAlign(int i2) {
        this.h3.y3(i2);
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.h3.z3(f2);
        requestLayout();
    }

    public void setVerticalGap(int i2) {
        this.h3.A3(i2);
        requestLayout();
    }

    public void setVerticalStyle(int i2) {
        this.h3.B3(i2);
        requestLayout();
    }

    public void setWrapMode(int i2) {
        this.h3.C3(i2);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        this.h3 = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.z6) {
                    this.h3.x3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.A6) {
                    this.h3.B2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.R6) {
                    this.h3.G2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.S6) {
                    this.h3.D2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.B6) {
                    this.h3.E2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.C6) {
                    this.h3.H2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.D6) {
                    this.h3.F2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.E6) {
                    this.h3.C2(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.B7) {
                    this.h3.C3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.r7) {
                    this.h3.r3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.A7) {
                    this.h3.B3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.l7) {
                    this.h3.l3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.t7) {
                    this.h3.t3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.n7) {
                    this.h3.n3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.v7) {
                    this.h3.v3(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.p7) {
                    this.h3.p3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.k7) {
                    this.h3.k3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.s7) {
                    this.h3.s3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.m7) {
                    this.h3.m3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.u7) {
                    this.h3.u3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.y7) {
                    this.h3.z3(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.o7) {
                    this.h3.o3(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.x7) {
                    this.h3.y3(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.q7) {
                    this.h3.q3(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.z7) {
                    this.h3.A3(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.w7) {
                    this.h3.w3(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.Z2 = this.h3;
        I();
    }

    public void z(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.z(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i2 = layoutParams.Z;
            if (i2 != -1) {
                flow.x3(i2);
            }
        }
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Flow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
