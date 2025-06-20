package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import androidx.annotation.Nullable;

public final class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new zzb();
    IMessengerCompat X;
    Messenger s;

    public zzd(IBinder iBinder) {
        this.s = new Messenger(iBinder);
    }

    public final IBinder a() {
        Messenger messenger = this.s;
        return messenger != null ? messenger.getBinder() : this.X.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.s;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.X.T(message);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zzd) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.s;
        parcel.writeStrongBinder(messenger != null ? messenger.getBinder() : this.X.asBinder());
    }
}
