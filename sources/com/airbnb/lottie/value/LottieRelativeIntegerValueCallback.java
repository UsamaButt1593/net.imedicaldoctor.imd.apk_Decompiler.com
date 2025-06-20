package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    public Integer e(LottieFrameInfo<Integer> lottieFrameInfo) {
        T t = this.f17382c;
        if (t != null) {
            return (Integer) t;
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }

    /* renamed from: f */
    public Integer a(LottieFrameInfo<Integer> lottieFrameInfo) {
        return Integer.valueOf(MiscUtils.k(lottieFrameInfo.g().intValue(), lottieFrameInfo.b().intValue(), lottieFrameInfo.c()) + e(lottieFrameInfo).intValue());
    }
}
