package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    private static final int B3 = R.style.Oe;
    private static final int C3 = 600;
    public static final int D3 = 0;
    public static final int E3 = 1;
    private boolean A3;
    private int X2;
    @Nullable
    private ViewGroup Y2;
    @Nullable
    private View Z2;
    private View a3;
    private int b3;
    private int c3;
    private int d3;
    private int e3;
    private final Rect f3;
    @NonNull
    final CollapsingTextHelper g3;
    @NonNull
    final ElevationOverlayProvider h3;
    private boolean i3;
    private boolean j3;
    @Nullable
    private Drawable k3;
    @Nullable
    Drawable l3;
    private int m3;
    private boolean n3;
    private ValueAnimator o3;
    private long p3;
    private final TimeInterpolator q3;
    private final TimeInterpolator r3;
    private boolean s;
    private int s3;
    private AppBarLayout.OnOffsetChangedListener t3;
    int u3;
    private int v3;
    @Nullable
    WindowInsetsCompat w3;
    private int x3;
    private boolean y3;
    private int z3;

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: c  reason: collision with root package name */
        private static final float f20812c = 0.5f;

        /* renamed from: d  reason: collision with root package name */
        public static final int f20813d = 0;

        /* renamed from: e  reason: collision with root package name */
        public static final int f20814e = 1;

        /* renamed from: f  reason: collision with root package name */
        public static final int f20815f = 2;

        /* renamed from: a  reason: collision with root package name */
        int f20816a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f20817b = 0.5f;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public int a() {
            return this.f20816a;
        }

        public float b() {
            return this.f20817b;
        }

        public void c(int i2) {
            this.f20816a = i2;
        }

        public void d(float f2) {
            this.f20817b = f2;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.b8);
            this.f20816a = obtainStyledAttributes.getInt(R.styleable.c8, 0);
            d(obtainStyledAttributes.getFloat(R.styleable.d8, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(@NonNull ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull FrameLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(@NonNull LayoutParams layoutParams) {
            super(layoutParams);
            this.f20816a = layoutParams.f20816a;
            this.f20817b = layoutParams.f20817b;
        }
    }

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void a(AppBarLayout appBarLayout, int i2) {
            int e2;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.u3 = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.w3;
            int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper k2 = CollapsingToolbarLayout.k(childAt);
                int i4 = layoutParams.f20816a;
                if (i4 == 1) {
                    e2 = MathUtils.e(-i2, 0, CollapsingToolbarLayout.this.i(childAt));
                } else if (i4 != 2) {
                } else {
                    e2 = Math.round(((float) (-i2)) * layoutParams.f20817b);
                }
                k2.k(e2);
            }
            CollapsingToolbarLayout.this.A();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.l3 != null && r > 0) {
                ViewCompat.t1(collapsingToolbarLayout2);
            }
            int height = CollapsingToolbarLayout.this.getHeight();
            int h0 = (height - ViewCompat.h0(CollapsingToolbarLayout.this)) - r;
            float f2 = (float) h0;
            CollapsingToolbarLayout.this.g3.C0(Math.min(1.0f, ((float) (height - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger())) / f2));
            CollapsingToolbarLayout collapsingToolbarLayout3 = CollapsingToolbarLayout.this;
            collapsingToolbarLayout3.g3.p0(collapsingToolbarLayout3.u3 + h0);
            CollapsingToolbarLayout.this.g3.A0(((float) Math.abs(i2)) / f2);
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TitleCollapseMode {
    }

    public CollapsingToolbarLayout(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private void B(int i2, int i4, int i5, int i6, boolean z) {
        View view;
        if (this.i3 && (view = this.a3) != null) {
            boolean z2 = false;
            boolean z4 = ViewCompat.R0(view) && this.a3.getVisibility() == 0;
            this.j3 = z4;
            if (z4 || z) {
                if (ViewCompat.c0(this) == 1) {
                    z2 = true;
                }
                v(z2);
                this.g3.q0(z2 ? this.d3 : this.b3, this.f3.top + this.c3, (i5 - i2) - (z2 ? this.b3 : this.d3), (i6 - i4) - this.e3);
                this.g3.d0(z);
            }
        }
    }

    private void C() {
        if (this.Y2 != null && this.i3 && TextUtils.isEmpty(this.g3.P())) {
            setTitle(j(this.Y2));
        }
    }

    private void a(int i2) {
        d();
        ValueAnimator valueAnimator = this.o3;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.o3 = valueAnimator2;
            valueAnimator2.setInterpolator(i2 > this.m3 ? this.q3 : this.r3);
            this.o3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.o3.cancel();
        }
        this.o3.setDuration(this.p3);
        this.o3.setIntValues(new int[]{this.m3, i2});
        this.o3.start();
    }

    private TextUtils.TruncateAt b(int i2) {
        if (i2 == 0) {
            return TextUtils.TruncateAt.START;
        }
        if (i2 != 1) {
            return i2 != 3 ? TextUtils.TruncateAt.END : TextUtils.TruncateAt.MARQUEE;
        }
        return TextUtils.TruncateAt.MIDDLE;
    }

    private void c(AppBarLayout appBarLayout) {
        if (o()) {
            appBarLayout.setLiftOnScroll(false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: android.view.ViewGroup} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
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
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
            r6.Y2 = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.e(r1)
            r6.Z2 = r1
        L_0x001f:
            android.view.ViewGroup r1 = r6.Y2
            r2 = 0
            if (r1 != 0) goto L_0x003e
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003c
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = q(r4)
            if (r5 == 0) goto L_0x0039
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x003c
        L_0x0039:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003c:
            r6.Y2 = r0
        L_0x003e:
            r6.z()
            r6.s = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.d():void");
    }

    @NonNull
    private View e(@NonNull View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    @ColorInt
    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList l2 = MaterialColors.l(getContext(), R.attr.g4);
        if (l2 != null) {
            return l2.getDefaultColor();
        }
        return this.h3.g(getResources().getDimension(R.dimen.Q0));
    }

    private static int h(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getMeasuredHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private static CharSequence j(View view) {
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getTitle();
        }
        if (view instanceof android.widget.Toolbar) {
            return ((android.widget.Toolbar) view).getTitle();
        }
        return null;
    }

    @NonNull
    static ViewOffsetHelper k(@NonNull View view) {
        int i2 = R.id.z6;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i2);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i2, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean o() {
        return this.v3 == 1;
    }

    private static boolean q(View view) {
        return (view instanceof Toolbar) || (view instanceof android.widget.Toolbar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000b A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean r(android.view.View r4) {
        /*
            r3 = this;
            android.view.View r0 = r3.Z2
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000d
            if (r0 != r3) goto L_0x0009
            goto L_0x000d
        L_0x0009:
            if (r4 != r0) goto L_0x0012
        L_0x000b:
            r1 = 1
            goto L_0x0012
        L_0x000d:
            android.view.ViewGroup r0 = r3.Y2
            if (r4 != r0) goto L_0x0012
            goto L_0x000b
        L_0x0012:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.r(android.view.View):boolean");
    }

    private void v(boolean z) {
        int i2;
        int i4;
        int i5;
        int i6;
        View view = this.Z2;
        if (view == null) {
            view = this.Y2;
        }
        int i7 = i(view);
        DescendantOffsetUtils.a(this, this.a3, this.f3);
        ViewGroup viewGroup = this.Y2;
        if (viewGroup instanceof Toolbar) {
            Toolbar toolbar = (Toolbar) viewGroup;
            i5 = toolbar.getTitleMarginStart();
            i4 = toolbar.getTitleMarginEnd();
            i2 = toolbar.getTitleMarginTop();
            i6 = toolbar.getTitleMarginBottom();
        } else if (Build.VERSION.SDK_INT < 24 || !(viewGroup instanceof android.widget.Toolbar)) {
            i5 = 0;
            i6 = 0;
            i4 = 0;
            i2 = 0;
        } else {
            android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
            i5 = toolbar2.getTitleMarginStart();
            i4 = toolbar2.getTitleMarginEnd();
            i2 = toolbar2.getTitleMarginTop();
            i6 = toolbar2.getTitleMarginBottom();
        }
        CollapsingTextHelper collapsingTextHelper = this.g3;
        Rect rect = this.f3;
        int i8 = rect.left + (z ? i4 : i5);
        int i9 = rect.top + i7 + i2;
        int i10 = rect.right;
        if (!z) {
            i5 = i4;
        }
        collapsingTextHelper.g0(i8, i9, i10 - i5, (rect.bottom + i7) - i6);
    }

    private void w() {
        setContentDescription(getTitle());
    }

    private void x(@NonNull Drawable drawable, int i2, int i4) {
        y(drawable, this.Y2, i2, i4);
    }

    private void y(@NonNull Drawable drawable, @Nullable View view, int i2, int i4) {
        if (o() && view != null && this.i3) {
            i4 = view.getBottom();
        }
        drawable.setBounds(0, 0, i2, i4);
    }

    private void z() {
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

    /* access modifiers changed from: package-private */
    public final void A() {
        if (this.k3 != null || this.l3 != null) {
            setScrimsShown(getHeight() + this.u3 < getScrimVisibleHeightTrigger());
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(@NonNull Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        d();
        if (this.Y2 == null && (drawable = this.k3) != null && this.m3 > 0) {
            drawable.mutate().setAlpha(this.m3);
            this.k3.draw(canvas);
        }
        if (this.i3 && this.j3) {
            if (this.Y2 == null || this.k3 == null || this.m3 <= 0 || !o() || this.g3.G() >= this.g3.H()) {
                this.g3.l(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.k3.getBounds(), Region.Op.DIFFERENCE);
                this.g3.l(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.l3 != null && this.m3 > 0) {
            WindowInsetsCompat windowInsetsCompat = this.w3;
            int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
            if (r > 0) {
                this.l3.setBounds(0, -this.u3, getWidth(), r - this.u3);
                this.l3.mutate().setAlpha(this.m3);
                this.l3.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.k3 == null || this.m3 <= 0 || !r(view)) {
            z = false;
        } else {
            y(this.k3, view, getWidth(), getHeight());
            this.k3.mutate().setAlpha(this.m3);
            this.k3.draw(canvas);
            z = true;
        }
        return super.drawChild(canvas, view, j2) || z;
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
        CollapsingTextHelper collapsingTextHelper = this.g3;
        if (collapsingTextHelper != null) {
            state |= collapsingTextHelper.K0(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.g3.q();
    }

    public float getCollapsedTitleTextSize() {
        return this.g3.u();
    }

    @NonNull
    public Typeface getCollapsedTitleTypeface() {
        return this.g3.v();
    }

    @Nullable
    public Drawable getContentScrim() {
        return this.k3;
    }

    public int getExpandedTitleGravity() {
        return this.g3.C();
    }

    public int getExpandedTitleMarginBottom() {
        return this.e3;
    }

    public int getExpandedTitleMarginEnd() {
        return this.d3;
    }

    public int getExpandedTitleMarginStart() {
        return this.b3;
    }

    public int getExpandedTitleMarginTop() {
        return this.c3;
    }

    public float getExpandedTitleTextSize() {
        return this.g3.E();
    }

    @NonNull
    public Typeface getExpandedTitleTypeface() {
        return this.g3.F();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getHyphenationFrequency() {
        return this.g3.I();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getLineCount() {
        return this.g3.J();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingAdd() {
        return this.g3.K();
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getLineSpacingMultiplier() {
        return this.g3.L();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getMaxLines() {
        return this.g3.M();
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.m3;
    }

    public long getScrimAnimationDuration() {
        return this.p3;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.s3;
        if (i2 >= 0) {
            return i2 + this.x3 + this.z3;
        }
        WindowInsetsCompat windowInsetsCompat = this.w3;
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
            return this.g3.P();
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.v3;
    }

    @Nullable
    public TimeInterpolator getTitlePositionInterpolator() {
        return this.g3.O();
    }

    @NonNull
    public TextUtils.TruncateAt getTitleTextEllipsize() {
        return this.g3.S();
    }

    /* access modifiers changed from: package-private */
    public final int i(@NonNull View view) {
        return ((getHeight() - k(view).c()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean l() {
        return this.A3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean m() {
        return this.y3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean n() {
        return this.g3.W();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            c(appBarLayout);
            ViewCompat.W1(this, ViewCompat.W(appBarLayout));
            if (this.t3 == null) {
                this.t3 = new OffsetUpdateListener();
            }
            appBarLayout.e(this.t3);
            ViewCompat.B1(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.g3.a0(configuration);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.t3;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).B(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i4, int i5, int i6) {
        super.onLayout(z, i2, i4, i5, i6);
        WindowInsetsCompat windowInsetsCompat = this.w3;
        if (windowInsetsCompat != null) {
            int r = windowInsetsCompat.r();
            int childCount = getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (!ViewCompat.W(childAt) && childAt.getTop() < r) {
                    ViewCompat.j1(childAt, r);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i8 = 0; i8 < childCount2; i8++) {
            k(getChildAt(i8)).h();
        }
        B(i2, i4, i5, i6, false);
        C();
        A();
        int childCount3 = getChildCount();
        for (int i9 = 0; i9 < childCount3; i9++) {
            k(getChildAt(i9)).a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        d();
        super.onMeasure(i2, i4);
        int mode = View.MeasureSpec.getMode(i4);
        WindowInsetsCompat windowInsetsCompat = this.w3;
        int r = windowInsetsCompat != null ? windowInsetsCompat.r() : 0;
        if ((mode == 0 || this.y3) && r > 0) {
            this.x3 = r;
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + r, 1073741824));
        }
        if (this.A3 && this.g3.M() > 1) {
            C();
            B(0, 0, getMeasuredWidth(), getMeasuredHeight(), true);
            int z = this.g3.z();
            if (z > 1) {
                this.z3 = Math.round(this.g3.B()) * (z - 1);
                super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + this.z3, 1073741824));
            }
        }
        ViewGroup viewGroup = this.Y2;
        if (viewGroup != null) {
            View view = this.Z2;
            setMinimumHeight((view == null || view == this) ? h(viewGroup) : h(view));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i4, int i5, int i6) {
        super.onSizeChanged(i2, i4, i5, i6);
        Drawable drawable = this.k3;
        if (drawable != null) {
            x(drawable, i2, i4);
        }
    }

    public boolean p() {
        return this.i3;
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat s(@NonNull WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.W(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.a(this.w3, windowInsetsCompat2)) {
            this.w3 = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    public void setCollapsedTitleGravity(int i2) {
        this.g3.l0(i2);
    }

    public void setCollapsedTitleTextAppearance(@StyleRes int i2) {
        this.g3.i0(i2);
    }

    public void setCollapsedTitleTextColor(@ColorInt int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextSize(float f2) {
        this.g3.m0(f2);
    }

    public void setCollapsedTitleTypeface(@Nullable Typeface typeface) {
        this.g3.n0(typeface);
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
                x(drawable3, getWidth(), getHeight());
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
        this.g3.w0(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.e3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.d3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.b3 = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.c3 = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(@StyleRes int i2) {
        this.g3.t0(i2);
    }

    public void setExpandedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.g3.v0(colorStateList);
    }

    public void setExpandedTitleTextSize(float f2) {
        this.g3.x0(f2);
    }

    public void setExpandedTitleTypeface(@Nullable Typeface typeface) {
        this.g3.y0(typeface);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setExtraMultilineHeightEnabled(boolean z) {
        this.A3 = z;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setForceApplySystemWindowInsetTop(boolean z) {
        this.y3 = z;
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setHyphenationFrequency(int i2) {
        this.g3.D0(i2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingAdd(float f2) {
        this.g3.F0(f2);
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setLineSpacingMultiplier(@FloatRange(from = 0.0d) float f2) {
        this.g3.G0(f2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setMaxLines(int i2) {
        this.g3.H0(i2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setRtlTextDirectionHeuristicsEnabled(boolean z) {
        this.g3.J0(z);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        ViewGroup viewGroup;
        if (i2 != this.m3) {
            if (!(this.k3 == null || (viewGroup = this.Y2) == null)) {
                ViewCompat.t1(viewGroup);
            }
            this.m3 = i2;
            ViewCompat.t1(this);
        }
    }

    public void setScrimAnimationDuration(@IntRange(from = 0) long j2) {
        this.p3 = j2;
    }

    public void setScrimVisibleHeightTrigger(@IntRange(from = 0) int i2) {
        if (this.s3 != i2) {
            this.s3 = i2;
            A();
        }
    }

    public void setScrimsShown(boolean z) {
        u(z, ViewCompat.Y0(this) && !isInEditMode());
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setStaticLayoutBuilderConfigurer(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.g3.L0(staticLayoutBuilderConfigurer);
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
        this.g3.M0(charSequence);
        w();
    }

    public void setTitleCollapseMode(int i2) {
        this.v3 = i2;
        boolean o = o();
        this.g3.B0(o);
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            c((AppBarLayout) parent);
        }
        if (o && this.k3 == null) {
            setContentScrimColor(getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(@NonNull TextUtils.TruncateAt truncateAt) {
        this.g3.O0(truncateAt);
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.i3) {
            this.i3 = z;
            w();
            z();
            requestLayout();
        }
    }

    public void setTitlePositionInterpolator(@Nullable TimeInterpolator timeInterpolator) {
        this.g3.I0(timeInterpolator);
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

    public void t(int i2, int i4, int i5, int i6) {
        this.b3 = i2;
        this.c3 = i4;
        this.d3 = i5;
        this.e3 = i6;
        requestLayout();
    }

    public void u(boolean z, boolean z2) {
        if (this.n3 != z) {
            int i2 = 0;
            if (z2) {
                if (z) {
                    i2 = 255;
                }
                a(i2);
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
    public boolean verifyDrawable(@NonNull Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.k3 || drawable == this.l3;
    }

    public CollapsingToolbarLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.j3);
    }

    public void setCollapsedTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.g3.k0(colorStateList);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CollapsingToolbarLayout(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r4 = B3
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r11, r12, r13, r4)
            r10.<init>(r11, r12, r13)
            r11 = 1
            r10.s = r11
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r10.f3 = r0
            r6 = -1
            r10.s3 = r6
            r7 = 0
            r10.x3 = r7
            r10.z3 = r7
            android.content.Context r8 = r10.getContext()
            com.google.android.material.internal.CollapsingTextHelper r9 = new com.google.android.material.internal.CollapsingTextHelper
            r9.<init>(r10)
            r10.g3 = r9
            android.animation.TimeInterpolator r0 = com.google.android.material.animation.AnimationUtils.f20770e
            r9.N0(r0)
            r9.J0(r7)
            com.google.android.material.elevation.ElevationOverlayProvider r0 = new com.google.android.material.elevation.ElevationOverlayProvider
            r0.<init>(r8)
            r10.h3 = r0
            int[] r2 = com.google.android.material.R.styleable.C7
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            android.content.res.TypedArray r12 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r13 = com.google.android.material.R.styleable.H7
            r0 = 8388691(0x800053, float:1.175506E-38)
            int r13 = r12.getInt(r13, r0)
            r9.w0(r13)
            int r13 = com.google.android.material.R.styleable.D7
            r0 = 8388627(0x800013, float:1.175497E-38)
            int r13 = r12.getInt(r13, r0)
            r9.l0(r13)
            int r13 = com.google.android.material.R.styleable.I7
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.e3 = r13
            r10.d3 = r13
            r10.c3 = r13
            r10.b3 = r13
            int r13 = com.google.android.material.R.styleable.L7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0074
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.b3 = r13
        L_0x0074:
            int r13 = com.google.android.material.R.styleable.K7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0082
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.d3 = r13
        L_0x0082:
            int r13 = com.google.android.material.R.styleable.M7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0090
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.c3 = r13
        L_0x0090:
            int r13 = com.google.android.material.R.styleable.J7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x009e
            int r13 = r12.getDimensionPixelSize(r13, r7)
            r10.e3 = r13
        L_0x009e:
            int r13 = com.google.android.material.R.styleable.X7
            boolean r13 = r12.getBoolean(r13, r11)
            r10.i3 = r13
            int r13 = com.google.android.material.R.styleable.V7
            java.lang.CharSequence r13 = r12.getText(r13)
            r10.setTitle(r13)
            int r13 = com.google.android.material.R.style.O7
            r9.t0(r13)
            int r13 = androidx.appcompat.R.style.m3
            r9.i0(r13)
            int r13 = com.google.android.material.R.styleable.N7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00c8
            int r13 = r12.getResourceId(r13, r7)
            r9.t0(r13)
        L_0x00c8:
            int r13 = com.google.android.material.R.styleable.E7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00d7
            int r13 = r12.getResourceId(r13, r7)
            r9.i0(r13)
        L_0x00d7:
            int r13 = com.google.android.material.R.styleable.Z7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00ea
            int r13 = r12.getInt(r13, r6)
            android.text.TextUtils$TruncateAt r13 = r10.b(r13)
            r10.setTitleEllipsize(r13)
        L_0x00ea:
            int r13 = com.google.android.material.R.styleable.O7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x00f9
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r8, r12, r13)
            r9.v0(r13)
        L_0x00f9:
            int r13 = com.google.android.material.R.styleable.F7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x0108
            android.content.res.ColorStateList r13 = com.google.android.material.resources.MaterialResources.a(r8, r12, r13)
            r9.k0(r13)
        L_0x0108:
            int r13 = com.google.android.material.R.styleable.T7
            int r13 = r12.getDimensionPixelSize(r13, r6)
            r10.s3 = r13
            int r13 = com.google.android.material.R.styleable.R7
            boolean r0 = r12.hasValue(r13)
            if (r0 == 0) goto L_0x011f
            int r11 = r12.getInt(r13, r11)
            r9.H0(r11)
        L_0x011f:
            int r11 = com.google.android.material.R.styleable.Y7
            boolean r13 = r12.hasValue(r11)
            if (r13 == 0) goto L_0x0132
            int r11 = r12.getResourceId(r11, r7)
            android.view.animation.Interpolator r11 = android.view.animation.AnimationUtils.loadInterpolator(r8, r11)
            r9.I0(r11)
        L_0x0132:
            int r11 = com.google.android.material.R.styleable.S7
            r13 = 600(0x258, float:8.41E-43)
            int r11 = r12.getInt(r11, r13)
            long r0 = (long) r11
            r10.p3 = r0
            int r11 = com.google.android.material.R.attr.be
            android.animation.TimeInterpolator r13 = com.google.android.material.animation.AnimationUtils.f20768c
            android.animation.TimeInterpolator r13 = com.google.android.material.motion.MotionUtils.g(r8, r11, r13)
            r10.q3 = r13
            android.animation.TimeInterpolator r13 = com.google.android.material.animation.AnimationUtils.f20769d
            android.animation.TimeInterpolator r11 = com.google.android.material.motion.MotionUtils.g(r8, r11, r13)
            r10.r3 = r11
            int r11 = com.google.android.material.R.styleable.G7
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setContentScrim(r11)
            int r11 = com.google.android.material.R.styleable.U7
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r11)
            r10.setStatusBarScrim(r11)
            int r11 = com.google.android.material.R.styleable.W7
            int r11 = r12.getInt(r11, r7)
            r10.setTitleCollapseMode(r11)
            int r11 = com.google.android.material.R.styleable.a8
            int r11 = r12.getResourceId(r11, r6)
            r10.X2 = r11
            int r11 = com.google.android.material.R.styleable.Q7
            boolean r11 = r12.getBoolean(r11, r7)
            r10.y3 = r11
            int r11 = com.google.android.material.R.styleable.P7
            boolean r11 = r12.getBoolean(r11, r7)
            r10.A3 = r11
            r12.recycle()
            r10.setWillNotDraw(r7)
            com.google.android.material.appbar.CollapsingToolbarLayout$1 r11 = new com.google.android.material.appbar.CollapsingToolbarLayout$1
            r11.<init>()
            androidx.core.view.ViewCompat.k2(r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
