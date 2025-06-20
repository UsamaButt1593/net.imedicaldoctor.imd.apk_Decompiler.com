package com.google.android.gms.common.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

@KeepForSdk
public class TelemetryLoggingOptions implements Api.ApiOptions.Optional {
    @NonNull
    public static final TelemetryLoggingOptions X = a().a();
    @Nullable
    private final String s;

    @KeepForSdk
    public static class Builder {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private String f20268a;

        private Builder() {
        }

        @NonNull
        @KeepForSdk
        public TelemetryLoggingOptions a() {
            return new TelemetryLoggingOptions(this.f20268a, (zaad) null);
        }

        @NonNull
        @KeepForSdk
        public Builder b(@Nullable String str) {
            this.f20268a = str;
            return this;
        }

        /* synthetic */ Builder(zaac zaac) {
        }
    }

    /* synthetic */ TelemetryLoggingOptions(String str, zaad zaad) {
        this.s = str;
    }

    @NonNull
    @KeepForSdk
    public static Builder a() {
        return new Builder((zaac) null);
    }

    @NonNull
    public final Bundle b() {
        Bundle bundle = new Bundle();
        String str = this.s;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TelemetryLoggingOptions)) {
            return false;
        }
        return Objects.b(this.s, ((TelemetryLoggingOptions) obj).s);
    }

    public final int hashCode() {
        return Objects.c(this.s);
    }
}
