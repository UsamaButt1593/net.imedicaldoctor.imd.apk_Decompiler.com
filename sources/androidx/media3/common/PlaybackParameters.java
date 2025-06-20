package androidx.media3.common;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;

public final class PlaybackParameters implements Bundleable {
    private static final String X2 = Util.d1(0);
    private static final String Y2 = Util.d1(1);
    public static final PlaybackParameters Z = new PlaybackParameters(1.0f);
    @UnstableApi
    @Deprecated
    public static final Bundleable.Creator<PlaybackParameters> Z2 = new J();
    public final float X;
    private final int Y;
    public final float s;

    public PlaybackParameters(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        this(f2, 1.0f);
    }

    @UnstableApi
    public static PlaybackParameters b(Bundle bundle) {
        return new PlaybackParameters(bundle.getFloat(X2, 1.0f), bundle.getFloat(Y2, 1.0f));
    }

    @UnstableApi
    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putFloat(X2, this.s);
        bundle.putFloat(Y2, this.X);
        return bundle;
    }

    @UnstableApi
    public long c(long j2) {
        return j2 * ((long) this.Y);
    }

    @CheckResult
    public PlaybackParameters d(@FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        return new PlaybackParameters(f2, this.X);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        return this.s == playbackParameters.s && this.X == playbackParameters.X;
    }

    public int hashCode() {
        return ((MetaDo.w + Float.floatToRawIntBits(this.s)) * 31) + Float.floatToRawIntBits(this.X);
    }

    public String toString() {
        return Util.S("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.s), Float.valueOf(this.X));
    }

    public PlaybackParameters(@FloatRange(from = 0.0d, fromInclusive = false) float f2, @FloatRange(from = 0.0d, fromInclusive = false) float f3) {
        boolean z = false;
        Assertions.a(f2 > 0.0f);
        Assertions.a(f3 > 0.0f ? true : z);
        this.s = f2;
        this.X = f3;
        this.Y = Math.round(f2 * 1000.0f);
    }
}
