package com.airbnb.lottie.value;

public interface SimpleLottieValueCallback<T> {
    T a(LottieFrameInfo<T> lottieFrameInfo);
}
