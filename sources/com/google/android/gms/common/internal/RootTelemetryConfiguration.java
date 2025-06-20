package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "RootTelemetryConfigurationCreator")
public class RootTelemetryConfiguration extends AbstractSafeParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<RootTelemetryConfiguration> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean X;
    @SafeParcelable.Field(getter = "getMaxMethodInvocationsInBatch", id = 5)
    private final int X2;
    @SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean Y;
    @SafeParcelable.Field(getter = "getBatchPeriodMillis", id = 4)
    private final int Z;
    @SafeParcelable.Field(getter = "getVersion", id = 1)
    private final int s;

    @SafeParcelable.Constructor
    public RootTelemetryConfiguration(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) int i3, @SafeParcelable.Param(id = 5) int i4) {
        this.s = i2;
        this.X = z;
        this.Y = z2;
        this.Z = i3;
        this.X2 = i4;
    }

    @KeepForSdk
    public int C() {
        return this.Z;
    }

    @KeepForSdk
    public int H() {
        return this.X2;
    }

    @KeepForSdk
    public boolean I() {
        return this.X;
    }

    @KeepForSdk
    public boolean N() {
        return this.Y;
    }

    @KeepForSdk
    public int getVersion() {
        return this.s;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, getVersion());
        SafeParcelWriter.g(parcel, 2, I());
        SafeParcelWriter.g(parcel, 3, N());
        SafeParcelWriter.F(parcel, 4, C());
        SafeParcelWriter.F(parcel, 5, H());
        SafeParcelWriter.b(parcel, a2);
    }
}
