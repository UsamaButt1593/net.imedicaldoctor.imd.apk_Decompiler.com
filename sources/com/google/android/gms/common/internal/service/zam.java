package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.TelemetryData;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zam implements RemoteCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TelemetryData f20277a;

    public /* synthetic */ zam(TelemetryData telemetryData) {
        this.f20277a = telemetryData;
    }

    public final void accept(Object obj, Object obj2) {
        TelemetryData telemetryData = this.f20277a;
        int i2 = zao.f20281n;
        ((zai) ((zap) obj).M()).e(telemetryData);
        ((TaskCompletionSource) obj2).c(null);
    }
}
