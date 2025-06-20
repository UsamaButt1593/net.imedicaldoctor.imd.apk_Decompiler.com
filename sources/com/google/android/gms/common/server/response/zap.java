package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zap implements Parcelable.Creator<zal> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        String str = null;
        ArrayList<zam> arrayList = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                arrayList = SafeParcelReader.L(parcel, X, zam.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zal(i2, str, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zal[i2];
    }
}
