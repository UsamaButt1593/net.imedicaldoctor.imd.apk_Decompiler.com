package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zaq;

final class zacz extends zaq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zada f20144a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zacz(zada zada, Looper looper) {
        super(looper);
        this.f20144a = zada;
    }

    public final void handleMessage(Message message) {
        Status k2;
        int i2 = message.what;
        if (i2 == 0) {
            PendingResult pendingResult = (PendingResult) message.obj;
            synchronized (this.f20144a.f20150e) {
                try {
                    zada zada = (zada) Preconditions.r(this.f20144a.f20147b);
                    if (pendingResult == null) {
                        k2 = new Status(13, "Transform returned null");
                    } else if (pendingResult instanceof zacp) {
                        k2 = ((zacp) pendingResult).k();
                    } else {
                        zada.l(pendingResult);
                    }
                    zada.m(k2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 != 1) {
            StringBuilder sb = new StringBuilder(70);
            sb.append("TransformationResultHandler received unknown message type: ");
            sb.append(i2);
            Log.e("TransformedResultImpl", sb.toString());
        } else {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
    }
}
