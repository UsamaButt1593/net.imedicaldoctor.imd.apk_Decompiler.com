package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f17151a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f17152b;

    public GradientColor(float[] fArr, int[] iArr) {
        this.f17151a = fArr;
        this.f17152b = iArr;
    }

    public int[] a() {
        return this.f17152b;
    }

    public float[] b() {
        return this.f17151a;
    }

    public int c() {
        return this.f17152b.length;
    }

    public void d(GradientColor gradientColor, GradientColor gradientColor2, float f2) {
        if (gradientColor.f17152b.length == gradientColor2.f17152b.length) {
            for (int i2 = 0; i2 < gradientColor.f17152b.length; i2++) {
                this.f17151a[i2] = MiscUtils.j(gradientColor.f17151a[i2], gradientColor2.f17151a[i2], f2);
                this.f17152b[i2] = GammaEvaluator.c(f2, gradientColor.f17152b[i2], gradientColor2.f17152b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + gradientColor.f17152b.length + " vs " + gradientColor2.f17152b.length + ")");
    }
}
