package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.RemoteException;

public final /* synthetic */ class zzi implements Runnable {
    public final /* synthetic */ IBinder X;
    public final /* synthetic */ zzp s;

    public /* synthetic */ zzi(zzp zzp, IBinder iBinder) {
        this.s = zzp;
        this.X = iBinder;
    }

    public final void run() {
        zzp zzp = this.s;
        IBinder iBinder = this.X;
        synchronized (zzp) {
            if (iBinder == null) {
                zzp.a(0, "Null service connection");
                return;
            }
            try {
                zzp.Y = new zzq(iBinder);
                zzp.s = 2;
                zzp.c();
            } catch (RemoteException e2) {
                zzp.a(0, e2.getMessage());
            }
        }
    }
}
