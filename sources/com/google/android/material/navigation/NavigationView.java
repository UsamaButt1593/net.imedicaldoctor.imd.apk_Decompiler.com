package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    private static final int[] t3 = {16842912};
    private static final int[] u3 = {-16842910};
    private static final int v3 = R.style.Qe;
    private static final int w3 = 1;
    @NonNull
    private final NavigationMenu d3;
    /* access modifiers changed from: private */
    public final NavigationMenuPresenter e3;
    OnNavigationItemSelectedListener f3;
    private final int g3;
    /* access modifiers changed from: private */
    public final int[] h3;
    private MenuInflater i3;
    private ViewTreeObserver.OnGlobalLayoutListener j3;
    private boolean k3;
    private boolean l3;
    @Px
    private int m3;
    private final boolean n3;
    @Px
    private final int o3;
    private final ShapeableDelegate p3;
    private final MaterialSideContainerBackHelper q3;
    /* access modifiers changed from: private */
    public final MaterialBackOrchestrator r3;
    private final DrawerLayout.DrawerListener s3;

    public interface OnNavigationItemSelectedListener {
        boolean a(@NonNull MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
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
        public Bundle Y;

        public SavedState(@NonNull Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
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

    public NavigationView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @CanIgnoreReturnValue
    private Pair<DrawerLayout, DrawerLayout.LayoutParams> B() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair<>((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    private void C() {
        this.j3 = new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.h3);
                boolean z = true;
                boolean z2 = NavigationView.this.h3[1] == 0;
                NavigationView.this.e3.G(z2);
                NavigationView navigationView2 = NavigationView.this;
                navigationView2.setDrawTopInsetForeground(z2 && navigationView2.w());
                NavigationView.this.setDrawLeftInsetForeground(NavigationView.this.h3[0] == 0 || NavigationView.this.h3[0] + NavigationView.this.getWidth() == 0);
                Activity a2 = ContextUtils.a(NavigationView.this.getContext());
                if (a2 != null) {
                    Rect b2 = WindowUtils.b(a2);
                    boolean z3 = b2.height() - NavigationView.this.getHeight() == NavigationView.this.h3[1];
                    boolean z4 = Color.alpha(a2.getWindow().getNavigationBarColor()) != 0;
                    NavigationView navigationView3 = NavigationView.this;
                    navigationView3.setDrawBottomInsetForeground(z3 && z4 && navigationView3.v());
                    if (!(b2.width() == NavigationView.this.h3[0] || b2.width() - NavigationView.this.getWidth() == NavigationView.this.h3[0])) {
                        z = false;
                    }
                    NavigationView.this.setDrawRightInsetForeground(z);
                }
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.j3);
    }

    private MenuInflater getMenuInflater() {
        if (this.i3 == null) {
            this.i3 = new SupportMenuInflater(getContext());
        }
        return this.i3;
    }

    @Nullable
    private ColorStateList o(int i2) {
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
        int[] iArr = u3;
        return new ColorStateList(new int[][]{iArr, t3, FrameLayout.EMPTY_STATE_SET}, new int[]{a2.getColorForState(iArr, defaultColor), i4, defaultColor});
    }

    @NonNull
    private Drawable p(@NonNull TintTypedArray tintTypedArray) {
        return q(tintTypedArray, MaterialResources.b(getContext(), tintTypedArray, R.styleable.Qq));
    }

    @NonNull
    private Drawable q(@NonNull TintTypedArray tintTypedArray, @Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.b(getContext(), tintTypedArray.u(R.styleable.Oq, 0), tintTypedArray.u(R.styleable.Pq, 0)).m());
        materialShapeDrawable.p0(colorStateList);
        return new InsetDrawable(materialShapeDrawable, tintTypedArray.g(R.styleable.Tq, 0), tintTypedArray.g(R.styleable.Uq, 0), tintTypedArray.g(R.styleable.Sq, 0), tintTypedArray.g(R.styleable.Rq, 0));
    }

    private boolean s(@NonNull TintTypedArray tintTypedArray) {
        return tintTypedArray.C(R.styleable.Oq) || tintTypedArray.C(R.styleable.Pq);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: private */
    public void y() {
        if (this.n3 && this.m3 != 0) {
            this.m3 = 0;
            z(getWidth(), getHeight());
        }
    }

    private void z(@Px int i2, @Px int i4) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.m3 > 0 || this.n3) && (getBackground() instanceof MaterialShapeDrawable)) {
                boolean z = GravityCompat.d(((DrawerLayout.LayoutParams) getLayoutParams()).f7420a, ViewCompat.c0(this)) == 3;
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                ShapeAppearanceModel.Builder o = materialShapeDrawable.getShapeAppearanceModel().v().o((float) this.m3);
                if (z) {
                    o.K(0.0f);
                    o.x(0.0f);
                } else {
                    o.P(0.0f);
                    o.C(0.0f);
                }
                ShapeAppearanceModel m2 = o.m();
                materialShapeDrawable.setShapeAppearanceModel(m2);
                this.p3.g(this, m2);
                this.p3.f(this, new RectF(0.0f, 0.0f, (float) i2, (float) i4));
                this.p3.i(this, true);
            }
        }
    }

    public void A(@NonNull View view) {
        this.e3.F(view);
    }

    public void c(@NonNull BackEventCompat backEventCompat) {
        B();
        this.q3.j(backEventCompat);
    }

    public void d(@NonNull BackEventCompat backEventCompat) {
        this.q3.l(backEventCompat, ((DrawerLayout.LayoutParams) B().second).f7420a);
        if (this.n3) {
            this.m3 = AnimationUtils.c(0, this.o3, this.q3.a(backEventCompat.a()));
            z(getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(@NonNull Canvas canvas) {
        this.p3.e(canvas, new c(this));
    }

    public void e() {
        Pair<DrawerLayout, DrawerLayout.LayoutParams> B = B();
        DrawerLayout drawerLayout = (DrawerLayout) B.first;
        BackEventCompat c2 = this.q3.c();
        if (c2 == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.f(this);
            return;
        }
        this.q3.h(c2, ((DrawerLayout.LayoutParams) B.second).f7420a, DrawerLayoutUtils.b(drawerLayout, this), DrawerLayoutUtils.c(drawerLayout));
    }

    public void g() {
        B();
        this.q3.f();
        y();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.q3;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.e3.o();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.e3.p();
    }

    @Px
    public int getDividerInsetStart() {
        return this.e3.q();
    }

    public int getHeaderCount() {
        return this.e3.r();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.e3.t();
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.e3.u();
    }

    @Dimension
    public int getItemIconPadding() {
        return this.e3.v();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.e3.y();
    }

    public int getItemMaxLines() {
        return this.e3.w();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.e3.x();
    }

    @Px
    public int getItemVerticalPadding() {
        return this.e3.z();
    }

    @NonNull
    public Menu getMenu() {
        return this.d3;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.e3.A();
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.e3.B();
    }

    /* access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void h(@NonNull WindowInsetsCompat windowInsetsCompat) {
        this.e3.k(windowInsetsCompat);
    }

    public void n(@NonNull View view) {
        this.e3.b(view);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
        ViewParent parent = getParent();
        if ((parent instanceof DrawerLayout) && this.r3.b()) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            drawerLayout.O(this.s3);
            drawerLayout.a(this.s3);
            if (drawerLayout.D(this)) {
                this.r3.e();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.j3);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            ((DrawerLayout) parent).O(this.s3);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int min;
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                min = this.g3;
            }
            super.onMeasure(i2, i4);
        }
        min = Math.min(View.MeasureSpec.getSize(i2), this.g3);
        i2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        super.onMeasure(i2, i4);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.d3.V(savedState.Y);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.Y = bundle;
        this.d3.X(bundle);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        z(i2, i4);
    }

    public View r(int i2) {
        return this.e3.s(i2);
    }

    public void setBottomInsetScrimEnabled(boolean z) {
        this.l3 = z;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem findItem = this.d3.findItem(i2);
        if (findItem != null) {
            this.e3.H((MenuItemImpl) findItem);
        }
    }

    public void setDividerInsetEnd(@Px int i2) {
        this.e3.I(i2);
    }

    public void setDividerInsetStart(@Px int i2) {
        this.e3.J(i2);
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.d(this, f2);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceCompatClippingEnabled(boolean z) {
        this.p3.h(this, z);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.e3.L(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(ContextCompat.l(getContext(), i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        this.e3.N(i2);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) {
        this.e3.N(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconPadding(@Dimension int i2) {
        this.e3.O(i2);
    }

    public void setItemIconPaddingResource(int i2) {
        this.e3.O(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconSize(@Dimension int i2) {
        this.e3.P(i2);
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.e3.Q(colorStateList);
    }

    public void setItemMaxLines(int i2) {
        this.e3.R(i2);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        this.e3.S(i2);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.e3.T(z);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.e3.U(colorStateList);
    }

    public void setItemVerticalPadding(@Px int i2) {
        this.e3.V(i2);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i2) {
        this.e3.V(getResources().getDimensionPixelSize(i2));
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f3 = onNavigationItemSelectedListener;
    }

    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.e3;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.W(i2);
        }
    }

    public void setSubheaderInsetEnd(@Px int i2) {
        this.e3.Y(i2);
    }

    public void setSubheaderInsetStart(@Px int i2) {
        this.e3.Z(i2);
    }

    public void setTopInsetScrimEnabled(boolean z) {
        this.k3 = z;
    }

    public View t(@LayoutRes int i2) {
        return this.e3.D(i2);
    }

    public void u(int i2) {
        this.e3.b0(true);
        getMenuInflater().inflate(i2, this.d3);
        this.e3.b0(false);
        this.e3.d(false);
    }

    public boolean v() {
        return this.l3;
    }

    public boolean w() {
        return this.k3;
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.re);
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem findItem = this.d3.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.e3.H((MenuItemImpl) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = v3
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            com.google.android.material.internal.NavigationMenuPresenter r10 = new com.google.android.material.internal.NavigationMenuPresenter
            r10.<init>()
            r0.e3 = r10
            r1 = 2
            int[] r1 = new int[r1]
            r0.h3 = r1
            r11 = 1
            r0.k3 = r11
            r0.l3 = r11
            r12 = 0
            r0.m3 = r12
            com.google.android.material.shape.ShapeableDelegate r1 = com.google.android.material.shape.ShapeableDelegate.a(r16)
            r0.p3 = r1
            com.google.android.material.motion.MaterialSideContainerBackHelper r1 = new com.google.android.material.motion.MaterialSideContainerBackHelper
            r1.<init>(r0)
            r0.q3 = r1
            com.google.android.material.motion.MaterialBackOrchestrator r1 = new com.google.android.material.motion.MaterialBackOrchestrator
            r1.<init>(r0)
            r0.r3 = r1
            com.google.android.material.navigation.NavigationView$1 r1 = new com.google.android.material.navigation.NavigationView$1
            r1.<init>()
            r0.s3 = r1
            android.content.Context r13 = r16.getContext()
            com.google.android.material.internal.NavigationMenu r14 = new com.google.android.material.internal.NavigationMenu
            r14.<init>(r13)
            r0.d3 = r14
            int[] r3 = com.google.android.material.R.styleable.wq
            int[] r6 = new int[r12]
            r1 = r13
            r2 = r18
            r4 = r19
            r5 = r9
            androidx.appcompat.widget.TintTypedArray r1 = com.google.android.material.internal.ThemeEnforcement.l(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.yq
            boolean r3 = r1.C(r2)
            if (r3 == 0) goto L_0x0068
            android.graphics.drawable.Drawable r2 = r1.h(r2)
            androidx.core.view.ViewCompat.P1(r0, r2)
        L_0x0068:
            int r2 = com.google.android.material.R.styleable.Eq
            int r2 = r1.g(r2, r12)
            r0.m3 = r2
            if (r2 != 0) goto L_0x0074
            r2 = 1
            goto L_0x0075
        L_0x0074:
            r2 = 0
        L_0x0075:
            r0.n3 = r2
            android.content.res.Resources r2 = r16.getResources()
            int r3 = com.google.android.material.R.dimen.E7
            int r2 = r2.getDimensionPixelSize(r3)
            r0.o3 = r2
            android.graphics.drawable.Drawable r2 = r16.getBackground()
            android.content.res.ColorStateList r3 = com.google.android.material.drawable.DrawableUtils.g(r2)
            if (r2 == 0) goto L_0x008f
            if (r3 == 0) goto L_0x00a7
        L_0x008f:
            com.google.android.material.shape.ShapeAppearanceModel$Builder r2 = com.google.android.material.shape.ShapeAppearanceModel.e(r13, r7, r8, r9)
            com.google.android.material.shape.ShapeAppearanceModel r2 = r2.m()
            com.google.android.material.shape.MaterialShapeDrawable r4 = new com.google.android.material.shape.MaterialShapeDrawable
            r4.<init>((com.google.android.material.shape.ShapeAppearanceModel) r2)
            if (r3 == 0) goto L_0x00a1
            r4.p0(r3)
        L_0x00a1:
            r4.a0(r13)
            androidx.core.view.ViewCompat.P1(r0, r4)
        L_0x00a7:
            int r2 = com.google.android.material.R.styleable.Fq
            boolean r3 = r1.C(r2)
            if (r3 == 0) goto L_0x00b7
            int r2 = r1.g(r2, r12)
            float r2 = (float) r2
            r0.setElevation(r2)
        L_0x00b7:
            int r2 = com.google.android.material.R.styleable.zq
            boolean r2 = r1.a(r2, r12)
            r0.setFitsSystemWindows(r2)
            int r2 = com.google.android.material.R.styleable.Aq
            int r2 = r1.g(r2, r12)
            r0.g3 = r2
            int r2 = com.google.android.material.R.styleable.cr
            boolean r3 = r1.C(r2)
            r4 = 0
            if (r3 == 0) goto L_0x00d6
            android.content.res.ColorStateList r2 = r1.d(r2)
            goto L_0x00d7
        L_0x00d6:
            r2 = r4
        L_0x00d7:
            int r3 = com.google.android.material.R.styleable.fr
            boolean r5 = r1.C(r3)
            if (r5 == 0) goto L_0x00e4
            int r3 = r1.u(r3, r12)
            goto L_0x00e5
        L_0x00e4:
            r3 = 0
        L_0x00e5:
            r5 = 16842808(0x1010038, float:2.3693715E-38)
            if (r3 != 0) goto L_0x00f0
            if (r2 != 0) goto L_0x00f0
            android.content.res.ColorStateList r2 = r0.o(r5)
        L_0x00f0:
            int r6 = com.google.android.material.R.styleable.Lq
            boolean r7 = r1.C(r6)
            if (r7 == 0) goto L_0x00fd
            android.content.res.ColorStateList r5 = r1.d(r6)
            goto L_0x0101
        L_0x00fd:
            android.content.res.ColorStateList r5 = r0.o(r5)
        L_0x0101:
            int r6 = com.google.android.material.R.styleable.Vq
            boolean r7 = r1.C(r6)
            if (r7 == 0) goto L_0x010e
            int r6 = r1.u(r6, r12)
            goto L_0x010f
        L_0x010e:
            r6 = 0
        L_0x010f:
            int r7 = com.google.android.material.R.styleable.Wq
            boolean r7 = r1.a(r7, r11)
            int r8 = com.google.android.material.R.styleable.Kq
            boolean r9 = r1.C(r8)
            if (r9 == 0) goto L_0x0124
            int r8 = r1.g(r8, r12)
            r0.setItemIconSize(r8)
        L_0x0124:
            int r8 = com.google.android.material.R.styleable.Xq
            boolean r9 = r1.C(r8)
            if (r9 == 0) goto L_0x0131
            android.content.res.ColorStateList r8 = r1.d(r8)
            goto L_0x0132
        L_0x0131:
            r8 = r4
        L_0x0132:
            if (r6 != 0) goto L_0x013d
            if (r8 != 0) goto L_0x013d
            r8 = 16842806(0x1010036, float:2.369371E-38)
            android.content.res.ColorStateList r8 = r0.o(r8)
        L_0x013d:
            int r9 = com.google.android.material.R.styleable.Hq
            android.graphics.drawable.Drawable r9 = r1.h(r9)
            if (r9 != 0) goto L_0x0167
            boolean r15 = r0.s(r1)
            if (r15 == 0) goto L_0x0167
            android.graphics.drawable.Drawable r9 = r0.p(r1)
            int r15 = com.google.android.material.R.styleable.Nq
            android.content.res.ColorStateList r15 = com.google.android.material.resources.MaterialResources.b(r13, r1, r15)
            if (r15 == 0) goto L_0x0167
            android.graphics.drawable.Drawable r11 = r0.q(r1, r4)
            android.graphics.drawable.RippleDrawable r12 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r15 = com.google.android.material.ripple.RippleUtils.e(r15)
            r12.<init>(r15, r4, r11)
            r10.M(r12)
        L_0x0167:
            int r4 = com.google.android.material.R.styleable.Iq
            boolean r11 = r1.C(r4)
            if (r11 == 0) goto L_0x0178
            r11 = 0
            int r4 = r1.g(r4, r11)
            r0.setItemHorizontalPadding(r4)
            goto L_0x0179
        L_0x0178:
            r11 = 0
        L_0x0179:
            int r4 = com.google.android.material.R.styleable.Yq
            boolean r12 = r1.C(r4)
            if (r12 == 0) goto L_0x0188
            int r4 = r1.g(r4, r11)
            r0.setItemVerticalPadding(r4)
        L_0x0188:
            int r4 = com.google.android.material.R.styleable.Dq
            int r4 = r1.g(r4, r11)
            r0.setDividerInsetStart(r4)
            int r4 = com.google.android.material.R.styleable.Cq
            int r4 = r1.g(r4, r11)
            r0.setDividerInsetEnd(r4)
            int r4 = com.google.android.material.R.styleable.er
            int r4 = r1.g(r4, r11)
            r0.setSubheaderInsetStart(r4)
            int r4 = com.google.android.material.R.styleable.dr
            int r4 = r1.g(r4, r11)
            r0.setSubheaderInsetEnd(r4)
            int r4 = com.google.android.material.R.styleable.gr
            boolean r12 = r0.k3
            boolean r4 = r1.a(r4, r12)
            r0.setTopInsetScrimEnabled(r4)
            int r4 = com.google.android.material.R.styleable.Bq
            boolean r12 = r0.l3
            boolean r4 = r1.a(r4, r12)
            r0.setBottomInsetScrimEnabled(r4)
            int r4 = com.google.android.material.R.styleable.Jq
            int r4 = r1.g(r4, r11)
            int r11 = com.google.android.material.R.styleable.Mq
            r12 = 1
            int r11 = r1.o(r11, r12)
            r0.setItemMaxLines(r11)
            com.google.android.material.navigation.NavigationView$2 r11 = new com.google.android.material.navigation.NavigationView$2
            r11.<init>()
            r14.Y(r11)
            r10.K(r12)
            r10.i(r13, r14)
            if (r3 == 0) goto L_0x01e5
            r10.a0(r3)
        L_0x01e5:
            r10.X(r2)
            r10.Q(r5)
            int r2 = r16.getOverScrollMode()
            r10.W(r2)
            if (r6 == 0) goto L_0x01f7
            r10.S(r6)
        L_0x01f7:
            r10.T(r7)
            r10.U(r8)
            r10.L(r9)
            r10.O(r4)
            r14.b(r10)
            androidx.appcompat.view.menu.MenuView r2 = r10.m(r0)
            android.view.View r2 = (android.view.View) r2
            r0.addView(r2)
            int r2 = com.google.android.material.R.styleable.Zq
            boolean r3 = r1.C(r2)
            if (r3 == 0) goto L_0x0220
            r3 = 0
            int r2 = r1.u(r2, r3)
            r0.u(r2)
            goto L_0x0221
        L_0x0220:
            r3 = 0
        L_0x0221:
            int r2 = com.google.android.material.R.styleable.Gq
            boolean r4 = r1.C(r2)
            if (r4 == 0) goto L_0x0230
            int r2 = r1.u(r2, r3)
            r0.t(r2)
        L_0x0230:
            r1.I()
            r16.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
