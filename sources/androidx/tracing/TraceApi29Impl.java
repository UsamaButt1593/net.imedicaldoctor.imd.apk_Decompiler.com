package androidx.tracing;

import android.os.Trace;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void a(@NonNull String str, int i2) {
        Trace.beginAsyncSection(str, i2);
    }

    public static void b(@NonNull String str, int i2) {
        Trace.endAsyncSection(str, i2);
    }

    public static void c(@NonNull String str, int i2) {
        Trace.setCounter(str, (long) i2);
    }
}
