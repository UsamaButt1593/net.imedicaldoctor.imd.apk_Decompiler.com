package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void c(@NonNull Exception exc);

        void f(@Nullable T t);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    @NonNull
    DataSource d();

    void e(@NonNull Priority priority, @NonNull DataCallback<? super T> dataCallback);
}
