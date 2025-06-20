package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaf implements Parcelable.Creator<DataHolder> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                strArr = SafeParcelReader.H(parcel, X);
            } else if (O == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.K(parcel, X, CursorWindow.CREATOR);
            } else if (O == 3) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 4) {
                bundle = SafeParcelReader.g(parcel, X);
            } else if (O != 1000) {
                SafeParcelReader.h0(parcel, X);
            } else {
                i2 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.d0();
        return dataHolder;
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new DataHolder[i2];
    }
}
