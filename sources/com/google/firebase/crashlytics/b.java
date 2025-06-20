package com.google.firebase.crashlytics;

import android.os.Bundle;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;

public final /* synthetic */ class b implements AnalyticsEventLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f23488a;

    public /* synthetic */ b(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f23488a = analyticsDeferredProxy;
    }

    public final void a(String str, Bundle bundle) {
        this.f23488a.g(str, bundle);
    }
}
