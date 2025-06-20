package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class MaybeFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> X;
    final MaybeSource<T> s;

    static final class FlatMapIterableObserver<T, R> extends BasicQueueDisposable<R> implements MaybeObserver<T> {
        final Function<? super T, ? extends Iterable<? extends R>> X;
        volatile boolean X2;
        Disposable Y;
        boolean Y2;
        volatile Iterator<? extends R> Z;
        final Observer<? super R> s;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.s = observer;
            this.X = function;
        }

        public void a(T t) {
            Observer<? super R> observer = this.s;
            try {
                Iterator<? extends R> it2 = ((Iterable) this.X.apply(t)).iterator();
                if (!it2.hasNext()) {
                    observer.onComplete();
                    return;
                }
                this.Z = it2;
                if (this.Y2) {
                    observer.onNext(null);
                    observer.onComplete();
                    return;
                }
                while (!this.X2) {
                    try {
                        observer.onNext(it2.next());
                        if (!this.X2) {
                            try {
                                if (!it2.hasNext()) {
                                    observer.onComplete();
                                    return;
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                observer.onError(th);
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        observer.onError(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                Exceptions.b(th3);
                observer.onError(th3);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public void clear() {
            this.Z = null;
        }

        public boolean g() {
            return this.X2;
        }

        public boolean isEmpty() {
            return this.Z == null;
        }

        public void m() {
            this.X2 = true;
            this.Y.m();
            this.Y = DisposableHelper.DISPOSED;
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.Y = DisposableHelper.DISPOSED;
            this.s.onError(th);
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it2 = this.Z;
            if (it2 == null) {
                return null;
            }
            R next = it2.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.Z = null;
            }
            return next;
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.Y2 = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableObservable(MaybeSource<T> maybeSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.s = maybeSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.d(new FlatMapIterableObserver(observer, this.X));
    }
}
