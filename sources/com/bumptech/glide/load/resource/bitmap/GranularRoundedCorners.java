package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class GranularRoundedCorners extends BitmapTransformation {

    /* renamed from: g  reason: collision with root package name */
    private static final String f18295g = "com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners";

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f18296h = f18295g.getBytes(Key.f17830b);

    /* renamed from: c  reason: collision with root package name */
    private final float f18297c;

    /* renamed from: d  reason: collision with root package name */
    private final float f18298d;

    /* renamed from: e  reason: collision with root package name */
    private final float f18299e;

    /* renamed from: f  reason: collision with root package name */
    private final float f18300f;

    public GranularRoundedCorners(float f2, float f3, float f4, float f5) {
        this.f18297c = f2;
        this.f18298d = f3;
        this.f18299e = f4;
        this.f18300f = f5;
    }

    public void a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f18296h);
        messageDigest.update(ByteBuffer.allocate(16).putFloat(this.f18297c).putFloat(this.f18298d).putFloat(this.f18299e).putFloat(this.f18300f).array());
    }

    /* access modifiers changed from: protected */
    public Bitmap c(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i2, int i3) {
        return TransformationUtils.p(bitmapPool, bitmap, this.f18297c, this.f18298d, this.f18299e, this.f18300f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GranularRoundedCorners)) {
            return false;
        }
        GranularRoundedCorners granularRoundedCorners = (GranularRoundedCorners) obj;
        return this.f18297c == granularRoundedCorners.f18297c && this.f18298d == granularRoundedCorners.f18298d && this.f18299e == granularRoundedCorners.f18299e && this.f18300f == granularRoundedCorners.f18300f;
    }

    public int hashCode() {
        return Util.m(this.f18300f, Util.m(this.f18299e, Util.m(this.f18298d, Util.o(-2013597734, Util.l(this.f18297c)))));
    }
}
