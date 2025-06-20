package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzc implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        long j2 = -1;
        int i2 = 0;
        String str = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 2) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                j2 = SafeParcelReader.c0(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new Feature(str, i2, j2);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new Feature[i2];
    }
}
