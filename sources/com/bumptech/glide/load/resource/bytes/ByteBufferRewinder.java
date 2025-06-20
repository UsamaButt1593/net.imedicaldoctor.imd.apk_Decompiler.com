package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f18357a;

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @NonNull
        /* renamed from: c */
        public DataRewinder<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f18357a = byteBuffer;
    }

    public void b() {
    }

    @NonNull
    /* renamed from: c */
    public ByteBuffer a() {
        this.f18357a.position(0);
        return this.f18357a;
    }
}
