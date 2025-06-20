package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class StateListAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Tuple> f21546a = new ArrayList<>();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Tuple f21547b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    ValueAnimator f21548c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f21549d = new AnimatorListenerAdapter() {
        public void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.f21548c == animator) {
                stateListAnimator.f21548c = null;
            }
        }
    };

    static class Tuple {

        /* renamed from: a  reason: collision with root package name */
        final int[] f21550a;

        /* renamed from: b  reason: collision with root package name */
        final ValueAnimator f21551b;

        Tuple(int[] iArr, ValueAnimator valueAnimator) {
            this.f21550a = iArr;
            this.f21551b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f21548c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f21548c = null;
        }
    }

    private void e(@NonNull Tuple tuple) {
        ValueAnimator valueAnimator = tuple.f21551b;
        this.f21548c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(iArr, valueAnimator);
        valueAnimator.addListener(this.f21549d);
        this.f21546a.add(tuple);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f21548c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f21548c = null;
        }
    }

    public void d(int[] iArr) {
        Tuple tuple;
        int size = this.f21546a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                tuple = null;
                break;
            }
            tuple = this.f21546a.get(i2);
            if (StateSet.stateSetMatches(tuple.f21550a, iArr)) {
                break;
            }
            i2++;
        }
        Tuple tuple2 = this.f21547b;
        if (tuple != tuple2) {
            if (tuple2 != null) {
                b();
            }
            this.f21547b = tuple;
            if (tuple != null) {
                e(tuple);
            }
        }
    }
}
