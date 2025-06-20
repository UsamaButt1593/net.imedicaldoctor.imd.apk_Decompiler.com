package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;

final class zabt implements Runnable {
    final /* synthetic */ zabu X;
    final /* synthetic */ ConnectionResult s;

    zabt(zabu zabu, ConnectionResult connectionResult) {
        this.X = zabu;
        this.s = connectionResult;
    }

    public final void run() {
        zabu zabu = this.X;
        zabq zabq = (zabq) zabu.f20116f.e3.get(zabu.f20112b);
        if (zabq != null) {
            if (this.s.O()) {
                this.X.f20115e = true;
                if (this.X.f20111a.w()) {
                    this.X.h();
                    return;
                }
                try {
                    zabu zabu2 = this.X;
                    zabu2.f20111a.f((IAccountAccessor) null, zabu2.f20111a.e());
                } catch (SecurityException e2) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
                    this.X.f20111a.g("Failed to get service from broker.");
                    zabq.H(new ConnectionResult(10), (Exception) null);
                }
            } else {
                zabq.H(this.s, (Exception) null);
            }
        }
    }
}
