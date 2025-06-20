package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    @SafeParcelable.Field(id = 2)
    Feature[] X;
    @SafeParcelable.Field(defaultValue = "0", id = 3)
    int Y;
    @SafeParcelable.Field(id = 4)
    @Nullable
    ConnectionTelemetryConfiguration Z;
    @SafeParcelable.Field(id = 1)
    Bundle s;

    public zzk() {
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.k(parcel, 1, this.s, false);
        SafeParcelWriter.c0(parcel, 2, this.X, i2, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.S(parcel, 4, this.Z, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    @SafeParcelable.Constructor
    zzk(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) @Nullable ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.s = bundle;
        this.X = featureArr;
        this.Y = i2;
        this.Z = connectionTelemetryConfiguration;
    }
}
