package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class BackendRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract BackendRequest a();

        public abstract Builder b(Iterable<EventInternal> iterable);

        public abstract Builder c(@Nullable byte[] bArr);
    }

    public static Builder a() {
        return new AutoValue_BackendRequest.Builder();
    }

    public static BackendRequest b(Iterable<EventInternal> iterable) {
        return a().b(iterable).a();
    }

    public abstract Iterable<EventInternal> c();

    @Nullable
    public abstract byte[] d();
}
