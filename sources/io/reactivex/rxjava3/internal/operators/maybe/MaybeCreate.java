package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCreate<T> extends Maybe<T> {
    final MaybeOnSubscribe<T> s;

    static final class Emitter<T> extends AtomicReference<Disposable> implements MaybeEmitter<T>, Disposable {
        private static final long X = -2467358622224974244L;
        final MaybeObserver<? super T> s;

        Emitter(MaybeObserver<? super T> maybeObserver) {
            this.s = maybeObserver;
        }

        public void a(T t) {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                if (t == null) {
                    try {
                        this.s.onError(ExceptionHelper.b("onSuccess called with a null value."));
                    } finally {
                        if (disposable != null) {
                            disposable.m();
                        }
                    }
                } else {
                    this.s.a(t);
                }
            }
        }

        public void b(Disposable disposable) {
            DisposableHelper.f(this, disposable);
        }

        public boolean c(Throwable th) {
            Disposable disposable;
            if (th == null) {
                th = ExceptionHelper.b("onError called with a null Throwable.");
            }
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj == disposableHelper || (disposable = (Disposable) getAndSet(disposableHelper)) == disposableHelper) {
                return false;
            }
            try {
                this.s.onError(th);
            } finally {
                if (disposable != null) {
                    disposable.m();
                }
            }
        }

        public boolean g() {
            return DisposableHelper.b((Disposable) get());
        }

        public void h(Cancellable cancellable) {
            b(new CancellableDisposable(cancellable));
        }

        public void m() {
            DisposableHelper.a(this);
        }

        public void onComplete() {
            Disposable disposable;
            Object obj = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (obj != disposableHelper && (disposable = (Disposable) getAndSet(disposableHelper)) != disposableHelper) {
                try {
                    this.s.onComplete();
                } finally {
                    if (disposable != null) {
                        disposable.m();
                    }
                }
            }
        }

        public void onError(Throwable th) {
            if (!c(th)) {
                RxJavaPlugins.Y(th);
            }
        }

        public String toString() {
            return String.format("%s{%s}", new Object[]{Emitter.class.getSimpleName(), super.toString()});
        }
    }

    public MaybeCreate(MaybeOnSubscribe<T> maybeOnSubscribe) {
        this.s = maybeOnSubscribe;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        Emitter emitter = new Emitter(maybeObserver);
        maybeObserver.b(emitter);
        try {
            this.s.a(emitter);
        } catch (Throwable th) {
            Exceptions.b(th);
            emitter.onError(th);
        }
    }
}
