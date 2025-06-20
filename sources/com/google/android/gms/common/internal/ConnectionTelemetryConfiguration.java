package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "ConnectionTelemetryConfigurationCreator")
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getMethodInvocationTelemetryEnabled", id = 2)
    private final boolean X;
    @SafeParcelable.Field(getter = "getMaxMethodInvocationsLogged", id = 5)
    private final int X2;
    @SafeParcelable.Field(getter = "getMethodTimingTelemetryEnabled", id = 3)
    private final boolean Y;
    @SafeParcelable.Field(getter = "getMethodInvocationMethodKeyDisallowlist", id = 6)
    @Nullable
    private final int[] Y2;
    @SafeParcelable.Field(getter = "getMethodInvocationMethodKeyAllowlist", id = 4)
    @Nullable
    private final int[] Z;
    @SafeParcelable.Field(getter = "getRootTelemetryConfiguration", id = 1)
    private final RootTelemetryConfiguration s;

    @SafeParcelable.Constructor
    public ConnectionTelemetryConfiguration(@SafeParcelable.Param(id = 1) @NonNull RootTelemetryConfiguration rootTelemetryConfiguration, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) @Nullable int[] iArr, @SafeParcelable.Param(id = 5) int i2, @SafeParcelable.Param(id = 6) @Nullable int[] iArr2) {
        this.s = rootTelemetryConfiguration;
        this.X = z;
        this.Y = z2;
        this.Z = iArr;
        this.X2 = i2;
        this.Y2 = iArr2;
    }

    @KeepForSdk
    public int C() {
        return this.X2;
    }

    @KeepForSdk
    @Nullable
    public int[] H() {
        return this.Z;
    }

    @KeepForSdk
    @Nullable
    public int[] I() {
        return this.Y2;
    }

    @KeepForSdk
    public boolean N() {
        return this.X;
    }

    @KeepForSdk
    public boolean O() {
        return this.Y;
    }

    @NonNull
    public final RootTelemetryConfiguration P() {
        return this.s;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.S(parcel, 1, this.s, i2, false);
        SafeParcelWriter.g(parcel, 2, N());
        SafeParcelWriter.g(parcel, 3, O());
        SafeParcelWriter.G(parcel, 4, H(), false);
        SafeParcelWriter.F(parcel, 5, C());
        SafeParcelWriter.G(parcel, 6, I(), false);
        SafeParcelWriter.b(parcel, a2);
    }
}
