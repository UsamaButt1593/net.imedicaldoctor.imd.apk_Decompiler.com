package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class Layer extends ConstraintHelper {
    private static final String x3 = "Layer";
    private float f3 = Float.NaN;
    private float g3 = Float.NaN;
    private float h3 = Float.NaN;
    ConstraintLayout i3;
    private float j3 = 1.0f;
    private float k3 = 1.0f;
    protected float l3 = Float.NaN;
    protected float m3 = Float.NaN;
    protected float n3 = Float.NaN;
    protected float o3 = Float.NaN;
    protected float p3 = Float.NaN;
    protected float q3 = Float.NaN;
    boolean r3 = true;
    View[] s3 = null;
    private float t3 = 0.0f;
    private float u3 = 0.0f;
    private boolean v3;
    private boolean w3;

    public Layer(Context context) {
        super(context);
    }

    private void K() {
        int i2;
        if (this.i3 != null && (i2 = this.X2) != 0) {
            View[] viewArr = this.s3;
            if (viewArr == null || viewArr.length != i2) {
                this.s3 = new View[i2];
            }
            for (int i4 = 0; i4 < this.X2; i4++) {
                this.s3[i4] = this.i3.o(this.s[i4]);
            }
        }
    }

    private void L() {
        if (this.i3 != null) {
            if (this.s3 == null) {
                K();
            }
            J();
            double radians = Float.isNaN(this.h3) ? 0.0d : Math.toRadians((double) this.h3);
            float sin = (float) Math.sin(radians);
            float cos = (float) Math.cos(radians);
            float f2 = this.j3;
            float f4 = f2 * cos;
            float f5 = this.k3;
            float f6 = (-f5) * sin;
            float f7 = f2 * sin;
            float f8 = f5 * cos;
            for (int i2 = 0; i2 < this.X2; i2++) {
                View view = this.s3[i2];
                float left = ((float) ((view.getLeft() + view.getRight()) / 2)) - this.l3;
                float top = ((float) ((view.getTop() + view.getBottom()) / 2)) - this.m3;
                view.setTranslationX((((f4 * left) + (f6 * top)) - left) + this.t3);
                view.setTranslationY((((left * f7) + (f8 * top)) - top) + this.u3);
                view.setScaleY(this.k3);
                view.setScaleX(this.j3);
                if (!Float.isNaN(this.h3)) {
                    view.setRotation(this.h3);
                }
            }
        }
    }

    public void D(ConstraintLayout constraintLayout) {
        K();
        this.l3 = Float.NaN;
        this.m3 = Float.NaN;
        ConstraintWidget b2 = ((ConstraintLayout.LayoutParams) getLayoutParams()).b();
        b2.c2(0);
        b2.y1(0);
        J();
        layout(((int) this.p3) - getPaddingLeft(), ((int) this.q3) - getPaddingTop(), ((int) this.n3) + getPaddingRight(), ((int) this.o3) + getPaddingBottom());
        L();
    }

    public void F(ConstraintLayout constraintLayout) {
        this.i3 = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f || !Float.isNaN(this.h3)) {
            this.h3 = rotation;
        }
    }

    /* access modifiers changed from: protected */
    public void J() {
        if (this.i3 != null) {
            if (!this.r3 && !Float.isNaN(this.l3) && !Float.isNaN(this.m3)) {
                return;
            }
            if (Float.isNaN(this.f3) || Float.isNaN(this.g3)) {
                View[] w = w(this.i3);
                int left = w[0].getLeft();
                int top = w[0].getTop();
                int right = w[0].getRight();
                int bottom = w[0].getBottom();
                for (int i2 = 0; i2 < this.X2; i2++) {
                    View view = w[i2];
                    left = Math.min(left, view.getLeft());
                    top = Math.min(top, view.getTop());
                    right = Math.max(right, view.getRight());
                    bottom = Math.max(bottom, view.getBottom());
                }
                this.n3 = (float) right;
                this.o3 = (float) bottom;
                this.p3 = (float) left;
                this.q3 = (float) top;
                this.l3 = Float.isNaN(this.f3) ? (float) ((left + right) / 2) : this.f3;
                this.m3 = Float.isNaN(this.g3) ? (float) ((top + bottom) / 2) : this.g3;
                return;
            }
            this.m3 = this.g3;
            this.l3 = this.f3;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i3 = (ConstraintLayout) getParent();
        if (this.v3 || this.w3) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.X2; i2++) {
                View o = this.i3.o(this.s[i2]);
                if (o != null) {
                    if (this.v3) {
                        o.setVisibility(visibility);
                    }
                    if (this.w3 && elevation > 0.0f) {
                        o.setTranslationZ(o.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void r(ConstraintLayout constraintLayout) {
        q(constraintLayout);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        p();
    }

    public void setPivotX(float f2) {
        this.f3 = f2;
        L();
    }

    public void setPivotY(float f2) {
        this.g3 = f2;
        L();
    }

    public void setRotation(float f2) {
        this.h3 = f2;
        L();
    }

    public void setScaleX(float f2) {
        this.j3 = f2;
        L();
    }

    public void setScaleY(float f2) {
        this.k3 = f2;
        L();
    }

    public void setTranslationX(float f2) {
        this.t3 = f2;
        L();
    }

    public void setTranslationY(float f2) {
        this.u3 = f2;
        L();
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        p();
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        this.a3 = false;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.F6) {
                    this.v3 = true;
                } else if (index == R.styleable.V6) {
                    this.w3 = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
