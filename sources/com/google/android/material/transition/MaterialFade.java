package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final float f4 = 0.8f;
    private static final float g4 = 0.3f;
    @AttrRes
    private static final int h4 = R.attr.Ld;
    @AttrRes
    private static final int i4 = R.attr.Od;
    @AttrRes
    private static final int j4 = R.attr.Ud;
    @AttrRes
    private static final int k4 = R.attr.Td;

    public MaterialFade() {
        super(r2(), u2());
    }

    private static FadeProvider r2() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.e(g4);
        return fadeProvider;
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
    @NonNull
    public TimeInterpolator f2(boolean z) {
        return AnimationUtils.f20766a;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g2(boolean z) {
        return z ? h4 : i4;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int i2(boolean z) {
        return z ? j4 : k4;
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
