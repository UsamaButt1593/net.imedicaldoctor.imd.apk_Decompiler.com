package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class SearchBar extends Toolbar {
    private static final int g4 = R.style.Ah;
    private static final int h4 = 53;
    private static final String i4 = "http://schemas.android.com/apk/res-auto";
    private final TextView R3;
    private final boolean S3;
    private final boolean T3;
    private final SearchBarAnimationHelper U3;
    private final Drawable V3;
    private final boolean W3;
    private final boolean X3;
    @Nullable
    private View Y3;
    @Nullable
    private Integer Z3;
    @Nullable
    private Drawable a4;
    private int b4;
    private boolean c4;
    private MaterialShapeDrawable d4;
    /* access modifiers changed from: private */
    @Nullable
    public final AccessibilityManager e4;
    /* access modifiers changed from: private */
    public final AccessibilityManagerCompat.TouchExplorationStateChangeListener f4;

    public static abstract class OnLoadAnimationCallback {
        public void a() {
        }

        public void b() {
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };
        String Y;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.Y);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean a3 = false;

        public ScrollingViewBehavior() {
        }

        private void j0(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT == 21) {
                appBarLayout.setOutlineProvider((ViewOutlineProvider) null);
            } else {
                appBarLayout.setTargetElevation(0.0f);
            }
        }

        /* access modifiers changed from: protected */
        public boolean e0() {
            return true;
        }

        public boolean p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            boolean p = super.p(coordinatorLayout, view, view2);
            if (!this.a3 && (view2 instanceof AppBarLayout)) {
                this.a3 = true;
                j0((AppBarLayout) view2);
            }
            return p;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public SearchBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A0(View view, int i2, int i3, int i5, int i6) {
        if (ViewCompat.c0(this) == 1) {
            view.layout(getMeasuredWidth() - i5, i3, getMeasuredWidth() - i2, i6);
        } else {
            view.layout(i2, i3, i5, i6);
        }
    }

    @Nullable
    private Drawable B0(@Nullable Drawable drawable) {
        int i2;
        if (!this.W3 || drawable == null) {
            return drawable;
        }
        Integer num = this.Z3;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = MaterialColors.d(this, drawable == this.V3 ? R.attr.K3 : R.attr.I3);
        }
        Drawable r = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(r, i2);
        return r;
    }

    private void C0(int i2, int i3) {
        View view = this.Y3;
        if (view != null) {
            view.measure(i2, i3);
        }
    }

    private void G0() {
        if (this.T3 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.i8);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = l0(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = l0(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = l0(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = l0(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void H0() {
        if (Build.VERSION.SDK_INT >= 34) {
            boolean z = true;
            int i2 = 0;
            if (getLayoutDirection() != 1) {
                z = false;
            }
            ImageButton e2 = ToolbarUtils.e(this);
            int width = (e2 == null || !e2.isClickable()) ? 0 : z ? getWidth() - e2.getLeft() : e2.getRight();
            ActionMenuView b2 = ToolbarUtils.b(this);
            if (b2 != null) {
                i2 = z ? b2.getRight() : getWidth() - b2.getLeft();
            }
            float f2 = (float) (-(z ? i2 : width));
            if (!z) {
                width = i2;
            }
            setHandwritingBoundsOffsets(f2, 0.0f, (float) (-width), 0.0f);
        }
    }

    private void I0() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.c4) {
                if (layoutParams.c() == 0) {
                    layoutParams.h(53);
                }
            } else if (layoutParams.c() == 53) {
                layoutParams.h(0);
            }
        }
    }

    private void J0() {
        AccessibilityManager accessibilityManager = this.e4;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && this.e4.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View view) {
                    AccessibilityManagerCompat.b(SearchBar.this.e4, SearchBar.this.f4);
                }

                public void onViewDetachedFromWindow(View view) {
                    AccessibilityManagerCompat.h(SearchBar.this.e4, SearchBar.this.f4);
                }
            });
        }
    }

    private void M0(@Nullable AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue(i4, "title") != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            } else if (attributeSet.getAttributeValue(i4, "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
    }

    private int l0(int i2, int i3) {
        return i2 == 0 ? i3 : i2;
    }

    private ColorStateList p0(@ColorInt int i2, @ColorInt int i3) {
        int[][] iArr = {new int[]{16842919}, new int[]{16842908}, new int[0]};
        int s = MaterialColors.s(i2, i3);
        return new ColorStateList(iArr, new int[]{s, s, i2});
    }

    private void q0(ShapeAppearanceModel shapeAppearanceModel, @ColorInt int i2, float f2, float f3, @ColorInt int i3) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        this.d4 = materialShapeDrawable;
        materialShapeDrawable.a0(getContext());
        this.d4.o0(f2);
        if (f3 >= 0.0f) {
            this.d4.E0(f3, i3);
        }
        int d2 = MaterialColors.d(this, R.attr.q3);
        this.d4.p0(ColorStateList.valueOf(i2));
        ColorStateList valueOf = ColorStateList.valueOf(d2);
        MaterialShapeDrawable materialShapeDrawable2 = this.d4;
        ViewCompat.P1(this, new RippleDrawable(valueOf, materialShapeDrawable2, materialShapeDrawable2));
    }

    private void r0() {
        setNavigationIcon(getNavigationIcon() == null ? this.V3 : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void s0(@StyleRes int i2, String str, String str2) {
        if (i2 != -1) {
            TextViewCompat.D(this.R3, i2);
        }
        setText((CharSequence) str);
        setHint((CharSequence) str2);
        if (getNavigationIcon() == null) {
            MarginLayoutParamsCompat.h((ViewGroup.MarginLayoutParams) this.R3.getLayoutParams(), getResources().getDimensionPixelSize(R.dimen.m8));
        }
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton e2 = ToolbarUtils.e(this);
        if (e2 != null) {
            e2.setClickable(!z);
            e2.setFocusable(!z);
            Drawable background = e2.getBackground();
            if (background != null) {
                this.a4 = background;
            }
            e2.setBackgroundDrawable(z ? null : this.a4);
            H0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(boolean z) {
        setFocusableInTouchMode(z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0() {
        this.U3.J(this);
    }

    private void z0() {
        View view = this.Y3;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i2 = measuredWidth2 + measuredWidth;
            int measuredHeight = this.Y3.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            A0(this.Y3, measuredWidth2, measuredHeight2, i2, measuredHeight2 + measuredHeight);
        }
    }

    public boolean D0(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.U3.D(animatorListenerAdapter);
    }

    public boolean E0(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        return this.U3.E(animatorListenerAdapter);
    }

    public boolean F0(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.U3.F(onLoadAnimationCallback);
    }

    public void K0() {
        post(new C0463b(this));
    }

    public void L0() {
        this.U3.K(this);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.S3 && this.Y3 == null && !(view instanceof ActionMenuView)) {
            this.Y3 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i2, layoutParams);
    }

    public void e0(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.U3.h(animatorListenerAdapter);
    }

    public void f0(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.U3.i(animatorListenerAdapter);
    }

    public void g0(@NonNull OnLoadAnimationCallback onLoadAnimationCallback) {
        this.U3.j(onLoadAnimationCallback);
    }

    @Nullable
    public View getCenterView() {
        return this.Y3;
    }

    /* access modifiers changed from: package-private */
    public float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.d4;
        return materialShapeDrawable != null ? materialShapeDrawable.y() : ViewCompat.T(this);
    }

    public float getCornerSize() {
        return this.d4.T();
    }

    /* access modifiers changed from: protected */
    @DimenRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultMarginVerticalResource() {
        return R.dimen.j8;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.h1;
    }

    @Nullable
    public CharSequence getHint() {
        return this.R3.getHint();
    }

    /* access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.b4;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.d4.O().getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.d4.R();
    }

    @NonNull
    public CharSequence getText() {
        return this.R3.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.R3;
    }

    public void h0() {
        this.R3.setText("");
    }

    @CanIgnoreReturnValue
    public boolean i0(@NonNull View view) {
        return j0(view, (AppBarLayout) null);
    }

    @CanIgnoreReturnValue
    public boolean j0(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return k0(view, appBarLayout, false);
    }

    @CanIgnoreReturnValue
    public boolean k0(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z) {
        if ((view.getVisibility() != 0 || t0()) && !v0()) {
            return false;
        }
        this.U3.H(this, view, appBarLayout, z);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean m0(@NonNull View view) {
        return n0(view, (AppBarLayout) null);
    }

    @CanIgnoreReturnValue
    public boolean n0(@NonNull View view, @Nullable AppBarLayout appBarLayout) {
        return o0(view, appBarLayout, false);
    }

    @CanIgnoreReturnValue
    public boolean o0(@NonNull View view, @Nullable AppBarLayout appBarLayout, boolean z) {
        if ((view.getVisibility() == 0 || v0()) && !t0()) {
            return false;
        }
        this.U3.I(this, view, appBarLayout, z);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.d4);
        G0();
        I0();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i2 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (i2 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i5, int i6) {
        super.onLayout(z, i2, i3, i5, i6);
        z0();
        H0();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        C0(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setText((CharSequence) savedState.Y);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.Y = text == null ? null : text.toString();
        return savedState;
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.Y3;
        if (view2 != null) {
            removeView(view2);
            this.Y3 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.c4 = z;
        I0();
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeDrawable materialShapeDrawable = this.d4;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.o0(f2);
        }
    }

    public void setHint(@StringRes int i2) {
        this.R3.setHint(i2);
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(B0(drawable));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (!this.X3) {
            super.setNavigationOnClickListener(onClickListener);
            setNavigationIconDecorative(onClickListener == null);
        }
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.U3.G(z);
    }

    public void setStrokeColor(@ColorInt int i2) {
        if (getStrokeColor() != i2) {
            this.d4.G0(ColorStateList.valueOf(i2));
        }
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (getStrokeWidth() != f2) {
            this.d4.J0(f2);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(@StringRes int i2) {
        this.R3.setText(i2);
    }

    public void setTitle(CharSequence charSequence) {
    }

    public boolean t0() {
        return this.U3.x();
    }

    public boolean u0() {
        return this.c4;
    }

    public boolean v0() {
        return this.U3.y();
    }

    public boolean w0() {
        return this.U3.z();
    }

    public void z(@MenuRes int i2) {
        Menu menu = getMenu();
        boolean z = menu instanceof MenuBuilder;
        if (z) {
            ((MenuBuilder) menu).n0();
        }
        super.z(i2);
        this.b4 = i2;
        if (z) {
            ((MenuBuilder) menu).m0();
        }
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Qc);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.R3.setHint(charSequence);
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.R3.setText(charSequence);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = g4
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.b4 = r11
            com.google.android.material.search.c r0 = new com.google.android.material.search.c
            r0.<init>(r10)
            r10.f4 = r0
            android.content.Context r7 = r10.getContext()
            r10.M0(r12)
            int r0 = r10.getDefaultNavigationIconResource()
            android.graphics.drawable.Drawable r0 = androidx.appcompat.content.res.AppCompatResources.b(r7, r0)
            r10.V3 = r0
            com.google.android.material.search.SearchBarAnimationHelper r0 = new com.google.android.material.search.SearchBarAnimationHelper
            r0.<init>()
            r10.U3 = r0
            int[] r2 = com.google.android.material.R.styleable.ps
            r8 = 0
            int[] r5 = new int[r8]
            r0 = r7
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r12 = com.google.android.material.shape.ShapeAppearanceModel.e(r7, r12, r13, r6)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r12.m()
            int r12 = com.google.android.material.R.styleable.ts
            int r3 = r0.getColor(r12, r8)
            int r12 = com.google.android.material.R.styleable.ws
            r13 = 0
            float r4 = r0.getDimension(r12, r13)
            int r12 = com.google.android.material.R.styleable.us
            r13 = 1
            boolean r12 = r0.getBoolean(r12, r13)
            r10.T3 = r12
            int r12 = com.google.android.material.R.styleable.vs
            boolean r12 = r0.getBoolean(r12, r13)
            r10.c4 = r12
            int r12 = com.google.android.material.R.styleable.ys
            boolean r12 = r0.getBoolean(r12, r8)
            int r1 = com.google.android.material.R.styleable.xs
            boolean r1 = r0.getBoolean(r1, r8)
            r10.X3 = r1
            int r1 = com.google.android.material.R.styleable.Cs
            boolean r1 = r0.getBoolean(r1, r13)
            r10.W3 = r1
            int r1 = com.google.android.material.R.styleable.zs
            boolean r5 = r0.hasValue(r1)
            if (r5 == 0) goto L_0x0086
            int r1 = r0.getColor(r1, r11)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10.Z3 = r1
        L_0x0086:
            int r1 = com.google.android.material.R.styleable.qs
            int r11 = r0.getResourceId(r1, r11)
            int r1 = com.google.android.material.R.styleable.rs
            java.lang.String r1 = r0.getString(r1)
            int r5 = com.google.android.material.R.styleable.ss
            java.lang.String r5 = r0.getString(r5)
            int r6 = com.google.android.material.R.styleable.Bs
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r6 = r0.getDimension(r6, r9)
            int r9 = com.google.android.material.R.styleable.As
            int r8 = r0.getColor(r9, r8)
            r0.recycle()
            if (r12 != 0) goto L_0x00ae
            r10.r0()
        L_0x00ae:
            r10.setClickable(r13)
            r10.setFocusable(r13)
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r7)
            int r0 = com.google.android.material.R.layout.R0
            r12.inflate(r0, r10)
            r10.S3 = r13
            int r12 = com.google.android.material.R.id.S3
            android.view.View r12 = r10.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r10.R3 = r12
            androidx.core.view.ViewCompat.V1(r10, r4)
            r10.s0(r11, r1, r5)
            r1 = r10
            r5 = r6
            r6 = r8
            r1.q0(r2, r3, r4, r5, r6)
            android.content.Context r11 = r10.getContext()
            java.lang.String r12 = "accessibility"
            java.lang.Object r11 = r11.getSystemService(r12)
            android.view.accessibility.AccessibilityManager r11 = (android.view.accessibility.AccessibilityManager) r11
            r10.e4 = r11
            r10.J0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
