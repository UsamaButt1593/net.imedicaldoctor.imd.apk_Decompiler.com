package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {
    private boolean f3 = false;
    private boolean g3 = false;
    private float h3;
    protected View[] i3;

    public MotionHelper(Context context) {
        super(context);
    }

    public void J(View view, float f2) {
    }

    public void a(MotionLayout motionLayout, int i2, int i4, float f2) {
    }

    public void b(MotionLayout motionLayout) {
    }

    public void c(MotionLayout motionLayout, int i2, int i4) {
    }

    public void d(MotionLayout motionLayout, int i2, boolean z, float f2) {
    }

    public boolean e() {
        return this.f3;
    }

    public boolean f() {
        return this.g3;
    }

    public void g(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
    }

    public float getProgress() {
        return this.h3;
    }

    public void h(Canvas canvas) {
    }

    public void i(Canvas canvas) {
    }

    public boolean j() {
        return false;
    }

    public void k(MotionLayout motionLayout, int i2) {
    }

    public void setProgress(float f2) {
        this.h3 = f2;
        int i2 = 0;
        if (this.X2 > 0) {
            this.i3 = w((ConstraintLayout) getParent());
            while (i2 < this.X2) {
                J(this.i3[i2], f2);
                i2++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i2 < childCount) {
            View childAt = viewGroup.getChildAt(i2);
            if (!(childAt instanceof MotionHelper)) {
                J(childAt, f2);
            }
            i2++;
        }
    }

    /* access modifiers changed from: protected */
    public void y(AttributeSet attributeSet) {
        super.y(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Gj);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Ij) {
                    this.f3 = obtainStyledAttributes.getBoolean(index, this.f3);
                } else if (index == R.styleable.Hj) {
                    this.g3 = obtainStyledAttributes.getBoolean(index, this.g3);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        y(attributeSet);
    }
}
