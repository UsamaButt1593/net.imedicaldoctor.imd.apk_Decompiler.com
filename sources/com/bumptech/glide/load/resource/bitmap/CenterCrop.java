package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

public class CenterCrop extends BitmapTransformation {

    /* renamed from: c  reason: collision with root package name */
    private static final String f18243c = "com.bumptech.glide.load.resource.bitmap.CenterCrop";

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f18244d = f18243c.getBytes(Key.f17830b);

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18244d);
    }

    /* access modifiers changed from: protected */
    public Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.b(bitmapPool, bitmap, i2, i3);
    }

    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    public int hashCode() {
        return -599754482;
    }
}
