package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;

public class MotionTiming {

    /* renamed from: a  reason: collision with root package name */
    private long f20782a;

    /* renamed from: b  reason: collision with root package name */
    private long f20783b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f20784c;

    /* renamed from: d  reason: collision with root package name */
    private int f20785d;

    /* renamed from: e  reason: collision with root package name */
    private int f20786e;

    public MotionTiming(long j2, long j3) {
        this.f20784c = null;
        this.f20785d = 0;
        this.f20786e = 1;
        this.f20782a = j2;
        this.f20783b = j3;
    }

    @NonNull
    static MotionTiming b(@NonNull ValueAnimator valueAnimator) {
        MotionTiming motionTiming = new MotionTiming(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        motionTiming.f20785d = valueAnimator.getRepeatCount();
        motionTiming.f20786e = valueAnimator.getRepeatMode();
        return motionTiming;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return AnimationUtils.f20767b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return AnimationUtils.f20768c;
        }
        return interpolator instanceof DecelerateInterpolator ? AnimationUtils.f20769d : interpolator;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f20782a;
    }

    public long d() {
        return this.f20783b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f20784c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.f20767b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (c() == motionTiming.c() && d() == motionTiming.d() && g() == motionTiming.g() && h() == motionTiming.h()) {
            return e().getClass().equals(motionTiming.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f20785d;
    }

    public int h() {
        return this.f20786e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return 10 + getClass().getName() + ASCIIPropertyListParser.f18652j + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public MotionTiming(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.f20785d = 0;
        this.f20786e = 1;
        this.f20782a = j2;
        this.f20783b = j3;
        this.f20784c = timeInterpolator;
    }
}
