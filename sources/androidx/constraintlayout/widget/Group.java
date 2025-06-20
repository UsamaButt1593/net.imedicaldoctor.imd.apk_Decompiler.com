package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public void D(ConstraintLayout constraintLayout) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.v0.c2(0);
        layoutParams.v0.y1(0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
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
        this.a3 = false;
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
