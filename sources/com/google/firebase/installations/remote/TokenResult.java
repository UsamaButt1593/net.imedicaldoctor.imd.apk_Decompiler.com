package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.firebase.installations.remote.AutoValue_TokenResult;

@AutoValue
public abstract class TokenResult {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract TokenResult a();

        @NonNull
        public abstract Builder b(@NonNull ResponseCode responseCode);

        @NonNull
        public abstract Builder c(@NonNull String str);

        @NonNull
        public abstract Builder d(long j2);
    }

    public enum ResponseCode {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_TokenResult.Builder().d(0);
    }

    @Nullable
    public abstract ResponseCode b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();

    @NonNull
    public abstract Builder e();
}
