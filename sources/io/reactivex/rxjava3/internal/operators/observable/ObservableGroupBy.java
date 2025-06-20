package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.observables.GroupedObservable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableGroupBy<T, K, V> extends AbstractObservableWithUpstream<T, GroupedObservable<K, V>> {
    final Function<? super T, ? extends K> X;
    final boolean X2;
    final Function<? super T, ? extends V> Y;
    final int Z;

    public static final class GroupByObserver<T, K, V> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long b3 = -3688291656102519502L;
        static final Object c3 = new Object();
        final Function<? super T, ? extends K> X;
        final boolean X2;
        final Function<? super T, ? extends V> Y;
        final Map<Object, GroupedUnicast<K, V>> Y2;
        final int Z;
        Disposable Z2;
        final AtomicBoolean a3 = new AtomicBoolean();
        final Observer<? super GroupedObservable<K, V>> s;

        public GroupByObserver(Observer<? super GroupedObservable<K, V>> observer, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = function2;
            this.Z = i2;
            this.X2 = z;
            this.Y2 = new ConcurrentHashMap();
            lazySet(1);
        }

        public void a(K k2) {
            if (k2 == null) {
                k2 = c3;
            }
            this.Y2.remove(k2);
            if (decrementAndGet() == 0) {
                this.Z2.m();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.a3.get();
        }

        public void m() {
            if (this.a3.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.Z2.m();
            }
        }

        public void onComplete() {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.Y2.values());
            this.Y2.clear();
            for (GroupedUnicast onComplete : arrayList) {
                onComplete.onComplete();
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            ArrayList<GroupedUnicast> arrayList = new ArrayList<>(this.Y2.values());
            this.Y2.clear();
            for (GroupedUnicast onError : arrayList) {
                onError.onError(th);
            }
            this.s.onError(th);
        }

        public void onNext(T t) {
            boolean z;
            try {
                Object apply = this.X.apply(t);
                Object obj = apply != null ? apply : c3;
                GroupedUnicast groupedUnicast = this.Y2.get(obj);
                if (groupedUnicast != null) {
                    z = false;
                } else if (!this.a3.get()) {
                    groupedUnicast = GroupedUnicast.E8(apply, this.Z, this, this.X2);
                    this.Y2.put(obj, groupedUnicast);
                    getAndIncrement();
                    z = true;
                } else {
                    return;
                }
                try {
                    Object apply2 = this.Y.apply(t);
                    Objects.requireNonNull(apply2, "The value supplied is null");
                    groupedUnicast.onNext(apply2);
                    if (z) {
                        this.s.onNext(groupedUnicast);
                        if (groupedUnicast.X.i()) {
                            a(apply);
                            groupedUnicast.onComplete();
                        }
                    }
                } catch (Throwable th) {
                    Exceptions.b(th);
                    this.Z2.m();
                    if (z) {
                        this.s.onNext(groupedUnicast);
                    }
                    onError(th);
                }
            } catch (Throwable th2) {
                Exceptions.b(th2);
                this.Z2.m();
                onError(th2);
            }
        }
    }

    static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> X;

        protected GroupedUnicast(K k2, State<T, K> state) {
            super(k2);
            this.X = state;
        }

        public static <T, K> GroupedUnicast<K, T> E8(K k2, int i2, GroupByObserver<?, K, T> groupByObserver, boolean z) {
            return new GroupedUnicast<>(k2, new State(i2, groupByObserver, k2, z));
        }

        /* access modifiers changed from: protected */
        public void g6(Observer<? super T> observer) {
            this.X.a(observer);
        }

        public void onComplete() {
            this.X.e();
        }

        public void onError(Throwable th) {
            this.X.f(th);
        }

        public void onNext(T t) {
            this.X.h(t);
        }
    }

    static final class State<T, K> extends AtomicInteger implements Disposable, ObservableSource<T> {
        private static final long c3 = -3852313036005250360L;
        static final int d3 = 0;
        static final int e3 = 1;
        static final int f3 = 2;
        static final int g3 = 3;
        final SpscLinkedArrayQueue<T> X;
        volatile boolean X2;
        final GroupByObserver<?, K, T> Y;
        Throwable Y2;
        final boolean Z;
        final AtomicBoolean Z2 = new AtomicBoolean();
        final AtomicReference<Observer<? super T>> a3 = new AtomicReference<>();
        final AtomicInteger b3 = new AtomicInteger();
        final K s;

        State(int i2, GroupByObserver<?, K, T> groupByObserver, K k2, boolean z) {
            this.X = new SpscLinkedArrayQueue<>(i2);
            this.Y = groupByObserver;
            this.s = k2;
            this.Z = z;
        }

        public void a(Observer<? super T> observer) {
            int i2;
            do {
                i2 = this.b3.get();
                if ((i2 & 1) != 0) {
                    EmptyDisposable.h(new IllegalStateException("Only one Observer allowed!"), observer);
                    return;
                }
            } while (!this.b3.compareAndSet(i2, i2 | 1));
            observer.b(this);
            this.a3.lazySet(observer);
            if (this.Z2.get()) {
                this.a3.lazySet((Object) null);
            } else {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            if ((this.b3.get() & 2) == 0) {
                this.Y.a(this.s);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(boolean z, boolean z2, Observer<? super T> observer, boolean z3) {
            if (this.Z2.get()) {
                this.X.clear();
                this.a3.lazySet((Object) null);
                b();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!z3) {
                    Throwable th = this.Y2;
                    if (th != null) {
                        this.X.clear();
                        this.a3.lazySet((Object) null);
                        observer.onError(th);
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.a3.lazySet((Object) null);
                        observer.onComplete();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    Throwable th2 = this.Y2;
                    this.a3.lazySet((Object) null);
                    if (th2 != null) {
                        observer.onError(th2);
                    } else {
                        observer.onComplete();
                    }
                    return true;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.X;
                boolean z = this.Z;
                Observer observer = this.a3.get();
                int i2 = 1;
                while (true) {
                    if (observer != null) {
                        while (true) {
                            boolean z2 = this.X2;
                            T poll = spscLinkedArrayQueue.poll();
                            boolean z3 = poll == null;
                            if (!c(z2, z3, observer, z)) {
                                if (z3) {
                                    break;
                                }
                                observer.onNext(poll);
                            } else {
                                return;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 != 0) {
                        if (observer == null) {
                            observer = this.a3.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public void e() {
            this.X2 = true;
            d();
        }

        public void f(Throwable th) {
            this.Y2 = th;
            this.X2 = true;
            d();
        }

        public boolean g() {
            return this.Z2.get();
        }

        public void h(T t) {
            this.X.offer(t);
            d();
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            return this.b3.get() == 0 && this.b3.compareAndSet(0, 2);
        }

        public void m() {
            if (this.Z2.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.a3.lazySet((Object) null);
                b();
            }
        }
    }

    public ObservableGroupBy(ObservableSource<T> observableSource, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, int i2, boolean z) {
        super(observableSource);
        this.X = function;
        this.Y = function2;
        this.Z = i2;
        this.X2 = z;
    }

    public void g6(Observer<? super GroupedObservable<K, V>> observer) {
        this.s.a(new GroupByObserver(observer, this.X, this.Y, this.Z, this.X2));
    }
}
