package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
import java.util.List;

abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P c4;
    @Nullable
    private VisibilityAnimatorProvider d4;
    private final List<VisibilityAnimatorProvider> e4 = new ArrayList();

    protected MaterialVisibility(P p, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.c4 = p;
        this.d4 = visibilityAnimatorProvider;
    }

    private static void b2(List<Animator> list, @Nullable VisibilityAnimatorProvider visibilityAnimatorProvider, ViewGroup viewGroup, View view, boolean z) {
        if (visibilityAnimatorProvider != null) {
            Animator a2 = z ? visibilityAnimatorProvider.a(viewGroup, view) : visibilityAnimatorProvider.b(viewGroup, view);
            if (a2 != null) {
                list.add(a2);
            }
        }
    }

    private Animator e2(@NonNull ViewGroup viewGroup, @NonNull View view, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        b2(arrayList, this.c4, viewGroup, view, z);
        b2(arrayList, this.d4, viewGroup, view, z);
        for (VisibilityAnimatorProvider b2 : this.e4) {
            b2(arrayList, b2, viewGroup, view, z);
        }
        n2(viewGroup.getContext(), z);
        AnimatorSetCompat.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void n2(@NonNull Context context, boolean z) {
        TransitionUtils.s(this, context, g2(z));
        TransitionUtils.t(this, context, i2(z), f2(z));
    }

    public Animator O1(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e2(viewGroup, view, true);
    }

    public Animator S1(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return e2(viewGroup, view, false);
    }

    public void a2(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.e4.add(visibilityAnimatorProvider);
    }

    public void d2() {
        this.e4.clear();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public TimeInterpolator f2(boolean z) {
        return AnimationUtils.f20767b;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int g2(boolean z) {
        return 0;
    }

    /* access modifiers changed from: package-private */
    @AttrRes
    public int i2(boolean z) {
        return 0;
    }

    @NonNull
    public P j2() {
        return this.c4;
    }

    @Nullable
    public VisibilityAnimatorProvider m2() {
        return this.d4;
    }

    public boolean p2(@NonNull VisibilityAnimatorProvider visibilityAnimatorProvider) {
        return this.e4.remove(visibilityAnimatorProvider);
    }

    public void q2(@Nullable VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.d4 = visibilityAnimatorProvider;
    }

    public boolean u0() {
        return true;
    }
}
