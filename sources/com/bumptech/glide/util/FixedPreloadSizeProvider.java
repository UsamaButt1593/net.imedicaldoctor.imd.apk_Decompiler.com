package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;

public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f18530a;

    public FixedPreloadSizeProvider(int i2, int i3) {
        this.f18530a = new int[]{i2, i3};
    }

    @Nullable
    public int[] a(@NonNull T t, int i2, int i3) {
        return this.f18530a;
    }
}
