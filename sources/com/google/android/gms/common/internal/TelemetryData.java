package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

@KeepForSdk
@SafeParcelable.Class(creator = "TelemetryDataCreator")
public class TelemetryData extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();
    @SafeParcelable.Field(getter = "getMethodInvocations", id = 2)
    @Nullable
    private List<MethodInvocation> X;
    @SafeParcelable.Field(getter = "getTelemetryConfigVersion", id = 1)
    private final int s;

    @SafeParcelable.Constructor
    public TelemetryData(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @Nullable List<MethodInvocation> list) {
        this.s = i2;
        this.X = list;
    }

    @androidx.annotation.Nullable
    public final List<MethodInvocation> C() {
        return this.X;
    }

    public final void H(@NonNull MethodInvocation methodInvocation) {
        if (this.X == null) {
            this.X = new ArrayList();
        }
        this.X.add(methodInvocation);
    }

    public final int b() {
        return this.s;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.d0(parcel, 2, this.X, false);
        SafeParcelWriter.b(parcel, a2);
    }
}
