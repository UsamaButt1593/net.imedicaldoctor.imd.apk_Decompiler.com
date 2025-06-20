package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapNotification<T, R> extends Single<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> X;
    final Function<? super Throwable, ? extends SingleSource<? extends R>> Y;
    final SingleSource<T> s;

    static final class FlatMapSingleObserver<T, R> extends AtomicReference<Disposable> implements SingleObserver<T>, Disposable {
        private static final long X2 = 4375739915521278546L;
        final Function<? super T, ? extends SingleSource<? extends R>> X;
        final Function<? super Throwable, ? extends SingleSource<? extends R>> Y;
        Disposable Z;
        final SingleObserver<? super R> s;

        final class InnerObserver implements SingleObserver<R> {
            InnerObserver() {
            }

            public void a(R r) {
                FlatMapSingleObserver.this.s.a(r);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(FlatMapSingleObserver.this, disposable);
            }

            public void onError(Throwable th) {
                FlatMapSingleObserver.this.s.onError(th);
            }
        }

        FlatMapSingleObserver(SingleObserver<? super R> singleObserver, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
            this.s = singleObserver;
            this.X = function;
            this.Y = function2;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The onSuccessMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!g()) {
                    singleSource.e(new InnerObserver());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.Z.m();
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.Y.apply(th);
                Objects.requireNonNull(apply, "The onErrorMapper returned a null SingleSource");
                SingleSource singleSource = (SingleSource) apply;
                if (!g()) {
                    singleSource.e(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public SingleFlatMapNotification(SingleSource<T> singleSource, Function<? super T, ? extends SingleSource<? extends R>> function, Function<? super Throwable, ? extends SingleSource<? extends R>> function2) {
        this.s = singleSource;
        this.X = function;
        this.Y = function2;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super R> singleObserver) {
        this.s.e(new FlatMapSingleObserver(singleObserver, this.X, this.Y));
    }
}
