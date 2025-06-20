package com.google.android.gms.common.internal.service;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;

public final class Common {
    @NonNull
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public static final Api.ClientKey<zah> f20272a;
    @NonNull
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    public static final Api<Api.ApiOptions.NoOptions> f20273b;

    /* renamed from: c  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zah, Api.ApiOptions.NoOptions> f20274c;

    /* renamed from: d  reason: collision with root package name */
    public static final zae f20275d = new zae();

    static {
        Api.ClientKey<zah> clientKey = new Api.ClientKey<>();
        f20272a = clientKey;
        zab zab = new zab();
        f20274c = zab;
        f20273b = new Api<>("Common.API", zab, clientKey);
    }
}
