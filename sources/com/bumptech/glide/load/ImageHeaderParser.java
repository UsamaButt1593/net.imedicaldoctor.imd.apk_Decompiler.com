package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    public static final int f17819a = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean s;

        private ImageType(boolean z) {
            this.s = z;
        }

        public boolean hasAlpha() {
            return this.s;
        }
    }

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException;

    int b(@NonNull ByteBuffer byteBuffer, @NonNull ArrayPool arrayPool) throws IOException;

    @NonNull
    ImageType c(@NonNull InputStream inputStream) throws IOException;

    int d(@NonNull InputStream inputStream, @NonNull ArrayPool arrayPool) throws IOException;
}
