package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Objects;

final class zzq {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f19827a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final zzd f19828b;

    zzq(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if (Objects.equals(interfaceDescriptor, "android.os.IMessenger")) {
            this.f19827a = new Messenger(iBinder);
            this.f19828b = null;
        } else if (Objects.equals(interfaceDescriptor, IMessengerCompat.f19806h)) {
            this.f19828b = new zzd(iBinder);
            this.f19827a = null;
        } else {
            Log.w("MessengerIpcClient", "Invalid interface descriptor: ".concat(String.valueOf(interfaceDescriptor)));
            throw new RemoteException();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f19827a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzd zzd = this.f19828b;
        if (zzd != null) {
            zzd.b(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
