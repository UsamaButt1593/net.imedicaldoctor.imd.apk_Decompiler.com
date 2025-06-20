package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;

public final class StarRating extends Rating {
    private static final int d3 = 2;
    private static final int e3 = 5;
    private static final String f3 = Util.d1(1);
    private static final String g3 = Util.d1(2);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<StarRating> h3 = new f1();
    @IntRange(from = 1)
    private final int b3;
    private final float c3;

    public StarRating(@IntRange(from = 1) int i2) {
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        this.b3 = i2;
        this.c3 = -1.0f;
    }

    @UnstableApi
    public static StarRating d(Bundle bundle) {
        Assertions.a(bundle.getInt(Rating.Z2, -1) == 2);
        int i2 = bundle.getInt(f3, 5);
        float f2 = bundle.getFloat(g3, -1.0f);
        return f2 == -1.0f ? new StarRating(i2) : new StarRating(i2, f2);
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.Z2, 2);
        bundle.putInt(f3, this.b3);
        bundle.putFloat(g3, this.c3);
        return bundle;
    }

    public boolean c() {
        return this.c3 != -1.0f;
    }

    @IntRange(from = 1)
    public int e() {
        return this.b3;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.b3 == starRating.b3 && this.c3 == starRating.c3;
    }

    public float f() {
        return this.c3;
    }

    public int hashCode() {
        return Objects.b(Integer.valueOf(this.b3), Float.valueOf(this.c3));
    }

    public StarRating(@IntRange(from = 1) int i2, @FloatRange(from = 0.0d) float f2) {
        boolean z = false;
        Assertions.b(i2 > 0, "maxStars must be a positive integer");
        if (f2 >= 0.0f && f2 <= ((float) i2)) {
            z = true;
        }
        Assertions.b(z, "starRating is out of range [0, maxStars]");
        this.b3 = i2;
        this.c3 = f2;
    }
}
