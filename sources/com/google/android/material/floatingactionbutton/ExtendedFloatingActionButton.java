package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int O3 = R.style.ij;
    private static final int P3 = 0;
    private static final int Q3 = 1;
    private static final int R3 = 2;
    private static final int S3 = 0;
    private static final int T3 = 1;
    private static final int U3 = 2;
    private static final int V3 = 3;
    private static final int W3 = 0;
    private static final int X3 = 1;
    private static final int Y3 = 2;
    static final Property<View, Float> Z3;
    static final Property<View, Float> a4;
    static final Property<View, Float> b4;
    static final Property<View, Float> c4;
    @NonNull
    private final MotionStrategy A3;
    private final MotionStrategy B3;
    private final MotionStrategy C3;
    private final int D3;
    /* access modifiers changed from: private */
    public int E3;
    /* access modifiers changed from: private */
    public int F3;
    @NonNull
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> G3;
    /* access modifiers changed from: private */
    public boolean H3;
    /* access modifiers changed from: private */
    public boolean I3;
    private boolean J3;
    @NonNull
    protected ColorStateList K3;
    /* access modifiers changed from: private */
    public int L3;
    /* access modifiers changed from: private */
    public int M3;
    private final int N3;
    /* access modifiers changed from: private */
    public int x3;
    private final AnimatorTracker y3;
    @NonNull
    private final MotionStrategy z3;

    class ChangeSizeStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private final Size f21452g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f21453h;

        ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.f21452g = size;
            this.f21453h = z;
        }

        public void a() {
            super.a();
            boolean unused = ExtendedFloatingActionButton.this.I3 = false;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = this.f21452g.b().width;
                layoutParams.height = this.f21452g.b().height;
            }
        }

        @NonNull
        public AnimatorSet c() {
            MotionSpec d2 = d();
            if (d2.j("width")) {
                PropertyValuesHolder[] g2 = d2.g("width");
                g2[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getWidth(), (float) this.f21452g.getWidth()});
                d2.l("width", g2);
            }
            if (d2.j("height")) {
                PropertyValuesHolder[] g3 = d2.g("height");
                g3[0].setFloatValues(new float[]{(float) ExtendedFloatingActionButton.this.getHeight(), (float) this.f21452g.getHeight()});
                d2.l("height", g3);
            }
            if (d2.j("paddingStart")) {
                PropertyValuesHolder[] g4 = d2.g("paddingStart");
                g4[0].setFloatValues(new float[]{(float) ViewCompat.n0(ExtendedFloatingActionButton.this), (float) this.f21452g.c()});
                d2.l("paddingStart", g4);
            }
            if (d2.j("paddingEnd")) {
                PropertyValuesHolder[] g5 = d2.g("paddingEnd");
                g5[0].setFloatValues(new float[]{(float) ViewCompat.m0(ExtendedFloatingActionButton.this), (float) this.f21452g.a()});
                d2.l("paddingEnd", g5);
            }
            if (d2.j("labelOpacity")) {
                PropertyValuesHolder[] g6 = d2.g("labelOpacity");
                boolean z = this.f21453h;
                float f2 = 1.0f;
                float f3 = z ? 0.0f : 1.0f;
                if (!z) {
                    f2 = 0.0f;
                }
                g6[0].setFloatValues(new float[]{f3, f2});
                d2.l("labelOpacity", g6);
            }
            return super.o(d2);
        }

        public int e() {
            return this.f21453h ? R.animator.A : R.animator.z;
        }

        public void f() {
            boolean unused = ExtendedFloatingActionButton.this.H3 = this.f21453h;
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams != null) {
                if (!this.f21453h) {
                    int unused2 = ExtendedFloatingActionButton.this.L3 = layoutParams.width;
                    int unused3 = ExtendedFloatingActionButton.this.M3 = layoutParams.height;
                }
                layoutParams.width = this.f21452g.b().width;
                layoutParams.height = this.f21452g.b().height;
                ViewCompat.n2(ExtendedFloatingActionButton.this, this.f21452g.c(), ExtendedFloatingActionButton.this.getPaddingTop(), this.f21452g.a(), ExtendedFloatingActionButton.this.getPaddingBottom());
                ExtendedFloatingActionButton.this.requestLayout();
            }
        }

        public boolean h() {
            return this.f21453h == ExtendedFloatingActionButton.this.H3 || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }

        public void m(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                if (this.f21453h) {
                    onChangedCallback.a(ExtendedFloatingActionButton.this);
                } else {
                    onChangedCallback.d(ExtendedFloatingActionButton.this);
                }
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            boolean unused = ExtendedFloatingActionButton.this.H3 = this.f21453h;
            boolean unused2 = ExtendedFloatingActionButton.this.I3 = true;
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
        }
    }

    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean Y2 = false;
        private static final boolean Z2 = true;
        @Nullable
        private OnChangedCallback X;
        private boolean X2;
        @Nullable
        private OnChangedCallback Y;
        private boolean Z;
        private Rect s;

        public ExtendedFloatingActionButtonBehavior() {
            this.Z = false;
            this.X2 = true;
        }

        private static boolean R(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean Y(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.Z || this.X2) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean a0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!Y(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.s == null) {
                this.s = new Rect();
            }
            Rect rect = this.s;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                Z(extendedFloatingActionButton);
                return true;
            }
            N(extendedFloatingActionButton);
            return true;
        }

        private boolean b0(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!Y(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                Z(extendedFloatingActionButton);
                return true;
            }
            N(extendedFloatingActionButton);
            return true;
        }

        /* access modifiers changed from: protected */
        public void N(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.X2;
            extendedFloatingActionButton.N(z ? 3 : 0, z ? this.Y : this.X);
        }

        /* renamed from: O */
        public boolean i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
            return super.i(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        public boolean P() {
            return this.Z;
        }

        public boolean Q() {
            return this.X2;
        }

        /* renamed from: S */
        public boolean p(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a0(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!R(view)) {
                return false;
            } else {
                b0(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* renamed from: T */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i2) {
            List<View> w = coordinatorLayout.w(extendedFloatingActionButton);
            int size = w.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = w.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (R(view) && b0(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (a0(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.N(extendedFloatingActionButton, i2);
            return true;
        }

        public void U(boolean z) {
            this.Z = z;
        }

        public void V(boolean z) {
            this.X2 = z;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void W(@Nullable OnChangedCallback onChangedCallback) {
            this.X = onChangedCallback;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void X(@Nullable OnChangedCallback onChangedCallback) {
            this.Y = onChangedCallback;
        }

        /* access modifiers changed from: protected */
        public void Z(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z = this.X2;
            extendedFloatingActionButton.N(z ? 2 : 1, z ? this.Y : this.X);
        }

        public void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f5084h == 0) {
                layoutParams.f5084h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ig);
            this.Z = obtainStyledAttributes.getBoolean(R.styleable.jg, false);
            this.X2 = obtainStyledAttributes.getBoolean(R.styleable.kg, true);
            obtainStyledAttributes.recycle();
        }
    }

    class HideStrategy extends BaseMotionStrategy {

        /* renamed from: g  reason: collision with root package name */
        private boolean f21455g;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        public void a() {
            super.a();
            int unused = ExtendedFloatingActionButton.this.x3 = 0;
            if (!this.f21455g) {
                ExtendedFloatingActionButton.this.setVisibility(8);
            }
        }

        public void b() {
            super.b();
            this.f21455g = true;
        }

        public int e() {
            return R.animator.B;
        }

        public void f() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        public boolean h() {
            return ExtendedFloatingActionButton.this.L();
        }

        public void m(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.b(ExtendedFloatingActionButton.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.f21455g = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.x3 = 1;
        }
    }

    public static abstract class OnChangedCallback {
        public void a(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void b(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void c(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void d(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        public void a() {
            super.a();
            int unused = ExtendedFloatingActionButton.this.x3 = 0;
        }

        public int e() {
            return R.animator.C;
        }

        public void f() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        public boolean h() {
            return ExtendedFloatingActionButton.this.M();
        }

        public void m(@Nullable OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.c(ExtendedFloatingActionButton.this);
            }
        }

        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            int unused = ExtendedFloatingActionButton.this.x3 = 2;
        }
    }

    interface Size {
        int a();

        ViewGroup.LayoutParams b();

        int c();

        int getHeight();

        int getWidth();
    }

    static {
        Class<Float> cls = Float.class;
        Z3 = new Property<View, Float>(cls, "width") {
            @NonNull
            /* renamed from: a */
            public Float get(@NonNull View view) {
                return Float.valueOf((float) view.getLayoutParams().width);
            }

            /* renamed from: b */
            public void set(@NonNull View view, @NonNull Float f2) {
                view.getLayoutParams().width = f2.intValue();
                view.requestLayout();
            }
        };
        a4 = new Property<View, Float>(cls, "height") {
            @NonNull
            /* renamed from: a */
            public Float get(@NonNull View view) {
                return Float.valueOf((float) view.getLayoutParams().height);
            }

            /* renamed from: b */
            public void set(@NonNull View view, @NonNull Float f2) {
                view.getLayoutParams().height = f2.intValue();
                view.requestLayout();
            }
        };
        b4 = new Property<View, Float>(cls, "paddingStart") {
            @NonNull
            /* renamed from: a */
            public Float get(@NonNull View view) {
                return Float.valueOf((float) ViewCompat.n0(view));
            }

            /* renamed from: b */
            public void set(@NonNull View view, @NonNull Float f2) {
                ViewCompat.n2(view, f2.intValue(), view.getPaddingTop(), ViewCompat.m0(view), view.getPaddingBottom());
            }
        };
        c4 = new Property<View, Float>(cls, "paddingEnd") {
            @NonNull
            /* renamed from: a */
            public Float get(@NonNull View view) {
                return Float.valueOf((float) ViewCompat.m0(view));
            }

            /* renamed from: b */
            public void set(@NonNull View view, @NonNull Float f2) {
                ViewCompat.n2(view, ViewCompat.n0(view), view.getPaddingTop(), f2.intValue(), view.getPaddingBottom());
            }
        };
    }

    public ExtendedFloatingActionButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private Size H(int i2) {
        final AnonymousClass2 r0 = new Size() {
            public int a() {
                return ExtendedFloatingActionButton.this.F3;
            }

            public ViewGroup.LayoutParams b() {
                return new ViewGroup.LayoutParams(-2, -2);
            }

            public int c() {
                return ExtendedFloatingActionButton.this.E3;
            }

            public int getHeight() {
                return ExtendedFloatingActionButton.this.getMeasuredHeight();
            }

            public int getWidth() {
                return (ExtendedFloatingActionButton.this.getMeasuredWidth() - (ExtendedFloatingActionButton.this.getCollapsedPadding() * 2)) + ExtendedFloatingActionButton.this.E3 + ExtendedFloatingActionButton.this.F3;
            }
        };
        final AnonymousClass3 r1 = new Size() {
            public int a() {
                return ExtendedFloatingActionButton.this.F3;
            }

            public ViewGroup.LayoutParams b() {
                return new ViewGroup.LayoutParams(-1, ExtendedFloatingActionButton.this.M3 == 0 ? -2 : ExtendedFloatingActionButton.this.M3);
            }

            public int c() {
                return ExtendedFloatingActionButton.this.E3;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
                r2 = (android.view.ViewGroup.MarginLayoutParams) r4.f21448b.getLayoutParams();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int getHeight() {
                /*
                    r4 = this;
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    int r0 = r0.M3
                    r1 = -1
                    r2 = -2
                    if (r0 != r1) goto L_0x005f
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewParent r0 = r0.getParent()
                    boolean r0 = r0 instanceof android.view.View
                    if (r0 != 0) goto L_0x001b
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r0 = r0
                    int r0 = r0.getHeight()
                    return r0
                L_0x001b:
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewParent r0 = r0.getParent()
                    android.view.View r0 = (android.view.View) r0
                    android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                    if (r1 == 0) goto L_0x0034
                    int r1 = r1.height
                    if (r1 != r2) goto L_0x0034
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r0 = r0
                    int r0 = r0.getHeight()
                    return r0
                L_0x0034:
                    int r1 = r0.getPaddingTop()
                    int r2 = r0.getPaddingBottom()
                    int r1 = r1 + r2
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r2 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                    boolean r2 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                    if (r2 == 0) goto L_0x0057
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r2 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                    android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                    if (r2 == 0) goto L_0x0057
                    int r3 = r2.topMargin
                    int r2 = r2.bottomMargin
                    int r3 = r3 + r2
                    goto L_0x0058
                L_0x0057:
                    r3 = 0
                L_0x0058:
                    int r0 = r0.getHeight()
                    int r0 = r0 - r3
                    int r0 = r0 - r1
                    return r0
                L_0x005f:
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    int r0 = r0.M3
                    if (r0 == 0) goto L_0x0077
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    int r0 = r0.M3
                    if (r0 != r2) goto L_0x0070
                    goto L_0x0077
                L_0x0070:
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    int r0 = r0.M3
                    return r0
                L_0x0077:
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r0 = r0
                    int r0 = r0.getHeight()
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass3.getHeight():int");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
                r2 = (android.view.ViewGroup.MarginLayoutParams) r4.f21448b.getLayoutParams();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int getWidth() {
                /*
                    r4 = this;
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewParent r0 = r0.getParent()
                    boolean r0 = r0 instanceof android.view.View
                    if (r0 != 0) goto L_0x0011
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r0 = r0
                    int r0 = r0.getWidth()
                    return r0
                L_0x0011:
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r0 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewParent r0 = r0.getParent()
                    android.view.View r0 = (android.view.View) r0
                    android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                    if (r1 == 0) goto L_0x002b
                    int r1 = r1.width
                    r2 = -2
                    if (r1 != r2) goto L_0x002b
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r0 = r0
                    int r0 = r0.getWidth()
                    return r0
                L_0x002b:
                    int r1 = r0.getPaddingLeft()
                    int r2 = r0.getPaddingRight()
                    int r1 = r1 + r2
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r2 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                    boolean r2 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
                    if (r2 == 0) goto L_0x004e
                    com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r2 = com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.this
                    android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
                    android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
                    if (r2 == 0) goto L_0x004e
                    int r3 = r2.leftMargin
                    int r2 = r2.rightMargin
                    int r3 = r3 + r2
                    goto L_0x004f
                L_0x004e:
                    r3 = 0
                L_0x004f:
                    int r0 = r0.getWidth()
                    int r0 = r0 - r3
                    int r0 = r0 - r1
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.AnonymousClass3.getWidth():int");
            }
        };
        AnonymousClass4 r2 = new Size() {
            public int a() {
                return ExtendedFloatingActionButton.this.F3;
            }

            public ViewGroup.LayoutParams b() {
                int i2 = -2;
                int s = ExtendedFloatingActionButton.this.L3 == 0 ? -2 : ExtendedFloatingActionButton.this.L3;
                if (ExtendedFloatingActionButton.this.M3 != 0) {
                    i2 = ExtendedFloatingActionButton.this.M3;
                }
                return new ViewGroup.LayoutParams(s, i2);
            }

            public int c() {
                return ExtendedFloatingActionButton.this.E3;
            }

            public int getHeight() {
                return ExtendedFloatingActionButton.this.M3 == -1 ? r1.getHeight() : (ExtendedFloatingActionButton.this.M3 == 0 || ExtendedFloatingActionButton.this.M3 == -2) ? r0.getHeight() : ExtendedFloatingActionButton.this.M3;
            }

            public int getWidth() {
                return ExtendedFloatingActionButton.this.L3 == -1 ? r1.getWidth() : (ExtendedFloatingActionButton.this.L3 == 0 || ExtendedFloatingActionButton.this.L3 == -2) ? r0.getWidth() : ExtendedFloatingActionButton.this.L3;
            }
        };
        if (i2 != 1) {
            return i2 != 2 ? r2 : r1;
        }
        return r0;
    }

    /* access modifiers changed from: private */
    public boolean L() {
        return getVisibility() == 0 ? this.x3 == 1 : this.x3 != 2;
    }

    /* access modifiers changed from: private */
    public boolean M() {
        return getVisibility() != 0 ? this.x3 == 2 : this.x3 != 1;
    }

    /* access modifiers changed from: private */
    public void N(int i2, @Nullable final OnChangedCallback onChangedCallback) {
        final MotionStrategy motionStrategy;
        int height;
        if (i2 == 0) {
            motionStrategy = this.B3;
        } else if (i2 == 1) {
            motionStrategy = this.C3;
        } else if (i2 == 2) {
            motionStrategy = this.z3;
        } else if (i2 == 3) {
            motionStrategy = this.A3;
        } else {
            throw new IllegalStateException("Unknown strategy type: " + i2);
        }
        if (!motionStrategy.h()) {
            if (!T()) {
                motionStrategy.f();
                motionStrategy.m(onChangedCallback);
                return;
            }
            if (i2 == 2) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    this.L3 = layoutParams.width;
                    height = layoutParams.height;
                } else {
                    this.L3 = getWidth();
                    height = getHeight();
                }
                this.M3 = height;
            }
            measure(0, 0);
            AnimatorSet c2 = motionStrategy.c();
            c2.addListener(new AnimatorListenerAdapter() {
                private boolean s;

                public void onAnimationCancel(Animator animator) {
                    this.s = true;
                    motionStrategy.b();
                }

                public void onAnimationEnd(Animator animator) {
                    motionStrategy.a();
                    if (!this.s) {
                        motionStrategy.m(onChangedCallback);
                    }
                }

                public void onAnimationStart(Animator animator) {
                    motionStrategy.onAnimationStart(animator);
                    this.s = false;
                }
            });
            for (Animator.AnimatorListener addListener : motionStrategy.l()) {
                c2.addListener(addListener);
            }
            c2.start();
        }
    }

    private void S() {
        this.K3 = getTextColors();
    }

    private boolean T() {
        return (ViewCompat.Y0(this) || (!M() && this.J3)) && !isInEditMode();
    }

    public void B(@NonNull Animator.AnimatorListener animatorListener) {
        this.A3.j(animatorListener);
    }

    public void C(@NonNull Animator.AnimatorListener animatorListener) {
        this.C3.j(animatorListener);
    }

    public void D(@NonNull Animator.AnimatorListener animatorListener) {
        this.B3.j(animatorListener);
    }

    public void E(@NonNull Animator.AnimatorListener animatorListener) {
        this.z3.j(animatorListener);
    }

    public void F() {
        N(3, (OnChangedCallback) null);
    }

    public void G(@NonNull OnChangedCallback onChangedCallback) {
        N(3, onChangedCallback);
    }

    public void I() {
        N(1, (OnChangedCallback) null);
    }

    public void J(@NonNull OnChangedCallback onChangedCallback) {
        N(1, onChangedCallback);
    }

    public final boolean K() {
        return this.H3;
    }

    public void O(@NonNull Animator.AnimatorListener animatorListener) {
        this.A3.i(animatorListener);
    }

    public void P(@NonNull Animator.AnimatorListener animatorListener) {
        this.C3.i(animatorListener);
    }

    public void Q(@NonNull Animator.AnimatorListener animatorListener) {
        this.B3.i(animatorListener);
    }

    public void R(@NonNull Animator.AnimatorListener animatorListener) {
        this.z3.i(animatorListener);
    }

    public void U() {
        N(0, (OnChangedCallback) null);
    }

    public void V(@NonNull OnChangedCallback onChangedCallback) {
        N(0, onChangedCallback);
    }

    public void W() {
        N(2, (OnChangedCallback) null);
    }

    public void X(@NonNull OnChangedCallback onChangedCallback) {
        N(2, onChangedCallback);
    }

    /* access modifiers changed from: protected */
    public void Y(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @NonNull
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.G3;
    }

    /* access modifiers changed from: package-private */
    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public int getCollapsedSize() {
        int i2 = this.D3;
        return i2 < 0 ? (Math.min(ViewCompat.n0(this), ViewCompat.m0(this)) * 2) + getIconSize() : i2;
    }

    @Nullable
    public MotionSpec getExtendMotionSpec() {
        return this.A3.g();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return this.C3.g();
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return this.B3.g();
    }

    @Nullable
    public MotionSpec getShrinkMotionSpec() {
        return this.z3.g();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.H3 && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.H3 = false;
            this.z3.f();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.J3 = z;
    }

    public void setExtendMotionSpec(@Nullable MotionSpec motionSpec) {
        this.A3.k(motionSpec);
    }

    public void setExtendMotionSpecResource(@AnimatorRes int i2) {
        setExtendMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setExtended(boolean z) {
        if (this.H3 != z) {
            MotionStrategy motionStrategy = z ? this.A3 : this.z3;
            if (!motionStrategy.h()) {
                motionStrategy.f();
            }
        }
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.C3.k(motionSpec);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
        if (this.H3 && !this.I3) {
            this.E3 = ViewCompat.n0(this);
            this.F3 = ViewCompat.m0(this);
        }
    }

    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
        super.setPaddingRelative(i2, i3, i4, i5);
        if (this.H3 && !this.I3) {
            this.E3 = i2;
            this.F3 = i4;
        }
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.B3.k(motionSpec);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setShrinkMotionSpec(@Nullable MotionSpec motionSpec) {
        this.z3.k(motionSpec);
    }

    public void setShrinkMotionSpecResource(@AnimatorRes int i2) {
        setShrinkMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setTextColor(int i2) {
        super.setTextColor(i2);
        S();
    }

    public ExtendedFloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.l7);
    }

    public void setTextColor(@NonNull ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        S();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExtendedFloatingActionButton(@androidx.annotation.NonNull android.content.Context r17, @androidx.annotation.Nullable android.util.AttributeSet r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r7 = r18
            r8 = r19
            int r9 = O3
            r1 = r17
            android.content.Context r1 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = 0
            r0.x3 = r10
            com.google.android.material.floatingactionbutton.AnimatorTracker r1 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r1.<init>()
            r0.y3 = r1
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy r11 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ShowStrategy
            r11.<init>(r1)
            r0.B3 = r11
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy r12 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$HideStrategy
            r12.<init>(r1)
            r0.C3 = r12
            r13 = 1
            r0.H3 = r13
            r0.I3 = r10
            r0.J3 = r10
            android.content.Context r14 = r16.getContext()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior r1 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior
            r1.<init>(r14, r7)
            r0.G3 = r1
            int[] r3 = com.google.android.material.R.styleable.ag
            int[] r6 = new int[r10]
            r1 = r14
            r2 = r18
            r4 = r19
            r5 = r9
            android.content.res.TypedArray r1 = com.google.android.material.internal.ThemeEnforcement.k(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.gg
            com.google.android.material.animation.MotionSpec r2 = com.google.android.material.animation.MotionSpec.c(r14, r1, r2)
            int r3 = com.google.android.material.R.styleable.fg
            com.google.android.material.animation.MotionSpec r3 = com.google.android.material.animation.MotionSpec.c(r14, r1, r3)
            int r4 = com.google.android.material.R.styleable.dg
            com.google.android.material.animation.MotionSpec r4 = com.google.android.material.animation.MotionSpec.c(r14, r1, r4)
            int r5 = com.google.android.material.R.styleable.hg
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.c(r14, r1, r5)
            int r6 = com.google.android.material.R.styleable.bg
            r15 = -1
            int r6 = r1.getDimensionPixelSize(r6, r15)
            r0.D3 = r6
            int r6 = com.google.android.material.R.styleable.eg
            int r6 = r1.getInt(r6, r13)
            r0.N3 = r6
            int r15 = androidx.core.view.ViewCompat.n0(r16)
            r0.E3 = r15
            int r15 = androidx.core.view.ViewCompat.m0(r16)
            r0.F3 = r15
            com.google.android.material.floatingactionbutton.AnimatorTracker r15 = new com.google.android.material.floatingactionbutton.AnimatorTracker
            r15.<init>()
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r10 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$Size r6 = r0.H(r6)
            r10.<init>(r15, r6, r13)
            r0.A3 = r10
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy r6 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$ChangeSizeStrategy
            com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1 r13 = new com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1
            r13.<init>()
            r7 = 0
            r6.<init>(r15, r13, r7)
            r0.z3 = r6
            r11.k(r2)
            r12.k(r3)
            r10.k(r4)
            r6.k(r5)
            r1.recycle()
            com.google.android.material.shape.CornerSize r1 = com.google.android.material.shape.ShapeAppearanceModel.f21822m
            r2 = r18
            com.google.android.material.shape.ShapeAppearanceModel$Builder r1 = com.google.android.material.shape.ShapeAppearanceModel.g(r14, r2, r8, r9, r1)
            com.google.android.material.shape.ShapeAppearanceModel r1 = r1.m()
            r0.setShapeAppearanceModel(r1)
            r16.S()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
