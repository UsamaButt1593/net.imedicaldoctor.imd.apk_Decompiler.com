package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@Deprecated
public abstract class ExpandableTransformationBehavior extends ExpandableBehavior {
    /* access modifiers changed from: private */
    @Nullable
    public AnimatorSet X2;

    public ExpandableTransformationBehavior() {
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public boolean R(View view, View view2, boolean z, boolean z2) {
        AnimatorSet animatorSet = this.X2;
        boolean z3 = animatorSet != null;
        if (z3) {
            animatorSet.cancel();
        }
        AnimatorSet T = T(view, view2, z, z3);
        this.X2 = T;
        T.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                AnimatorSet unused = ExpandableTransformationBehavior.this.X2 = null;
            }
        });
        this.X2.start();
        if (!z2) {
            this.X2.end();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract AnimatorSet T(View view, View view2, boolean z, boolean z2);

    public ExpandableTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
