package com.airbnb.lottie.utils;

public class MeanCalculator {

    /* renamed from: a  reason: collision with root package name */
    private float f17344a;

    /* renamed from: b  reason: collision with root package name */
    private int f17345b;

    public void a(float f2) {
        float f3 = this.f17344a + f2;
        this.f17344a = f3;
        int i2 = this.f17345b + 1;
        this.f17345b = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.f17344a = f3 / 2.0f;
            this.f17345b = i2 / 2;
        }
    }

    public float b() {
        int i2 = this.f17345b;
        if (i2 == 0) {
            return 0.0f;
        }
        return this.f17344a / ((float) i2);
    }
}
