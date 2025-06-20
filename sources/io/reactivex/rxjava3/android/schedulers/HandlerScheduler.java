package io.reactivex.rxjava3.android.schedulers;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

final class HandlerScheduler extends Scheduler {
    private final Handler X;
    private final boolean Y;

    private static final class HandlerWorker extends Scheduler.Worker {
        private final boolean X;
        private volatile boolean Y;
        private final Handler s;

        HandlerWorker(Handler handler, boolean z) {
            this.s = handler;
            this.X = z;
        }

        @SuppressLint({"NewApi"})
        public Disposable c(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            } else if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            } else if (this.Y) {
                return b.a();
            } else {
                ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.s, RxJavaPlugins.b0(runnable));
                Message obtain = Message.obtain(this.s, scheduledRunnable);
                obtain.obj = this;
                if (this.X) {
                    obtain.setAsynchronous(true);
                }
                this.s.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
                if (!this.Y) {
                    return scheduledRunnable;
                }
                this.s.removeCallbacks(scheduledRunnable);
                return b.a();
            }
        }

        public boolean g() {
            return this.Y;
        }

        public void m() {
            this.Y = true;
            this.s.removeCallbacksAndMessages(this);
        }
    }

    private static final class ScheduledRunnable implements Runnable, Disposable {
        private final Runnable X;
        private volatile boolean Y;
        private final Handler s;

        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.s = handler;
            this.X = runnable;
        }

        public boolean g() {
            return this.Y;
        }

        public void m() {
            this.s.removeCallbacks(this);
            this.Y = true;
        }

        public void run() {
            try {
                this.X.run();
            } catch (Throwable th) {
                RxJavaPlugins.Y(th);
            }
        }
    }

    HandlerScheduler(Handler handler, boolean z) {
        this.X = handler;
        this.Y = z;
    }

    public Scheduler.Worker d() {
        return new HandlerWorker(this.X, this.Y);
    }

    @SuppressLint({"NewApi"})
    public Disposable h(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        } else if (timeUnit != null) {
            ScheduledRunnable scheduledRunnable = new ScheduledRunnable(this.X, RxJavaPlugins.b0(runnable));
            Message obtain = Message.obtain(this.X, scheduledRunnable);
            if (this.Y) {
                obtain.setAsynchronous(true);
            }
            this.X.sendMessageDelayed(obtain, timeUnit.toMillis(j2));
            return scheduledRunnable;
        } else {
            throw new NullPointerException("unit == null");
        }
    }
}
