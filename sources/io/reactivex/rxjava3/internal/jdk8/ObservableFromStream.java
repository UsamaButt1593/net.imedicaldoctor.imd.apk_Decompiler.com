package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public final class ObservableFromStream<T> extends Observable<T> {
    final Stream<T> s;

    static final class StreamDisposable<T> implements QueueDisposable<T> {
        Iterator<T> X;
        boolean X2;
        AutoCloseable Y;
        boolean Y2;
        volatile boolean Z;
        final Observer<? super T> s;

        StreamDisposable(Observer<? super T> observer, Iterator<T> it2, AutoCloseable autoCloseable) {
            this.s = observer;
            this.X = it2;
            this.Y = autoCloseable;
        }

        public void a() {
            if (!this.Y2) {
                Iterator<T> it2 = this.X;
                Observer<? super T> observer = this.s;
                while (!this.Z) {
                    try {
                        T next = it2.next();
                        Objects.requireNonNull(next, "The Stream's Iterator.next returned a null value");
                        if (!this.Z) {
                            observer.onNext(next);
                            if (!this.Z) {
                                if (!it2.hasNext()) {
                                    observer.onComplete();
                                    this.Z = true;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        Exceptions.b(th);
                        observer.onError(th);
                    }
                }
                clear();
            }
        }

        public void clear() {
            this.X = null;
            AutoCloseable autoCloseable = this.Y;
            this.Y = null;
            if (autoCloseable != null) {
                ObservableFromStream.D8(autoCloseable);
            }
        }

        public boolean g() {
            return this.Z;
        }

        public boolean isEmpty() {
            Iterator<T> it2 = this.X;
            if (it2 == null) {
                return true;
            }
            if (!this.X2 || it2.hasNext()) {
                return false;
            }
            clear();
            return true;
        }

        public void m() {
            this.Z = true;
            a();
        }

        public boolean offer(@NonNull T t) {
            throw new UnsupportedOperationException();
        }

        @Nullable
        public T poll() {
            Iterator<T> it2 = this.X;
            if (it2 == null) {
                return null;
            }
            if (!this.X2) {
                this.X2 = true;
            } else if (!it2.hasNext()) {
                clear();
                return null;
            }
            T next = this.X.next();
            Objects.requireNonNull(next, "The Stream's Iterator.next() returned a null value");
            return next;
        }

        public boolean q(@NonNull T t, @NonNull T t2) {
            throw new UnsupportedOperationException();
        }

        public int r(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.Y2 = true;
            return 1;
        }
    }

    public ObservableFromStream(Stream<T> stream) {
        this.s = stream;
    }

    static void D8(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            Exceptions.b(th);
            RxJavaPlugins.Y(th);
        }
    }

    public static <T> void E8(Observer<? super T> observer, Stream<T> stream) {
        try {
            Iterator a2 = stream.iterator();
            if (!a2.hasNext()) {
                EmptyDisposable.c(observer);
                D8(stream);
                return;
            }
            StreamDisposable streamDisposable = new StreamDisposable(observer, a2, stream);
            observer.b(streamDisposable);
            streamDisposable.a();
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.h(th, observer);
            D8(stream);
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        E8(observer, this.s);
    }
}
