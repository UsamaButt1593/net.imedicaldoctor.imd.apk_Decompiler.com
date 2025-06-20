package com.google.common.util.concurrent;

import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class ExecutionSequencer {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<ListenableFuture<Void>> f23171a = new AtomicReference<>(Futures.p());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ThreadConfinedTaskQueue f23172b = new ThreadConfinedTaskQueue();

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        @CheckForNull
        Executor X;
        @CheckForNull
        Runnable Y;
        @CheckForNull
        Thread Z;
        @CheckForNull
        ExecutionSequencer s;

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.X = executor;
            this.s = executionSequencer;
        }

        /* access modifiers changed from: private */
        public boolean c() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }

        /* access modifiers changed from: private */
        public boolean d() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.X = null;
                this.s = null;
                return;
            }
            this.Z = Thread.currentThread();
            try {
                ExecutionSequencer executionSequencer = this.s;
                Objects.requireNonNull(executionSequencer);
                ThreadConfinedTaskQueue b2 = executionSequencer.f23172b;
                if (b2.f23176a == this.Z) {
                    this.s = null;
                    Preconditions.g0(b2.f23177b == null);
                    b2.f23177b = runnable;
                    Executor executor = this.X;
                    Objects.requireNonNull(executor);
                    b2.f23178c = executor;
                    this.X = null;
                } else {
                    Executor executor2 = this.X;
                    Objects.requireNonNull(executor2);
                    this.X = null;
                    this.Y = runnable;
                    executor2.execute(this);
                }
            } finally {
                this.Z = null;
            }
        }

        public void run() {
            Executor executor;
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.Z) {
                Runnable runnable = this.Y;
                Objects.requireNonNull(runnable);
                this.Y = null;
                runnable.run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue();
            threadConfinedTaskQueue.f23176a = currentThread;
            ExecutionSequencer executionSequencer = this.s;
            Objects.requireNonNull(executionSequencer);
            ThreadConfinedTaskQueue unused = executionSequencer.f23172b = threadConfinedTaskQueue;
            this.s = null;
            try {
                Runnable runnable2 = this.Y;
                Objects.requireNonNull(runnable2);
                this.Y = null;
                runnable2.run();
                while (true) {
                    Runnable runnable3 = threadConfinedTaskQueue.f23177b;
                    if (runnable3 != null && (executor = threadConfinedTaskQueue.f23178c) != null) {
                        threadConfinedTaskQueue.f23177b = null;
                        threadConfinedTaskQueue.f23178c = null;
                        executor.execute(runnable3);
                    }
                }
            } finally {
                threadConfinedTaskQueue.f23176a = null;
            }
        }
    }

    private static final class ThreadConfinedTaskQueue {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        Thread f23176a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        Runnable f23177b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Executor f23178c;

        private ThreadConfinedTaskQueue() {
        }
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer d() {
        return new ExecutionSequencer();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            settableFuture.D(listenableFuture);
        } else if (listenableFuture2.isCancelled() && taskNonReentrantExecutor.c()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    public <T> ListenableFuture<T> f(final Callable<T> callable, Executor executor) {
        Preconditions.E(callable);
        Preconditions.E(executor);
        return g(new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                return Futures.o(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> g(final AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.E(asyncCallable);
        Preconditions.E(executor);
        final TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this);
        AnonymousClass2 r9 = new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                return !taskNonReentrantExecutor.d() ? Futures.m() : asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        SettableFuture F = SettableFuture.F();
        ListenableFuture andSet = this.f23171a.getAndSet(F);
        TrustedListenableFutureTask N = TrustedListenableFutureTask.N(r9);
        andSet.a0(N, taskNonReentrantExecutor);
        ListenableFuture<T> u = Futures.u(N);
        s sVar = new s(N, F, andSet, u, taskNonReentrantExecutor);
        u.a0(sVar, MoreExecutors.c());
        N.a0(sVar, MoreExecutors.c());
        return u;
    }
}
