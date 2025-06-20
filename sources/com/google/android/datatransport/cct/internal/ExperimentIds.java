package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_ExperimentIds;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ExperimentIds {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract ExperimentIds a();

        @NonNull
        public abstract Builder b(@Nullable byte[] bArr);

        @NonNull
        public abstract Builder c(@Nullable byte[] bArr);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_ExperimentIds.Builder();
    }

    @Nullable
    public abstract byte[] b();

    @Nullable
    public abstract byte[] c();
}
