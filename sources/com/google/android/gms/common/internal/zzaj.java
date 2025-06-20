package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaj implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                z = SafeParcelReader.P(parcel, X);
            } else if (O == 3) {
                z2 = SafeParcelReader.P(parcel, X);
            } else if (O == 4) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O != 5) {
                SafeParcelReader.h0(parcel, X);
            } else {
                i4 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new RootTelemetryConfiguration(i2, z, z2, i3, i4);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new RootTelemetryConfiguration[i2];
    }
}
