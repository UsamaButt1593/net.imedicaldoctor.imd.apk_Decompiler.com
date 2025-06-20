package com.airbnb.lottie.value;

import android.view.animation.Interpolator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieInterpolatedIntegerValue extends LottieInterpolatedValue<Integer> {
    public LottieInterpolatedIntegerValue(Integer num, Integer num2) {
        super(num, num2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Integer e(Integer num, Integer num2, float f2) {
        return Integer.valueOf(MiscUtils.k(num.intValue(), num2.intValue(), f2));
    }

    public LottieInterpolatedIntegerValue(Integer num, Integer num2, Interpolator interpolator) {
        super(num, num2, interpolator);
    }
}
