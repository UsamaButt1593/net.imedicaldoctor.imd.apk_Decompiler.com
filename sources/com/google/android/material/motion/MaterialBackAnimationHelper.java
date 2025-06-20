package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class MaterialBackAnimationHelper<V extends View> {

    /* renamed from: g  reason: collision with root package name */
    private static final String f21595g = "MaterialBackHelper";

    /* renamed from: h  reason: collision with root package name */
    private static final int f21596h = 300;

    /* renamed from: i  reason: collision with root package name */
    private static final int f21597i = 150;

    /* renamed from: j  reason: collision with root package name */
    private static final int f21598j = 100;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final TimeInterpolator f21599a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    protected final V f21600b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f21601c;

    /* renamed from: d  reason: collision with root package name */
    protected final int f21602d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f21603e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private BackEventCompat f21604f;

    public MaterialBackAnimationHelper(@NonNull V v) {
        this.f21600b = v;
        Context context = v.getContext();
        this.f21599a = MotionUtils.g(context, R.attr.ae, PathInterpolatorCompat.b(0.0f, 0.0f, 0.0f, 1.0f));
        this.f21601c = MotionUtils.f(context, R.attr.Jd, 300);
        this.f21602d = MotionUtils.f(context, R.attr.Od, f21597i);
        this.f21603e = MotionUtils.f(context, R.attr.Nd, 100);
    }

    public float a(float f2) {
        return this.f21599a.getInterpolation(f2);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public BackEventCompat b() {
        if (this.f21604f == null) {
            Log.w(f21595g, "Must call startBackProgress() and updateBackProgress() before cancelBackProgress()");
        }
        BackEventCompat backEventCompat = this.f21604f;
        this.f21604f = null;
        return backEventCompat;
    }

    @Nullable
    public BackEventCompat c() {
        BackEventCompat backEventCompat = this.f21604f;
        this.f21604f = null;
        return backEventCompat;
    }

    /* access modifiers changed from: protected */
    public void d(@NonNull BackEventCompat backEventCompat) {
        this.f21604f = backEventCompat;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public BackEventCompat e(@NonNull BackEventCompat backEventCompat) {
        if (this.f21604f == null) {
            Log.w(f21595g, "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = this.f21604f;
        this.f21604f = backEventCompat;
        return backEventCompat2;
    }
}
