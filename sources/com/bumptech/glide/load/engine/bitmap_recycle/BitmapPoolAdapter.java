package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

public class BitmapPoolAdapter implements BitmapPool {
    public long a() {
        return 0;
    }

    public void b(int i2) {
    }

    public void c() {
    }

    public void d(float f2) {
    }

    public void e(Bitmap bitmap) {
        bitmap.recycle();
    }

    @NonNull
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    @NonNull
    public Bitmap g(int i2, int i3, Bitmap.Config config) {
        return f(i2, i3, config);
    }
}
