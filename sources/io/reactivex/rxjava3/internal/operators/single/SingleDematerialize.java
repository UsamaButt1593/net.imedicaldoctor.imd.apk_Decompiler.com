package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class SingleDematerialize<T, R> extends Maybe<R> {
    final Function<? super T, Notification<R>> X;
    final Single<T> s;

    static final class DematerializeObserver<T, R> implements SingleObserver<T>, Disposable {
        final Function<? super T, Notification<R>> X;
        Disposable Y;
        final MaybeObserver<? super R> s;

        DematerializeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Notification<R>> function) {
            this.s = maybeObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Notification<R> apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The selector returned a null Notification");
                Notification notification = apply;
                if (notification.h()) {
                    this.s.a(notification.e());
                } else if (notification.f()) {
                    this.s.onComplete();
                } else {
                    this.s.onError(notification.d());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y, disposable)) {
                this.Y = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y.g();
        }

        public void m() {
            this.Y.m();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public SingleDematerialize(Single<T> single, Function<? super T, Notification<R>> function) {
        this.s = single;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.e(new DematerializeObserver(maybeObserver, this.X));
    }
}
