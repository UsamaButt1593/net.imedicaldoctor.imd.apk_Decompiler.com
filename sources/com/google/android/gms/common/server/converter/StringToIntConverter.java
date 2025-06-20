package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    private final HashMap<String, Integer> X;
    private final SparseArray<String> Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @KeepForSdk
    public StringToIntConverter() {
        this.s = 1;
        this.X = new HashMap<>();
        this.Y = new SparseArray<>();
    }

    @NonNull
    @KeepForSdk
    public StringToIntConverter C(@NonNull String str, int i2) {
        this.X.put(str, Integer.valueOf(i2));
        this.Y.put(i2, str);
        return this;
    }

    public final int b() {
        return 7;
    }

    public final int c() {
        return 0;
    }

    @NonNull
    public final /* bridge */ /* synthetic */ Object k(@NonNull Object obj) {
        String str = this.Y.get(((Integer) obj).intValue());
        return (str != null || !this.X.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object p(@NonNull Object obj) {
        Integer num = this.X.get((String) obj);
        return num == null ? this.X.get("gms_unknown") : num;
    }

    public final void writeToParcel(@NonNull Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        ArrayList arrayList = new ArrayList();
        for (String next : this.X.keySet()) {
            arrayList.add(new zac(next, this.X.get(next).intValue()));
        }
        SafeParcelWriter.d0(parcel, 2, arrayList, false);
        SafeParcelWriter.b(parcel, a2);
    }

    @SafeParcelable.Constructor
    StringToIntConverter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zac> arrayList) {
        this.s = i2;
        this.X = new HashMap<>();
        this.Y = new SparseArray<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zac zac = arrayList.get(i3);
            C(zac.X, zac.Y);
        }
    }
}
