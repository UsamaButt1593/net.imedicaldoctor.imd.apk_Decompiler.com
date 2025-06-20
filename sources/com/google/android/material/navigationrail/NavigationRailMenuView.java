package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationRailMenuView extends NavigationBarMenuView {
    @Px
    private int F3 = -1;
    private final FrameLayout.LayoutParams G3;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.G3 = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        setItemActiveIndicatorResizeable(true);
    }

    private int v(int i2, int i3, int i4) {
        int max = i3 / Math.max(1, i4);
        int i5 = this.F3;
        if (i5 == -1) {
            i5 = View.MeasureSpec.getSize(i2);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i5, max), 0);
    }

    private int w(View view, int i2, int i3) {
        if (view.getVisibility() == 8) {
            return 0;
        }
        view.measure(i2, i3);
        return view.getMeasuredHeight();
    }

    private int x(int i2, int i3, int i4, View view) {
        int v = view == null ? v(i2, i3, i4) : View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                i5 += w(childAt, i2, v);
            }
        }
        return i5;
    }

    private int y(int i2, int i3, int i4) {
        int i5;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i5 = w(childAt, i2, v(i2, i3, i4));
            i3 -= i5;
            i4--;
        } else {
            i5 = 0;
        }
        return i5 + x(i2, i3, i4, childAt);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView g(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    @Px
    public int getItemMinimumHeight() {
        return this.F3;
    }

    /* access modifiers changed from: package-private */
    public int getMenuGravity() {
        return this.G3.gravity;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i6, measuredHeight);
                i7 = measuredHeight;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i3);
        int size2 = getMenu().H().size();
        setMeasuredDimension(View.MeasureSpec.getSize(i2), View.resolveSizeAndState((size2 <= 1 || !l(getLabelVisibilityMode(), size2)) ? x(i2, size, size2, (View) null) : y(i2, size, size2), i3, 0));
    }

    public void setItemMinimumHeight(@Px int i2) {
        if (this.F3 != i2) {
            this.F3 = i2;
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void setMenuGravity(int i2) {
        FrameLayout.LayoutParams layoutParams = this.G3;
        if (layoutParams.gravity != i2) {
            layoutParams.gravity = i2;
            setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        return (this.G3.gravity & 112) == 48;
    }
}
