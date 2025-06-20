package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f18376a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f18377b;

    public GifBitmapProvider(BitmapPool bitmapPool) {
        this(bitmapPool, (ArrayPool) null);
    }

    @NonNull
    public Bitmap a(int i2, int i3, @NonNull Bitmap.Config config) {
        return this.f18376a.g(i2, i3, config);
    }

    @NonNull
    public int[] b(int i2) {
        ArrayPool arrayPool = this.f18377b;
        return arrayPool == null ? new int[i2] : (int[]) arrayPool.f(i2, int[].class);
    }

    public void c(@NonNull Bitmap bitmap) {
        this.f18376a.e(bitmap);
    }

    public void d(@NonNull byte[] bArr) {
        ArrayPool arrayPool = this.f18377b;
        if (arrayPool != null) {
            arrayPool.put(bArr);
        }
    }

    @NonNull
    public byte[] e(int i2) {
        ArrayPool arrayPool = this.f18377b;
        return arrayPool == null ? new byte[i2] : (byte[]) arrayPool.f(i2, byte[].class);
    }

    public void f(@NonNull int[] iArr) {
        ArrayPool arrayPool = this.f18377b;
        if (arrayPool != null) {
            arrayPool.put(iArr);
        }
    }

    public GifBitmapProvider(BitmapPool bitmapPool, @Nullable ArrayPool arrayPool) {
        this.f18376a = bitmapPool;
        this.f18377b = arrayPool;
    }
}
