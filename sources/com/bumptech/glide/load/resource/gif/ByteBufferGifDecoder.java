package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f18367f = "BufferGifDecoder";

    /* renamed from: g  reason: collision with root package name */
    private static final GifDecoderFactory f18368g = new GifDecoderFactory();

    /* renamed from: h  reason: collision with root package name */
    private static final GifHeaderParserPool f18369h = new GifHeaderParserPool();

    /* renamed from: a  reason: collision with root package name */
    private final Context f18370a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f18371b;

    /* renamed from: c  reason: collision with root package name */
    private final GifHeaderParserPool f18372c;

    /* renamed from: d  reason: collision with root package name */
    private final GifDecoderFactory f18373d;

    /* renamed from: e  reason: collision with root package name */
    private final GifBitmapProvider f18374e;

    @VisibleForTesting
    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: package-private */
        public GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i2);
        }
    }

    @VisibleForTesting
    static class GifHeaderParserPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<GifHeaderParser> f18375a = Util.f(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            try {
                poll = this.f18375a.poll();
                if (poll == null) {
                    poll = new GifHeaderParser();
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
            return poll.q(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f18375a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context) {
        this(context, Glide.d(context).m().g(), Glide.d(context).g(), Glide.d(context).f());
    }

    @Nullable
    private GifDrawableResource c(ByteBuffer byteBuffer, int i2, int i3, GifHeaderParser gifHeaderParser, Options options) {
        long b2 = LogTime.b();
        try {
            GifHeader d2 = gifHeaderParser.d();
            if (d2.b() > 0) {
                if (d2.c() == 0) {
                    Bitmap.Config config = options.c(GifOptions.f18396a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    GifDecoder a2 = this.f18373d.a(this.f18374e, d2, byteBuffer, e(d2, i2, i3));
                    a2.k(config);
                    a2.g();
                    Bitmap f2 = a2.f();
                    if (f2 == null) {
                        if (Log.isLoggable(f18367f, 2)) {
                            Log.v(f18367f, "Decoded GIF from stream in " + LogTime.a(b2));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f18370a, a2, UnitTransformation.c(), i2, i3, f2));
                    if (Log.isLoggable(f18367f, 2)) {
                        Log.v(f18367f, "Decoded GIF from stream in " + LogTime.a(b2));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable(f18367f, 2)) {
                Log.v(f18367f, "Decoded GIF from stream in " + LogTime.a(b2));
            }
        }
    }

    private static int e(GifHeader gifHeader, int i2, int i3) {
        int min = Math.min(gifHeader.a() / i3, gifHeader.d() / i2);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable(f18367f, 2) && max > 1) {
            Log.v(f18367f, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + gifHeader.d() + "x" + gifHeader.a() + "]");
        }
        return max;
    }

    /* renamed from: d */
    public GifDrawableResource b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull Options options) {
        GifHeaderParser a2 = this.f18372c.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, a2, options);
        } finally {
            this.f18372c.b(a2);
        }
    }

    /* renamed from: f */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return !((Boolean) options.c(GifOptions.f18397b)).booleanValue() && ImageHeaderParserUtils.f(this.f18371b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f18369h, f18368g);
    }

    @VisibleForTesting
    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f18370a = context.getApplicationContext();
        this.f18371b = list;
        this.f18373d = gifDecoderFactory;
        this.f18374e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f18372c = gifHeaderParserPool;
    }
}
