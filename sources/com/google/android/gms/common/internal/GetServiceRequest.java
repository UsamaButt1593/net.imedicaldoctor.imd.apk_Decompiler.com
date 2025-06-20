package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzn();
    static final Scope[] h3 = new Scope[0];
    static final Feature[] i3 = new Feature[0];
    @SafeParcelable.Field(id = 2)
    final int X;
    @SafeParcelable.Field(id = 5)
    @Nullable
    IBinder X2;
    @SafeParcelable.Field(id = 3)
    final int Y;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_SCOPES", id = 6)
    Scope[] Y2;
    @SafeParcelable.Field(id = 4)
    String Z;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.Bundle()", id = 7)
    Bundle Z2;
    @SafeParcelable.Field(id = 8)
    @Nullable
    Account a3;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 10)
    Feature[] b3;
    @SafeParcelable.Field(defaultValueUnchecked = "GetServiceRequest.EMPTY_FEATURES", id = 11)
    Feature[] c3;
    @SafeParcelable.Field(id = 12)
    final boolean d3;
    @SafeParcelable.Field(defaultValue = "0", id = 13)
    final int e3;
    @SafeParcelable.Field(getter = "isRequestingTelemetryConfiguration", id = 14)
    boolean f3;
    @SafeParcelable.Field(getter = "getAttributionTag", id = 15)
    @Nullable
    private final String g3;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 6) Scope[] scopeArr, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) @Nullable Account account, @SafeParcelable.Param(id = 10) Feature[] featureArr, @SafeParcelable.Param(id = 11) Feature[] featureArr2, @SafeParcelable.Param(id = 12) boolean z, @SafeParcelable.Param(id = 13) int i6, @SafeParcelable.Param(id = 14) boolean z2, @SafeParcelable.Param(id = 15) @Nullable String str2) {
        scopeArr = scopeArr == null ? h3 : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        featureArr = featureArr == null ? i3 : featureArr;
        featureArr2 = featureArr2 == null ? i3 : featureArr2;
        this.s = i2;
        this.X = i4;
        this.Y = i5;
        if ("com.google.android.gms".equals(str)) {
            this.Z = "com.google.android.gms";
        } else {
            this.Z = str;
        }
        if (i2 < 2) {
            this.a3 = iBinder != null ? AccountAccessor.f(IAccountAccessor.Stub.e(iBinder)) : null;
        } else {
            this.X2 = iBinder;
            this.a3 = account;
        }
        this.Y2 = scopeArr;
        this.Z2 = bundle;
        this.b3 = featureArr;
        this.c3 = featureArr2;
        this.d3 = z;
        this.e3 = i6;
        this.f3 = z2;
        this.g3 = str2;
    }

    @NonNull
    @KeepForSdk
    public Bundle C() {
        return this.Z2;
    }

    @Nullable
    public final String H() {
        return this.g3;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        zzn.a(this, parcel, i2);
    }
}
