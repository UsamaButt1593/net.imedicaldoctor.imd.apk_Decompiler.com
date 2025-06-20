package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Util;

public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {

    private static final class NonOwnedBitmapResource implements Resource<Bitmap> {
        private final Bitmap s;

        NonOwnedBitmapResource(@NonNull Bitmap bitmap) {
            this.s = bitmap;
        }

        public int a() {
            return Util.h(this.s);
        }

        @NonNull
        /* renamed from: b */
        public Bitmap get() {
            return this.s;
        }

        @NonNull
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public void recycle() {
        }
    }

    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull Bitmap bitmap, int i2, int i3, @NonNull Options options) {
        return new NonOwnedBitmapResource(bitmap);
    }

    /* renamed from: d */
    public boolean a(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }
}
