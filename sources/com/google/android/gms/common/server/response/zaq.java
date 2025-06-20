package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaq implements Parcelable.Creator<SafeParcelResponse> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        Parcel parcel2 = null;
        zan zan = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                parcel2 = SafeParcelReader.y(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                zan = (zan) SafeParcelReader.C(parcel, X, zan.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new SafeParcelResponse(i2, parcel2, zan);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }
}
