package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public final /* synthetic */ class a implements BreadcrumbSource {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f23487a;

    public /* synthetic */ a(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f23487a = analyticsDeferredProxy;
    }

    public final void a(BreadcrumbHandler breadcrumbHandler) {
        this.f23487a.h(breadcrumbHandler);
    }
}
