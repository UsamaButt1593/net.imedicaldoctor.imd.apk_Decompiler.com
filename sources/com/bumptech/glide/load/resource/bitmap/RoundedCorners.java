package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18326d = "com.bumptech.glide.load.resource.bitmap.RoundedCorners";

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f18327e = f18326d.getBytes(Key.f17830b);

    /* renamed from: c  reason: collision with root package name */
    private final int f18328c;

    public RoundedCorners(int i2) {
        Preconditions.a(i2 > 0, "roundingRadius must be greater than 0.");
        this.f18328c = i2;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18327e);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f18328c).array());
    }

    /* access modifiers changed from: protected */
    public Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.q(bitmapPool, bitmap, this.f18328c);
    }

    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.f18328c == ((RoundedCorners) obj).f18328c;
    }

    public int hashCode() {
        return Util.o(-569625254, Util.n(this.f18328c));
    }
}
