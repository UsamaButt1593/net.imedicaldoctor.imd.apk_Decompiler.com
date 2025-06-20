package androidx.core.os;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

@Deprecated
public final class TraceCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6076a = "TraceCompat";

    /* renamed from: b  reason: collision with root package name */
    private static long f6077b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f6078c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f6079d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f6080e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f6081f;

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static void a(String str, int i2) {
            Trace.beginAsyncSection(str, i2);
        }

        @DoNotInline
        static void b(String str, int i2) {
            Trace.endAsyncSection(str, i2);
        }

        @DoNotInline
        static boolean c() {
            return Trace.isEnabled();
        }

        @DoNotInline
        static void d(String str, long j2) {
            Trace.setCounter(str, j2);
        }
    }

    static {
        Class<String> cls = String.class;
        Class<Trace> cls2 = Trace.class;
        if (Build.VERSION.SDK_INT < 29) {
            try {
                f6077b = cls2.getField("TRACE_TAG_APP").getLong((Object) null);
                Class cls3 = Long.TYPE;
                f6078c = cls2.getMethod("isTagEnabled", new Class[]{cls3});
                Class cls4 = Integer.TYPE;
                f6079d = cls2.getMethod("asyncTraceBegin", new Class[]{cls3, cls, cls4});
                f6080e = cls2.getMethod("asyncTraceEnd", new Class[]{cls3, cls, cls4});
                f6081f = cls2.getMethod("traceCounter", new Class[]{cls3, cls, cls4});
            } catch (Exception e2) {
                Log.i(f6076a, "Unable to initialize via reflection.", e2);
            }
        }
    }

    private TraceCompat() {
    }

    public static void a(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.a(str, i2);
            return;
        }
        try {
            f6079d.invoke((Object) null, new Object[]{Long.valueOf(f6077b), str, Integer.valueOf(i2)});
        } catch (Exception unused) {
            Log.v(f6076a, "Unable to invoke asyncTraceBegin() via reflection.");
        }
    }

    public static void b(@NonNull String str) {
        Trace.beginSection(str);
    }

    public static void c(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.b(str, i2);
            return;
        }
        try {
            f6080e.invoke((Object) null, new Object[]{Long.valueOf(f6077b), str, Integer.valueOf(i2)});
        } catch (Exception unused) {
            Log.v(f6076a, "Unable to invoke endAsyncSection() via reflection.");
        }
    }

    public static void d() {
        Trace.endSection();
    }

    public static boolean e() {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.c();
        }
        try {
            return ((Boolean) f6078c.invoke((Object) null, new Object[]{Long.valueOf(f6077b)})).booleanValue();
        } catch (Exception unused) {
            Log.v(f6076a, "Unable to invoke isTagEnabled() via reflection.");
            return false;
        }
    }

    public static void f(@NonNull String str, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.d(str, (long) i2);
            return;
        }
        try {
            f6081f.invoke((Object) null, new Object[]{Long.valueOf(f6077b), str, Integer.valueOf(i2)});
        } catch (Exception unused) {
            Log.v(f6076a, "Unable to invoke traceCounter() via reflection.");
        }
    }
}
