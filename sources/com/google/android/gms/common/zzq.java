package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupResponseCreator")
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getErrorMessage", id = 2)
    @Nullable
    private final String X;
    @SafeParcelable.Field(getter = "getStatusValue", id = 3)
    private final int Y;
    @SafeParcelable.Field(getter = "getFirstPartyStatusValue", id = 4)
    private final int Z;
    @SafeParcelable.Field(getter = "getResult", id = 1)
    private final boolean s;

    @SafeParcelable.Constructor
    zzq(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2, @SafeParcelable.Param(id = 4) int i3) {
        this.s = z;
        this.X = str;
        this.Y = zzy.a(i2) - 1;
        this.Z = zzd.a(i3) - 1;
    }

    @Nullable
    public final String C() {
        return this.X;
    }

    public final boolean H() {
        return this.s;
    }

    public final int I() {
        return zzd.a(this.Z);
    }

    public final int N() {
        return zzy.a(this.Y);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.g(parcel, 1, this.s);
        SafeParcelWriter.Y(parcel, 2, this.X, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.F(parcel, 4, this.Z);
        SafeParcelWriter.b(parcel, a2);
    }
}
