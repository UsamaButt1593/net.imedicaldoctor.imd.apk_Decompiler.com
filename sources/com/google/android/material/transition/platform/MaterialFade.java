package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;

@RequiresApi(21)
public final class MaterialFade extends MaterialVisibility<FadeProvider> {
    private static final float X2 = 0.3f;
    @AttrRes
    private static final int Y2 = R.attr.Ld;
    private static final float Z = 0.8f;
    @AttrRes
    private static final int Z2 = R.attr.Od;
    @AttrRes
    private static final int a3 = R.attr.Ud;
    @AttrRes
    private static final int b3 = R.attr.Td;

    public MaterialFade() {
        super(o(), p());
    }

    private static FadeProvider o() {
        FadeProvider fadeProvider = new FadeProvider();
        fadeProvider.e(X2);
        return fadeProvider;
    }

    private static VisibilityAnimatorProvider p() {
        ScaleProvider scaleProvider = new ScaleProvider();
        scaleProvider.o(false);
        scaleProvider.l(Z);
        return scaleProvider;
    }

    public /* bridge */ /* synthetic */ void a(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        super.a(visibilityAnimatorProvider);
    }

    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TimeInterpolator e(boolean z) {
        return AnimationUtils.f20766a;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int f(boolean z) {
        return z ? Y2 : Z2;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g(boolean z) {
        return z ? a3 : b3;
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
}
