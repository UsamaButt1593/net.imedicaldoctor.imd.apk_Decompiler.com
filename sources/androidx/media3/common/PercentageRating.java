package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;

public final class PercentageRating extends Rating {
    private static final int c3 = 1;
    private static final String d3 = Util.d1(1);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<PercentageRating> e3 = new H();
    private final float b3;

    public PercentageRating() {
        this.b3 = -1.0f;
    }

    @UnstableApi
    public static PercentageRating d(Bundle bundle) {
        boolean z = true;
        if (bundle.getInt(Rating.Z2, -1) != 1) {
            z = false;
        }
        Assertions.a(z);
        float f2 = bundle.getFloat(d3, -1.0f);
        return f2 == -1.0f ? new PercentageRating() : new PercentageRating(f2);
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(Rating.Z2, 1);
        bundle.putFloat(d3, this.b3);
        return bundle;
    }

    public boolean c() {
        return this.b3 != -1.0f;
    }

    public float e() {
        return this.b3;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof PercentageRating) && this.b3 == ((PercentageRating) obj).b3;
    }

    public int hashCode() {
        return Objects.b(Float.valueOf(this.b3));
    }

    public PercentageRating(@FloatRange(from = 0.0d, to = 100.0d) float f2) {
        Assertions.b(f2 >= 0.0f && f2 <= 100.0f, "percent must be in the range of [0, 100]");
        this.b3 = f2;
    }
}
