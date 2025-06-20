package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzl implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int i2 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                bundle = SafeParcelReader.g(parcel, X);
            } else if (O == 2) {
                featureArr = (Feature[]) SafeParcelReader.K(parcel, X, Feature.CREATOR);
            } else if (O == 3) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.h0(parcel, X);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.C(parcel, X, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zzk(bundle, featureArr, i2, connectionTelemetryConfiguration);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzk[i2];
    }
}
