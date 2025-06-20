package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Throwables {
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: a  reason: collision with root package name */
    private static final String f22297a = "sun.misc.JavaLangAccess";
    @GwtIncompatible
    @J2ktIncompatible
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final String f22298b = "sun.misc.SharedSecrets";
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: c  reason: collision with root package name */
    public static final Object f22299c;
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: d  reason: collision with root package name */
    public static final Method f22300d;
    /* access modifiers changed from: private */
    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: e  reason: collision with root package name */
    public static final Method f22301e;

    static {
        Object h2 = h();
        f22299c = h2;
        Method method = null;
        f22300d = h2 == null ? null : g();
        if (h2 != null) {
            method = k(h2);
        }
        f22301e = method;
    }

    private Throwables() {
    }

    public static List<Throwable> e(Throwable th) {
        Preconditions.E(th);
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(th);
        boolean z = false;
        Throwable th2 = th;
        while (true) {
            th = th.getCause();
            if (th == null) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(th);
            if (th != th2) {
                if (z) {
                    th2 = th2.getCause();
                }
                z = !z;
            } else {
                throw new IllegalArgumentException("Loop in causal chain detected.", th);
            }
        }
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    public static <X extends Throwable> X f(Throwable th, Class<X> cls) {
        try {
            return (Throwable) cls.cast(th.getCause());
        } catch (ClassCastException e2) {
            e2.initCause(th);
            throw e2;
        }
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Method g() {
        return i("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    @CheckForNull
    @GwtIncompatible
    @J2ktIncompatible
    private static Object h() {
        try {
            return Class.forName(f22298b, false, (ClassLoader) null).getMethod("getJavaLangAccess", (Class[]) null).invoke((Object) null, (Object[]) null);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    private static Method i(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName(f22297a, false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e2) {
            throw e2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Throwable j(Throwable th) {
        boolean z = false;
        Throwable th2 = th;
        while (true) {
            Throwable cause = th.getCause();
            if (cause == null) {
                return th;
            }
            if (cause != th2) {
                if (z) {
                    th2 = th2.getCause();
                }
                z = !z;
                th = cause;
            } else {
                throw new IllegalArgumentException("Loop in causal chain detected.", cause);
            }
        }
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    private static Method k(Object obj) {
        try {
            Method i2 = i("getStackTraceDepth", Throwable.class);
            if (i2 == null) {
                return null;
            }
            i2.invoke(obj, new Object[]{new Throwable()});
            return i2;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    @GwtIncompatible
    public static String l(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    @J2ktIncompatible
    public static Object m(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw q(e3.getCause());
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private static List<StackTraceElement> n(final Throwable th) {
        Preconditions.E(th);
        return new AbstractList<StackTraceElement>() {
            /* renamed from: b */
            public StackTraceElement get(int i2) {
                Method a2 = Throwables.f22300d;
                Objects.requireNonNull(a2);
                Object b2 = Throwables.f22299c;
                Objects.requireNonNull(b2);
                return (StackTraceElement) Throwables.m(a2, b2, th, Integer.valueOf(i2));
            }

            public int size() {
                Method d2 = Throwables.f22301e;
                Objects.requireNonNull(d2);
                Object b2 = Throwables.f22299c;
                Objects.requireNonNull(b2);
                return ((Integer) Throwables.m(d2, b2, th)).intValue();
            }
        };
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static List<StackTraceElement> o(Throwable th) {
        return p() ? n(th) : Collections.unmodifiableList(Arrays.asList(th.getStackTrace()));
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static boolean p() {
        return (f22300d == null || f22301e == null) ? false : true;
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @Deprecated
    @J2ktIncompatible
    public static RuntimeException q(Throwable th) {
        w(th);
        throw new RuntimeException(th);
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static <X extends Throwable> void r(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        if (th != null) {
            v(th, cls);
        }
    }

    @GwtIncompatible
    @Deprecated
    @J2ktIncompatible
    public static void s(@CheckForNull Throwable th) {
        if (th != null) {
            w(th);
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X extends Throwable> void t(@CheckForNull Throwable th, Class<X> cls) throws Throwable {
        r(th, cls);
        s(th);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X1 extends Throwable, X2 extends Throwable> void u(@CheckForNull Throwable th, Class<X1> cls, Class<X2> cls2) throws Throwable, Throwable {
        Preconditions.E(cls2);
        r(th, cls);
        t(th, cls2);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <X extends Throwable> void v(Throwable th, Class<X> cls) throws Throwable {
        Preconditions.E(th);
        if (cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void w(Throwable th) {
        Preconditions.E(th);
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        }
    }
}
