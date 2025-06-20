package io.reactivex.rxjava3.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class TestScheduler extends Scheduler {
    final Queue<TimedRunnable> X = new PriorityBlockingQueue(11);
    long Y;
    volatile long Z;

    final class TestWorker extends Scheduler.Worker {
        volatile boolean s;

        final class QueueRemove implements Runnable {
            final TimedRunnable s;

            QueueRemove(TimedRunnable timedRunnable) {
                this.s = timedRunnable;
            }

            public void run() {
                TestScheduler.this.X.remove(this.s);
            }
        }

        TestWorker() {
        }

        public long a(@NonNull TimeUnit timeUnit) {
            return TestScheduler.this.e(timeUnit);
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            if (this.s) {
                return EmptyDisposable.INSTANCE;
            }
            TestScheduler testScheduler = TestScheduler.this;
            long j2 = testScheduler.Y;
            testScheduler.Y = 1 + j2;
            TimedRunnable timedRunnable = new TimedRunnable(this, 0, runnable, j2);
            TestScheduler.this.X.add(timedRunnable);
            return b.g(new QueueRemove(timedRunnable));
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            if (this.s) {
                return EmptyDisposable.INSTANCE;
            }
            long nanos = TestScheduler.this.Z + timeUnit.toNanos(j2);
            TestScheduler testScheduler = TestScheduler.this;
            long j3 = testScheduler.Y;
            testScheduler.Y = 1 + j3;
            TimedRunnable timedRunnable = new TimedRunnable(this, nanos, runnable, j3);
            TestScheduler.this.X.add(timedRunnable);
            return b.g(new QueueRemove(timedRunnable));
        }

        public boolean g() {
            return this.s;
        }

        public void m() {
            this.s = true;
        }
    }

    static final class TimedRunnable implements Comparable<TimedRunnable> {
        final Runnable X;
        final TestWorker Y;
        final long Z;
        final long s;

        TimedRunnable(TestWorker testWorker, long j2, Runnable runnable, long j3) {
            this.s = j2;
            this.X = runnable;
            this.Y = testWorker;
            this.Z = j3;
        }

        /* renamed from: a */
        public int compareTo(TimedRunnable timedRunnable) {
            long j2 = this.s;
            long j3 = timedRunnable.s;
            return j2 == j3 ? Long.compare(this.Z, timedRunnable.Z) : Long.compare(j2, j3);
        }

        public String toString() {
            return String.format("TimedRunnable(time = %d, run = %s)", new Object[]{Long.valueOf(this.s), this.X.toString()});
        }
    }

    public TestScheduler() {
    }

    private void q(long j2) {
        while (true) {
            TimedRunnable peek = this.X.peek();
            if (peek == null) {
                break;
            }
            long j3 = peek.s;
            if (j3 > j2) {
                break;
            }
            if (j3 == 0) {
                j3 = this.Z;
            }
            this.Z = j3;
            this.X.remove(peek);
            if (!peek.Y.s) {
                peek.X.run();
            }
        }
        this.Z = j2;
    }

    @NonNull
    public Scheduler.Worker d() {
        return new TestWorker();
    }

    public long e(@NonNull TimeUnit timeUnit) {
        return timeUnit.convert(this.Z, TimeUnit.NANOSECONDS);
    }

    public void n(long j2, TimeUnit timeUnit) {
        o(this.Z + timeUnit.toNanos(j2), TimeUnit.NANOSECONDS);
    }

    public void o(long j2, TimeUnit timeUnit) {
        q(timeUnit.toNanos(j2));
    }

    public void p() {
        q(this.Z);
    }

    public TestScheduler(long j2, TimeUnit timeUnit) {
        this.Z = timeUnit.toNanos(j2);
    }
}
