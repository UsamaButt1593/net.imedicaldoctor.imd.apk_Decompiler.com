package com.google.android.material.transition.platform;

import android.graphics.RectF;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class FitModeEvaluators {

    /* renamed from: a  reason: collision with root package name */
    private static final FitModeEvaluator f22166a = new FitModeEvaluator() {
        public FitModeResult a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float o = TransitionUtils.o(f5, f7, f3, f4, f2, true);
            float f9 = o / f5;
            float f10 = o / f7;
            return new FitModeResult(f9, f10, o, f6 * f9, o, f8 * f10);
        }

        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f22171d > fitModeResult.f22173f;
        }

        public void c(RectF rectF, float f2, FitModeResult fitModeResult) {
            rectF.bottom -= Math.abs(fitModeResult.f22173f - fitModeResult.f22171d) * f2;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FitModeEvaluator f22167b = new FitModeEvaluator() {
        public FitModeResult a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float o = TransitionUtils.o(f6, f8, f3, f4, f2, true);
            float f9 = o / f6;
            float f10 = o / f8;
            return new FitModeResult(f9, f10, f5 * f9, o, f7 * f10, o);
        }

        public boolean b(FitModeResult fitModeResult) {
            return fitModeResult.f22170c > fitModeResult.f22172e;
        }

        public void c(RectF rectF, float f2, FitModeResult fitModeResult) {
            float abs = (Math.abs(fitModeResult.f22172e - fitModeResult.f22170c) / 2.0f) * f2;
            rectF.left += abs;
            rectF.right -= abs;
        }
    };

    private FitModeEvaluators() {
    }

    static FitModeEvaluator a(int i2, boolean z, RectF rectF, RectF rectF2) {
        if (i2 == 0) {
            return b(z, rectF, rectF2) ? f22166a : f22167b;
        }
        if (i2 == 1) {
            return f22166a;
        }
        if (i2 == 2) {
            return f22167b;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x001e A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(boolean r4, android.graphics.RectF r5, android.graphics.RectF r6) {
        /*
            float r0 = r5.width()
            float r5 = r5.height()
            float r1 = r6.width()
            float r6 = r6.height()
            float r2 = r6 * r0
            float r2 = r2 / r1
            float r1 = r1 * r5
            float r1 = r1 / r0
            r0 = 0
            r3 = 1
            if (r4 == 0) goto L_0x0020
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
        L_0x001e:
            r0 = 1
            goto L_0x0025
        L_0x0020:
            int r4 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x0025
            goto L_0x001e
        L_0x0025:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transition.platform.FitModeEvaluators.b(boolean, android.graphics.RectF, android.graphics.RectF):boolean");
    }
}
