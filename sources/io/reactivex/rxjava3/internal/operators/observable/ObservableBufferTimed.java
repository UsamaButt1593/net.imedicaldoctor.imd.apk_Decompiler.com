package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.observers.QueueDrainObserver;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import io.reactivex.rxjava3.observers.SerializedObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableBufferTimed<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final long X;
    final Scheduler X2;
    final long Y;
    final Supplier<U> Y2;
    final TimeUnit Z;
    final int Z2;
    final boolean a3;

    static final class BufferExactBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Supplier<U> D3;
        final long E3;
        final TimeUnit F3;
        final int G3;
        final boolean H3;
        final Scheduler.Worker I3;
        U J3;
        Disposable K3;
        Disposable L3;
        long M3;
        long N3;

        BufferExactBoundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j2, TimeUnit timeUnit, int i2, boolean z, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.D3 = supplier;
            this.E3 = j2;
            this.F3 = timeUnit;
            this.G3 = i2;
            this.H3 = z;
            this.I3 = worker;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.L3, disposable)) {
                this.L3 = disposable;
                try {
                    U u = this.D3.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.J3 = (Collection) u;
                    this.y3.b(this);
                    Scheduler.Worker worker = this.I3;
                    long j2 = this.E3;
                    this.K3 = worker.d(this, j2, j2, this.F3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.m();
                    EmptyDisposable.h(th, this.y3);
                    this.I3.m();
                }
            }
        }

        public boolean g() {
            return this.A3;
        }

        /* renamed from: k */
        public void j(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void m() {
            if (!this.A3) {
                this.A3 = true;
                this.L3.m();
                this.I3.m();
                synchronized (this) {
                    this.J3 = null;
                }
            }
        }

        public void onComplete() {
            U u;
            this.I3.m();
            synchronized (this) {
                u = this.J3;
                this.J3 = null;
            }
            if (u != null) {
                this.z3.offer(u);
                this.B3 = true;
                if (a()) {
                    QueueDrainHelper.d(this.z3, this.y3, false, this, this);
                }
            }
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.J3 = null;
            }
            this.y3.onError(th);
            this.I3.m();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            if (r7.H3 == false) goto L_0x002a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0025, code lost:
            r7.K3.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            h(r0, false, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8 = r7.D3.get();
            java.util.Objects.requireNonNull(r8, "The buffer supplied is null");
            r8 = (java.util.Collection) r8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003b, code lost:
            monitor-enter(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.J3 = r8;
            r7.N3++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0043, code lost:
            monitor-exit(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0046, code lost:
            if (r7.H3 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
            r0 = r7.I3;
            r4 = r7.E3;
            r7.K3 = r0.d(r7, r4, r4, r7.F3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x005a, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x005b, code lost:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r8);
            r7.y3.onError(r8);
            m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                U r0 = r7.J3     // Catch:{ all -> 0x0007 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0007:
                r8 = move-exception
                goto L_0x0067
            L_0x0009:
                r0.add(r8)     // Catch:{ all -> 0x0007 }
                int r8 = r0.size()     // Catch:{ all -> 0x0007 }
                int r1 = r7.G3     // Catch:{ all -> 0x0007 }
                if (r8 >= r1) goto L_0x0016
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                return
            L_0x0016:
                r8 = 0
                r7.J3 = r8     // Catch:{ all -> 0x0007 }
                long r1 = r7.M3     // Catch:{ all -> 0x0007 }
                r3 = 1
                long r1 = r1 + r3
                r7.M3 = r1     // Catch:{ all -> 0x0007 }
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                boolean r8 = r7.H3
                if (r8 == 0) goto L_0x002a
                io.reactivex.rxjava3.disposables.Disposable r8 = r7.K3
                r8.m()
            L_0x002a:
                r8 = 0
                r7.h(r0, r8, r7)
                io.reactivex.rxjava3.functions.Supplier<U> r8 = r7.D3     // Catch:{ all -> 0x005a }
                java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x005a }
                java.lang.String r0 = "The buffer supplied is null"
                java.util.Objects.requireNonNull(r8, r0)     // Catch:{ all -> 0x005a }
                java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x005a }
                monitor-enter(r7)
                r7.J3 = r8     // Catch:{ all -> 0x0057 }
                long r0 = r7.N3     // Catch:{ all -> 0x0057 }
                long r0 = r0 + r3
                r7.N3 = r0     // Catch:{ all -> 0x0057 }
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                boolean r8 = r7.H3
                if (r8 == 0) goto L_0x0056
                io.reactivex.rxjava3.core.Scheduler$Worker r0 = r7.I3
                long r4 = r7.E3
                java.util.concurrent.TimeUnit r6 = r7.F3
                r1 = r7
                r2 = r4
                io.reactivex.rxjava3.disposables.Disposable r8 = r0.d(r1, r2, r4, r6)
                r7.K3 = r8
            L_0x0056:
                return
            L_0x0057:
                r8 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x0057 }
                throw r8
            L_0x005a:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r8)
                io.reactivex.rxjava3.core.Observer<? super V> r0 = r7.y3
                r0.onError(r8)
                r7.m()
                return
            L_0x0067:
                monitor-exit(r7)     // Catch:{ all -> 0x0007 }
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableBufferTimed.BufferExactBoundedObserver.onNext(java.lang.Object):void");
        }

        public void run() {
            try {
                U u = this.D3.get();
                Objects.requireNonNull(u, "The bufferSupplier returned a null buffer");
                U u2 = (Collection) u;
                synchronized (this) {
                    U u3 = this.J3;
                    if (u3 != null) {
                        if (this.M3 == this.N3) {
                            this.J3 = u2;
                            h(u3, false, this);
                        }
                    }
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                m();
                this.y3.onError(th);
            }
        }
    }

    static final class BufferExactUnboundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Supplier<U> D3;
        final long E3;
        final TimeUnit F3;
        final Scheduler G3;
        Disposable H3;
        U I3;
        final AtomicReference<Disposable> J3 = new AtomicReference<>();

        BufferExactUnboundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            super(observer, new MpscLinkedQueue());
            this.D3 = supplier;
            this.E3 = j2;
            this.F3 = timeUnit;
            this.G3 = scheduler;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.H3, disposable)) {
                this.H3 = disposable;
                try {
                    U u = this.D3.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    this.I3 = (Collection) u;
                    this.y3.b(this);
                    if (!DisposableHelper.b(this.J3.get())) {
                        Scheduler scheduler = this.G3;
                        long j2 = this.E3;
                        DisposableHelper.f(this.J3, scheduler.i(this, j2, j2, this.F3));
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    m();
                    EmptyDisposable.h(th, this.y3);
                }
            }
        }

        public boolean g() {
            return this.J3.get() == DisposableHelper.DISPOSED;
        }

        /* renamed from: k */
        public void j(Observer<? super U> observer, U u) {
            this.y3.onNext(u);
        }

        public void m() {
            DisposableHelper.a(this.J3);
            this.H3.m();
        }

        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.I3;
                this.I3 = null;
            }
            if (u != null) {
                this.z3.offer(u);
                this.B3 = true;
                if (a()) {
                    QueueDrainHelper.d(this.z3, this.y3, false, (Disposable) null, this);
                }
            }
            DisposableHelper.a(this.J3);
        }

        public void onError(Throwable th) {
            synchronized (this) {
                this.I3 = null;
            }
            this.y3.onError(th);
            DisposableHelper.a(this.J3);
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    U u = this.I3;
                    if (u != null) {
                        u.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void run() {
            U u;
            try {
                U u2 = this.D3.get();
                Objects.requireNonNull(u2, "The bufferSupplier returned a null buffer");
                U u3 = (Collection) u2;
                synchronized (this) {
                    try {
                        u = this.I3;
                        if (u != null) {
                            this.I3 = u3;
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                if (u == null) {
                    DisposableHelper.a(this.J3);
                } else {
                    e(u, false, this);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.y3.onError(th2);
                m();
            }
        }
    }

    static final class BufferSkipBoundedObserver<T, U extends Collection<? super T>> extends QueueDrainObserver<T, U, U> implements Runnable, Disposable {
        final Supplier<U> D3;
        final long E3;
        final long F3;
        final TimeUnit G3;
        final Scheduler.Worker H3;
        final List<U> I3 = new LinkedList();
        Disposable J3;

        final class RemoveFromBuffer implements Runnable {
            private final U s;

            RemoveFromBuffer(U u) {
                this.s = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.I3.remove(this.s);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.h(this.s, false, bufferSkipBoundedObserver.H3);
            }
        }

        final class RemoveFromBufferEmit implements Runnable {
            private final U s;

            RemoveFromBufferEmit(U u) {
                this.s = u;
            }

            public void run() {
                synchronized (BufferSkipBoundedObserver.this) {
                    BufferSkipBoundedObserver.this.I3.remove(this.s);
                }
                BufferSkipBoundedObserver bufferSkipBoundedObserver = BufferSkipBoundedObserver.this;
                bufferSkipBoundedObserver.h(this.s, false, bufferSkipBoundedObserver.H3);
            }
        }

        BufferSkipBoundedObserver(Observer<? super U> observer, Supplier<U> supplier, long j2, long j3, TimeUnit timeUnit, Scheduler.Worker worker) {
            super(observer, new MpscLinkedQueue());
            this.D3 = supplier;
            this.E3 = j2;
            this.F3 = j3;
            this.G3 = timeUnit;
            this.H3 = worker;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.J3, disposable)) {
                this.J3 = disposable;
                try {
                    U u = this.D3.get();
                    Objects.requireNonNull(u, "The buffer supplied is null");
                    Collection collection = (Collection) u;
                    this.I3.add(collection);
                    this.y3.b(this);
                    Scheduler.Worker worker = this.H3;
                    long j2 = this.F3;
                    worker.d(this, j2, j2, this.G3);
                    this.H3.c(new RemoveFromBufferEmit(collection), this.E3, this.G3);
                } catch (Throwable th) {
                    Exceptions.b(th);
                    disposable.m();
                    EmptyDisposable.h(th, this.y3);
                    this.H3.m();
                }
            }
        }

        public boolean g() {
            return this.A3;
        }

        /* renamed from: k */
        public void j(Observer<? super U> observer, U u) {
            observer.onNext(u);
        }

        public void m() {
            if (!this.A3) {
                this.A3 = true;
                o();
                this.J3.m();
                this.H3.m();
            }
        }

        /* access modifiers changed from: package-private */
        public void o() {
            synchronized (this) {
                this.I3.clear();
            }
        }

        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(this.I3);
                this.I3.clear();
            }
            for (Collection offer : arrayList) {
                this.z3.offer(offer);
            }
            this.B3 = true;
            if (a()) {
                QueueDrainHelper.d(this.z3, this.y3, false, this.H3, this);
            }
        }

        public void onError(Throwable th) {
            this.B3 = true;
            o();
            this.y3.onError(th);
            this.H3.m();
        }

        public void onNext(T t) {
            synchronized (this) {
                try {
                    for (U add : this.I3) {
                        add.add(t);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void run() {
            if (!this.A3) {
                try {
                    U u = this.D3.get();
                    Objects.requireNonNull(u, "The bufferSupplier returned a null buffer");
                    Collection collection = (Collection) u;
                    synchronized (this) {
                        try {
                            if (!this.A3) {
                                this.I3.add(collection);
                                this.H3.c(new RemoveFromBuffer(collection), this.E3, this.G3);
                            }
                        } catch (Throwable th) {
                            while (true) {
                                throw th;
                            }
                        }
                    }
                } catch (Throwable th2) {
                    Exceptions.b(th2);
                    this.y3.onError(th2);
                    m();
                }
            }
        }
    }

    public ObservableBufferTimed(ObservableSource<T> observableSource, long j2, long j3, TimeUnit timeUnit, Scheduler scheduler, Supplier<U> supplier, int i2, boolean z) {
        super(observableSource);
        this.X = j2;
        this.Y = j3;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = supplier;
        this.Z2 = i2;
        this.a3 = z;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super U> observer) {
        if (this.X == this.Y && this.Z2 == Integer.MAX_VALUE) {
            this.s.a(new BufferExactUnboundedObserver(new SerializedObserver(observer), this.Y2, this.X, this.Z, this.X2));
            return;
        }
        Scheduler.Worker d2 = this.X2.d();
        int i2 = (this.X > this.Y ? 1 : (this.X == this.Y ? 0 : -1));
        ObservableSource<T> observableSource = this.s;
        if (i2 == 0) {
            observableSource.a(new BufferExactBoundedObserver(new SerializedObserver(observer), this.Y2, this.X, this.Z, this.Z2, this.a3, d2));
        } else {
            observableSource.a(new BufferSkipBoundedObserver(new SerializedObserver(observer), this.Y2, this.X, this.Y, this.Z, d2));
        }
    }
}
