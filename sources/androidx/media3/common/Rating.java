package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

public abstract class Rating implements Bundleable {
    static final int X = -1;
    static final int X2 = 2;
    static final int Y = 0;
    static final int Y2 = 3;
    static final int Z = 1;
    static final String Z2 = Util.d1(0);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<Rating> a3 = new N();
    static final float s = -1.0f;

    Rating() {
    }

    @UnstableApi
    public static Rating b(Bundle bundle) {
        int i2 = bundle.getInt(Z2, -1);
        if (i2 == 0) {
            return HeartRating.d(bundle);
        }
        if (i2 == 1) {
            return PercentageRating.d(bundle);
        }
        if (i2 == 2) {
            return StarRating.d(bundle);
        }
        if (i2 == 3) {
            return ThumbRating.d(bundle);
        }
        throw new IllegalArgumentException("Unknown RatingType: " + i2);
    }

    public abstract boolean c();
}
