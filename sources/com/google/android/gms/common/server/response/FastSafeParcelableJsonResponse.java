package com.google.android.gms.common.server.response;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.VisibleForTesting;

@ShowFirstParty
@KeepForSdk
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }

    @KeepForSdk
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field next : c().values()) {
            if (j(next)) {
                if (!fastJsonResponse.j(next) || !Objects.b(d(next), fastJsonResponse.d(next))) {
                    return false;
                }
            } else if (fastJsonResponse.j(next)) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    @VisibleForTesting
    public Object g(@NonNull String str) {
        return null;
    }

    @KeepForSdk
    public int hashCode() {
        int i2 = 0;
        for (FastJsonResponse.Field next : c().values()) {
            if (j(next)) {
                i2 = (i2 * 31) + Preconditions.r(d(next)).hashCode();
            }
        }
        return i2;
    }

    @VisibleForTesting
    public boolean k(@NonNull String str) {
        return false;
    }

    @NonNull
    @KeepForSdk
    public byte[] m0() {
        Parcel obtain = Parcel.obtain();
        writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
