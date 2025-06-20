package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    @SafeParcelable.Field(getter = "getConnectionResultCode", id = 2)
    private int X;
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", id = 3)
    @Nullable
    private Intent Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    public zaa() {
        this(2, 0, (Intent) null);
    }

    public final Status d() {
        return this.X == 0 ? Status.Y2 : Status.c3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.F(parcel, 2, this.X);
        SafeParcelWriter.S(parcel, 3, this.Y, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) @Nullable Intent intent) {
        this.s = i2;
        this.X = i3;
        this.Y = intent;
    }
}
