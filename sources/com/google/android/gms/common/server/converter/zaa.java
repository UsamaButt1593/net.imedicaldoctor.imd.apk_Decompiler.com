package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@SafeParcelable.Class(creator = "ConverterWrapperCreator")
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    @SafeParcelable.Field(getter = "getStringToIntConverter", id = 2)
    private final StringToIntConverter X;
    @SafeParcelable.VersionField(id = 1)
    final int s;

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) StringToIntConverter stringToIntConverter) {
        this.s = i2;
        this.X = stringToIntConverter;
    }

    public static zaa C(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zaa((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final FastJsonResponse.FieldConverter<?, ?> H() {
        StringToIntConverter stringToIntConverter = this.X;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = SafeParcelWriter.a(parcel);
        SafeParcelWriter.F(parcel, 1, this.s);
        SafeParcelWriter.S(parcel, 2, this.X, i2, false);
        SafeParcelWriter.b(parcel, a2);
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.s = 1;
        this.X = stringToIntConverter;
    }
}
