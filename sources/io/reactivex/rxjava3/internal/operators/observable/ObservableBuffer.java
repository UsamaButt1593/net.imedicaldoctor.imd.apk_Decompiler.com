package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final int X;
    final int Y;
    final Supplier<U> Z;

    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final int X;
        int X2;
        final Supplier<U> Y;
        Disposable Y2;
        U Z;
        final Observer<? super U> s;

        BufferExactObserver(Observer<? super U> observer, int i2, Supplier<U> supplier) {
            this.s = observer;
            this.X = i2;
            this.Y = supplier;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            try {
                U u = this.Y.get();
                Objects.requireNonNull(u, "Empty buffer supplied");
                this.Z = (Collection) u;
                return true;
            } catch (Throwable th) {
                Exceptions.b(th);
                this.Z = null;
                Disposable disposable = this.Y2;
                if (disposable == null) {
                    EmptyDisposable.h(th, this.s);
                    return false;
                }
                disposable.m();
                this.s.onError(th);
                return false;
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.Y2.g();
        }

        public void m() {
            this.Y2.m();
        }

        public void onComplete() {
            U u = this.Z;
            if (u != null) {
                this.Z = null;
                if (!u.isEmpty()) {
                    this.s.onNext(u);
                }
                this.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            this.Z = null;
            this.s.onError(th);
        }

        public void onNext(T t) {
            U u = this.Z;
            if (u != null) {
                u.add(t);
                int i2 = this.X2 + 1;
                this.X2 = i2;
                if (i2 >= this.X) {
                    this.s.onNext(u);
                    this.X2 = 0;
                    a();
                }
            }
        }
    }

    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long a3 = -8223395059921494546L;
        final int X;
        Disposable X2;
        final int Y;
        final ArrayDeque<U> Y2 = new ArrayDeque<>();
        final Supplier<U> Z;
        long Z2;
        final Observer<? super U> s;

        BufferSkipObserver(Observer<? super U> observer, int i2, int i3, Supplier<U> supplier) {
            this.s = observer;
            this.X = i2;
            this.Y = i3;
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
            while (!this.Y2.isEmpty()) {
                this.s.onNext(this.Y2.poll());
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.Y2.clear();
            this.s.onError(th);
        }

        public void onNext(T t) {
            long j2 = this.Z2;
            this.Z2 = 1 + j2;
            if (j2 % ((long) this.Y) == 0) {
                try {
                    this.Y2.offer((Collection) ExceptionHelper.d(this.Z.get(), "The bufferSupplier returned a null Collection."));
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Y2.clear();
                    this.X2.m();
                    this.s.onError(th);
                    return;
                }
            }
            Iterator<U> it2 = this.Y2.iterator();
            while (it2.hasNext()) {
                Collection collection = (Collection) it2.next();
                collection.add(t);
                if (this.X <= collection.size()) {
                    it2.remove();
                    this.s.onNext(collection);
                }
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i2, int i3, Supplier<U> supplier) {
        super(observableSource);
        this.X = i2;
        this.Y = i3;
        this.Z = supplier;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super U> observer) {
        int i2 = this.Y;
        int i3 = this.X;
        if (i2 == i3) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i3, this.Z);
            if (bufferExactObserver.a()) {
                this.s.a(bufferExactObserver);
                return;
            }
            return;
        }
        this.s.a(new BufferSkipObserver(observer, this.X, this.Y, this.Z));
    }
}
