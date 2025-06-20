package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CircleCrop extends BitmapTransformation {

    /* renamed from: c  reason: collision with root package name */
    private static final int f18247c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final String f18248d = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f18249e = f18248d.getBytes(Key.f17830b);

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18249e);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.d(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof CircleCrop;
    }

    public int hashCode() {
        return 1101716364;
    }
}
