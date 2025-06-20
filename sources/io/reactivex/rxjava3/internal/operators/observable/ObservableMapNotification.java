package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;

public final class ObservableMapNotification<T, R> extends AbstractObservableWithUpstream<T, ObservableSource<? extends R>> {
    final Function<? super T, ? extends ObservableSource<? extends R>> X;
    final Function<? super Throwable, ? extends ObservableSource<? extends R>> Y;
    final Supplier<? extends ObservableSource<? extends R>> Z;

    static final class MapNotificationObserver<T, R> implements Observer<T>, Disposable {
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        Disposable X2;
        final Function<? super Throwable, ? extends ObservableSource<? extends R>> Y;
        final Supplier<? extends ObservableSource<? extends R>> Z;
        final Observer<? super ObservableSource<? extends R>> s;

        MapNotificationObserver(Observer<? super ObservableSource<? extends R>> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
            this.s = observer;
            this.X = function;
            this.Y = function2;
            this.Z = supplier;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.X2.g();
        }

        public void m() {
            this.X2.m();
        }

        public void onComplete() {
            try {
                Object obj = this.Z.get();
                Objects.requireNonNull(obj, "The onComplete ObservableSource returned is null");
                this.s.onNext((ObservableSource) obj);
                this.s.onComplete();
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.Y.apply(th);
                Objects.requireNonNull(apply, "The onError ObservableSource returned is null");
                this.s.onNext((ObservableSource) apply);
                this.s.onComplete();
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }

        public void onNext(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The onNext ObservableSource returned is null");
                this.s.onNext((ObservableSource) apply);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }
    }

    public ObservableMapNotification(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, Function<? super Throwable, ? extends ObservableSource<? extends R>> function2, Supplier<? extends ObservableSource<? extends R>> supplier) {
        super(observableSource);
        this.X = function;
        this.Y = function2;
        this.Z = supplier;
    }

    public void g6(Observer<? super ObservableSource<? extends R>> observer) {
        this.s.a(new MapNotificationObserver(observer, this.X, this.Y, this.Z));
    }
}
