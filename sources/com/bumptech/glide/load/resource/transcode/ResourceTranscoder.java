package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

public interface ResourceTranscoder<Z, R> {
    @Nullable
    Resource<R> a(@NonNull Resource<Z> resource, @NonNull Options options);
}
