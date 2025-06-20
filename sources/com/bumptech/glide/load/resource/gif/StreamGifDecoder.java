package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f18398d = "StreamGifDecoder";

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f18399a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceDecoder<ByteBuffer, GifDrawable> f18400b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f18401c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f18399a = list;
        this.f18400b = resourceDecoder;
        this.f18401c = arrayPool;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable(f18398d, 5)) {
                return null;
            }
            Log.w(f18398d, "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: c */
    public Resource<GifDrawable> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull Options options) throws IOException {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f18400b.b(ByteBuffer.wrap(e2), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
        return !((Boolean) options.c(GifOptions.f18397b)).booleanValue() && ImageHeaderParserUtils.e(this.f18399a, inputStream, this.f18401c) == ImageHeaderParser.ImageType.GIF;
    }
}
