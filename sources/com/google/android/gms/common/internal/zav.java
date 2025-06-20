package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
public final class zav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();
    @SafeParcelable.Field(id = 2)
    @Nullable
    final IBinder X;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", id = 5)
    private final boolean X2;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 3)
    private final ConnectionResult Y;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", id = 4)
    private final boolean Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zav(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) boolean z2) {
        this.s = i2;
        this.X = iBinder;
        this.Y = connectionResult;
        this.Z = z;
        this.X2 = z2;
    }

    public final ConnectionResult C() {
        return this.Y;
    }

    @Nullable
    public final IAccountAccessor H() {
        IBinder iBinder = this.X;
        if (iBinder == null) {
            return null;
        }
        return IAccountAccessor.Stub.e(iBinder);
    }

    public final boolean I() {
        return this.Z;
    }

    public final boolean N() {
        return this.X2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zav)) {
            return false;
        }
        zav zav = (zav) obj;
        return this.Y.equals(zav.Y) && Objects.b(H(), zav.H());
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.B(parcel, 2, this.X, false);
        SafeParcelWriter.S(parcel, 3, this.Y, i2, false);
        SafeParcelWriter.g(parcel, 4, this.Z);
        SafeParcelWriter.g(parcel, 5, this.X2);
        SafeParcelWriter.b(parcel, a2);
    }
}
