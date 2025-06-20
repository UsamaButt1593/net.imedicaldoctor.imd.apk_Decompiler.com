package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zan implements Parcelable.Creator<MethodInvocation> {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int i0 = SafeParcelReader.i0(parcel);
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 2:
                    i3 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 3:
                    i4 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 4:
                    j2 = SafeParcelReader.c0(parcel2, X);
                    break;
                case 5:
                    j3 = SafeParcelReader.c0(parcel2, X);
                    break;
                case 6:
                    str = SafeParcelReader.G(parcel2, X);
                    break;
                case 7:
                    str2 = SafeParcelReader.G(parcel2, X);
                    break;
                case 8:
                    i5 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 9:
                    i6 = SafeParcelReader.Z(parcel2, X);
                    break;
                default:
                    SafeParcelReader.h0(parcel2, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel2, i0);
        return new MethodInvocation(i2, i3, i4, j2, j3, str, str2, i5, i6);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new MethodInvocation[i2];
    }
}
