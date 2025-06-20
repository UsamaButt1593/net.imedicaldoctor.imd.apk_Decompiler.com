package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeEqualSingle<T> extends Single<Boolean> {
    final MaybeSource<? extends T> X;
    final BiPredicate<? super T, ? super T> Y;
    final MaybeSource<? extends T> s;

    static final class EqualCoordinator<T> extends AtomicInteger implements Disposable {
        final EqualObserver<T> X = new EqualObserver<>(this);
        final EqualObserver<T> Y = new EqualObserver<>(this);
        final BiPredicate<? super T, ? super T> Z;
        final SingleObserver<? super Boolean> s;

        EqualCoordinator(SingleObserver<? super Boolean> singleObserver, BiPredicate<? super T, ? super T> biPredicate) {
            super(2);
            this.s = singleObserver;
            this.Z = biPredicate;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (decrementAndGet() == 0) {
                Object obj = this.X.X;
                Object obj2 = this.Y.X;
                if (obj == null || obj2 == null) {
                    this.s.a(Boolean.valueOf(obj == null && obj2 == null));
                    return;
                }
                try {
                    this.s.a(Boolean.valueOf(this.Z.a(obj, obj2)));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.s.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(EqualObserver<T> equalObserver, Throwable th) {
            if (getAndSet(0) > 0) {
                EqualObserver<T> equalObserver2 = this.X;
                if (equalObserver == equalObserver2) {
                    this.Y.c();
                } else {
                    equalObserver2.c();
                }
                this.s.onError(th);
                return;
            }
            RxJavaPlugins.Y(th);
        }

        /* access modifiers changed from: package-private */
        public void c(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2) {
            maybeSource.d(this.X);
            maybeSource2.d(this.Y);
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) this.X.get());
        }

        public void m() {
            this.X.c();
            this.Y.c();
        }
    }

    static final class EqualObserver<T> extends AtomicReference<Disposable> implements MaybeObserver<T> {
        private static final long Y = -3031974433025990931L;
        Object X;
        final EqualCoordinator<T> s;

        EqualObserver(EqualCoordinator<T> equalCoordinator) {
            this.s = equalCoordinator;
        }

        public void a(T t) {
            this.X = t;
            this.s.a();
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this, disposable);
        }

        public void c() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            this.s.a();
        }

        public void onError(Throwable th) {
            this.s.b(this, th);
        }
    }

    public MaybeEqualSingle(MaybeSource<? extends T> maybeSource, MaybeSource<? extends T> maybeSource2, BiPredicate<? super T, ? super T> biPredicate) {
        this.s = maybeSource;
        this.X = maybeSource2;
        this.Y = biPredicate;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Boolean> singleObserver) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(singleObserver, this.Y);
        singleObserver.b(equalCoordinator);
        equalCoordinator.c(this.s, this.X);
    }
}
