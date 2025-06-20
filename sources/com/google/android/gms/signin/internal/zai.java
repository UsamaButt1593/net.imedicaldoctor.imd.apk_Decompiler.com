package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zat;

@SafeParcelable.Class(creator = "SignInRequestCreator")
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new zaj();
    @SafeParcelable.Field(getter = "getResolveAccountRequest", id = 2)
    final zat X;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zai(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) zat zat) {
        this.s = i2;
        this.X = zat;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, this.X, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
