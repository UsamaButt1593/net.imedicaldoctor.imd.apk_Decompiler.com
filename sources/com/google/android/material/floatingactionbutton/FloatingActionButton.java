package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimatorRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.stateful.ExtendableSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, ExpandableTransformationWidget, Shapeable, CoordinatorLayout.AttachedBehavior {
    private static final String n3 = "FloatingActionButton";
    private static final String o3 = "expandableWidgetHelper";
    private static final int p3 = R.style.Pe;
    public static final int q3 = 1;
    public static final int r3 = 0;
    public static final int s3 = -1;
    public static final int t3 = 0;
    private static final int u3 = 470;
    @Nullable
    private ColorStateList X2;
    @Nullable
    private PorterDuff.Mode Y2;
    @Nullable
    private ColorStateList Z2;
    @Nullable
    private PorterDuff.Mode a3;
    @Nullable
    private ColorStateList b3;
    private int c3;
    private int d3;
    private int e3;
    /* access modifiers changed from: private */
    public int f3;
    private int g3;
    boolean h3;
    final Rect i3;
    private final Rect j3;
    @NonNull
    private final AppCompatImageHelper k3;
    @NonNull
    private final ExpandableWidgetHelper l3;
    private FloatingActionButtonImpl m3;

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean Z = true;
        private OnVisibilityChangedListener X;
        private boolean Y;
        private Rect s;

        public BaseBehavior() {
            this.Y = true;
        }

        private static boolean P(@NonNull View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void Q(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
            Rect rect = floatingActionButton.i3;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                int i2 = 0;
                int i3 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin ? rect.right : floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    ViewCompat.j1(floatingActionButton, i2);
                }
                if (i3 != 0) {
                    ViewCompat.i1(floatingActionButton, i3);
                }
            }
        }

        private boolean V(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            return this.Y && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean W(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
            if (!V(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.s == null) {
                this.s = new Rect();
            }
            Rect rect = this.s;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.q(this.X, false);
                return true;
            }
            floatingActionButton.B(this.X, false);
            return true;
        }

        private boolean X(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
            if (!V(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.q(this.X, false);
                return true;
            }
            floatingActionButton.B(this.X, false);
            return true;
        }

        /* renamed from: N */
        public boolean i(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            Rect rect2 = floatingActionButton.i3;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        public boolean O() {
            return this.Y;
        }

        /* renamed from: R */
        public boolean p(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                W(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!P(view)) {
                return false;
            } else {
                X(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: S */
        public boolean t(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            List<View> w = coordinatorLayout.w(floatingActionButton);
            int size = w.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = w.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (P(view) && X(view, floatingActionButton)) {
                        break;
                    }
                } else if (W(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.N(floatingActionButton, i2);
            Q(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void T(boolean z) {
            this.Y = z;
        }

        @VisibleForTesting
        public void U(OnVisibilityChangedListener onVisibilityChangedListener) {
            this.X = onVisibilityChangedListener;
        }

        public void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f5084h == 0) {
                layoutParams.f5084h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Dg);
            this.Y = obtainStyledAttributes.getBoolean(R.styleable.Eg, true);
            obtainStyledAttributes.recycle();
        }
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean N(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
            return super.i(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean O() {
            return super.O();
        }

        public /* bridge */ /* synthetic */ boolean R(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
            return super.p(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean S(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i2) {
            return super.t(coordinatorLayout, floatingActionButton, i2);
        }

        public /* bridge */ /* synthetic */ void T(boolean z) {
            super.T(z);
        }

        @VisibleForTesting
        public /* bridge */ /* synthetic */ void U(OnVisibilityChangedListener onVisibilityChangedListener) {
            super.U(onVisibilityChangedListener);
        }

        public /* bridge */ /* synthetic */ void o(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
            super.o(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.i3.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f3, i3 + FloatingActionButton.this.f3, i4 + FloatingActionButton.this.f3, i5 + FloatingActionButton.this.f3);
        }

        public boolean b() {
            return FloatingActionButton.this.h3;
        }

        public void c(@Nullable Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        public float d() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Size {
    }

    class TransformationCallbackWrapper<T extends FloatingActionButton> implements FloatingActionButtonImpl.InternalTransformationCallback {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final TransformationCallback<T> f21461a;

        TransformationCallbackWrapper(@NonNull TransformationCallback<T> transformationCallback) {
            this.f21461a = transformationCallback;
        }

        public void a() {
            this.f21461a.b(FloatingActionButton.this);
        }

        public void b() {
            this.f21461a.a(FloatingActionButton.this);
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof TransformationCallbackWrapper) && ((TransformationCallbackWrapper) obj).f21461a.equals(this.f21461a);
        }

        public int hashCode() {
            return this.f21461a.hashCode();
        }
    }

    public FloatingActionButton(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    @Nullable
    private FloatingActionButtonImpl.InternalVisibilityChangedListener C(@Nullable final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
            public void a() {
                onVisibilityChangedListener.b(FloatingActionButton.this);
            }

            public void b() {
                onVisibilityChangedListener.a(FloatingActionButton.this);
            }
        };
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.m3 == null) {
            this.m3 = j();
        }
        return this.m3;
    }

    @NonNull
    private FloatingActionButtonImpl j() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    }

    private int m(int i2) {
        int i4 = this.e3;
        if (i4 != 0) {
            return i4;
        }
        Resources resources = getResources();
        if (i2 == -1) {
            return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < u3 ? m(1) : m(0);
        }
        return resources.getDimensionPixelSize(i2 != 1 ? R.dimen.k1 : R.dimen.j1);
    }

    private void n(@NonNull Rect rect) {
        l(rect);
        int i2 = -this.m3.w();
        rect.inset(i2, i2);
    }

    private void t(@NonNull Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.i3;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void u() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.Z2;
            if (colorStateList == null) {
                DrawableCompat.c(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.a3;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.e(colorForState, mode));
        }
    }

    public void A(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        B(onVisibilityChangedListener, true);
    }

    /* access modifiers changed from: package-private */
    public void B(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().g0(C(onVisibilityChangedListener), z);
    }

    public boolean a(boolean z) {
        return this.l3.f(z);
    }

    public boolean b() {
        return this.l3.c();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().F(getDrawableState());
    }

    public void f(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void g(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    @Nullable
    public ColorStateList getBackgroundTintList() {
        return this.X2;
    }

    @Nullable
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.Y2;
    }

    @NonNull
    public CoordinatorLayout.Behavior<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    @Nullable
    public Drawable getContentBackground() {
        return getImpl().m();
    }

    @Px
    public int getCustomSize() {
        return this.e3;
    }

    public int getExpandedComponentIdHint() {
        return this.l3.b();
    }

    @Nullable
    public MotionSpec getHideMotionSpec() {
        return getImpl().p();
    }

    @ColorInt
    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.b3;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    @Nullable
    public ColorStateList getRippleColorStateList() {
        return this.b3;
    }

    @NonNull
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return (ShapeAppearanceModel) Preconditions.l(getImpl().u());
    }

    @Nullable
    public MotionSpec getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.d3;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return m(this.d3);
    }

    @Nullable
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Nullable
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Nullable
    public ColorStateList getSupportImageTintList() {
        return this.Z2;
    }

    @Nullable
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.a3;
    }

    public boolean getUseCompatPadding() {
        return this.h3;
    }

    public void h(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        getImpl().g(new TransformationCallbackWrapper(transformationCallback));
    }

    public void i() {
        setCustomSize(0);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().B();
    }

    @Deprecated
    public boolean k(@NonNull Rect rect) {
        if (!ViewCompat.Y0(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        t(rect);
        return true;
    }

    public void l(@NonNull Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        t(rect);
    }

    public void o() {
        p((OnVisibilityChangedListener) null);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().C();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().E();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i4) {
        int sizeDimension = getSizeDimension();
        this.f3 = (sizeDimension - this.g3) / 2;
        getImpl().j0();
        int min = Math.min(View.resolveSize(sizeDimension, i2), View.resolveSize(sizeDimension, i4));
        Rect rect = this.i3;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.l3.d((Bundle) Preconditions.l(extendableSavedState.Y.get(o3)));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.Y.put(o3, this.l3.e());
        return extendableSavedState;
    }

    public boolean onTouchEvent(@NonNull MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            n(this.j3);
            if (!this.j3.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(@Nullable OnVisibilityChangedListener onVisibilityChangedListener) {
        q(onVisibilityChangedListener, true);
    }

    /* access modifiers changed from: package-private */
    public void q(@Nullable OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().x(C(onVisibilityChangedListener), z);
    }

    public boolean r() {
        return getImpl().z();
    }

    public boolean s() {
        return getImpl().A();
    }

    public void setBackgroundColor(int i2) {
        Log.i(n3, "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i(n3, "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i(n3, "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        if (this.X2 != colorStateList) {
            this.X2 = colorStateList;
            getImpl().P(colorStateList);
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.Y2 != mode) {
            this.Y2 = mode;
            getImpl().Q(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().R(f2);
    }

    public void setCompatElevationResource(@DimenRes int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().U(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(@DimenRes int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().Y(f2);
    }

    public void setCompatPressedTranslationZResource(@DimenRes int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(@Px int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i2 != this.e3) {
            this.e3 = i2;
            requestLayout();
        }
    }

    @RequiresApi(21)
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().k0(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().o()) {
            getImpl().S(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(@IdRes int i2) {
        this.l3.g(i2);
    }

    public void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().T(motionSpec);
    }

    public void setHideMotionSpecResource(@AnimatorRes int i2) {
        setHideMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setImageDrawable(@Nullable Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().i0();
            if (this.Z2 != null) {
                u();
            }
        }
    }

    public void setImageResource(@DrawableRes int i2) {
        this.k3.i(i2);
        u();
    }

    public void setMaxImageSize(int i2) {
        this.g3 = i2;
        getImpl().W(i2);
    }

    public void setRippleColor(@ColorInt int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().J();
    }

    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().J();
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setShadowPaddingEnabled(boolean z) {
        getImpl().a0(z);
    }

    public void setShapeAppearanceModel(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        getImpl().b0(shapeAppearanceModel);
    }

    public void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        getImpl().c0(motionSpec);
    }

    public void setShowMotionSpecResource(@AnimatorRes int i2) {
        setShowMotionSpec(MotionSpec.d(getContext(), i2));
    }

    public void setSize(int i2) {
        this.e3 = 0;
        if (i2 != this.d3) {
            this.d3 = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(@Nullable ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(@Nullable ColorStateList colorStateList) {
        if (this.Z2 != colorStateList) {
            this.Z2 = colorStateList;
            u();
        }
    }

    public void setSupportImageTintMode(@Nullable PorterDuff.Mode mode) {
        if (this.a3 != mode) {
            this.a3 = mode;
            u();
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().K();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().K();
    }

    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().K();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.h3 != z) {
            this.h3 = z;
            getImpl().D();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    public void v(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().L(animatorListener);
    }

    public void w(@NonNull Animator.AnimatorListener animatorListener) {
        getImpl().M(animatorListener);
    }

    public void x(@NonNull TransformationCallback<? extends FloatingActionButton> transformationCallback) {
        getImpl().N(new TransformationCallbackWrapper(transformationCallback));
    }

    public boolean y() {
        return getImpl().o();
    }

    public void z() {
        A((OnVisibilityChangedListener) null);
    }

    public FloatingActionButton(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.Q7);
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        if (this.b3 != colorStateList) {
            this.b3 = colorStateList;
            getImpl().Z(this.b3);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FloatingActionButton(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = p3
            android.content.Context r11 = com.google.android.material.theme.overlay.MaterialThemeOverlay.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.i3 = r11
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r10.j3 = r11
            android.content.Context r11 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.lg
            r7 = 0
            int[] r5 = new int[r7]
            r0 = r11
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = com.google.android.material.internal.ThemeEnforcement.k(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.ng
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r11, r0, r1)
            r10.X2 = r1
            int r1 = com.google.android.material.R.styleable.og
            r2 = -1
            int r1 = r0.getInt(r1, r2)
            r3 = 0
            android.graphics.PorterDuff$Mode r1 = com.google.android.material.internal.ViewUtils.u(r1, r3)
            r10.Y2 = r1
            int r1 = com.google.android.material.R.styleable.yg
            android.content.res.ColorStateList r1 = com.google.android.material.resources.MaterialResources.a(r11, r0, r1)
            r10.b3 = r1
            int r1 = com.google.android.material.R.styleable.tg
            int r1 = r0.getInt(r1, r2)
            r10.d3 = r1
            int r1 = com.google.android.material.R.styleable.sg
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.e3 = r1
            int r1 = com.google.android.material.R.styleable.pg
            int r1 = r0.getDimensionPixelSize(r1, r7)
            r10.c3 = r1
            int r1 = com.google.android.material.R.styleable.qg
            r2 = 0
            float r1 = r0.getDimension(r1, r2)
            int r3 = com.google.android.material.R.styleable.vg
            float r3 = r0.getDimension(r3, r2)
            int r4 = com.google.android.material.R.styleable.xg
            float r2 = r0.getDimension(r4, r2)
            int r4 = com.google.android.material.R.styleable.Cg
            boolean r4 = r0.getBoolean(r4, r7)
            r10.h3 = r4
            android.content.res.Resources r4 = r10.getResources()
            int r5 = com.google.android.material.R.dimen.tc
            int r4 = r4.getDimensionPixelSize(r5)
            int r5 = com.google.android.material.R.styleable.wg
            int r5 = r0.getDimensionPixelSize(r5, r7)
            r10.setMaxImageSize(r5)
            int r5 = com.google.android.material.R.styleable.Bg
            com.google.android.material.animation.MotionSpec r5 = com.google.android.material.animation.MotionSpec.c(r11, r0, r5)
            int r8 = com.google.android.material.R.styleable.ug
            com.google.android.material.animation.MotionSpec r8 = com.google.android.material.animation.MotionSpec.c(r11, r0, r8)
            com.google.android.material.shape.CornerSize r9 = com.google.android.material.shape.ShapeAppearanceModel.f21822m
            com.google.android.material.shape.ShapeAppearanceModel$Builder r11 = com.google.android.material.shape.ShapeAppearanceModel.g(r11, r12, r13, r6, r9)
            com.google.android.material.shape.ShapeAppearanceModel r11 = r11.m()
            int r6 = com.google.android.material.R.styleable.rg
            boolean r6 = r0.getBoolean(r6, r7)
            int r7 = com.google.android.material.R.styleable.mg
            r9 = 1
            boolean r7 = r0.getBoolean(r7, r9)
            r10.setEnabled(r7)
            r0.recycle()
            androidx.appcompat.widget.AppCompatImageHelper r0 = new androidx.appcompat.widget.AppCompatImageHelper
            r0.<init>(r10)
            r10.k3 = r0
            r0.g(r12, r13)
            com.google.android.material.expandable.ExpandableWidgetHelper r12 = new com.google.android.material.expandable.ExpandableWidgetHelper
            r12.<init>(r10)
            r10.l3 = r12
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r12 = r10.getImpl()
            r12.b0(r11)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            android.content.res.ColorStateList r12 = r10.X2
            android.graphics.PorterDuff$Mode r13 = r10.Y2
            android.content.res.ColorStateList r0 = r10.b3
            int r7 = r10.c3
            r11.y(r12, r13, r0, r7)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.X(r4)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.R(r1)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.U(r3)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.Y(r2)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.c0(r5)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.T(r8)
            com.google.android.material.floatingactionbutton.FloatingActionButtonImpl r11 = r10.getImpl()
            r11.S(r6)
            android.widget.ImageView$ScaleType r11 = android.widget.ImageView.ScaleType.MATRIX
            r10.setScaleType(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
