package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    boolean a(@NonNull T t, @NonNull Options options) throws IOException;

    @Nullable
    Resource<Z> b(@NonNull T t, int i2, int i3, @NonNull Options options) throws IOException;
}
