package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.List;

interface MotionStrategy {
    void a();

    void b();

    AnimatorSet c();

    MotionSpec d();

    @AnimatorRes
    int e();

    void f();

    @Nullable
    MotionSpec g();

    boolean h();

    void i(@NonNull Animator.AnimatorListener animatorListener);

    void j(@NonNull Animator.AnimatorListener animatorListener);

    void k(@Nullable MotionSpec motionSpec);

    List<Animator.AnimatorListener> l();

    void m(@Nullable ExtendedFloatingActionButton.OnChangedCallback onChangedCallback);

    void onAnimationStart(Animator animator);
}
