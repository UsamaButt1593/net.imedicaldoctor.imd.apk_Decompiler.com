package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ExternalPrivacyContext;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ExternalPrivacyContext {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ExternalPrivacyContext a();

        @NonNull
        public abstract Builder b(@Nullable ExternalPRequestContext externalPRequestContext);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ExternalPrivacyContext.Builder();
    }

    @Nullable
    public abstract ExternalPRequestContext b();
}
