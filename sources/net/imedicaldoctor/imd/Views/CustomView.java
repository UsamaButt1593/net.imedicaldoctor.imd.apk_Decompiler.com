package net.imedicaldoctor.imd.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class CustomView extends RelativeLayout {
    static final String a3 = "http://schemas.android.com/apk/res-auto";
    static final String b3 = "http://schemas.android.com/apk/res/android";
    int X2;
    public boolean Y2 = false;
    boolean Z2 = false;
    final int s = Color.parseColor("#E2E2E2");

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onAnimationEnd() {
        super.onAnimationEnd();
        this.Z2 = false;
    }

    /* access modifiers changed from: protected */
    public void onAnimationStart() {
        super.onAnimationStart();
        this.Z2 = true;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Z2) {
            invalidate();
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setBackgroundColor(z ? this.X2 : this.s);
        invalidate();
    }
}
