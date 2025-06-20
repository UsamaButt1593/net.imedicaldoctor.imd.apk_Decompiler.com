package kotlinx.coroutines.channels;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\t¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J#\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00028\u00002\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0014¢\u0006\u0004\b\u001f\u0010 J\u0011\u0010!\u001a\u0004\u0018\u00010\u0016H\u0014¢\u0006\u0004\b!\u0010\"J\u001d\u0010#\u001a\u0004\u0018\u00010\u00162\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0014¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\b2\u0006\u0010*\u001a\u00020'H\u0014¢\u0006\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u000601j\u0002`28\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u001e\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010.R\u0014\u0010>\u001a\u00020'8DX\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010@\u001a\u00020'8DX\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0014\u0010B\u001a\u00020'8DX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010=R\u0014\u0010D\u001a\u00020'8DX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010=R\u0014\u0010E\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010=R\u0014\u0010G\u001a\u00020'8VX\u0004¢\u0006\u0006\u001a\u0004\bF\u0010=R\u0014\u0010K\u001a\u00020H8TX\u0004¢\u0006\u0006\u001a\u0004\bI\u0010J¨\u0006L"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "Lkotlinx/coroutines/internal/Symbol;", "u0", "(I)Lkotlinx/coroutines/internal/Symbol;", "element", "s0", "(ILjava/lang/Object;)V", "t0", "(I)V", "", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "H", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "send", "k", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "m0", "()Ljava/lang/Object;", "n0", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "a0", "(Lkotlinx/coroutines/channels/Receive;)Z", "wasClosed", "h0", "(Z)V", "Z", "I", "X2", "Lkotlinx/coroutines/channels/BufferOverflow;", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Y2", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "", "Z2", "[Ljava/lang/Object;", "buffer", "a3", "head", "d0", "()Z", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "y", "isBufferAlwaysFull", "A", "isBufferFull", "isEmpty", "l", "isClosedForReceive", "", "n", "()Ljava/lang/String;", "bufferDebugString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ArrayChannel<E> extends AbstractChannel<E> {
    @NotNull
    private final BufferOverflow X2;
    @NotNull
    private final ReentrantLock Y2;
    private final int Z;
    @NotNull
    private Object[] Z2;
    private int a3;
    @NotNull
    private volatile /* synthetic */ int size;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29234a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f29234a = iArr;
        }
    }

    public ArrayChannel(int i2, @NotNull BufferOverflow bufferOverflow, @Nullable Function1<? super E, Unit> function1) {
        super(function1);
        this.Z = i2;
        this.X2 = bufferOverflow;
        if (i2 >= 1) {
            this.Y2 = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i2, 8)];
            ArraysKt.V1(objArr, AbstractChannelKt.f29226c, 0, 0, 6, (Object) null);
            this.Z2 = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    private final void s0(int i2, E e2) {
        if (i2 < this.Z) {
            t0(i2);
            Object[] objArr = this.Z2;
            objArr[(this.a3 + i2) % objArr.length] = e2;
            return;
        }
        Object[] objArr2 = this.Z2;
        int i3 = this.a3;
        objArr2[i3 % objArr2.length] = null;
        objArr2[(i2 + i3) % objArr2.length] = e2;
        this.a3 = (i3 + 1) % objArr2.length;
    }

    private final void t0(int i2) {
        Object[] objArr = this.Z2;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.Z);
            Object[] objArr2 = new Object[min];
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr3 = this.Z2;
                objArr2[i3] = objArr3[(this.a3 + i3) % objArr3.length];
            }
            ArraysKt.M1(objArr2, AbstractChannelKt.f29226c, i2, min);
            this.Z2 = objArr2;
            this.a3 = 0;
        }
    }

    private final Symbol u0(int i2) {
        if (i2 < this.Z) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = WhenMappings.f29234a[this.X2.ordinal()];
        if (i3 == 1) {
            return AbstractChannelKt.f29228e;
        }
        if (i3 == 2) {
            return AbstractChannelKt.f29227d;
        }
        if (i3 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* access modifiers changed from: protected */
    public final boolean A() {
        return this.size == this.Z && this.X2 == BufferOverflow.SUSPEND;
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @NotNull
    public Object F(E e2) {
        ReceiveOrClosed M;
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        int i2 = this.size;
        Closed<?> q = q();
        if (q != null) {
            reentrantLock.unlock();
            return q;
        }
        Symbol u0 = u0(i2);
        if (u0 != null) {
            reentrantLock.unlock();
            return u0;
        }
        if (i2 == 0) {
            do {
                try {
                    M = M();
                    if (M != null) {
                        if (M instanceof Closed) {
                            this.size = i2;
                            reentrantLock.unlock();
                            return M;
                        }
                        Intrinsics.m(M);
                    }
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            } while (M.n0(e2, (LockFreeLinkedListNode.PrepareOp) null) == null);
            this.size = i2;
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            M.c0(e2);
            return M.v();
        }
        s0(i2, e2);
        Symbol symbol = AbstractChannelKt.f29227d;
        reentrantLock.unlock();
        return symbol;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object H(E e2, @NotNull SelectInstance<?> selectInstance) {
        Object i0;
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        int i2 = this.size;
        Closed<?> q = q();
        if (q != null) {
            reentrantLock.unlock();
            return q;
        }
        Symbol u0 = u0(i2);
        if (u0 != null) {
            reentrantLock.unlock();
            return u0;
        }
        if (i2 == 0) {
            do {
                try {
                    AbstractSendChannel.TryOfferDesc j2 = j(e2);
                    i0 = selectInstance.i0(j2);
                    if (i0 == null) {
                        this.size = i2;
                        Object o = j2.o();
                        Unit unit = Unit.f28779a;
                        reentrantLock.unlock();
                        Intrinsics.m(o);
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) o;
                        receiveOrClosed.c0(e2);
                        return receiveOrClosed.v();
                    } else if (i0 != AbstractChannelKt.f29228e) {
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } while (i0 == AtomicKt.f29332b);
            if (i0 != SelectKt.d()) {
                if (!(i0 instanceof Closed)) {
                    throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + i0).toString());
                }
            }
            this.size = i2;
            return i0;
        }
        if (!selectInstance.y()) {
            this.size = i2;
            Object d2 = SelectKt.d();
            reentrantLock.unlock();
            return d2;
        }
        s0(i2, e2);
        Symbol symbol = AbstractChannelKt.f29227d;
        reentrantLock.unlock();
        return symbol;
    }

    /* access modifiers changed from: protected */
    public boolean a0(@NotNull Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            return super.a0(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean d0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean e0() {
        return this.size == 0;
    }

    /* access modifiers changed from: protected */
    public void h0(boolean z) {
        Function1<E, Unit> function1 = this.s;
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            UndeliveredElementException undeliveredElementException = null;
            for (int i3 = 0; i3 < i2; i3++) {
                Object obj = this.Z2[this.a3];
                if (!(function1 == null || obj == AbstractChannelKt.f29226c)) {
                    undeliveredElementException = OnUndeliveredElementKt.c(function1, obj, undeliveredElementException);
                }
                Object[] objArr = this.Z2;
                int i4 = this.a3;
                objArr[i4] = AbstractChannelKt.f29226c;
                this.a3 = (i4 + 1) % objArr.length;
            }
            this.size = 0;
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            super.h0(z);
            if (undeliveredElementException != null) {
                throw undeliveredElementException;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            return f0();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object k(@NotNull Send send) {
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            return super.k(send);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean l() {
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            return super.l();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object m0() {
        ReentrantLock reentrantLock = this.Y2;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object q = q();
                if (q == null) {
                    q = AbstractChannelKt.f29229f;
                }
                return q;
            }
            Object[] objArr = this.Z2;
            int i3 = this.a3;
            Object obj = objArr[i3];
            Send send = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object obj2 = AbstractChannelKt.f29229f;
            boolean z = false;
            if (i2 == this.Z) {
                Send send2 = null;
                while (true) {
                    Send N = N();
                    if (N == null) {
                        send = send2;
                        break;
                    }
                    Intrinsics.m(N);
                    if (N.a1((LockFreeLinkedListNode.PrepareOp) null) != null) {
                        obj2 = N.Y0();
                        send = N;
                        z = true;
                        break;
                    }
                    N.b1();
                    send2 = N;
                }
            }
            if (obj2 != AbstractChannelKt.f29229f && !(obj2 instanceof Closed)) {
                this.size = i2;
                Object[] objArr2 = this.Z2;
                objArr2[(this.a3 + i2) % objArr2.length] = obj2;
            }
            this.a3 = (this.a3 + 1) % this.Z2.length;
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            if (z) {
                Intrinsics.m(send);
                send.X0();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String n() {
        return "(buffer:capacity=" + this.Z + ",size=" + this.size + ASCIIPropertyListParser.f18650h;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r7 != kotlinx.coroutines.selects.SelectKt.d()) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
        r8.size = r1;
        r8.Z2[r8.a3] = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        if ((r7 instanceof kotlinx.coroutines.channels.Closed) == false) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        r2 = r7;
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        throw new java.lang.IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + r7).toString());
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098 A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00be  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object n0(@org.jetbrains.annotations.NotNull kotlinx.coroutines.selects.SelectInstance<?> r9) {
        /*
            r8 = this;
            java.util.concurrent.locks.ReentrantLock r0 = r8.Y2
            r0.lock()
            int r1 = r8.size     // Catch:{ all -> 0x0012 }
            if (r1 != 0) goto L_0x0019
            kotlinx.coroutines.channels.Closed r9 = r8.q()     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x0015
            kotlinx.coroutines.internal.Symbol r9 = kotlinx.coroutines.channels.AbstractChannelKt.f29229f     // Catch:{ all -> 0x0012 }
            goto L_0x0015
        L_0x0012:
            r9 = move-exception
            goto L_0x00c7
        L_0x0015:
            r0.unlock()
            return r9
        L_0x0019:
            java.lang.Object[] r2 = r8.Z2     // Catch:{ all -> 0x0012 }
            int r3 = r8.a3     // Catch:{ all -> 0x0012 }
            r4 = r2[r3]     // Catch:{ all -> 0x0012 }
            r5 = 0
            r2[r3] = r5     // Catch:{ all -> 0x0012 }
            int r2 = r1 + -1
            r8.size = r2     // Catch:{ all -> 0x0012 }
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.f29229f     // Catch:{ all -> 0x0012 }
            int r3 = r8.Z     // Catch:{ all -> 0x0012 }
            r6 = 1
            if (r1 != r3) goto L_0x0083
        L_0x002d:
            kotlinx.coroutines.channels.AbstractChannel$TryPollDesc r3 = r8.W()     // Catch:{ all -> 0x0012 }
            java.lang.Object r7 = r9.i0(r3)     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x0047
            java.lang.Object r5 = r3.o()     // Catch:{ all -> 0x0012 }
            kotlin.jvm.internal.Intrinsics.m(r5)     // Catch:{ all -> 0x0012 }
            r2 = r5
            kotlinx.coroutines.channels.Send r2 = (kotlinx.coroutines.channels.Send) r2     // Catch:{ all -> 0x0012 }
            java.lang.Object r2 = r2.Y0()     // Catch:{ all -> 0x0012 }
        L_0x0045:
            r3 = 1
            goto L_0x0084
        L_0x0047:
            kotlinx.coroutines.internal.Symbol r3 = kotlinx.coroutines.channels.AbstractChannelKt.f29229f     // Catch:{ all -> 0x0012 }
            if (r7 == r3) goto L_0x0083
            java.lang.Object r3 = kotlinx.coroutines.internal.AtomicKt.f29332b     // Catch:{ all -> 0x0012 }
            if (r7 == r3) goto L_0x002d
            java.lang.Object r2 = kotlinx.coroutines.selects.SelectKt.d()     // Catch:{ all -> 0x0012 }
            if (r7 != r2) goto L_0x0061
            r8.size = r1     // Catch:{ all -> 0x0012 }
            java.lang.Object[] r9 = r8.Z2     // Catch:{ all -> 0x0012 }
            int r1 = r8.a3     // Catch:{ all -> 0x0012 }
            r9[r1] = r4     // Catch:{ all -> 0x0012 }
            r0.unlock()
            return r7
        L_0x0061:
            boolean r2 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x0012 }
            if (r2 == 0) goto L_0x0068
            r2 = r7
            r5 = r2
            goto L_0x0045
        L_0x0068:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0012 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0012 }
            r1.<init>()     // Catch:{ all -> 0x0012 }
            java.lang.String r2 = "performAtomicTrySelect(describeTryOffer) returned "
            r1.append(r2)     // Catch:{ all -> 0x0012 }
            r1.append(r7)     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0012 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0012 }
            r9.<init>(r1)     // Catch:{ all -> 0x0012 }
            throw r9     // Catch:{ all -> 0x0012 }
        L_0x0083:
            r3 = 0
        L_0x0084:
            kotlinx.coroutines.internal.Symbol r7 = kotlinx.coroutines.channels.AbstractChannelKt.f29229f     // Catch:{ all -> 0x0012 }
            if (r2 == r7) goto L_0x0098
            boolean r7 = r2 instanceof kotlinx.coroutines.channels.Closed     // Catch:{ all -> 0x0012 }
            if (r7 != 0) goto L_0x0098
            r8.size = r1     // Catch:{ all -> 0x0012 }
            java.lang.Object[] r9 = r8.Z2     // Catch:{ all -> 0x0012 }
            int r7 = r8.a3     // Catch:{ all -> 0x0012 }
            int r7 = r7 + r1
            int r1 = r9.length     // Catch:{ all -> 0x0012 }
            int r7 = r7 % r1
            r9[r7] = r2     // Catch:{ all -> 0x0012 }
            goto L_0x00ae
        L_0x0098:
            boolean r9 = r9.y()     // Catch:{ all -> 0x0012 }
            if (r9 != 0) goto L_0x00ae
            r8.size = r1     // Catch:{ all -> 0x0012 }
            java.lang.Object[] r9 = r8.Z2     // Catch:{ all -> 0x0012 }
            int r1 = r8.a3     // Catch:{ all -> 0x0012 }
            r9[r1] = r4     // Catch:{ all -> 0x0012 }
            java.lang.Object r9 = kotlinx.coroutines.selects.SelectKt.d()     // Catch:{ all -> 0x0012 }
            r0.unlock()
            return r9
        L_0x00ae:
            int r9 = r8.a3     // Catch:{ all -> 0x0012 }
            int r9 = r9 + r6
            java.lang.Object[] r1 = r8.Z2     // Catch:{ all -> 0x0012 }
            int r1 = r1.length     // Catch:{ all -> 0x0012 }
            int r9 = r9 % r1
            r8.a3 = r9     // Catch:{ all -> 0x0012 }
            kotlin.Unit r9 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0012 }
            r0.unlock()
            if (r3 == 0) goto L_0x00c6
            kotlin.jvm.internal.Intrinsics.m(r5)
            kotlinx.coroutines.channels.Send r5 = (kotlinx.coroutines.channels.Send) r5
            r5.X0()
        L_0x00c6:
            return r4
        L_0x00c7:
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayChannel.n0(kotlinx.coroutines.selects.SelectInstance):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return false;
    }
}
