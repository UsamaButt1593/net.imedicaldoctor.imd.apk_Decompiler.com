package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;
import java.util.Objects;

public final class SingleFlatMapIterableObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Iterable<? extends R>> X;
    final SingleSource<T> s;

    static final class FlatMapIterableObserver<T, R> extends BasicIntQueueDisposable<R> implements SingleObserver<T> {
        private static final long a3 = -8938804753851907758L;
        final Observer<? super R> X;
        volatile Iterator<? extends R> X2;
        final Function<? super T, ? extends Iterable<? extends R>> Y;
        volatile boolean Y2;
        Disposable Z;
        boolean Z2;

        FlatMapIterableObserver(Observer<? super R> observer, Function<? super T, ? extends Iterable<? extends R>> function) {
            this.X = observer;
            this.Y = function;
        }

        public void a(T t) {
            Observer<? super R> observer = this.X;
            try {
                Iterator<? extends R> it2 = ((Iterable) this.Y.apply(t)).iterator();
                if (!it2.hasNext()) {
                    observer.onComplete();
                } else if (this.Z2) {
                    this.X2 = it2;
                    observer.onNext(null);
                    observer.onComplete();
                } else {
                    while (!this.Y2) {
                        try {
                            observer.onNext(it2.next());
                            if (!this.Y2) {
                                if (!it2.hasNext()) {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            Exceptions.b(th);
                            observer.onError(th);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                Exceptions.b(th);
                observer = this.X;
                observer.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.X.b(this);
            }
        }

        public void clear() {
            this.X2 = null;
        }

        public boolean g() {
            return this.Y2;
        }

        public boolean isEmpty() {
            return this.X2 == null;
        }

        public void m() {
            this.Y2 = true;
            this.Z.m();
            this.Z = DisposableHelper.DISPOSED;
        }

        public void onError(Throwable th) {
            this.Z = DisposableHelper.DISPOSED;
            this.X.onError(th);
        }

        @Nullable
        public R poll() {
            Iterator<? extends R> it2 = this.X2;
            if (it2 == null) {
                return null;
            }
            R next = it2.next();
            Objects.requireNonNull(next, "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.X2 = null;
            }
            return next;
        }

        public int r(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.Z2 = true;
            return 2;
        }
    }

    public SingleFlatMapIterableObservable(SingleSource<T> singleSource, Function<? super T, ? extends Iterable<? extends R>> function) {
        this.s = singleSource;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.e(new FlatMapIterableObserver(observer, this.X));
    }
}
