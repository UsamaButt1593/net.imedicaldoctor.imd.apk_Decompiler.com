package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import java.util.ArrayList;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int F3;
    private final int G3;
    private final int H3;
    private final int I3;
    private boolean J3;
    private final List<Integer> K3 = new ArrayList();

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.F3 = resources.getDimensionPixelSize(R.dimen.X0);
        this.G3 = resources.getDimensionPixelSize(R.dimen.Y0);
        this.H3 = resources.getDimensionPixelSize(R.dimen.R0);
        this.I3 = resources.getDimensionPixelSize(R.dimen.S0);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public NavigationBarItemView g(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.c0(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = menu.H().size();
        int childCount = getChildCount();
        this.K3.clear();
        int size3 = View.MeasureSpec.getSize(i3);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i6 = 1;
        if (!l(getLabelVisibilityMode(), size2) || !u()) {
            if (size2 != 0) {
                i6 = size2;
            }
            int min = Math.min(size / i6, this.H3);
            int i7 = size - (size2 * min);
            for (int i8 = 0; i8 < childCount; i8++) {
                if (getChildAt(i8).getVisibility() == 8) {
                    i4 = 0;
                } else if (i7 > 0) {
                    i4 = min + 1;
                    i7--;
                } else {
                    i4 = min;
                }
                this.K3.add(Integer.valueOf(i4));
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i9 = this.I3;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.H3, Integer.MIN_VALUE), makeMeasureSpec);
                i9 = Math.max(i9, childAt.getMeasuredWidth());
            }
            int i10 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.G3 * i10), Math.min(i9, this.H3));
            int i11 = size - min2;
            if (i10 != 0) {
                i6 = i10;
            }
            int min3 = Math.min(i11 / i6, this.F3);
            int i12 = i11 - (i10 * min3);
            int i13 = 0;
            while (i13 < childCount) {
                if (getChildAt(i13).getVisibility() != 8) {
                    i5 = i13 == getSelectedItemPosition() ? min2 : min3;
                    if (i12 > 0) {
                        i5++;
                        i12--;
                    }
                } else {
                    i5 = 0;
                }
                this.K3.add(Integer.valueOf(i5));
                i13++;
            }
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.K3.get(i15).intValue(), 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i14 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(i14, size3);
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.J3 = z;
    }

    public boolean u() {
        return this.J3;
    }
}
