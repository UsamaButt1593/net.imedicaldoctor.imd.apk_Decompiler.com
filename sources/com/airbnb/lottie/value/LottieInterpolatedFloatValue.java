package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedFloatValue extends LottieInterpolatedValue<Float> {
    public LottieInterpolatedFloatValue(Float f2, Float f3) {
        super(f2, f3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Float e(Float f2, Float f3, float f4) {
        return Float.valueOf(MiscUtils.j(f2.floatValue(), f3.floatValue(), f4));
    }

    public LottieInterpolatedFloatValue(Float f2, Float f3, Interpolator interpolator) {
        super(f2, f3, interpolator);
    }
}
