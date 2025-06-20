package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@RequiresApi(21)
public final class MaterialSharedAxis extends MaterialVisibility<VisibilityAnimatorProvider> {
    public static final int Y2 = 0;
    public static final int Z2 = 1;
    public static final int a3 = 2;
    @AttrRes
    private static final int b3 = R.attr.Ed;
    @AttrRes
    private static final int c3 = R.attr.Vd;
    private final boolean X2;
    private final int Z;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Axis {
    }

    public MaterialSharedAxis(int i2, boolean z) {
        super(o(i2, z), p());
        this.Z = i2;
        this.X2 = z;
    }

    private static VisibilityAnimatorProvider o(int i2, boolean z) {
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

    private static VisibilityAnimatorProvider p() {
        return new FadeThroughProvider();
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
        return b3;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g(boolean z) {
        return c3;
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

    public int q() {
        return this.Z;
    }

    public boolean r() {
        return this.X2;
    }
}
