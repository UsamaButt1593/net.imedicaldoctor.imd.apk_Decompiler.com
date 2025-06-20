package net.imedicaldoctor.imd.CollapsingToolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import net.imedicaldoctor.imd.CollapsingToolbar.ValueAnimatorCompat;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int u3 = 600;
    private final int X2;
    private Toolbar Y2;
    private View Z2;
    private View a3;
    private int b3;
    private int c3;
    private int d3;
    private int e3;
    private int f3;
    private final Rect g3;
    /* access modifiers changed from: private */
    public final CollapsingTextHelper h3;
    private boolean i3;
    private boolean j3;
    private Drawable k3;
    Drawable l3;
    private int m3;
    private boolean n3;
    private ValueAnimatorCompat o3;
    private long p3;
    private int q3;
    private AppBarLayout.OnOffsetChangedListener r3;
    private boolean s;
    int s3;
    WindowInsetsCompat t3;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: c  reason: collision with root package name */
        private static final float f29501c = 0.5f;

        /* renamed from: d  reason: collision with root package name */
        public static final int f29502d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final int f29503e = 1;

        /* renamed from: f  reason: collision with root package name */
        public static final int f29504f = 2;

        /* renamed from: a  reason: collision with root package name */
        int f29505a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f29506b = 0.5f;

        @RestrictTo({RestrictTo.Scope.GROUP_ID})
        @Retention(RetentionPolicy.SOURCE)
        @interface CollapseMode {
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public int a() {
            return this.f29505a;
        }

        public float b() {
            return this.f29506b;
        }

        public void c(int i2) {
            this.f29505a = i2;
        }

        public void d(float f2) {
            this.f29506b = f2;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.b8);
            this.f29505a = obtainStyledAttributes.getInt(0, 0);
            d(obtainStyledAttributes.getFloat(1, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void a(AppBarLayout appBarLayout, int i2) {
            int b2;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.s3 = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.t3;
            int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper i4 = CollapsingToolbarLayout.i(childAt);
                int i5 = layoutParams.f29505a;
                if (i5 == 1) {
                    b2 = MathUtils.b(-i2, 0, CollapsingToolbarLayout.this.h(childAt));
                } else if (i5 != 2) {
                } else {
                    b2 = Math.round(((float) (-i2)) * layoutParams.f29506b);
                }
                i4.g(b2);
            }
            CollapsingToolbarLayout.this.p();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.l3 != null && r > 0) {
                ViewCompat.t1(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.h3.U(((float) Math.abs(i2)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.h0(CollapsingToolbarLayout.this)) - r)));
        }
    }

    public CollapsingToolbarLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void b(int i2) {
        c();
        ValueAnimatorCompat valueAnimatorCompat = this.o3;
        if (valueAnimatorCompat == null) {
            ValueAnimatorCompat a2 = ViewUtils.a();
            this.o3 = a2;
            a2.j(this.p3);
            this.o3.m(i2 > this.m3 ? AnimationUtils.f29482c : AnimationUtils.f29483d);
            this.o3.b(new ValueAnimatorCompat.AnimatorUpdateListener() {
                public void a(ValueAnimatorCompat valueAnimatorCompat) {
                    CollapsingToolbarLayout.this.setScrimAlpha(valueAnimatorCompat.g());
                }
            });
        } else if (valueAnimatorCompat.i()) {
            this.o3.c();
        }
        this.o3.l(this.m3, i2);
        this.o3.n();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c() {
        /*
            r6 = this;
            boolean r0 = r6.s
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.Y2 = r0
            r6.Z2 = r0
            int r1 = r6.X2
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.Y2 = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.d(r1)
            r6.Z2 = r1
        L_0x001f:
            androidx.appcompat.widget.Toolbar r1 = r6.Y2
            r2 = 0
            if (r1 != 0) goto L_0x003c
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003a
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 == 0) goto L_0x0037
            r0 = r4
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003a:
            r6.Y2 = r0
        L_0x003c:
            r6.o()
            r6.s = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.imedicaldoctor.imd.CollapsingToolbar.CollapsingToolbarLayout.c():void");
    }

    private View d(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private static int g(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static ViewOffsetHelper i(View view) {
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(net.imedicaldoctor.imd.R.id.view_offset_helper);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(net.imedicaldoctor.imd.R.id.view_offset_helper, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean k(View view) {
        int i2 = this.b3;
        return i2 >= 0 && i2 == indexOfChild(view) + 1;
    }

    private void o() {
        View view;
        if (!this.i3 && (view = this.a3) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.a3);
            }
        }
        if (this.i3 && this.Y2 != null) {
            if (this.a3 == null) {
                this.a3 = new View(getContext());
            }
            if (this.a3.getParent() == null) {
                this.Y2.addView(this.a3, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        c();
        if (this.Y2 == null && (drawable = this.k3) != null && this.m3 > 0) {
            drawable.mutate().setAlpha(this.m3);
            this.k3.draw(canvas);
        }
        if (this.i3 && this.j3) {
            this.h3.h(canvas);
        }
        if (this.l3 != null && this.m3 > 0) {
            WindowInsetsCompat windowInsetsCompat = this.t3;
            int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
            if (r > 0) {
                this.l3.setBounds(0, -this.s3, getWidth(), r - this.s3);
                this.l3.mutate().setAlpha(this.m3);
                this.l3.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean drawChild = super.drawChild(canvas, view, j2);
        if (this.k3 == null || this.m3 <= 0 || !k(view)) {
            return drawChild;
        }
        this.k3.mutate().setAlpha(this.m3);
        this.k3.draw(canvas);
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.l3;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.k3;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.h3;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.Y(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.h3.m();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.h3.o();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.k3;
    }

    public int getExpandedTitleGravity() {
        return this.h3.s();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f3;
    }

    public int getExpandedTitleMarginEnd() {
        return this.e3;
    }

    public int getExpandedTitleMarginStart() {
        return this.c3;
    }

    public int getExpandedTitleMarginTop() {
        return this.d3;
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.h3.u();
    }

    public int getMaxLines() {
        return this.h3.w();
    }

    public long getScrimAnimationDuration() {
        return this.p3;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.q3;
        if (i2 >= 0) {
            return i2;
        }
        WindowInsetsCompat windowInsetsCompat = this.t3;
        int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
        int h0 = ViewCompat.h0(this);
        return h0 > 0 ? Math.min((h0 * 2) + r, getHeight()) : getHeight() / 3;
    }

    @Nullable
    public Drawable getStatusBarScrim() {
        return this.l3;
    }

    @Nullable
    public CharSequence getTitle() {
        if (this.i3) {
            return this.h3.x();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final int h(View view) {
        return ((getHeight() - i(view).b()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public boolean j() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat l(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.W(this) ? windowInsetsCompat : null;
        if (!ViewUtils.b(this.t3, windowInsetsCompat2)) {
            this.t3 = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    public void m(int i2, int i4, int i5, int i6) {
        this.c3 = i2;
        this.d3 = i4;
        this.e3 = i5;
        this.f3 = i6;
        requestLayout();
    }

    public void n(boolean z, boolean z2) {
        if (this.n3 != z) {
            int i2 = 0;
            if (z2) {
                if (z) {
                    i2 = 255;
                }
                b(i2);
            } else {
                if (z) {
                    i2 = 255;
                }
                setScrimAlpha(i2);
            }
            this.n3 = z;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.W1(this, ViewCompat.W((View) parent));
            if (this.r3 == null) {
                this.r3 = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).e(this.r3);
            ViewCompat.B1(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.r3;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).B(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        int i7;
        View view;
        View view2;
        super.onLayout(z, i2, i4, i5, i6);
        WindowInsetsCompat windowInsetsCompat = this.t3;
        if (windowInsetsCompat != null) {
            int r = windowInsetsCompat.r();
            int childCount = getChildCount();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (!ViewCompat.W(childAt) && childAt.getTop() < r) {
                    ViewCompat.j1(childAt, r);
                }
            }
        }
        if (this.i3 && (view2 = this.a3) != null) {
            boolean z2 = true;
            boolean z3 = ViewCompat.R0(view2) && this.a3.getVisibility() == 0;
            this.j3 = z3;
            if (z3) {
                if (ViewCompat.c0(this) != 1) {
                    z2 = false;
                }
                View view3 = this.Z2;
                if (view3 == null) {
                    view3 = this.Y2;
                }
                int h2 = h(view3);
                ViewGroupUtils.a(this, this.a3, this.g3);
                CollapsingTextHelper collapsingTextHelper = this.h3;
                int i9 = this.g3.left;
                Toolbar toolbar = this.Y2;
                int titleMarginEnd = i9 + (z2 ? toolbar.getTitleMarginEnd() : toolbar.getTitleMarginStart());
                int titleMarginTop = this.g3.top + h2 + this.Y2.getTitleMarginTop();
                int i10 = this.g3.right;
                Toolbar toolbar2 = this.Y2;
                collapsingTextHelper.G(titleMarginEnd, titleMarginTop, i10 + (z2 ? toolbar2.getTitleMarginStart() : toolbar2.getTitleMarginEnd()), (this.g3.bottom + h2) - this.Y2.getTitleMarginBottom());
                this.h3.N(z2 ? this.e3 : this.c3, this.g3.top + this.d3, (i5 - i2) - (z2 ? this.c3 : this.e3), (i6 - i4) - this.f3);
                this.h3.E();
            }
        }
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            i(getChildAt(i11)).e();
        }
        if (this.Y2 != null) {
            if (this.i3 && TextUtils.isEmpty(this.h3.x())) {
                this.h3.Z(this.Y2.getTitle());
            }
            View view4 = this.Z2;
            if (view4 == null || view4 == this) {
                setMinimumHeight(g(this.Y2));
                view = this.Y2;
            } else {
                setMinimumHeight(g(view4));
                view = this.Z2;
            }
            i7 = indexOfChild(view);
        } else {
            i7 = -1;
        }
        this.b3 = i7;
        p();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        c();
        super.onMeasure(i2, i4);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        Drawable drawable = this.k3;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void p() {
        if (this.k3 != null || this.l3 != null) {
            setScrimsShown(getHeight() + this.s3 < getScrimVisibleHeightTrigger());
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.h3.K(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.h3.H(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.h3.M(typeface);
    }

    public void setContentScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.k3;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.k3 = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.k3.setCallback(this);
                this.k3.setAlpha(this.m3);
            }
            ViewCompat.t1(this);
        }
    }

    public void setContentScrimColor(@ColorInt int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(@DrawableRes int i2) {
        setContentScrim(ContextCompat.l(getContext(), i2));
    }

    public void setExpandedTitleColor(@ColorInt int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.h3.R(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.e3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.c3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.d3 = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.h3.O(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.h3.Q(colorStateList);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.h3.T(typeface);
    }

    public void setMaxLines(int i2) {
        this.h3.W(i2);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.m3) {
            if (!(this.k3 == null || (toolbar = this.Y2) == null)) {
                ViewCompat.t1(toolbar);
            }
            this.m3 = i2;
            ViewCompat.t1(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.p3 = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.q3 != i2) {
            this.q3 = i2;
            p();
        }
    }

    public void setScrimsShown(boolean z) {
        n(z, ViewCompat.Y0(this) && !isInEditMode());
    }

    public void setStatusBarScrim(@Nullable Drawable drawable) {
        Drawable drawable2 = this.l3;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.l3 = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.l3.setState(getDrawableState());
                }
                DrawableCompat.m(this.l3, ViewCompat.c0(this));
                this.l3.setVisible(getVisibility() == 0, false);
                this.l3.setCallback(this);
                this.l3.setAlpha(this.m3);
            }
            ViewCompat.t1(this);
        }
    }

    public void setStatusBarScrimColor(@ColorInt int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(@DrawableRes int i2) {
        setStatusBarScrim(ContextCompat.l(getContext(), i2));
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.h3.Z(charSequence);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.i3) {
            this.i3 = z;
            o();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.l3;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.l3.setVisible(z, false);
        }
        Drawable drawable2 = this.k3;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.k3.setVisible(z, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.k3 || drawable == this.l3;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.h3.J(colorStateList);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.s = true;
        this.g3 = new Rect();
        this.q3 = -1;
        ThemeUtils.a(context);
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.h3 = collapsingTextHelper;
        collapsingTextHelper.a0(AnimationUtils.f29484e);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.C7, i2, net.imedicaldoctor.imd.R.style.Widget_Design_MultilineCollapsingToolbar);
        collapsingTextHelper.R(obtainStyledAttributes.getInt(4, 8388691));
        collapsingTextHelper.K(obtainStyledAttributes.getInt(0, 8388627));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, 0);
        this.f3 = dimensionPixelSize;
        this.e3 = dimensionPixelSize;
        this.d3 = dimensionPixelSize;
        this.c3 = dimensionPixelSize;
        if (obtainStyledAttributes.hasValue(8)) {
            this.c3 = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        }
        if (obtainStyledAttributes.hasValue(7)) {
            this.e3 = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        }
        if (obtainStyledAttributes.hasValue(9)) {
            this.d3 = obtainStyledAttributes.getDimensionPixelSize(9, 0);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.f3 = obtainStyledAttributes.getDimensionPixelSize(6, 0);
        }
        this.i3 = obtainStyledAttributes.getBoolean(20, true);
        setTitle(obtainStyledAttributes.getText(18));
        collapsingTextHelper.O(2132017675);
        collapsingTextHelper.H(net.imedicaldoctor.imd.R.style.ActionBar_Title);
        if (obtainStyledAttributes.hasValue(10)) {
            collapsingTextHelper.O(obtainStyledAttributes.getResourceId(10, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            collapsingTextHelper.H(obtainStyledAttributes.getResourceId(1, 0));
        }
        this.q3 = obtainStyledAttributes.getDimensionPixelSize(16, -1);
        this.p3 = (long) obtainStyledAttributes.getInt(15, 600);
        setContentScrim(obtainStyledAttributes.getDrawable(3));
        setStatusBarScrim(obtainStyledAttributes.getDrawable(17));
        this.X2 = obtainStyledAttributes.getResourceId(23, -1);
        obtainStyledAttributes.recycle();
        setWillNotDraw(false);
        ViewCompat.k2(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.l(windowInsetsCompat);
            }
        });
        collapsingTextHelper.W(context.obtainStyledAttributes(attributeSet, net.imedicaldoctor.imd.R.styleable.y9, i2, 0).getInteger(0, 3));
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
