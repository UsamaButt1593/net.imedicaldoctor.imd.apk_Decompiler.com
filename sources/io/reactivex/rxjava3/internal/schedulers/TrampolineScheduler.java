package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class TrampolineScheduler extends Scheduler {
    private static final TrampolineScheduler X = new TrampolineScheduler();

    static final class SleepingRunnable implements Runnable {
        private final TrampolineWorker X;
        private final long Y;
        private final Runnable s;

        SleepingRunnable(Runnable runnable, TrampolineWorker trampolineWorker, long j2) {
            this.s = runnable;
            this.X = trampolineWorker;
            this.Y = j2;
        }

        public void run() {
            if (!this.X.Z) {
                long a2 = this.X.a(TimeUnit.MILLISECONDS);
                long j2 = this.Y;
                if (j2 > a2) {
                    try {
                        Thread.sleep(j2 - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        RxJavaPlugins.Y(e2);
                        return;
                    }
                }
                if (!this.X.Z) {
                    this.s.run();
                }
            }
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final long X;
        final int Y;
        volatile boolean Z;
        final Runnable s;

        TimedRunnable(Runnable runnable, Long l2, int i2) {
            this.s = runnable;
            this.X = l2.longValue();
            this.Y = i2;
        }

        /* renamed from: a */
        public int compareTo(TimedRunnable timedRunnable) {
            int compare = Long.compare(this.X, timedRunnable.X);
            return compare == 0 ? Integer.compare(this.Y, timedRunnable.Y) : compare;
        }
    }

    static final class TrampolineWorker extends Scheduler.Worker implements Disposable {
        private final AtomicInteger X = new AtomicInteger();
        final AtomicInteger Y = new AtomicInteger();
        volatile boolean Z;
        final PriorityBlockingQueue<TimedRunnable> s = new PriorityBlockingQueue<>();

        final class AppendToQueueTask implements Runnable {
            final TimedRunnable s;

            AppendToQueueTask(TimedRunnable timedRunnable) {
                this.s = timedRunnable;
            }

            public void run() {
                this.s.Z = true;
                TrampolineWorker.this.s.remove(this.s);
            }
        }

        TrampolineWorker() {
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j2);
            return e(new SleepingRunnable(runnable, this, a2), a2);
        }

        /* access modifiers changed from: package-private */
        public Disposable e(Runnable runnable, long j2) {
            if (this.Z) {
                return EmptyDisposable.INSTANCE;
            }
            TimedRunnable timedRunnable = new TimedRunnable(runnable, Long.valueOf(j2), this.Y.incrementAndGet());
            this.s.add(timedRunnable);
            if (this.X.getAndIncrement() != 0) {
                return b.g(new AppendToQueueTask(timedRunnable));
            }
            int i2 = 1;
            while (!this.Z) {
                TimedRunnable poll = this.s.poll();
                if (poll == null) {
                    i2 = this.X.addAndGet(-i2);
                    if (i2 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.Z) {
                    poll.s.run();
                }
            }
            this.s.clear();
            return EmptyDisposable.INSTANCE;
        }

        public boolean g() {
            return this.Z;
        }

        public void m() {
            this.Z = true;
        }
    }

    TrampolineScheduler() {
    }

    public static TrampolineScheduler n() {
        return X;
    }

    @NonNull
    public Scheduler.Worker d() {
        return new TrampolineWorker();
    }

    @NonNull
    public Disposable f(@NonNull Runnable runnable) {
        RxJavaPlugins.b0(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @NonNull
    public Disposable h(@NonNull Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j2);
            RxJavaPlugins.b0(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            RxJavaPlugins.Y(e2);
        }
        return EmptyDisposable.INSTANCE;
    }
}
