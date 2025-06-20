package com.google.android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.motion.MotionUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SnackbarContentLayout extends LinearLayout implements ContentViewCallback {
    private Button X2;
    private final TimeInterpolator Y2;
    private int Z2;
    private TextView s;

    public SnackbarContentLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private static void d(@NonNull View view, int i2, int i3) {
        if (ViewCompat.c1(view)) {
            ViewCompat.n2(view, ViewCompat.n0(view), i2, ViewCompat.m0(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean e(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.s.getPaddingTop() == i3 && this.s.getPaddingBottom() == i4) {
            return z;
        }
        d(this.s, i3, i4);
        return true;
    }

    public void a(int i2, int i3) {
        this.s.setAlpha(0.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.s.animate().alpha(1.0f).setDuration(j2).setInterpolator(this.Y2).setStartDelay(j3).start();
        if (this.X2.getVisibility() == 0) {
            this.X2.setAlpha(0.0f);
            this.X2.animate().alpha(1.0f).setDuration(j2).setInterpolator(this.Y2).setStartDelay(j3).start();
        }
    }

    public void b(int i2, int i3) {
        this.s.setAlpha(1.0f);
        long j2 = (long) i3;
        long j3 = (long) i2;
        this.s.animate().alpha(0.0f).setDuration(j2).setInterpolator(this.Y2).setStartDelay(j3).start();
        if (this.X2.getVisibility() == 0) {
            this.X2.setAlpha(1.0f);
            this.X2.animate().alpha(0.0f).setDuration(j2).setInterpolator(this.Y2).setStartDelay(j3).start();
        }
    }

    /* access modifiers changed from: package-private */
    public void c(float f2) {
        if (f2 != 1.0f) {
            this.X2.setTextColor(MaterialColors.t(MaterialColors.d(this, R.attr.e4), this.X2.getCurrentTextColor(), f2));
        }
    }

    public Button getActionView() {
        return this.X2;
    }

    public TextView getMessageView() {
        return this.s;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.s = (TextView) findViewById(R.id.i5);
        this.X2 = (Button) findViewById(R.id.h5);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (getOrientation() != 1) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.F1);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.E1);
            Layout layout2 = this.s.getLayout();
            boolean z = layout2 != null && layout2.getLineCount() > 1;
            if (!z || this.Z2 <= 0 || this.X2.getMeasuredWidth() <= this.Z2) {
                if (!z) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (!e(0, dimensionPixelSize, dimensionPixelSize)) {
                    return;
                }
            } else if (!e(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                return;
            }
            super.onMeasure(i2, i3);
        }
    }

    public void setMaxInlineActionWidth(int i2) {
        this.Z2 = i2;
    }

    public SnackbarContentLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Y2 = MotionUtils.g(context, R.attr.Vd, AnimationUtils.f20767b);
    }
}
