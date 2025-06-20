package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;

public abstract class VirtualLayout extends ConstraintHelper {
    private boolean f3;
    private boolean g3;

    public VirtualLayout(Context context) {
        super(context);
    }

    public void J(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i2, int i3) {
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3 || this.g3) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = getElevation();
                for (int i2 = 0; i2 < this.X2; i2++) {
                    View o = constraintLayout.o(this.s[i2]);
                    if (o != null) {
                        if (this.f3) {
                            o.setVisibility(visibility);
                        }
                        if (this.g3 && elevation > 0.0f) {
                            o.setTranslationZ(o.getTranslationZ() + elevation);
                        }
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

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        p();
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.y6);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.F6) {
                    this.f3 = true;
                } else if (index == R.styleable.V6) {
                    this.g3 = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
