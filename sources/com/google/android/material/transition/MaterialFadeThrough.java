package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.google.android.material.R;

public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
    private static final float f4 = 0.92f;
    @AttrRes
    private static final int g4 = R.attr.Ed;
    @AttrRes
    private static final int h4 = R.attr.Vd;

    public MaterialFadeThrough() {
        super(r2(), u2());
    }

    private static FadeThroughProvider r2() {
        return new FadeThroughProvider();
    }

    private static VisibilityAnimatorProvider u2() {
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.o(false);
        scaleProvider.l(f4);
        return scaleProvider;
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
        return g4;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int i2(boolean z) {
        return h4;
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
}
