package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

class DataCacheWriter<DataType> implements DiskCache.Writer {

    /* renamed from: a  reason: collision with root package name */
    private final Encoder<DataType> f17873a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f17874b;

    /* renamed from: c  reason: collision with root package name */
    private final Options f17875c;

    DataCacheWriter(Encoder<DataType> encoder, DataType datatype, Options options) {
        this.f17873a = encoder;
        this.f17874b = datatype;
        this.f17875c = options;
    }

    public boolean a(@NonNull File file) {
        return this.f17873a.a(this.f17874b, file, this.f17875c);
    }
}
