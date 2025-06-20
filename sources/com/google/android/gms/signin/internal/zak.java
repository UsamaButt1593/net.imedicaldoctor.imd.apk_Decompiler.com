package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zav;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();
    @SafeParcelable.Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult X;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", id = 3)
    @Nullable
    private final zav Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(id = 3) @Nullable zav zav) {
        this.s = i2;
        this.X = connectionResult;
        this.Y = zav;
    }

    public final ConnectionResult C() {
        return this.X;
    }

    @Nullable
    public final zav H() {
        return this.Y;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, this.X, i2, false);
        SafeParcelWriter.S(parcel, 3, this.Y, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
