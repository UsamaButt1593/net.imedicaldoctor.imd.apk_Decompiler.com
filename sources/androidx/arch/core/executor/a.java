package androidx.arch.core.executor;

import java.util.concurrent.Executor;

public final /* synthetic */ class a implements Executor {
    public final void execute(Runnable runnable) {
        ArchTaskExecutor.h().d(runnable);
    }
}
