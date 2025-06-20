package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class NavigationBarView extends FrameLayout {
    public static final int c3 = -1;
    public static final int d3 = 0;
    public static final int e3 = 1;
    public static final int f3 = 2;
    private static final int g3 = 1;
    @NonNull
    private final NavigationBarMenuView X2;
    @NonNull
    private final NavigationBarPresenter Y2;
    private MenuInflater Z2;
    /* access modifiers changed from: private */
    public OnItemSelectedListener a3;
    /* access modifiers changed from: private */
    public OnItemReselectedListener b3;
    @NonNull
    private final NavigationBarMenu s;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void a(@NonNull MenuItem menuItem);
    }

    public interface OnItemSelectedListener {
        boolean a(@NonNull MenuItem menuItem);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        @Nullable
        Bundle Y;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        private void b(@NonNull Parcel parcel, ClassLoader classLoader) {
            this.Y = parcel.readBundle(classLoader);
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.Y);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationBarView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i3) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.Y2 = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = R.styleable.Wp;
        int i4 = R.styleable.jq;
        int i5 = R.styleable.hq;
        TintTypedArray l2 = ThemeEnforcement.l(context2, attributeSet, iArr, i2, i3, i4, i5);
        NavigationBarMenu navigationBarMenu = new NavigationBarMenu(context2, getClass(), getMaxItemCount());
        this.s = navigationBarMenu;
        NavigationBarMenuView c2 = c(context2);
        this.X2 = c2;
        navigationBarPresenter.b(c2);
        navigationBarPresenter.a(1);
        c2.setPresenter(navigationBarPresenter);
        navigationBarMenu.b(navigationBarPresenter);
        navigationBarPresenter.i(getContext(), navigationBarMenu);
        int i6 = R.styleable.dq;
        c2.setIconTintList(l2.C(i6) ? l2.d(i6) : c2.d(16842808));
        setItemIconSize(l2.g(R.styleable.cq, getResources().getDimensionPixelSize(R.dimen.Fc)));
        if (l2.C(i4)) {
            setItemTextAppearanceInactive(l2.u(i4, 0));
        }
        if (l2.C(i5)) {
            setItemTextAppearanceActive(l2.u(i5, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(l2.a(R.styleable.iq, true));
        int i7 = R.styleable.kq;
        if (l2.C(i7)) {
            setItemTextColor(l2.d(i7));
        }
        Drawable background = getBackground();
        ColorStateList g2 = DrawableUtils.g(background);
        if (background == null || g2 != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.e(context2, attributeSet, i2, i3).m());
            if (g2 != null) {
                materialShapeDrawable.p0(g2);
            }
            materialShapeDrawable.a0(context2);
            ViewCompat.P1(this, materialShapeDrawable);
        }
        int i8 = R.styleable.fq;
        if (l2.C(i8)) {
            setItemPaddingTop(l2.g(i8, 0));
        }
        int i9 = R.styleable.eq;
        if (l2.C(i9)) {
            setItemPaddingBottom(l2.g(i9, 0));
        }
        int i10 = R.styleable.Xp;
        if (l2.C(i10)) {
            setActiveIndicatorLabelPadding(l2.g(i10, 0));
        }
        int i11 = R.styleable.Zp;
        if (l2.C(i11)) {
            setElevation((float) l2.g(i11, 0));
        }
        DrawableCompat.o(getBackground().mutate(), MaterialResources.b(context2, l2, R.styleable.Yp));
        setLabelVisibilityMode(l2.p(R.styleable.lq, -1));
        int u = l2.u(R.styleable.bq, 0);
        if (u != 0) {
            c2.setItemBackgroundRes(u);
        } else {
            setItemRippleColor(MaterialResources.b(context2, l2, R.styleable.gq));
        }
        int u2 = l2.u(R.styleable.aq, 0);
        if (u2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(u2, R.styleable.Qp);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Sp, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Rp, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Up, 0));
            setItemActiveIndicatorColor(MaterialResources.a(context2, obtainStyledAttributes, R.styleable.Tp));
            setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.b(context2, obtainStyledAttributes.getResourceId(R.styleable.Vp, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        int i12 = R.styleable.mq;
        if (l2.C(i12)) {
            f(l2.u(i12, 0));
        }
        l2.I();
        addView(c2);
        navigationBarMenu.Y(new MenuBuilder.Callback() {
            public boolean a(MenuBuilder menuBuilder, @NonNull MenuItem menuItem) {
                if (NavigationBarView.this.b3 == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                    return NavigationBarView.this.a3 != null && !NavigationBarView.this.a3.a(menuItem);
                }
                NavigationBarView.this.b3.a(menuItem);
                return true;
            }

            public void b(MenuBuilder menuBuilder) {
            }
        });
    }

    private MenuInflater getMenuInflater() {
        if (this.Z2 == null) {
            this.Z2 = new SupportMenuInflater(getContext());
        }
        return this.Z2;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract NavigationBarMenuView c(@NonNull Context context);

    @Nullable
    public BadgeDrawable d(int i2) {
        return this.X2.i(i2);
    }

    @NonNull
    public BadgeDrawable e(int i2) {
        return this.X2.j(i2);
    }

    public void f(int i2) {
        this.Y2.k(true);
        getMenuInflater().inflate(i2, this.s);
        this.Y2.k(false);
        this.Y2.d(true);
    }

    public boolean g() {
        return this.X2.getItemActiveIndicatorEnabled();
    }

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.X2.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.X2.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.X2.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.X2.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.X2.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.X2.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.X2.getItemBackground();
    }

    @Deprecated
    @DrawableRes
    public int getItemBackgroundResource() {
        return this.X2.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.X2.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.X2.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.X2.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.X2.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.X2.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.X2.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.X2.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.X2.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.X2.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.s;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public MenuView getMenuView() {
        return this.X2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public NavigationBarPresenter getPresenter() {
        return this.Y2;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.X2.getSelectedItemId();
    }

    public void h(int i2) {
        this.X2.n(i2);
    }

    public void i(int i2, @Nullable View.OnTouchListener onTouchListener) {
        this.X2.q(i2, onTouchListener);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(@Nullable Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.s.V(savedState.Y);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.Y = bundle;
        this.s.X(bundle);
        return savedState;
    }

    public void setActiveIndicatorLabelPadding(@Px int i2) {
        this.X2.setActiveIndicatorLabelPadding(i2);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.d(this, f2);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.X2.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.X2.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorHeight(@Px int i2) {
        this.X2.setItemActiveIndicatorHeight(i2);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i2) {
        this.X2.setItemActiveIndicatorMarginHorizontal(i2);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.X2.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(@Px int i2) {
        this.X2.setItemActiveIndicatorWidth(i2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.X2.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.X2.setItemBackgroundRes(i2);
    }

    public void setItemIconSize(@Dimension int i2) {
        this.X2.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.X2.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(@Px int i2) {
        this.X2.setItemPaddingBottom(i2);
    }

    public void setItemPaddingTop(@Px int i2) {
        this.X2.setItemPaddingTop(i2);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.X2.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) {
        this.X2.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.X2.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) {
        this.X2.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.X2.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.X2.getLabelVisibilityMode() != i2) {
            this.X2.setLabelVisibilityMode(i2);
            this.Y2.d(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener onItemReselectedListener) {
        this.b3 = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.a3 = onItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i2) {
        MenuItem findItem = this.s.findItem(i2);
        if (findItem != null && !this.s.Q(findItem, this.Y2, 0)) {
            findItem.setChecked(true);
        }
    }
}
