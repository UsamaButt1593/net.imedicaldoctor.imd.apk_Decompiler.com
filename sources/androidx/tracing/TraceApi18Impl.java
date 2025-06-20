package androidx.tracing;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(18)
final class TraceApi18Impl {
    private TraceApi18Impl() {
    }

    public static void a(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
