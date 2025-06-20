package com.google.android.material.internal;

import androidx.annotation.FloatRange;

final class FadeThroughUtils {

    /* renamed from: a  reason: collision with root package name */
    static final float f21520a = 0.5f;

    private FadeThroughUtils() {
    }

    static void a(@FloatRange(from = 0.0d, to = 1.0d) float f2, float[] fArr) {
        if (f2 <= 0.5f) {
            fArr[0] = 1.0f - (f2 * 2.0f);
            fArr[1] = 0.0f;
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = (f2 * 2.0f) - 1.0f;
    }
}
