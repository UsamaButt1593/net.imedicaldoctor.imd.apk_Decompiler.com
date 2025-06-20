package com.google.android.material.search;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.shape.MaterialShapeUtils;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class SearchView extends FrameLayout implements CoordinatorLayout.AttachedBehavior, MaterialBackHandler {
    private static final int A3 = R.style.Ch;
    private static final long z3 = 100;
    final ClippableRoundedCornerLayout X2;
    final View Y2;
    final View Z2;
    final FrameLayout a3;
    final FrameLayout b3;
    final MaterialToolbar c3;
    final Toolbar d3;
    final TextView e3;
    final EditText f3;
    final ImageButton g3;
    final View h3;
    final TouchObserverFrameLayout i3;
    private final boolean j3;
    private final SearchViewAnimationHelper k3;
    @NonNull
    private final MaterialBackOrchestrator l3;
    private final boolean m3;
    private final ElevationOverlayProvider n3;
    private final Set<TransitionListener> o3;
    @Nullable
    private SearchBar p3;
    private int q3;
    private boolean r3;
    final View s;
    private boolean s3;
    private boolean t3;
    @ColorInt
    private final int u3;
    private boolean v3;
    private boolean w3;
    @NonNull
    private TransitionState x3;
    private Map<View, Integer> y3;

    public static class Behavior extends CoordinatorLayout.Behavior<SearchView> {
        public Behavior() {
        }

        /* renamed from: N */
        public boolean p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull SearchView searchView, @NonNull View view) {
            if (searchView.D() || !(view instanceof SearchBar)) {
                return false;
            }
            searchView.setupWithSearchBar((SearchBar) view);
            return false;
        }

        public Behavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
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
        int Z;

        public SavedState(Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.Y);
            parcel.writeInt(this.Z);
        }

        public SavedState(Parcel parcel, @Nullable ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readString();
            this.Z = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public interface TransitionListener {
        void a(@NonNull SearchView searchView, @NonNull TransitionState transitionState, @NonNull TransitionState transitionState2);
    }

    public enum TransitionState {
        HIDING,
        HIDDEN,
        SHOWING,
        SHOWN
    }

    public SearchView(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private boolean A() {
        return this.x3.equals(TransitionState.HIDDEN) || this.x3.equals(TransitionState.HIDING);
    }

    private boolean C(@NonNull Toolbar toolbar) {
        return DrawableCompat.q(toolbar.getNavigationIcon()) instanceof DrawerArrowDrawable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G() {
        this.f3.clearFocus();
        SearchBar searchBar = this.p3;
        if (searchBar != null) {
            searchBar.requestFocus();
        }
        ViewUtils.r(this.f3, this.v3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H() {
        if (this.f3.requestFocus()) {
            this.f3.sendAccessibilityEvent(8);
        }
        ViewUtils.C(this.f3, this.v3);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        v();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        u();
        U();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean K(View view, MotionEvent motionEvent) {
        if (!x()) {
            return false;
        }
        t();
        return false;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ WindowInsetsCompat L(ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i4, View view, WindowInsetsCompat windowInsetsCompat) {
        marginLayoutParams.leftMargin = i2 + windowInsetsCompat.p();
        marginLayoutParams.rightMargin = i4 + windowInsetsCompat.q();
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat N(View view, WindowInsetsCompat windowInsetsCompat) {
        int r = windowInsetsCompat.r();
        setUpStatusBarSpacer(r);
        if (!this.w3) {
            setStatusBarSpacerEnabledInternal(r > 0);
        }
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ WindowInsetsCompat O(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        boolean s2 = ViewUtils.s(this.c3);
        this.c3.setPadding((s2 ? relativePadding.f21591c : relativePadding.f21589a) + windowInsetsCompat.p(), relativePadding.f21590b, (s2 ? relativePadding.f21589a : relativePadding.f21591c) + windowInsetsCompat.q(), relativePadding.f21592d);
        return windowInsetsCompat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        g0();
    }

    private void V(@NonNull TransitionState transitionState, boolean z) {
        boolean z2;
        if (!this.x3.equals(transitionState)) {
            if (z) {
                if (transitionState == TransitionState.SHOWN) {
                    z2 = true;
                } else if (transitionState == TransitionState.HIDDEN) {
                    z2 = false;
                }
                setModalForAccessibility(z2);
            }
            TransitionState transitionState2 = this.x3;
            this.x3 = transitionState;
            for (TransitionListener a2 : new LinkedHashSet(this.o3)) {
                a2.a(this, transitionState2, transitionState);
            }
            i0(transitionState);
        }
    }

    private void W(boolean z, boolean z2) {
        if (z2) {
            this.c3.setNavigationIcon((Drawable) null);
            return;
        }
        this.c3.setNavigationOnClickListener(new l(this));
        if (z) {
            DrawerArrowDrawable drawerArrowDrawable = new DrawerArrowDrawable(getContext());
            drawerArrowDrawable.p(MaterialColors.d(this, R.attr.I3));
            this.c3.setNavigationIcon(drawerArrowDrawable);
        }
    }

    private void X() {
        setUpBackgroundViewElevationOverlay(getOverlayElevation());
    }

    private void Y() {
        this.g3.setOnClickListener(new n(this));
        this.f3.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.g3.setVisibility(charSequence.length() > 0 ? 0 : 8);
            }
        });
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void Z() {
        this.i3.setOnTouchListener(new v(this));
    }

    private void a0() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.h3.getLayoutParams();
        ViewCompat.k2(this.h3, new o(marginLayoutParams, marginLayoutParams.leftMargin, marginLayoutParams.rightMargin));
    }

    private void b0(@StyleRes int i2, String str, String str2) {
        if (i2 != -1) {
            TextViewCompat.D(this.f3, i2);
        }
        this.f3.setText(str);
        this.f3.setHint(str2);
    }

    private void c0() {
        f0();
        a0();
        e0();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void d0() {
        this.X2.setOnTouchListener(new u());
    }

    private void e0() {
        setUpStatusBarSpacer(getStatusBarHeight());
        ViewCompat.k2(this.Z2, new r(this));
    }

    private void f0() {
        ViewUtils.h(this.c3, new q(this));
    }

    @Nullable
    private Window getActivityWindow() {
        Activity a2 = ContextUtils.a(getContext());
        if (a2 == null) {
            return null;
        }
        return a2.getWindow();
    }

    private float getOverlayElevation() {
        SearchBar searchBar = this.p3;
        return searchBar != null ? searchBar.getCompatElevation() : getResources().getDimension(R.dimen.p8);
    }

    @Px
    private int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @SuppressLint({"InlinedApi"})
    private void h0(ViewGroup viewGroup, boolean z) {
        int i2;
        for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if (childAt != this) {
                if (childAt.findViewById(this.X2.getId()) != null) {
                    h0((ViewGroup) childAt, z);
                } else {
                    Map<View, Integer> map = this.y3;
                    if (z) {
                        map.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        i2 = 4;
                    } else if (map != null && map.containsKey(childAt)) {
                        i2 = this.y3.get(childAt).intValue();
                    }
                    ViewCompat.Z1(childAt, i2);
                }
            }
        }
    }

    private void i0(@NonNull TransitionState transitionState) {
        if (this.p3 != null && this.m3) {
            if (transitionState.equals(TransitionState.SHOWN)) {
                this.l3.c();
            } else if (transitionState.equals(TransitionState.HIDDEN)) {
                this.l3.f();
            }
        }
    }

    private void j0() {
        MaterialToolbar materialToolbar = this.c3;
        if (materialToolbar != null && !C(materialToolbar)) {
            int defaultNavigationIconResource = getDefaultNavigationIconResource();
            if (this.p3 == null) {
                this.c3.setNavigationIcon(defaultNavigationIconResource);
                return;
            }
            Drawable r = DrawableCompat.r(AppCompatResources.b(getContext(), defaultNavigationIconResource).mutate());
            if (this.c3.getNavigationIconTint() != null) {
                DrawableCompat.n(r, this.c3.getNavigationIconTint().intValue());
            }
            this.c3.setNavigationIcon(new FadeThroughDrawable(this.p3.getNavigationIcon(), r));
            k0();
        }
    }

    private void k0() {
        ImageButton e2 = ToolbarUtils.e(this.c3);
        if (e2 != null) {
            int i2 = this.X2.getVisibility() == 0 ? 1 : 0;
            Drawable q = DrawableCompat.q(e2.getDrawable());
            if (q instanceof DrawerArrowDrawable) {
                ((DrawerArrowDrawable) q).s((float) i2);
            }
            if (q instanceof FadeThroughDrawable) {
                ((FadeThroughDrawable) q).a((float) i2);
            }
        }
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        this.Z2.setVisibility(z ? 0 : 8);
    }

    private void setUpBackgroundViewElevationOverlay(float f2) {
        ElevationOverlayProvider elevationOverlayProvider = this.n3;
        if (elevationOverlayProvider != null && this.Y2 != null) {
            this.Y2.setBackgroundColor(elevationOverlayProvider.e(this.u3, f2));
        }
    }

    private void setUpHeaderLayout(int i2) {
        if (i2 != -1) {
            r(LayoutInflater.from(getContext()).inflate(i2, this.a3, false));
        }
    }

    private void setUpStatusBarSpacer(@Px int i2) {
        if (this.Z2.getLayoutParams().height != i2) {
            this.Z2.getLayoutParams().height = i2;
            this.Z2.requestLayout();
        }
    }

    public boolean B() {
        return this.s3;
    }

    public boolean D() {
        return this.p3 != null;
    }

    public boolean E() {
        return this.x3.equals(TransitionState.SHOWN) || this.x3.equals(TransitionState.SHOWING);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean F() {
        return this.v3;
    }

    public void Q() {
        this.a3.removeAllViews();
        this.a3.setVisibility(8);
    }

    public void R(@NonNull View view) {
        this.a3.removeView(view);
        if (this.a3.getChildCount() == 0) {
            this.a3.setVisibility(8);
        }
    }

    public void S(@NonNull TransitionListener transitionListener) {
        this.o3.remove(transitionListener);
    }

    public void T() {
        this.f3.postDelayed(new p(this), z3);
    }

    /* access modifiers changed from: package-private */
    public void U() {
        if (this.t3) {
            T();
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.j3) {
            this.i3.addView(view, i2, layoutParams);
        } else {
            super.addView(view, i2, layoutParams);
        }
    }

    public void c(@NonNull BackEventCompat backEventCompat) {
        if (!A() && this.p3 != null) {
            this.k3.a0(backEventCompat);
        }
    }

    public void d(@NonNull BackEventCompat backEventCompat) {
        if (!A() && this.p3 != null && Build.VERSION.SDK_INT >= 34) {
            this.k3.f0(backEventCompat);
        }
    }

    public void e() {
        if (!A()) {
            BackEventCompat S = this.k3.S();
            if (Build.VERSION.SDK_INT < 34 || this.p3 == null || S == null) {
                v();
            } else {
                this.k3.p();
            }
        }
    }

    public void g() {
        if (!A() && this.p3 != null && Build.VERSION.SDK_INT >= 34) {
            this.k3.o();
        }
    }

    public void g0() {
        if (!this.x3.equals(TransitionState.SHOWN) && !this.x3.equals(TransitionState.SHOWING)) {
            this.k3.Z();
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.k3.r();
    }

    @NonNull
    public CoordinatorLayout.Behavior<SearchView> getBehavior() {
        return new Behavior();
    }

    @NonNull
    public TransitionState getCurrentTransitionState() {
        return this.x3;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDefaultNavigationIconResource() {
        return R.drawable.Q0;
    }

    @NonNull
    public EditText getEditText() {
        return this.f3;
    }

    @Nullable
    public CharSequence getHint() {
        return this.f3.getHint();
    }

    @NonNull
    public TextView getSearchPrefix() {
        return this.e3;
    }

    @Nullable
    public CharSequence getSearchPrefixText() {
        return this.e3.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.q3;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    @NonNull
    public Editable getText() {
        return this.f3.getText();
    }

    @NonNull
    public Toolbar getToolbar() {
        return this.c3;
    }

    public void l0() {
        Window activityWindow = getActivityWindow();
        if (activityWindow != null) {
            this.q3 = activityWindow.getAttributes().softInputMode;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        l0();
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
        setVisible(savedState.Z == 0);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Editable text = getText();
        savedState.Y = text == null ? null : text.toString();
        savedState.Z = this.X2.getVisibility();
        return savedState;
    }

    public void r(@NonNull View view) {
        this.a3.addView(view);
        this.a3.setVisibility(0);
    }

    public void s(@NonNull TransitionListener transitionListener) {
        this.o3.add(transitionListener);
    }

    public void setAnimatedNavigationIcon(boolean z) {
        this.r3 = z;
    }

    public void setAutoShowKeyboard(boolean z) {
        this.t3 = z;
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        setUpBackgroundViewElevationOverlay(f2);
    }

    public void setHint(@StringRes int i2) {
        this.f3.setHint(i2);
    }

    public void setMenuItemsAnimated(boolean z) {
        this.s3 = z;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        if (z) {
            this.y3 = new HashMap(viewGroup.getChildCount());
        }
        h0(viewGroup, z);
        if (!z) {
            this.y3 = null;
        }
    }

    public void setOnMenuItemClickListener(@Nullable Toolbar.OnMenuItemClickListener onMenuItemClickListener) {
        this.c3.setOnMenuItemClickListener(onMenuItemClickListener);
    }

    public void setSearchPrefixText(@Nullable CharSequence charSequence) {
        this.e3.setText(charSequence);
        this.e3.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStatusBarSpacerEnabled(boolean z) {
        this.w3 = true;
        setStatusBarSpacerEnabledInternal(z);
    }

    public void setText(@StringRes int i2) {
        this.f3.setText(i2);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        this.c3.setTouchscreenBlocksFocus(z);
    }

    /* access modifiers changed from: package-private */
    public void setTransitionState(@NonNull TransitionState transitionState) {
        V(transitionState, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setUseWindowInsetsController(boolean z) {
        this.v3 = z;
    }

    public void setVisible(boolean z) {
        boolean z2 = true;
        boolean z4 = this.X2.getVisibility() == 0;
        this.X2.setVisibility(z ? 0 : 8);
        k0();
        TransitionState transitionState = z ? TransitionState.SHOWN : TransitionState.HIDDEN;
        if (z4 == z) {
            z2 = false;
        }
        V(transitionState, z2);
    }

    public void setupWithSearchBar(@Nullable SearchBar searchBar) {
        this.p3 = searchBar;
        this.k3.X(searchBar);
        if (searchBar != null) {
            searchBar.setOnClickListener(new s(this));
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar.setHandwritingDelegatorCallback(new t(this));
                    this.f3.setIsHandwritingDelegate(true);
                } catch (LinkageError unused) {
                }
            }
        }
        j0();
        X();
        i0(getCurrentTransitionState());
    }

    public void t() {
        this.f3.post(new m(this));
    }

    public void u() {
        this.f3.setText("");
    }

    public void v() {
        if (!this.x3.equals(TransitionState.HIDDEN) && !this.x3.equals(TransitionState.HIDING)) {
            this.k3.M();
        }
    }

    public void w(@MenuRes int i2) {
        this.c3.z(i2);
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return this.q3 == 48;
    }

    public boolean y() {
        return this.r3;
    }

    public boolean z() {
        return this.t3;
    }

    public SearchView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Sc);
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.f3.setHint(charSequence);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(@Nullable CharSequence charSequence) {
        this.f3.setText(charSequence);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SearchView(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.Nullable android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = A3
            android.content.Context r9 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            com.google.android.material.motion.MaterialBackOrchestrator r9 = new com.google.android.material.motion.MaterialBackOrchestrator
            r9.<init>(r8)
            r8.l3 = r9
            java.util.LinkedHashSet r9 = new java.util.LinkedHashSet
            r9.<init>()
            r8.o3 = r9
            r9 = 16
            r8.q3 = r9
            com.google.android.material.search.SearchView$TransitionState r9 = com.google.android.material.search.SearchView.TransitionState.HIDDEN
            r8.x3 = r9
            android.content.Context r9 = r8.getContext()
            int[] r2 = com.google.android.material.R.styleable.Ds
            r6 = 0
            int[] r5 = new int[r6]
            r0 = r9
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R.styleable.Ps
            int r11 = r10.getColor(r11, r6)
            r8.u3 = r11
            int r11 = com.google.android.material.R.styleable.Us
            r0 = -1
            int r11 = r10.getResourceId(r11, r0)
            int r1 = com.google.android.material.R.styleable.Es
            int r0 = r10.getResourceId(r1, r0)
            int r1 = com.google.android.material.R.styleable.Hs
            java.lang.String r1 = r10.getString(r1)
            int r2 = com.google.android.material.R.styleable.Is
            java.lang.String r2 = r10.getString(r2)
            int r3 = com.google.android.material.R.styleable.ct
            java.lang.String r3 = r10.getString(r3)
            int r4 = com.google.android.material.R.styleable.ft
            boolean r4 = r10.getBoolean(r4, r6)
            int r5 = com.google.android.material.R.styleable.Ms
            r7 = 1
            boolean r5 = r10.getBoolean(r5, r7)
            r8.r3 = r5
            int r5 = com.google.android.material.R.styleable.Ls
            boolean r5 = r10.getBoolean(r5, r7)
            r8.s3 = r5
            int r5 = com.google.android.material.R.styleable.Vs
            boolean r5 = r10.getBoolean(r5, r6)
            int r6 = com.google.android.material.R.styleable.Ns
            boolean r6 = r10.getBoolean(r6, r7)
            r8.t3 = r6
            int r6 = com.google.android.material.R.styleable.Os
            boolean r6 = r10.getBoolean(r6, r7)
            r8.m3 = r6
            r10.recycle()
            android.view.LayoutInflater r10 = android.view.LayoutInflater.from(r9)
            int r6 = com.google.android.material.R.layout.S0
            r10.inflate(r6, r8)
            r8.j3 = r7
            int r10 = com.google.android.material.R.id.b4
            android.view.View r10 = r8.findViewById(r10)
            r8.s = r10
            int r10 = com.google.android.material.R.id.a4
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.internal.ClippableRoundedCornerLayout r10 = (com.google.android.material.internal.ClippableRoundedCornerLayout) r10
            r8.X2 = r10
            int r10 = com.google.android.material.R.id.T3
            android.view.View r10 = r8.findViewById(r10)
            r8.Y2 = r10
            int r10 = com.google.android.material.R.id.d4
            android.view.View r10 = r8.findViewById(r10)
            r8.Z2 = r10
            int r10 = com.google.android.material.R.id.Z3
            android.view.View r10 = r8.findViewById(r10)
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            r8.a3 = r10
            int r10 = com.google.android.material.R.id.f4
            android.view.View r10 = r8.findViewById(r10)
            android.widget.FrameLayout r10 = (android.widget.FrameLayout) r10
            r8.b3 = r10
            int r10 = com.google.android.material.R.id.e4
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.appbar.MaterialToolbar r10 = (com.google.android.material.appbar.MaterialToolbar) r10
            r8.c3 = r10
            int r10 = com.google.android.material.R.id.X3
            android.view.View r10 = r8.findViewById(r10)
            androidx.appcompat.widget.Toolbar r10 = (androidx.appcompat.widget.Toolbar) r10
            r8.d3 = r10
            int r10 = com.google.android.material.R.id.c4
            android.view.View r10 = r8.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r8.e3 = r10
            int r10 = com.google.android.material.R.id.Y3
            android.view.View r10 = r8.findViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            r8.f3 = r10
            int r10 = com.google.android.material.R.id.U3
            android.view.View r10 = r8.findViewById(r10)
            android.widget.ImageButton r10 = (android.widget.ImageButton) r10
            r8.g3 = r10
            int r10 = com.google.android.material.R.id.W3
            android.view.View r10 = r8.findViewById(r10)
            r8.h3 = r10
            int r10 = com.google.android.material.R.id.V3
            android.view.View r10 = r8.findViewById(r10)
            com.google.android.material.internal.TouchObserverFrameLayout r10 = (com.google.android.material.internal.TouchObserverFrameLayout) r10
            r8.i3 = r10
            com.google.android.material.search.SearchViewAnimationHelper r10 = new com.google.android.material.search.SearchViewAnimationHelper
            r10.<init>(r8)
            r8.k3 = r10
            com.google.android.material.elevation.ElevationOverlayProvider r10 = new com.google.android.material.elevation.ElevationOverlayProvider
            r10.<init>(r9)
            r8.n3 = r10
            r8.d0()
            r8.X()
            r8.setUpHeaderLayout(r11)
            r8.setSearchPrefixText(r3)
            r8.b0(r0, r1, r2)
            r8.W(r4, r5)
            r8.Y()
            r8.Z()
            r8.c0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.search.SearchView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
