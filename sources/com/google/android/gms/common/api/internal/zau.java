package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public interface zau extends GoogleApiClient.ConnectionCallbacks {
    void u0(ConnectionResult connectionResult, Api<?> api, boolean z);
}
