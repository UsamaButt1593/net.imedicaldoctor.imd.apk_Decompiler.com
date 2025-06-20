package com.google.android.gms.common.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.zzq;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzag extends IInterface {
    zzq B0(zzo zzo) throws RemoteException;

    boolean F(zzs zzs, IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean a() throws RemoteException;

    boolean c() throws RemoteException;

    zzq t0(zzo zzo) throws RemoteException;
}
