package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;

public interface IGmsCallbacks extends IInterface {
    void X0(int i2, IBinder iBinder, zzk zzk) throws RemoteException;

    void g0(int i2, @NonNull Bundle bundle) throws RemoteException;

    void w0(int i2, @NonNull IBinder iBinder, @NonNull Bundle bundle) throws RemoteException;
}
