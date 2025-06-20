package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ExternalPRequestContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ExternalPRequestContext {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ExternalPRequestContext a();

        @NonNull
        public abstract Builder b(@Nullable Integer num);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ExternalPRequestContext.Builder();
    }

    @Nullable
    public abstract Integer b();
}
