package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;

public final class VideoSize implements Bundleable {
    private static final int X2 = 0;
    private static final int Y2 = 0;
    private static final int Z2 = 0;
    private static final float a3 = 1.0f;
    public static final VideoSize b3 = new VideoSize(0, 0);
    private static final String c3 = Util.d1(0);
    private static final String d3 = Util.d1(1);
    private static final String e3 = Util.d1(2);
    private static final String f3 = Util.d1(3);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<VideoSize> g3 = new w1();
    @IntRange(from = 0)
    public final int X;
    @IntRange(from = 0, to = 359)
    public final int Y;
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float Z;
    @IntRange(from = 0)
    public final int s;

    @UnstableApi
    public VideoSize(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3) {
        this(i2, i3, 0, 1.0f);
    }

    @UnstableApi
    public static VideoSize b(Bundle bundle) {
        return new VideoSize(bundle.getInt(c3, 0), bundle.getInt(d3, 0), bundle.getInt(e3, 0), bundle.getFloat(f3, 1.0f));
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(c3, this.s);
        bundle.putInt(d3, this.X);
        bundle.putInt(e3, this.Y);
        bundle.putFloat(f3, this.Z);
        return bundle;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.s == videoSize.s && this.X == videoSize.X && this.Y == videoSize.Y && this.Z == videoSize.Z;
    }

    public int hashCode() {
        return ((((((217 + this.s) * 31) + this.X) * 31) + this.Y) * 31) + Float.floatToRawIntBits(this.Z);
    }

    @UnstableApi
    public VideoSize(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0, to = 359) int i4, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this.s = i2;
        this.X = i3;
        this.Y = i4;
        this.Z = f2;
    }
}
