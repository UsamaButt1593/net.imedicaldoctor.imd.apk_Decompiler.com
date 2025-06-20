package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Closer implements Closeable {
    private static final Suppressor Z;
    private final Deque<Closeable> X = new ArrayDeque(4);
    @CheckForNull
    private Throwable Y;
    @VisibleForTesting
    final Suppressor s;

    @VisibleForTesting
    static final class LoggingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        static final LoggingSuppressor f22777a = new LoggingSuppressor();

        LoggingSuppressor() {
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            Logger logger = Closeables.f22776a;
            Level level = Level.WARNING;
            logger.log(level, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @VisibleForTesting
    static final class SuppressingSuppressor implements Suppressor {

        /* renamed from: a  reason: collision with root package name */
        private final Method f22778a;

        private SuppressingSuppressor(Method method) {
            this.f22778a = method;
        }

        @CheckForNull
        static SuppressingSuppressor b() {
            Class<Throwable> cls = Throwable.class;
            try {
                return new SuppressingSuppressor(cls.getMethod("addSuppressed", new Class[]{cls}));
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a(Closeable closeable, Throwable th, Throwable th2) {
            if (th != th2) {
                try {
                    this.f22778a.invoke(th, new Object[]{th2});
                } catch (Throwable unused) {
                    LoggingSuppressor.f22777a.a(closeable, th, th2);
                }
            }
        }
    }

    @VisibleForTesting
    interface Suppressor {
        void a(Closeable closeable, Throwable th, Throwable th2);
    }

    static {
        Suppressor b2 = SuppressingSuppressor.b();
        if (b2 == null) {
            b2 = LoggingSuppressor.f22777a;
        }
        Z = b2;
    }

    @VisibleForTesting
    Closer(Suppressor suppressor) {
        this.s = (Suppressor) Preconditions.E(suppressor);
    }

    public static Closer b() {
        return new Closer(Z);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public <C extends Closeable> C c(@ParametricNullness C c2) {
        if (c2 != null) {
            this.X.addFirst(c2);
        }
        return c2;
    }

    public void close() throws IOException {
        Throwable th = this.Y;
        while (!this.X.isEmpty()) {
            Closeable removeFirst = this.X.removeFirst();
            try {
                removeFirst.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    this.s.a(removeFirst, th, th2);
                }
            }
        }
        if (this.Y == null && th != null) {
            Throwables.t(th, IOException.class);
            throw new AssertionError(th);
        }
    }

    public RuntimeException d(Throwable th) throws IOException {
        Preconditions.E(th);
        this.Y = th;
        Throwables.t(th, IOException.class);
        throw new RuntimeException(th);
    }

    public <X extends Exception> RuntimeException e(Throwable th, Class<X> cls) throws IOException, Exception {
        Preconditions.E(th);
        this.Y = th;
        Throwables.t(th, IOException.class);
        Throwables.t(th, cls);
        throw new RuntimeException(th);
    }

    public <X1 extends Exception, X2 extends Exception> RuntimeException f(Throwable th, Class<X1> cls, Class<X2> cls2) throws IOException, Exception, Exception {
        Preconditions.E(th);
        this.Y = th;
        Throwables.t(th, IOException.class);
        Throwables.u(th, cls, cls2);
        throw new RuntimeException(th);
    }
}
