package io.reactivex.rxjava3.internal.schedulers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.processors.FlowableProcessor;
import io.reactivex.rxjava3.processors.UnicastProcessor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class SchedulerWhen extends Scheduler implements Disposable {
    static final Disposable X2 = new SubscribedDisposable();
    static final Disposable Y2 = b.a();
    private final Scheduler X;
    private final FlowableProcessor<Flowable<Completable>> Y;
    private Disposable Z;

    static final class CreateWorkerFunction implements Function<ScheduledAction, Completable> {
        final Scheduler.Worker s;

        final class WorkerCompletable extends Completable {
            final ScheduledAction s;

            WorkerCompletable(ScheduledAction scheduledAction) {
                this.s = scheduledAction;
            }

            /* access modifiers changed from: protected */
            public void Z0(CompletableObserver completableObserver) {
                completableObserver.b(this.s);
                this.s.a(CreateWorkerFunction.this.s, completableObserver);
            }
        }

        CreateWorkerFunction(Scheduler.Worker worker) {
            this.s = worker;
        }

        /* renamed from: a */
        public Completable apply(ScheduledAction scheduledAction) {
            return new WorkerCompletable(scheduledAction);
        }
    }

    static class DelayedAction extends ScheduledAction {
        private final long X;
        private final TimeUnit Y;
        private final Runnable s;

        DelayedAction(Runnable runnable, long j2, TimeUnit timeUnit) {
            this.s = runnable;
            this.X = j2;
            this.Y = timeUnit;
        }

        /* access modifiers changed from: protected */
        public Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.c(new OnCompletedAction(this.s, completableObserver), this.X, this.Y);
        }
    }

    static class ImmediateAction extends ScheduledAction {
        private final Runnable s;

        ImmediateAction(Runnable runnable) {
            this.s = runnable;
        }

        /* access modifiers changed from: protected */
        public Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver) {
            return worker.b(new OnCompletedAction(this.s, completableObserver));
        }
    }

    static class OnCompletedAction implements Runnable {
        final Runnable X;
        final CompletableObserver s;

        OnCompletedAction(Runnable runnable, CompletableObserver completableObserver) {
            this.X = runnable;
            this.s = completableObserver;
        }

        public void run() {
            try {
                this.X.run();
            } finally {
                this.s.onComplete();
            }
        }
    }

    static final class QueueWorker extends Scheduler.Worker {
        private final FlowableProcessor<ScheduledAction> X;
        private final Scheduler.Worker Y;
        private final AtomicBoolean s = new AtomicBoolean();

        QueueWorker(FlowableProcessor<ScheduledAction> flowableProcessor, Scheduler.Worker worker) {
            this.X = flowableProcessor;
            this.Y = worker;
        }

        @NonNull
        public Disposable b(@NonNull Runnable runnable) {
            ImmediateAction immediateAction = new ImmediateAction(runnable);
            this.X.onNext(immediateAction);
            return immediateAction;
        }

        @NonNull
        public Disposable c(@NonNull Runnable runnable, long j2, @NonNull TimeUnit timeUnit) {
            DelayedAction delayedAction = new DelayedAction(runnable, j2, timeUnit);
            this.X.onNext(delayedAction);
            return delayedAction;
        }

        public boolean g() {
            return this.s.get();
        }

        public void m() {
            if (this.s.compareAndSet(false, true)) {
                this.X.onComplete();
                this.Y.m();
            }
        }
    }

    static abstract class ScheduledAction extends AtomicReference<Disposable> implements Disposable {
        ScheduledAction() {
            super(SchedulerWhen.X2);
        }

        /* access modifiers changed from: package-private */
        public void a(Scheduler.Worker worker, CompletableObserver completableObserver) {
            Disposable disposable;
            Disposable disposable2 = (Disposable) get();
            if (disposable2 != SchedulerWhen.Y2 && disposable2 == (disposable = SchedulerWhen.X2)) {
                Disposable b2 = b(worker, completableObserver);
                if (!compareAndSet(disposable, b2)) {
                    b2.m();
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract Disposable b(Scheduler.Worker worker, CompletableObserver completableObserver);

        public boolean g() {
            return ((Disposable) get()).g();
        }

        public void m() {
            ((Disposable) getAndSet(SchedulerWhen.Y2)).m();
        }
    }

    static final class SubscribedDisposable implements Disposable {
        SubscribedDisposable() {
        }

        public boolean g() {
            return false;
        }

        public void m() {
        }
    }

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.X = scheduler;
        FlowableProcessor<Flowable<Completable>> n9 = UnicastProcessor.p9().n9();
        this.Y = n9;
        try {
            this.Z = function.apply(n9).W0();
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    @NonNull
    public Scheduler.Worker d() {
        Scheduler.Worker d2 = this.X.d();
        FlowableProcessor n9 = UnicastProcessor.p9().n9();
        Flowable c4 = n9.c4(new CreateWorkerFunction(d2));
        QueueWorker queueWorker = new QueueWorker(n9, d2);
        this.Y.onNext(c4);
        return queueWorker;
    }

    public boolean g() {
        return this.Z.g();
    }

    public void m() {
        this.Z.m();
    }
}
