package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;

public final class MaterialElevationScale extends MaterialVisibility<ScaleProvider> {
    private static final float g4 = 0.85f;
    private final boolean f4;

    public MaterialElevationScale(boolean z) {
        super(r2(z), u2());
        this.f4 = z;
    }

    private static ScaleProvider r2(boolean z) {
        ScaleProvider scaleProvider = new ScaleProvider(z);
        scaleProvider.m(g4);
        scaleProvider.l(g4);
        return scaleProvider;
    }

    private static VisibilityAnimatorProvider u2() {
        return new FadeProvider();
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

    public boolean w2() {
        return this.f4;
    }
}
