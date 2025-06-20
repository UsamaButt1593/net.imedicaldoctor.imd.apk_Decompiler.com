package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FadeModeResult {

    /* renamed from: a  reason: collision with root package name */
    final int f22160a;

    /* renamed from: b  reason: collision with root package name */
    final int f22161b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f22162c;

    private FadeModeResult(int i2, int i3, boolean z) {
        this.f22160a = i2;
        this.f22161b = i3;
        this.f22162c = z;
    }

    static FadeModeResult a(int i2, int i3) {
        return new FadeModeResult(i2, i3, true);
    }

    static FadeModeResult b(int i2, int i3) {
        return new FadeModeResult(i2, i3, false);
    }
}
