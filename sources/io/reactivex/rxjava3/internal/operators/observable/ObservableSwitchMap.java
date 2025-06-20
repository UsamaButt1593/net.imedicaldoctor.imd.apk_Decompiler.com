package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSwitchMap<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> X;
    final int Y;
    final boolean Z;

    static final class SwitchMapInnerObserver<T, R> extends AtomicReference<Disposable> implements Observer<R> {
        private static final long Y2 = 3837284832786408377L;
        final long X;
        volatile boolean X2;
        final int Y;
        volatile SimpleQueue<R> Z;
        final SwitchMapObserver<T, R> s;

        SwitchMapInnerObserver(SwitchMapObserver<T, R> switchMapObserver, long j2, int i2) {
            this.s = switchMapObserver;
            this.X = j2;
            this.Y = i2;
        }

        public void a() {
            DisposableHelper.a(this);
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(7);
                    if (r == 1) {
                        this.Z = queueDisposable;
                        this.X2 = true;
                        this.s.c();
                        return;
                    } else if (r == 2) {
                        this.Z = queueDisposable;
                        return;
                    }
                }
                this.Z = new SpscLinkedArrayQueue(this.Y);
            }
        }

        public void onComplete() {
            if (this.X == this.s.c3) {
                this.X2 = true;
                this.s.c();
            }
        }

        public void onError(Throwable th) {
            this.s.d(this, th);
        }

        public void onNext(R r) {
            if (this.X == this.s.c3) {
                if (r != null) {
                    this.Z.offer(r);
                }
                this.s.c();
            }
        }
    }

    static final class SwitchMapObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long d3 = -3491074160481096299L;
        static final SwitchMapInnerObserver<Object, Object> e3;
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final AtomicThrowable X2;
        final int Y;
        volatile boolean Y2;
        final boolean Z;
        volatile boolean Z2;
        Disposable a3;
        final AtomicReference<SwitchMapInnerObserver<T, R>> b3 = new AtomicReference<>();
        volatile long c3;
        final Observer<? super R> s;

        static {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver = new SwitchMapInnerObserver<>((SwitchMapObserver) null, -1, 1);
            e3 = switchMapInnerObserver;
            switchMapInnerObserver.a();
        }

        SwitchMapObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = i2;
            this.Z = z;
            this.X2 = new AtomicThrowable();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            SwitchMapInnerObserver andSet = this.b3.getAndSet(e3);
            if (andSet != null) {
                andSet.a();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.a3, disposable)) {
                this.a3 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.rxjava3.core.Observer<? super R> r0 = r13.s
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver<T, R>> r1 = r13.b3
                boolean r2 = r13.Z
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r13.Z2
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.Y2
                r6 = 0
                if (r5 == 0) goto L_0x004e
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x004e
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.X2
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                goto L_0x0037
            L_0x0034:
                r0.onComplete()
            L_0x0037:
                return
            L_0x0038:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r7 = r13.X2
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x0048
            L_0x0042:
                io.reactivex.rxjava3.internal.util.AtomicThrowable r1 = r13.X2
                r1.i(r0)
                return
            L_0x0048:
                if (r5 == 0) goto L_0x004e
                r0.onComplete()
                return
            L_0x004e:
                java.lang.Object r5 = r1.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap$SwitchMapInnerObserver r5 = (io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.SwitchMapInnerObserver) r5
                if (r5 == 0) goto L_0x00b2
                io.reactivex.rxjava3.internal.fuseable.SimpleQueue<R> r7 = r5.Z
                if (r7 == 0) goto L_0x00b2
                r8 = 0
            L_0x005b:
                boolean r9 = r13.Z2
                if (r9 == 0) goto L_0x0060
                return
            L_0x0060:
                java.lang.Object r9 = r1.get()
                if (r5 == r9) goto L_0x0068
            L_0x0066:
                r8 = 1
                goto L_0x00aa
            L_0x0068:
                if (r2 != 0) goto L_0x0075
                io.reactivex.rxjava3.internal.util.AtomicThrowable r9 = r13.X2
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x0075
                goto L_0x0042
            L_0x0075:
                boolean r9 = r5.X2
                r10 = 0
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x007d }
                goto L_0x009b
            L_0x007d:
                r8 = move-exception
                io.reactivex.rxjava3.exceptions.Exceptions.b(r8)
                io.reactivex.rxjava3.internal.util.AtomicThrowable r11 = r13.X2
                r11.d(r8)
                androidx.lifecycle.g.a(r1, r5, r10)
                if (r2 != 0) goto L_0x0096
                r13.a()
                io.reactivex.rxjava3.disposables.Disposable r8 = r13.a3
                r8.m()
                r13.Y2 = r3
                goto L_0x0099
            L_0x0096:
                r5.a()
            L_0x0099:
                r11 = r10
                r8 = 1
            L_0x009b:
                if (r11 != 0) goto L_0x009f
                r12 = 1
                goto L_0x00a0
            L_0x009f:
                r12 = 0
            L_0x00a0:
                if (r9 == 0) goto L_0x00a8
                if (r12 == 0) goto L_0x00a8
                androidx.lifecycle.g.a(r1, r5, r10)
                goto L_0x0066
            L_0x00a8:
                if (r12 == 0) goto L_0x00ae
            L_0x00aa:
                if (r8 == 0) goto L_0x00b2
                goto L_0x000f
            L_0x00ae:
                r0.onNext(r11)
                goto L_0x005b
            L_0x00b2:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableSwitchMap.SwitchMapObserver.c():void");
        }

        /* access modifiers changed from: package-private */
        public void d(SwitchMapInnerObserver<T, R> switchMapInnerObserver, Throwable th) {
            if (switchMapInnerObserver.X != this.c3 || !this.X2.c(th)) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (!this.Z) {
                this.a3.m();
                this.Y2 = true;
            }
            switchMapInnerObserver.X2 = true;
            c();
        }

        public boolean g() {
            return this.Z2;
        }

        public void m() {
            if (!this.Z2) {
                this.Z2 = true;
                this.a3.m();
                a();
                this.X2.e();
            }
        }

        public void onComplete() {
            if (!this.Y2) {
                this.Y2 = true;
                c();
            }
        }

        public void onError(Throwable th) {
            if (this.Y2 || !this.X2.c(th)) {
                RxJavaPlugins.Y(th);
                return;
            }
            if (!this.Z) {
                a();
            }
            this.Y2 = true;
            c();
        }

        public void onNext(T t) {
            SwitchMapInnerObserver<Object, Object> switchMapInnerObserver;
            long j2 = this.c3 + 1;
            this.c3 = j2;
            SwitchMapInnerObserver switchMapInnerObserver2 = this.b3.get();
            if (switchMapInnerObserver2 != null) {
                switchMapInnerObserver2.a();
            }
            try {
                Object apply = this.X.apply(t);
                Objects.requireNonNull(apply, "The ObservableSource returned is null");
                ObservableSource observableSource = (ObservableSource) apply;
                SwitchMapInnerObserver switchMapInnerObserver3 = new SwitchMapInnerObserver(this, j2, this.Y);
                do {
                    switchMapInnerObserver = this.b3.get();
                    if (switchMapInnerObserver == e3) {
                        return;
                    }
                } while (!g.a(this.b3, switchMapInnerObserver, switchMapInnerObserver3));
                observableSource.a(switchMapInnerObserver3);
            } catch (Throwable th) {
                Exceptions.b(th);
                this.a3.m();
                onError(th);
            }
        }
    }

    public ObservableSwitchMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
        super(observableSource);
        this.X = function;
        this.Y = i2;
        this.Z = z;
    }

    public void g6(Observer<? super R> observer) {
        if (!ObservableScalarXMap.b(this.s, observer, this.X)) {
            this.s.a(new SwitchMapObserver(observer, this.X, this.Y, this.Z));
        }
    }
}
