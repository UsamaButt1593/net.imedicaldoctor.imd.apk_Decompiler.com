package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;

final class zacy implements Runnable {
    final /* synthetic */ zada X;
    final /* synthetic */ Result s;

    zacy(zada zada, Result result) {
        this.X = zada;
        this.s = result;
    }

    @WorkerThread
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            ThreadLocal<Boolean> threadLocal = BasePendingResult.p;
            threadLocal.set(Boolean.TRUE);
            PendingResult c2 = ((ResultTransform) Preconditions.r(this.X.f20146a)).c(this.s);
            zada zada = this.X;
            zada.f20153h.sendMessage(zada.f20153h.obtainMessage(0, c2));
            threadLocal.set(Boolean.FALSE);
            zada.q(this.s);
            googleApiClient = (GoogleApiClient) this.X.f20152g.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (RuntimeException e2) {
            zada zada2 = this.X;
            zada2.f20153h.sendMessage(zada2.f20153h.obtainMessage(1, e2));
            BasePendingResult.p.set(Boolean.FALSE);
            zada.q(this.s);
            googleApiClient = (GoogleApiClient) this.X.f20152g.get();
            if (googleApiClient == null) {
                return;
            }
        } catch (Throwable th) {
            BasePendingResult.p.set(Boolean.FALSE);
            zada.q(this.s);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.X.f20152g.get();
            if (googleApiClient2 != null) {
                googleApiClient2.I(this.X);
            }
            throw th;
        }
        googleApiClient.I(this.X);
    }
}
