package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new zzb();
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status X2 = new Status(-1);
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status Y2 = new Status(0);
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status Z2 = new Status(14);
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status a3 = new Status(8);
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status b3 = new Status(15);
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final Status c3 = new Status(16);
    @NonNull
    @KeepForSdk
    public static final Status d3 = new Status(18);
    @ShowFirstParty
    @NonNull
    public static final Status e3 = new Status(17);
    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)
    @Nullable
    private final String X;
    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)
    @Nullable
    private final PendingIntent Y;
    @SafeParcelable.Field(getter = "getConnectionResult", id = 4)
    @Nullable
    private final ConnectionResult Z;
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)
    private final int s;

    public Status(int i2) {
        this(i2, (String) null);
    }

    @Nullable
    public ConnectionResult C() {
        return this.Z;
    }

    @Nullable
    public PendingIntent H() {
        return this.Y;
    }

    @ResultIgnorabilityUnspecified
    public int I() {
        return this.s;
    }

    @Nullable
    public String N() {
        return this.X;
    }

    public boolean O() {
        return this.Y != null;
    }

    public boolean P() {
        return this.s == 16;
    }

    public boolean Q() {
        return this.s == 14;
    }

    @CheckReturnValue
    public boolean R() {
        return this.s <= 0;
    }

    public void S(@NonNull Activity activity, int i2) throws IntentSender.SendIntentException {
        if (O()) {
            PendingIntent pendingIntent = this.Y;
            Preconditions.r(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, (Intent) null, 0, 0, 0);
        }
    }

    public void T(@NonNull ActivityResultLauncher<IntentSenderRequest> activityResultLauncher) {
        if (O()) {
            PendingIntent pendingIntent = this.Y;
            Preconditions.r(pendingIntent);
            activityResultLauncher.b(new IntentSenderRequest.Builder(pendingIntent.getIntentSender()).a());
        }
    }

    @NonNull
    public final String W() {
        String str = this.X;
        return str != null ? str : CommonStatusCodes.a(this.s);
    }

    @NonNull
    @CanIgnoreReturnValue
    public Status d() {
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.s == status.s && Objects.b(this.X, status.X) && Objects.b(this.Y, status.Y) && Objects.b(this.Z, status.Z);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.s), this.X, this.Y, this.Z);
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper d2 = Objects.d(this);
        d2.a("statusCode", W());
        d2.a("resolution", this.Y);
        return d2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, I());
        SafeParcelWriter.Y(parcel, 2, N(), false);
        SafeParcelWriter.S(parcel, 3, this.Y, i2, false);
        SafeParcelWriter.S(parcel, 4, C(), i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    public Status(int i2, @Nullable String str) {
        this(i2, str, (PendingIntent) null);
    }

    public Status(int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(i2, str, pendingIntent, (ConnectionResult) null);
    }

    @SafeParcelable.Constructor
    Status(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) @Nullable String str, @SafeParcelable.Param(id = 3) @Nullable PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) @Nullable ConnectionResult connectionResult) {
        this.s = i2;
        this.X = str;
        this.Y = pendingIntent;
        this.Z = connectionResult;
    }

    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str) {
        this(connectionResult, str, 17);
    }

    @KeepForSdk
    @Deprecated
    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str, int i2) {
        this(i2, str, connectionResult.I(), connectionResult);
    }
}
