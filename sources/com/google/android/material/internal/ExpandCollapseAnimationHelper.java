package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.animation.AnimationUtils;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ExpandCollapseAnimationHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f21508a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final View f21509b;

    /* renamed from: c  reason: collision with root package name */
    private final List<AnimatorListenerAdapter> f21510c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final List<View> f21511d = new ArrayList();
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f21512e;

    /* renamed from: f  reason: collision with root package name */
    private long f21513f;

    /* renamed from: g  reason: collision with root package name */
    private int f21514g;

    /* renamed from: h  reason: collision with root package name */
    private int f21515h;

    public ExpandCollapseAnimationHelper(@NonNull View view, @NonNull View view2) {
        this.f21508a = view;
        this.f21509b = view2;
    }

    private void f(Animator animator, List<AnimatorListenerAdapter> list) {
        for (AnimatorListenerAdapter addListener : list) {
            animator.addListener(addListener);
        }
    }

    private AnimatorSet g(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{k(z), l(z), i(z)});
        return animatorSet;
    }

    private Animator i(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{(float) ((this.f21509b.getLeft() - this.f21508a.getLeft()) + (this.f21508a.getRight() - this.f21509b.getRight())), 0.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.m(this.f21511d));
        ofFloat.setDuration(this.f21513f);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f20767b));
        return ofFloat;
    }

    private Animator k(boolean z) {
        Rect e2 = ViewUtils.e(this.f21508a, this.f21514g);
        Rect e3 = ViewUtils.e(this.f21509b, this.f21515h);
        Rect rect = new Rect(e2);
        ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), new Object[]{e2, e3});
        ofObject.addUpdateListener(new a(this, rect));
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f21512e;
        if (animatorUpdateListener != null) {
            ofObject.addUpdateListener(animatorUpdateListener);
        }
        ofObject.setDuration(this.f21513f);
        ofObject.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f20767b));
        return ofObject;
    }

    private Animator l(boolean z) {
        List<View> k2 = ViewUtils.k(this.f21509b);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(MultiViewUpdateListener.e(k2));
        ofFloat.setDuration(this.f21513f);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.a(z, AnimationUtils.f20766a));
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m(Rect rect, ValueAnimator valueAnimator) {
        ViewUtils.A(this.f21509b, rect);
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper c(@NonNull Collection<View> collection) {
        this.f21511d.addAll(collection);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper d(@NonNull View... viewArr) {
        Collections.addAll(this.f21511d, viewArr);
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper e(@NonNull AnimatorListenerAdapter animatorListenerAdapter) {
        this.f21510c.add(animatorListenerAdapter);
        return this;
    }

    @NonNull
    public Animator h() {
        AnimatorSet g2 = g(false);
        g2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                ExpandCollapseAnimationHelper.this.f21509b.setVisibility(8);
            }
        });
        f(g2, this.f21510c);
        return g2;
    }

    @NonNull
    public Animator j() {
        AnimatorSet g2 = g(true);
        g2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                ExpandCollapseAnimationHelper.this.f21509b.setVisibility(0);
            }
        });
        f(g2, this.f21510c);
        return g2;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper n(@Nullable ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f21512e = animatorUpdateListener;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper o(int i2) {
        this.f21514g = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper p(long j2) {
        this.f21513f = j2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public ExpandCollapseAnimationHelper q(int i2) {
        this.f21515h = i2;
        return this;
    }
}
