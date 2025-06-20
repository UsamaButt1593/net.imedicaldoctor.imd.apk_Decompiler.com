package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zza implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int i0 = SafeParcelReader.i0(parcel);
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < i0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 2:
                    j2 = SafeParcelReader.c0(parcel2, X);
                    break;
                case 4:
                    str = SafeParcelReader.G(parcel2, X);
                    break;
                case 5:
                    i4 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 6:
                    arrayList = SafeParcelReader.I(parcel2, X);
                    break;
                case 8:
                    j3 = SafeParcelReader.c0(parcel2, X);
                    break;
                case 10:
                    str3 = SafeParcelReader.G(parcel2, X);
                    break;
                case 11:
                    i3 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 12:
                    str2 = SafeParcelReader.G(parcel2, X);
                    break;
                case 13:
                    str4 = SafeParcelReader.G(parcel2, X);
                    break;
                case 14:
                    i5 = SafeParcelReader.Z(parcel2, X);
                    break;
                case 15:
                    f2 = SafeParcelReader.V(parcel2, X);
                    break;
                case 16:
                    j4 = SafeParcelReader.c0(parcel2, X);
                    break;
                case 17:
                    str5 = SafeParcelReader.G(parcel2, X);
                    break;
                case 18:
                    z = SafeParcelReader.P(parcel2, X);
                    break;
                default:
                    SafeParcelReader.h0(parcel2, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel2, i0);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z);
    }

    public final /* synthetic */ Object[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
