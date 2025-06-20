package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzt implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 2) {
                iBinder = SafeParcelReader.Y(parcel, X);
            } else if (O == 3) {
                z = SafeParcelReader.P(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.h0(parcel, X);
            } else {
                z2 = SafeParcelReader.P(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zzs(str, iBinder, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzs[i2];
    }
}
