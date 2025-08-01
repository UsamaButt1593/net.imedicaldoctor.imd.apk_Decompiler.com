package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
public final class BinderWrapper implements Parcelable {
    @NonNull
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzh();
    private final IBinder s;

    @KeepForSdk
    public BinderWrapper(@NonNull IBinder iBinder) {
        this.s = iBinder;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.s);
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzi zzi) {
        this.s = parcel.readStrongBinder();
    }
}
