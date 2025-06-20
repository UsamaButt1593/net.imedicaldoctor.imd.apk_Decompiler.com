package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class ObservableDematerialize<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends Notification<R>> X;

    static final class DematerializeObserver<T, R> implements Observer<T>, Disposable {
        final Function<? super T, ? extends Notification<R>> X;
        boolean Y;
        Disposable Z;
        final Observer<? super R> s;

        DematerializeObserver(Observer<? super R> observer, Function<? super T, ? extends Notification<R>> function) {
            this.s = observer;
            this.X = function;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z, disposable)) {
                this.Z = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Z.g();
        }

        public void m() {
            this.Z.m();
        }

        public void onComplete() {
            if (!this.Y) {
                this.Y = true;
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            if (this.Y) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.Y = true;
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.Y) {
                try {
                    Object apply = this.X.apply(t);
                    Objects.requireNonNull(apply, "The selector returned a null Notification");
                    Notification notification = (Notification) apply;
                    if (notification.g()) {
                        this.Z.m();
                        onError(notification.d());
                    } else if (notification.f()) {
                        this.Z.m();
                        onComplete();
                    } else {
                        this.s.onNext(notification.e());
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z.m();
                    onError(th);
                }
            } else if (t instanceof Notification) {
                Notification notification2 = (Notification) t;
                if (notification2.g()) {
                    RxJavaPlugins.Y(notification2.d());
                }
            }
        }
    }

    public ObservableDematerialize(ObservableSource<T> observableSource, Function<? super T, ? extends Notification<R>> function) {
        super(observableSource);
        this.X = function;
    }

    public void g6(Observer<? super R> observer) {
        this.s.a(new DematerializeObserver(observer, this.X));
    }
}
