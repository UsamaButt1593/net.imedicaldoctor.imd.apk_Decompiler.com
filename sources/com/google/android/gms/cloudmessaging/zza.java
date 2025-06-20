package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        Intent intent = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            if (SafeParcelReader.O(X) != 1) {
                SafeParcelReader.h0(parcel, X);
            } else {
                intent = (Intent) SafeParcelReader.C(parcel, X, Intent.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new CloudMessage(intent);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new CloudMessage[i2];
    }
}
