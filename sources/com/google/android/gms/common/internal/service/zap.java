package com.google.android.gms.common.internal.service;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.TelemetryLoggingOptions;
import com.google.android.gms.internal.base.zad;
import com.itextpdf.text.pdf.codec.TIFFConstants;

public final class zap extends GmsClient<zai> {
    private final TelemetryLoggingOptions H3;

    public zap(Context context, Looper looper, ClientSettings clientSettings, TelemetryLoggingOptions telemetryLoggingOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, (int) TIFFConstants.e0, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.H3 = telemetryLoggingOptions;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final /* synthetic */ IInterface A(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof zai ? (zai) queryLocalInterface : new zai(iBinder);
    }

    public final Feature[] D() {
        return zad.zab;
    }

    /* access modifiers changed from: protected */
    public final Bundle I() {
        return this.H3.b();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String N() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public final String O() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    /* access modifiers changed from: protected */
    public final boolean R() {
        return true;
    }

    public final int r() {
        return 203400000;
    }
}
