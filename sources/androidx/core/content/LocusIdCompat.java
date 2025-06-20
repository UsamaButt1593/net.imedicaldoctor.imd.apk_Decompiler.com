package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

public final class LocusIdCompat {

    /* renamed from: a  reason: collision with root package name */
    private final String f5674a;

    /* renamed from: b  reason: collision with root package name */
    private final LocusId f5675b;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        static LocusId a(@NonNull String str) {
            return new LocusId(str);
        }

        @NonNull
        static String b(@NonNull LocusId locusId) {
            return locusId.getId();
        }
    }

    public LocusIdCompat(@NonNull String str) {
        this.f5674a = (String) Preconditions.q(str, "id cannot be empty");
        this.f5675b = Build.VERSION.SDK_INT >= 29 ? Api29Impl.a(str) : null;
    }

    @NonNull
    private String b() {
        int length = this.f5674a.length();
        return length + "_chars";
    }

    @RequiresApi(29)
    @NonNull
    public static LocusIdCompat d(@NonNull LocusId locusId) {
        Preconditions.m(locusId, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.q(Api29Impl.b(locusId), "id cannot be empty"));
    }

    @NonNull
    public String a() {
        return this.f5674a;
    }

    @RequiresApi(29)
    @NonNull
    public LocusId c() {
        return this.f5675b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || LocusIdCompat.class != obj.getClass()) {
            return false;
        }
        String str = this.f5674a;
        String str2 = ((LocusIdCompat) obj).f5674a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.f5674a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
