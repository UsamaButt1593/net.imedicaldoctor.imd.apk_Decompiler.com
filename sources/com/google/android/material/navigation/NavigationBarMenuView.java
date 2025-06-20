package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int B3 = 5;
    private static final int C3 = -1;
    private static final int[] D3 = {16842912};
    private static final int[] E3 = {-16842910};
    /* access modifiers changed from: private */
    public MenuBuilder A3;
    @NonNull
    private final View.OnClickListener X2;
    private final Pools.Pool<NavigationBarItemView> Y2 = new Pools.SynchronizedPool(5);
    @NonNull
    private final SparseArray<View.OnTouchListener> Z2 = new SparseArray<>(5);
    private int a3;
    @Nullable
    private NavigationBarItemView[] b3;
    private int c3 = 0;
    private int d3 = 0;
    @Nullable
    private ColorStateList e3;
    @Dimension
    private int f3;
    private ColorStateList g3;
    @Nullable
    private final ColorStateList h3 = d(16842808);
    @StyleRes
    private int i3;
    @StyleRes
    private int j3;
    private boolean k3;
    private Drawable l3;
    @Nullable
    private ColorStateList m3;
    private int n3;
    @NonNull
    private final SparseArray<BadgeDrawable> o3 = new SparseArray<>(5);
    private int p3 = -1;
    private int q3 = -1;
    private int r3 = -1;
    @Nullable
    private final TransitionSet s;
    private boolean s3;
    private int t3;
    private int u3;
    private int v3;
    private ShapeAppearanceModel w3;
    private boolean x3 = false;
    private ColorStateList y3;
    /* access modifiers changed from: private */
    public NavigationBarPresenter z3;

    public NavigationBarMenuView(@NonNull Context context) {
        super(context);
        if (isInEditMode()) {
            this.s = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.s = autoTransition;
            autoTransition.p2(0);
            autoTransition.k1((long) MotionUtils.f(getContext(), R.attr.Ld, getResources().getInteger(R.integer.M)));
            autoTransition.r1(MotionUtils.g(getContext(), R.attr.Yd, AnimationUtils.f20767b));
            autoTransition.R1(new TextScale());
        }
        this.X2 = new View.OnClickListener() {
            public void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                if (!NavigationBarMenuView.this.A3.Q(itemData, NavigationBarMenuView.this.z3, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        ViewCompat.Z1(this, 1);
    }

    @Nullable
    private Drawable f() {
        if (this.w3 == null || this.y3 == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.w3);
        materialShapeDrawable.p0(this.y3);
        return materialShapeDrawable;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView b2 = this.Y2.b();
        return b2 == null ? g(getContext()) : b2;
    }

    private boolean m(int i2) {
        return i2 != -1;
    }

    private void o() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.A3.size(); i2++) {
            hashSet.add(Integer.valueOf(this.A3.getItem(i2).getItemId()));
        }
        for (int i4 = 0; i4 < this.o3.size(); i4++) {
            int keyAt = this.o3.keyAt(i4);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.o3.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (m(id) && (badgeDrawable = this.o3.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void t(int i2) {
        if (!m(i2)) {
            throw new IllegalArgumentException(i2 + " is not a valid view id");
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void c() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.Y2.c(navigationBarItemView);
                    navigationBarItemView.j();
                }
            }
        }
        if (this.A3.size() == 0) {
            this.c3 = 0;
            this.d3 = 0;
            this.b3 = null;
            return;
        }
        o();
        this.b3 = new NavigationBarItemView[this.A3.size()];
        boolean l2 = l(this.a3, this.A3.H().size());
        for (int i2 = 0; i2 < this.A3.size(); i2++) {
            this.z3.k(true);
            this.A3.getItem(i2).setCheckable(true);
            this.z3.k(false);
            NavigationBarItemView newItem = getNewItem();
            this.b3[i2] = newItem;
            newItem.setIconTintList(this.e3);
            newItem.setIconSize(this.f3);
            newItem.setTextColor(this.h3);
            newItem.setTextAppearanceInactive(this.i3);
            newItem.setTextAppearanceActive(this.j3);
            newItem.setTextAppearanceActiveBoldEnabled(this.k3);
            newItem.setTextColor(this.g3);
            int i4 = this.p3;
            if (i4 != -1) {
                newItem.setItemPaddingTop(i4);
            }
            int i5 = this.q3;
            if (i5 != -1) {
                newItem.setItemPaddingBottom(i5);
            }
            int i6 = this.r3;
            if (i6 != -1) {
                newItem.setActiveIndicatorLabelPadding(i6);
            }
            newItem.setActiveIndicatorWidth(this.t3);
            newItem.setActiveIndicatorHeight(this.u3);
            newItem.setActiveIndicatorMarginHorizontal(this.v3);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.x3);
            newItem.setActiveIndicatorEnabled(this.s3);
            Drawable drawable = this.l3;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.n3);
            }
            newItem.setItemRippleColor(this.m3);
            newItem.setShifting(l2);
            newItem.setLabelVisibilityMode(this.a3);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.A3.getItem(i2);
            newItem.h(menuItemImpl, 0);
            newItem.setItemPosition(i2);
            int itemId = menuItemImpl.getItemId();
            newItem.setOnTouchListener(this.Z2.get(itemId));
            newItem.setOnClickListener(this.X2);
            int i7 = this.c3;
            if (i7 != 0 && itemId == i7) {
                this.d3 = i2;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.A3.size() - 1, this.d3);
        this.d3 = min;
        this.A3.getItem(min).setChecked(true);
    }

    @Nullable
    public ColorStateList d(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList a2 = AppCompatResources.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.J0, typedValue, true)) {
            return null;
        }
        int i4 = typedValue.data;
        int defaultColor = a2.getDefaultColor();
        int[] iArr = E3;
        return new ColorStateList(new int[][]{iArr, D3, ViewGroup.EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i4, defaultColor});
    }

    public void e(@NonNull MenuBuilder menuBuilder) {
        this.A3 = menuBuilder;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract NavigationBarItemView g(@NonNull Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.r3;
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.o3;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.e3;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.y3;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.s3;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.u3;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.v3;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.w3;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.t3;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.l3 : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.n3;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f3;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.q3;
    }

    @Px
    public int getItemPaddingTop() {
        return this.p3;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.m3;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.j3;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.i3;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.g3;
    }

    public int getLabelVisibilityMode() {
        return this.a3;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public MenuBuilder getMenu() {
        return this.A3;
    }

    public int getSelectedItemId() {
        return this.c3;
    }

    /* access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.d3;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Nullable
    public NavigationBarItemView h(int i2) {
        t(i2);
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr == null) {
            return null;
        }
        for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
            if (navigationBarItemView.getId() == i2) {
                return navigationBarItemView;
            }
        }
        return null;
    }

    @Nullable
    public BadgeDrawable i(int i2) {
        return this.o3.get(i2);
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable j(int i2) {
        t(i2);
        BadgeDrawable badgeDrawable = this.o3.get(i2);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.f(getContext());
            this.o3.put(i2, badgeDrawable);
        }
        NavigationBarItemView h2 = h(i2);
        if (h2 != null) {
            h2.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return this.x3;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean l(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            r1 = 0
            r2 = 1
            if (r4 != r0) goto L_0x000a
            r4 = 3
            if (r5 <= r4) goto L_0x000d
        L_0x0008:
            r1 = 1
            goto L_0x000d
        L_0x000a:
            if (r4 != 0) goto L_0x000d
            goto L_0x0008
        L_0x000d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarMenuView.l(int, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
        t(i2);
        NavigationBarItemView h2 = h(i2);
        if (h2 != null) {
            h2.r();
        }
        this.o3.put(i2, (Object) null);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(1, this.A3.H().size(), false, 1));
    }

    /* access modifiers changed from: package-private */
    public void p(SparseArray<BadgeDrawable> sparseArray) {
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            int keyAt = sparseArray.keyAt(i2);
            if (this.o3.indexOfKey(keyAt) < 0) {
                this.o3.append(keyAt, sparseArray.get(keyAt));
            }
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                BadgeDrawable badgeDrawable = this.o3.get(navigationBarItemView.getId());
                if (badgeDrawable != null) {
                    navigationBarItemView.setBadge(badgeDrawable);
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void q(int i2, @Nullable View.OnTouchListener onTouchListener) {
        SparseArray<View.OnTouchListener> sparseArray = this.Z2;
        if (onTouchListener == null) {
            sparseArray.remove(i2);
        } else {
            sparseArray.put(i2, onTouchListener);
        }
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView.getItemData().getItemId() == i2) {
                    navigationBarItemView.setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(int i2) {
        int size = this.A3.size();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItem item = this.A3.getItem(i4);
            if (i2 == item.getItemId()) {
                this.c3 = i2;
                this.d3 = i4;
                item.setChecked(true);
                return;
            }
        }
    }

    public void s() {
        TransitionSet transitionSet;
        MenuBuilder menuBuilder = this.A3;
        if (menuBuilder != null && this.b3 != null) {
            int size = menuBuilder.size();
            if (size != this.b3.length) {
                c();
                return;
            }
            int i2 = this.c3;
            for (int i4 = 0; i4 < size; i4++) {
                MenuItem item = this.A3.getItem(i4);
                if (item.isChecked()) {
                    this.c3 = item.getItemId();
                    this.d3 = i4;
                }
            }
            if (!(i2 == this.c3 || (transitionSet = this.s) == null)) {
                TransitionManager.b(this, transitionSet);
            }
            boolean l2 = l(this.a3, this.A3.H().size());
            for (int i5 = 0; i5 < size; i5++) {
                this.z3.k(true);
                this.b3[i5].setLabelVisibilityMode(this.a3);
                this.b3[i5].setShifting(l2);
                this.b3[i5].h((MenuItemImpl) this.A3.getItem(i5), 0);
                this.z3.k(false);
            }
        }
    }

    public void setActiveIndicatorLabelPadding(@Px int i2) {
        this.r3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorLabelPadding : navigationBarItemViewArr) {
                activeIndicatorLabelPadding.setActiveIndicatorLabelPadding(i2);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.e3 = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconTintList : navigationBarItemViewArr) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.y3 = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorDrawable : navigationBarItemViewArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.s3 = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorEnabled : navigationBarItemViewArr) {
                activeIndicatorEnabled.setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i2) {
        this.u3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorHeight : navigationBarItemViewArr) {
                activeIndicatorHeight.setActiveIndicatorHeight(i2);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i2) {
        this.v3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorMarginHorizontal : navigationBarItemViewArr) {
                activeIndicatorMarginHorizontal.setActiveIndicatorMarginHorizontal(i2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z) {
        this.x3 = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorResizeable : navigationBarItemViewArr) {
                activeIndicatorResizeable.setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.w3 = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorDrawable : navigationBarItemViewArr) {
                activeIndicatorDrawable.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i2) {
        this.t3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView activeIndicatorWidth : navigationBarItemViewArr) {
                activeIndicatorWidth.setActiveIndicatorWidth(i2);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.l3 = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground : navigationBarItemViewArr) {
                itemBackground.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.n3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemBackground : navigationBarItemViewArr) {
                itemBackground.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView iconSize : navigationBarItemViewArr) {
                iconSize.setIconSize(i2);
            }
        }
    }

    public void setItemPaddingBottom(@Px int i2) {
        this.q3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemPaddingBottom : navigationBarItemViewArr) {
                itemPaddingBottom.setItemPaddingBottom(i2);
            }
        }
    }

    public void setItemPaddingTop(@Px int i2) {
        this.p3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemPaddingTop : navigationBarItemViewArr) {
                itemPaddingTop.setItemPaddingTop(i2);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.m3 = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView itemRippleColor : navigationBarItemViewArr) {
                itemRippleColor.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.j3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.g3;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.k3 = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView textAppearanceActiveBoldEnabled : navigationBarItemViewArr) {
                textAppearanceActiveBoldEnabled.setTextAppearanceActiveBoldEnabled(z);
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.i3 = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.g3;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.g3 = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.b3;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView textColor : navigationBarItemViewArr) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.a3 = i2;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.z3 = navigationBarPresenter;
    }
}
