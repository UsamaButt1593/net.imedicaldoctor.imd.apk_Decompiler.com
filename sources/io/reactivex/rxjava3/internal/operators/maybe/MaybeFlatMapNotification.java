package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapNotification<T, R> extends AbstractMaybeWithUpstream<T, R> {
    final Function<? super T, ? extends MaybeSource<? extends R>> X;
    final Function<? super Throwable, ? extends MaybeSource<? extends R>> Y;
    final Supplier<? extends MaybeSource<? extends R>> Z;

    static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements MaybeObserver<T>, Disposable {
        private static final long Y2 = 4375739915521278546L;
        final Function<? super T, ? extends MaybeSource<? extends R>> X;
        Disposable X2;
        final Function<? super Throwable, ? extends MaybeSource<? extends R>> Y;
        final Supplier<? extends MaybeSource<? extends R>> Z;
        final MaybeObserver<? super R> s;

        final class InnerObserver implements MaybeObserver<R> {
            InnerObserver() {
            }

            public void a(R r) {
                FlatMapMaybeObserver.this.s.a(r);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(FlatMapMaybeObserver.this, disposable);
            }

            public void onComplete() {
                FlatMapMaybeObserver.this.s.onComplete();
            }

            public void onError(Throwable th) {
                FlatMapMaybeObserver.this.s.onError(th);
            }
        }

        FlatMapMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
            this.s = maybeObserver;
            this.X = function;
            this.Y = function2;
            this.Z = supplier;
        }

        public void a(T t) {
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The onSuccessMapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!g()) {
                    maybeSource.d(new InnerObserver());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.X2, disposable)) {
                this.X2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void m() {
            DisposableHelper.a(this);
            this.X2.m();
        }

        public void onComplete() {
            try {
                Object obj = this.Z.get();
                Objects.requireNonNull(obj, "The onCompleteSupplier returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) obj;
                if (!g()) {
                    maybeSource.d(new InnerObserver());
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                this.s.onError(th);
            }
        }

        public void onError(Throwable th) {
            try {
                Object apply = this.Y.apply(th);
                Objects.requireNonNull(apply, "The onErrorMapper returned a null MaybeSource");
                MaybeSource maybeSource = (MaybeSource) apply;
                if (!g()) {
                    maybeSource.d(new InnerObserver());
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.s.onError(new CompositeException(th, th2));
            }
        }
    }

    public MaybeFlatMapNotification(MaybeSource<T> maybeSource, Function<? super T, ? extends MaybeSource<? extends R>> function, Function<? super Throwable, ? extends MaybeSource<? extends R>> function2, Supplier<? extends MaybeSource<? extends R>> supplier) {
        super(maybeSource);
        this.X = function;
        this.Y = function2;
        this.Z = supplier;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.d(new FlatMapMaybeObserver(maybeObserver, this.X, this.Y, this.Z));
    }
}
