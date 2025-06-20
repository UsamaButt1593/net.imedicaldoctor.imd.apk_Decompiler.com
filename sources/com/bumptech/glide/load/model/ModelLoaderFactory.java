package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;

public interface ModelLoaderFactory<T, Y> {
    void a();

    @NonNull
    ModelLoader<T, Y> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory);
}
