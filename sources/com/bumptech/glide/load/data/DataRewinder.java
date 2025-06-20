package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import java.io.IOException;

public interface DataRewinder<T> {

    public interface Factory<T> {
        @NonNull
        Class<T> a();

        @NonNull
        DataRewinder<T> b(@NonNull T t);
    }

    @NonNull
    T a() throws IOException;

    void b();
}
