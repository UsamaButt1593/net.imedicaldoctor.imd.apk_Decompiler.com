package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class Rotate extends BitmapTransformation {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18323d = "com.bumptech.glide.load.resource.bitmap.Rotate";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f18324e = f18323d.getBytes(Key.f17830b);

    /* renamed from: c  reason: collision with root package name */
    private final int f18325c;

    public Rotate(int i2) {
        this.f18325c = i2;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18324e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18325c).array());
    }

    /* access modifiers changed from: protected */
    public Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.n(bitmap, this.f18325c);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Rotate) && this.f18325c == ((Rotate) obj).f18325c;
    }

    public int hashCode() {
        return Util.o(-950519196, Util.n(this.f18325c));
    }
}
