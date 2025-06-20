package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;

public final class ThumbRating extends Rating {
    private static final int d3 = 3;
    private static final String e3 = Util.d1(1);
    private static final String f3 = Util.d1(2);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<ThumbRating> g3 = new g1();
    private final boolean b3;
    private final boolean c3;

    public ThumbRating() {
        this.b3 = false;
        this.c3 = false;
    }

    @UnstableApi
    public static ThumbRating d(Bundle bundle) {
        Assertions.a(bundle.getInt(Rating.Z2, -1) == 3);
        return bundle.getBoolean(e3, false) ? new ThumbRating(bundle.getBoolean(f3, false)) : new ThumbRating();
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.Z2, 3);
        bundle.putBoolean(e3, this.b3);
        bundle.putBoolean(f3, this.c3);
        return bundle;
    }

    public boolean c() {
        return this.b3;
    }

    public boolean e() {
        return this.c3;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.c3 == thumbRating.c3 && this.b3 == thumbRating.b3;
    }

    public int hashCode() {
        return Objects.b(Boolean.valueOf(this.b3), Boolean.valueOf(this.c3));
    }

    public ThumbRating(boolean z) {
        this.b3 = true;
        this.c3 = z;
    }
}
