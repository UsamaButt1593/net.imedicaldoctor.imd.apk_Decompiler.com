package com.google.android.gms.cloudmessaging;

import android.os.Parcel;
import android.os.Parcelable;

final class zzb implements Parcelable.Creator {
    zzb() {
    }

    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new zzd(parcel.readStrongBinder());
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzd[i2];
    }
}
