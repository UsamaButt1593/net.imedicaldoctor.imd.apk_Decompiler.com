package androidx.media3.common.util;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.net.UnknownHostException;
import org.apache.commons.lang3.StringUtils;
import org.checkerframework.dataflow.qual.Pure;

@UnstableApi
public final class Log {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9571a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9572b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9573c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f9574d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f9575e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    private static final Object f9576f = new Object();
    @GuardedBy("lock")

    /* renamed from: g  reason: collision with root package name */
    private static int f9577g = 0;
    @GuardedBy("lock")

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9578h = true;
    @GuardedBy("lock")

    /* renamed from: i  reason: collision with root package name */
    private static Logger f9579i = Logger.f9580a;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LogLevel {
    }

    public interface Logger {

        /* renamed from: a  reason: collision with root package name */
        public static final Logger f9580a = new Logger() {
            public void a(String str, String str2, @Nullable Throwable th) {
                android.util.Log.w(str, Log.a(str2, th));
            }

            public void b(String str, String str2, @Nullable Throwable th) {
                android.util.Log.e(str, Log.a(str2, th));
            }

            public void c(String str, String str2, @Nullable Throwable th) {
                android.util.Log.d(str, Log.a(str2, th));
            }

            public void d(String str, String str2, @Nullable Throwable th) {
                android.util.Log.i(str, Log.a(str2, th));
            }
        };

        void a(String str, String str2, @Nullable Throwable th);

        void b(String str, String str2, @Nullable Throwable th);

        void c(String str, String str2, @Nullable Throwable th);

        void d(String str, String str2, @Nullable Throwable th);
    }

    private Log() {
    }

    @Pure
    public static String a(String str, @Nullable Throwable th) {
        String g2 = g(th);
        if (TextUtils.isEmpty(g2)) {
            return str;
        }
        return str + "\n  " + g2.replace(StringUtils.LF, "\n  ") + 10;
    }

    @Pure
    public static void b(@Size(max = 23) String str, String str2) {
        synchronized (f9576f) {
            try {
                if (f9577g == 0) {
                    f9579i.c(str, str2, (Throwable) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    public static void c(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (f9576f) {
            try {
                if (f9577g == 0) {
                    f9579i.c(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    public static void d(@Size(max = 23) String str, String str2) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 3) {
                    f9579i.b(str, str2, (Throwable) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    public static void e(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 3) {
                    f9579i.b(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    public static int f() {
        int i2;
        synchronized (f9576f) {
            i2 = f9577g;
        }
        return i2;
    }

    @Nullable
    @Pure
    public static String g(@Nullable Throwable th) {
        if (th == null) {
            return null;
        }
        synchronized (f9576f) {
            try {
                if (j(th)) {
                    return "UnknownHostException (no network)";
                }
                if (!f9578h) {
                    String message = th.getMessage();
                    return message;
                }
                String replace = android.util.Log.getStackTraceString(th).trim().replace("\t", "    ");
                return replace;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    public static void h(@Size(max = 23) String str, String str2) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 1) {
                    f9579i.d(str, str2, (Throwable) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    public static void i(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 1) {
                    f9579i.d(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Pure
    private static boolean j(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void k(int i2) {
        synchronized (f9576f) {
            f9577g = i2;
        }
    }

    public static void l(boolean z) {
        synchronized (f9576f) {
            f9578h = z;
        }
    }

    public static void m(Logger logger) {
        synchronized (f9576f) {
            f9579i = logger;
        }
    }

    @Pure
    public static void n(@Size(max = 23) String str, String str2) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 2) {
                    f9579i.a(str, str2, (Throwable) null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Pure
    public static void o(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        synchronized (f9576f) {
            try {
                if (f9577g <= 2) {
                    f9579i.a(str, str2, th);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
