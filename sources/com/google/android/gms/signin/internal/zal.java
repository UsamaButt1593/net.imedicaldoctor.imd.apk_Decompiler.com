package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zav;

public final class zal implements Parcelable.Creator<zak> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        ConnectionResult connectionResult = null;
        zav zav = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, X, ConnectionResult.CREATOR);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                zav = (zav) SafeParcelReader.C(parcel, X, zav.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zak(i2, connectionResult, zav);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zak[i2];
    }
}
