package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int X;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long Y;
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String s;

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) long j2) {
        this.s = str;
        this.X = i2;
        this.Y = j2;
    }

    @NonNull
    @KeepForSdk
    public String C() {
        return this.s;
    }

    @KeepForSdk
    public long H() {
        long j2 = this.Y;
        return j2 == -1 ? (long) this.X : j2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            return ((C() != null && C().equals(feature.C())) || (C() == null && feature.C() == null)) && H() == feature.H();
        }
    }

    public final int hashCode() {
        return Objects.c(C(), Long.valueOf(H()));
    }

    @NonNull
    public final String toString() {
        Objects.ToStringHelper d2 = Objects.d(this);
        d2.a("name", C());
        d2.a("version", Long.valueOf(H()));
        return d2.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.Y(parcel, 1, C(), false);
        SafeParcelWriter.F(parcel, 2, this.X);
        SafeParcelWriter.K(parcel, 3, H());
        SafeParcelWriter.b(parcel, a2);
    }

    @KeepForSdk
    public Feature(@NonNull String str, long j2) {
        this.s = str;
        this.Y = j2;
        this.X = -1;
    }
}
