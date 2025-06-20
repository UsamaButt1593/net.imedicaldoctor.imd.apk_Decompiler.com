package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubscribeOn<T> extends AbstractMaybeWithUpstream<T, T> {
    final Scheduler X;

    static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y = 8571289934935992137L;
        final MaybeObserver<? super T> X;
        final SequentialDisposable s = new SequentialDisposable();

        SubscribeOnMaybeObserver(MaybeObserver<? super T> maybeObserver) {
            this.X = maybeObserver;
        }

        public void a(T t) {
            this.X.a(t);
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.s.m();
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }
    }

    static final class SubscribeTask<T> implements Runnable {
        final MaybeSource<T> X;
        final MaybeObserver<? super T> s;

        SubscribeTask(MaybeObserver<? super T> maybeObserver, MaybeSource<T> maybeSource) {
            this.s = maybeObserver;
            this.X = maybeSource;
        }

        public void run() {
            this.X.d(this.s);
        }
    }

    public MaybeSubscribeOn(MaybeSource<T> maybeSource, Scheduler scheduler) {
        super(maybeSource);
        this.X = scheduler;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        SubscribeOnMaybeObserver subscribeOnMaybeObserver = new SubscribeOnMaybeObserver(maybeObserver);
        maybeObserver.b(subscribeOnMaybeObserver);
        subscribeOnMaybeObserver.s.a(this.X.f(new SubscribeTask(subscribeOnMaybeObserver, this.s)));
    }
}
