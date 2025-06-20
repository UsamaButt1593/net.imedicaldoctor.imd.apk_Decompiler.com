package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservablePublish<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    final AtomicReference<PublishConnection<T>> X = new AtomicReference<>();
    final ObservableSource<T> s;

    static final class InnerDisposable<T> extends AtomicReference<PublishConnection<T>> implements Disposable {
        private static final long X = 7463222674719692880L;
        final Observer<? super T> s;

        InnerDisposable(Observer<? super T> observer, PublishConnection<T> publishConnection) {
            this.s = observer;
            lazySet(publishConnection);
        }

        public boolean g() {
            return get() == null;
        }

        public void m() {
            PublishConnection publishConnection = (PublishConnection) getAndSet((Object) null);
            if (publishConnection != null) {
                publishConnection.c(this);
            }
        }
    }

    static final class PublishConnection<T> extends AtomicReference<InnerDisposable<T>[]> implements Observer<T>, Disposable {
        private static final long X2 = -3251430252873581268L;
        static final InnerDisposable[] Y2 = new InnerDisposable[0];
        static final InnerDisposable[] Z2 = new InnerDisposable[0];
        final AtomicReference<PublishConnection<T>> X;
        final AtomicReference<Disposable> Y;
        Throwable Z;
        final AtomicBoolean s = new AtomicBoolean();

        PublishConnection(AtomicReference<PublishConnection<T>> atomicReference) {
            this.X = atomicReference;
            this.Y = new AtomicReference<>();
            lazySet(Y2);
        }

        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                if (innerDisposableArr == Z2) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(Disposable disposable) {
            DisposableHelper.h(this.Y, disposable);
        }

        public void c(InnerDisposable<T> innerDisposable) {
            InnerDisposable<T>[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = (InnerDisposable[]) get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerDisposableArr[i2] == innerDisposable) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        innerDisposableArr2 = Y2;
                        if (length != 1) {
                            innerDisposableArr2 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr2, i2, (length - i2) - 1);
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(innerDisposableArr, innerDisposableArr2));
        }

        public boolean g() {
            return get() == Z2;
        }

        public void m() {
            getAndSet(Z2);
            g.a(this.X, this, (Object) null);
            DisposableHelper.a(this.Y);
        }

        public void onComplete() {
            this.Y.lazySet(DisposableHelper.DISPOSED);
            for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(Z2)) {
                innerDisposable.s.onComplete();
            }
        }

        public void onError(Throwable th) {
            Disposable disposable = this.Y.get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (disposable != disposableHelper) {
                this.Z = th;
                this.Y.lazySet(disposableHelper);
                for (InnerDisposable innerDisposable : (InnerDisposable[]) getAndSet(Z2)) {
                    innerDisposable.s.onError(th);
                }
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            for (InnerDisposable innerDisposable : (InnerDisposable[]) get()) {
                innerDisposable.s.onNext(t);
            }
        }
    }

    public ObservablePublish(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H8(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r4.X
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.g()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.X
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r4.X
            boolean r0 = androidx.lifecycle.g.a(r2, r0, r1)
            if (r0 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.s
            boolean r1 = r1.get()
            r2 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.s
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)
            if (r1 == 0) goto L_0x0034
            r2 = 1
        L_0x0034:
            r5.accept(r0)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x003e
            io.reactivex.rxjava3.core.ObservableSource<T> r5 = r4.s
            r5.a(r0)
        L_0x003e:
            return
        L_0x003f:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.i(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.H8(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void O8() {
        PublishConnection publishConnection = this.X.get();
        if (publishConnection != null && publishConnection.g()) {
            g.a(this.X, publishConnection, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g6(io.reactivex.rxjava3.core.Observer<? super T> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r0 = r3.X
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.PublishConnection) r0
            if (r0 != 0) goto L_0x001b
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.X
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$PublishConnection<T>> r2 = r3.X
            boolean r0 = androidx.lifecycle.g.a(r2, r0, r1)
            if (r0 != 0) goto L_0x001a
            goto L_0x0000
        L_0x001a:
            r0 = r1
        L_0x001b:
            io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservablePublish$InnerDisposable
            r1.<init>(r4, r0)
            r4.b(r1)
            boolean r2 = r0.a(r1)
            if (r2 == 0) goto L_0x0033
            boolean r4 = r1.g()
            if (r4 == 0) goto L_0x0032
            r0.c(r1)
        L_0x0032:
            return
        L_0x0033:
            java.lang.Throwable r0 = r0.Z
            if (r0 == 0) goto L_0x003b
            r4.onError(r0)
            goto L_0x003e
        L_0x003b:
            r4.onComplete()
        L_0x003e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservablePublish.g6(io.reactivex.rxjava3.core.Observer):void");
    }

    public ObservableSource<T> source() {
        return this.s;
    }
}
