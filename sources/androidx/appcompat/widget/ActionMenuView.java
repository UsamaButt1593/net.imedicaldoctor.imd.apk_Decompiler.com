package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;

public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    private static final String J3 = "ActionMenuView";
    static final int K3 = 56;
    static final int L3 = 4;
    private boolean A3;
    private ActionMenuPresenter B3;
    private MenuPresenter.Callback C3;
    MenuBuilder.Callback D3;
    private boolean E3;
    private int F3;
    private int G3;
    private int H3;
    OnMenuItemClickListener I3;
    private MenuBuilder x3;
    private Context y3;
    private int z3;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ActionMenuChildView {
        boolean a();

        boolean d();
    }

    private static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        ActionMenuPresenterCallback() {
        }

        public void c(@NonNull MenuBuilder menuBuilder, boolean z) {
        }

        public boolean d(@NonNull MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f2998a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f2999b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f3000c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f3001d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f3002e;

        /* renamed from: f  reason: collision with root package name */
        boolean f3003f;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2998a = false;
        }

        LayoutParams(int i2, int i3, boolean z) {
            super(i2, i3);
            this.f2998a = z;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f2998a = layoutParams.f2998a;
        }
    }

    private class MenuBuilderCallback implements MenuBuilder.Callback {
        MenuBuilderCallback() {
        }

        public boolean a(@NonNull MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.I3;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        public void b(@NonNull MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.D3;
            if (callback != null) {
                callback.b(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    static int P(View view, int i2, int i3, int i4, int i5) {
        int i6;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.v();
        if (i3 > 0) {
            i6 = 2;
            if (!z2 || i3 >= 2) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
                int measuredWidth = view.getMeasuredWidth();
                int i7 = measuredWidth / i2;
                if (measuredWidth % i2 != 0) {
                    i7++;
                }
                if (!z2 || i7 >= 2) {
                    i6 = i7;
                }
                if (!layoutParams.f2998a && z2) {
                    z = true;
                }
                layoutParams.f3001d = z;
                layoutParams.f2999b = i6;
                view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
                return i6;
            }
        }
        i6 = 0;
        z = true;
        layoutParams.f3001d = z;
        layoutParams.f2999b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    private void Q(int i2, int i3) {
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        boolean z4;
        int i7;
        boolean z5;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingTop, -2);
        int i8 = size - paddingLeft;
        int i9 = this.G3;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = i9 + (i11 / i10);
        int childCount = getChildCount();
        int i13 = 0;
        int i14 = 0;
        boolean z6 = false;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j2 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            int i18 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i19 = i15 + 1;
                if (z7) {
                    int i20 = this.H3;
                    i7 = i19;
                    z5 = false;
                    childAt.setPadding(i20, 0, i20, 0);
                } else {
                    i7 = i19;
                    z5 = false;
                }
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f3003f = z5;
                layoutParams.f3000c = z5 ? 1 : 0;
                layoutParams.f2999b = z5;
                layoutParams.f3001d = z5;
                layoutParams.leftMargin = z5;
                layoutParams.rightMargin = z5;
                layoutParams.f3002e = z7 && ((ActionMenuItemView) childAt).v();
                int P = P(childAt, i12, layoutParams.f2998a ? 1 : i10, childMeasureSpec, paddingTop);
                i16 = Math.max(i16, P);
                if (layoutParams.f3001d) {
                    i17++;
                }
                if (layoutParams.f2998a) {
                    z6 = true;
                }
                i10 -= P;
                i13 = Math.max(i13, childAt.getMeasuredHeight());
                if (P == 1) {
                    j2 |= (long) (1 << i14);
                    i13 = i13;
                } else {
                    int i21 = i13;
                }
                i15 = i7;
            }
            i14++;
            size2 = i18;
        }
        int i22 = size2;
        boolean z8 = z6 && i15 == 2;
        boolean z9 = false;
        while (true) {
            if (i17 <= 0 || i10 <= 0) {
                i6 = mode;
                i4 = i8;
                z = z9;
                i5 = i13;
            } else {
                int i23 = 0;
                int i24 = 0;
                int i25 = Integer.MAX_VALUE;
                long j3 = 0;
                while (i24 < childCount) {
                    boolean z10 = z9;
                    LayoutParams layoutParams2 = (LayoutParams) getChildAt(i24).getLayoutParams();
                    int i26 = i13;
                    if (layoutParams2.f3001d) {
                        int i27 = layoutParams2.f2999b;
                        if (i27 < i25) {
                            j3 = 1 << i24;
                            i25 = i27;
                            i23 = 1;
                        } else if (i27 == i25) {
                            i23++;
                            j3 |= 1 << i24;
                        }
                    }
                    i24++;
                    i13 = i26;
                    z9 = z10;
                }
                z = z9;
                i5 = i13;
                j2 |= j3;
                if (i23 > i10) {
                    i6 = mode;
                    i4 = i8;
                    break;
                }
                int i28 = i25 + 1;
                int i29 = 0;
                while (i29 < childCount) {
                    View childAt2 = getChildAt(i29);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    int i30 = i8;
                    int i31 = mode;
                    long j4 = (long) (1 << i29);
                    if ((j3 & j4) == 0) {
                        if (layoutParams3.f2999b == i28) {
                            j2 |= j4;
                        }
                        z4 = z8;
                    } else {
                        if (!z8 || !layoutParams3.f3002e || i10 != 1) {
                            z4 = z8;
                        } else {
                            int i32 = this.H3;
                            z4 = z8;
                            childAt2.setPadding(i32 + i12, 0, i32, 0);
                        }
                        layoutParams3.f2999b++;
                        layoutParams3.f3003f = true;
                        i10--;
                    }
                    i29++;
                    mode = i31;
                    i8 = i30;
                    z8 = z4;
                }
                i13 = i5;
                z9 = true;
            }
        }
        boolean z11 = !z6 && i15 == 1;
        if (i10 <= 0 || j2 == 0 || (i10 >= i15 - 1 && !z11 && i16 <= 1)) {
            z2 = z;
        } else {
            float bitCount = (float) Long.bitCount(j2);
            if (!z11) {
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f3002e) {
                    bitCount -= 0.5f;
                }
                int i33 = childCount - 1;
                if ((j2 & ((long) (1 << i33))) != 0 && !((LayoutParams) getChildAt(i33).getLayoutParams()).f3002e) {
                    bitCount -= 0.5f;
                }
            }
            int i34 = bitCount > 0.0f ? (int) (((float) (i10 * i12)) / bitCount) : 0;
            z2 = z;
            for (int i35 = 0; i35 < childCount; i35++) {
                if ((j2 & ((long) (1 << i35))) != 0) {
                    View childAt3 = getChildAt(i35);
                    LayoutParams layoutParams4 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams4.f3000c = i34;
                        layoutParams4.f3003f = true;
                        if (i35 == 0 && !layoutParams4.f3002e) {
                            layoutParams4.leftMargin = (-i34) / 2;
                        }
                    } else if (layoutParams4.f2998a) {
                        layoutParams4.f3000c = i34;
                        layoutParams4.f3003f = true;
                        layoutParams4.rightMargin = (-i34) / 2;
                    } else {
                        if (i35 != 0) {
                            layoutParams4.leftMargin = i34 / 2;
                        }
                        if (i35 != childCount - 1) {
                            layoutParams4.rightMargin = i34 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i36 = 0; i36 < childCount; i36++) {
                View childAt4 = getChildAt(i36);
                LayoutParams layoutParams5 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams5.f3003f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams5.f2999b * i12) + layoutParams5.f3000c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i4, i6 != 1073741824 ? i5 : i22);
    }

    public void F() {
        ActionMenuPresenter actionMenuPresenter = this.B3;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: G */
    public LayoutParams o() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    /* renamed from: H */
    public LayoutParams p(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public LayoutParams q(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return o();
        }
        LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams2.gravity <= 0) {
            layoutParams2.gravity = 16;
        }
        return layoutParams2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public LayoutParams J() {
        LayoutParams G = o();
        G.f2998a = true;
        return G;
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean K(int i2) {
        boolean z = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            z = ((ActionMenuChildView) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? z : z | ((ActionMenuChildView) childAt2).d();
    }

    public boolean L() {
        ActionMenuPresenter actionMenuPresenter = this.B3;
        return actionMenuPresenter != null && actionMenuPresenter.E();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean M() {
        ActionMenuPresenter actionMenuPresenter = this.B3;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean N() {
        ActionMenuPresenter actionMenuPresenter = this.B3;
        return actionMenuPresenter != null && actionMenuPresenter.H();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean O() {
        return this.A3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MenuBuilder R() {
        return this.x3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void S(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.C3 = callback;
        this.D3 = callback2;
    }

    public boolean T() {
        ActionMenuPresenter actionMenuPresenter = this.B3;
        return actionMenuPresenter != null && actionMenuPresenter.Q();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean a(MenuItemImpl menuItemImpl) {
        return this.x3.P(menuItemImpl, 0);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void e(MenuBuilder menuBuilder) {
        this.x3 = menuBuilder;
    }

    public Menu getMenu() {
        if (this.x3 == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.x3 = menuBuilder;
            menuBuilder.Y(new MenuBuilderCallback());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.B3 = actionMenuPresenter;
            actionMenuPresenter.O(true);
            ActionMenuPresenter actionMenuPresenter2 = this.B3;
            MenuPresenter.Callback callback = this.C3;
            if (callback == null) {
                callback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter2.h(callback);
            this.x3.c(this.B3, this.y3);
            this.B3.M(this);
        }
        return this.x3;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        return this.B3.D();
    }

    public int getPopupTheme() {
        return this.z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int getWindowAnimations() {
        return 0;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.B3;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.d(false);
            if (this.B3.H()) {
                this.B3.E();
                this.B3.Q();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        F();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (!this.E3) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i2;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean b2 = ViewUtils.b(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2998a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (K(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b2) {
                        i6 = getPaddingLeft() + layoutParams.leftMargin;
                        i7 = i6 + measuredWidth;
                    } else {
                        i7 = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        i6 = i7 - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i6, i13, i7, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    K(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int max = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (b2) {
            int width = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f2998a) {
                    int i18 = width - layoutParams2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width = i18 - ((measuredWidth3 + layoutParams2.leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f2998a) {
                int i21 = paddingLeft + layoutParams3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + layoutParams3.rightMargin + max;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        MenuBuilder menuBuilder;
        boolean z = this.E3;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.E3 = z2;
        if (z != z2) {
            this.F3 = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.E3 || (menuBuilder = this.x3) == null || size == this.F3)) {
            this.F3 = size;
            menuBuilder.O(true);
        }
        int childCount = getChildCount();
        if (!this.E3 || childCount <= 0) {
            for (int i4 = 0; i4 < childCount; i4++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i4).getLayoutParams();
                layoutParams.rightMargin = 0;
                layoutParams.leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        Q(i2, i3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setExpandedActionViewsExclusive(boolean z) {
        this.B3.K(z);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.I3 = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        this.B3.N(drawable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setOverflowReserved(boolean z) {
        this.A3 = z;
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.z3 != i2) {
            this.z3 = i2;
            if (i2 == 0) {
                this.y3 = getContext();
            } else {
                this.y3 = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.B3 = actionMenuPresenter;
        actionMenuPresenter.M(this);
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.G3 = (int) (56.0f * f2);
        this.H3 = (int) (f2 * 4.0f);
        this.y3 = context;
        this.z3 = 0;
    }
}
