package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final int T3 = R.style.Te;
    @Dimension(unit = 0)
    private static final int U3 = 72;
    @Dimension(unit = 0)
    static final int V3 = 8;
    @Dimension(unit = 0)
    private static final int W3 = 48;
    @Dimension(unit = 0)
    private static final int X3 = 56;
    @Dimension(unit = 0)
    static final int Y3 = 16;
    private static final int Z3 = -1;
    private static final int a4 = 300;
    private static final int b4 = -1;
    private static final Pools.Pool<Tab> c4 = new Pools.SynchronizedPool(16);
    private static final String d4 = "TabLayout";
    public static final int e4 = 0;
    public static final int f4 = 1;
    public static final int g4 = 2;
    public static final int h4 = 0;
    public static final int i4 = 1;
    public static final int j4 = 0;
    public static final int k4 = 1;
    public static final int l4 = 2;
    public static final int m4 = 0;
    public static final int n4 = 1;
    public static final int o4 = 2;
    public static final int p4 = 3;
    public static final int q4 = 0;
    public static final int r4 = 1;
    public static final int s4 = 2;
    boolean A3;
    boolean B3;
    int C3;
    int D3;
    boolean E3;
    /* access modifiers changed from: private */
    public TabIndicatorInterpolator F3;
    /* access modifiers changed from: private */
    public final TimeInterpolator G3;
    @Nullable
    private BaseOnTabSelectedListener H3;
    private final ArrayList<BaseOnTabSelectedListener> I3;
    @Nullable
    private BaseOnTabSelectedListener J3;
    private ValueAnimator K3;
    @Nullable
    ViewPager L3;
    @Nullable
    private PagerAdapter M3;
    private DataSetObserver N3;
    private TabLayoutOnPageChangeListener O3;
    private AdapterChangeListener P3;
    private boolean Q3;
    /* access modifiers changed from: private */
    public int R3;
    private final Pools.Pool<TabView> S3;
    private final ArrayList<Tab> X2;
    @Nullable
    private Tab Y2;
    @NonNull
    final SlidingTabIndicator Z2;
    int a3;
    int b3;
    int c3;
    int d3;
    /* access modifiers changed from: private */
    public final int e3;
    /* access modifiers changed from: private */
    public final int f3;
    /* access modifiers changed from: private */
    public int g3;
    ColorStateList h3;
    ColorStateList i3;
    ColorStateList j3;
    @NonNull
    Drawable k3;
    private int l3;
    PorterDuff.Mode m3;
    float n3;
    float o3;
    float p3;
    final int q3;
    int r3;
    int s;
    private final int s3;
    private final int t3;
    private final int u3;
    private int v3;
    int w3;
    int x3;
    int y3;
    int z3;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f21981a;

        AdapterChangeListener() {
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.f21981a = z;
        }

        public void b(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.L3 == viewPager) {
                tabLayout.T(pagerAdapter2, this.f21981a);
            }
        }
    }

    @Deprecated
    public interface BaseOnTabSelectedListener<T extends Tab> {
        void a(T t);

        void b(T t);

        void c(T t);
    }

    public @interface LabelVisibility {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public interface OnTabSelectedListener extends BaseOnTabSelectedListener<Tab> {
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.J();
        }

        public void onInvalidated() {
            TabLayout.this.J();
        }
    }

    class SlidingTabIndicator extends LinearLayout {
        private int X2 = -1;
        ValueAnimator s;

        SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
        }

        private void e() {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.s == -1) {
                tabLayout.s = tabLayout.getSelectedTabPosition();
            }
            f(TabLayout.this.s);
        }

        private void f(int i2) {
            if (TabLayout.this.R3 == 0 || (TabLayout.this.getTabSelectedIndicator().getBounds().left == -1 && TabLayout.this.getTabSelectedIndicator().getBounds().right == -1)) {
                View childAt = getChildAt(i2);
                TabIndicatorInterpolator e2 = TabLayout.this.F3;
                TabLayout tabLayout = TabLayout.this;
                e2.c(tabLayout, childAt, tabLayout.k3);
                TabLayout.this.s = i2;
            }
        }

        /* access modifiers changed from: private */
        public void g() {
            f(TabLayout.this.getSelectedTabPosition());
        }

        /* access modifiers changed from: private */
        public void j(View view, View view2, float f2) {
            if (view == null || view.getWidth() <= 0) {
                Drawable drawable = TabLayout.this.k3;
                drawable.setBounds(-1, drawable.getBounds().top, -1, TabLayout.this.k3.getBounds().bottom);
            } else {
                TabIndicatorInterpolator e2 = TabLayout.this.F3;
                TabLayout tabLayout = TabLayout.this;
                e2.d(tabLayout, view, view2, f2, tabLayout.k3);
            }
            ViewCompat.t1(this);
        }

        private void k(boolean z, int i2, int i3) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.s != i2) {
                final View childAt = getChildAt(tabLayout.getSelectedTabPosition());
                final View childAt2 = getChildAt(i2);
                if (childAt2 == null) {
                    g();
                    return;
                }
                TabLayout.this.s = i2;
                AnonymousClass1 r5 = new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                        SlidingTabIndicator.this.j(childAt, childAt2, valueAnimator.getAnimatedFraction());
                    }
                };
                if (z) {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    this.s = valueAnimator;
                    valueAnimator.setInterpolator(TabLayout.this.G3);
                    valueAnimator.setDuration((long) i3);
                    valueAnimator.setFloatValues(new float[]{0.0f, 1.0f});
                    valueAnimator.addUpdateListener(r5);
                    valueAnimator.start();
                    return;
                }
                this.s.removeAllUpdateListeners();
                this.s.addUpdateListener(r5);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            ValueAnimator valueAnimator = this.s;
            if (!(valueAnimator == null || !valueAnimator.isRunning() || TabLayout.this.s == i2)) {
                this.s.cancel();
            }
            k(true, i2, i3);
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0051  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void draw(@androidx.annotation.NonNull android.graphics.Canvas r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.k3
                android.graphics.Rect r0 = r0.getBounds()
                int r0 = r0.height()
                if (r0 >= 0) goto L_0x0016
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.k3
                int r0 = r0.getIntrinsicHeight()
            L_0x0016:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                int r1 = r1.y3
                if (r1 == 0) goto L_0x003c
                r2 = 1
                r3 = 2
                if (r1 == r2) goto L_0x002d
                r2 = 0
                if (r1 == r3) goto L_0x0043
                r0 = 3
                if (r1 == r0) goto L_0x0028
                r0 = 0
                goto L_0x0043
            L_0x0028:
                int r0 = r5.getHeight()
                goto L_0x0043
            L_0x002d:
                int r1 = r5.getHeight()
                int r1 = r1 - r0
                int r2 = r1 / 2
                int r1 = r5.getHeight()
                int r1 = r1 + r0
                int r0 = r1 / 2
                goto L_0x0043
            L_0x003c:
                int r1 = r5.getHeight()
                int r2 = r1 - r0
                goto L_0x0028
            L_0x0043:
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.k3
                android.graphics.Rect r1 = r1.getBounds()
                int r1 = r1.width()
                if (r1 <= 0) goto L_0x006b
                com.google.android.material.tabs.TabLayout r1 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r1 = r1.k3
                android.graphics.Rect r1 = r1.getBounds()
                com.google.android.material.tabs.TabLayout r3 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r3 = r3.k3
                int r4 = r1.left
                int r1 = r1.right
                r3.setBounds(r4, r2, r1, r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.graphics.drawable.Drawable r0 = r0.k3
                r0.draw(r6)
            L_0x006b:
                super.draw(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.SlidingTabIndicator.draw(android.graphics.Canvas):void");
        }

        /* access modifiers changed from: package-private */
        public void h(int i2, float f2) {
            TabLayout.this.s = Math.round(((float) i2) + f2);
            ValueAnimator valueAnimator = this.s;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.s.cancel();
            }
            j(getChildAt(i2), getChildAt(i2 + 1), f2);
        }

        /* access modifiers changed from: package-private */
        public void i(int i2) {
            Rect bounds = TabLayout.this.k3.getBounds();
            TabLayout.this.k3.setBounds(bounds.left, 0, bounds.right, i2);
            requestLayout();
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.s;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e();
            } else {
                k(false, TabLayout.this.getSelectedTabPosition(), -1);
            }
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z = true;
                if (tabLayout.w3 == 1 || tabLayout.z3 == 2) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (((int) ViewUtils.i(getContext(), 16)) * 2)) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z2 = true;
                                }
                            }
                            z = z2;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.w3 = 0;
                            tabLayout2.c0(false);
                        }
                        if (z) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.X2 != i2) {
                requestLayout();
                this.X2 = i2;
            }
        }
    }

    public static class Tab {

        /* renamed from: k  reason: collision with root package name */
        public static final int f21984k = -1;
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private Object f21985a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Drawable f21986b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f21987c;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f21988d;

        /* renamed from: e  reason: collision with root package name */
        private int f21989e = -1;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private View f21990f;
        /* access modifiers changed from: private */
        @LabelVisibility

        /* renamed from: g  reason: collision with root package name */
        public int f21991g = 1;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public TabLayout f21992h;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        public TabView f21993i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public int f21994j = -1;

        @NonNull
        @CanIgnoreReturnValue
        public Tab A(@LabelVisibility int i2) {
            this.f21991g = i2;
            TabLayout tabLayout = this.f21992h;
            if (tabLayout.w3 == 1 || tabLayout.z3 == 2) {
                tabLayout.c0(true);
            }
            E();
            if (BadgeUtils.f20839a && this.f21993i.o() && this.f21993i.a3.isVisible()) {
                this.f21993i.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab B(@Nullable Object obj) {
            this.f21985a = obj;
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab C(@StringRes int i2) {
            TabLayout tabLayout = this.f21992h;
            if (tabLayout != null) {
                return D(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab D(@Nullable CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f21988d) && !TextUtils.isEmpty(charSequence)) {
                this.f21993i.setContentDescription(charSequence);
            }
            this.f21987c = charSequence;
            E();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void E() {
            TabView tabView = this.f21993i;
            if (tabView != null) {
                tabView.x();
            }
        }

        @Nullable
        public BadgeDrawable e() {
            return this.f21993i.getBadge();
        }

        @Nullable
        public CharSequence f() {
            TabView tabView = this.f21993i;
            if (tabView == null) {
                return null;
            }
            return tabView.getContentDescription();
        }

        @Nullable
        public View g() {
            return this.f21990f;
        }

        @Nullable
        public Drawable h() {
            return this.f21986b;
        }

        public int i() {
            return this.f21994j;
        }

        @NonNull
        public BadgeDrawable j() {
            return this.f21993i.getOrCreateBadge();
        }

        public int k() {
            return this.f21989e;
        }

        @LabelVisibility
        public int l() {
            return this.f21991g;
        }

        @Nullable
        public Object m() {
            return this.f21985a;
        }

        @Nullable
        public CharSequence n() {
            return this.f21987c;
        }

        public boolean o() {
            TabLayout tabLayout = this.f21992h;
            if (tabLayout != null) {
                int selectedTabPosition = tabLayout.getSelectedTabPosition();
                return selectedTabPosition != -1 && selectedTabPosition == this.f21989e;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public void p() {
            this.f21993i.r();
        }

        /* access modifiers changed from: package-private */
        public void q() {
            this.f21992h = null;
            this.f21993i = null;
            this.f21985a = null;
            this.f21986b = null;
            this.f21994j = -1;
            this.f21987c = null;
            this.f21988d = null;
            this.f21989e = -1;
            this.f21990f = null;
        }

        public void r() {
            TabLayout tabLayout = this.f21992h;
            if (tabLayout != null) {
                tabLayout.R(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab s(@StringRes int i2) {
            TabLayout tabLayout = this.f21992h;
            if (tabLayout != null) {
                return t(tabLayout.getResources().getText(i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab t(@Nullable CharSequence charSequence) {
            this.f21988d = charSequence;
            E();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab u(@LayoutRes int i2) {
            return v(LayoutInflater.from(this.f21993i.getContext()).inflate(i2, this.f21993i, false));
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab v(@Nullable View view) {
            this.f21990f = view;
            E();
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab w(@DrawableRes int i2) {
            TabLayout tabLayout = this.f21992h;
            if (tabLayout != null) {
                return x(AppCompatResources.b(tabLayout.getContext(), i2));
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab x(@Nullable Drawable drawable) {
            this.f21986b = drawable;
            TabLayout tabLayout = this.f21992h;
            if (tabLayout.w3 == 1 || tabLayout.z3 == 2) {
                tabLayout.c0(true);
            }
            E();
            if (BadgeUtils.f20839a && this.f21993i.o() && this.f21993i.a3.isVisible()) {
                this.f21993i.invalidate();
            }
            return this;
        }

        @NonNull
        @CanIgnoreReturnValue
        public Tab y(int i2) {
            this.f21994j = i2;
            TabView tabView = this.f21993i;
            if (tabView != null) {
                tabView.setId(i2);
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        public void z(int i2) {
            this.f21989e = i2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorAnimationMode {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TabIndicatorGravity {
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f21995a;

        /* renamed from: b  reason: collision with root package name */
        private int f21996b;

        /* renamed from: c  reason: collision with root package name */
        private int f21997c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f21995a = new WeakReference<>(tabLayout);
        }

        public void a(int i2, float f2, int i3) {
            TabLayout tabLayout = this.f21995a.get();
            if (tabLayout != null) {
                int i4 = this.f21997c;
                tabLayout.W(i2, f2, i4 != 2 || this.f21996b == 1, (i4 == 2 && this.f21996b == 0) ? false : true, false);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f21997c = 0;
            this.f21996b = 0;
        }

        public void c(int i2) {
            this.f21996b = this.f21997c;
            this.f21997c = i2;
            TabLayout tabLayout = this.f21995a.get();
            if (tabLayout != null) {
                tabLayout.d0(this.f21997c);
            }
        }

        public void d(int i2) {
            TabLayout tabLayout = this.f21995a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f21997c;
                tabLayout.S(tabLayout.D(i2), i3 == 0 || (i3 == 2 && this.f21996b == 0));
            }
        }
    }

    public final class TabView extends LinearLayout {
        private TextView X2;
        private ImageView Y2;
        @Nullable
        private View Z2;
        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable a3;
        @Nullable
        private View b3;
        @Nullable
        private TextView c3;
        @Nullable
        private ImageView d3;
        @Nullable
        private Drawable e3;
        private int f3 = 2;
        private Tab s;

        public TabView(@NonNull Context context) {
            super(context);
            y(context);
            ViewCompat.n2(this, TabLayout.this.a3, TabLayout.this.b3, TabLayout.this.c3, TabLayout.this.d3);
            setGravity(17);
            setOrientation(TabLayout.this.A3 ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.q2(this, PointerIconCompat.c(getContext(), 1002));
        }

        private void B(@Nullable TextView textView, @Nullable ImageView imageView, boolean z) {
            Tab tab = this.s;
            CharSequence charSequence = null;
            Drawable mutate = (tab == null || tab.h() == null) ? null : DrawableCompat.r(this.s.h()).mutate();
            if (mutate != null) {
                DrawableCompat.o(mutate, TabLayout.this.i3);
                PorterDuff.Mode mode = TabLayout.this.m3;
                if (mode != null) {
                    DrawableCompat.p(mutate, mode);
                }
            }
            Tab tab2 = this.s;
            CharSequence n2 = tab2 != null ? tab2.n() : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(n2);
            if (textView != null) {
                if (!z3 || this.s.f21991g != 1) {
                    z2 = false;
                }
                textView.setText(z3 ? n2 : null);
                textView.setVisibility(z2 ? 0 : 8);
                if (z3) {
                    setVisibility(0);
                }
            } else {
                z2 = false;
            }
            if (z && imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int i2 = (!z2 || imageView.getVisibility() != 0) ? 0 : (int) ViewUtils.i(getContext(), 8);
                if (TabLayout.this.A3) {
                    if (i2 != MarginLayoutParamsCompat.b(marginLayoutParams)) {
                        MarginLayoutParamsCompat.g(marginLayoutParams, i2);
                        marginLayoutParams.bottomMargin = 0;
                    }
                } else if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    MarginLayoutParamsCompat.g(marginLayoutParams, 0);
                }
                imageView.setLayoutParams(marginLayoutParams);
                imageView.requestLayout();
            }
            Tab tab3 = this.s;
            if (tab3 != null) {
                charSequence = tab3.f21988d;
            }
            if (Build.VERSION.SDK_INT > 23) {
                if (!z3) {
                    n2 = charSequence;
                }
                TooltipCompat.a(this, n2);
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public BadgeDrawable getBadge() {
            return this.a3;
        }

        /* access modifiers changed from: private */
        @NonNull
        public BadgeDrawable getOrCreateBadge() {
            if (this.a3 == null) {
                this.a3 = BadgeDrawable.f(getContext());
            }
            v();
            BadgeDrawable badgeDrawable = this.a3;
            if (badgeDrawable != null) {
                return badgeDrawable;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        private void i(@Nullable final View view) {
            if (view != null) {
                view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        if (view.getVisibility() == 0) {
                            TabView.this.w(view);
                        }
                    }
                });
            }
        }

        private float j(@NonNull Layout layout2, int i2, float f2) {
            return layout2.getLineWidth(i2) * (f2 / layout2.getPaint().getTextSize());
        }

        private void k(boolean z) {
            setClipChildren(z);
            setClipToPadding(z);
            ViewGroup viewGroup = (ViewGroup) getParent();
            if (viewGroup != null) {
                viewGroup.setClipChildren(z);
                viewGroup.setClipToPadding(z);
            }
        }

        @NonNull
        private FrameLayout l() {
            FrameLayout frameLayout = new FrameLayout(getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            return frameLayout;
        }

        /* access modifiers changed from: private */
        public void m(@NonNull Canvas canvas) {
            Drawable drawable = this.e3;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.e3.draw(canvas);
            }
        }

        @Nullable
        private FrameLayout n(@NonNull View view) {
            if ((view == this.Y2 || view == this.X2) && BadgeUtils.f20839a) {
                return (FrameLayout) view.getParent();
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean o() {
            return this.a3 != null;
        }

        private void p() {
            ViewGroup viewGroup;
            if (BadgeUtils.f20839a) {
                viewGroup = l();
                addView(viewGroup, 0);
            } else {
                viewGroup = this;
            }
            ImageView imageView = (ImageView) LayoutInflater.from(getContext()).inflate(R.layout.H, viewGroup, false);
            this.Y2 = imageView;
            viewGroup.addView(imageView, 0);
        }

        private void q() {
            ViewGroup viewGroup;
            if (BadgeUtils.f20839a) {
                viewGroup = l();
                addView(viewGroup);
            } else {
                viewGroup = this;
            }
            TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(R.layout.I, viewGroup, false);
            this.X2 = textView;
            viewGroup.addView(textView);
        }

        /* access modifiers changed from: private */
        public void r() {
            if (this.Z2 != null) {
                u();
            }
            this.a3 = null;
        }

        private void t(@Nullable View view) {
            if (o() && view != null) {
                k(false);
                BadgeUtils.d(this.a3, view, n(view));
                this.Z2 = view;
            }
        }

        private void u() {
            if (o()) {
                k(true);
                View view = this.Z2;
                if (view != null) {
                    BadgeUtils.j(this.a3, view);
                    this.Z2 = null;
                }
            }
        }

        private void v() {
            Tab tab;
            View view;
            View view2;
            Tab tab2;
            if (o()) {
                if (this.b3 == null) {
                    if (this.Y2 != null && (tab2 = this.s) != null && tab2.h() != null) {
                        View view3 = this.Z2;
                        view = this.Y2;
                        if (view3 != view) {
                            u();
                            view2 = this.Y2;
                        }
                        w(view);
                        return;
                    } else if (!(this.X2 == null || (tab = this.s) == null || tab.l() != 1)) {
                        View view4 = this.Z2;
                        view = this.X2;
                        if (view4 != view) {
                            u();
                            view2 = this.X2;
                        }
                        w(view);
                        return;
                    }
                    t(view2);
                    return;
                }
                u();
            }
        }

        /* access modifiers changed from: private */
        public void w(@NonNull View view) {
            if (o() && view == this.Z2) {
                BadgeUtils.m(this.a3, view, n(view));
            }
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void y(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.q3
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.b(r6, r0)
                r5.e3 = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.e3
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.e3 = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.j3
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.j3
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.a(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.E3
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.ViewCompat.P1(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.y(android.content.Context):void");
        }

        /* access modifiers changed from: package-private */
        public final void A() {
            TextView textView;
            int c2;
            ViewParent parent;
            Tab tab = this.s;
            ImageView imageView = null;
            View g2 = tab != null ? tab.g() : null;
            if (g2 != null) {
                ViewParent parent2 = g2.getParent();
                if (parent2 != this) {
                    if (parent2 != null) {
                        ((ViewGroup) parent2).removeView(g2);
                    }
                    View view = this.b3;
                    if (!(view == null || (parent = view.getParent()) == null)) {
                        ((ViewGroup) parent).removeView(this.b3);
                    }
                    addView(g2);
                }
                this.b3 = g2;
                TextView textView2 = this.X2;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                }
                ImageView imageView2 = this.Y2;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.Y2.setImageDrawable((Drawable) null);
                }
                TextView textView3 = (TextView) g2.findViewById(16908308);
                this.c3 = textView3;
                if (textView3 != null) {
                    this.f3 = TextViewCompat.k(textView3);
                }
                imageView = (ImageView) g2.findViewById(16908294);
            } else {
                View view2 = this.b3;
                if (view2 != null) {
                    removeView(view2);
                    this.b3 = null;
                }
                this.c3 = null;
            }
            this.d3 = imageView;
            if (this.b3 == null) {
                if (this.Y2 == null) {
                    p();
                }
                if (this.X2 == null) {
                    q();
                    this.f3 = TextViewCompat.k(this.X2);
                }
                TextViewCompat.D(this.X2, TabLayout.this.e3);
                if (!isSelected() || TabLayout.this.g3 == -1) {
                    textView = this.X2;
                    c2 = TabLayout.this.f3;
                } else {
                    textView = this.X2;
                    c2 = TabLayout.this.g3;
                }
                TextViewCompat.D(textView, c2);
                ColorStateList colorStateList = TabLayout.this.h3;
                if (colorStateList != null) {
                    this.X2.setTextColor(colorStateList);
                }
                B(this.X2, this.Y2, true);
                v();
                i(this.Y2);
                i(this.X2);
            } else {
                TextView textView4 = this.c3;
                if (!(textView4 == null && this.d3 == null)) {
                    B(textView4, this.d3, false);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.f21988d)) {
                setContentDescription(tab.f21988d);
            }
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.e3;
            if ((drawable == null || !drawable.isStateful()) ? false : this.e3.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public int getContentHeight() {
            View[] viewArr = {this.X2, this.Y2, this.b3};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getTop()) : view.getTop();
                    i2 = z ? Math.max(i2, view.getBottom()) : view.getBottom();
                    z = true;
                }
            }
            return i2 - i3;
        }

        /* access modifiers changed from: package-private */
        public int getContentWidth() {
            View[] viewArr = {this.X2, this.Y2, this.b3};
            int i2 = 0;
            int i3 = 0;
            boolean z = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    i3 = z ? Math.min(i3, view.getLeft()) : view.getLeft();
                    i2 = z ? Math.max(i2, view.getRight()) : view.getRight();
                    z = true;
                }
            }
            return i2 - i3;
        }

        @Nullable
        public Tab getTab() {
            return this.s;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            AccessibilityNodeInfoCompat r2 = AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo);
            BadgeDrawable badgeDrawable = this.a3;
            if (badgeDrawable != null && badgeDrawable.isVisible()) {
                r2.o1(this.a3.r());
            }
            r2.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(0, 1, this.s.k(), 1, false, isSelected()));
            if (isSelected()) {
                r2.k1(false);
                r2.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6657j);
            }
            r2.V1(getResources().getString(R.string.a0));
        }

        public void onMeasure(int i2, int i3) {
            Layout layout2;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.r3, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.X2 != null) {
                float f2 = TabLayout.this.n3;
                int i4 = this.f3;
                ImageView imageView = this.Y2;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.X2;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.p3;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.X2.getTextSize();
                int lineCount = this.X2.getLineCount();
                int k2 = TextViewCompat.k(this.X2);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 == 0 && (k2 < 0 || i4 == k2)) {
                    return;
                }
                if (TabLayout.this.z3 != 1 || i5 <= 0 || lineCount != 1 || ((layout2 = this.X2.getLayout()) != null && j(layout2, 0, f2) <= ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                    this.X2.setTextSize(0, f2);
                    this.X2.setMaxLines(i4);
                    super.onMeasure(i2, i3);
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.s == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.s.r();
            return true;
        }

        /* access modifiers changed from: package-private */
        public void s() {
            setTab((Tab) null);
            setSelected(false);
        }

        public void setSelected(boolean z) {
            isSelected();
            super.setSelected(z);
            TextView textView = this.X2;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.Y2;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.b3;
            if (view != null) {
                view.setSelected(z);
            }
        }

        /* access modifiers changed from: package-private */
        public void setTab(@Nullable Tab tab) {
            if (tab != this.s) {
                this.s = tab;
                x();
            }
        }

        /* access modifiers changed from: package-private */
        public final void x() {
            A();
            Tab tab = this.s;
            setSelected(tab != null && tab.o());
        }

        /* access modifiers changed from: package-private */
        public final void z() {
            setOrientation(TabLayout.this.A3 ^ true ? 1 : 0);
            TextView textView = this.c3;
            if (textView == null && this.d3 == null) {
                B(this.X2, this.Y2, true);
            } else {
                B(textView, this.d3, false);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f21998a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f21998a = viewPager;
        }

        public void a(Tab tab) {
        }

        public void b(@NonNull Tab tab) {
            this.f21998a.setCurrentItem(tab.k());
        }

        public void c(Tab tab) {
        }
    }

    public TabLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void A(@NonNull Tab tab) {
        for (int size = this.I3.size() - 1; size >= 0; size--) {
            this.I3.get(size).b(tab);
        }
    }

    private void B(@NonNull Tab tab) {
        for (int size = this.I3.size() - 1; size >= 0; size--) {
            this.I3.get(size).c(tab);
        }
    }

    private void C() {
        if (this.K3 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.K3 = valueAnimator;
            valueAnimator.setInterpolator(this.G3);
            this.K3.setDuration((long) this.x3);
            this.K3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    private boolean G() {
        return getTabMode() == 0 || getTabMode() == 2;
    }

    private void Q(int i2) {
        TabView tabView = (TabView) this.Z2.getChildAt(i2);
        this.Z2.removeViewAt(i2);
        if (tabView != null) {
            tabView.s();
            this.S3.c(tabView);
        }
        requestLayout();
    }

    private void Z(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.L3;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.O3;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.O(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.P3;
            if (adapterChangeListener != null) {
                this.L3.N(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.J3;
        if (baseOnTabSelectedListener != null) {
            M(baseOnTabSelectedListener);
            this.J3 = null;
        }
        if (viewPager != null) {
            this.L3 = viewPager;
            if (this.O3 == null) {
                this.O3 = new TabLayoutOnPageChangeListener(this);
            }
            this.O3.b();
            viewPager.c(this.O3);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.J3 = viewPagerOnTabSelectedListener;
            g(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                T(adapter, z);
            }
            if (this.P3 == null) {
                this.P3 = new AdapterChangeListener();
            }
            this.P3.a(z);
            viewPager.b(this.P3);
            U(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.L3 = null;
            T((PagerAdapter) null, false);
        }
        this.Q3 = z2;
    }

    private void a0() {
        int size = this.X2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.X2.get(i2).E();
        }
    }

    private void b0(@NonNull LinearLayout.LayoutParams layoutParams) {
        float f2;
        if (this.z3 == 1 && this.w3 == 0) {
            layoutParams.width = 0;
            f2 = 1.0f;
        } else {
            layoutParams.width = -2;
            f2 = 0.0f;
        }
        layoutParams.weight = f2;
    }

    @Dimension(unit = 0)
    private int getDefaultHeight() {
        int size = this.X2.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            Tab tab = this.X2.get(i2);
            if (tab == null || tab.h() == null || TextUtils.isEmpty(tab.n())) {
                i2++;
            } else if (!this.A3) {
                return 72;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i2 = this.s3;
        if (i2 != -1) {
            return i2;
        }
        int i5 = this.z3;
        if (i5 == 0 || i5 == 2) {
            return this.u3;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.Z2.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void m(@NonNull TabItem tabItem) {
        Tab I = I();
        CharSequence charSequence = tabItem.s;
        if (charSequence != null) {
            I.D(charSequence);
        }
        Drawable drawable = tabItem.X2;
        if (drawable != null) {
            I.x(drawable);
        }
        int i2 = tabItem.Y2;
        if (i2 != 0) {
            I.u(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            I.t(tabItem.getContentDescription());
        }
        i(I);
    }

    private void n(@NonNull Tab tab) {
        TabView tabView = tab.f21993i;
        tabView.setSelected(false);
        tabView.setActivated(false);
        this.Z2.addView(tabView, tab.k(), w());
    }

    private void o(View view) {
        if (view instanceof TabItem) {
            m((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void p(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !ViewCompat.Y0(this) || this.Z2.d()) {
                U(i2, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int s2 = s(i2, 0.0f);
            if (scrollX != s2) {
                C();
                this.K3.setIntValues(new int[]{scrollX, s2});
                this.K3.start();
            }
            this.Z2.c(i2, this.x3);
        }
    }

    private void q(int i2) {
        SlidingTabIndicator slidingTabIndicator;
        int i5;
        if (i2 != 0) {
            i5 = 1;
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                slidingTabIndicator = this.Z2;
                i5 = GravityCompat.f6387b;
            } else {
                slidingTabIndicator = this.Z2;
            }
        } else {
            Log.w(d4, "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
            slidingTabIndicator = this.Z2;
            i5 = GravityCompat.f6387b;
        }
        slidingTabIndicator.setGravity(i5);
    }

    private void r() {
        int i2 = this.z3;
        ViewCompat.n2(this.Z2, (i2 == 0 || i2 == 2) ? Math.max(0, this.v3 - this.a3) : 0, 0, 0, 0);
        int i5 = this.z3;
        if (i5 == 0) {
            q(this.w3);
        } else if (i5 == 1 || i5 == 2) {
            if (this.w3 == 2) {
                Log.w(d4, "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
            }
            this.Z2.setGravity(1);
        }
        c0(true);
    }

    private int s(int i2, float f2) {
        View childAt;
        int i5 = this.z3;
        int i6 = 0;
        if ((i5 != 0 && i5 != 2) || (childAt = this.Z2.getChildAt(i2)) == null) {
            return 0;
        }
        int i7 = i2 + 1;
        View childAt2 = i7 < this.Z2.getChildCount() ? this.Z2.getChildAt(i7) : null;
        int width = childAt.getWidth();
        if (childAt2 != null) {
            i6 = childAt2.getWidth();
        }
        int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
        int i8 = (int) (((float) (width + i6)) * 0.5f * f2);
        return ViewCompat.c0(this) == 0 ? left + i8 : left - i8;
    }

    private void setSelectedTabView(int i2) {
        int childCount = this.Z2.getChildCount();
        if (i2 < childCount) {
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = this.Z2.getChildAt(i5);
                boolean z = true;
                if ((i5 != i2 || childAt.isSelected()) && (i5 == i2 || !childAt.isSelected())) {
                    childAt.setSelected(i5 == i2);
                    if (i5 != i2) {
                        z = false;
                    }
                    childAt.setActivated(z);
                } else {
                    childAt.setSelected(i5 == i2);
                    if (i5 != i2) {
                        z = false;
                    }
                    childAt.setActivated(z);
                    if (childAt instanceof TabView) {
                        ((TabView) childAt).A();
                    }
                }
                i5++;
            }
        }
    }

    private void u(@NonNull Tab tab, int i2) {
        tab.z(i2);
        this.X2.add(i2, tab);
        int size = this.X2.size();
        int i5 = -1;
        for (int i6 = i2 + 1; i6 < size; i6++) {
            if (this.X2.get(i6).k() == this.s) {
                i5 = i6;
            }
            this.X2.get(i6).z(i6);
        }
        this.s = i5;
    }

    @NonNull
    private static ColorStateList v(int i2, int i5) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i5, i2});
    }

    @NonNull
    private LinearLayout.LayoutParams w() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        b0(layoutParams);
        return layoutParams;
    }

    @NonNull
    private TabView y(@NonNull Tab tab) {
        Pools.Pool<TabView> pool = this.S3;
        TabView b2 = pool != null ? pool.b() : null;
        if (b2 == null) {
            b2 = new TabView(getContext());
        }
        b2.setTab(tab);
        b2.setFocusable(true);
        b2.setMinimumWidth(getTabMinWidth());
        b2.setContentDescription(TextUtils.isEmpty(tab.f21988d) ? tab.f21987c : tab.f21988d);
        return b2;
    }

    private void z(@NonNull Tab tab) {
        for (int size = this.I3.size() - 1; size >= 0; size--) {
            this.I3.get(size).a(tab);
        }
    }

    @Nullable
    public Tab D(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.X2.get(i2);
    }

    public boolean E() {
        return this.E3;
    }

    public boolean F() {
        return this.A3;
    }

    public boolean H() {
        return this.B3;
    }

    @NonNull
    public Tab I() {
        Tab x = x();
        x.f21992h = this;
        x.f21993i = y(x);
        if (x.f21994j != -1) {
            x.f21993i.setId(x.f21994j);
        }
        return x;
    }

    /* access modifiers changed from: package-private */
    public void J() {
        int currentItem;
        L();
        PagerAdapter pagerAdapter = this.M3;
        if (pagerAdapter != null) {
            int e2 = pagerAdapter.e();
            for (int i2 = 0; i2 < e2; i2++) {
                l(I().D(this.M3.g(i2)), false);
            }
            ViewPager viewPager = this.L3;
            if (viewPager != null && e2 > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                R(D(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean K(Tab tab) {
        return c4.c(tab);
    }

    public void L() {
        for (int childCount = this.Z2.getChildCount() - 1; childCount >= 0; childCount--) {
            Q(childCount);
        }
        Iterator<Tab> it2 = this.X2.iterator();
        while (it2.hasNext()) {
            Tab next = it2.next();
            it2.remove();
            next.q();
            K(next);
        }
        this.Y2 = null;
    }

    @Deprecated
    public void M(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.I3.remove(baseOnTabSelectedListener);
    }

    public void N(@NonNull OnTabSelectedListener onTabSelectedListener) {
        M(onTabSelectedListener);
    }

    public void O(@NonNull Tab tab) {
        if (tab.f21992h == this) {
            P(tab.k());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void P(int i2) {
        Tab tab = this.Y2;
        int k2 = tab != null ? tab.k() : 0;
        Q(i2);
        Tab remove = this.X2.remove(i2);
        if (remove != null) {
            remove.q();
            K(remove);
        }
        int size = this.X2.size();
        int i5 = -1;
        for (int i6 = i2; i6 < size; i6++) {
            if (this.X2.get(i6).k() == this.s) {
                i5 = i6;
            }
            this.X2.get(i6).z(i6);
        }
        this.s = i5;
        if (k2 == i2) {
            R(this.X2.isEmpty() ? null : this.X2.get(Math.max(0, i2 - 1)));
        }
    }

    public void R(@Nullable Tab tab) {
        S(tab, true);
    }

    public void S(@Nullable Tab tab, boolean z) {
        Tab tab2 = this.Y2;
        if (tab2 != tab) {
            int k2 = tab != null ? tab.k() : -1;
            if (z) {
                if ((tab2 == null || tab2.k() == -1) && k2 != -1) {
                    U(k2, 0.0f, true);
                } else {
                    p(k2);
                }
                if (k2 != -1) {
                    setSelectedTabView(k2);
                }
            }
            this.Y2 = tab;
            if (!(tab2 == null || tab2.f21992h == null)) {
                B(tab2);
            }
            if (tab != null) {
                A(tab);
            }
        } else if (tab2 != null) {
            z(tab);
            p(tab.k());
        }
    }

    /* access modifiers changed from: package-private */
    public void T(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.M3;
        if (!(pagerAdapter2 == null || (dataSetObserver = this.N3) == null)) {
            pagerAdapter2.u(dataSetObserver);
        }
        this.M3 = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.N3 == null) {
                this.N3 = new PagerAdapterObserver();
            }
            pagerAdapter.m(this.N3);
        }
        J();
    }

    public void U(int i2, float f2, boolean z) {
        V(i2, f2, z, true);
    }

    public void V(int i2, float f2, boolean z, boolean z2) {
        W(i2, f2, z, z2, true);
    }

    /* access modifiers changed from: package-private */
    public void W(int i2, float f2, boolean z, boolean z2, boolean z4) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.Z2.getChildCount()) {
            if (z2) {
                this.Z2.h(i2, f2);
            }
            ValueAnimator valueAnimator = this.K3;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.K3.cancel();
            }
            int s2 = s(i2, f2);
            int scrollX = getScrollX();
            boolean z5 = (i2 < getSelectedTabPosition() && s2 >= scrollX) || (i2 > getSelectedTabPosition() && s2 <= scrollX) || i2 == getSelectedTabPosition();
            if (ViewCompat.c0(this) == 1) {
                z5 = (i2 < getSelectedTabPosition() && s2 <= scrollX) || (i2 > getSelectedTabPosition() && s2 >= scrollX) || i2 == getSelectedTabPosition();
            }
            if (z5 || this.R3 == 1 || z4) {
                if (i2 < 0) {
                    s2 = 0;
                }
                scrollTo(s2, 0);
            }
            if (z) {
                setSelectedTabView(round);
            }
        }
    }

    public void X(int i2, int i5) {
        setTabTextColors(v(i2, i5));
    }

    public void Y(@Nullable ViewPager viewPager, boolean z) {
        Z(viewPager, z, false);
    }

    public void addView(View view) {
        o(view);
    }

    /* access modifiers changed from: package-private */
    public void c0(boolean z) {
        for (int i2 = 0; i2 < this.Z2.getChildCount(); i2++) {
            View childAt = this.Z2.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            b0((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d0(int i2) {
        this.R3 = i2;
    }

    @Deprecated
    public void g(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.I3.contains(baseOnTabSelectedListener)) {
            this.I3.add(baseOnTabSelectedListener);
        }
    }

    public int getSelectedTabPosition() {
        Tab tab = this.Y2;
        if (tab != null) {
            return tab.k();
        }
        return -1;
    }

    public int getTabCount() {
        return this.X2.size();
    }

    public int getTabGravity() {
        return this.w3;
    }

    @Nullable
    public ColorStateList getTabIconTint() {
        return this.i3;
    }

    public int getTabIndicatorAnimationMode() {
        return this.D3;
    }

    public int getTabIndicatorGravity() {
        return this.y3;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.r3;
    }

    public int getTabMode() {
        return this.z3;
    }

    @Nullable
    public ColorStateList getTabRippleColor() {
        return this.j3;
    }

    @NonNull
    public Drawable getTabSelectedIndicator() {
        return this.k3;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.h3;
    }

    public void h(@NonNull OnTabSelectedListener onTabSelectedListener) {
        g(onTabSelectedListener);
    }

    public void i(@NonNull Tab tab) {
        l(tab, this.X2.isEmpty());
    }

    public void j(@NonNull Tab tab, int i2) {
        k(tab, i2, this.X2.isEmpty());
    }

    public void k(@NonNull Tab tab, int i2, boolean z) {
        if (tab.f21992h == this) {
            u(tab, i2);
            n(tab);
            if (z) {
                tab.r();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void l(@NonNull Tab tab, boolean z) {
        k(tab, this.X2.size(), z);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.e(this);
        if (this.L3 == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                Z((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.Q3) {
            setupWithViewPager((ViewPager) null);
            this.Q3 = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(@NonNull Canvas canvas) {
        for (int i2 = 0; i2 < this.Z2.getChildCount(); i2++) {
            View childAt = this.Z2.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).m(canvas);
            }
        }
        super.onDraw(canvas);
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo).l1(AccessibilityNodeInfoCompat.CollectionInfoCompat.f(1, getTabCount(), false, 1));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return G() && super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i5) {
        int round = Math.round(ViewUtils.i(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i5);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i5 = View.MeasureSpec.makeMeasureSpec(round + getPaddingTop() + getPaddingBottom(), 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i5) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0) {
            int i6 = this.t3;
            if (i6 <= 0) {
                i6 = (int) (((float) size) - ViewUtils.i(getContext(), 56));
            }
            this.r3 = i6;
        }
        super.onMeasure(i2, i5);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i7 = this.z3;
            if (i7 != 0) {
                if (i7 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
                } else if (i7 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i5, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 8 || G()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.d(this, f2);
    }

    public void setInlineLabel(boolean z) {
        if (this.A3 != z) {
            this.A3 = z;
            for (int i2 = 0; i2 < this.Z2.getChildCount(); i2++) {
                View childAt = this.Z2.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).z();
                }
            }
            r();
        }
    }

    public void setInlineLabelResource(@BoolRes int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.H3;
        if (baseOnTabSelectedListener2 != null) {
            M(baseOnTabSelectedListener2);
        }
        this.H3 = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            g(baseOnTabSelectedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        C();
        this.K3.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(@DrawableRes int i2) {
        setSelectedTabIndicator(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i2) {
        this.l3 = i2;
        DrawableUtils.n(this.k3, i2);
        c0(false);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.y3 != i2) {
            this.y3 = i2;
            ViewCompat.t1(this.Z2);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.C3 = i2;
        this.Z2.i(i2);
    }

    public void setTabGravity(int i2) {
        if (this.w3 != i2) {
            this.w3 = i2;
            r();
        }
    }

    public void setTabIconTint(@Nullable ColorStateList colorStateList) {
        if (this.i3 != colorStateList) {
            this.i3 = colorStateList;
            a0();
        }
    }

    public void setTabIconTintResource(@ColorRes int i2) {
        setTabIconTint(AppCompatResources.a(getContext(), i2));
    }

    public void setTabIndicatorAnimationMode(int i2) {
        TabIndicatorInterpolator tabIndicatorInterpolator;
        this.D3 = i2;
        if (i2 == 0) {
            tabIndicatorInterpolator = new TabIndicatorInterpolator();
        } else if (i2 == 1) {
            tabIndicatorInterpolator = new ElasticTabIndicatorInterpolator();
        } else if (i2 == 2) {
            tabIndicatorInterpolator = new FadeTabIndicatorInterpolator();
        } else {
            throw new IllegalArgumentException(i2 + " is not a valid TabIndicatorAnimationMode");
        }
        this.F3 = tabIndicatorInterpolator;
    }

    public void setTabIndicatorFullWidth(boolean z) {
        this.B3 = z;
        this.Z2.g();
        ViewCompat.t1(this.Z2);
    }

    public void setTabMode(int i2) {
        if (i2 != this.z3) {
            this.z3 = i2;
            r();
        }
    }

    public void setTabRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.j3 != colorStateList) {
            this.j3 = colorStateList;
            for (int i2 = 0; i2 < this.Z2.getChildCount(); i2++) {
                View childAt = this.Z2.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(@ColorRes int i2) {
        setTabRippleColor(AppCompatResources.a(getContext(), i2));
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.h3 != colorStateList) {
            this.h3 = colorStateList;
            a0();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        T(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z) {
        if (this.E3 != z) {
            this.E3 = z;
            for (int i2 = 0; i2 < this.Z2.getChildCount(); i2++) {
                View childAt = this.Z2.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).y(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(@BoolRes int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        Y(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public void t() {
        this.I3.clear();
    }

    /* access modifiers changed from: protected */
    public Tab x() {
        Tab b2 = c4.b();
        return b2 == null ? new Tab() : b2;
    }

    public TabLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f20606fi);
    }

    public void addView(View view, int i2) {
        o(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void setOnTabSelectedListener(@Nullable OnTabSelectedListener onTabSelectedListener) {
        setOnTabSelectedListener((BaseOnTabSelectedListener) onTabSelectedListener);
    }

    public void setSelectedTabIndicator(@Nullable Drawable drawable) {
        if (drawable == null) {
            drawable = new GradientDrawable();
        }
        Drawable mutate = DrawableCompat.r(drawable).mutate();
        this.k3 = mutate;
        DrawableUtils.n(mutate, this.l3);
        int i2 = this.C3;
        if (i2 == -1) {
            i2 = this.k3.getIntrinsicHeight();
        }
        this.Z2.i(i2);
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TabLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = T3
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = -1
            r10.s = r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.X2 = r0
            r10.g3 = r11
            r6 = 0
            r10.l3 = r6
            r0 = 2147483647(0x7fffffff, float:NaN)
            r10.r3 = r0
            r10.C3 = r11
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r10.I3 = r0
            androidx.core.util.Pools$SimplePool r0 = new androidx.core.util.Pools$SimplePool
            r1 = 12
            r0.<init>(r1)
            r10.S3 = r0
            android.content.Context r7 = r10.getContext()
            r10.setHorizontalScrollBarEnabled(r6)
            com.google.android.material.tabs.TabLayout$SlidingTabIndicator r8 = new com.google.android.material.tabs.TabLayout$SlidingTabIndicator
            r8.<init>(r7)
            r10.Z2 = r8
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r11)
            super.addView(r8, r6, r0)
            int[] r2 = com.google.android.material.R.styleable.xv
            int r9 = com.google.android.material.R.styleable.Wv
            int[] r5 = new int[]{r9}
            r0 = r7
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            android.graphics.drawable.Drawable r13 = r10.getBackground()
            android.content.res.ColorStateList r13 = com.google.android.material.drawable.DrawableUtils.g(r13)
            if (r13 == 0) goto L_0x0074
            com.google.android.material.shape.MaterialShapeDrawable r0 = new com.google.android.material.shape.MaterialShapeDrawable
            r0.<init>()
            r0.p0(r13)
            r0.a0(r7)
            float r13 = androidx.core.view.ViewCompat.T(r10)
            r0.o0(r13)
            androidx.core.view.ViewCompat.P1(r10, r0)
        L_0x0074:
            int r13 = com.google.android.material.R.styleable.Dv
            android.graphics.drawable.Drawable r13 = com.google.android.material.resources.MaterialResources.e(r7, r12, r13)
            r10.setSelectedTabIndicator((android.graphics.drawable.Drawable) r13)
            int r13 = com.google.android.material.R.styleable.Gv
            int r13 = r12.getColor(r13, r6)
            r10.setSelectedTabIndicatorColor(r13)
            int r13 = com.google.android.material.R.styleable.Jv
            int r13 = r12.getDimensionPixelSize(r13, r11)
            r8.i(r13)
            int r13 = com.google.android.material.R.styleable.Iv
            int r13 = r12.getInt(r13, r6)
            r10.setSelectedTabIndicatorGravity(r13)
            int r13 = com.google.android.material.R.styleable.Fv
            int r13 = r12.getInt(r13, r6)
            r10.setTabIndicatorAnimationMode(r13)
            int r13 = com.google.android.material.R.styleable.Hv
            r0 = 1
            boolean r13 = r12.getBoolean(r13, r0)
            r10.setTabIndicatorFullWidth(r13)
            int r13 = com.google.android.material.R.styleable.Ov
            int r13 = r12.getDimensionPixelSize(r13, r6)
            r10.d3 = r13
            r10.c3 = r13
            r10.b3 = r13
            r10.a3 = r13
            int r1 = com.google.android.material.R.styleable.Rv
            int r13 = r12.getDimensionPixelSize(r1, r13)
            r10.a3 = r13
            int r13 = com.google.android.material.R.styleable.Sv
            int r1 = r10.b3
            int r13 = r12.getDimensionPixelSize(r13, r1)
            r10.b3 = r13
            int r13 = com.google.android.material.R.styleable.Qv
            int r1 = r10.c3
            int r13 = r12.getDimensionPixelSize(r13, r1)
            r10.c3 = r13
            int r13 = com.google.android.material.R.styleable.Pv
            int r1 = r10.d3
            int r13 = r12.getDimensionPixelSize(r13, r1)
            r10.d3 = r13
            boolean r13 = com.google.android.material.internal.ThemeEnforcement.h(r7)
            if (r13 == 0) goto L_0x00ea
            int r13 = com.google.android.material.R.attr.Yi
        L_0x00e7:
            r10.e3 = r13
            goto L_0x00ed
        L_0x00ea:
            int r13 = com.google.android.material.R.attr.ti
            goto L_0x00e7
        L_0x00ed:
            int r13 = com.google.android.material.R.style.Y7
            int r13 = r12.getResourceId(r9, r13)
            r10.f3 = r13
            int[] r1 = androidx.appcompat.R.styleable.a6
            android.content.res.TypedArray r2 = r7.obtainStyledAttributes(r13, r1)
            int r3 = androidx.appcompat.R.styleable.b6     // Catch:{ all -> 0x020e }
            int r4 = r2.getDimensionPixelSize(r3, r6)     // Catch:{ all -> 0x020e }
            float r4 = (float) r4     // Catch:{ all -> 0x020e }
            r10.n3 = r4     // Catch:{ all -> 0x020e }
            int r4 = androidx.appcompat.R.styleable.e6     // Catch:{ all -> 0x020e }
            android.content.res.ColorStateList r5 = com.google.android.material.resources.MaterialResources.a(r7, r2, r4)     // Catch:{ all -> 0x020e }
            r10.h3 = r5     // Catch:{ all -> 0x020e }
            r2.recycle()
            int r2 = com.google.android.material.R.styleable.Uv
            boolean r5 = r12.hasValue(r2)
            if (r5 == 0) goto L_0x011d
            int r13 = r12.getResourceId(r2, r13)
            r10.g3 = r13
        L_0x011d:
            int r13 = r10.g3
            if (r13 == r11) goto L_0x015b
            android.content.res.TypedArray r13 = r7.obtainStyledAttributes(r13, r1)
            float r1 = r10.n3     // Catch:{ all -> 0x0151 }
            int r1 = (int) r1     // Catch:{ all -> 0x0151 }
            int r1 = r13.getDimensionPixelSize(r3, r1)     // Catch:{ all -> 0x0151 }
            float r1 = (float) r1     // Catch:{ all -> 0x0151 }
            r10.o3 = r1     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r7, r13, r4)     // Catch:{ all -> 0x0151 }
            if (r1 == 0) goto L_0x0153
            android.content.res.ColorStateList r2 = r10.h3     // Catch:{ all -> 0x0151 }
            int r2 = r2.getDefaultColor()     // Catch:{ all -> 0x0151 }
            r3 = 16842913(0x10100a1, float:2.369401E-38)
            int[] r3 = new int[]{r3}     // Catch:{ all -> 0x0151 }
            int r4 = r1.getDefaultColor()     // Catch:{ all -> 0x0151 }
            int r1 = r1.getColorForState(r3, r4)     // Catch:{ all -> 0x0151 }
            android.content.res.ColorStateList r1 = v(r2, r1)     // Catch:{ all -> 0x0151 }
            r10.h3 = r1     // Catch:{ all -> 0x0151 }
            goto L_0x0153
        L_0x0151:
            r11 = move-exception
            goto L_0x0157
        L_0x0153:
            r13.recycle()
            goto L_0x015b
        L_0x0157:
            r13.recycle()
            throw r11
        L_0x015b:
            int r13 = com.google.android.material.R.styleable.Xv
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x0169
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r7, r12, r13)
            r10.h3 = r13
        L_0x0169:
            int r13 = com.google.android.material.R.styleable.Vv
            boolean r1 = r12.hasValue(r13)
            if (r1 == 0) goto L_0x0181
            int r13 = r12.getColor(r13, r6)
            android.content.res.ColorStateList r1 = r10.h3
            int r1 = r1.getDefaultColor()
            android.content.res.ColorStateList r13 = v(r1, r13)
            r10.h3 = r13
        L_0x0181:
            int r13 = com.google.android.material.R.styleable.Bv
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r7, r12, r13)
            r10.i3 = r13
            int r13 = com.google.android.material.R.styleable.Cv
            int r13 = r12.getInt(r13, r11)
            r1 = 0
            android.graphics.PorterDuff$Mode r13 = com.google.android.material.internal.ViewUtils.u(r13, r1)
            r10.m3 = r13
            int r13 = com.google.android.material.R.styleable.Tv
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r7, r12, r13)
            r10.j3 = r13
            int r13 = com.google.android.material.R.styleable.Ev
            r1 = 300(0x12c, float:4.2E-43)
            int r13 = r12.getInt(r13, r1)
            r10.x3 = r13
            int r13 = com.google.android.material.R.attr.Vd
            android.animation.TimeInterpolator r1 = com.google.android.material.animation.AnimationUtils.f20767b
            android.animation.TimeInterpolator r13 = com.google.android.material.motion.MotionUtils.g(r7, r13, r1)
            r10.G3 = r13
            int r13 = com.google.android.material.R.styleable.Mv
            int r13 = r12.getDimensionPixelSize(r13, r11)
            r10.s3 = r13
            int r13 = com.google.android.material.R.styleable.Lv
            int r11 = r12.getDimensionPixelSize(r13, r11)
            r10.t3 = r11
            int r11 = com.google.android.material.R.styleable.yv
            int r11 = r12.getResourceId(r11, r6)
            r10.q3 = r11
            int r11 = com.google.android.material.R.styleable.zv
            int r11 = r12.getDimensionPixelSize(r11, r6)
            r10.v3 = r11
            int r11 = com.google.android.material.R.styleable.Nv
            int r11 = r12.getInt(r11, r0)
            r10.z3 = r11
            int r11 = com.google.android.material.R.styleable.Av
            int r11 = r12.getInt(r11, r6)
            r10.w3 = r11
            int r11 = com.google.android.material.R.styleable.Kv
            boolean r11 = r12.getBoolean(r11, r6)
            r10.A3 = r11
            int r11 = com.google.android.material.R.styleable.Yv
            boolean r11 = r12.getBoolean(r11, r6)
            r10.E3 = r11
            r12.recycle()
            android.content.res.Resources r11 = r10.getResources()
            int r12 = com.google.android.material.R.dimen.K1
            int r12 = r11.getDimensionPixelSize(r12)
            float r12 = (float) r12
            r10.p3 = r12
            int r12 = com.google.android.material.R.dimen.I1
            int r11 = r11.getDimensionPixelSize(r12)
            r10.u3 = r11
            r10.r()
            return
        L_0x020e:
            r11 = move-exception
            r2.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        o(view);
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        o(view);
    }
}
