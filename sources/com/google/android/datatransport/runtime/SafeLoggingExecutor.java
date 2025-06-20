package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

class SafeLoggingExecutor implements Executor {
    private final Executor s;

    static class SafeLoggingRunnable implements Runnable {
        private final Runnable s;

        SafeLoggingRunnable(Runnable runnable) {
            this.s = runnable;
        }

        public void run() {
            try {
                this.s.run();
            } catch (Exception e2) {
                Logging.f("Executor", "Background execution failure.", e2);
            }
        }
    }

    SafeLoggingExecutor(Executor executor) {
        this.s = executor;
    }

    public void execute(Runnable runnable) {
        this.s.execute(new SafeLoggingRunnable(runnable));
    }
}
