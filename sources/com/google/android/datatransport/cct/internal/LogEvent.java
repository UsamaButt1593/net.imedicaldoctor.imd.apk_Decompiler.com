package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LogEvent {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract LogEvent a();

        @NonNull
        public abstract Builder b(@Nullable ComplianceData complianceData);

        @NonNull
        public abstract Builder c(@Nullable Integer num);

        @NonNull
        public abstract Builder d(long j2);

        @NonNull
        public abstract Builder e(long j2);

        @NonNull
        public abstract Builder f(@Nullable ExperimentIds experimentIds);

        @NonNull
        public abstract Builder g(@Nullable NetworkConnectionInfo networkConnectionInfo);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Builder h(@Nullable byte[] bArr);

        /* access modifiers changed from: package-private */
        @NonNull
        public abstract Builder i(@Nullable String str);

        @NonNull
        public abstract Builder j(long j2);
    }

    private static Builder a() {
        return new AutoValue_LogEvent.Builder();
    }

    @NonNull
    public static Builder k(@NonNull String str) {
        return a().i(str);
    }

    @NonNull
    public static Builder l(@NonNull byte[] bArr) {
        return a().h(bArr);
    }

    @Nullable
    public abstract ComplianceData b();

    @Nullable
    public abstract Integer c();

    public abstract long d();

    public abstract long e();

    @Nullable
    public abstract ExperimentIds f();

    @Nullable
    public abstract NetworkConnectionInfo g();

    @Nullable
    public abstract byte[] h();

    @Nullable
    public abstract String i();

    public abstract long j();
}
