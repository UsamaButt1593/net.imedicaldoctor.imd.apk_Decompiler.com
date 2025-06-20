package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuItemView extends ForegroundLinearLayout implements MenuView.ItemView {
    private static final int[] O3 = {16842912};
    private int D3;
    private boolean E3;
    boolean F3;
    boolean G3;
    private final CheckedTextView H3;
    private FrameLayout I3;
    private MenuItemImpl J3;
    private ColorStateList K3;
    private boolean L3;
    private Drawable M3;
    private final AccessibilityDelegateCompat N3;

    public NavigationMenuItemView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void F() {
        LinearLayoutCompat.LayoutParams layoutParams;
        int i2;
        if (J()) {
            this.H3.setVisibility(8);
            FrameLayout frameLayout = this.I3;
            if (frameLayout != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                i2 = -1;
            } else {
                return;
            }
        } else {
            this.H3.setVisibility(0);
            FrameLayout frameLayout2 = this.I3;
            if (frameLayout2 != null) {
                layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
                i2 = -2;
            } else {
                return;
            }
        }
        layoutParams.width = i2;
        this.I3.setLayoutParams(layoutParams);
    }

    @Nullable
    private StateListDrawable G() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.G0, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(O3, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean J() {
        return this.J3.getTitle() == null && this.J3.getIcon() == null && this.J3.getActionView() != null;
    }

    private void setActionView(@Nullable View view) {
        if (view != null) {
            if (this.I3 == null) {
                this.I3 = (FrameLayout) ((ViewStub) findViewById(com.google.android.material.R.id.g1)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.I3.removeAllViews();
            this.I3.addView(view);
        }
    }

    public void H(@NonNull MenuItemImpl menuItemImpl, boolean z) {
        this.G3 = z;
        h(menuItemImpl, 0);
    }

    public void I() {
        FrameLayout frameLayout = this.I3;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.H3.setCompoundDrawables((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void c(boolean z, char c2) {
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return true;
    }

    public MenuItemImpl getItemData() {
        return this.J3;
    }

    public void h(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.J3 = menuItemImpl;
        if (menuItemImpl.getItemId() > 0) {
            setId(menuItemImpl.getItemId());
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            ViewCompat.P1(this, G());
        }
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setTitle(menuItemImpl.getTitle());
        setIcon(menuItemImpl.getIcon());
        setActionView(menuItemImpl.getActionView());
        setContentDescription(menuItemImpl.getContentDescription());
        TooltipCompat.a(this, menuItemImpl.getTooltipText());
        F();
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.J3;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.J3.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, O3);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.F3 != z) {
            this.F3 = z;
            this.N3.l(this.H3, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.H3.setChecked(z);
        CheckedTextView checkedTextView = this.H3;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (!z || !this.G3) ? 0 : 1);
    }

    public void setHorizontalPadding(int i2) {
        setPadding(i2, getPaddingTop(), i2, getPaddingBottom());
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            if (this.L3) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.r(drawable).mutate();
                DrawableCompat.o(drawable, this.K3);
            }
            int i2 = this.D3;
            drawable.setBounds(0, 0, i2, i2);
        } else if (this.E3) {
            if (this.M3 == null) {
                Drawable g2 = ResourcesCompat.g(getResources(), com.google.android.material.R.drawable.p2, getContext().getTheme());
                this.M3 = g2;
                if (g2 != null) {
                    int i3 = this.D3;
                    g2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.M3;
        }
        TextViewCompat.u(this.H3, drawable, (Drawable) null, (Drawable) null, (Drawable) null);
    }

    public void setIconPadding(int i2) {
        this.H3.setCompoundDrawablePadding(i2);
    }

    public void setIconSize(@Dimension int i2) {
        this.D3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void setIconTintList(ColorStateList colorStateList) {
        this.K3 = colorStateList;
        this.L3 = colorStateList != null;
        MenuItemImpl menuItemImpl = this.J3;
        if (menuItemImpl != null) {
            setIcon(menuItemImpl.getIcon());
        }
    }

    public void setMaxLines(int i2) {
        this.H3.setMaxLines(i2);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.E3 = z;
    }

    public void setTextAppearance(int i2) {
        TextViewCompat.D(this.H3, i2);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.H3.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.H3.setText(charSequence);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.G3 = true;
        AnonymousClass1 r5 = new AccessibilityDelegateCompat() {
            public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.h1(NavigationMenuItemView.this.F3);
            }
        };
        this.N3 = r5;
        setOrientation(0);
        LayoutInflater.from(context).inflate(com.google.android.material.R.layout.P, this, true);
        setIconSize(context.getResources().getDimensionPixelSize(com.google.android.material.R.dimen.p1));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(com.google.android.material.R.id.h1);
        this.H3 = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        ViewCompat.H1(checkedTextView, r5);
    }
}
