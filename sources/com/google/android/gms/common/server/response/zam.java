package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();
    @SafeParcelable.Field(id = 2)
    final String X;
    @SafeParcelable.Field(id = 3)
    final FastJsonResponse.Field<?, ?> Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zam(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.s = i2;
        this.X = str;
        this.Y = field;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.Y(parcel, 2, this.X, false);
        SafeParcelWriter.S(parcel, 3, this.Y, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.s = 1;
        this.X = str;
        this.Y = field;
    }
}
