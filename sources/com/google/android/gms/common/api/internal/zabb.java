package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

final class zabb implements ResultCallback<Status> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ StatusPendingResult f20082a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f20083b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ GoogleApiClient f20084c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ zabe f20085d;

    zabb(zabe zabe, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.f20085d = zabe;
        this.f20082a = statusPendingResult;
        this.f20083b = z;
        this.f20084c = googleApiClient;
    }

    public final /* bridge */ /* synthetic */ void a(@NonNull Result result) {
        Status status = (Status) result;
        Storage.b(this.f20085d.f20092i).i();
        if (status.R() && this.f20085d.u()) {
            zabe zabe = this.f20085d;
            zabe.i();
            zabe.g();
        }
        this.f20082a.o(status);
        if (this.f20083b) {
            this.f20084c.i();
        }
    }
}
