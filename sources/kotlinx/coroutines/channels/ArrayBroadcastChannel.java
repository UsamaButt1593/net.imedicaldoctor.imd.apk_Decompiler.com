package kotlinx.coroutines.channels;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001RB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ4\u0010\u0013\u001a\u00020\r2\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010H\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001e\u0010\fJ\u0019\u0010\u001f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017¢\u0006\u0004\b\u001f\u0010\fJ\u001f\u0010\"\u001a\u00020\r2\u000e\u0010\t\u001a\n\u0018\u00010 j\u0004\u0018\u0001`!H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00028\u0000H\u0014¢\u0006\u0004\b&\u0010'J#\u0010*\u001a\u00020%2\u0006\u0010$\u001a\u00028\u00002\n\u0010)\u001a\u0006\u0012\u0002\b\u00030(H\u0014¢\u0006\u0004\b*\u0010+R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b,\u0010.R\u0018\u00103\u001a\u00060/j\u0002`08\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001c\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%048\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R6\u0010=\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001008j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0010`98\u0002X\u0004¢\u0006\f\n\u0004\b:\u0010;\u0012\u0004\b<\u0010\u000fR$\u0010B\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00158B@BX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010AR$\u0010E\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u00158B@BX\u000e¢\u0006\f\u001a\u0004\bC\u0010\u0017\"\u0004\bD\u0010AR$\u0010H\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u00048B@BX\u000e¢\u0006\f\u001a\u0004\bF\u0010.\"\u0004\bG\u0010\u0007R\u0014\u0010K\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020\n8TX\u0004¢\u0006\u0006\u001a\u0004\bL\u0010JR\u0014\u0010Q\u001a\u00020N8TX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "", "capacity", "<init>", "(I)V", "", "cause", "", "R", "(Ljava/lang/Throwable;)Z", "", "S", "()V", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "addSub", "removeSub", "j0", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;)V", "", "U", "()J", "index", "W", "(J)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "V", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "T", "d", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "element", "", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "H", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Z", "I", "()I", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "X2", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferLock", "", "Y2", "[Ljava/lang/Object;", "buffer", "", "Lkotlinx/coroutines/internal/SubscribersList;", "Z2", "Ljava/util/List;", "c0", "subscribers", "value", "a0", "e0", "(J)V", "head", "d0", "h0", "tail", "b0", "f0", "size", "y", "()Z", "isBufferAlwaysFull", "A", "isBufferFull", "", "n", "()Ljava/lang/String;", "bufferDebugString", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    @NotNull
    private final ReentrantLock X2;
    @NotNull
    private final Object[] Y2;
    private final int Z;
    @NotNull
    private final List<Subscriber<E>> Z2;
    @NotNull
    private volatile /* synthetic */ long _head;
    @NotNull
    private volatile /* synthetic */ int _size;
    @NotNull
    private volatile /* synthetic */ long _tail;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\nJ\u0011\u0010\u0013\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u0013\u0010\rJ\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u00060\u001aj\u0002`\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8F@FX\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0014\u0010)\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\nR\u0014\u0010+\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\nR\u0014\u0010-\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b,\u0010\n¨\u0006."}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "broadcastChannel", "<init>", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "", "u0", "()Z", "", "v0", "()Ljava/lang/Object;", "", "cause", "T", "(Ljava/lang/Throwable;)Z", "s0", "m0", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "n0", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Z", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "X2", "Ljava/util/concurrent/locks/ReentrantLock;", "subLock", "", "value", "t0", "()J", "w0", "(J)V", "subHead", "d0", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "y", "isBufferAlwaysFull", "A", "isBufferFull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        @NotNull
        private final ReentrantLock X2 = new ReentrantLock();
        @NotNull
        private final ArrayBroadcastChannel<E> Z;
        @NotNull
        private volatile /* synthetic */ long _subHead = 0;

        public Subscriber(@NotNull ArrayBroadcastChannel<E> arrayBroadcastChannel) {
            super((Function1) null);
            this.Z = arrayBroadcastChannel;
        }

        private final boolean u0() {
            if (p() != null) {
                return false;
            }
            return !e0() || this.Z.p() != null;
        }

        private final Object v0() {
            long t0 = t0();
            Closed<?> p = this.Z.p();
            if (t0 < this.Z.d0()) {
                Object O = this.Z.W(t0);
                Closed<?> p2 = p();
                return p2 != null ? p2 : O;
            } else if (p != null) {
                return p;
            } else {
                Closed<?> p3 = p();
                return p3 == null ? AbstractChannelKt.f29229f : p3;
            }
        }

        /* access modifiers changed from: protected */
        public boolean A() {
            throw new IllegalStateException("Should not be used".toString());
        }

        public boolean T(@Nullable Throwable th) {
            boolean T = super.T(th);
            if (T) {
                ArrayBroadcastChannel.k0(this.Z, (Subscriber) null, this, 1, (Object) null);
                ReentrantLock reentrantLock = this.X2;
                reentrantLock.lock();
                try {
                    w0(this.Z.d0());
                    Unit unit = Unit.f28779a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            return T;
        }

        /* access modifiers changed from: protected */
        public boolean d0() {
            return false;
        }

        /* access modifiers changed from: protected */
        public boolean e0() {
            return t0() >= this.Z.d0();
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        @Nullable
        public Object m0() {
            boolean z;
            ReentrantLock reentrantLock = this.X2;
            reentrantLock.lock();
            try {
                Object v0 = v0();
                boolean z2 = true;
                if ((v0 instanceof Closed) || v0 == AbstractChannelKt.f29229f) {
                    z = false;
                } else {
                    w0(t0() + 1);
                    z = true;
                }
                reentrantLock.unlock();
                Closed closed = v0 instanceof Closed ? (Closed) v0 : null;
                if (closed != null) {
                    T(closed.Z);
                }
                if (!s0()) {
                    z2 = z;
                }
                if (z2) {
                    ArrayBroadcastChannel.k0(this.Z, (Subscriber) null, (Subscriber) null, 3, (Object) null);
                }
                return v0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        @Nullable
        public Object n0(@NotNull SelectInstance<?> selectInstance) {
            ReentrantLock reentrantLock = this.X2;
            reentrantLock.lock();
            try {
                Object v0 = v0();
                boolean z = true;
                boolean z2 = false;
                if (!(v0 instanceof Closed) && v0 != AbstractChannelKt.f29229f) {
                    if (!selectInstance.y()) {
                        v0 = SelectKt.d();
                    } else {
                        w0(t0() + 1);
                        z2 = true;
                    }
                }
                reentrantLock.unlock();
                Closed closed = v0 instanceof Closed ? (Closed) v0 : null;
                if (closed != null) {
                    T(closed.Z);
                }
                if (!s0()) {
                    z = z2;
                }
                if (z) {
                    ArrayBroadcastChannel.k0(this.Z, (Subscriber) null, (Subscriber) null, 3, (Object) null);
                }
                return v0;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        public final boolean s0() {
            Closed closed;
            boolean z = false;
            while (true) {
                closed = null;
                if (!u0() || !this.X2.tryLock()) {
                    break;
                }
                try {
                    Object v0 = v0();
                    if (v0 != AbstractChannelKt.f29229f) {
                        if (v0 instanceof Closed) {
                            closed = (Closed) v0;
                            break;
                        }
                        ReceiveOrClosed M = M();
                        if (M == null) {
                            break;
                        } else if (M instanceof Closed) {
                            break;
                        } else if (M.n0(v0, (LockFreeLinkedListNode.PrepareOp) null) != null) {
                            w0(t0() + 1);
                            this.X2.unlock();
                            M.c0(v0);
                            z = true;
                        }
                    }
                } finally {
                    this.X2.unlock();
                }
            }
            this.X2.unlock();
            if (closed != null) {
                T(closed.Z);
            }
            return z;
        }

        public final long t0() {
            return this._subHead;
        }

        public final void w0(long j2) {
            this._subHead = j2;
        }

        /* access modifiers changed from: protected */
        public boolean y() {
            throw new IllegalStateException("Should not be used".toString());
        }
    }

    public ArrayBroadcastChannel(int i2) {
        super((Function1) null);
        this.Z = i2;
        if (i2 >= 1) {
            this.X2 = new ReentrantLock();
            this.Y2 = new Object[i2];
            this._head = 0;
            this._tail = 0;
            this._size = 0;
            this.Z2 = ConcurrentKt.d();
            return;
        }
        throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: R */
    public final boolean d(Throwable th) {
        boolean T = T(th);
        for (Subscriber<E> U : this.Z2) {
            U.d(th);
        }
        return T;
    }

    private final void S() {
        boolean z = false;
        boolean z2 = false;
        for (Subscriber<E> s0 : this.Z2) {
            if (s0.s0()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            k0(this, (Subscriber) null, (Subscriber) null, 3, (Object) null);
        }
    }

    private final long U() {
        long j2 = Long.MAX_VALUE;
        for (Subscriber<E> t0 : this.Z2) {
            j2 = RangesKt.C(j2, t0.t0());
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public final E W(long j2) {
        return this.Y2[(int) (j2 % ((long) this.Z))];
    }

    private final long a0() {
        return this._head;
    }

    private final int b0() {
        return this._size;
    }

    private static /* synthetic */ void c0() {
    }

    /* access modifiers changed from: private */
    public final long d0() {
        return this._tail;
    }

    private final void e0(long j2) {
        this._head = j2;
    }

    private final void f0(int i2) {
        this._size = i2;
    }

    private final void h0(long j2) {
        this._tail = j2;
    }

    private final void j0(Subscriber<E> subscriber, Subscriber<E> subscriber2) {
        Send N;
        while (true) {
            ReentrantLock reentrantLock = this.X2;
            reentrantLock.lock();
            if (subscriber != null) {
                try {
                    subscriber.w0(d0());
                    boolean isEmpty = this.Z2.isEmpty();
                    this.Z2.add(subscriber);
                    if (!isEmpty) {
                        return;
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
            if (subscriber2 != null) {
                this.Z2.remove(subscriber2);
                if (a0() != subscriber2.t0()) {
                    reentrantLock.unlock();
                    return;
                }
            }
            long U = U();
            long d0 = d0();
            long a0 = a0();
            long C = RangesKt.C(U, d0);
            if (C <= a0) {
                reentrantLock.unlock();
                return;
            }
            int b0 = b0();
            while (a0 < C) {
                Object[] objArr = this.Y2;
                int i2 = this.Z;
                objArr[(int) (a0 % ((long) i2))] = null;
                boolean z = b0 >= i2;
                a0++;
                e0(a0);
                int i3 = b0 - 1;
                f0(i3);
                if (z) {
                    do {
                        N = N();
                        if (N != null) {
                            if (!(N instanceof Closed)) {
                                Intrinsics.m(N);
                            } else {
                                continue;
                            }
                        }
                    } while (N.a1((LockFreeLinkedListNode.PrepareOp) null) == null);
                    this.Y2[(int) (d0 % ((long) this.Z))] = N.Y0();
                    f0(b0);
                    h0(d0 + 1);
                    Unit unit = Unit.f28779a;
                    reentrantLock.unlock();
                    N.X0();
                    S();
                    subscriber = null;
                    subscriber2 = null;
                }
                b0 = i3;
            }
            reentrantLock.unlock();
            return;
        }
    }

    static /* synthetic */ void k0(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            subscriber = null;
        }
        if ((i2 & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.j0(subscriber, subscriber2);
    }

    /* access modifiers changed from: protected */
    public boolean A() {
        return b0() >= this.Z;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object F(E e2) {
        ReentrantLock reentrantLock = this.X2;
        reentrantLock.lock();
        try {
            Closed<?> q = q();
            if (q != null) {
                return q;
            }
            int b0 = b0();
            if (b0 >= this.Z) {
                Symbol symbol = AbstractChannelKt.f29228e;
                reentrantLock.unlock();
                return symbol;
            }
            long d0 = d0();
            this.Y2[(int) (d0 % ((long) this.Z))] = e2;
            f0(b0 + 1);
            h0(d0 + 1);
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            S();
            return AbstractChannelKt.f29227d;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object H(E e2, @NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.X2;
        reentrantLock.lock();
        try {
            Closed<?> q = q();
            if (q != null) {
                return q;
            }
            int b0 = b0();
            if (b0 >= this.Z) {
                Symbol symbol = AbstractChannelKt.f29228e;
                reentrantLock.unlock();
                return symbol;
            } else if (!selectInstance.y()) {
                Object d2 = SelectKt.d();
                reentrantLock.unlock();
                return d2;
            } else {
                long d0 = d0();
                this.Y2[(int) (d0 % ((long) this.Z))] = e2;
                f0(b0 + 1);
                h0(d0 + 1);
                Unit unit = Unit.f28779a;
                reentrantLock.unlock();
                S();
                return AbstractChannelKt.f29227d;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean T(@Nullable Throwable th) {
        if (!super.T(th)) {
            return false;
        }
        S();
        return true;
    }

    @NotNull
    public ReceiveChannel<E> V() {
        Subscriber subscriber = new Subscriber(this);
        k0(this, subscriber, (Subscriber) null, 2, (Object) null);
        return subscriber;
    }

    public final int Z() {
        return this.Z;
    }

    public void i(@Nullable CancellationException cancellationException) {
        d(cancellationException);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String n() {
        return "(buffer:capacity=" + this.Y2.length + ",size=" + b0() + ASCIIPropertyListParser.f18650h;
    }

    /* access modifiers changed from: protected */
    public boolean y() {
        return false;
    }
}
