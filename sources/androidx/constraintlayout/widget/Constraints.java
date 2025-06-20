package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Constraints extends ViewGroup {
    public static final String X2 = "Constraints";
    ConstraintSet s;

    public static class LayoutParams extends ConstraintLayout.LayoutParams {
        public float V0;
        public boolean W0;
        public float X0;
        public float Y0;
        public float Z0;
        public float a1;
        public float b1;
        public float c1;
        public float d1;
        public float e1;
        public float f1;
        public float g1;
        public float h1;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.a1 = 0.0f;
            this.b1 = 1.0f;
            this.c1 = 1.0f;
            this.d1 = 0.0f;
            this.e1 = 0.0f;
            this.f1 = 0.0f;
            this.g1 = 0.0f;
            this.h1 = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.a1 = 0.0f;
            this.b1 = 1.0f;
            this.c1 = 1.0f;
            this.d1 = 0.0f;
            this.e1 = 0.0f;
            this.f1 = 0.0f;
            this.g1 = 0.0f;
            this.h1 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Xa);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.nb) {
                    this.V0 = obtainStyledAttributes.getFloat(index, this.V0);
                } else if (index == R.styleable.Ab) {
                    this.X0 = obtainStyledAttributes.getFloat(index, this.X0);
                    this.W0 = true;
                } else if (index == R.styleable.vb) {
                    this.Z0 = obtainStyledAttributes.getFloat(index, this.Z0);
                } else if (index == R.styleable.wb) {
                    this.a1 = obtainStyledAttributes.getFloat(index, this.a1);
                } else if (index == R.styleable.ub) {
                    this.Y0 = obtainStyledAttributes.getFloat(index, this.Y0);
                } else if (index == R.styleable.sb) {
                    this.b1 = obtainStyledAttributes.getFloat(index, this.b1);
                } else if (index == R.styleable.tb) {
                    this.c1 = obtainStyledAttributes.getFloat(index, this.c1);
                } else if (index == R.styleable.ob) {
                    this.d1 = obtainStyledAttributes.getFloat(index, this.d1);
                } else if (index == R.styleable.pb) {
                    this.e1 = obtainStyledAttributes.getFloat(index, this.e1);
                } else if (index == R.styleable.qb) {
                    this.f1 = obtainStyledAttributes.getFloat(index, this.f1);
                } else if (index == R.styleable.rb) {
                    this.g1 = obtainStyledAttributes.getFloat(index, this.g1);
                } else if (index == R.styleable.zb) {
                    this.h1 = obtainStyledAttributes.getFloat(index, this.h1);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ConstraintLayout.LayoutParams) layoutParams);
            this.V0 = 1.0f;
            this.W0 = false;
            this.X0 = 0.0f;
            this.Y0 = 0.0f;
            this.Z0 = 0.0f;
            this.a1 = 0.0f;
            this.b1 = 1.0f;
            this.c1 = 1.0f;
            this.d1 = 0.0f;
            this.e1 = 0.0f;
            this.f1 = 0.0f;
            this.g1 = 0.0f;
            this.h1 = 0.0f;
        }
    }

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void c(AttributeSet attributeSet) {
        Log.v(X2, " ################# init");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.s == null) {
            this.s = new ConstraintSet();
        }
        this.s.J(this);
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(attributeSet);
        super.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public Constraints(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        c(attributeSet);
        super.setVisibility(8);
    }
}
