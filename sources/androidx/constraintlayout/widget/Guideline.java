package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Guideline extends View {
    private boolean s = true;

    public Guideline(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setFilterRedundantCalls(boolean z) {
        this.s = z;
    }

    public void setGuidelineBegin(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.s || layoutParams.f4626a != i2) {
            layoutParams.f4626a = i2;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelineEnd(int i2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.s || layoutParams.f4627b != i2) {
            layoutParams.f4627b = i2;
            setLayoutParams(layoutParams);
        }
    }

    public void setGuidelinePercent(float f2) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        if (!this.s || layoutParams.f4628c != f2) {
            layoutParams.f4628c = f2;
            setLayoutParams(layoutParams);
        }
    }

    public void setVisibility(int i2) {
    }

    public Guideline(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }

    public Guideline(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
