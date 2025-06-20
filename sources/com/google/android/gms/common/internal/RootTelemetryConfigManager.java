package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class RootTelemetryConfigManager {
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static RootTelemetryConfigManager f20257b;

    /* renamed from: c  reason: collision with root package name */
    private static final RootTelemetryConfiguration f20258c = new RootTelemetryConfiguration(0, false, false, 0, 0);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private RootTelemetryConfiguration f20259a;

    private RootTelemetryConfigManager() {
    }

    @NonNull
    @KeepForSdk
    public static synchronized RootTelemetryConfigManager b() {
        RootTelemetryConfigManager rootTelemetryConfigManager;
        synchronized (RootTelemetryConfigManager.class) {
            try {
                if (f20257b == null) {
                    f20257b = new RootTelemetryConfigManager();
                }
                rootTelemetryConfigManager = f20257b;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return rootTelemetryConfigManager;
    }

    @KeepForSdk
    @Nullable
    public RootTelemetryConfiguration a() {
        return this.f20259a;
    }

    @VisibleForTesting
    public final synchronized void c(@Nullable RootTelemetryConfiguration rootTelemetryConfiguration) {
        if (rootTelemetryConfiguration == null) {
            this.f20259a = f20258c;
            return;
        }
        RootTelemetryConfiguration rootTelemetryConfiguration2 = this.f20259a;
        if (rootTelemetryConfiguration2 == null || rootTelemetryConfiguration2.getVersion() < rootTelemetryConfiguration.getVersion()) {
            this.f20259a = rootTelemetryConfiguration;
        }
    }
}
