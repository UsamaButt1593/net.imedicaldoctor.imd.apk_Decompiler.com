package com.google.android.gms.common.internal.service;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zac extends zaf {
    zac(zae zae, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ void w(Api.AnyClient anyClient) throws RemoteException {
        ((zal) ((zah) anyClient).M()).e(new zad(this));
    }
}
