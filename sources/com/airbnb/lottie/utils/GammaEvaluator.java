package com.airbnb.lottie.utils;

public class GammaEvaluator {
    private static float a(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    private static float b(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow((double) f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    public static int c(float f2, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f3 = ((float) ((i2 >> 24) & 255)) / 255.0f;
        float a2 = a(((float) ((i2 >> 16) & 255)) / 255.0f);
        float a3 = a(((float) ((i2 >> 8) & 255)) / 255.0f);
        float a4 = a(((float) (i2 & 255)) / 255.0f);
        float a5 = a(((float) ((i3 >> 16) & 255)) / 255.0f);
        float a6 = a(((float) ((i3 >> 8) & 255)) / 255.0f);
        float a7 = a4 + (f2 * (a(((float) (i3 & 255)) / 255.0f) - a4));
        return (Math.round(b(a2 + ((a5 - a2) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((float) ((i3 >> 24) & 255)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(b(a3 + ((a6 - a3) * f2)) * 255.0f) << 8) | Math.round(b(a7) * 255.0f);
    }
}
