package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zaa implements Parcelable.Creator<BitmapTeleporter> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i0 = SafeParcelReader.i0(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.C(parcel, X, ParcelFileDescriptor.CREATOR);
            } else if (O != 3) {
                SafeParcelReader.h0(parcel, X);
            } else {
                i3 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, i0);
        return new BitmapTeleporter(i2, parcelFileDescriptor, i3);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new BitmapTeleporter[i2];
    }
}
