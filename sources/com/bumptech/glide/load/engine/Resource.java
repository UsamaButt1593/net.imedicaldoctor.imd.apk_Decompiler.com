package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;

public interface Resource<Z> {
    int a();

    @NonNull
    Class<Z> c();

    @NonNull
    Z get();

    void recycle();
}
