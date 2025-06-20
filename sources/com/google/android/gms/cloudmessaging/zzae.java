package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.internal.cloudmessaging.zzf;

final class zzae extends zzf {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Rpc f19825a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(Rpc rpc, Looper looper) {
        super(looper);
        this.f19825a = rpc;
    }

    public final void handleMessage(Message message) {
        Rpc.g(this.f19825a, message);
    }
}
