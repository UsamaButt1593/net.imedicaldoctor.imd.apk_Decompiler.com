package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() {
        @NonNull
        /* renamed from: a */
        public ParcelableSparseIntArray createFromParcel(@NonNull Parcel parcel) {
            int readInt = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i2 = 0; i2 < readInt; i2++) {
                parcelableSparseIntArray.put(iArr[i2], iArr2[i2]);
            }
            return parcelableSparseIntArray;
        }

        @NonNull
        /* renamed from: b */
        public ParcelableSparseIntArray[] newArray(int i2) {
            return new ParcelableSparseIntArray[i2];
        }
    };

    public ParcelableSparseIntArray() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i3 = 0; i3 < size(); i3++) {
            iArr[i3] = keyAt(i3);
            iArr2[i3] = valueAt(i3);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }

    public ParcelableSparseIntArray(int i2) {
        super(i2);
    }

    public ParcelableSparseIntArray(@NonNull SparseIntArray sparseIntArray) {
        for (int i2 = 0; i2 < sparseIntArray.size(); i2++) {
            put(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
        }
    }
}
