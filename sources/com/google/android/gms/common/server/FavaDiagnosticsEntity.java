package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "FavaDiagnosticsEntityCreator")
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    @KeepForSdk
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();
    @SafeParcelable.Field(id = 2)
    @NonNull
    public final String X;
    @SafeParcelable.Field(id = 3)
    public final int Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    public FavaDiagnosticsEntity(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @NonNull String str, @SafeParcelable.Param(id = 3) int i3) {
        this.s = i2;
        this.X = str;
        this.Y = i3;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.Y(parcel, 2, this.X, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.b(parcel, a2);
    }

    @KeepForSdk
    public FavaDiagnosticsEntity(@NonNull String str, int i2) {
        this.s = 1;
        this.X = str;
        this.Y = i2;
    }
}
