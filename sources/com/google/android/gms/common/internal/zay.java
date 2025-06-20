package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zay implements Parcelable.Creator<zax> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 3) {
                i4 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.h0(parcel, X);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.K(parcel, X, Scope.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zax(i2, i3, i4, scopeArr);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zax[i2];
    }
}
