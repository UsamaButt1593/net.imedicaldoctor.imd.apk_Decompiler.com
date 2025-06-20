package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ButtonBarLayout extends LinearLayout {
    private static final int Z2 = 16;
    private boolean X2;
    private int Y2 = -1;
    private boolean s;

    public ButtonBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] iArr = R.styleable.q3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.F1(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.s = obtainStyledAttributes.getBoolean(R.styleable.r3, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.s);
        }
    }

    private int a(int i2) {
        int childCount = getChildCount();
        while (i2 < childCount) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private boolean b() {
        return this.X2;
    }

    private void setStacked(boolean z) {
        if (this.X2 == z) {
            return;
        }
        if (!z || this.s) {
            this.X2 = z;
            setOrientation(z ? 1 : 0);
            setGravity(z ? GravityCompat.f6388c : 80);
            View findViewById = findViewById(R.id.i0);
            if (findViewById != null) {
                findViewById.setVisibility(z ? 8 : 4);
            }
            for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                bringChildToFront(getChildAt(childCount));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int i5 = 0;
        if (this.s) {
            if (size > this.Y2 && b()) {
                setStacked(false);
            }
            this.Y2 = size;
        }
        if (b() || View.MeasureSpec.getMode(i2) != 1073741824) {
            i4 = i2;
            z = false;
        } else {
            i4 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i4, i3);
        if (this.s && !b() && (getMeasuredWidthAndState() & ViewCompat.y) == 16777216) {
            setStacked(true);
            z = true;
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
        int a2 = a(0);
        if (a2 >= 0) {
            View childAt = getChildAt(a2);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (b()) {
                int a3 = a(a2 + 1);
                if (a3 >= 0) {
                    paddingTop += getChildAt(a3).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i5 = paddingTop;
            } else {
                i5 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.h0(this) != i5) {
            setMinimumHeight(i5);
            if (i3 == 0) {
                super.onMeasure(i2, i3);
            }
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.s != z) {
            this.s = z;
            if (!z && b()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
