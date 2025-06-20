package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f22136a;

    /* renamed from: b  reason: collision with root package name */
    private float f22137b;

    /* renamed from: c  reason: collision with root package name */
    private float f22138c;

    /* renamed from: d  reason: collision with root package name */
    private float f22139d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22140e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22141f;

    public ScaleProvider() {
        this(true);
    }

    private static Animator c(final View view, float f2, float f3) {
        final float scaleX = view.getScaleX();
        final float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{scaleX * f2, scaleX * f3}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{f2 * scaleY, f3 * scaleY})});
        ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                view.setScaleX(scaleX);
                view.setScaleY(scaleY);
            }
        });
        return ofPropertyValuesHolder;
    }

    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f2;
        float f3;
        if (this.f22140e) {
            f2 = this.f22138c;
            f3 = this.f22139d;
        } else {
            f2 = this.f22137b;
            f3 = this.f22136a;
        }
        return c(view, f2, f3);
    }

    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f2;
        float f3;
        if (!this.f22141f) {
            return null;
        }
        if (this.f22140e) {
            f2 = this.f22136a;
            f3 = this.f22137b;
        } else {
            f2 = this.f22139d;
            f3 = this.f22138c;
        }
        return c(view, f2, f3);
    }

    public float d() {
        return this.f22139d;
    }

    public float e() {
        return this.f22138c;
    }

    public float f() {
        return this.f22137b;
    }

    public float g() {
        return this.f22136a;
    }

    public boolean h() {
        return this.f22140e;
    }

    public boolean i() {
        return this.f22141f;
    }

    public void j(boolean z) {
        this.f22140e = z;
    }

    public void k(float f2) {
        this.f22139d = f2;
    }

    public void l(float f2) {
        this.f22138c = f2;
    }

    public void m(float f2) {
        this.f22137b = f2;
    }

    public void n(float f2) {
        this.f22136a = f2;
    }

    public void o(boolean z) {
        this.f22141f = z;
    }

    public ScaleProvider(boolean z) {
        this.f22136a = 1.0f;
        this.f22137b = 1.1f;
        this.f22138c = 0.8f;
        this.f22139d = 1.0f;
        this.f22141f = true;
        this.f22140e = z;
    }
}
