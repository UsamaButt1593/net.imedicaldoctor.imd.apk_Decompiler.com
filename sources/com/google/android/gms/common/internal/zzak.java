package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ValidateAccountRequestCreator")
@Deprecated
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zzak(@SafeParcelable.Param(id = 1) int i2) {
        this.s = i2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = this.s;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, i3);
        SafeParcelWriter.b(parcel, a2);
    }
}
