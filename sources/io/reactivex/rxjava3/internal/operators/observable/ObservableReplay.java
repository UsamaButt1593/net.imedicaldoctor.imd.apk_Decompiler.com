package io.reactivex.rxjava3.internal.operators.observable;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableReplay<T> extends ConnectableObservable<T> implements HasUpstreamObservableSource<T> {
    static final BufferSupplier X2 = new UnBoundedFactory();
    final AtomicReference<ReplayObserver<T>> X;
    final BufferSupplier<T> Y;
    final ObservableSource<T> Z;
    final ObservableSource<T> s;

    static abstract class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long Z = 2346567790059478686L;
        int X;
        final boolean Y;
        Node s;

        BoundedReplayBuffer(boolean z) {
            this.Y = z;
            Node node = new Node((Object) null);
            this.s = node;
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void a(Node node) {
            this.s.set(node);
            this.s = node;
            this.X++;
        }

        public final void b(T t) {
            a(new Node(f(NotificationLite.q(t))));
            p();
        }

        public final void c() {
            a(new Node(f(NotificationLite.f())));
            q();
        }

        public final void d(Throwable th) {
            a(new Node(f(NotificationLite.h(th))));
            q();
        }

        /* access modifiers changed from: package-private */
        public final void e(Collection<? super T> collection) {
            Node h2 = h();
            while (true) {
                h2 = (Node) h2.get();
                if (h2 != null) {
                    Object k2 = k(h2.s);
                    if (!NotificationLite.m(k2) && !NotificationLite.o(k2)) {
                        collection.add(NotificationLite.l(k2));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return obj;
        }

        public final void g(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                int i2 = 1;
                do {
                    Node node = (Node) innerDisposable.a();
                    if (node == null) {
                        node = h();
                        innerDisposable.Y = node;
                    }
                    while (!innerDisposable.g()) {
                        Node node2 = (Node) node.get();
                        if (node2 == null) {
                            innerDisposable.Y = node;
                            i2 = innerDisposable.addAndGet(-i2);
                        } else if (NotificationLite.a(k(node2.s), innerDisposable.X)) {
                            innerDisposable.Y = null;
                            return;
                        } else {
                            node = node2;
                        }
                    }
                    innerDisposable.Y = null;
                    return;
                } while (i2 != 0);
            }
        }

        /* access modifiers changed from: package-private */
        public Node h() {
            return (Node) get();
        }

        /* access modifiers changed from: package-private */
        public boolean i() {
            Object obj = this.s.s;
            return obj != null && NotificationLite.m(k(obj));
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            Object obj = this.s.s;
            return obj != null && NotificationLite.o(k(obj));
        }

        /* access modifiers changed from: package-private */
        public Object k(Object obj) {
            return obj;
        }

        /* access modifiers changed from: package-private */
        public final void l() {
            this.X--;
            n((Node) ((Node) get()).get());
        }

        /* access modifiers changed from: package-private */
        public final void m(int i2) {
            Node node = (Node) get();
            while (i2 > 0) {
                node = (Node) node.get();
                i2--;
                this.X--;
            }
            n(node);
            Node node2 = (Node) get();
            if (node2.get() == null) {
                this.s = node2;
            }
        }

        /* access modifiers changed from: package-private */
        public final void n(Node node) {
            if (this.Y) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                node = node2;
            }
            set(node);
        }

        /* access modifiers changed from: package-private */
        public final void o() {
            Node node = (Node) get();
            if (node.s != null) {
                Node node2 = new Node((Object) null);
                node2.lazySet(node.get());
                set(node2);
            }
        }

        /* access modifiers changed from: package-private */
        public abstract void p();

        /* access modifiers changed from: package-private */
        public void q() {
            o();
        }
    }

    interface BufferSupplier<T> {
        ReplayBuffer<T> call();
    }

    static final class DisposeConsumer<R> implements Consumer<Disposable> {
        private final ObserverResourceWrapper<R> s;

        DisposeConsumer(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.s = observerResourceWrapper;
        }

        /* renamed from: a */
        public void accept(Disposable disposable) {
            this.s.a(disposable);
        }
    }

    static final class InnerDisposable<T> extends AtomicInteger implements Disposable {
        private static final long X2 = 2728361546769921047L;
        final Observer<? super T> X;
        Object Y;
        volatile boolean Z;
        final ReplayObserver<T> s;

        InnerDisposable(ReplayObserver<T> replayObserver, Observer<? super T> observer) {
            this.s = replayObserver;
            this.X = observer;
        }

        /* access modifiers changed from: package-private */
        public <U> U a() {
            return this.Y;
        }

        public boolean g() {
            return this.Z;
        }

        public void m() {
            if (!this.Z) {
                this.Z = true;
                this.s.c(this);
                this.Y = null;
            }
        }
    }

    static final class MulticastReplay<R, U> extends Observable<R> {
        private final Function<? super Observable<U>, ? extends ObservableSource<R>> X;
        private final Supplier<? extends ConnectableObservable<U>> s;

        MulticastReplay(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
            this.s = supplier;
            this.X = function;
        }

        /* access modifiers changed from: protected */
        public void g6(Observer<? super R> observer) {
            try {
                Object obj = this.s.get();
                Objects.requireNonNull(obj, "The connectableFactory returned a null ConnectableObservable");
                ConnectableObservable connectableObservable = (ConnectableObservable) obj;
                Object apply = this.X.apply(connectableObservable);
                Objects.requireNonNull(apply, "The selector returned a null ObservableSource");
                ObservableSource observableSource = (ObservableSource) apply;
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(observer);
                observableSource.a(observerResourceWrapper);
                connectableObservable.H8(new DisposeConsumer(observerResourceWrapper));
            } catch (Throwable th) {
                Exceptions.b(th);
                EmptyDisposable.h(th, observer);
            }
        }
    }

    static final class Node extends AtomicReference<Node> {
        private static final long X = 245354315435971818L;
        final Object s;

        Node(Object obj) {
            this.s = obj;
        }
    }

    interface ReplayBuffer<T> {
        void b(T t);

        void c();

        void d(Throwable th);

        void g(InnerDisposable<T> innerDisposable);
    }

    static final class ReplayBufferSupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        final int f28408a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f28409b;

        ReplayBufferSupplier(int i2, boolean z) {
            this.f28408a = i2;
            this.f28409b = z;
        }

        public ReplayBuffer<T> call() {
            return new SizeBoundReplayBuffer(this.f28408a, this.f28409b);
        }
    }

    static final class ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
        private static final long Y2 = -533785617179540163L;
        static final InnerDisposable[] Z2 = new InnerDisposable[0];
        static final InnerDisposable[] a3 = new InnerDisposable[0];
        boolean X;
        final AtomicReference<ReplayObserver<T>> X2;
        final AtomicReference<InnerDisposable[]> Y = new AtomicReference<>(Z2);
        final AtomicBoolean Z = new AtomicBoolean();
        final ReplayBuffer<T> s;

        ReplayObserver(ReplayBuffer<T> replayBuffer, AtomicReference<ReplayObserver<T>> atomicReference) {
            this.s = replayBuffer;
            this.X2 = atomicReference;
        }

        /* access modifiers changed from: package-private */
        public boolean a(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.Y.get();
                if (innerDisposableArr == a3) {
                    return false;
                }
                int length = innerDisposableArr.length;
                innerDisposableArr2 = new InnerDisposable[(length + 1)];
                System.arraycopy(innerDisposableArr, 0, innerDisposableArr2, 0, length);
                innerDisposableArr2[length] = innerDisposable;
            } while (!g.a(this.Y, innerDisposableArr, innerDisposableArr2));
            return true;
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.h(this, disposable)) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void c(InnerDisposable<T> innerDisposable) {
            InnerDisposable[] innerDisposableArr;
            InnerDisposable[] innerDisposableArr2;
            do {
                innerDisposableArr = this.Y.get();
                int length = innerDisposableArr.length;
                if (length != 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            i2 = -1;
                            break;
                        } else if (innerDisposableArr[i2].equals(innerDisposable)) {
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            innerDisposableArr2 = Z2;
                        } else {
                            InnerDisposable[] innerDisposableArr3 = new InnerDisposable[(length - 1)];
                            System.arraycopy(innerDisposableArr, 0, innerDisposableArr3, 0, i2);
                            System.arraycopy(innerDisposableArr, i2 + 1, innerDisposableArr3, i2, (length - i2) - 1);
                            innerDisposableArr2 = innerDisposableArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!g.a(this.Y, innerDisposableArr, innerDisposableArr2));
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (InnerDisposable g2 : this.Y.get()) {
                this.s.g(g2);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            for (InnerDisposable g2 : this.Y.getAndSet(a3)) {
                this.s.g(g2);
            }
        }

        public boolean g() {
            return this.Y.get() == a3;
        }

        public void m() {
            this.Y.set(a3);
            g.a(this.X2, this, (Object) null);
            DisposableHelper.a(this);
        }

        public void onComplete() {
            if (!this.X) {
                this.X = true;
                this.s.c();
                e();
            }
        }

        public void onError(Throwable th) {
            if (!this.X) {
                this.X = true;
                this.s.d(th);
                e();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            if (!this.X) {
                this.s.b(t);
                d();
            }
        }
    }

    static final class ReplaySource<T> implements ObservableSource<T> {
        private final BufferSupplier<T> X;
        private final AtomicReference<ReplayObserver<T>> s;

        ReplaySource(AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
            this.s = atomicReference;
            this.X = bufferSupplier;
        }

        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(io.reactivex.rxjava3.core.Observer<? super T> r4) {
            /*
                r3 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.s
                java.lang.Object r0 = r0.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayObserver) r0
                if (r0 != 0) goto L_0x0022
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$BufferSupplier<T> r0 = r3.X
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer r0 = r0.call()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r2 = r3.s
                r1.<init>(r0, r2)
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r3.s
                r2 = 0
                boolean r0 = androidx.lifecycle.g.a(r0, r2, r1)
                if (r0 != 0) goto L_0x0021
                goto L_0x0000
            L_0x0021:
                r0 = r1
            L_0x0022:
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$InnerDisposable r1 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$InnerDisposable
                r1.<init>(r0, r4)
                r4.b(r1)
                r0.a(r1)
                boolean r4 = r1.g()
                if (r4 == 0) goto L_0x0037
                r0.c(r1)
                return
            L_0x0037:
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer<T> r4 = r0.s
                r4.g(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplaySource.a(io.reactivex.rxjava3.core.Observer):void");
        }
    }

    static final class ScheduledReplaySupplier<T> implements BufferSupplier<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f28410a;

        /* renamed from: b  reason: collision with root package name */
        private final long f28411b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f28412c;

        /* renamed from: d  reason: collision with root package name */
        private final Scheduler f28413d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f28414e;

        ScheduledReplaySupplier(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            this.f28410a = i2;
            this.f28411b = j2;
            this.f28412c = timeUnit;
            this.f28413d = scheduler;
            this.f28414e = z;
        }

        public ReplayBuffer<T> call() {
            return new SizeAndTimeBoundReplayBuffer(this.f28410a, this.f28411b, this.f28412c, this.f28413d, this.f28414e);
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long b3 = 3457957419649567404L;
        final Scheduler X2;
        final long Y2;
        final TimeUnit Z2;
        final int a3;

        SizeAndTimeBoundReplayBuffer(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
            super(z);
            this.X2 = scheduler;
            this.a3 = i2;
            this.Y2 = j2;
            this.Z2 = timeUnit;
        }

        /* access modifiers changed from: package-private */
        public Object f(Object obj) {
            return new Timed(obj, this.X2.e(this.Z2), this.Z2);
        }

        /* access modifiers changed from: package-private */
        public Node h() {
            Node node;
            Timed timed;
            long e2 = this.X2.e(this.Z2) - this.Y2;
            Node node2 = (Node) get();
            do {
                node = node2;
                node2 = (Node) node2.get();
                if (node2 == null) {
                    break;
                }
                timed = (Timed) node2.s;
                if (NotificationLite.m(timed.d())) {
                    break;
                } else if (NotificationLite.o(timed.d())) {
                    break;
                }
            } while (timed.a() > e2);
            return node;
        }

        /* access modifiers changed from: package-private */
        public Object k(Object obj) {
            return ((Timed) obj).d();
        }

        /* access modifiers changed from: package-private */
        public void p() {
            Node node;
            long e2 = this.X2.e(this.Z2) - this.Y2;
            Node node2 = (Node) get();
            Node node3 = (Node) node2.get();
            int i2 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                int i3 = this.X;
                if (i3 <= 1) {
                    break;
                }
                if (i3 <= this.a3) {
                    if (((Timed) node2.s).a() > e2) {
                        break;
                    }
                    i2++;
                    this.X--;
                } else {
                    i2++;
                    this.X = i3 - 1;
                }
                node3 = (Node) node2.get();
            }
            if (i2 != 0) {
                n(node);
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x003c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void q() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.X2
                java.util.concurrent.TimeUnit r1 = r10.Z2
                long r0 = r0.e(r1)
                long r2 = r10.Y2
                long r0 = r0 - r2
                java.lang.Object r2 = r10.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r2
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r3
                r4 = 0
            L_0x0018:
                r9 = r3
                r3 = r2
                r2 = r9
                int r5 = r10.X
                r6 = 1
                if (r5 <= r6) goto L_0x003a
                java.lang.Object r5 = r2.s
                io.reactivex.rxjava3.schedulers.Timed r5 = (io.reactivex.rxjava3.schedulers.Timed) r5
                long r7 = r5.a()
                int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r5 > 0) goto L_0x003a
                int r4 = r4 + 1
                int r3 = r10.X
                int r3 = r3 - r6
                r10.X = r3
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.Node) r3
                goto L_0x0018
            L_0x003a:
                if (r4 == 0) goto L_0x003f
                r10.n(r3)
            L_0x003f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.SizeAndTimeBoundReplayBuffer.q():void");
        }
    }

    static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long Y2 = -5898283885385201806L;
        final int X2;

        SizeBoundReplayBuffer(int i2, boolean z) {
            super(z);
            this.X2 = i2;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            if (this.X > this.X2) {
                l();
            }
        }
    }

    static final class UnBoundedFactory implements BufferSupplier<Object> {
        UnBoundedFactory() {
        }

        public ReplayBuffer<Object> call() {
            return new UnboundedReplayBuffer(16);
        }
    }

    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long X = 7063189396499112664L;
        volatile int s;

        UnboundedReplayBuffer(int i2) {
            super(i2);
        }

        public void b(T t) {
            add(NotificationLite.q(t));
            this.s++;
        }

        public void c() {
            add(NotificationLite.f());
            this.s++;
        }

        public void d(Throwable th) {
            add(NotificationLite.h(th));
            this.s++;
        }

        public void g(InnerDisposable<T> innerDisposable) {
            if (innerDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = innerDisposable.X;
                int i2 = 1;
                while (!innerDisposable.g()) {
                    int i3 = this.s;
                    Integer num = (Integer) innerDisposable.a();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i3) {
                        if (!NotificationLite.a(get(intValue), observer) && !innerDisposable.g()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    innerDisposable.Y = Integer.valueOf(intValue);
                    i2 = innerDisposable.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private ObservableReplay(ObservableSource<T> observableSource, ObservableSource<T> observableSource2, AtomicReference<ReplayObserver<T>> atomicReference, BufferSupplier<T> bufferSupplier) {
        this.Z = observableSource;
        this.s = observableSource2;
        this.X = atomicReference;
        this.Y = bufferSupplier;
    }

    public static <T> ConnectableObservable<T> P8(ObservableSource<T> observableSource, int i2, boolean z) {
        return i2 == Integer.MAX_VALUE ? T8(observableSource) : S8(observableSource, new ReplayBufferSupplier(i2, z));
    }

    public static <T> ConnectableObservable<T> Q8(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, int i2, boolean z) {
        return S8(observableSource, new ScheduledReplaySupplier(i2, j2, timeUnit, scheduler, z));
    }

    public static <T> ConnectableObservable<T> R8(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        return Q8(observableSource, j2, timeUnit, scheduler, Integer.MAX_VALUE, z);
    }

    static <T> ConnectableObservable<T> S8(ObservableSource<T> observableSource, BufferSupplier<T> bufferSupplier) {
        AtomicReference atomicReference = new AtomicReference();
        return RxJavaPlugins.U(new ObservableReplay(new ReplaySource(atomicReference, bufferSupplier), observableSource, atomicReference, bufferSupplier));
    }

    public static <T> ConnectableObservable<T> T8(ObservableSource<? extends T> observableSource) {
        return S8(observableSource, X2);
    }

    public static <U, R> Observable<R> U8(Supplier<? extends ConnectableObservable<U>> supplier, Function<? super Observable<U>, ? extends ObservableSource<R>> function) {
        return RxJavaPlugins.R(new MulticastReplay(supplier, function));
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void H8(io.reactivex.rxjava3.functions.Consumer<? super io.reactivex.rxjava3.disposables.Disposable> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r0 = r4.X
            java.lang.Object r0 = r0.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r0 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.ReplayObserver) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.g()
            if (r1 == 0) goto L_0x0027
        L_0x0010:
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$BufferSupplier<T> r1 = r4.Y
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayBuffer r1 = r1.call()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver r2 = new io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r3 = r4.X
            r2.<init>(r1, r3)
            java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$ReplayObserver<T>> r1 = r4.X
            boolean r0 = androidx.lifecycle.g.a(r1, r0, r2)
            if (r0 != 0) goto L_0x0026
            goto L_0x0000
        L_0x0026:
            r0 = r2
        L_0x0027:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Z
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x003b
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.Z
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x003b
            r1 = 1
            goto L_0x003c
        L_0x003b:
            r1 = 0
        L_0x003c:
            r5.accept(r0)     // Catch:{ all -> 0x0047 }
            if (r1 == 0) goto L_0x0046
            io.reactivex.rxjava3.core.ObservableSource<T> r5 = r4.s
            r5.a(r0)
        L_0x0046:
            return
        L_0x0047:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            if (r1 == 0) goto L_0x0052
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.Z
            r0.compareAndSet(r2, r3)
        L_0x0052:
            io.reactivex.rxjava3.exceptions.Exceptions.b(r5)
            java.lang.RuntimeException r5 = io.reactivex.rxjava3.internal.util.ExceptionHelper.i(r5)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay.H8(io.reactivex.rxjava3.functions.Consumer):void");
    }

    public void O8() {
        ReplayObserver replayObserver = this.X.get();
        if (replayObserver != null && replayObserver.g()) {
            g.a(this.X, replayObserver, (Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        this.Z.a(observer);
    }

    public ObservableSource<T> source() {
        return this.s;
    }
}
