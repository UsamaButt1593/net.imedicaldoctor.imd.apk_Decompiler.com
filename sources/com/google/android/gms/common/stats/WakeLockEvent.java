package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@SafeParcelable.Class(creator = "WakeLockEventCreator")
@Deprecated
public final class WakeLockEvent extends StatsEvent {
    @NonNull
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zza();
    @SafeParcelable.Field(getter = "getTimeMillis", id = 2)
    private final long X;
    @SafeParcelable.Field(getter = "getSecondaryWakeLockName", id = 10)
    private final String X2;
    @SafeParcelable.Field(getter = "getEventType", id = 11)
    private final int Y;
    @SafeParcelable.Field(getter = "getCodePackage", id = 17)
    private final String Y2;
    @SafeParcelable.Field(getter = "getWakeLockName", id = 4)
    private final String Z;
    @SafeParcelable.Field(getter = "getWakeLockType", id = 5)
    private final int Z2;
    @SafeParcelable.Field(getter = "getCallingPackages", id = 6)
    @Nullable
    private final List a3;
    @SafeParcelable.Field(getter = "getEventKey", id = 12)
    private final String b3;
    @SafeParcelable.Field(getter = "getElapsedRealtime", id = 8)
    private final long c3;
    @SafeParcelable.Field(getter = "getDeviceState", id = 14)
    private final int d3;
    @SafeParcelable.Field(getter = "getHostPackage", id = 13)
    private final String e3;
    @SafeParcelable.Field(getter = "getBeginPowerPercentage", id = 15)
    private final float f3;
    @SafeParcelable.Field(getter = "getTimeout", id = 16)
    private final long g3;
    @SafeParcelable.Field(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean h3;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    WakeLockEvent(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) long j2, @SafeParcelable.Param(id = 11) int i3, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) int i4, @SafeParcelable.Param(id = 6) @Nullable List list, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 8) long j3, @SafeParcelable.Param(id = 14) int i5, @SafeParcelable.Param(id = 10) String str3, @SafeParcelable.Param(id = 13) String str4, @SafeParcelable.Param(id = 15) float f2, @SafeParcelable.Param(id = 16) long j4, @SafeParcelable.Param(id = 17) String str5, @SafeParcelable.Param(id = 18) boolean z) {
        this.s = i2;
        this.X = j2;
        this.Y = i3;
        this.Z = str;
        this.X2 = str3;
        this.Y2 = str5;
        this.Z2 = i4;
        this.a3 = list;
        this.b3 = str2;
        this.c3 = j3;
        this.d3 = i5;
        this.e3 = str4;
        this.f3 = f2;
        this.g3 = j4;
        this.h3 = z;
    }

    public final int C() {
        return this.Y;
    }

    public final long H() {
        return this.X;
    }

    @NonNull
    public final String I() {
        List list = this.a3;
        String str = "";
        String join = list == null ? str : TextUtils.join(",", list);
        int i2 = this.d3;
        String str2 = this.X2;
        String str3 = this.e3;
        float f2 = this.f3;
        String str4 = this.Y2;
        int i3 = this.Z2;
        String str5 = this.Z;
        boolean z = this.h3;
        StringBuilder sb = new StringBuilder();
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        if (str2 == null) {
            str2 = str;
        }
        sb.append(str2);
        sb.append("\t");
        if (str3 == null) {
            str3 = str;
        }
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        if (str4 != null) {
            str = str4;
        }
        sb.append(str);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.K(parcel, 2, this.X);
        SafeParcelWriter.Y(parcel, 4, this.Z, false);
        SafeParcelWriter.F(parcel, 5, this.Z2);
        SafeParcelWriter.a0(parcel, 6, this.a3, false);
        SafeParcelWriter.K(parcel, 8, this.c3);
        SafeParcelWriter.Y(parcel, 10, this.X2, false);
        SafeParcelWriter.F(parcel, 11, this.Y);
        SafeParcelWriter.Y(parcel, 12, this.b3, false);
        SafeParcelWriter.Y(parcel, 13, this.e3, false);
        SafeParcelWriter.F(parcel, 14, this.d3);
        SafeParcelWriter.w(parcel, 15, this.f3);
        SafeParcelWriter.K(parcel, 16, this.g3);
        SafeParcelWriter.Y(parcel, 17, this.Y2, false);
        SafeParcelWriter.g(parcel, 18, this.h3);
        SafeParcelWriter.b(parcel, a2);
    }
}
