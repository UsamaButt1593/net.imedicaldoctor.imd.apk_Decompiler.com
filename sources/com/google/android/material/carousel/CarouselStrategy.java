package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;

public abstract class CarouselStrategy {

    /* renamed from: a  reason: collision with root package name */
    private float f20943a;

    /* renamed from: b  reason: collision with root package name */
    private float f20944b;

    static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr2[i2] = iArr[i2] * 2;
        }
        return iArr2;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    static float b(float f2, float f3, float f4) {
        return 1.0f - ((f2 - f4) / (f3 - f4));
    }

    public float c() {
        return this.f20944b;
    }

    public float d() {
        return this.f20943a;
    }

    /* access modifiers changed from: package-private */
    public void e(Context context) {
        float f2 = this.f20943a;
        if (f2 <= 0.0f) {
            f2 = CarouselStrategyHelper.h(context);
        }
        this.f20943a = f2;
        float f3 = this.f20944b;
        if (f3 <= 0.0f) {
            f3 = CarouselStrategyHelper.g(context);
        }
        this.f20944b = f3;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public abstract KeylineState g(@NonNull Carousel carousel, @NonNull View view);

    public void h(float f2) {
        this.f20944b = f2;
    }

    public void i(float f2) {
        this.f20943a = f2;
    }

    /* access modifiers changed from: package-private */
    public boolean j(Carousel carousel, int i2) {
        return false;
    }
}
