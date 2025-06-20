package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zad implements Parcelable.Creator<StringToIntConverter> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        ArrayList<zac> arrayList = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                arrayList = SafeParcelReader.L(parcel, X, zac.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new StringToIntConverter(i2, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new StringToIntConverter[i2];
    }
}
