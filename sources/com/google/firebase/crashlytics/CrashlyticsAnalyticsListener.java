package com.google.firebase.crashlytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver;
import java.util.Locale;

class CrashlyticsAnalyticsListener implements AnalyticsConnector.AnalyticsConnectorListener {

    /* renamed from: c  reason: collision with root package name */
    static final String f23472c = "_o";

    /* renamed from: d  reason: collision with root package name */
    static final String f23473d = "name";

    /* renamed from: e  reason: collision with root package name */
    static final String f23474e = "params";

    /* renamed from: f  reason: collision with root package name */
    static final String f23475f = "clx";

    /* renamed from: a  reason: collision with root package name */
    private AnalyticsEventReceiver f23476a;

    /* renamed from: b  reason: collision with root package name */
    private AnalyticsEventReceiver f23477b;

    CrashlyticsAnalyticsListener() {
    }

    private static void b(@Nullable AnalyticsEventReceiver analyticsEventReceiver, @NonNull String str, @NonNull Bundle bundle) {
        if (analyticsEventReceiver != null) {
            analyticsEventReceiver.y(str, bundle);
        }
    }

    private void c(@NonNull String str, @NonNull Bundle bundle) {
        b(f23475f.equals(bundle.getString(f23472c)) ? this.f23476a : this.f23477b, str, bundle);
    }

    public void a(int i2, @Nullable Bundle bundle) {
        String string;
        Logger.f().k(String.format(Locale.US, "Analytics listener received message. ID: %d, Extras: %s", new Object[]{Integer.valueOf(i2), bundle}));
        if (bundle != null && (string = bundle.getString("name")) != null) {
            Bundle bundle2 = bundle.getBundle(f23474e);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            c(string, bundle2);
        }
    }

    public void d(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.f23477b = analyticsEventReceiver;
    }

    public void e(@Nullable AnalyticsEventReceiver analyticsEventReceiver) {
        this.f23476a = analyticsEventReceiver;
    }
}
