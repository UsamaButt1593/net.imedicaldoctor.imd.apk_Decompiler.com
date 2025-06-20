package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> X;
    @SafeParcelable.Field(getter = "getRootClassName", id = 3)
    private final String Y;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zan(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(id = 3) String str) {
        this.s = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zal = arrayList.get(i3);
            String str2 = zal.X;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) Preconditions.r(zal.Y)).size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zam = zal.Y.get(i4);
                hashMap2.put(zam.X, zam.Y);
            }
            hashMap.put(str2, hashMap2);
        }
        this.X = hashMap;
        this.Y = (String) Preconditions.r(str);
        N();
    }

    public final String C() {
        return this.Y;
    }

    @Nullable
    public final Map<String, FastJsonResponse.Field<?, ?>> H(String str) {
        return this.X.get(str);
    }

    public final void I() {
        for (String next : this.X.keySet()) {
            Map map = this.X.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).d0());
            }
            this.X.put(next, hashMap);
        }
    }

    public final void N() {
        for (String str : this.X.keySet()) {
            Map map = this.X.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).m0(this);
            }
        }
    }

    public final void O(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.X.put((String) Preconditions.r(cls.getCanonicalName()), map);
    }

    public final boolean P(Class<? extends FastJsonResponse> cls) {
        return this.X.containsKey(Preconditions.r(cls.getCanonicalName()));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.X.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.X.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        ArrayList arrayList = new ArrayList();
        for (String next : this.X.keySet()) {
            arrayList.add(new zal(next, this.X.get(next)));
        }
        SafeParcelWriter.d0(parcel, 2, arrayList, false);
        SafeParcelWriter.Y(parcel, 3, this.Y, false);
        SafeParcelWriter.b(parcel, a2);
    }

    public zan(Class<? extends FastJsonResponse> cls) {
        this.s = 1;
        this.X = new HashMap<>();
        this.Y = (String) Preconditions.r(cls.getCanonicalName());
    }
}
