package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Constructor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class StaticLayoutBuilderCompat {
    static final int o = (Build.VERSION.SDK_INT >= 23 ? 1 : 0);
    static final float p = 0.0f;
    static final float q = 1.0f;
    private static final String r = "android.text.TextDirectionHeuristic";
    private static final String s = "android.text.TextDirectionHeuristics";
    private static final String t = "LTR";
    private static final String u = "RTL";
    private static boolean v;
    @Nullable
    private static Constructor<StaticLayout> w;
    @Nullable
    private static Object x;

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f21552a;

    /* renamed from: b  reason: collision with root package name */
    private final TextPaint f21553b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21554c;

    /* renamed from: d  reason: collision with root package name */
    private int f21555d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f21556e;

    /* renamed from: f  reason: collision with root package name */
    private Layout.Alignment f21557f;

    /* renamed from: g  reason: collision with root package name */
    private int f21558g;

    /* renamed from: h  reason: collision with root package name */
    private float f21559h;

    /* renamed from: i  reason: collision with root package name */
    private float f21560i;

    /* renamed from: j  reason: collision with root package name */
    private int f21561j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f21562k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21563l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private TextUtils.TruncateAt f21564m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private StaticLayoutBuilderConfigurer f21565n;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f21552a = charSequence;
        this.f21553b = textPaint;
        this.f21554c = i2;
        this.f21556e = charSequence.length();
        this.f21557f = Layout.Alignment.ALIGN_NORMAL;
        this.f21558g = Integer.MAX_VALUE;
        this.f21559h = 0.0f;
        this.f21560i = 1.0f;
        this.f21561j = o;
        this.f21562k = true;
        this.f21564m = null;
    }

    private void b() throws StaticLayoutBuilderCompatException {
        if (!v) {
            try {
                x = this.f21563l && Build.VERSION.SDK_INT >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls});
                w = declaredConstructor;
                declaredConstructor.setAccessible(true);
                v = true;
            } catch (Exception e2) {
                throw new StaticLayoutBuilderCompatException(e2);
            }
        }
    }

    @NonNull
    public static StaticLayoutBuilderCompat c(@NonNull CharSequence charSequence, @NonNull TextPaint textPaint, @IntRange(from = 0) int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f21552a == null) {
            this.f21552a = "";
        }
        int max = Math.max(0, this.f21554c);
        CharSequence charSequence = this.f21552a;
        if (this.f21558g == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f21553b, (float) max, this.f21564m);
        }
        int min = Math.min(charSequence.length(), this.f21556e);
        this.f21556e = min;
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f21563l && this.f21558g == 1) {
                this.f21557f = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder a2 = StaticLayout.Builder.obtain(charSequence, this.f21555d, min, this.f21553b, max);
            StaticLayout.Builder unused = a2.setAlignment(this.f21557f);
            StaticLayout.Builder unused2 = a2.setIncludePad(this.f21562k);
            StaticLayout.Builder unused3 = a2.setTextDirection(this.f21563l ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f21564m;
            if (truncateAt != null) {
                StaticLayout.Builder unused4 = a2.setEllipsize(truncateAt);
            }
            StaticLayout.Builder unused5 = a2.setMaxLines(this.f21558g);
            float f2 = this.f21559h;
            if (!(f2 == 0.0f && this.f21560i == 1.0f)) {
                StaticLayout.Builder unused6 = a2.setLineSpacing(f2, this.f21560i);
            }
            if (this.f21558g > 1) {
                StaticLayout.Builder unused7 = a2.setHyphenationFrequency(this.f21561j);
            }
            StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer = this.f21565n;
            if (staticLayoutBuilderConfigurer != null) {
                staticLayoutBuilderConfigurer.a(a2);
            }
            return a2.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) Preconditions.l(w)).newInstance(new Object[]{charSequence, Integer.valueOf(this.f21555d), Integer.valueOf(this.f21556e), this.f21553b, Integer.valueOf(max), this.f21557f, Preconditions.l(x), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f21562k), null, Integer.valueOf(max), Integer.valueOf(this.f21558g)});
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat d(@NonNull Layout.Alignment alignment) {
        this.f21557f = alignment;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat e(@Nullable TextUtils.TruncateAt truncateAt) {
        this.f21564m = truncateAt;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat f(@IntRange(from = 0) int i2) {
        this.f21556e = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat g(int i2) {
        this.f21561j = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat h(boolean z) {
        this.f21562k = z;
        return this;
    }

    public StaticLayoutBuilderCompat i(boolean z) {
        this.f21563l = z;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat j(float f2, float f3) {
        this.f21559h = f2;
        this.f21560i = f3;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat k(@IntRange(from = 0) int i2) {
        this.f21558g = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat l(@IntRange(from = 0) int i2) {
        this.f21555d = i2;
        return this;
    }

    @NonNull
    @CanIgnoreReturnValue
    public StaticLayoutBuilderCompat m(@Nullable StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer) {
        this.f21565n = staticLayoutBuilderConfigurer;
        return this;
    }
}
