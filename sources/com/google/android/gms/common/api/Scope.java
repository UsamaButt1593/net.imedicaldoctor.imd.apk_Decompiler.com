package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getScopeUri", id = 2)
    private final String X;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    Scope(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str) {
        Preconditions.m(str, "scopeUri must not be null or empty");
        this.s = i2;
        this.X = str;
    }

    @NonNull
    @KeepForSdk
    public String C() {
        return this.X;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.X.equals(((Scope) obj).X);
    }

    public int hashCode() {
        return this.X.hashCode();
    }

    @NonNull
    public String toString() {
        return this.X;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int i3 = this.s;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, i3);
        SafeParcelWriter.Y(parcel, 2, C(), false);
        SafeParcelWriter.b(parcel, a2);
    }

    public Scope(@NonNull String str) {
        this(1, str);
    }
}
