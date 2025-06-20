package kotlinx.coroutines.channels;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00028\u00002\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\rH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J/\u0010\u0016\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0014\u0010!\u001a\u00020\u00188DX\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "element", "", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "H", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "j0", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "", "d0", "()Z", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "y", "isBufferAlwaysFull", "A", "isBufferFull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class LinkedListChannel<E> extends AbstractChannel<E> {
    public LinkedListChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: protected */
    public final boolean A() {
        return false;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object F(E e2) {
        ReceiveOrClosed<?> K;
        do {
            Object F = super.F(e2);
            Symbol symbol = AbstractChannelKt.f29227d;
            if (F == symbol) {
                return symbol;
            }
            if (F == AbstractChannelKt.f29228e) {
                K = K(e2);
                if (K == null) {
                    return symbol;
                }
            } else if (F instanceof Closed) {
                return F;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + F).toString());
            }
        } while (!(K instanceof Closed));
        return K;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object H(E e2, @NotNull SelectInstance<?> selectInstance) {
        Object obj;
        while (true) {
            if (c0()) {
                obj = super.H(e2, selectInstance);
            } else {
                obj = selectInstance.i0(h(e2));
                if (obj == null) {
                    obj = AbstractChannelKt.f29227d;
                }
            }
            if (obj == SelectKt.d()) {
                return SelectKt.d();
            }
            Symbol symbol = AbstractChannelKt.f29227d;
            if (obj == symbol) {
                return symbol;
            }
            if (obj != AbstractChannelKt.f29228e && obj != AtomicKt.f29332b) {
                if (obj instanceof Closed) {
                    return obj;
                }
                throw new IllegalStateException(("Invalid result " + obj).toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean d0() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean e0() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void j0(@NotNull Object obj, @NotNull Closed<?> closed) {
        UndeliveredElementException undeliveredElementException = null;
        if (obj != null) {
            if (!(obj instanceof ArrayList)) {
                Send send = (Send) obj;
                if (send instanceof AbstractSendChannel.SendBuffered) {
                    Function1<E, Unit> function1 = this.s;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.c(function1, ((AbstractSendChannel.SendBuffered) send).Z, (UndeliveredElementException) null);
                    }
                } else {
                    send.Z0(closed);
                }
            } else {
                ArrayList arrayList = (ArrayList) obj;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    Send send2 = (Send) arrayList.get(size);
                    if (send2 instanceof AbstractSendChannel.SendBuffered) {
                        Function1<E, Unit> function12 = this.s;
                        undeliveredElementException2 = function12 != null ? OnUndeliveredElementKt.c(function12, ((AbstractSendChannel.SendBuffered) send2).Z, undeliveredElementException2) : null;
                    } else {
                        send2.Z0(closed);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean y() {
        return false;
    }
}
