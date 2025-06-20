package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

final class zaao extends zaav {
    private final Map<Api.Client, zaal> X;
    final /* synthetic */ zaaw Y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaaw, Map<Api.Client, zaal> map) {
        super(zaaw, (zaau) null);
        this.Y = zaaw;
        this.X = map;
    }

    @GuardedBy("mLock")
    @WorkerThread
    public final void a() {
        zal zal = new zal(this.Y.f20065d);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.X.keySet()) {
            if (!next.p() || this.X.get(next).f20054c) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i2 = -1;
        int i3 = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i3 < size) {
                i2 = zal.b(this.Y.f20064c, (Api.Client) arrayList.get(i3));
                i3++;
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i3 < size2) {
                i2 = zal.b(this.Y.f20064c, (Api.Client) arrayList2.get(i3));
                i3++;
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i2, (PendingIntent) null);
            zaaw zaaw = this.Y;
            zaaw.f20062a.t(new zaam(this, zaaw, connectionResult));
            return;
        }
        zaaw zaaw2 = this.Y;
        if (zaaw2.f20074m && zaaw2.f20072k != null) {
            zaaw2.f20072k.c();
        }
        for (Api.Client next2 : this.X.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.X.get(next2);
            if (!next2.p() || zal.b(this.Y.f20064c, next2) == 0) {
                next2.k(connectionProgressReportCallbacks);
            } else {
                zaaw zaaw3 = this.Y;
                zaaw3.f20062a.t(new zaan(this, zaaw3, connectionProgressReportCallbacks));
            }
        }
    }
}
