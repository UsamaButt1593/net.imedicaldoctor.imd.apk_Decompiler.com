package androidx.media3.common.util;

import android.os.Trace;
import androidx.annotation.RequiresApi;

@UnstableApi
public final class TraceUtil {
    private TraceUtil() {
    }

    public static void a(String str) {
        if (Util.f9646a >= 18) {
            b(str);
        }
    }

    @RequiresApi(18)
    private static void b(String str) {
        Trace.beginSection(str);
    }

    public static void c() {
        if (Util.f9646a >= 18) {
            d();
        }
    }

    @RequiresApi(18)
    private static void d() {
        Trace.endSection();
    }
}
