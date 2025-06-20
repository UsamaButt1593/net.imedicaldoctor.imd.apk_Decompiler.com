package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int A4 = 0;
    public static final int B4 = 1;
    public static final int C4 = 0;
    public static final int D4 = 1;
    private static final int E4 = -1;
    private static final int F4 = 0;
    private static final int r4 = R.style.yi;
    private static final int s4 = 300;
    private static final int t4 = R.attr.Fd;
    private static final int u4 = R.attr.Vd;
    private static final float v4 = 0.2f;
    public static final int w4 = 0;
    public static final int x4 = 1;
    public static final int y4 = 0;
    public static final int z4 = 1;
    @Nullable
    private Integer R3;
    /* access modifiers changed from: private */
    public final MaterialShapeDrawable S3;
    /* access modifiers changed from: private */
    @Nullable
    public Animator T3;
    /* access modifiers changed from: private */
    @Nullable
    public Animator U3;
    /* access modifiers changed from: private */
    public int V3;
    private int W3;
    /* access modifiers changed from: private */
    public int X3;
    /* access modifiers changed from: private */
    public final int Y3;
    @Px
    private int Z3;
    private int a4;
    /* access modifiers changed from: private */
    public final boolean b4;
    private boolean c4;
    /* access modifiers changed from: private */
    public final boolean d4;
    /* access modifiers changed from: private */
    public final boolean e4;
    /* access modifiers changed from: private */
    public final boolean f4;
    private int g4;
    private ArrayList<AnimationListener> h4;
    /* access modifiers changed from: private */
    @MenuRes
    public int i4;
    /* access modifiers changed from: private */
    public boolean j4;
    /* access modifiers changed from: private */
    public boolean k4;
    private Behavior l4;
    /* access modifiers changed from: private */
    public int m4;
    /* access modifiers changed from: private */
    public int n4;
    /* access modifiers changed from: private */
    public int o4;
    @NonNull
    AnimatorListenerAdapter p4;
    @NonNull
    TransformationCallback<FloatingActionButton> q4;

    interface AnimationListener {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        /* access modifiers changed from: private */
        @NonNull
        public final Rect j3 = new Rect();
        /* access modifiers changed from: private */
        public WeakReference<BottomAppBar> k3;
        /* access modifiers changed from: private */
        public int l3;
        private final View.OnLayoutChangeListener m3 = new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.k3.get();
                if (bottomAppBar == null || (!(view instanceof FloatingActionButton) && !(view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.l(Behavior.this.j3);
                    int height2 = Behavior.this.j3.height();
                    bottomAppBar.q1(height2);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.j3)));
                    height = height2;
                }
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.this.l3 == 0) {
                    if (bottomAppBar.X3 == 1) {
                        layoutParams.bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.ya) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    layoutParams.leftMargin = bottomAppBar.getLeftInset();
                    layoutParams.rightMargin = bottomAppBar.getRightInset();
                    if (ViewUtils.s(view)) {
                        layoutParams.leftMargin += bottomAppBar.Y3;
                    } else {
                        layoutParams.rightMargin += bottomAppBar.Y3;
                    }
                }
                bottomAppBar.o1();
            }
        };

        public Behavior() {
        }

        /* renamed from: d0 */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            this.k3 = new WeakReference<>(bottomAppBar);
            View B0 = bottomAppBar.W0();
            if (B0 != null && !ViewCompat.Y0(B0)) {
                BottomAppBar.t1(bottomAppBar, B0);
                this.l3 = ((CoordinatorLayout.LayoutParams) B0.getLayoutParams()).bottomMargin;
                if (B0 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) B0;
                    if (bottomAppBar.X3 == 0 && bottomAppBar.b4) {
                        ViewCompat.V1(floatingActionButton, 0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.F);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.E);
                    }
                    bottomAppBar.M0(floatingActionButton);
                }
                B0.addOnLayoutChangeListener(this.m3);
                bottomAppBar.o1();
            }
            coordinatorLayout.N(bottomAppBar, i2);
            return super.t(coordinatorLayout, bottomAppBar, i2);
        }

        /* renamed from: e0 */
        public boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.I(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAlignmentMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FabAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuAlignmentMode {
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
        int Y;
        boolean Z;

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.Y = parcel.readInt();
            this.Z = parcel.readInt() != 0;
        }

        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.Y);
            parcel.writeInt(this.Z ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public void M0(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.f(this.p4);
        floatingActionButton.g(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.p4.onAnimationStart(animator);
                FloatingActionButton u0 = BottomAppBar.this.V0();
                if (u0 != null) {
                    u0.setTranslationX(BottomAppBar.this.getFabTranslationX());
                }
            }
        });
        floatingActionButton.h(this.q4);
    }

    /* access modifiers changed from: private */
    public void O0() {
        Animator animator = this.U3;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.T3;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void R0(int i2, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(V0(), "translationX", new float[]{Y0(i2)});
        ofFloat.setDuration((long) getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void S0(final int i2, final boolean z, @NonNull List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            float fabAlignmentAnimationDuration = (float) getFabAlignmentAnimationDuration();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{1.0f});
            ofFloat.setDuration((long) (0.8f * fabAlignmentAnimationDuration));
            if (Math.abs(actionMenuView.getTranslationX() - ((float) X0(actionMenuView, i2, z))) > 1.0f) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", new float[]{0.0f});
                ofFloat2.setDuration((long) (fabAlignmentAnimationDuration * 0.2f));
                ofFloat2.addListener(new AnimatorListenerAdapter() {
                    public boolean s;

                    public void onAnimationCancel(Animator animator) {
                        this.s = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        if (!this.s) {
                            boolean z = BottomAppBar.this.i4 != 0;
                            BottomAppBar bottomAppBar = BottomAppBar.this;
                            bottomAppBar.m1(bottomAppBar.i4);
                            BottomAppBar.this.s1(actionMenuView, i2, z, z);
                        }
                    }
                });
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(new Animator[]{ofFloat2, ofFloat});
                list.add(animatorSet);
            } else if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        }
    }

    /* access modifiers changed from: private */
    public void T0() {
        ArrayList<AnimationListener> arrayList;
        int i2 = this.g4 - 1;
        this.g4 = i2;
        if (i2 == 0 && (arrayList = this.h4) != null) {
            Iterator<AnimationListener> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().b(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public void U0() {
        ArrayList<AnimationListener> arrayList;
        int i2 = this.g4;
        this.g4 = i2 + 1;
        if (i2 == 0 && (arrayList = this.h4) != null) {
            Iterator<AnimationListener> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a(this);
            }
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public FloatingActionButton V0() {
        View W0 = W0();
        if (W0 instanceof FloatingActionButton) {
            return (FloatingActionButton) W0;
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View W0() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.x(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0018:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L_0x002c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L_0x0018
        L_0x002c:
            return r2
        L_0x002d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.W0():android.view.View");
    }

    /* access modifiers changed from: private */
    public float Y0(int i2) {
        boolean s = ViewUtils.s(this);
        int i3 = 1;
        if (i2 != 1) {
            return 0.0f;
        }
        View W0 = W0();
        int measuredWidth = (getMeasuredWidth() / 2) - ((s ? this.o4 : this.n4) + ((this.Z3 == -1 || W0 == null) ? this.Y3 : (W0.getMeasuredWidth() / 2) + this.Z3));
        if (s) {
            i3 = -1;
        }
        return (float) (measuredWidth * i3);
    }

    private boolean Z0() {
        FloatingActionButton V0 = V0();
        return V0 != null && V0.s();
    }

    /* access modifiers changed from: private */
    public void d1(int i2, boolean z) {
        if (!ViewCompat.Y0(this)) {
            this.j4 = false;
            m1(this.i4);
            return;
        }
        Animator animator = this.U3;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!Z0()) {
            i2 = 0;
            z = false;
        }
        S0(i2, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.U3 = animatorSet;
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.T0();
                boolean unused = BottomAppBar.this.j4 = false;
                Animator unused2 = BottomAppBar.this.U3 = null;
            }

            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.U0();
            }
        });
        this.U3.start();
    }

    private void e1(int i2) {
        if (this.V3 != i2 && ViewCompat.Y0(this)) {
            Animator animator = this.T3;
            if (animator != null) {
                animator.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (this.W3 == 1) {
                R0(i2, arrayList);
            } else {
                Q0(i2, arrayList);
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            animatorSet.setInterpolator(MotionUtils.g(getContext(), u4, AnimationUtils.f20766a));
            this.T3 = animatorSet;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.T0();
                    Animator unused = BottomAppBar.this.T3 = null;
                }

                public void onAnimationStart(Animator animator) {
                    BottomAppBar.this.U0();
                }
            });
            this.T3.start();
        }
    }

    @Nullable
    private Drawable f1(@Nullable Drawable drawable) {
        if (drawable == null || this.R3 == null) {
            return drawable;
        }
        Drawable r = DrawableCompat.r(drawable.mutate());
        DrawableCompat.n(r, this.R3.intValue());
        return r;
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public int getBottomInset() {
        return this.m4;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.f(getContext(), t4, 300);
    }

    /* access modifiers changed from: private */
    public float getFabTranslationX() {
        return Y0(this.V3);
    }

    private float getFabTranslationY() {
        if (this.X3 == 1) {
            return -getTopEdgeTreatment().d();
        }
        View W0 = W0();
        return (float) (W0 != null ? (-((getMeasuredHeight() + getBottomInset()) - W0.getMeasuredHeight())) / 2 : 0);
    }

    /* access modifiers changed from: private */
    public int getLeftInset() {
        return this.o4;
    }

    /* access modifiers changed from: private */
    public int getRightInset() {
        return this.n4;
    }

    /* access modifiers changed from: private */
    @NonNull
    public BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.S3.getShapeAppearanceModel().p();
    }

    /* access modifiers changed from: private */
    public void n1() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null && this.U3 == null) {
            actionMenuView.setAlpha(1.0f);
            if (!Z0()) {
                r1(actionMenuView, 0, false);
            } else {
                r1(actionMenuView, this.V3, this.k4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void o1() {
        getTopEdgeTreatment().q(getFabTranslationX());
        this.S3.q0((!this.k4 || !Z0() || this.X3 != 1) ? 0.0f : 1.0f);
        View W0 = W0();
        if (W0 != null) {
            W0.setTranslationY(getFabTranslationY());
            W0.setTranslationX(getFabTranslationX());
        }
    }

    private void r1(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        s1(actionMenuView, i2, z, false);
    }

    /* access modifiers changed from: private */
    public void s1(@NonNull final ActionMenuView actionMenuView, final int i2, final boolean z, boolean z2) {
        AnonymousClass8 r0 = new Runnable() {
            public void run() {
                ActionMenuView actionMenuView = actionMenuView;
                actionMenuView.setTranslationX((float) BottomAppBar.this.X0(actionMenuView, i2, z));
            }
        };
        if (z2) {
            actionMenuView.post(r0);
        } else {
            r0.run();
        }
    }

    /* access modifiers changed from: private */
    public static void t1(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.f5080d = 17;
        int i2 = bottomAppBar.X3;
        if (i2 == 1) {
            layoutParams.f5080d = 17 | 48;
        }
        if (i2 == 0) {
            layoutParams.f5080d |= 80;
        }
    }

    /* access modifiers changed from: package-private */
    public void L0(@NonNull AnimationListener animationListener) {
        if (this.h4 == null) {
            this.h4 = new ArrayList<>();
        }
        this.h4.add(animationListener);
    }

    public void N0(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().O(onScrollStateChangedListener);
    }

    public void P0() {
        getBehavior().Q();
    }

    /* access modifiers changed from: protected */
    public void Q0(final int i2, List<Animator> list) {
        FloatingActionButton V0 = V0();
        if (V0 != null && !V0.r()) {
            U0();
            V0.p(new FloatingActionButton.OnVisibilityChangedListener() {
                public void a(@NonNull FloatingActionButton floatingActionButton) {
                    floatingActionButton.setTranslationX(BottomAppBar.this.Y0(i2));
                    floatingActionButton.A(new FloatingActionButton.OnVisibilityChangedListener() {
                        public void b(FloatingActionButton floatingActionButton) {
                            BottomAppBar.this.T0();
                        }
                    });
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int X0(@NonNull ActionMenuView actionMenuView, int i2, boolean z) {
        int i3 = 0;
        if (this.a4 != 1 && (i2 != 1 || !z)) {
            return 0;
        }
        boolean s = ViewUtils.s(this);
        int measuredWidth = s ? getMeasuredWidth() : 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f2698a & GravityCompat.f6389d) == 8388611) {
                measuredWidth = s ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = s ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i6 = s ? this.n4 : -this.o4;
        if (getNavigationIcon() == null) {
            i3 = getResources().getDimensionPixelOffset(R.dimen.U2);
            if (!s) {
                i3 = -i3;
            }
        }
        return measuredWidth - ((right + i6) + i3);
    }

    public boolean a1() {
        return getBehavior().R();
    }

    public boolean b1() {
        return getBehavior().S();
    }

    public void g1() {
        h1(true);
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.S3.S();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().d();
    }

    public int getFabAlignmentMode() {
        return this.V3;
    }

    @Px
    public int getFabAlignmentModeEndMargin() {
        return this.Z3;
    }

    public int getFabAnchorMode() {
        return this.X3;
    }

    public int getFabAnimationMode() {
        return this.W3;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().f();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().g();
    }

    public boolean getHideOnScroll() {
        return this.c4;
    }

    public int getMenuAlignmentMode() {
        return this.a4;
    }

    public void h1(boolean z) {
        getBehavior().W(this, z);
    }

    public void i1() {
        j1(true);
    }

    public void j1(boolean z) {
        getBehavior().Y(this, z);
    }

    /* access modifiers changed from: package-private */
    public void k1(@NonNull AnimationListener animationListener) {
        ArrayList<AnimationListener> arrayList = this.h4;
        if (arrayList != null) {
            arrayList.remove(animationListener);
        }
    }

    public void l1(@NonNull HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().T(onScrollStateChangedListener);
    }

    public void m1(@MenuRes int i2) {
        if (i2 != 0) {
            this.i4 = 0;
            getMenu().clear();
            z(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.f(this, this.S3);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i5, int i6) {
        super.onLayout(z, i2, i3, i5, i6);
        if (z) {
            O0();
            o1();
            View W0 = W0();
            if (W0 != null && ViewCompat.Y0(W0)) {
                W0.post(new c(W0));
            }
        }
        n1();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.V3 = savedState.Y;
        this.k4 = savedState.Z;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Y = this.V3;
        savedState.Z = this.k4;
        return savedState;
    }

    public void p1(int i2, @MenuRes int i3) {
        this.i4 = i3;
        this.j4 = true;
        d1(i2, this.k4);
        e1(i2);
        this.V3 = i2;
    }

    /* access modifiers changed from: package-private */
    public boolean q1(@Px int i2) {
        float f2 = (float) i2;
        if (f2 == getTopEdgeTreatment().h()) {
            return false;
        }
        getTopEdgeTreatment().p(f2);
        this.S3.invalidateSelf();
        return true;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.o(this.S3, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().l(f2);
            this.S3.invalidateSelf();
            o1();
        }
    }

    public void setElevation(float f2) {
        this.S3.o0(f2);
        getBehavior().U(this, this.S3.L() - this.S3.K());
    }

    public void setFabAlignmentMode(int i2) {
        p1(i2, 0);
    }

    public void setFabAlignmentModeEndMargin(@Px int i2) {
        if (this.Z3 != i2) {
            this.Z3 = i2;
            o1();
        }
    }

    public void setFabAnchorMode(int i2) {
        this.X3 = i2;
        o1();
        View W0 = W0();
        if (W0 != null) {
            t1(this, W0);
            W0.requestLayout();
            this.S3.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i2) {
        this.W3 = i2;
    }

    /* access modifiers changed from: package-private */
    public void setFabCornerSize(@Dimension float f2) {
        if (f2 != getTopEdgeTreatment().e()) {
            getTopEdgeTreatment().m(f2);
            this.S3.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().n(f2);
            this.S3.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().o(f2);
            this.S3.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z) {
        this.c4 = z;
    }

    public void setMenuAlignmentMode(int i2) {
        if (this.a4 != i2) {
            this.a4 = i2;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                r1(actionMenuView, this.V3, Z0());
            }
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(f1(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i2) {
        this.R3 = Integer.valueOf(i2);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.i1);
    }

    @NonNull
    public Behavior getBehavior() {
        if (this.l4 == null) {
            this.l4 = new Behavior();
        }
        return this.l4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r13, @androidx.annotation.Nullable android.util.AttributeSet r14, int r15) {
        /*
            r12 = this;
            int r6 = r4
            android.content.Context r13 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r13, r14, r15, r6)
            r12.<init>(r13, r14, r15)
            com.google.android.material.shape.MaterialShapeDrawable r13 = new com.google.android.material.shape.MaterialShapeDrawable
            r13.<init>()
            r12.S3 = r13
            r7 = 0
            r12.g4 = r7
            r12.i4 = r7
            r12.j4 = r7
            r8 = 1
            r12.k4 = r8
            com.google.android.material.bottomappbar.BottomAppBar$1 r0 = new com.google.android.material.bottomappbar.BottomAppBar$1
            r0.<init>()
            r12.p4 = r0
            com.google.android.material.bottomappbar.BottomAppBar$2 r0 = new com.google.android.material.bottomappbar.BottomAppBar$2
            r0.<init>()
            r12.q4 = r0
            android.content.Context r9 = r12.getContext()
            int[] r2 = com.google.android.material.R.styleable.L4
            int[] r5 = new int[r7]
            r0 = r9
            r1 = r14
            r3 = r15
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.N4
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r9, r0, r1)
            int r2 = com.google.android.material.R.styleable.Y4
            boolean r3 = r0.hasValue(r2)
            r4 = -1
            if (r3 == 0) goto L_0x004e
            int r2 = r0.getColor(r2, r4)
            r12.setNavigationIconTint(r2)
        L_0x004e:
            int r2 = com.google.android.material.R.styleable.O4
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.T4
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r5 = com.google.android.material.R.styleable.U4
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r10 = com.google.android.material.R.styleable.V4
            int r10 = r0.getDimensionPixelOffset(r10, r7)
            float r10 = (float) r10
            int r11 = com.google.android.material.R.styleable.P4
            int r11 = r0.getInt(r11, r7)
            r12.V3 = r11
            int r11 = com.google.android.material.R.styleable.S4
            int r11 = r0.getInt(r11, r7)
            r12.W3 = r11
            int r11 = com.google.android.material.R.styleable.R4
            int r11 = r0.getInt(r11, r8)
            r12.X3 = r11
            int r11 = com.google.android.material.R.styleable.c5
            boolean r11 = r0.getBoolean(r11, r8)
            r12.b4 = r11
            int r11 = com.google.android.material.R.styleable.X4
            int r11 = r0.getInt(r11, r7)
            r12.a4 = r11
            int r11 = com.google.android.material.R.styleable.W4
            boolean r11 = r0.getBoolean(r11, r7)
            r12.c4 = r11
            int r11 = com.google.android.material.R.styleable.Z4
            boolean r11 = r0.getBoolean(r11, r7)
            r12.d4 = r11
            int r11 = com.google.android.material.R.styleable.a5
            boolean r11 = r0.getBoolean(r11, r7)
            r12.e4 = r11
            int r11 = com.google.android.material.R.styleable.b5
            boolean r11 = r0.getBoolean(r11, r7)
            r12.f4 = r11
            int r11 = com.google.android.material.R.styleable.Q4
            int r4 = r0.getDimensionPixelOffset(r11, r4)
            r12.Z3 = r4
            int r4 = com.google.android.material.R.styleable.M4
            boolean r4 = r0.getBoolean(r4, r8)
            r0.recycle()
            android.content.res.Resources r0 = r12.getResources()
            int r11 = com.google.android.material.R.dimen.xa
            int r0 = r0.getDimensionPixelOffset(r11)
            r12.Y3 = r0
            com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment r0 = new com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
            r0.<init>(r3, r5, r10)
            com.google.android.material.shape.ShapeAppearanceModel$Builder r3 = com.google.android.material.shape.ShapeAppearanceModel.a()
            com.google.android.material.shape.ShapeAppearanceModel$Builder r0 = r3.G(r0)
            com.google.android.material.shape.ShapeAppearanceModel r0 = r0.m()
            r13.setShapeAppearanceModel(r0)
            if (r4 == 0) goto L_0x00e9
            r0 = 2
            r13.y0(r0)
            goto L_0x00f8
        L_0x00e9:
            r13.y0(r8)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 28
            if (r0 < r3) goto L_0x00f8
            r12.setOutlineAmbientShadowColor(r7)
            r12.setOutlineSpotShadowColor(r7)
        L_0x00f8:
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r13.s0(r0)
            r13.a0(r9)
            float r0 = (float) r2
            r12.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.o(r13, r1)
            androidx.core.view.ViewCompat.P1(r12, r13)
            com.google.android.material.bottomappbar.BottomAppBar$3 r13 = new com.google.android.material.bottomappbar.BottomAppBar$3
            r13.<init>()
            com.google.android.material.internal.ViewUtils.g(r12, r14, r15, r6, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
