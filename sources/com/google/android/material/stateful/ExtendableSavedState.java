package com.google.android.material.stateful;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import androidx.customview.view.AbsSavedState;

public class ExtendableSavedState extends AbsSavedState {
    public static final Parcelable.Creator<ExtendableSavedState> CREATOR = new Parcelable.ClassLoaderCreator<ExtendableSavedState>() {
        @Nullable
        /* renamed from: a */
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel) {
            return new ExtendableSavedState(parcel, (ClassLoader) null);
        }

        @NonNull
        /* renamed from: b */
        public ExtendableSavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
            return new ExtendableSavedState(parcel, classLoader);
        }

        @NonNull
        /* renamed from: c */
        public ExtendableSavedState[] newArray(int i2) {
            return new ExtendableSavedState[i2];
        }
    };
    @NonNull
    public final SimpleArrayMap<String, Bundle> Y;

    private ExtendableSavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        String[] strArr = new String[readInt];
        parcel.readStringArray(strArr);
        Bundle[] bundleArr = new Bundle[readInt];
        parcel.readTypedArray(bundleArr, Bundle.CREATOR);
        this.Y = new SimpleArrayMap<>(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.Y.put(strArr[i2], bundleArr[i2]);
        }
    }

    @NonNull
    public String toString() {
        return "ExtendableSavedState{" + Integer.toHexString(System.identityHashCode(this)) + " states=" + this.Y + "}";
    }

    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        super.writeToParcel(parcel, i2);
        int size = this.Y.size();
        parcel.writeInt(size);
        String[] strArr = new String[size];
        Bundle[] bundleArr = new Bundle[size];
        for (int i3 = 0; i3 < size; i3++) {
            strArr[i3] = this.Y.i(i3);
            bundleArr[i3] = this.Y.m(i3);
        }
        parcel.writeStringArray(strArr);
        parcel.writeTypedArray(bundleArr, 0);
    }

    public ExtendableSavedState(Parcelable parcelable) {
        super(parcelable);
        this.Y = new SimpleArrayMap<>();
    }
}
