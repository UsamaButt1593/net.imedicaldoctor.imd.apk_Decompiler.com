package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInButtonConfigCreator")
public final class zax extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();
    @SafeParcelable.Field(getter = "getButtonSize", id = 2)
    private final int X;
    @SafeParcelable.Field(getter = "getColorScheme", id = 3)
    private final int Y;
    @SafeParcelable.Field(getter = "getScopes", id = 4)
    @Deprecated
    @Nullable
    private final Scope[] Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zax(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) @Nullable Scope[] scopeArr) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = scopeArr;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.F(parcel, 2, this.X);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.c0(parcel, 4, this.Z, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
