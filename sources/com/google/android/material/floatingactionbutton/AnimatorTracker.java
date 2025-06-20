package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

class AnimatorTracker {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Animator f21422a;

    AnimatorTracker() {
    }

    public void a() {
        Animator animator = this.f21422a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.f21422a = null;
    }

    public void c(Animator animator) {
        a();
        this.f21422a = animator;
    }
}
