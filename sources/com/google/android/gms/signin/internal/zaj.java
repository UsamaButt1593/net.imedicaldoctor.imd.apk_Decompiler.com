package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zat;

public final class zaj implements Parcelable.Creator<zai> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        zat zat = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                zat = (zat) SafeParcelReader.C(parcel, X, zat.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zai(i2, zat);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zai[i2];
    }
}
