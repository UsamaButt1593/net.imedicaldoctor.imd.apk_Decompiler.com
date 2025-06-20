package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.platform.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

@RequiresApi(21)
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    @Nullable
    private VisibilityAnimatorProvider X;
    private final List<VisibilityAnimatorProvider> Y = new ArrayList();
    private final P s;

    protected MaterialVisibility(P p, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.s = p;
        this.X = visibilityAnimatorProvider;
    }

    private static void b(List<Animator> list, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        if (visibilityAnimatorProvider != null) {
            Animator a2 = z ? visibilityAnimatorProvider.a(viewGroup, view) : visibilityAnimatorProvider.b(viewGroup, view);
            if (a2 != null) {
                list.add(a2);
            }
        }
    }

    private Animator d(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        b(arrayList, this.s, viewGroup, view, z);
        b(arrayList, this.X, viewGroup, view, z);
        for (VisibilityAnimatorProvider b2 : this.Y) {
            b(arrayList, b2, viewGroup, view, z);
        }
        l(viewGroup.getContext(), z);
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void l(@NonNull Context context, boolean z) {
        TransitionUtils.s(this, context, f(z));
        TransitionUtils.t(this, context, g(z), e(z));
    }

    public void a(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.Y.add(visibilityAnimatorProvider);
    }

    public void c() {
        this.Y.clear();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TimeInterpolator e(boolean z) {
        return AnimationUtils.f20767b;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int f(boolean z) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g(boolean z) {
        return 0;
    }

    @NonNull
    public P h() {
        return this.s;
    }

    @Nullable
    public VisibilityAnimatorProvider i() {
        return this.X;
    }

    public boolean m(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.Y.remove(visibilityAnimatorProvider);
    }

    public void n(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.X = visibilityAnimatorProvider;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return d(viewGroup, view, true);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return d(viewGroup, view, false);
    }
}
