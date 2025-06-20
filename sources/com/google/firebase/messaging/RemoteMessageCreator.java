package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public class RemoteMessageCreator implements Parcelable.Creator<RemoteMessage> {

    /* renamed from: a  reason: collision with root package name */
    public static final int f24837a = 0;

    static void c(RemoteMessage remoteMessage, Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.k(parcel, 2, remoteMessage.s, false);
        SafeParcelWriter.b(parcel, a2);
    }

    @Nullable
    /* renamed from: a */
    public RemoteMessage createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            if (SafeParcelReader.O(X) != 2) {
                SafeParcelReader.h0(parcel, X);
            } else {
                bundle = SafeParcelReader.g(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new RemoteMessage(bundle);
    }

    @Nullable
    /* renamed from: b */
    public RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
