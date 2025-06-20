package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.R;

@RequiresApi(21)
public final class MaterialFadeThrough extends MaterialVisibility<FadeThroughProvider> {
    @AttrRes
    private static final int X2 = R.attr.Ed;
    @AttrRes
    private static final int Y2 = R.attr.Vd;
    private static final float Z = 0.92f;

    public MaterialFadeThrough() {
        super(o(), p());
    }

    private static FadeThroughProvider o() {
        return new FadeThroughProvider();
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
    @AttrRes
    public int f(boolean z) {
        return X2;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g(boolean z) {
        return Y2;
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
