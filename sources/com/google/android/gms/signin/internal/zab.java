package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zab implements Parcelable.Creator<zaa> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        Intent intent = null;
        int i3 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                intent = (Intent) SafeParcelReader.C(parcel, X, Intent.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zaa(i2, i3, intent);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zaa[i2];
    }
}
