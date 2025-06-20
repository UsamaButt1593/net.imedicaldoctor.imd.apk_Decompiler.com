package com.google.android.material.transition.platform;

import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FadeModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FadeModeEvaluator f22156a = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.a(255, TransitionUtils.p(0, 255, f3, f4, f2));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FadeModeEvaluator f22157b = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f4, f2), 255);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final FadeModeEvaluator f22158c = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f4, f2), TransitionUtils.p(0, 255, f3, f4, f2));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final FadeModeEvaluator f22159d = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            float f6 = ((f4 - f3) * f5) + f3;
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f6, f2), TransitionUtils.p(0, 255, f6, f4, f2));
        }
    };

    private FadeModeEvaluators() {
    }

    static FadeModeEvaluator a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? f22156a : f22157b;
        }
        if (i2 == 1) {
            return z ? f22157b : f22156a;
        }
        if (i2 == 2) {
            return f22158c;
        }
        if (i2 == 3) {
            return f22159d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i2);
    }
}
