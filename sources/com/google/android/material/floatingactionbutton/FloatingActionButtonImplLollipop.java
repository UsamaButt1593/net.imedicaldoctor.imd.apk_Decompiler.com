package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

@RequiresApi(21)
class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    @Nullable
    private StateListAnimator c0;

    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        public boolean isStateful() {
            return true;
        }
    }

    FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @NonNull
    private StateListAnimator n0(float f2, float f3, float f4) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.W, o0(f2, f4));
        stateListAnimator.addState(FloatingActionButtonImpl.X, o0(f2, f3));
        stateListAnimator.addState(FloatingActionButtonImpl.Y, o0(f2, f3));
        stateListAnimator.addState(FloatingActionButtonImpl.Z, o0(f2, f3));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.w, "elevation", new float[]{f2}).setDuration(0));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 24) {
            FloatingActionButton floatingActionButton = this.w;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, new float[]{floatingActionButton.getTranslationZ()}).setDuration(100));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[]{0.0f}).setDuration(100));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        stateListAnimator.addState(FloatingActionButtonImpl.a0, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.b0, o0(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator o0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", new float[]{f2}).setDuration(0)).with(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, new float[]{f3}).setDuration(100));
        animatorSet.setInterpolator(FloatingActionButtonImpl.D);
        return animatorSet;
    }

    /* access modifiers changed from: package-private */
    public void B() {
    }

    /* access modifiers changed from: package-private */
    public void D() {
        j0();
    }

    /* access modifiers changed from: package-private */
    public void F(int[] iArr) {
        FloatingActionButton floatingActionButton;
        if (Build.VERSION.SDK_INT == 21) {
            float f2 = 0.0f;
            if (this.w.isEnabled()) {
                this.w.setElevation(this.f21470h);
                if (this.w.isPressed()) {
                    floatingActionButton = this.w;
                    f2 = this.f21472j;
                } else {
                    if (this.w.isFocused() || this.w.isHovered()) {
                        floatingActionButton = this.w;
                        f2 = this.f21471i;
                    }
                    floatingActionButton = this.w;
                }
            } else {
                this.w.setElevation(0.0f);
                floatingActionButton = this.w;
            }
            floatingActionButton.setTranslationZ(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(float f2, float f3, float f4) {
        if (Build.VERSION.SDK_INT == 21) {
            this.w.refreshDrawableState();
        } else if (this.w.getStateListAnimator() == this.c0) {
            StateListAnimator n0 = n0(f2, f3, f4);
            this.c0 = n0;
            this.w.setStateListAnimator(n0);
        }
        if (d0()) {
            j0();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean O() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void Z(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f21465c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.e(colorStateList));
        } else {
            super.Z(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d0() {
        return this.x.b() || !f0();
    }

    /* access modifiers changed from: package-private */
    public void h0() {
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public MaterialShapeDrawable l() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.l(this.f21463a));
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public BorderDrawable m0(int i2, ColorStateList colorStateList) {
        Context context = this.w.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.l(this.f21463a));
        borderDrawable.f(ContextCompat.g(context, R.color.E0), ContextCompat.g(context, R.color.D0), ContextCompat.g(context, R.color.B0), ContextCompat.g(context, R.color.C0));
        borderDrawable.e((float) i2);
        borderDrawable.d(colorStateList);
        return borderDrawable;
    }

    public float n() {
        return this.w.getElevation();
    }

    /* access modifiers changed from: package-private */
    public void s(@NonNull Rect rect) {
        if (this.x.b()) {
            super.s(rect);
            return;
        }
        int sizeDimension = !f0() ? (this.f21473k - this.w.getSizeDimension()) / 2 : 0;
        rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
    }

    /* access modifiers changed from: package-private */
    public void y(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        MaterialShapeDrawable l2 = l();
        this.f21464b = l2;
        l2.setTintList(colorStateList);
        if (mode != null) {
            this.f21464b.setTintMode(mode);
        }
        this.f21464b.a0(this.w.getContext());
        if (i2 > 0) {
            this.f21466d = m0(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.l(this.f21466d), (Drawable) Preconditions.l(this.f21464b)});
        } else {
            this.f21466d = null;
            drawable = this.f21464b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.e(colorStateList2), drawable, (Drawable) null);
        this.f21465c = rippleDrawable;
        this.f21467e = rippleDrawable;
    }
}
