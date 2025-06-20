package com.google.firebase.installations;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.AutoValue_InstallationTokenResult;

@AutoValue
public abstract class InstallationTokenResult {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract InstallationTokenResult a();

        @NonNull
        public abstract Builder b(@NonNull String str);

        @NonNull
        public abstract Builder c(long j2);

        @NonNull
        public abstract Builder d(long j2);
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_InstallationTokenResult.Builder();
    }

    @NonNull
    public abstract String b();

    @NonNull
    public abstract long c();

    @NonNull
    public abstract long d();

    @NonNull
    public abstract Builder e();
}
