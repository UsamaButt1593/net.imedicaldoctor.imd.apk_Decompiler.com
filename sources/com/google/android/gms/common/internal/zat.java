package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountRequestCreator")
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();
    @SafeParcelable.Field(getter = "getAccount", id = 2)
    private final Account X;
    @SafeParcelable.Field(getter = "getSessionId", id = 3)
    private final int Y;
    @SafeParcelable.Field(getter = "getSignInAccountHint", id = 4)
    @Nullable
    private final GoogleSignInAccount Z;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zat(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) Account account, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) @Nullable GoogleSignInAccount googleSignInAccount) {
        this.s = i2;
        this.X = account;
        this.Y = i3;
        this.Z = googleSignInAccount;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, this.X, i2, false);
        SafeParcelWriter.F(parcel, 3, this.Y);
        SafeParcelWriter.S(parcel, 4, this.Z, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    public zat(Account account, int i2, @Nullable GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
