package androidx.media3.container;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public final class Mp4Util {

    /* renamed from: a  reason: collision with root package name */
    private static final int f9665a = 2082844800;

    private Mp4Util() {
    }

    public static long a(long j2) {
        return (j2 - 2082844800) * 1000;
    }

    public static long b(long j2) {
        return (j2 / 1000) + 2082844800;
    }
}
