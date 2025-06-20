package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    public static final int h4 = 0;
    public static final int i4 = 1;
    public static final int j4 = 2;
    @AttrRes
    private static final int k4 = R.attr.Ed;
    @AttrRes
    private static final int l4 = R.attr.Vd;
    private final int f4;
    private final boolean g4;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public MaterialSharedAxis(int i2, boolean z) {
        super(r2(i2, z), u2());
        this.f4 = i2;
        this.g4 = z;
    }

    private static VisibilityAnimatorProvider r2(int i2, boolean z) {
        if (i2 == 0) {
            return new SlideDistanceProvider(z ? GravityCompat.f6388c : GravityCompat.f6387b);
        } else if (i2 == 1) {
            return new SlideDistanceProvider(z ? 80 : 48);
        } else if (i2 == 2) {
            return new ScaleProvider(z);
        } else {
            throw new IllegalArgumentException("Invalid axis: " + i2);
        }
    }

    private static VisibilityAnimatorProvider u2() {
        return new FadeThroughProvider();
    }

    public boolean B2() {
        return this.g4;
    }

    public /* bridge */ /* synthetic */ Animator O1(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.O1(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ Animator S1(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.S1(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ void a2(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.a2(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void d2() {
        super.d2();
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g2(boolean z) {
        return k4;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int i2(boolean z) {
        return l4;
    }

    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider j2() {
        return super.j2();
    }

    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider m2() {
        return super.m2();
    }

    public /* bridge */ /* synthetic */ boolean p2(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.p2(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void q2(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.q2(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ boolean u0() {
        return super.u0();
    }

    public int w2() {
        return this.f4;
    }
}
