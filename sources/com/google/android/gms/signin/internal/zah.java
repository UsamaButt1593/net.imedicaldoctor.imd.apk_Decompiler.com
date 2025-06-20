package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zah implements Parcelable.Creator<zag> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        ArrayList<String> arrayList = null;
        String str = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                arrayList = SafeParcelReader.I(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                str = SafeParcelReader.G(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zag(arrayList, str);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zag[i2];
    }
}
