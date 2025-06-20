package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    private static final int C3 = -1;
    private static final int[] D3 = {16842912};
    private static final ActiveIndicatorTransform E3 = new ActiveIndicatorTransform();
    private static final ActiveIndicatorTransform F3 = new ActiveIndicatorUnlabeledTransform();
    private int A3 = 0;
    @Nullable
    private BadgeDrawable B3;
    private ColorStateList X2;
    @Nullable
    Drawable Y2;
    private int Z2;
    private int a3;
    private int b3;
    private float c3;
    private float d3;
    private float e3;
    private int f3;
    private boolean g3;
    @Nullable
    private final FrameLayout h3;
    @Nullable
    private final View i3;
    /* access modifiers changed from: private */
    public final ImageView j3;
    private final ViewGroup k3;
    private final TextView l3;
    private final TextView m3;
    private int n3 = -1;
    @StyleRes
    private int o3 = 0;
    @Nullable
    private MenuItemImpl p3;
    @Nullable
    private ColorStateList q3;
    @Nullable
    private Drawable r3;
    private boolean s = false;
    @Nullable
    private Drawable s3;
    private ValueAnimator t3;
    private ActiveIndicatorTransform u3 = E3;
    private float v3 = 0.0f;
    private boolean w3 = false;
    private int x3 = 0;
    private int y3 = 0;
    private boolean z3 = false;

    private static class ActiveIndicatorTransform {

        /* renamed from: a  reason: collision with root package name */
        private static final float f21627a = 0.4f;

        /* renamed from: b  reason: collision with root package name */
        private static final float f21628b = 1.0f;

        /* renamed from: c  reason: collision with root package name */
        private static final float f21629c = 0.2f;

        private ActiveIndicatorTransform() {
        }

        /* access modifiers changed from: protected */
        public float a(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            int i2 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            return AnimationUtils.b(0.0f, 1.0f, i2 == 0 ? 0.8f : 0.0f, i2 == 0 ? 1.0f : 0.2f, f2);
        }

        /* access modifiers changed from: protected */
        public float b(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            return AnimationUtils.a(f21627a, 1.0f, f2);
        }

        /* access modifiers changed from: protected */
        public float c(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
            return 1.0f;
        }

        public void d(@FloatRange(from = 0.0d, to = 1.0d) float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3, @NonNull View view) {
            view.setScaleX(b(f2, f3));
            view.setScaleY(c(f2, f3));
            view.setAlpha(a(f2, f3));
        }
    }

    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super();
        }

        /* access modifiers changed from: protected */
        public float c(float f2, float f3) {
            return b(f2, f3);
        }
    }

    public NavigationBarItemView(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(getItemLayoutResId(), this, true);
        this.h3 = (FrameLayout) findViewById(R.id.F3);
        this.i3 = findViewById(R.id.E3);
        ImageView imageView = (ImageView) findViewById(R.id.G3);
        this.j3 = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.H3);
        this.k3 = viewGroup;
        TextView textView = (TextView) findViewById(R.id.J3);
        this.l3 = textView;
        TextView textView2 = (TextView) findViewById(R.id.I3);
        this.m3 = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.Z2 = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.a3 = viewGroup.getPaddingBottom();
        this.b3 = getResources().getDimensionPixelSize(R.dimen.F7);
        ViewCompat.Z1(textView, 2);
        ViewCompat.Z1(textView2, 2);
        setFocusable(true);
        i(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (NavigationBarItemView.this.j3.getVisibility() == 0) {
                        NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                        navigationBarItemView.y(navigationBarItemView.j3);
                    }
                }
            });
        }
    }

    private void A() {
        this.u3 = n() ? F3 : E3;
    }

    private static void B(@NonNull View view, int i2) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.h3;
        return frameLayout != null ? frameLayout : this.j3;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i4 = 0; i4 < indexOfChild; i4++) {
            View childAt = viewGroup.getChildAt(i4);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        return ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin + getIconOrContainer().getMeasuredHeight();
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.B3;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.B3.u();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.j3.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private void i(float f2, float f4) {
        this.c3 = f2 - f4;
        this.d3 = (f4 * 1.0f) / f2;
        this.e3 = (f2 * 1.0f) / f4;
    }

    private static Drawable k(@NonNull ColorStateList colorStateList) {
        return new RippleDrawable(RippleUtils.a(colorStateList), (Drawable) null, (Drawable) null);
    }

    @Nullable
    private FrameLayout l(View view) {
        ImageView imageView = this.j3;
        if (view != imageView || !BadgeUtils.f20839a) {
            return null;
        }
        return (FrameLayout) imageView.getParent();
    }

    private boolean m() {
        return this.B3 != null;
    }

    private boolean n() {
        return this.z3 && this.f3 == 2;
    }

    private void o(@FloatRange(from = 0.0d, to = 1.0d) final float f2) {
        if (!this.w3 || !this.s || !ViewCompat.R0(this)) {
            s(f2, f2);
            return;
        }
        ValueAnimator valueAnimator = this.t3;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t3 = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.v3, f2});
        this.t3 = ofFloat;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                NavigationBarItemView.this.s(((Float) valueAnimator.getAnimatedValue()).floatValue(), f2);
            }
        });
        this.t3.setInterpolator(MotionUtils.g(getContext(), R.attr.Vd, AnimationUtils.f20767b));
        this.t3.setDuration((long) MotionUtils.f(getContext(), R.attr.Fd, getResources().getInteger(R.integer.M)));
        this.t3.start();
    }

    private void p() {
        MenuItemImpl menuItemImpl = this.p3;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    private void q() {
        Drawable drawable = this.Y2;
        RippleDrawable rippleDrawable = null;
        boolean z = true;
        if (this.X2 != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.w3 && getActiveIndicatorDrawable() != null && this.h3 != null && activeIndicatorDrawable != null) {
                rippleDrawable = new RippleDrawable(RippleUtils.e(this.X2), (Drawable) null, activeIndicatorDrawable);
                z = false;
            } else if (drawable == null) {
                drawable = k(this.X2);
            }
        }
        FrameLayout frameLayout = this.h3;
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            this.h3.setForeground(rippleDrawable);
        }
        ViewCompat.P1(this, drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    /* access modifiers changed from: private */
    public void s(@FloatRange(from = 0.0d, to = 1.0d) float f2, float f4) {
        View view = this.i3;
        if (view != null) {
            this.u3.d(f2, f4, view);
        }
        this.v3 = f2;
    }

    private static void t(TextView textView, @StyleRes int i2) {
        TextViewCompat.D(textView, i2);
        int i4 = MaterialResources.i(textView.getContext(), i2, 0);
        if (i4 != 0) {
            textView.setTextSize(0, (float) i4);
        }
    }

    private static void u(@NonNull View view, float f2, float f4, int i2) {
        view.setScaleX(f2);
        view.setScaleY(f4);
        view.setVisibility(i2);
    }

    private static void v(@NonNull View view, int i2, int i4) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i4;
        view.setLayoutParams(layoutParams);
    }

    private void w(@Nullable View view) {
        if (m() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.d(this.B3, view, l(view));
        }
    }

    private void x(@Nullable View view) {
        if (m()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.j(this.B3, view);
            }
            this.B3 = null;
        }
    }

    /* access modifiers changed from: private */
    public void y(View view) {
        if (m()) {
            BadgeUtils.m(this.B3, view, l(view));
        }
    }

    /* access modifiers changed from: private */
    public void z(int i2) {
        if (this.i3 != null && i2 > 0) {
            int min = Math.min(this.x3, i2 - (this.A3 * 2));
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i3.getLayoutParams();
            layoutParams.height = n() ? min : this.y3;
            layoutParams.width = min;
            this.i3.setLayoutParams(layoutParams);
        }
    }

    public void c(boolean z, char c2) {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.h3;
        if (frameLayout != null && this.w3) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return true;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.i3;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.B3;
    }

    /* access modifiers changed from: protected */
    @DrawableRes
    public int getItemBackgroundResId() {
        return R.drawable.Z1;
    }

    @Nullable
    public MenuItemImpl getItemData() {
        return this.p3;
    }

    /* access modifiers changed from: protected */
    @DimenRes
    public int getItemDefaultMarginResId() {
        return R.dimen.Gc;
    }

    /* access modifiers changed from: protected */
    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.n3;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k3.getLayoutParams();
        return getSuggestedIconHeight() + (this.k3.getVisibility() == 0 ? this.b3 : 0) + layoutParams.topMargin + this.k3.getMeasuredHeight() + layoutParams.bottomMargin;
    }

    /* access modifiers changed from: protected */
    public int getSuggestedMinimumWidth() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.k3.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams.leftMargin + this.k3.getMeasuredWidth() + layoutParams.rightMargin);
    }

    public void h(@NonNull MenuItemImpl menuItemImpl, int i2) {
        this.p3 = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle();
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.a(this, tooltipText);
        }
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        this.s = true;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        r();
        this.p3 = null;
        this.v3 = 0.0f;
        this.s = false;
    }

    @NonNull
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.p3;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.p3.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, D3);
        }
        return onCreateDrawableState;
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.B3;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            CharSequence title = this.p3.getTitle();
            if (!TextUtils.isEmpty(this.p3.getContentDescription())) {
                title = this.p3.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(title + ", " + this.B3.r());
        }
        AccessibilityNodeInfoCompat r2 = AccessibilityNodeInfoCompat.r2(accessibilityNodeInfo);
        r2.m1(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.j(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            r2.k1(false);
            r2.V0(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f6657j);
        }
        r2.V1(getResources().getString(R.string.a0));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(final int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        post(new Runnable() {
            public void run() {
                NavigationBarItemView.this.z(i2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void r() {
        x(this.j3);
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.i3;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
            q();
        }
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.w3 = z;
        q();
        View view = this.i3;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i2) {
        this.y3 = i2;
        z(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i2) {
        if (this.b3 != i2) {
            this.b3 = i2;
            p();
        }
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i2) {
        this.A3 = i2;
        z(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.z3 = z;
    }

    public void setActiveIndicatorWidth(int i2) {
        this.x3 = i2;
        z(getWidth());
    }

    /* access modifiers changed from: package-private */
    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        if (this.B3 != badgeDrawable) {
            if (m() && this.j3 != null) {
                Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
                x(this.j3);
            }
            this.B3 = badgeDrawable;
            ImageView imageView = this.j3;
            if (imageView != null) {
                w(imageView);
            }
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0068, code lost:
        if (r9 != false) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0085, code lost:
        v(getIconOrContainer(), r8.Z2, 49);
        r1 = r8.m3;
        r2 = r8.e3;
        u(r1, r2, r2, 4);
        u(r8.l3, 1.0f, 1.0f, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00a1, code lost:
        if (r9 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a3, code lost:
        v(r0, r1, 49);
        B(r8.k3, r8.a3);
        r8.m3.setVisibility(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b3, code lost:
        v(r0, r1, 17);
        B(r8.k3, 0);
        r8.m3.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00c0, code lost:
        r8.l3.setVisibility(4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d0, code lost:
        if (r9 != false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00da, code lost:
        if (r9 != false) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setChecked(boolean r9) {
        /*
            r8 = this;
            android.widget.TextView r0 = r8.m3
            int r1 = r0.getWidth()
            r2 = 2
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r8.m3
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            android.widget.TextView r0 = r8.l3
            int r1 = r0.getWidth()
            int r1 = r1 / r2
            float r1 = (float) r1
            r0.setPivotX(r1)
            android.widget.TextView r0 = r8.l3
            int r1 = r0.getBaseline()
            float r1 = (float) r1
            r0.setPivotY(r1)
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r9 == 0) goto L_0x0032
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            r8.o(r1)
            int r1 = r8.f3
            r3 = -1
            r4 = 17
            r5 = 49
            r6 = 4
            r7 = 0
            if (r1 == r3) goto L_0x00c6
            if (r1 == 0) goto L_0x009b
            r3 = 1
            if (r1 == r3) goto L_0x0061
            if (r1 == r2) goto L_0x004a
            goto L_0x00dd
        L_0x004a:
            android.view.View r0 = r8.getIconOrContainer()
            int r1 = r8.Z2
            v(r0, r1, r4)
            android.widget.TextView r0 = r8.m3
            r1 = 8
            r0.setVisibility(r1)
            android.widget.TextView r0 = r8.l3
            r0.setVisibility(r1)
            goto L_0x00dd
        L_0x0061:
            android.view.ViewGroup r1 = r8.k3
            int r2 = r8.a3
            B(r1, r2)
            if (r9 == 0) goto L_0x0085
        L_0x006a:
            android.view.View r1 = r8.getIconOrContainer()
            int r2 = r8.Z2
            float r2 = (float) r2
            float r3 = r8.c3
            float r2 = r2 + r3
            int r2 = (int) r2
            v(r1, r2, r5)
            android.widget.TextView r1 = r8.m3
            u(r1, r0, r0, r7)
            android.widget.TextView r0 = r8.l3
            float r1 = r8.d3
            u(r0, r1, r1, r6)
            goto L_0x00dd
        L_0x0085:
            android.view.View r1 = r8.getIconOrContainer()
            int r2 = r8.Z2
            v(r1, r2, r5)
            android.widget.TextView r1 = r8.m3
            float r2 = r8.e3
            u(r1, r2, r2, r6)
            android.widget.TextView r1 = r8.l3
            u(r1, r0, r0, r7)
            goto L_0x00dd
        L_0x009b:
            android.view.View r0 = r8.getIconOrContainer()
            int r1 = r8.Z2
            if (r9 == 0) goto L_0x00b3
        L_0x00a3:
            v(r0, r1, r5)
            android.view.ViewGroup r0 = r8.k3
            int r1 = r8.a3
            B(r0, r1)
            android.widget.TextView r0 = r8.m3
            r0.setVisibility(r7)
            goto L_0x00c0
        L_0x00b3:
            v(r0, r1, r4)
            android.view.ViewGroup r0 = r8.k3
            B(r0, r7)
            android.widget.TextView r0 = r8.m3
            r0.setVisibility(r6)
        L_0x00c0:
            android.widget.TextView r0 = r8.l3
            r0.setVisibility(r6)
            goto L_0x00dd
        L_0x00c6:
            boolean r1 = r8.g3
            if (r1 == 0) goto L_0x00d3
            android.view.View r0 = r8.getIconOrContainer()
            int r1 = r8.Z2
            if (r9 == 0) goto L_0x00b3
            goto L_0x00a3
        L_0x00d3:
            android.view.ViewGroup r1 = r8.k3
            int r2 = r8.a3
            B(r1, r2)
            if (r9 == 0) goto L_0x0085
            goto L_0x006a
        L_0x00dd:
            r8.refreshDrawableState()
            r8.setSelected(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.setChecked(boolean):void");
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.l3.setEnabled(z);
        this.m3.setEnabled(z);
        this.j3.setEnabled(z);
        ViewCompat.q2(this, z ? PointerIconCompat.c(getContext(), 1002) : null);
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable != this.r3) {
            this.r3 = drawable;
            if (drawable != null) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = DrawableCompat.r(drawable).mutate();
                this.s3 = drawable;
                ColorStateList colorStateList = this.q3;
                if (colorStateList != null) {
                    DrawableCompat.o(drawable, colorStateList);
                }
            }
            this.j3.setImageDrawable(drawable);
        }
    }

    public void setIconSize(int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j3.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        this.j3.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.q3 = colorStateList;
        if (this.p3 != null && (drawable = this.s3) != null) {
            DrawableCompat.o(drawable, colorStateList);
            this.s3.invalidateSelf();
        }
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : ContextCompat.l(getContext(), i2));
    }

    public void setItemPaddingBottom(int i2) {
        if (this.a3 != i2) {
            this.a3 = i2;
            p();
        }
    }

    public void setItemPaddingTop(int i2) {
        if (this.Z2 != i2) {
            this.Z2 = i2;
            p();
        }
    }

    public void setItemPosition(int i2) {
        this.n3 = i2;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.X2 = colorStateList;
        q();
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f3 != i2) {
            this.f3 = i2;
            A();
            z(getWidth());
            p();
        }
    }

    public void setShifting(boolean z) {
        if (this.g3 != z) {
            this.g3 = z;
            p();
        }
    }

    public void setTextAppearanceActive(@StyleRes int i2) {
        this.o3 = i2;
        t(this.m3, i2);
        i(this.l3.getTextSize(), this.m3.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        setTextAppearanceActive(this.o3);
        TextView textView = this.m3;
        textView.setTypeface(textView.getTypeface(), z ? 1 : 0);
    }

    public void setTextAppearanceInactive(@StyleRes int i2) {
        t(this.l3, i2);
        i(this.l3.getTextSize(), this.m3.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.l3.setTextColor(colorStateList);
            this.m3.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.l3.setText(charSequence);
        this.m3.setText(charSequence);
        MenuItemImpl menuItemImpl = this.p3;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.p3;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.getTooltipText())) {
            charSequence = this.p3.getTooltipText();
        }
        if (Build.VERSION.SDK_INT > 23) {
            TooltipCompat.a(this, charSequence);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (!(drawable == null || drawable.getConstantState() == null)) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.Y2 = drawable;
        q();
    }
}
