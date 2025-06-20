package com.google.android.material.transition;

class FadeModeResult {

    /* renamed from: a  reason: collision with root package name */
    final int f22095a;

    /* renamed from: b  reason: collision with root package name */
    final int f22096b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f22097c;

    private FadeModeResult(int i2, int i3, boolean z) {
        this.f22095a = i2;
        this.f22096b = i3;
        this.f22097c = z;
    }

    static FadeModeResult a(int i2, int i3) {
        return new FadeModeResult(i2, i3, true);
    }

    static FadeModeResult b(int i2, int i3) {
        return new FadeModeResult(i2, i3, false);
    }
}
