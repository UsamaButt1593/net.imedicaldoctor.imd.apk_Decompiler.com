package com.google.android.gms.common.images;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

final class zad {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f20210a;

    public zad(Uri uri) {
        this.f20210a = uri;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zad)) {
            return false;
        }
        return Objects.b(((zad) obj).f20210a, this.f20210a);
    }

    public final int hashCode() {
        return Objects.c(this.f20210a);
    }
}
