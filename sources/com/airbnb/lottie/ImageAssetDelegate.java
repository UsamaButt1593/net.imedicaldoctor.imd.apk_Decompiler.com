package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

public interface ImageAssetDelegate {
    @Nullable
    Bitmap a(LottieImageAsset lottieImageAsset);
}
