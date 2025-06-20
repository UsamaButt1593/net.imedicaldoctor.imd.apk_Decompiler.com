package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] Y = {"data"};
    private final Parcelable.Creator<T> X;

    @KeepForSdk
    public DataBufferSafeParcelable(@NonNull DataHolder dataHolder, @NonNull Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.X = creator;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void b(@NonNull DataHolder.Builder builder, @NonNull T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        builder.c(contentValues);
        obtain.recycle();
    }

    @NonNull
    @KeepForSdk
    public static DataHolder.Builder c() {
        return DataHolder.C(Y);
    }

    @NonNull
    @KeepForSdk
    /* renamed from: d */
    public T get(int i2) {
        DataHolder dataHolder = (DataHolder) Preconditions.r(this.s);
        byte[] N = dataHolder.N("data", i2, dataHolder.S(i2));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(N, 0, N.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.X.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
