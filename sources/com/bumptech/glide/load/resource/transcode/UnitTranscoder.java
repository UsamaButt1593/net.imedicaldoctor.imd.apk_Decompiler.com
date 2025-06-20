package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitTranscoder<?> f18412a = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> b() {
        return f18412a;
    }

    @Nullable
    public Resource<Z> a(@NonNull Resource<Z> resource, @NonNull Options options) {
        return resource;
    }
}
