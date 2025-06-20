package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public interface BitmapPool {
    long a();

    void b(int i2);

    void c();

    void d(float f2);

    void e(Bitmap bitmap);

    @NonNull
    Bitmap f(int i2, int i3, Bitmap.Config config);

    @NonNull
    Bitmap g(int i2, int i3, Bitmap.Config config);
}
