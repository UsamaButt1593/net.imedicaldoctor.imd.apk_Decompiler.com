package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzb implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.C(parcel, X, PendingIntent.CREATOR);
            } else if (O != 4) {
                SafeParcelReader.h0(parcel, X);
            } else {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, X, ConnectionResult.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new Status(i2, str, pendingIntent, connectionResult);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Status[i2];
    }
}
