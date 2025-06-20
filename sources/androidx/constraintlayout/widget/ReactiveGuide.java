package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {
    private boolean X2 = false;
    private int Y2 = 0;
    private boolean Z2 = true;
    private int s = -1;

    public ReactiveGuide(Context context) {
        super(context);
        super.setVisibility(8);
        c((AttributeSet) null);
    }

    private void b(int i2, int i3, MotionLayout motionLayout, int i4) {
        ConstraintSet B0 = motionLayout.B0(i4);
        B0.d1(i3, i2);
        motionLayout.l1(i4, B0);
    }

    private void c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.K8);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.O8) {
                    this.s = obtainStyledAttributes.getResourceId(index, this.s);
                } else if (index == R.styleable.L8) {
                    this.X2 = obtainStyledAttributes.getBoolean(index, this.X2);
                } else if (index == R.styleable.N8) {
                    this.Y2 = obtainStyledAttributes.getResourceId(index, this.Y2);
                } else if (index == R.styleable.M8) {
                    this.Z2 = obtainStyledAttributes.getBoolean(index, this.Z2);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.s != -1) {
            ConstraintLayout.getSharedValues().a(this.s, this);
        }
    }

    public void a(int i2, int i3, int i4) {
        setGuidelineBegin(i3);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i5 = this.Y2;
            if (i5 != 0) {
                currentState = i5;
            }
            int i6 = 0;
            if (this.X2) {
                if (this.Z2) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i6 < constraintSetIds.length) {
                        int i7 = constraintSetIds[i6];
                        if (i7 != currentState) {
                            b(i3, id, motionLayout, i7);
                        }
                        i6++;
                    }
                }
                ConstraintSet n0 = motionLayout.n0(currentState);
                n0.d1(id, i3);
                motionLayout.m1(currentState, n0, 1000);
            } else if (this.Z2) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i6 < constraintSetIds2.length) {
                    b(i3, id, motionLayout, constraintSetIds2[i6]);
                    i6++;
                }
            } else {
                b(i3, id, motionLayout, currentState);
            }
        }
    }

    public boolean d() {
        return this.X2;
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.Y2;
    }

    public int getAttributeId() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setAnimateChange(boolean z) {
        this.X2 = z;
    }

    public void setApplyToConstraintSetId(int i2) {
        this.Y2 = i2;
    }

    public void setAttributeId(int i2) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i3 = this.s;
        if (i3 != -1) {
            sharedValues.e(i3, this);
        }
        this.s = i2;
        if (i2 != -1) {
            sharedValues.a(i2, this);
        }
    }

    public void setGuidelineBegin(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4626a = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4627b = i2;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.f4628c = f2;
        setLayoutParams(layoutParams);
    }

    public void setVisibility(int i2) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
        c(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
        c(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
        c(attributeSet);
    }
}
