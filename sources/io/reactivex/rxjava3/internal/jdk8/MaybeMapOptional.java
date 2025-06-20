package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.Objects;
import java.util.Optional;

public final class MaybeMapOptional<T, R> extends Maybe<R> {
    final Function<? super T, Optional<? extends R>> X;
    final Maybe<T> s;

    static final class MapOptionalMaybeObserver<T, R> implements MaybeObserver<T>, Disposable {
        final Function<? super T, Optional<? extends R>> X;
        Disposable Y;
        final MaybeObserver<? super R> s;

        MapOptionalMaybeObserver(MaybeObserver<? super R> maybeObserver, Function<? super T, Optional<? extends R>> function) {
            this.s = maybeObserver;
            this.X = function;
        }

        public void a(T t) {
            try {
                Optional<? extends R> apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The mapper returned a null item");
                Optional a2 = k.a(apply);
                if (a2.isPresent()) {
                    this.s.a(a2.get());
                } else {
                    this.s.onComplete();
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
            Disposable disposable = this.Y;
            this.Y = DisposableHelper.DISPOSED;
            disposable.m();
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }
    }

    public MaybeMapOptional(Maybe<T> maybe, Function<? super T, Optional<? extends R>> function) {
        this.s = maybe;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super R> maybeObserver) {
        this.s.d(new MapOptionalMaybeObserver(maybeObserver, this.X));
    }
}
