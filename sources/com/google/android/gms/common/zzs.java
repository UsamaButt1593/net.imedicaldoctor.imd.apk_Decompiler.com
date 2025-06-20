package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzj X;
    @SafeParcelable.Field(getter = "getAllowTestKeys", id = 3)
    private final boolean Y;
    @SafeParcelable.Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean Z;
    @SafeParcelable.Field(getter = "getCallingPackage", id = 1)
    private final String s;

    @SafeParcelable.Constructor
    zzs(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.s = str;
        zzk zzk = null;
        if (iBinder != null) {
            try {
                IObjectWrapper d2 = zzz.e(iBinder).d();
                byte[] bArr = d2 == null ? null : (byte[]) ObjectWrapper.f(d2);
                if (bArr != null) {
                    zzk = new zzk(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e2) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            }
        }
        this.X = zzk;
        this.Y = z;
        this.Z = z2;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        String str = this.s;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.Y(parcel, 1, str, false);
        zzj zzj = this.X;
        if (zzj == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzj = null;
        }
        SafeParcelWriter.B(parcel, 2, zzj, false);
        SafeParcelWriter.g(parcel, 3, this.Y);
        SafeParcelWriter.g(parcel, 4, this.Z);
        SafeParcelWriter.b(parcel, a2);
    }

    zzs(String str, @Nullable zzj zzj, boolean z, boolean z2) {
        this.s = str;
        this.X = zzj;
        this.Y = z;
        this.Z = z2;
    }
}
