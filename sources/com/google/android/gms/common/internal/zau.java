package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zau implements Parcelable.Creator<zat> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i3 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                account = (Account) SafeParcelReader.C(parcel, X, Account.CREATOR);
            } else if (O == 3) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.h0(parcel, X);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.C(parcel, X, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new zat(i2, account, i3, googleSignInAccount);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new zat[i2];
    }
}
