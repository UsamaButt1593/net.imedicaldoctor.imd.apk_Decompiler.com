package com.bumptech.glide.load;

import android.content.Context;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

public interface Transformation<T> extends Key {
    @NonNull
    Resource<T> b(@NonNull Context context, @NonNull Resource<T> resource, int i2, int i3);
}
