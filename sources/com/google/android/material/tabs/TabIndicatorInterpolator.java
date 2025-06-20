package com.google.android.material.tabs;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.tabs.TabLayout;

class TabIndicatorInterpolator {
    @Dimension(unit = 0)

    /* renamed from: a  reason: collision with root package name */
    private static final int f21980a = 24;

    TabIndicatorInterpolator() {
    }

    static RectF a(TabLayout tabLayout, @Nullable View view) {
        if (view == null) {
            return new RectF();
        }
        return (tabLayout.H() || !(view instanceof TabLayout.TabView)) ? new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom()) : b((TabLayout.TabView) view, 24);
    }

    static RectF b(@NonNull TabLayout.TabView tabView, @Dimension(unit = 0) int i2) {
        int contentWidth = tabView.getContentWidth();
        int contentHeight = tabView.getContentHeight();
        int i3 = (int) ViewUtils.i(tabView.getContext(), i2);
        if (contentWidth < i3) {
            contentWidth = i3;
        }
        int left = (tabView.getLeft() + tabView.getRight()) / 2;
        int top = (tabView.getTop() + tabView.getBottom()) / 2;
        int i4 = contentWidth / 2;
        return new RectF((float) (left - i4), (float) (top - (contentHeight / 2)), (float) (i4 + left), (float) (top + (left / 2)));
    }

    /* access modifiers changed from: package-private */
    public void c(TabLayout tabLayout, View view, @NonNull Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        drawable.setBounds((int) a2.left, drawable.getBounds().top, (int) a2.right, drawable.getBounds().bottom);
    }

    /* access modifiers changed from: package-private */
    public void d(TabLayout tabLayout, View view, View view2, @FloatRange(from = 0.0d, to = 1.0d) float f2, @NonNull Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        RectF a3 = a(tabLayout, view2);
        drawable.setBounds(AnimationUtils.c((int) a2.left, (int) a3.left, f2), drawable.getBounds().top, AnimationUtils.c((int) a2.right, (int) a3.right, f2), drawable.getBounds().bottom);
    }
}
