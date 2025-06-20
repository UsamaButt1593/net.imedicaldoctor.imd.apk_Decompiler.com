package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.Collection;
import java.util.Objects;

public final class ObservableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractObservableWithUpstream<T, U> {
    final ObservableSource<B> X;
    final Supplier<U> Y;

    static final class BufferBoundaryObserver<T, U extends Collection<? super T>, B> extends DisposableObserver<B> {
        final BufferExactBoundaryObserver<T, U, B> X;

        BufferBoundaryObserver(BufferExactBoundaryObserver<T, U, B> bufferExactBoundaryObserver) {
            this.X = bufferExactBoundaryObserver;
        }

        public void onComplete() {
            this.X.onComplete();
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }

        public void onNext(B b2) {
            this.X.l();
        }
    }

    static final class BufferExactBoundaryObserver<T, U extends Collection<? super T>, B> extends QueueDrainObserver<T, U, U> implements Observer<T>, Disposable {
        final Supplier<U> D3;
        final ObservableSource<B> E3;
        Disposable F3;
        Disposable G3;
        U H3;

        BufferExactBoundaryObserver(Observer<? super U> observer, Supplier<U> supplier, ObservableSource<B> observableSource) {
            super(observer, new MpscLinkedQueue());
            this.D3 = supplier;
            this.E3 = observableSource;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.F3, disposable)) {
                this.F3 = disposable;
                try {
                    U u = this.D3.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.H3 = (Collection) u;
                    BufferBoundaryObserver bufferBoundaryObserver = new BufferBoundaryObserver(this);
                    this.G3 = bufferBoundaryObserver;
                    this.y3.b(this);
                    if (!this.A3) {
                        this.E3.a(bufferBoundaryObserver);
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.A3 = true;
                    disposable.m();
                    EmptyDisposable.h(th, this.y3);
                }
            }
        }

        public boolean g() {
            return this.A3;
        }

        /* renamed from: k */
        public void j(Observer<? super U> observer, U u) {
            this.y3.onNext(u);
        }

        /* access modifiers changed from: package-private */
        public void l() {
            try {
                U u = this.D3.get();
                Objects.requireNonNull(u, "The buffer supplied is null");
                U u2 = (Collection) u;
                synchronized (this) {
                    try {
                        U u3 = this.H3;
                        if (u3 != null) {
                            this.H3 = u2;
                            e(u3, false, this);
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                m();
                this.y3.onError(th2);
            }
        }

        public void m() {
            if (!this.A3) {
                this.A3 = true;
                this.G3.m();
                this.F3.m();
                if (a()) {
                    this.z3.clear();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x000d, code lost:
            r3.z3.offer(r0);
            r3.B3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (a() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            io.reactivex.rxjava3.internal.util.QueueDrainHelper.d(r3.z3, r3.y3, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onComplete() {
            /*
                r3 = this;
                monitor-enter(r3)
                U r0 = r3.H3     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r0 = move-exception
                goto L_0x0024
            L_0x0009:
                r1 = 0
                r3.H3 = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r1 = r3.z3
                r1.offer(r0)
                r0 = 1
                r3.B3 = r0
                boolean r0 = r3.a()
                if (r0 == 0) goto L_0x0023
                io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue<U> r0 = r3.z3
                io.reactivex.rxjava3.core.Observer<? super V> r1 = r3.y3
                r2 = 0
                io.reactivex.rxjava3.internal.util.QueueDrainHelper.d(r0, r1, r2, r3, r3)
            L_0x0023:
                return
            L_0x0024:
                monitor-exit(r3)     // Catch:{ all -> 0x0007 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferExactBoundary.BufferExactBoundaryObserver.onComplete():void");
        }

        public void onError(Throwable th) {
            m();
            this.y3.onError(th);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    U u = this.H3;
                    if (u != null) {
                        u.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ObservableBufferExactBoundary(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Supplier<U> supplier) {
        super(observableSource);
        this.X = observableSource2;
        this.Y = supplier;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super U> observer) {
        this.s.a(new BufferExactBoundaryObserver(new SerializedObserver(observer), this.Y, this.X));
    }
}
