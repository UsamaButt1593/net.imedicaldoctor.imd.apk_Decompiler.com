package androidx.core.os;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class ExecutorCompat {

    private static class HandlerExecutor implements Executor {
        private final Handler s;

        HandlerExecutor(@NonNull Handler handler) {
            this.s = (Handler) Preconditions.l(handler);
        }

        public void execute(@NonNull Runnable runnable) {
            if (!this.s.post((Runnable) Preconditions.l(runnable))) {
                throw new RejectedExecutionException(this.s + " is shutting down");
            }
        }
    }

    private ExecutorCompat() {
    }

    @NonNull
    public static Executor a(@NonNull Handler handler) {
        return new HandlerExecutor(handler);
    }
}
