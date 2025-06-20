package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.AutoValue_InstallationResponse;

@AutoValue
public abstract class InstallationResponse {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract InstallationResponse a();

        @NonNull
        public abstract Builder b(@NonNull TokenResult tokenResult);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(@NonNull String str);

        @NonNull
        public abstract Builder e(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder f(@NonNull String str);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_InstallationResponse.Builder();
    }

    @Nullable
    public abstract TokenResult b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract ResponseCode e();

    @Nullable
    public abstract String f();

    @NonNull
    public abstract Builder g();
}
