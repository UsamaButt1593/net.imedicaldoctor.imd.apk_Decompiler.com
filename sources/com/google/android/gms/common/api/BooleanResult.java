package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

@KeepForSdk
public class BooleanResult implements Result {
    private final boolean X;
    private final Status s;

    @ShowFirstParty
    @KeepForSdk
    public BooleanResult(@NonNull Status status, boolean z) {
        this.s = (Status) Preconditions.s(status, "Status must not be null");
        this.X = z;
    }

    @KeepForSdk
    public boolean a() {
        return this.X;
    }

    @NonNull
    @KeepForSdk
    public Status d() {
        return this.s;
    }

    @KeepForSdk
    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.s.equals(booleanResult.s) && this.X == booleanResult.X;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.s.hashCode() + MetaDo.w) * 31) + (this.X ? 1 : 0);
    }
}
