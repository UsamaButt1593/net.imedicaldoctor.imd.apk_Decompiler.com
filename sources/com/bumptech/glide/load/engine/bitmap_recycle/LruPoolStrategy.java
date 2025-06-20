package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

interface LruPoolStrategy {
    String a(int i2, int i3, Bitmap.Config config);

    int b(Bitmap bitmap);

    String c(Bitmap bitmap);

    void e(Bitmap bitmap);

    @Nullable
    Bitmap f(int i2, int i3, Bitmap.Config config);

    @Nullable
    Bitmap removeLast();
}
