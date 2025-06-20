package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@AutoValue
public abstract class LogRequest {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract LogRequest a();

        @NonNull
        public abstract Builder b(@Nullable ClientInfo clientInfo);

        @NonNull
        public abstract Builder c(@Nullable List<LogEvent> list);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Builder d(@Nullable Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Builder e(@Nullable String str);

        @NonNull
        public abstract Builder f(@Nullable QosTier qosTier);

        @NonNull
        public abstract Builder g(long j2);

        @NonNull
        public abstract Builder h(long j2);

        @NonNull
        public Builder i(int i2) {
            return d(Integer.valueOf(i2));
        }

        @NonNull
        public Builder j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static Builder a() {
        return new AutoValue_LogRequest.Builder();
    }

    @Nullable
    public abstract ClientInfo b();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<LogEvent> c();

    @Nullable
    public abstract Integer d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
