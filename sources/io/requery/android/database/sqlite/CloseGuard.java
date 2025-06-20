package io.requery.android.database.sqlite;

import android.util.Log;

public final class CloseGuard {
    private static volatile boolean ENABLED = true;
    private static final CloseGuard NOOP = new CloseGuard();
    private static volatile Reporter REPORTER = new DefaultReporter();
    private Throwable allocationSite;

    private static final class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        public void report(String str, Throwable th) {
            Log.w("SQLite", str, th);
        }
    }

    public interface Reporter {
        void report(String str, Throwable th);
    }

    private CloseGuard() {
    }

    public static CloseGuard get() {
        return !ENABLED ? NOOP : new CloseGuard();
    }

    public static Reporter getReporter() {
        return REPORTER;
    }

    public static void setEnabled(boolean z) {
        ENABLED = z;
    }

    public static void setReporter(Reporter reporter) {
        if (reporter != null) {
            REPORTER = reporter;
            return;
        }
        throw new NullPointerException("reporter == null");
    }

    public void close() {
        this.allocationSite = null;
    }

    public void open(String str) {
        if (str == null) {
            throw new NullPointerException("closer == null");
        } else if (this != NOOP && ENABLED) {
            this.allocationSite = new Throwable("Explicit termination method '" + str + "' not called");
        }
    }

    public void warnIfOpen() {
        if (this.allocationSite != null && ENABLED) {
            REPORTER.report("A resource was acquired at attached stack trace but never released. See java.io.Closeable for information on avoiding resource leaks.", this.allocationSite);
        }
    }
}
