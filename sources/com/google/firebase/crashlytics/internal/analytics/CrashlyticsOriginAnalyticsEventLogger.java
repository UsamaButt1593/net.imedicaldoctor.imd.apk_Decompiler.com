package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;

public class CrashlyticsOriginAnalyticsEventLogger implements AnalyticsEventLogger {

    /* renamed from: b  reason: collision with root package name */
    static final String f23522b = "clx";
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final AnalyticsConnector f23523a;

    public CrashlyticsOriginAnalyticsEventLogger(@NonNull AnalyticsConnector analyticsConnector) {
        this.f23523a = analyticsConnector;
    }

    public void a(@NonNull String str, @Nullable Bundle bundle) {
        this.f23523a.c(f23522b, str, bundle);
    }
}
