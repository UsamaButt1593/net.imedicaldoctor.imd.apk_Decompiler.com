package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.internal.SignInClientImpl;

final class zaa extends Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> {
    zaa() {
    }

    public final /* bridge */ /* synthetic */ Api.Client c(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        SignInOptions signInOptions = (SignInOptions) obj;
        return new SignInClientImpl(context, looper, true, clientSettings, SignInClientImpl.u0(clientSettings), connectionCallbacks, onConnectionFailedListener);
    }
}
