package kotlinx.coroutines.channels;

import com.dd.plist.ASCIIPropertyListParser;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001e\u001a\u00020\u00182\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH\u0014¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u00060 j\u0002`!8\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b-\u0010)R\u0014\u00100\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010)R\u0014\u00101\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0014\u00105\u001a\u0002028TX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "element", "Lkotlinx/coroutines/internal/UndeliveredElementException;", "s0", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/UndeliveredElementException;", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "H", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "m0", "()Ljava/lang/Object;", "n0", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "", "wasClosed", "h0", "(Z)V", "Lkotlinx/coroutines/channels/Receive;", "receive", "a0", "(Lkotlinx/coroutines/channels/Receive;)Z", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "Z", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "X2", "Ljava/lang/Object;", "value", "d0", "()Z", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "y", "isBufferAlwaysFull", "A", "isBufferFull", "isEmpty", "", "n", "()Ljava/lang/String;", "bufferDebugString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class ConflatedChannel<E> extends AbstractChannel<E> {
    @Nullable
    private Object X2 = AbstractChannelKt.f29226c;
    @NotNull
    private final ReentrantLock Z = new ReentrantLock();

    public ConflatedChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    private final UndeliveredElementException s0(Object obj) {
        Function1<E, Unit> function1;
        Object obj2 = this.X2;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == AbstractChannelKt.f29226c || (function1 = this.s) == null)) {
            undeliveredElementException = OnUndeliveredElementKt.d(function1, obj2, (UndeliveredElementException) null, 2, (Object) null);
        }
        this.X2 = obj;
        return undeliveredElementException;
    }

    /* access modifiers changed from: protected */
    public final boolean A() {
        return false;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object F(E e2) {
        ReceiveOrClosed M;
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            Closed<?> q = q();
            if (q != null) {
                return q;
            }
            if (this.X2 == AbstractChannelKt.f29226c) {
                do {
                    M = M();
                    if (M != null) {
                        if (M instanceof Closed) {
                            reentrantLock.unlock();
                            return M;
                        }
                        Intrinsics.m(M);
                    }
                } while (M.n0(e2, (LockFreeLinkedListNode.PrepareOp) null) == null);
                Unit unit = Unit.f28779a;
                reentrantLock.unlock();
                M.c0(e2);
                return M.v();
            }
            UndeliveredElementException s0 = s0(e2);
            if (s0 == null) {
                Symbol symbol = AbstractChannelKt.f29227d;
                reentrantLock.unlock();
                return symbol;
            }
            throw s0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object H(E e2, @NotNull SelectInstance<?> selectInstance) {
        Object i0;
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            Closed<?> q = q();
            if (q != null) {
                return q;
            }
            if (this.X2 == AbstractChannelKt.f29226c) {
                do {
                    AbstractSendChannel.TryOfferDesc j2 = j(e2);
                    i0 = selectInstance.i0(j2);
                    if (i0 == null) {
                        Object o = j2.o();
                        Unit unit = Unit.f28779a;
                        reentrantLock.unlock();
                        Intrinsics.m(o);
                        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) o;
                        receiveOrClosed.c0(e2);
                        return receiveOrClosed.v();
                    } else if (i0 != AbstractChannelKt.f29228e) {
                    }
                } while (i0 == AtomicKt.f29332b);
                if (i0 != SelectKt.d()) {
                    if (!(i0 instanceof Closed)) {
                        throw new IllegalStateException(("performAtomicTrySelect(describeTryOffer) returned " + i0).toString());
                    }
                }
                reentrantLock.unlock();
                return i0;
            }
            if (!selectInstance.y()) {
                Object d2 = SelectKt.d();
                reentrantLock.unlock();
                return d2;
            }
            UndeliveredElementException s0 = s0(e2);
            if (s0 == null) {
                Symbol symbol = AbstractChannelKt.f29227d;
                reentrantLock.unlock();
                return symbol;
            }
            throw s0;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public boolean a0(@NotNull Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.Z;
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
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            return this.X2 == AbstractChannelKt.f29226c;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public void h0(boolean z) {
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            UndeliveredElementException s0 = s0(AbstractChannelKt.f29226c);
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            super.h0(z);
            if (s0 != null) {
                throw s0;
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean isEmpty() {
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            return f0();
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object m0() {
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            Object obj = this.X2;
            Symbol symbol = AbstractChannelKt.f29226c;
            if (obj == symbol) {
                Object q = q();
                if (q == null) {
                    q = AbstractChannelKt.f29229f;
                }
                return q;
            }
            this.X2 = symbol;
            Unit unit = Unit.f28779a;
            reentrantLock.unlock();
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String n() {
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            return "(value=" + this.X2 + ASCIIPropertyListParser.f18650h;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object n0(@NotNull SelectInstance<?> selectInstance) {
        ReentrantLock reentrantLock = this.Z;
        reentrantLock.lock();
        try {
            Object obj = this.X2;
            Symbol symbol = AbstractChannelKt.f29226c;
            if (obj == symbol) {
                Object q = q();
                if (q == null) {
                    q = AbstractChannelKt.f29229f;
                }
                return q;
            } else if (!selectInstance.y()) {
                Object d2 = SelectKt.d();
                reentrantLock.unlock();
                return d2;
            } else {
                Object obj2 = this.X2;
                this.X2 = symbol;
                Unit unit = Unit.f28779a;
                reentrantLock.unlock();
                return obj2;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return false;
    }
}
