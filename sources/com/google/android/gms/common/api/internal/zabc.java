package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class zabc extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabe f20086a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabc(zabe zabe, Looper looper) {
        super(looper);
        this.f20086a = zabe;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            zabe.Q(this.f20086a);
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        } else {
            zabe.P(this.f20086a);
        }
    }
}
