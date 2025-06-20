package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.internal.base.zaq;

final class zabh extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zabi f20099a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabh(zabi zabi, Looper looper) {
        super(looper);
        this.f20099a = zabi;
    }

    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((zabg) message.obj).b(this.f20099a);
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GACStateManager", sb.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
