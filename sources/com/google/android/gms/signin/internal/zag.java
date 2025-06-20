package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "RecordConsentByConsentResultResponseCreator")
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();
    @SafeParcelable.Field(getter = "getToken", id = 2)
    @Nullable
    private final String X;
    @SafeParcelable.Field(getter = "getGrantedScopes", id = 1)
    private final List<String> s;

    @SafeParcelable.Constructor
    public zag(@SafeParcelable.Param(id = 1) List<String> list, @SafeParcelable.Param(id = 2) @Nullable String str) {
        this.s = list;
        this.X = str;
    }

    public final Status d() {
        return this.X != null ? Status.Y2 : Status.c3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.a0(parcel, 1, this.s, false);
        SafeParcelWriter.Y(parcel, 2, this.X, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
