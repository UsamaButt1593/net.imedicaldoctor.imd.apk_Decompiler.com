package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import javax.annotation.concurrent.GuardedBy;

final class zaan extends zabg {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f20057b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaan(zaao zaao, zabf zabf, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabf);
        this.f20057b = connectionProgressReportCallbacks;
    }

    @GuardedBy("mLock")
    public final void a() {
        this.f20057b.a(new ConnectionResult(16, (PendingIntent) null));
    }
}
