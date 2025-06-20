package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout extends LinearLayout implements CoordinatorLayout.AttachedBehavior {
    private static final int A3 = R.style.Le;
    private static final int B3 = -1;
    static final int v3 = 0;
    static final int w3 = 1;
    static final int x3 = 2;
    static final int y3 = 4;
    static final int z3 = 8;
    private int X2;
    private int Y2;
    private int Z2;
    private boolean a3;
    private int b3;
    @Nullable
    private WindowInsetsCompat c3;
    private List<BaseOnOffsetChangedListener> d3;
    private boolean e3;
    private boolean f3;
    private boolean g3;
    private boolean h3;
    @IdRes
    private int i3;
    @Nullable
    private WeakReference<View> j3;
    private final boolean k3;
    @Nullable
    private ValueAnimator l3;
    @Nullable
    private ValueAnimator.AnimatorUpdateListener m3;
    private final List<LiftOnScrollListener> n3;
    private final long o3;
    private final TimeInterpolator p3;
    private int[] q3;
    @Nullable
    private Drawable r3;
    private int s;
    @Nullable
    private Integer s3;
    private final float t3;
    private Behavior u3;

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        private static final int k3 = 600;
        /* access modifiers changed from: private */
        public int e3;
        private int f3;
        private ValueAnimator g3;
        private SavedState h3;
        @Nullable
        private WeakReference<View> i3;
        private BaseDragCallback j3;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean a(@NonNull T t);
        }

        protected static class SavedState extends AbsSavedState {
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
            int X2;
            boolean Y;
            float Y2;
            boolean Z;
            boolean Z2;

            public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                boolean z = false;
                this.Y = parcel.readByte() != 0;
                this.Z = parcel.readByte() != 0;
                this.X2 = parcel.readInt();
                this.Y2 = parcel.readFloat();
                this.Z2 = parcel.readByte() != 0 ? true : z;
            }

            public void writeToParcel(@NonNull Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeByte(this.Y ? (byte) 1 : 0);
                parcel.writeByte(this.Z ? (byte) 1 : 0);
                parcel.writeInt(this.X2);
                parcel.writeFloat(this.Y2);
                parcel.writeByte(this.Z2 ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }

        public BaseBehavior() {
        }

        private boolean M0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            List<View> x = coordinatorLayout.x(t);
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) x.get(i2).getLayoutParams()).f();
                if (f2 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f2).Z() != 0;
                }
            }
            return false;
        }

        private void N0(CoordinatorLayout coordinatorLayout, @NonNull T t) {
            int topInset = t.getTopInset() + t.getPaddingTop();
            int b0 = b0() - topInset;
            int t0 = t0(t, b0);
            if (t0 >= 0) {
                View childAt = t.getChildAt(t0);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int c2 = layoutParams.c();
                if ((c2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i4 = -childAt.getBottom();
                    if (t0 == 0 && ViewCompat.W(t) && ViewCompat.W(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (p0(c2, 2)) {
                        i4 += ViewCompat.h0(childAt);
                    } else if (p0(c2, 5)) {
                        int h0 = ViewCompat.h0(childAt) + i4;
                        if (b0 < h0) {
                            i2 = h0;
                        } else {
                            i4 = h0;
                        }
                    }
                    if (p0(c2, 32)) {
                        i2 += layoutParams.topMargin;
                        i4 -= layoutParams.bottomMargin;
                    }
                    k0(coordinatorLayout, t, MathUtils.e(m0(b0, i4, i2) + topInset, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void O0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i4, boolean z) {
            View s0 = s0(t, i2);
            boolean z2 = false;
            if (s0 != null) {
                int c2 = ((LayoutParams) s0.getLayoutParams()).c();
                if ((c2 & 1) != 0) {
                    int h0 = ViewCompat.h0(s0);
                    if (i4 <= 0 || (c2 & 12) == 0 ? !((c2 & 2) == 0 || (-i2) < (s0.getBottom() - h0) - t.getTopInset()) : (-i2) >= (s0.getBottom() - h0) - t.getTopInset()) {
                        z2 = true;
                    }
                }
            }
            if (t.s()) {
                z2 = t.L(r0(coordinatorLayout));
            }
            boolean I = t.I(z2);
            if (z || (I && M0(coordinatorLayout, t))) {
                if (t.getBackground() != null) {
                    t.getBackground().jumpToCurrentState();
                }
                if (Build.VERSION.SDK_INT >= 23 && t.getForeground() != null) {
                    t.getForeground().jumpToCurrentState();
                }
                if (t.getStateListAnimator() != null) {
                    t.getStateListAnimator().jumpToCurrentState();
                }
            }
        }

        private void j0(final CoordinatorLayout coordinatorLayout, @NonNull final T t) {
            if (!ViewCompat.J0(coordinatorLayout)) {
                ViewCompat.H1(coordinatorLayout, new AccessibilityDelegateCompat() {
                    public void g(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        View g0;
                        super.g(view, accessibilityNodeInfoCompat);
                        accessibilityNodeInfoCompat.j1(ScrollView.class.getName());
                        if (t.getTotalScrollRange() != 0 && (g0 = BaseBehavior.this.u0(coordinatorLayout)) != null && BaseBehavior.this.q0(t)) {
                            if (BaseBehavior.this.b0() != (-t.getTotalScrollRange())) {
                                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.r);
                                accessibilityNodeInfoCompat.X1(true);
                            }
                            if (BaseBehavior.this.b0() == 0) {
                                return;
                            }
                            if (!g0.canScrollVertically(-1) || (-t.getDownNestedPreScrollRange()) != 0) {
                                accessibilityNodeInfoCompat.b(AccessibilityNodeInfoCompat.AccessibilityActionCompat.s);
                                accessibilityNodeInfoCompat.X1(true);
                            }
                        }
                    }

                    public boolean j(View view, int i2, Bundle bundle) {
                        if (i2 == 4096) {
                            t.setExpanded(false);
                            return true;
                        } else if (i2 != 8192) {
                            return super.j(view, i2, bundle);
                        } else {
                            if (BaseBehavior.this.b0() != 0) {
                                View g0 = BaseBehavior.this.u0(coordinatorLayout);
                                if (g0.canScrollVertically(-1)) {
                                    int i3 = -t.getDownNestedPreScrollRange();
                                    if (i3 != 0) {
                                        BaseBehavior.this.y(coordinatorLayout, t, g0, 0, i3, new int[]{0, 0}, 1);
                                        return true;
                                    }
                                } else {
                                    t.setExpanded(true);
                                    return true;
                                }
                            }
                            return false;
                        }
                    }
                });
            }
        }

        private void k0(CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, float f2) {
            int abs = Math.abs(b0() - i2);
            float abs2 = Math.abs(f2);
            l0(coordinatorLayout, t, i2, abs2 > 0.0f ? Math.round((((float) abs) / abs2) * 1000.0f) * 3 : (int) (((((float) abs) / ((float) t.getHeight())) + 1.0f) * 150.0f));
        }

        private void l0(final CoordinatorLayout coordinatorLayout, final T t, int i2, int i4) {
            int b0 = b0();
            if (b0 == i2) {
                ValueAnimator valueAnimator = this.g3;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.g3.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.g3;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.g3 = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.f20770e);
                this.g3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        BaseBehavior.this.e0(coordinatorLayout, t, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.g3.setDuration((long) Math.min(i4, 600));
            this.g3.setIntValues(new int[]{b0, i2});
            this.g3.start();
        }

        private int m0(int i2, int i4, int i5) {
            return i2 < (i4 + i5) / 2 ? i4 : i5;
        }

        private boolean o0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
            return t.o() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean p0(int i2, int i4) {
            return (i2 & i4) == i4;
        }

        /* access modifiers changed from: private */
        public boolean q0(AppBarLayout appBarLayout) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (((LayoutParams) appBarLayout.getChildAt(i2).getLayoutParams()).f20808a != 0) {
                    return true;
                }
            }
            return false;
        }

        @Nullable
        private View r0(@NonNull CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof NestedScrollingChild) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        @Nullable
        private static View s0(@NonNull AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = appBarLayout.getChildAt(i4);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int t0(@NonNull T t, int i2) {
            int childCount = t.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = t.getChildAt(i4);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (p0(layoutParams.c(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i5 = -i2;
                if (top <= i5 && bottom >= i5) {
                    return i4;
                }
            }
            return -1;
        }

        /* access modifiers changed from: private */
        @Nullable
        public View u0(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        private int x0(@NonNull T t, int i2) {
            int abs = Math.abs(i2);
            int childCount = t.getChildCount();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                if (i5 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator d2 = layoutParams.d();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i5++;
                } else if (d2 != null) {
                    int c2 = layoutParams.c();
                    if ((c2 & 1) != 0) {
                        i4 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((c2 & 2) != 0) {
                            i4 -= ViewCompat.h0(childAt);
                        }
                    }
                    if (ViewCompat.W(childAt)) {
                        i4 -= t.getTopInset();
                    }
                    if (i4 > 0) {
                        float f2 = (float) i4;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * d2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        /* renamed from: A0 */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2) {
            int i4;
            boolean t2 = super.t(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            SavedState savedState = this.h3;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        i4 = -t.getUpNestedPreScrollRange();
                        if (z) {
                            k0(coordinatorLayout, t, i4, 0.0f);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            k0(coordinatorLayout, t, 0, 0.0f);
                        }
                        e0(coordinatorLayout, t, 0);
                    }
                }
                t.C();
                this.h3 = null;
                U(MathUtils.e(O(), -t.getTotalScrollRange(), 0));
                O0(coordinatorLayout, t, O(), 0, true);
                t.x(O());
                j0(coordinatorLayout, t);
                return t2;
            } else if (savedState.Y) {
                i4 = -t.getTotalScrollRange();
            } else {
                if (!savedState.Z) {
                    View childAt = t.getChildAt(savedState.X2);
                    e0(coordinatorLayout, t, (-childAt.getBottom()) + (this.h3.Z2 ? ViewCompat.h0(childAt) + t.getTopInset() : Math.round(((float) childAt.getHeight()) * this.h3.Y2)));
                    t.C();
                    this.h3 = null;
                    U(MathUtils.e(O(), -t.getTotalScrollRange(), 0));
                    O0(coordinatorLayout, t, O(), 0, true);
                    t.x(O());
                    j0(coordinatorLayout, t);
                    return t2;
                }
                e0(coordinatorLayout, t, 0);
                t.C();
                this.h3 = null;
                U(MathUtils.e(O(), -t.getTotalScrollRange(), 0));
                O0(coordinatorLayout, t, O(), 0, true);
                t.x(O());
                j0(coordinatorLayout, t);
                return t2;
            }
            e0(coordinatorLayout, t, i4);
            t.C();
            this.h3 = null;
            U(MathUtils.e(O(), -t.getTotalScrollRange(), 0));
            O0(coordinatorLayout, t, O(), 0, true);
            t.x(O());
            j0(coordinatorLayout, t);
            return t2;
        }

        /* renamed from: B0 */
        public boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i4, int i5, int i6) {
            if (((CoordinatorLayout.LayoutParams) t.getLayoutParams()).height != -2) {
                return super.u(coordinatorLayout, t, i2, i4, i5, i6);
            }
            coordinatorLayout.O(t, i2, i4, View.MeasureSpec.makeMeasureSpec(0, 0), i6);
            return true;
        }

        /* renamed from: C0 */
        public void y(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i4, int[] iArr, int i5) {
            int i6;
            int i7;
            if (i4 != 0) {
                if (i4 < 0) {
                    int i8 = -t.getTotalScrollRange();
                    i7 = i8;
                    i6 = t.getDownNestedPreScrollRange() + i8;
                } else {
                    i7 = -t.getUpNestedPreScrollRange();
                    i6 = 0;
                }
                if (i7 != i6) {
                    iArr[1] = d0(coordinatorLayout, t, i4, i7, i6);
                }
            }
            if (t.s()) {
                t.I(t.L(view));
            }
        }

        /* renamed from: D0 */
        public void B(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2, int i4, int i5, int i6, int i7, int[] iArr) {
            if (i6 < 0) {
                iArr[1] = d0(coordinatorLayout, t, i6, -t.getDownNestedScrollRange(), 0);
            }
            if (i6 == 0) {
                j0(coordinatorLayout, t);
            }
        }

        /* renamed from: E0 */
        public void F(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                I0((SavedState) parcelable, true);
                super.F(coordinatorLayout, t, this.h3.a());
                return;
            }
            super.F(coordinatorLayout, t, parcelable);
            this.h3 = null;
        }

        /* renamed from: F0 */
        public Parcelable G(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            Parcelable G = super.G(coordinatorLayout, t);
            SavedState J0 = J0(G, t);
            return J0 == null ? G : J0;
        }

        /* renamed from: G0 */
        public boolean I(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, View view2, int i2, int i4) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.s() || o0(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.g3) != null) {
                valueAnimator.cancel();
            }
            this.i3 = null;
            this.f3 = i4;
            return z;
        }

        /* renamed from: H0 */
        public void K(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i2) {
            if (this.f3 == 0 || i2 == 1) {
                N0(coordinatorLayout, t);
                if (t.s()) {
                    t.I(t.L(view));
                }
            }
            this.i3 = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        public void I0(@Nullable SavedState savedState, boolean z) {
            if (this.h3 == null || z) {
                this.h3 = savedState;
            }
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public SavedState J0(@Nullable Parcelable parcelable, @NonNull T t) {
            int O = O();
            int childCount = t.getChildCount();
            boolean z = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + O;
                if (childAt.getTop() + O > 0 || bottom < 0) {
                    i2++;
                } else {
                    if (parcelable == null) {
                        parcelable = AbsSavedState.X;
                    }
                    SavedState savedState = new SavedState(parcelable);
                    boolean z2 = O == 0;
                    savedState.Z = z2;
                    savedState.Y = !z2 && (-O) >= t.getTotalScrollRange();
                    savedState.X2 = i2;
                    if (bottom == ViewCompat.h0(childAt) + t.getTopInset()) {
                        z = true;
                    }
                    savedState.Z2 = z;
                    savedState.Y2 = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return null;
        }

        public void K0(@Nullable BaseDragCallback baseDragCallback) {
            this.j3 = baseDragCallback;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: L0 */
        public int f0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i2, int i4, int i5) {
            int b0 = b0();
            int i6 = 0;
            if (i4 == 0 || b0 < i4 || b0 > i5) {
                this.e3 = 0;
            } else {
                int e2 = MathUtils.e(i2, i4, i5);
                if (b0 != e2) {
                    int x0 = t.m() ? x0(t, e2) : e2;
                    boolean U = U(x0);
                    int i7 = b0 - e2;
                    this.e3 = e2 - x0;
                    if (U) {
                        while (i6 < t.getChildCount()) {
                            LayoutParams layoutParams = (LayoutParams) t.getChildAt(i6).getLayoutParams();
                            ChildScrollEffect b2 = layoutParams.b();
                            if (!(b2 == null || (layoutParams.c() & 1) == 0)) {
                                b2.a(t, t.getChildAt(i6), (float) O());
                            }
                            i6++;
                        }
                    }
                    if (!U && t.m()) {
                        coordinatorLayout.k(t);
                    }
                    t.x(O());
                    O0(coordinatorLayout, t, e2, e2 < b0 ? -1 : 1, false);
                    i6 = i7;
                }
            }
            j0(coordinatorLayout, t);
            return i6;
        }

        /* access modifiers changed from: package-private */
        public int b0() {
            return O() + this.e3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n0 */
        public boolean W(T t) {
            BaseDragCallback baseDragCallback = this.j3;
            if (baseDragCallback != null) {
                return baseDragCallback.a(t);
            }
            WeakReference<View> weakReference = this.i3;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return view != null && view.isShown() && !view.canScrollVertically(-1);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: v0 */
        public int Z(@NonNull T t) {
            return (-t.getDownNestedScrollRange()) + t.getTopInset();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: w0 */
        public int a0(@NonNull T t) {
            return t.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public boolean y0() {
            ValueAnimator valueAnimator = this.g3;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: z0 */
        public void c0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
            N0(coordinatorLayout, t);
            if (t.s()) {
                t.I(t.L(r0(coordinatorLayout)));
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void a(T t, int i2);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {

        public static abstract class DragCallback extends BaseBehavior.BaseDragCallback<AppBarLayout> {
        }

        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean A0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2) {
            return super.t(coordinatorLayout, appBarLayout, i2);
        }

        public /* bridge */ /* synthetic */ boolean B0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.u(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void C0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.y(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        public /* bridge */ /* synthetic */ void D0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.B(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        public /* bridge */ /* synthetic */ void E0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, Parcelable parcelable) {
            super.F(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable F0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout) {
            return super.G(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean G0(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull View view, View view2, int i2, int i3) {
            return super.I(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        public /* bridge */ /* synthetic */ void H0(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, View view, int i2) {
            super.K(coordinatorLayout, appBarLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ void K0(@Nullable BaseBehavior.BaseDragCallback baseDragCallback) {
            super.K0(baseDragCallback);
        }

        public /* bridge */ /* synthetic */ boolean L(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.L(coordinatorLayout, view, motionEvent);
        }

        public /* bridge */ /* synthetic */ int N() {
            return super.N();
        }

        public /* bridge */ /* synthetic */ int O() {
            return super.O();
        }

        public /* bridge */ /* synthetic */ boolean P() {
            return super.P();
        }

        public /* bridge */ /* synthetic */ boolean Q() {
            return super.Q();
        }

        public /* bridge */ /* synthetic */ void S(boolean z) {
            super.S(z);
        }

        public /* bridge */ /* synthetic */ boolean T(int i2) {
            return super.T(i2);
        }

        public /* bridge */ /* synthetic */ boolean U(int i2) {
            return super.U(i2);
        }

        public /* bridge */ /* synthetic */ void V(boolean z) {
            super.V(z);
        }

        public /* bridge */ /* synthetic */ boolean s(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull MotionEvent motionEvent) {
            return super.s(coordinatorLayout, view, motionEvent);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class ChildScrollEffect {
        public abstract void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f2);
    }

    public static class CompressChildScrollEffect extends ChildScrollEffect {

        /* renamed from: c  reason: collision with root package name */
        private static final float f20794c = 0.3f;

        /* renamed from: a  reason: collision with root package name */
        private final Rect f20795a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f20796b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        public void a(@NonNull AppBarLayout appBarLayout, @NonNull View view, float f2) {
            b(this.f20795a, appBarLayout, view);
            float abs = ((float) this.f20795a.top) - Math.abs(f2);
            if (abs <= 0.0f) {
                float d2 = 1.0f - MathUtils.d(Math.abs(abs / ((float) this.f20795a.height())), 0.0f, 1.0f);
                float height = (-abs) - ((((float) this.f20795a.height()) * f20794c) * (1.0f - (d2 * d2)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f20796b);
                this.f20796b.offset(0, (int) (-height));
                if (height >= ((float) this.f20796b.height())) {
                    view.setVisibility(4);
                } else {
                    view.setVisibility(0);
                }
                ViewCompat.T1(view, this.f20796b);
                return;
            }
            ViewCompat.T1(view, (Rect) null);
            view.setTranslationY(0.0f);
            view.setVisibility(0);
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: d  reason: collision with root package name */
        public static final int f20797d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final int f20798e = 1;

        /* renamed from: f  reason: collision with root package name */
        public static final int f20799f = 2;

        /* renamed from: g  reason: collision with root package name */
        public static final int f20800g = 4;

        /* renamed from: h  reason: collision with root package name */
        public static final int f20801h = 8;

        /* renamed from: i  reason: collision with root package name */
        public static final int f20802i = 16;

        /* renamed from: j  reason: collision with root package name */
        public static final int f20803j = 32;

        /* renamed from: k  reason: collision with root package name */
        static final int f20804k = 5;

        /* renamed from: l  reason: collision with root package name */
        static final int f20805l = 17;

        /* renamed from: m  reason: collision with root package name */
        static final int f20806m = 10;

        /* renamed from: n  reason: collision with root package name */
        public static final int f20807n = 0;
        public static final int o = 1;

        /* renamed from: a  reason: collision with root package name */
        int f20808a = 1;

        /* renamed from: b  reason: collision with root package name */
        private ChildScrollEffect f20809b;

        /* renamed from: c  reason: collision with root package name */
        Interpolator f20810c;

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollEffect {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        @Nullable
        private ChildScrollEffect a(int i2) {
            if (i2 != 1) {
                return null;
            }
            return new CompressChildScrollEffect();
        }

        @Nullable
        public ChildScrollEffect b() {
            return this.f20809b;
        }

        public int c() {
            return this.f20808a;
        }

        public Interpolator d() {
            return this.f20810c;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            int i2 = this.f20808a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public void f(int i2) {
            this.f20809b = a(i2);
        }

        public void g(@Nullable ChildScrollEffect childScrollEffect) {
            this.f20809b = childScrollEffect;
        }

        public void h(int i2) {
            this.f20808a = i2;
        }

        public void i(Interpolator interpolator) {
            this.f20810c = interpolator;
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3, f2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.G0);
            this.f20808a = obtainStyledAttributes.getInt(R.styleable.I0, 0);
            f(obtainStyledAttributes.getInt(R.styleable.H0, 0));
            int i2 = R.styleable.J0;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f20810c = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.f20808a = layoutParams.f20808a;
            this.f20809b = layoutParams.f20809b;
            this.f20810c = layoutParams.f20810c;
        }
    }

    public interface LiftOnScrollListener {
        void a(@Dimension float f2, @ColorInt int i2);
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
        void a(AppBarLayout appBarLayout, int i2);
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int g0(@NonNull AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                return ((BaseBehavior) f2).b0();
            }
            return 0;
        }

        private void h0(@NonNull View view, @NonNull View view2) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                ViewCompat.j1(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f2).e3) + b0()) - X(view2));
            }
        }

        private void i0(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.s()) {
                    appBarLayout.I(appBarLayout.L(view));
                }
            }
        }

        public boolean E(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect, boolean z) {
            AppBarLayout f0 = W(coordinatorLayout.w(view));
            if (f0 != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                Rect rect3 = this.Z;
                rect3.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect3.contains(rect2)) {
                    f0.D(false, !z);
                    return true;
                }
            }
            return false;
        }

        public /* bridge */ /* synthetic */ int N() {
            return super.N();
        }

        public /* bridge */ /* synthetic */ int O() {
            return super.O();
        }

        public /* bridge */ /* synthetic */ boolean P() {
            return super.P();
        }

        public /* bridge */ /* synthetic */ boolean Q() {
            return super.Q();
        }

        public /* bridge */ /* synthetic */ void S(boolean z) {
            super.S(z);
        }

        public /* bridge */ /* synthetic */ boolean T(int i2) {
            return super.T(i2);
        }

        public /* bridge */ /* synthetic */ boolean U(int i2) {
            return super.U(i2);
        }

        public /* bridge */ /* synthetic */ void V(boolean z) {
            super.V(z);
        }

        /* access modifiers changed from: package-private */
        public float Y(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int g0 = g0(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + g0 > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) g0) / ((float) i2)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        public int a0(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.a0(view);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        /* renamed from: f0 */
        public AppBarLayout W(@NonNull List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean m(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean p(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            h0(view, view2);
            i0(view, view2);
            return false;
        }

        public void q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
            if (view2 instanceof AppBarLayout) {
                ViewCompat.H1(coordinatorLayout, (AccessibilityDelegateCompat) null);
            }
        }

        public /* bridge */ /* synthetic */ boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2) {
            return super.t(coordinatorLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean u(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i2, int i3, int i4, int i5) {
            return super.u(coordinatorLayout, view, i2, i3, i4, i5);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ns);
            d0(obtainStyledAttributes.getDimensionPixelSize(R.styleable.os, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void E(boolean z, boolean z2, boolean z4) {
        int i2 = 0;
        int i4 = (z ? 1 : 2) | (z2 ? 4 : 0);
        if (z4) {
            i2 = 8;
        }
        this.b3 = i4 | i2;
        requestLayout();
    }

    private boolean G(boolean z) {
        if (this.f3 == z) {
            return false;
        }
        this.f3 = z;
        refreshDrawableState();
        return true;
    }

    private boolean K() {
        return this.r3 != null && getTopInset() > 0;
    }

    private boolean M() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return childAt.getVisibility() != 8 && !ViewCompat.W(childAt);
    }

    private void N(float f2, float f4) {
        ValueAnimator valueAnimator = this.l3;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f2, f4});
        this.l3 = ofFloat;
        ofFloat.setDuration(this.o3);
        this.l3.setInterpolator(this.p3);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.m3;
        if (animatorUpdateListener != null) {
            this.l3.addUpdateListener(animatorUpdateListener);
        }
        this.l3.start();
    }

    private void O() {
        setWillNotDraw(!K());
    }

    private void g() {
        WeakReference<View> weakReference = this.j3;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.j3 = null;
    }

    @Nullable
    private Integer h() {
        int defaultColor;
        Drawable drawable = this.r3;
        if (drawable instanceof MaterialShapeDrawable) {
            defaultColor = ((MaterialShapeDrawable) drawable).E();
        } else {
            ColorStateList g2 = DrawableUtils.g(drawable);
            if (g2 == null) {
                return null;
            }
            defaultColor = g2.getDefaultColor();
        }
        return Integer.valueOf(defaultColor);
    }

    @Nullable
    private View i(@Nullable View view) {
        int i2;
        if (this.j3 == null && (i2 = this.i3) != -1) {
            View findViewById = view != null ? view.findViewById(i2) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.i3);
            }
            if (findViewById != null) {
                this.j3 = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.j3;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean n() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void p(MaterialShapeDrawable materialShapeDrawable, @NonNull ColorStateList colorStateList, @NonNull ColorStateList colorStateList2) {
        this.m3 = new b(this, colorStateList, colorStateList2, materialShapeDrawable, MaterialColors.f(getContext(), R.attr.e4));
        ViewCompat.P1(this, materialShapeDrawable);
    }

    private void q(Context context, MaterialShapeDrawable materialShapeDrawable) {
        materialShapeDrawable.a0(context);
        this.m3 = new c(this, materialShapeDrawable);
        ViewCompat.P1(this, materialShapeDrawable);
    }

    private void r() {
        Behavior behavior = this.u3;
        BaseBehavior.SavedState J0 = (behavior == null || this.X2 == -1 || this.b3 != 0) ? null : behavior.J0(AbsSavedState.X, this);
        this.X2 = -1;
        this.Y2 = -1;
        this.Z2 = -1;
        if (J0 != null) {
            this.u3.I0(J0, false);
        }
    }

    private boolean t() {
        return getBackground() instanceof MaterialShapeDrawable;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(ColorStateList colorStateList, ColorStateList colorStateList2, MaterialShapeDrawable materialShapeDrawable, Integer num, ValueAnimator valueAnimator) {
        Integer num2;
        int t = MaterialColors.t(colorStateList.getDefaultColor(), colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
        materialShapeDrawable.p0(ColorStateList.valueOf(t));
        if (!(this.r3 == null || (num2 = this.s3) == null || !num2.equals(num))) {
            DrawableCompat.n(this.r3, t);
        }
        if (!this.n3.isEmpty()) {
            for (LiftOnScrollListener next : this.n3) {
                if (materialShapeDrawable.z() != null) {
                    next.a(0.0f, t);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(MaterialShapeDrawable materialShapeDrawable, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.o0(floatValue);
        Drawable drawable = this.r3;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).o0(floatValue);
        }
        for (LiftOnScrollListener a2 : this.n3) {
            a2.a(floatValue, materialShapeDrawable.E());
        }
    }

    public void A(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.d3;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    public void B(OnOffsetChangedListener onOffsetChangedListener) {
        A(onOffsetChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void C() {
        this.b3 = 0;
    }

    public void D(boolean z, boolean z2) {
        E(z, z2, true);
    }

    public boolean F(boolean z) {
        this.e3 = true;
        return G(z);
    }

    public boolean H(boolean z) {
        return J(z, true);
    }

    /* access modifiers changed from: package-private */
    public boolean I(boolean z) {
        return J(z, !this.e3);
    }

    /* access modifiers changed from: package-private */
    public boolean J(boolean z, boolean z2) {
        if (!z2 || this.g3 == z) {
            return false;
        }
        this.g3 = z;
        refreshDrawableState();
        if (!t()) {
            return true;
        }
        float f2 = 0.0f;
        if (this.k3) {
            float f4 = z ? 0.0f : 1.0f;
            if (z) {
                f2 = 1.0f;
            }
            N(f4, f2);
            return true;
        } else if (!this.h3) {
            return true;
        } else {
            float f5 = z ? 0.0f : this.t3;
            if (z) {
                f2 = this.t3;
            }
            N(f5, f2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean L(@Nullable View view) {
        View i2 = i(view);
        if (i2 != null) {
            view = i2;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    public void c(@NonNull LiftOnScrollListener liftOnScrollListener) {
        this.n3.add(liftOnScrollListener);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(@Nullable BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.d3 == null) {
            this.d3 = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.d3.contains(baseOnOffsetChangedListener)) {
            this.d3.add(baseOnOffsetChangedListener);
        }
    }

    public void draw(@NonNull Canvas canvas) {
        super.draw(canvas);
        if (K()) {
            int save = canvas.save();
            canvas.translate(0.0f, (float) (-this.s));
            this.r3.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.r3;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public void e(OnOffsetChangedListener onOffsetChangedListener) {
        d(onOffsetChangedListener);
    }

    public void f() {
        this.n3.clear();
    }

    @NonNull
    public CoordinatorLayout.Behavior<AppBarLayout> getBehavior() {
        Behavior behavior = new Behavior();
        this.u3 = behavior;
        return behavior;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int h0;
        int i4 = this.Y2;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.f20808a;
                if ((i6 & 5) == 5) {
                    int i7 = layoutParams.topMargin + layoutParams.bottomMargin;
                    if ((i6 & 8) != 0) {
                        h0 = ViewCompat.h0(childAt);
                    } else if ((i6 & 2) != 0) {
                        h0 = measuredHeight - ViewCompat.h0(childAt);
                    } else {
                        i2 = i7 + measuredHeight;
                        if (childCount == 0 && ViewCompat.W(childAt)) {
                            i2 = Math.min(i2, measuredHeight - getTopInset());
                        }
                        i5 += i2;
                    }
                    i2 = i7 + h0;
                    i2 = Math.min(i2, measuredHeight - getTopInset());
                    i5 += i2;
                } else if (i5 > 0) {
                    break;
                }
            }
        }
        int max = Math.max(0, i5);
        this.Y2 = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.Z2;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                int i6 = layoutParams.f20808a;
                if ((i6 & 1) == 0) {
                    break;
                }
                i5 += measuredHeight;
                if ((i6 & 2) != 0) {
                    i5 -= ViewCompat.h0(childAt);
                    break;
                }
            }
            i4++;
        }
        int max = Math.max(0, i5);
        this.Z2 = max;
        return max;
    }

    @IdRes
    public int getLiftOnScrollTargetViewId() {
        return this.i3;
    }

    @Nullable
    public MaterialShapeDrawable getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof MaterialShapeDrawable) {
            return (MaterialShapeDrawable) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int h0 = ViewCompat.h0(this);
        if (h0 == 0) {
            int childCount = getChildCount();
            h0 = childCount >= 1 ? ViewCompat.h0(getChildAt(childCount - 1)) : 0;
            if (h0 == 0) {
                return getHeight() / 3;
            }
        }
        return (h0 * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.b3;
    }

    @Nullable
    public Drawable getStatusBarForeground() {
        return this.r3;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.c3;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.r();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.X2;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = layoutParams.f20808a;
                if ((i6 & 1) == 0) {
                    break;
                }
                i5 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
                if (i4 == 0 && ViewCompat.W(childAt)) {
                    i5 -= getTopInset();
                }
                if ((i6 & 2) != 0) {
                    i5 -= ViewCompat.h0(childAt);
                    break;
                }
            }
            i4++;
        }
        int max = Math.max(0, i5);
        this.X2 = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    /* renamed from: k */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.a3;
    }

    /* access modifiers changed from: package-private */
    public boolean o() {
        return getTotalScrollRange() != 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.q3 == null) {
            this.q3 = new int[4];
        }
        int[] iArr = this.q3;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.f3;
        int i4 = R.attr.fh;
        if (!z) {
            i4 = -i4;
        }
        iArr[0] = i4;
        iArr[1] = (!z || !this.g3) ? -R.attr.gh : R.attr.gh;
        int i5 = R.attr.bh;
        if (!z) {
            i5 = -i5;
        }
        iArr[2] = i5;
        iArr[3] = (!z || !this.g3) ? -R.attr.ah : R.attr.ah;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        boolean z2 = true;
        if (ViewCompat.W(this) && M()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                ViewCompat.j1(getChildAt(childCount), topInset);
            }
        }
        r();
        this.a3 = false;
        int childCount2 = getChildCount();
        int i7 = 0;
        while (true) {
            if (i7 >= childCount2) {
                break;
            } else if (((LayoutParams) getChildAt(i7).getLayoutParams()).d() != null) {
                this.a3 = true;
                break;
            } else {
                i7++;
            }
        }
        Drawable drawable = this.r3;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.e3) {
            if (!this.h3 && !n()) {
                z2 = false;
            }
            G(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        super.onMeasure(i2, i4);
        int mode = View.MeasureSpec.getMode(i4);
        if (mode != 1073741824 && ViewCompat.W(this) && M()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = MathUtils.e(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i4));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        r();
    }

    public boolean s() {
        return this.h3;
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.d(this, f2);
    }

    public void setExpanded(boolean z) {
        D(z, ViewCompat.Y0(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.h3 = z;
    }

    public void setLiftOnScrollTargetView(@Nullable View view) {
        this.i3 = -1;
        if (view == null) {
            g();
        } else {
            this.j3 = new WeakReference<>(view);
        }
    }

    public void setLiftOnScrollTargetViewId(@IdRes int i2) {
        this.i3 = i2;
        g();
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.e3 = z;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(@Nullable Drawable drawable) {
        Drawable drawable2 = this.r3;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.r3 = drawable3;
            this.s3 = h();
            Drawable drawable4 = this.r3;
            if (drawable4 != null) {
                if (drawable4.isStateful()) {
                    this.r3.setState(getDrawableState());
                }
                DrawableCompat.m(this.r3, ViewCompat.c0(this));
                this.r3.setVisible(getVisibility() == 0, false);
                this.r3.setCallback(this);
            }
            O();
            ViewCompat.t1(this);
        }
    }

    public void setStatusBarForegroundColor(@ColorInt int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(@DrawableRes int i2) {
        setStatusBarForeground(AppCompatResources.b(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        ViewUtilsLollipop.b(this, f2);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.r3;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    public boolean u() {
        return this.g3;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.r3;
    }

    /* access modifiers changed from: package-private */
    public void x(int i2) {
        this.s = i2;
        if (!willNotDraw()) {
            ViewCompat.t1(this);
        }
        List<BaseOnOffsetChangedListener> list = this.d3;
        if (list != null) {
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.d3.get(i4);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.a(this, i2);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat y(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.W(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.a(this.c3, windowInsetsCompat2)) {
            this.c3 = windowInsetsCompat2;
            O();
            requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean z(@NonNull LiftOnScrollListener liftOnScrollListener) {
        return this.n3.remove(liftOnScrollListener);
    }

    public AppBarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Y);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppBarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = A3
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.X2 = r11
            r10.Y2 = r11
            r10.Z2 = r11
            r6 = 0
            r10.b3 = r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.n3 = r0
            android.content.Context r7 = r10.getContext()
            r8 = 1
            r10.setOrientation(r8)
            int r9 = android.os.Build.VERSION.SDK_INT
            android.view.ViewOutlineProvider r0 = r10.getOutlineProvider()
            android.view.ViewOutlineProvider r1 = android.view.ViewOutlineProvider.BACKGROUND
            if (r0 != r1) goto L_0x002f
            com.google.android.material.appbar.ViewUtilsLollipop.a(r10)
        L_0x002f:
            com.google.android.material.appbar.ViewUtilsLollipop.c(r10, r12, r13, r4)
            int[] r2 = com.google.android.material.R.styleable.r0
            int[] r5 = new int[r6]
            r0 = r7
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.s0
            android.graphics.drawable.Drawable r13 = r12.getDrawable(r13)
            androidx.core.view.ViewCompat.P1(r10, r13)
            int r13 = com.google.android.material.R.styleable.y0
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r7, r12, r13)
            if (r13 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r8 = 0
        L_0x0050:
            r10.k3 = r8
            android.graphics.drawable.Drawable r0 = r10.getBackground()
            android.content.res.ColorStateList r0 = com.google.android.material.drawable.DrawableUtils.g(r0)
            if (r0 == 0) goto L_0x006d
            com.google.android.material.shape.MaterialShapeDrawable r1 = new com.google.android.material.shape.MaterialShapeDrawable
            r1.<init>()
            r1.p0(r0)
            if (r13 == 0) goto L_0x006a
            r10.p(r1, r0, r13)
            goto L_0x006d
        L_0x006a:
            r10.q(r7, r1)
        L_0x006d:
            int r13 = com.google.android.material.R.attr.Jd
            android.content.res.Resources r0 = r10.getResources()
            int r1 = com.google.android.material.R.integer.f20677c
            int r0 = r0.getInteger(r1)
            int r13 = com.google.android.material.motion.MotionUtils.f(r7, r13, r0)
            long r0 = (long) r13
            r10.o3 = r0
            int r13 = com.google.android.material.R.attr.be
            android.animation.TimeInterpolator r0 = com.google.android.material.animation.AnimationUtils.f20766a
            android.animation.TimeInterpolator r13 = com.google.android.material.motion.MotionUtils.g(r7, r13, r0)
            r10.p3 = r13
            int r13 = com.google.android.material.R.styleable.w0
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0099
            boolean r13 = r12.getBoolean(r13, r6)
            r10.E(r13, r6, r6)
        L_0x0099:
            int r13 = com.google.android.material.R.styleable.v0
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00a9
            int r13 = r12.getDimensionPixelSize(r13, r6)
            float r13 = (float) r13
            com.google.android.material.appbar.ViewUtilsLollipop.b(r10, r13)
        L_0x00a9:
            r13 = 26
            if (r9 < r13) goto L_0x00cb
            int r13 = com.google.android.material.R.styleable.u0
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00bc
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setKeyboardNavigationCluster(r13)
        L_0x00bc:
            int r13 = com.google.android.material.R.styleable.t0
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00cb
            boolean r13 = r12.getBoolean(r13, r6)
            r10.setTouchscreenBlocksFocus(r13)
        L_0x00cb:
            android.content.res.Resources r13 = r10.getResources()
            int r0 = com.google.android.material.R.dimen.Q0
            float r13 = r13.getDimension(r0)
            r10.t3 = r13
            int r13 = com.google.android.material.R.styleable.x0
            boolean r13 = r12.getBoolean(r13, r6)
            r10.h3 = r13
            int r13 = com.google.android.material.R.styleable.z0
            int r11 = r12.getResourceId(r13, r11)
            r10.i3 = r11
            int r11 = com.google.android.material.R.styleable.A0
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarForeground(r11)
            r12.recycle()
            com.google.android.material.appbar.AppBarLayout$1 r11 = new com.google.android.material.appbar.AppBarLayout$1
            r11.<init>()
            androidx.core.view.ViewCompat.k2(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
