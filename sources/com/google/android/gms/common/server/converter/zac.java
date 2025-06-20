package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();
    @SafeParcelable.Field(id = 2)
    final String X;
    @SafeParcelable.Field(id = 3)
    final int Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zac(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
        this.s = i2;
        this.X = str;
        this.Y = i3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.Y(parcel, 2, this.X, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.b(parcel, a2);
    }

    zac(String str, int i2) {
        this.s = 1;
        this.X = str;
        this.Y = i2;
    }
}
