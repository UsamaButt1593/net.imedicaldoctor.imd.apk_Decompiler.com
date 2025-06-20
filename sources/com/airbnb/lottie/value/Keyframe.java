package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.dd.plist.ASCIIPropertyListParser;

public class Keyframe<T> {
    private static final float o = -3987645.8f;
    private static final int p = 784923401;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final LottieComposition f17354a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final T f17355b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public T f17356c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f17357d;

    /* renamed from: e  reason: collision with root package name */
    public final float f17358e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Float f17359f;

    /* renamed from: g  reason: collision with root package name */
    private float f17360g;

    /* renamed from: h  reason: collision with root package name */
    private float f17361h;

    /* renamed from: i  reason: collision with root package name */
    private int f17362i;

    /* renamed from: j  reason: collision with root package name */
    private int f17363j;

    /* renamed from: k  reason: collision with root package name */
    private float f17364k;

    /* renamed from: l  reason: collision with root package name */
    private float f17365l;

    /* renamed from: m  reason: collision with root package name */
    public PointF f17366m;

    /* renamed from: n  reason: collision with root package name */
    public PointF f17367n;

    public Keyframe(LottieComposition lottieComposition, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f2, @Nullable Float f3) {
        this.f17360g = o;
        this.f17361h = o;
        this.f17362i = p;
        this.f17363j = p;
        this.f17364k = Float.MIN_VALUE;
        this.f17365l = Float.MIN_VALUE;
        this.f17366m = null;
        this.f17367n = null;
        this.f17354a = lottieComposition;
        this.f17355b = t;
        this.f17356c = t2;
        this.f17357d = interpolator;
        this.f17358e = f2;
        this.f17359f = f3;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.f17354a == null) {
            return 1.0f;
        }
        if (this.f17365l == Float.MIN_VALUE) {
            if (this.f17359f == null) {
                this.f17365l = 1.0f;
            } else {
                this.f17365l = e() + ((this.f17359f.floatValue() - this.f17358e) / this.f17354a.e());
            }
        }
        return this.f17365l;
    }

    public float c() {
        if (this.f17361h == o) {
            this.f17361h = ((Float) this.f17356c).floatValue();
        }
        return this.f17361h;
    }

    public int d() {
        if (this.f17363j == p) {
            this.f17363j = ((Integer) this.f17356c).intValue();
        }
        return this.f17363j;
    }

    public float e() {
        LottieComposition lottieComposition = this.f17354a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f17364k == Float.MIN_VALUE) {
            this.f17364k = (this.f17358e - lottieComposition.p()) / this.f17354a.e();
        }
        return this.f17364k;
    }

    public float f() {
        if (this.f17360g == o) {
            this.f17360g = ((Float) this.f17355b).floatValue();
        }
        return this.f17360g;
    }

    public int g() {
        if (this.f17362i == p) {
            this.f17362i = ((Integer) this.f17355b).intValue();
        }
        return this.f17362i;
    }

    public boolean h() {
        return this.f17357d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f17355b + ", endValue=" + this.f17356c + ", startFrame=" + this.f17358e + ", endFrame=" + this.f17359f + ", interpolator=" + this.f17357d + ASCIIPropertyListParser.f18653k;
    }

    public Keyframe(T t) {
        this.f17360g = o;
        this.f17361h = o;
        this.f17362i = p;
        this.f17363j = p;
        this.f17364k = Float.MIN_VALUE;
        this.f17365l = Float.MIN_VALUE;
        this.f17366m = null;
        this.f17367n = null;
        this.f17354a = null;
        this.f17355b = t;
        this.f17356c = t;
        this.f17357d = null;
        this.f17358e = Float.MIN_VALUE;
        this.f17359f = Float.valueOf(Float.MAX_VALUE);
    }
}
