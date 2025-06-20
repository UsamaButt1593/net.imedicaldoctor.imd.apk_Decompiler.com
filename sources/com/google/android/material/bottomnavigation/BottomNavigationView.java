package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationView extends NavigationBarView {
    private static final int h3 = 5;

    @Deprecated
    public interface OnNavigationItemReselectedListener extends NavigationBarView.OnItemReselectedListener {
    }

    @Deprecated
    public interface OnNavigationItemSelectedListener extends NavigationBarView.OnItemSelectedListener {
    }

    public BottomNavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void j(@NonNull Context context) {
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.g(context, R.color.V));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.b1)));
        addView(view);
    }

    private void k() {
        ViewUtils.h(this, new ViewUtils.OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                relativePadding.f21592d += windowInsetsCompat.o();
                boolean z = true;
                if (ViewCompat.c0(view) != 1) {
                    z = false;
                }
                int p = windowInsetsCompat.p();
                int q = windowInsetsCompat.q();
                relativePadding.f21589a += z ? q : p;
                int i2 = relativePadding.f21591c;
                if (!z) {
                    p = q;
                }
                relativePadding.f21591c = i2 + p;
                relativePadding.a(view);
                return windowInsetsCompat;
            }
        });
    }

    private int m(int i2) {
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumHeight <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumHeight + getPaddingTop() + getPaddingBottom()), 1073741824);
    }

    private boolean n() {
        return false;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarMenuView c(@NonNull Context context) {
        return new BottomNavigationMenuView(context);
    }

    public int getMaxItemCount() {
        return 5;
    }

    public boolean l() {
        return ((BottomNavigationMenuView) getMenuView()).u();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, m(i3));
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        BottomNavigationMenuView bottomNavigationMenuView = (BottomNavigationMenuView) getMenuView();
        if (bottomNavigationMenuView.u() != z) {
            bottomNavigationMenuView.setItemHorizontalTranslationEnabled(z);
            getPresenter().d(false);
        }
    }

    @Deprecated
    public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener onNavigationItemReselectedListener) {
        setOnItemReselectedListener(onNavigationItemReselectedListener);
    }

    @Deprecated
    public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        setOnItemSelectedListener(onNavigationItemSelectedListener);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.k1);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Me);
    }

    public BottomNavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        Context context2 = getContext();
        TintTypedArray l2 = ThemeEnforcement.l(context2, attributeSet, R.styleable.d5, i2, i3, new int[0]);
        setItemHorizontalTranslationEnabled(l2.a(R.styleable.g5, true));
        int i4 = R.styleable.e5;
        if (l2.C(i4)) {
            setMinimumHeight(l2.g(i4, 0));
        }
        if (l2.a(R.styleable.f5, true) && n()) {
            j(context2);
        }
        l2.I();
        k();
    }
}
