package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Collection;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MultiViewUpdateListener implements ValueAnimator.AnimatorUpdateListener {
    private final View[] X;
    private final Listener s;

    interface Listener {
        void a(@NonNull ValueAnimator valueAnimator, @NonNull View view);
    }

    @SuppressLint({"LambdaLast"})
    public MultiViewUpdateListener(@NonNull Listener listener, @NonNull Collection<View> collection) {
        this.s = listener;
        this.X = (View[]) collection.toArray(new View[0]);
    }

    @NonNull
    public static MultiViewUpdateListener e(@NonNull Collection<View> collection) {
        return new MultiViewUpdateListener((Listener) new e(), collection);
    }

    @NonNull
    public static MultiViewUpdateListener f(@NonNull View... viewArr) {
        return new MultiViewUpdateListener((Listener) new e(), viewArr);
    }

    @NonNull
    public static MultiViewUpdateListener g(@NonNull Collection<View> collection) {
        return new MultiViewUpdateListener((Listener) new c(), collection);
    }

    @NonNull
    public static MultiViewUpdateListener h(@NonNull View... viewArr) {
        return new MultiViewUpdateListener((Listener) new c(), viewArr);
    }

    /* access modifiers changed from: private */
    public static void i(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public static void j(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        Float f2 = (Float) valueAnimator.getAnimatedValue();
        view.setScaleX(f2.floatValue());
        view.setScaleY(f2.floatValue());
    }

    /* access modifiers changed from: private */
    public static void k(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setTranslationX(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* access modifiers changed from: private */
    public static void l(@NonNull ValueAnimator valueAnimator, @NonNull View view) {
        view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @NonNull
    public static MultiViewUpdateListener m(@NonNull Collection<View> collection) {
        return new MultiViewUpdateListener((Listener) new b(), collection);
    }

    @NonNull
    public static MultiViewUpdateListener n(@NonNull View... viewArr) {
        return new MultiViewUpdateListener((Listener) new b(), viewArr);
    }

    @NonNull
    public static MultiViewUpdateListener o(@NonNull Collection<View> collection) {
        return new MultiViewUpdateListener((Listener) new d(), collection);
    }

    @NonNull
    public static MultiViewUpdateListener p(@NonNull View... viewArr) {
        return new MultiViewUpdateListener((Listener) new d(), viewArr);
    }

    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        for (View a2 : this.X) {
            this.s.a(valueAnimator, a2);
        }
    }

    @SuppressLint({"LambdaLast"})
    public MultiViewUpdateListener(@NonNull Listener listener, @NonNull View... viewArr) {
        this.s = listener;
        this.X = viewArr;
    }
}
