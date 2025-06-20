package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f18329a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f18330b;

    static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f18331a;

        /* renamed from: b  reason: collision with root package name */
        private final ExceptionCatchingInputStream f18332b;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f18331a = recyclableBufferedInputStream;
            this.f18332b = exceptionCatchingInputStream;
        }

        public void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException c2 = this.f18332b.c();
            if (c2 != null) {
                if (bitmap != null) {
                    bitmapPool.e(bitmap);
                }
                throw c2;
            }
        }

        public void b() {
            this.f18331a.c();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f18329a = downsampler;
        this.f18330b = arrayPool;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f18330b);
            z = true;
        }
        ExceptionCatchingInputStream d2 = ExceptionCatchingInputStream.d(recyclableBufferedInputStream);
        try {
            return this.f18329a.g(new MarkEnforcingInputStream(d2), i2, i3, options, new UntrustedCallbacks(recyclableBufferedInputStream, d2));
        } finally {
            d2.a();
            if (z) {
                recyclableBufferedInputStream.a();
            }
        }
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull Options options) {
        return this.f18329a.p(inputStream);
    }
}
