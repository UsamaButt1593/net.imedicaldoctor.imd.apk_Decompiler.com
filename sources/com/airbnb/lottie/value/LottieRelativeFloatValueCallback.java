package com.airbnb.lottie.value;

import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    public LottieRelativeFloatValueCallback() {
    }

    public Float e(LottieFrameInfo<Float> lottieFrameInfo) {
        T t = this.f17382c;
        if (t != null) {
            return (Float) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* renamed from: f */
    public Float a(LottieFrameInfo<Float> lottieFrameInfo) {
        return Float.valueOf(MiscUtils.j(lottieFrameInfo.g().floatValue(), lottieFrameInfo.b().floatValue(), lottieFrameInfo.c()) + e(lottieFrameInfo).floatValue());
    }

    public LottieRelativeFloatValueCallback(@NonNull Float f2) {
        super(f2);
    }
}
