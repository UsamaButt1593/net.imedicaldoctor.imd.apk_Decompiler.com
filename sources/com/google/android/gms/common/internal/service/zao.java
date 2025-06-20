package com.google.android.gms.common.internal.service;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.common.internal.TelemetryLoggingClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zad;
import com.google.android.gms.tasks.Task;

public final class zao extends GoogleApi<TelemetryLoggingOptions> implements TelemetryLoggingClient {

    /* renamed from: k  reason: collision with root package name */
    private static final Api.ClientKey<zap> f20278k;

    /* renamed from: l  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zap, TelemetryLoggingOptions> f20279l;

    /* renamed from: m  reason: collision with root package name */
    private static final Api<TelemetryLoggingOptions> f20280m;

    /* renamed from: n  reason: collision with root package name */
    public static final /* synthetic */ int f20281n = 0;

    static {
        Api.ClientKey<zap> clientKey = new Api.ClientKey<>();
        f20278k = clientKey;
        zan zan = new zan();
        f20279l = zan;
        f20280m = new Api<>("ClientTelemetry.API", zan, clientKey);
    }

    public zao(Context context, TelemetryLoggingOptions telemetryLoggingOptions) {
        super(context, f20280m, telemetryLoggingOptions, GoogleApi.Settings.f19953c);
    }

    public final Task<Void> a(TelemetryData telemetryData) {
        TaskApiCall.Builder a2 = TaskApiCall.a();
        a2.e(zad.zaa);
        a2.d(false);
        a2.c(new zam(telemetryData));
        return g(a2.a());
    }
}
