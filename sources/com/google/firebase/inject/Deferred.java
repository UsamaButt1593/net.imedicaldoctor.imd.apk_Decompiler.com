package com.google.firebase.inject;

import androidx.annotation.NonNull;
import com.google.firebase.annotations.DeferredApi;

public interface Deferred<T> {

    public interface DeferredHandler<T> {
        @DeferredApi
        void a(Provider<T> provider);
    }

    void a(@NonNull DeferredHandler<T> deferredHandler);
}
