package io.reactivex.rxjava3.subjects;

import androidx.lifecycle.g;
import io.reactivex.rxjava3.annotations.CheckReturnValue;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T> extends Subject<T> {
    static final ReplayDisposable[] X2 = new ReplayDisposable[0];
    private static final Object[] Y2 = new Object[0];
    static final ReplayDisposable[] Z = new ReplayDisposable[0];
    final AtomicReference<ReplayDisposable<T>[]> X = new AtomicReference<>(Z);
    boolean Y;
    final ReplayBuffer<T> s;

    static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long X = 6404226426336033100L;
        final T s;

        Node(T t) {
            this.s = t;
        }
    }

    interface ReplayBuffer<T> {
        void a();

        void add(T t);

        void b(Object obj);

        void c(ReplayDisposable<T> replayDisposable);

        boolean compareAndSet(Object obj, Object obj2);

        T[] f(T[] tArr);

        Object get();

        @Nullable
        T getValue();

        int size();
    }

    static final class ReplayDisposable<T> extends AtomicInteger implements Disposable {
        private static final long X2 = 466549804534799122L;
        final ReplaySubject<T> X;
        Object Y;
        volatile boolean Z;
        final Observer<? super T> s;

        ReplayDisposable(Observer<? super T> observer, ReplaySubject<T> replaySubject) {
            this.s = observer;
            this.X = replaySubject;
        }

        public boolean g() {
            return this.Z;
        }

        public void m() {
            if (!this.Z) {
                this.Z = true;
                this.X.V8(this);
            }
        }
    }

    static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long b3 = -8056260896137901749L;
        final long X;
        int X2;
        final TimeUnit Y;
        volatile TimedNode<Object> Y2;
        final Scheduler Z;
        TimedNode<Object> Z2;
        volatile boolean a3;
        final int s;

        SizeAndTimeBoundReplayBuffer(int i2, long j2, TimeUnit timeUnit, Scheduler scheduler) {
            this.s = i2;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = scheduler;
            TimedNode<Object> timedNode = new TimedNode<>(null, 0);
            this.Z2 = timedNode;
            this.Y2 = timedNode;
        }

        public void a() {
            TimedNode<Object> timedNode = this.Y2;
            if (timedNode.s != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0);
                timedNode2.lazySet(timedNode.get());
                this.Y2 = timedNode2;
            }
        }

        public void add(T t) {
            TimedNode<Object> timedNode = new TimedNode<>(t, this.Z.e(this.Y));
            TimedNode<Object> timedNode2 = this.Z2;
            this.Z2 = timedNode;
            this.X2++;
            timedNode2.set(timedNode);
            g();
        }

        public void b(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.Z2;
            this.Z2 = timedNode;
            this.X2++;
            timedNode2.lazySet(timedNode);
            h();
            this.a3 = true;
        }

        public void c(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.s;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.Y;
                if (timedNode == null) {
                    timedNode = d();
                }
                int i2 = 1;
                while (!replayDisposable.Z) {
                    TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        replayDisposable.Y = timedNode;
                        i2 = replayDisposable.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        T t = timedNode2.s;
                        if (!this.a3 || timedNode2.get() != null) {
                            observer.onNext(t);
                            timedNode = timedNode2;
                        } else {
                            if (NotificationLite.m(t)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.j(t));
                            }
                            replayDisposable.Y = null;
                            replayDisposable.Z = true;
                            return;
                        }
                    }
                }
                replayDisposable.Y = null;
            }
        }

        /* access modifiers changed from: package-private */
        public TimedNode<Object> d() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.Y2;
            long e2 = this.Z.e(this.Y) - this.X;
            do {
                timedNode = timedNode2;
                timedNode2 = (TimedNode) timedNode2.get();
                if (timedNode2 == null || timedNode2.X > e2) {
                    return timedNode;
                }
                timedNode = timedNode2;
                timedNode2 = (TimedNode) timedNode2.get();
                break;
            } while (timedNode2.X > e2);
            return timedNode;
        }

        /* access modifiers changed from: package-private */
        public int e(TimedNode<Object> timedNode) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    T t = timedNode.s;
                    return (NotificationLite.m(t) || NotificationLite.o(t)) ? i2 - 1 : i2;
                }
                i2++;
                timedNode = timedNode2;
            }
            return i2;
        }

        public T[] f(T[] tArr) {
            TimedNode<Object> d2 = d();
            int e2 = e(d2);
            if (e2 != 0) {
                if (tArr.length < e2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), e2);
                }
                for (int i2 = 0; i2 != e2; i2++) {
                    d2 = (TimedNode) d2.get();
                    tArr[i2] = d2.s;
                }
                if (tArr.length > e2) {
                    tArr[e2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        /* access modifiers changed from: package-private */
        public void g() {
            int i2 = this.X2;
            if (i2 > this.s) {
                this.X2 = i2 - 1;
                this.Y2 = (TimedNode) this.Y2.get();
            }
            long e2 = this.Z.e(this.Y) - this.X;
            TimedNode<Object> timedNode = this.Y2;
            while (this.X2 > 1) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.X > e2) {
                    break;
                }
                this.X2--;
                timedNode = timedNode2;
            }
            this.Y2 = timedNode;
        }

        @Nullable
        public T getValue() {
            T t;
            TimedNode<Object> timedNode = this.Y2;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.X >= this.Z.e(this.Y) - this.X && (t = timedNode.s) != null) {
                return (NotificationLite.m(t) || NotificationLite.o(t)) ? timedNode2.s : t;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0025, code lost:
            r0.lazySet(r2.get());
            r10.Y2 = r0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void h() {
            /*
                r10 = this;
                io.reactivex.rxjava3.core.Scheduler r0 = r10.Z
                java.util.concurrent.TimeUnit r1 = r10.Y
                long r0 = r0.e(r1)
                long r2 = r10.X
                long r0 = r0 - r2
                io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode<java.lang.Object> r2 = r10.Y2
            L_0x000d:
                java.lang.Object r3 = r2.get()
                io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode r3 = (io.reactivex.rxjava3.subjects.ReplaySubject.TimedNode) r3
                java.lang.Object r4 = r3.get()
                r5 = 0
                r7 = 0
                if (r4 != 0) goto L_0x0032
                T r0 = r2.s
                if (r0 == 0) goto L_0x002f
                io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode r0 = new io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode
                r0.<init>(r7, r5)
            L_0x0025:
                java.lang.Object r1 = r2.get()
                r0.lazySet(r1)
                r10.Y2 = r0
                goto L_0x0042
            L_0x002f:
                r10.Y2 = r2
                goto L_0x0042
            L_0x0032:
                long r8 = r3.X
                int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                if (r4 <= 0) goto L_0x0043
                T r0 = r2.s
                if (r0 == 0) goto L_0x002f
                io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode r0 = new io.reactivex.rxjava3.subjects.ReplaySubject$TimedNode
                r0.<init>(r7, r5)
                goto L_0x0025
            L_0x0042:
                return
            L_0x0043:
                r2 = r3
                goto L_0x000d
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.subjects.ReplaySubject.SizeAndTimeBoundReplayBuffer.h():void");
        }

        public int size() {
            return e(d());
        }
    }

    static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long Y2 = 1107649250281456395L;
        int X;
        volatile boolean X2;
        volatile Node<Object> Y;
        Node<Object> Z;
        final int s;

        SizeBoundReplayBuffer(int i2) {
            this.s = i2;
            Node<Object> node = new Node<>(null);
            this.Z = node;
            this.Y = node;
        }

        public void a() {
            Node<Object> node = this.Y;
            if (node.s != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.Y = node2;
            }
        }

        public void add(T t) {
            Node<Object> node = new Node<>(t);
            Node<Object> node2 = this.Z;
            this.Z = node;
            this.X++;
            node2.set(node);
            d();
        }

        public void b(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.Z;
            this.Z = node;
            this.X++;
            node2.lazySet(node);
            a();
            this.X2 = true;
        }

        public void c(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                Observer<? super T> observer = replayDisposable.s;
                Node<Object> node = (Node) replayDisposable.Y;
                if (node == null) {
                    node = this.Y;
                }
                int i2 = 1;
                while (!replayDisposable.Z) {
                    Node<Object> node2 = (Node) node.get();
                    if (node2 != null) {
                        T t = node2.s;
                        if (!this.X2 || node2.get() != null) {
                            observer.onNext(t);
                            node = node2;
                        } else {
                            if (NotificationLite.m(t)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.j(t));
                            }
                            replayDisposable.Y = null;
                            replayDisposable.Z = true;
                            return;
                        }
                    } else if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.Y = node;
                        i2 = replayDisposable.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.Y = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int i2 = this.X;
            if (i2 > this.s) {
                this.X = i2 - 1;
                this.Y = (Node) this.Y.get();
            }
        }

        public T[] f(T[] tArr) {
            Node<Object> node = this.Y;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
                }
                for (int i2 = 0; i2 != size; i2++) {
                    node = (Node) node.get();
                    tArr[i2] = node.s;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Nullable
        public T getValue() {
            Node<Object> node = this.Y;
            Node<Object> node2 = null;
            while (true) {
                Node<Object> node3 = (Node) node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t = node.s;
            if (t == null) {
                return null;
            }
            return (NotificationLite.m(t) || NotificationLite.o(t)) ? node2.s : t;
        }

        public int size() {
            Node<Object> node = this.Y;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                Node<Object> node2 = (Node) node.get();
                if (node2 == null) {
                    T t = node.s;
                    return (NotificationLite.m(t) || NotificationLite.o(t)) ? i2 - 1 : i2;
                }
                i2++;
                node = node2;
            }
            return i2;
        }
    }

    static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long Y = 6404226426336033100L;
        final long X;
        final T s;

        TimedNode(T t, long j2) {
            this.s = t;
            this.X = j2;
        }
    }

    static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> implements ReplayBuffer<T> {
        private static final long Z = -733876083048047795L;
        volatile boolean X;
        volatile int Y;
        final List<Object> s;

        UnboundedReplayBuffer(int i2) {
            this.s = new ArrayList(i2);
        }

        public void a() {
        }

        public void add(T t) {
            this.s.add(t);
            this.Y++;
        }

        public void b(Object obj) {
            this.s.add(obj);
            a();
            this.Y++;
            this.X = true;
        }

        public void c(ReplayDisposable<T> replayDisposable) {
            int i2;
            int i3;
            if (replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.s;
                Observer<? super T> observer = replayDisposable.s;
                Integer num = (Integer) replayDisposable.Y;
                if (num != null) {
                    i2 = num.intValue();
                } else {
                    i2 = 0;
                    replayDisposable.Y = 0;
                }
                int i4 = 1;
                while (!replayDisposable.Z) {
                    int i5 = this.Y;
                    while (i5 != i2) {
                        if (replayDisposable.Z) {
                            replayDisposable.Y = null;
                            return;
                        }
                        Object obj = list.get(i2);
                        if (this.X && (i3 = i2 + 1) == i5 && i3 == (i5 = this.Y)) {
                            if (NotificationLite.m(obj)) {
                                observer.onComplete();
                            } else {
                                observer.onError(NotificationLite.j(obj));
                            }
                            replayDisposable.Y = null;
                            replayDisposable.Z = true;
                            return;
                        }
                        observer.onNext(obj);
                        i2++;
                    }
                    if (i2 == this.Y) {
                        replayDisposable.Y = Integer.valueOf(i2);
                        i4 = replayDisposable.addAndGet(-i4);
                        if (i4 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.Y = null;
            }
        }

        public T[] f(T[] tArr) {
            int i2 = this.Y;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List list = this.s;
            Object obj = list.get(i2 - 1);
            if ((NotificationLite.m(obj) || NotificationLite.o(obj)) && i2 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i2) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2);
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = list.get(i3);
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Nullable
        public T getValue() {
            int i2 = this.Y;
            if (i2 == 0) {
                return null;
            }
            List<Object> list = this.s;
            T t = list.get(i2 - 1);
            if (!NotificationLite.m(t) && !NotificationLite.o(t)) {
                return t;
            }
            if (i2 == 1) {
                return null;
            }
            return list.get(i2 - 2);
        }

        public int size() {
            int i2 = this.Y;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            Object obj = this.s.get(i3);
            return (NotificationLite.m(obj) || NotificationLite.o(obj)) ? i3 : i2;
        }
    }

    ReplaySubject(ReplayBuffer<T> replayBuffer) {
        this.s = replayBuffer;
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> K8() {
        return new ReplaySubject<>(new UnboundedReplayBuffer(16));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> L8(int i2) {
        ObjectHelper.b(i2, "capacityHint");
        return new ReplaySubject<>(new UnboundedReplayBuffer(i2));
    }

    static <T> ReplaySubject<T> M8() {
        return new ReplaySubject<>(new SizeBoundReplayBuffer(Integer.MAX_VALUE));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> N8(int i2) {
        ObjectHelper.b(i2, "maxSize");
        return new ReplaySubject<>(new SizeBoundReplayBuffer(i2));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> O8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler) {
        ObjectHelper.c(j2, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(Integer.MAX_VALUE, j2, timeUnit, scheduler));
    }

    @NonNull
    @CheckReturnValue
    public static <T> ReplaySubject<T> P8(long j2, @NonNull TimeUnit timeUnit, @NonNull Scheduler scheduler, int i2) {
        ObjectHelper.b(i2, "maxSize");
        ObjectHelper.c(j2, "maxAge");
        Objects.requireNonNull(timeUnit, "unit is null");
        Objects.requireNonNull(scheduler, "scheduler is null");
        return new ReplaySubject<>(new SizeAndTimeBoundReplayBuffer(i2, j2, timeUnit, scheduler));
    }

    @CheckReturnValue
    @Nullable
    public Throwable D8() {
        Object obj = this.s.get();
        if (NotificationLite.o(obj)) {
            return NotificationLite.j(obj);
        }
        return null;
    }

    @CheckReturnValue
    public boolean E8() {
        return NotificationLite.m(this.s.get());
    }

    @CheckReturnValue
    public boolean F8() {
        return ((ReplayDisposable[]) this.X.get()).length != 0;
    }

    @CheckReturnValue
    public boolean G8() {
        return NotificationLite.o(this.s.get());
    }

    /* access modifiers changed from: package-private */
    public boolean I8(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.X.get();
            if (replayDisposableArr == X2) {
                return false;
            }
            int length = replayDisposableArr.length;
            replayDisposableArr2 = new ReplayDisposable[(length + 1)];
            System.arraycopy(replayDisposableArr, 0, replayDisposableArr2, 0, length);
            replayDisposableArr2[length] = replayDisposable;
        } while (!g.a(this.X, replayDisposableArr, replayDisposableArr2));
        return true;
    }

    public void J8() {
        this.s.a();
    }

    @CheckReturnValue
    @Nullable
    public T Q8() {
        return this.s.getValue();
    }

    @CheckReturnValue
    public Object[] R8() {
        Object[] objArr = Y2;
        Object[] S8 = S8(objArr);
        return S8 == objArr ? new Object[0] : S8;
    }

    @CheckReturnValue
    public T[] S8(T[] tArr) {
        return this.s.f(tArr);
    }

    @CheckReturnValue
    public boolean T8() {
        return this.s.size() != 0;
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int U8() {
        return ((ReplayDisposable[]) this.X.get()).length;
    }

    /* access modifiers changed from: package-private */
    public void V8(ReplayDisposable<T> replayDisposable) {
        ReplayDisposable<T>[] replayDisposableArr;
        ReplayDisposable[] replayDisposableArr2;
        do {
            replayDisposableArr = (ReplayDisposable[]) this.X.get();
            if (replayDisposableArr != X2 && replayDisposableArr != Z) {
                int length = replayDisposableArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        i2 = -1;
                        break;
                    } else if (replayDisposableArr[i2] == replayDisposable) {
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i2 >= 0) {
                    if (length == 1) {
                        replayDisposableArr2 = Z;
                    } else {
                        ReplayDisposable[] replayDisposableArr3 = new ReplayDisposable[(length - 1)];
                        System.arraycopy(replayDisposableArr, 0, replayDisposableArr3, 0, i2);
                        System.arraycopy(replayDisposableArr, i2 + 1, replayDisposableArr3, i2, (length - i2) - 1);
                        replayDisposableArr2 = replayDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!g.a(this.X, replayDisposableArr, replayDisposableArr2));
    }

    /* access modifiers changed from: package-private */
    @CheckReturnValue
    public int W8() {
        return this.s.size();
    }

    /* access modifiers changed from: package-private */
    public ReplayDisposable<T>[] X8(Object obj) {
        this.s.compareAndSet((Object) null, obj);
        return (ReplayDisposable[]) this.X.getAndSet(X2);
    }

    public void b(Disposable disposable) {
        if (this.Y) {
            disposable.m();
        }
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super T> observer) {
        ReplayDisposable replayDisposable = new ReplayDisposable(observer, this);
        observer.b(replayDisposable);
        if (!I8(replayDisposable) || !replayDisposable.Z) {
            this.s.c(replayDisposable);
        } else {
            V8(replayDisposable);
        }
    }

    public void onComplete() {
        if (!this.Y) {
            this.Y = true;
            Object f2 = NotificationLite.f();
            ReplayBuffer<T> replayBuffer = this.s;
            replayBuffer.b(f2);
            for (ReplayDisposable c2 : X8(f2)) {
                replayBuffer.c(c2);
            }
        }
    }

    public void onError(Throwable th) {
        ExceptionHelper.d(th, "onError called with a null Throwable.");
        if (this.Y) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Y = true;
        Object h2 = NotificationLite.h(th);
        ReplayBuffer<T> replayBuffer = this.s;
        replayBuffer.b(h2);
        for (ReplayDisposable c2 : X8(h2)) {
            replayBuffer.c(c2);
        }
    }

    public void onNext(T t) {
        ExceptionHelper.d(t, "onNext called with a null value.");
        if (!this.Y) {
            ReplayBuffer<T> replayBuffer = this.s;
            replayBuffer.add(t);
            for (ReplayDisposable c2 : (ReplayDisposable[]) this.X.get()) {
                replayBuffer.c(c2);
            }
        }
    }
}
