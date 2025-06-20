package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

public class NavigationRailView extends NavigationBarView {
    static final int m3 = 49;
    static final int n3 = 7;
    private static final int o3 = 49;
    static final int p3 = -1;
    private final int h3;
    @Nullable
    private View i3;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean j3;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean k3;
    /* access modifiers changed from: private */
    @Nullable
    public Boolean l3;

    public NavigationRailView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private void p() {
        ViewUtils.h(this, new ViewUtils.OnApplyWindowInsetsListener() {
            @NonNull
            public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.RelativePadding relativePadding) {
                Insets f2 = windowInsetsCompat.f(WindowInsetsCompat.Type.i());
                NavigationRailView navigationRailView = NavigationRailView.this;
                if (navigationRailView.u(navigationRailView.j3)) {
                    relativePadding.f21590b += f2.f5825b;
                }
                NavigationRailView navigationRailView2 = NavigationRailView.this;
                if (navigationRailView2.u(navigationRailView2.k3)) {
                    relativePadding.f21592d += f2.f5827d;
                }
                NavigationRailView navigationRailView3 = NavigationRailView.this;
                if (navigationRailView3.u(navigationRailView3.l3)) {
                    relativePadding.f21589a += ViewUtils.s(view) ? f2.f5826c : f2.f5824a;
                }
                relativePadding.a(view);
                return windowInsetsCompat;
            }
        });
    }

    private boolean r() {
        View view = this.i3;
        return (view == null || view.getVisibility() == 8) ? false : true;
    }

    private int s(int i2) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i2) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i2;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
    }

    /* access modifiers changed from: private */
    public boolean u(Boolean bool) {
        return bool != null ? bool.booleanValue() : ViewCompat.W(this);
    }

    @Nullable
    public View getHeaderView() {
        return this.i3;
    }

    public int getItemMinimumHeight() {
        return ((NavigationRailMenuView) getMenuView()).getItemMinimumHeight();
    }

    public int getMaxItemCount() {
        return 7;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public void n(@LayoutRes int i2) {
        o(LayoutInflater.from(getContext()).inflate(i2, this, false));
    }

    public void o(@NonNull View view) {
        t();
        this.i3 = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.h3;
        addView(view, 0, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        NavigationRailMenuView navigationRailMenuView = getNavigationRailMenuView();
        int i7 = 0;
        if (r()) {
            int bottom = this.i3.getBottom() + this.h3;
            int top = navigationRailMenuView.getTop();
            if (top < bottom) {
                i7 = bottom - top;
            }
        } else if (navigationRailMenuView.u()) {
            i7 = this.h3;
        }
        if (i7 > 0) {
            navigationRailMenuView.layout(navigationRailMenuView.getLeft(), navigationRailMenuView.getTop() + i7, navigationRailMenuView.getRight(), navigationRailMenuView.getBottom() + i7);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int s = s(i2);
        super.onMeasure(s, i4);
        if (r()) {
            measureChild(getNavigationRailMenuView(), s, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.i3.getMeasuredHeight()) - this.h3, Integer.MIN_VALUE));
        }
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: q */
    public NavigationRailMenuView c(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public void setItemMinimumHeight(@Px int i2) {
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i2);
    }

    public void setMenuGravity(int i2) {
        getNavigationRailMenuView().setMenuGravity(i2);
    }

    public void t() {
        View view = this.i3;
        if (view != null) {
            removeView(view);
            this.i3 = null;
        }
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.qe);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, R.style.Mj);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i4) {
        super(context, attributeSet, i2, i4);
        this.j3 = null;
        this.k3 = null;
        this.l3 = null;
        this.h3 = getResources().getDimensionPixelSize(R.dimen.Tc);
        Context context2 = getContext();
        TintTypedArray l2 = ThemeEnforcement.l(context2, attributeSet, R.styleable.nq, i2, i4, new int[0]);
        int u = l2.u(R.styleable.oq, 0);
        if (u != 0) {
            n(u);
        }
        setMenuGravity(l2.o(R.styleable.qq, 49));
        int i5 = R.styleable.pq;
        if (l2.C(i5)) {
            setItemMinimumHeight(l2.g(i5, -1));
        }
        int i6 = R.styleable.tq;
        if (l2.C(i6)) {
            this.j3 = Boolean.valueOf(l2.a(i6, false));
        }
        int i7 = R.styleable.rq;
        if (l2.C(i7)) {
            this.k3 = Boolean.valueOf(l2.a(i7, false));
        }
        int i8 = R.styleable.sq;
        if (l2.C(i8)) {
            this.l3 = Boolean.valueOf(l2.a(i8, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.Z7);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.X7);
        float b2 = AnimationUtils.b(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.f(context2) - 1.0f);
        setItemPaddingTop(Math.round((float) AnimationUtils.c(getItemPaddingTop(), dimensionPixelOffset, b2)));
        setItemPaddingBottom(Math.round((float) AnimationUtils.c(getItemPaddingBottom(), dimensionPixelOffset2, b2)));
        l2.I();
        p();
    }
}
