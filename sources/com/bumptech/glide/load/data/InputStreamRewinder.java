package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f17841b = 5242880;

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f17842a;

    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f17843a;

        public Factory(ArrayPool arrayPool) {
            this.f17843a = arrayPool;
        }

        @NonNull
        public Class<InputStream> a() {
            return InputStream.class;
        }

        @NonNull
        /* renamed from: c */
        public DataRewinder<InputStream> b(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f17843a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f17842a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(f17841b);
    }

    public void b() {
        this.f17842a.a();
    }

    public void c() {
        this.f17842a.c();
    }

    @NonNull
    /* renamed from: d */
    public InputStream a() throws IOException {
        this.f17842a.reset();
        return this.f17842a;
    }
}
