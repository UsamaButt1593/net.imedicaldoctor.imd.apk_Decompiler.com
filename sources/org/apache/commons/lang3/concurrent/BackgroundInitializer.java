package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    private ExecutorService executor;
    private ExecutorService externalExecutor;
    private Future<T> future;

    private class InitializationTask implements Callable<T> {
        private final ExecutorService execFinally;

        public InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        public T call() throws Exception {
            try {
                return BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }

    protected BackgroundInitializer() {
        this((ExecutorService) null);
    }

    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    private Callable<T> createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (ExecutionException e2) {
            ConcurrentUtils.handleCause(e2);
            return null;
        } catch (InterruptedException e3) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e3);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized ExecutorService getActiveExecutor() {
        return this.executor;
    }

    public final synchronized ExecutorService getExternalExecutor() {
        return this.externalExecutor;
    }

    public synchronized Future<T> getFuture() {
        Future<T> future2;
        future2 = this.future;
        if (future2 == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future2;
    }

    /* access modifiers changed from: protected */
    public int getTaskCount() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws Exception;

    public synchronized boolean isStarted() {
        return this.future != null;
    }

    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (!isStarted()) {
            this.externalExecutor = executorService;
        } else {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
    }

    public synchronized boolean start() {
        ExecutorService executorService;
        try {
            if (isStarted()) {
                return false;
            }
            ExecutorService externalExecutor2 = getExternalExecutor();
            this.executor = externalExecutor2;
            if (externalExecutor2 == null) {
                executorService = createExecutor();
                this.executor = executorService;
            } else {
                executorService = null;
            }
            this.future = this.executor.submit(createTask(executorService));
            return true;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    protected BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }
}
