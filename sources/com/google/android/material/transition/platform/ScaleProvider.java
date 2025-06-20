package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class ScaleProvider implements VisibilityAnimatorProvider {

    /* renamed from: a  reason: collision with root package name */
    private float f22218a;

    /* renamed from: b  reason: collision with root package name */
    private float f22219b;

    /* renamed from: c  reason: collision with root package name */
    private float f22220c;

    /* renamed from: d  reason: collision with root package name */
    private float f22221d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22222e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22223f;

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
        if (this.f22222e) {
            f2 = this.f22220c;
            f3 = this.f22221d;
        } else {
            f2 = this.f22219b;
            f3 = this.f22218a;
        }
        return c(view, f2, f3);
    }

    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float f2;
        float f3;
        if (!this.f22223f) {
            return null;
        }
        if (this.f22222e) {
            f2 = this.f22218a;
            f3 = this.f22219b;
        } else {
            f2 = this.f22221d;
            f3 = this.f22220c;
        }
        return c(view, f2, f3);
    }

    public float d() {
        return this.f22221d;
    }

    public float e() {
        return this.f22220c;
    }

    public float f() {
        return this.f22219b;
    }

    public float g() {
        return this.f22218a;
    }

    public boolean h() {
        return this.f22222e;
    }

    public boolean i() {
        return this.f22223f;
    }

    public void j(boolean z) {
        this.f22222e = z;
    }

    public void k(float f2) {
        this.f22221d = f2;
    }

    public void l(float f2) {
        this.f22220c = f2;
    }

    public void m(float f2) {
        this.f22219b = f2;
    }

    public void n(float f2) {
        this.f22218a = f2;
    }

    public void o(boolean z) {
        this.f22223f = z;
    }

    public ScaleProvider(boolean z) {
        this.f22218a = 1.0f;
        this.f22219b = 1.1f;
        this.f22220c = 0.8f;
        this.f22221d = 1.0f;
        this.f22223f = true;
        this.f22222e = z;
    }
}
