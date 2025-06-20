package androidx.media3.exoplayer.drm;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.UnstableApi;
import java.util.Map;

@UnstableApi
public final class WidevineUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String f11354a = "LicenseDurationRemaining";

    /* renamed from: b  reason: collision with root package name */
    public static final String f11355b = "PlaybackDurationRemaining";

    private WidevineUtil() {
    }

    private static long a(Map<String, String> map, String str) {
        if (map == null) {
            return C.f9084b;
        }
        try {
            String str2 = map.get(str);
            return str2 != null ? Long.parseLong(str2) : C.f9084b;
        } catch (NumberFormatException unused) {
            return C.f9084b;
        }
    }

    @Nullable
    public static Pair<Long, Long> b(DrmSession drmSession) {
        Map<String, String> i2 = drmSession.i();
        if (i2 == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(a(i2, f11354a)), Long.valueOf(a(i2, f11355b)));
    }
}
