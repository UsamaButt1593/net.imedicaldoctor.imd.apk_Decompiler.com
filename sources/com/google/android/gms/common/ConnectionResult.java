package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionResultCreator")
public final class ConnectionResult extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();
    @KeepForSdk
    public static final int X2 = -1;
    public static final int Y2 = 0;
    public static final int Z2 = 1;
    public static final int a3 = 2;
    public static final int b3 = 3;
    public static final int c3 = 4;
    public static final int d3 = 5;
    public static final int e3 = 6;
    public static final int f3 = 7;
    public static final int g3 = 8;
    public static final int h3 = 9;
    public static final int i3 = 10;
    public static final int j3 = 11;
    public static final int k3 = 13;
    public static final int l3 = 14;
    public static final int m3 = 15;
    public static final int n3 = 16;
    public static final int o3 = 17;
    public static final int p3 = 18;
    public static final int q3 = 19;
    public static final int r3 = 20;
    public static final int s3 = 22;
    public static final int t3 = 23;
    public static final int u3 = 24;
    @Deprecated
    public static final int v3 = 1500;
    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static final ConnectionResult w3 = new ConnectionResult(0);
    @SafeParcelable.Field(getter = "getErrorCode", id = 2)
    private final int X;
    @SafeParcelable.Field(getter = "getResolution", id = 3)
    @Nullable
    private final PendingIntent Y;
    @SafeParcelable.Field(getter = "getErrorMessage", id = 4)
    @Nullable
    private final String Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    public ConnectionResult(int i2) {
        this(i2, (PendingIntent) null, (String) null);
    }

    @NonNull
    static String Q(int i2) {
        if (i2 == 99) {
            return "UNFINISHED";
        }
        if (i2 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i2) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i2) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i2 + ")";
                }
        }
    }

    public int C() {
        return this.X;
    }

    @Nullable
    public String H() {
        return this.Z;
    }

    @Nullable
    public PendingIntent I() {
        return this.Y;
    }

    public boolean N() {
        return (this.X == 0 || this.Y == null) ? false : true;
    }

    public boolean O() {
        return this.X == 0;
    }

    public void P(@NonNull Activity activity, int i2) throws IntentSender.SendIntentException {
        if (N()) {
            PendingIntent pendingIntent = this.Y;
            Preconditions.r(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i2, (Intent) null, 0, 0, 0);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.X == connectionResult.X && Objects.b(this.Y, connectionResult.Y) && Objects.b(this.Z, connectionResult.Z);
    }

    public int hashCode() {
        return Objects.c(Integer.valueOf(this.X), this.Y, this.Z);
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper d2 = Objects.d(this);
        d2.a("statusCode", Q(this.X));
        d2.a("resolution", this.Y);
        d2.a("message", this.Z);
        return d2.toString();
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int i4 = this.s;
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, i4);
        SafeParcelWriter.F(parcel, 2, C());
        SafeParcelWriter.S(parcel, 3, I(), i2, false);
        SafeParcelWriter.Y(parcel, 4, H(), false);
        SafeParcelWriter.b(parcel, a2);
    }

    @SafeParcelable.Constructor
    ConnectionResult(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) @Nullable PendingIntent pendingIntent, @SafeParcelable.Param(id = 4) @Nullable String str) {
        this.s = i2;
        this.X = i4;
        this.Y = pendingIntent;
        this.Z = str;
    }

    public ConnectionResult(int i2, @Nullable PendingIntent pendingIntent) {
        this(i2, pendingIntent, (String) null);
    }

    public ConnectionResult(int i2, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        this(1, i2, pendingIntent, str);
    }
}
