package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.PrintStream;
import java.lang.Thread;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class UncaughtExceptionHandlers {

    @VisibleForTesting
    static final class Exiter implements Thread.UncaughtExceptionHandler {

        /* renamed from: b  reason: collision with root package name */
        private static final Logger f23257b = Logger.getLogger(Exiter.class.getName());

        /* renamed from: a  reason: collision with root package name */
        private final Runtime f23258a;

        Exiter(Runtime runtime) {
            this.f23258a = runtime;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            try {
                f23257b.log(Level.SEVERE, String.format(Locale.ROOT, "Caught an exception in %s.  Shutting down.", new Object[]{thread}), th);
            } catch (Error | RuntimeException e2) {
                PrintStream printStream = System.err;
                printStream.println(th.getMessage());
                printStream.println(e2.getMessage());
            } catch (Throwable th2) {
                this.f23258a.exit(1);
                throw th2;
            }
            this.f23258a.exit(1);
        }
    }

    private UncaughtExceptionHandlers() {
    }

    public static Thread.UncaughtExceptionHandler a() {
        return new Exiter(Runtime.getRuntime());
    }
}
