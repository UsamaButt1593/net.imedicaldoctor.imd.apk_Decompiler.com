package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaw implements Parcelable.Creator<zav> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                iBinder = SafeParcelReader.Y(parcel, X);
            } else if (O == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, X, ConnectionResult.CREATOR);
            } else if (O == 4) {
                z = SafeParcelReader.P(parcel, X);
            } else if (O != 5) {
                SafeParcelReader.h0(parcel, X);
            } else {
                z2 = SafeParcelReader.P(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zav(i2, iBinder, connectionResult, z, z2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zav[i2];
    }
}
