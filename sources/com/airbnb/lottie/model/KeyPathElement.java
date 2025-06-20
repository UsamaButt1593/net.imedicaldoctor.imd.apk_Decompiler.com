package com.airbnb.lottie.model;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface KeyPathElement {
    void c(KeyPath keyPath, int i2, List<KeyPath> list, KeyPath keyPath2);

    <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback);
}
