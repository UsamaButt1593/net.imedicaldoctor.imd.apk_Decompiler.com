package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "GoogleCertificatesLookupQueryCreator")
public final class zzo extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 2)
    private final boolean X;
    @SafeParcelable.Field(getter = "getIsChimeraPackage", id = 5)
    private final boolean X2;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 3)
    private final boolean Y;
    @SafeParcelable.Field(getter = "getIncludeHashesInErrorMessage", id = 6)
    private final boolean Y2;
    @SafeParcelable.Field(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")
    private final Context Z;
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String s;

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) IBinder iBinder, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) boolean z4) {
        this.s = str;
        this.X = z;
        this.Y = z2;
        this.Z = (Context) ObjectWrapper.f(IObjectWrapper.Stub.e(iBinder));
        this.X2 = z3;
        this.Y2 = z4;
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.dynamic.IObjectWrapper, android.os.IBinder] */
    public final void writeToParcel(Parcel parcel, int i2) {
        String str = this.s;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.Y(parcel, 1, str, false);
        SafeParcelWriter.g(parcel, 2, this.X);
        SafeParcelWriter.g(parcel, 3, this.Y);
        SafeParcelWriter.B(parcel, 4, ObjectWrapper.z(this.Z), false);
        SafeParcelWriter.g(parcel, 5, this.X2);
        SafeParcelWriter.g(parcel, 6, this.Y2);
        SafeParcelWriter.b(parcel, a2);
    }
}
