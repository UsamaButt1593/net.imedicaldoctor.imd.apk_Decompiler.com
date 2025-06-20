package androidx.tracing;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Trace {

    /* renamed from: a  reason: collision with root package name */
    static final String f15954a = "Trace";

    /* renamed from: b  reason: collision with root package name */
    private static long f15955b;

    /* renamed from: c  reason: collision with root package name */
    private static Method f15956c;

    /* renamed from: d  reason: collision with root package name */
    private static Method f15957d;

    /* renamed from: e  reason: collision with root package name */
    private static Method f15958e;

    /* renamed from: f  reason: collision with root package name */
    private static Method f15959f;

    private Trace() {
    }

    @SuppressLint({"NewApi"})
    public static void a(@NonNull String str, int i2) {
        try {
            if (f15957d == null) {
                TraceApi29Impl.a(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i2);
    }

    private static void b(@NonNull String str, int i2) {
        try {
            if (f15957d == null) {
                f15957d = android.os.Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            f15957d.invoke((Object) null, new Object[]{Long.valueOf(f15955b), str, Integer.valueOf(i2)});
        } catch (Exception e2) {
            g("asyncTraceBegin", e2);
        }
    }

    public static void c(@NonNull String str) {
        TraceApi18Impl.a(str);
    }

    @SuppressLint({"NewApi"})
    public static void d(@NonNull String str, int i2) {
        try {
            if (f15958e == null) {
                TraceApi29Impl.b(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i2);
    }

    private static void e(@NonNull String str, int i2) {
        try {
            if (f15958e == null) {
                f15958e = android.os.Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            f15958e.invoke((Object) null, new Object[]{Long.valueOf(f15955b), str, Integer.valueOf(i2)});
        } catch (Exception e2) {
            g("asyncTraceEnd", e2);
        }
    }

    public static void f() {
        TraceApi18Impl.b();
    }

    private static void g(@NonNull String str, @NonNull Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v(f15954a, "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean h() {
        try {
            if (f15956c == null) {
                return android.os.Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    private static boolean i() {
        Class<android.os.Trace> cls = android.os.Trace.class;
        try {
            if (f15956c == null) {
                f15955b = cls.getField("TRACE_TAG_APP").getLong((Object) null);
                f15956c = cls.getMethod("isTagEnabled", new Class[]{Long.TYPE});
            }
            return ((Boolean) f15956c.invoke((Object) null, new Object[]{Long.valueOf(f15955b)})).booleanValue();
        } catch (Exception e2) {
            g("isTagEnabled", e2);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void j(@NonNull String str, int i2) {
        try {
            if (f15959f == null) {
                TraceApi29Impl.c(str, i2);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        k(str, i2);
    }

    private static void k(@NonNull String str, int i2) {
        try {
            if (f15959f == null) {
                f15959f = android.os.Trace.class.getMethod("traceCounter", new Class[]{Long.TYPE, String.class, Integer.TYPE});
            }
            f15959f.invoke((Object) null, new Object[]{Long.valueOf(f15955b), str, Integer.valueOf(i2)});
        } catch (Exception e2) {
            g("traceCounter", e2);
        }
    }
}
