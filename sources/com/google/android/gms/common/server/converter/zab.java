package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zab implements Parcelable.Creator<zaa> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.C(parcel, X, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zaa(i2, stringToIntConverter);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zaa[i2];
    }
}
