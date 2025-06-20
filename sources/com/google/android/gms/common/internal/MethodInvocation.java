package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "MethodInvocationCreator")
public class MethodInvocation extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getResultStatusCode", id = 2)
    private final int X;
    @SafeParcelable.Field(getter = "getEndTimeMillis", id = 5)
    private final long X2;
    @SafeParcelable.Field(getter = "getConnectionResultStatusCode", id = 3)
    private final int Y;
    @SafeParcelable.Field(getter = "getCallingModuleId", id = 6)
    @Nullable
    private final String Y2;
    @SafeParcelable.Field(getter = "getStartTimeMillis", id = 4)
    private final long Z;
    @SafeParcelable.Field(getter = "getCallingEntryPoint", id = 7)
    @Nullable
    private final String Z2;
    @SafeParcelable.Field(defaultValue = "0", getter = "getServiceId", id = 8)
    private final int a3;
    @SafeParcelable.Field(defaultValue = "-1", getter = "getLatencyMillis", id = 9)
    private final int b3;
    @SafeParcelable.Field(getter = "getMethodKey", id = 1)
    private final int s;

    @KeepForSdk
    @Deprecated
    public MethodInvocation(int i2, int i3, int i4, long j2, long j3, @Nullable String str, @Nullable String str2, int i5) {
        this(i2, i3, i4, j2, j3, str, str2, i5, -1);
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.F(parcel, 2, this.X);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.K(parcel, 4, this.Z);
        SafeParcelWriter.K(parcel, 5, this.X2);
        SafeParcelWriter.Y(parcel, 6, this.Y2, false);
        SafeParcelWriter.Y(parcel, 7, this.Z2, false);
        SafeParcelWriter.F(parcel, 8, this.a3);
        SafeParcelWriter.F(parcel, 9, this.b3);
        SafeParcelWriter.b(parcel, a2);
    }

    @SafeParcelable.Constructor
    public MethodInvocation(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i3, @SafeParcelable.Param(id = 3) int i4, @SafeParcelable.Param(id = 4) long j2, @SafeParcelable.Param(id = 5) long j3, @SafeParcelable.Param(id = 6) @Nullable String str, @SafeParcelable.Param(id = 7) @Nullable String str2, @SafeParcelable.Param(id = 8) int i5, @SafeParcelable.Param(id = 9) int i6) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = j2;
        this.X2 = j3;
        this.Y2 = str;
        this.Z2 = str2;
        this.a3 = i5;
        this.b3 = i6;
    }
}
