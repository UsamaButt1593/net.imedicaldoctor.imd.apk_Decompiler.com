package com.google.android.material.progressindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public abstract class BaseProgressIndicator<S extends BaseProgressIndicatorSpec> extends ProgressBar {
    public static final int k3 = 0;
    public static final int l3 = 1;
    public static final int m3 = 2;
    public static final int n3 = 0;
    public static final int o3 = 1;
    public static final int p3 = 2;
    public static final int q3 = 3;
    static final int r3 = R.style.Wj;
    static final float s3 = 0.2f;
    static final int t3 = 255;
    static final int u3 = 1000;
    /* access modifiers changed from: private */
    public int X2;
    /* access modifiers changed from: private */
    public boolean Y2;
    private boolean Z2;
    private final int a3;
    private final int b3;
    /* access modifiers changed from: private */
    public long c3 = -1;
    AnimatorDurationScaleProvider d3;
    /* access modifiers changed from: private */
    public boolean e3 = false;
    /* access modifiers changed from: private */
    public int f3 = 4;
    private final Runnable g3 = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.l();
        }
    };
    private final Runnable h3 = new Runnable() {
        public void run() {
            BaseProgressIndicator.this.k();
            long unused = BaseProgressIndicator.this.c3 = -1;
        }
    };
    private final Animatable2Compat.AnimationCallback i3 = new Animatable2Compat.AnimationCallback() {
        public void b(Drawable drawable) {
            BaseProgressIndicator.this.setIndeterminate(false);
            BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
            baseProgressIndicator.p(baseProgressIndicator.X2, BaseProgressIndicator.this.Y2);
        }
    };
    private final Animatable2Compat.AnimationCallback j3 = new Animatable2Compat.AnimationCallback() {
        public void b(Drawable drawable) {
            super.b(drawable);
            if (!BaseProgressIndicator.this.e3) {
                BaseProgressIndicator baseProgressIndicator = BaseProgressIndicator.this;
                baseProgressIndicator.setVisibility(baseProgressIndicator.f3);
            }
        }
    };
    S s;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HideAnimationBehavior {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowAnimationBehavior {
    }

    protected BaseProgressIndicator(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i2, @StyleRes int i4) {
        super(MaterialThemeOverlay.c(context, attributeSet, i2, r3), attributeSet, i2);
        Context context2 = getContext();
        this.s = i(context2, attributeSet);
        TypedArray k2 = ThemeEnforcement.k(context2, attributeSet, R.styleable.A4, i2, i4, new int[0]);
        this.a3 = k2.getInt(R.styleable.H4, -1);
        this.b3 = Math.min(k2.getInt(R.styleable.F4, -1), 1000);
        k2.recycle();
        this.d3 = new AnimatorDurationScaleProvider();
        this.Z2 = true;
    }

    @Nullable
    private DrawingDelegate<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().D();
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().F();
        }
    }

    /* access modifiers changed from: private */
    public void k() {
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).w(false, false, true);
        if (n()) {
            setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (this.b3 > 0) {
            this.c3 = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    private boolean n() {
        return (getProgressDrawable() == null || !getProgressDrawable().isVisible()) && (getIndeterminateDrawable() == null || !getIndeterminateDrawable().isVisible());
    }

    private void o() {
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().C().d(this.i3);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().b(this.j3);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().b(this.j3);
        }
    }

    private void r() {
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().d(this.j3);
            getIndeterminateDrawable().C().j();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().d(this.j3);
        }
    }

    @Nullable
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.s.f21641f;
    }

    @NonNull
    public int[] getIndicatorColor() {
        return this.s.f21638c;
    }

    @Px
    public int getIndicatorTrackGapSize() {
        return this.s.f21642g;
    }

    public int getShowAnimationBehavior() {
        return this.s.f21640e;
    }

    @ColorInt
    public int getTrackColor() {
        return this.s.f21639d;
    }

    @Px
    public int getTrackCornerRadius() {
        return this.s.f21637b;
    }

    @Px
    public int getTrackThickness() {
        return this.s.f21636a;
    }

    /* access modifiers changed from: protected */
    public void h(boolean z) {
        if (this.Z2) {
            ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).w(s(), false, z);
        }
    }

    /* access modifiers changed from: package-private */
    public abstract S i(@NonNull Context context, @NonNull AttributeSet attributeSet);

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void j() {
        if (getVisibility() != 0) {
            removeCallbacks(this.g3);
            return;
        }
        removeCallbacks(this.h3);
        long uptimeMillis = SystemClock.uptimeMillis() - this.c3;
        int i2 = this.b3;
        if (uptimeMillis >= ((long) i2)) {
            this.h3.run();
        } else {
            postDelayed(this.h3, ((long) i2) - uptimeMillis);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        View view = this;
        while (view.getVisibility() == 0) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        if (s()) {
            l();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.h3);
        removeCallbacks(this.g3);
        ((DrawableWithAnimatedVisibilityChange) getCurrentDrawable()).m();
        r();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(@NonNull Canvas canvas) {
        try {
            int save = canvas.save();
            if (getPaddingLeft() == 0) {
                if (getPaddingTop() != 0) {
                }
                if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
                    canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
                }
                getCurrentDrawable().draw(canvas);
                canvas.restoreToCount(save);
            }
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
            getCurrentDrawable().draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int i2, int i4) {
        try {
            DrawingDelegate currentDrawingDelegate = getCurrentDrawingDelegate();
            if (currentDrawingDelegate != null) {
                setMeasuredDimension(currentDrawingDelegate.f() < 0 ? View.getDefaultSize(getSuggestedMinimumWidth(), i2) : currentDrawingDelegate.f() + getPaddingLeft() + getPaddingRight(), currentDrawingDelegate.e() < 0 ? View.getDefaultSize(getSuggestedMinimumHeight(), i4) : currentDrawingDelegate.e() + getPaddingTop() + getPaddingBottom());
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        h(i2 == 0);
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        h(false);
    }

    public void p(int i2, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null && !z) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.X2 = i2;
            this.Y2 = z;
            this.e3 = true;
            if (!getIndeterminateDrawable().isVisible() || this.d3.a(getContext().getContentResolver()) == 0.0f) {
                this.i3.b(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().C().f();
            }
        }
    }

    public void q() {
        if (this.a3 > 0) {
            removeCallbacks(this.g3);
            postDelayed(this.g3, (long) this.a3);
            return;
        }
        this.g3.run();
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return ViewCompat.R0(this) && getWindowVisibility() == 0 && m();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setAnimatorDurationScaleProvider(@NonNull AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.d3 = animatorDurationScaleProvider;
        if (getProgressDrawable() != null) {
            getProgressDrawable().Y = animatorDurationScaleProvider;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().Y = animatorDurationScaleProvider;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.s.f21641f = i2;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z) {
        try {
            if (z != isIndeterminate()) {
                DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
                if (drawableWithAnimatedVisibilityChange != null) {
                    drawableWithAnimatedVisibilityChange.m();
                }
                super.setIndeterminate(z);
                DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange2 = (DrawableWithAnimatedVisibilityChange) getCurrentDrawable();
                if (drawableWithAnimatedVisibilityChange2 != null) {
                    drawableWithAnimatedVisibilityChange2.w(s(), false, false);
                }
                if ((drawableWithAnimatedVisibilityChange2 instanceof IndeterminateDrawable) && s()) {
                    ((IndeterminateDrawable) drawableWithAnimatedVisibilityChange2).C().i();
                }
                this.e3 = false;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public void setIndeterminateDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable((Drawable) null);
        } else if (drawable instanceof IndeterminateDrawable) {
            ((DrawableWithAnimatedVisibilityChange) drawable).m();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(@ColorInt int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.b(getContext(), R.attr.R3, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.s.f21638c = iArr;
            getIndeterminateDrawable().C().c();
            invalidate();
        }
    }

    public void setIndicatorTrackGapSize(@Px int i2) {
        S s2 = this.s;
        if (s2.f21642g != i2) {
            s2.f21642g = i2;
            s2.e();
            invalidate();
        }
    }

    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            p(i2, false);
        }
    }

    public void setProgressDrawable(@Nullable Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable((Drawable) null);
        } else if (drawable instanceof DeterminateDrawable) {
            DeterminateDrawable determinateDrawable = (DeterminateDrawable) drawable;
            determinateDrawable.m();
            super.setProgressDrawable(determinateDrawable);
            determinateDrawable.K(((float) getProgress()) / ((float) getMax()));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.s.f21640e = i2;
        invalidate();
    }

    public void setTrackColor(@ColorInt int i2) {
        S s2 = this.s;
        if (s2.f21639d != i2) {
            s2.f21639d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(@Px int i2) {
        S s2 = this.s;
        if (s2.f21637b != i2) {
            s2.f21637b = Math.min(i2, s2.f21636a / 2);
            invalidate();
        }
    }

    public void setTrackThickness(@Px int i2) {
        S s2 = this.s;
        if (s2.f21636a != i2) {
            s2.f21636a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 == 0 || i2 == 4 || i2 == 8) {
            this.f3 = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }

    @Nullable
    public IndeterminateDrawable<S> getIndeterminateDrawable() {
        return (IndeterminateDrawable) super.getIndeterminateDrawable();
    }

    @Nullable
    public DeterminateDrawable<S> getProgressDrawable() {
        return (DeterminateDrawable) super.getProgressDrawable();
    }
}
