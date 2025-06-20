package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23524a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f23525b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f23526c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ StaticSessionData f23527d;

    public /* synthetic */ b(String str, String str2, long j2, StaticSessionData staticSessionData) {
        this.f23524a = str;
        this.f23525b = str2;
        this.f23526c = j2;
        this.f23527d = staticSessionData;
    }

    public final void a(Provider provider) {
        ((CrashlyticsNativeComponent) provider.get()).c(this.f23524a, this.f23525b, this.f23526c, this.f23527d);
    }
}
