package com.google.android.gms.common.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.service.zao;

@KeepForSdk
public class TelemetryLogging {
    private TelemetryLogging() {
    }

    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient a(@NonNull Context context) {
        return b(context, TelemetryLoggingOptions.X);
    }

    @NonNull
    @KeepForSdk
    public static TelemetryLoggingClient b(@NonNull Context context, @NonNull TelemetryLoggingOptions telemetryLoggingOptions) {
        return new zao(context, telemetryLoggingOptions);
    }
}
