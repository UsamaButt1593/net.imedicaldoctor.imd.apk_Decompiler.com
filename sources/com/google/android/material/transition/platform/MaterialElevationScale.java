package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class MaterialElevationScale extends MaterialVisibility<ScaleProvider> {
    private static final float X2 = 0.85f;
    private final boolean Z;

    public MaterialElevationScale(boolean z) {
        super(o(z), p());
        this.Z = z;
    }

    private static ScaleProvider o(boolean z) {
        ScaleProvider scaleProvider = new ScaleProvider(z);
        scaleProvider.m(X2);
        scaleProvider.l(X2);
        return scaleProvider;
    }

    private static VisibilityAnimatorProvider p() {
        return new FadeProvider();
    }

    public /* bridge */ /* synthetic */ void a(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.a(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @NonNull
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider h() {
        return super.h();
    }

    @Nullable
    public /* bridge */ /* synthetic */ VisibilityAnimatorProvider i() {
        return super.i();
    }

    public /* bridge */ /* synthetic */ boolean m(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return super.m(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void n(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.n(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public boolean q() {
        return this.Z;
    }
}
