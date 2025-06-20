package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import androidx.annotation.VisibleForTesting;

@VisibleForTesting
public final class zze implements ServiceConnection {
    final /* synthetic */ BaseGmsClient X;
    private final int s;

    public zze(BaseGmsClient baseGmsClient, int i2) {
        this.X = baseGmsClient;
        this.s = i2;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        BaseGmsClient baseGmsClient = this.X;
        if (iBinder == null) {
            BaseGmsClient.l0(baseGmsClient, 16);
            return;
        }
        synchronized (baseGmsClient.g3) {
            try {
                BaseGmsClient baseGmsClient2 = this.X;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                baseGmsClient2.h3 = (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) ? new zzad(iBinder) : (IGmsServiceBroker) queryLocalInterface;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.X.m0(0, (Bundle) null, this.s);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.X.g3) {
            this.X.h3 = null;
        }
        BaseGmsClient baseGmsClient = this.X;
        int i2 = this.s;
        Handler handler = baseGmsClient.e3;
        handler.sendMessage(handler.obtainMessage(6, i2, 1));
    }
}
