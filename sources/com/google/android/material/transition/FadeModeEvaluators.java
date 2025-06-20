package com.google.android.material.transition;

class FadeModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FadeModeEvaluator f22091a = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.a(255, TransitionUtils.p(0, 255, f3, f4, f2));
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FadeModeEvaluator f22092b = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f4, f2), 255);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final FadeModeEvaluator f22093c = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f4, f2), TransitionUtils.p(0, 255, f3, f4, f2));
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final FadeModeEvaluator f22094d = new FadeModeEvaluator() {
        public FadeModeResult a(float f2, float f3, float f4, float f5) {
            float f6 = ((f4 - f3) * f5) + f3;
            return FadeModeResult.b(TransitionUtils.p(255, 0, f3, f6, f2), TransitionUtils.p(0, 255, f6, f4, f2));
        }
    };

    private FadeModeEvaluators() {
    }

    static FadeModeEvaluator a(int i2, boolean z) {
        if (i2 == 0) {
            return z ? f22091a : f22092b;
        }
        if (i2 == 1) {
            return z ? f22092b : f22091a;
        }
        if (i2 == 2) {
            return f22093c;
        }
        if (i2 == 3) {
            return f22094d;
        }
        throw new IllegalArgumentException("Invalid fade mode: " + i2);
    }
}
