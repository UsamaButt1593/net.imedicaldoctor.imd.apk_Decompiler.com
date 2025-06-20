package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.common.zzag;
import java.util.ArrayList;

@KeepForSdk
public final class SafeParcelableSerializer {
    private SafeParcelableSerializer() {
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T a(@NonNull byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        Preconditions.r(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> T b(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return a(byteArrayExtra, creator);
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> T c(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return a(Base64Utils.b(str), creator);
    }

    @Deprecated
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> d(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(a((byte[]) arrayList.get(i2), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> e(@NonNull Bundle bundle, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return f(bundle.getByteArray(str), creator);
    }

    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> f(@Nullable byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        try {
            ArrayList<T> arrayList = new ArrayList<>();
            obtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            obtain.recycle();
        }
    }

    @Nullable
    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> ArrayList<T> g(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList<T> arrayList2 = new ArrayList<>(arrayList.size());
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(a((byte[]) arrayList.get(i2), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    @Nullable
    public static <T extends SafeParcelable> ArrayList<T> h(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return f(intent.getByteArrayExtra(str), creator);
    }

    @Deprecated
    public static <T extends SafeParcelable> void i(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T m2 : iterable) {
            arrayList.add(m(m2));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static <T extends SafeParcelable> void j(@NonNull Iterable<T> iterable, @NonNull Bundle bundle, @NonNull String str) {
        bundle.putByteArray(str, p(iterable));
    }

    @KeepForSdk
    @Deprecated
    public static <T extends SafeParcelable> void k(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        for (T m2 : iterable) {
            arrayList.add(m(m2));
        }
        intent.putExtra(str, arrayList);
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void l(@NonNull Iterable<T> iterable, @NonNull Intent intent, @NonNull String str) {
        intent.putExtra(str, p(iterable));
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> byte[] m(@NonNull T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    @KeepForSdk
    public static <T extends SafeParcelable> void n(@NonNull T t, @NonNull Intent intent, @NonNull String str) {
        intent.putExtra(str, m(t));
    }

    @NonNull
    @KeepForSdk
    public static <T extends SafeParcelable> String o(@NonNull T t) {
        return Base64Utils.e(m(t));
    }

    private static byte[] p(Iterable iterable) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeTypedList(zzag.zzj(iterable));
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }
}
