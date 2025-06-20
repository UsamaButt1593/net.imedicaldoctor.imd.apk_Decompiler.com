package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zaab implements Parcelable.Creator<TelemetryData> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        ArrayList<MethodInvocation> arrayList = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                arrayList = SafeParcelReader.L(parcel, X, MethodInvocation.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new TelemetryData(i2, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new TelemetryData[i2];
    }
}
