package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BeforeResumeCancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0007_`abcdeB)\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00028\u0001\"\u0004\b\u0001\u0010\n2\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013JT\u0010\u001a\u001a\u00020\u0005\"\u0004\b\u0001\u0010\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\f\u001a\u00020\u000b2$\u0010\u0019\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJZ\u0010\u001d\u001a\u00020\u0005\"\u0004\b\u0001\u0010\n* \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJT\u0010\u001f\u001a\u00020\u0011\"\u0004\b\u0001\u0010\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00142$\u0010\u0019\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\f\u001a\u00020\u000bH\u0002ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J'\u0010#\u001a\u00020\u00052\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030!2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014H\u0014¢\u0006\u0004\b'\u0010(J\u0013\u0010)\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u001d\u0010+\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0014¢\u0006\u0004\b+\u0010\u0013J\"\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000,H@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0001\u0010*J\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00000,ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b-\u0010&J\u0019\u00100\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010.H\u0007¢\u0006\u0004\b0\u00101J\u001d\u00104\u001a\u00020\u00052\u000e\u0010/\u001a\n\u0018\u000102j\u0004\u0018\u0001`3¢\u0006\u0004\b4\u00105J\u0019\u00106\u001a\u00020\u00112\b\u0010/\u001a\u0004\u0018\u00010.H\u0000¢\u0006\u0004\b6\u00101J\u0017\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0011H\u0014¢\u0006\u0004\b8\u00109J/\u0010?\u001a\u00020\u00052\f\u0010<\u001a\b\u0012\u0004\u0012\u00020;0:2\n\u0010>\u001a\u0006\u0012\u0002\b\u00030=H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b?\u0010@J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000AH\u0002¢\u0006\u0004\bB\u0010CJ\u0015\u0010E\u001a\b\u0012\u0004\u0012\u00028\u00000DH\u0004¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010GH\u0014¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0005H\u0014¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\u0005H\u0014¢\u0006\u0004\bL\u0010KR\u0014\u0010O\u001a\u00020\u00118$X¤\u0004¢\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020\u00118$X¤\u0004¢\u0006\u0006\u001a\u0004\bP\u0010NR\u0014\u0010S\u001a\u00020\u00118DX\u0004¢\u0006\u0006\u001a\u0004\bR\u0010NR\u0014\u0010U\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bT\u0010NR\u0014\u0010V\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010NR\u0014\u0010X\u001a\u00020\u00118DX\u0004¢\u0006\u0006\u001a\u0004\bW\u0010NR\u0017\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R \u0010^\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000,0Y8Fø\u0001\u0000¢\u0006\u0006\u001a\u0004\b]\u0010[\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", "E", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "R", "", "receiveMode", "o0", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Receive;", "receive", "", "Z", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "p0", "(Lkotlinx/coroutines/selects/SelectInstance;ILkotlin/jvm/functions/Function2;)V", "value", "r0", "(Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/selects/SelectInstance;ILjava/lang/Object;)V", "b0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "Lkotlinx/coroutines/CancellableContinuation;", "cont", "q0", "(Lkotlinx/coroutines/CancellableContinuation;Lkotlinx/coroutines/channels/Receive;)V", "m0", "()Ljava/lang/Object;", "n0", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Q", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a0", "Lkotlinx/coroutines/channels/ChannelResult;", "B", "", "cause", "d", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "i", "(Ljava/util/concurrent/CancellationException;)V", "U", "wasClosed", "h0", "(Z)V", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "j0", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "W", "()Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "M", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "l0", "()V", "k0", "d0", "()Z", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "c0", "hasReceiveOrClosed", "l", "isClosedForReceive", "isEmpty", "f0", "isEmptyImpl", "Lkotlinx/coroutines/selects/SelectClause1;", "m", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceive", "o", "onReceiveCatching", "Itr", "ReceiveElement", "ReceiveElementWithUndeliveredHandler", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000e\u001a\u00020\tHBø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "E", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "", "result", "", "e", "(Ljava/lang/Object;)Z", "f", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "next", "()Ljava/lang/Object;", "Lkotlinx/coroutines/channels/AbstractChannel;", "b", "Ljava/lang/Object;", "d", "g", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class Itr<E> implements ChannelIterator<E> {
        @NotNull
        @JvmField

        /* renamed from: a  reason: collision with root package name */
        public final AbstractChannel<E> f29222a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Object f29223b = AbstractChannelKt.f29229f;

        public Itr(@NotNull AbstractChannel<E> abstractChannel) {
            this.f29222a = abstractChannel;
        }

        private final boolean e(Object obj) {
            if (!(obj instanceof Closed)) {
                return true;
            }
            Closed closed = (Closed) obj;
            if (closed.Z == null) {
                return false;
            }
            throw StackTraceRecoveryKt.p(closed.e1());
        }

        /* access modifiers changed from: private */
        public final Object f(Continuation<? super Boolean> continuation) {
            Object a2;
            CancellableContinuationImpl<? super Boolean> b2 = CancellableContinuationKt.b(IntrinsicsKt.e(continuation));
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, b2);
            while (true) {
                if (this.f29222a.Z(receiveHasNext)) {
                    this.f29222a.q0(b2, receiveHasNext);
                    break;
                }
                Object m0 = this.f29222a.m0();
                g(m0);
                if (m0 instanceof Closed) {
                    Closed closed = (Closed) m0;
                    if (closed.Z == null) {
                        Result.Companion companion = Result.X;
                        a2 = Boxing.a(false);
                    } else {
                        Result.Companion companion2 = Result.X;
                        a2 = ResultKt.a(closed.e1());
                    }
                    b2.w(Result.b(a2));
                } else if (m0 != AbstractChannelKt.f29229f) {
                    Boolean a3 = Boxing.a(true);
                    Function1<E, Unit> function1 = this.f29222a.s;
                    b2.f0(a3, function1 != null ? OnUndeliveredElementKt.a(function1, m0, b2.g()) : null);
                }
            }
            Object y = b2.y();
            if (y == IntrinsicsKt.l()) {
                DebugProbesKt.c(continuation);
            }
            return y;
        }

        @Nullable
        public Object a(@NotNull Continuation<? super Boolean> continuation) {
            Object obj = this.f29223b;
            Symbol symbol = AbstractChannelKt.f29229f;
            if (obj == symbol) {
                obj = this.f29222a.m0();
                this.f29223b = obj;
                if (obj == symbol) {
                    return f(continuation);
                }
            }
            return Boxing.a(e(obj));
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @JvmName(name = "next")
        public /* synthetic */ Object b(Continuation continuation) {
            return ChannelIterator.DefaultImpls.a(this, continuation);
        }

        @Nullable
        public final Object d() {
            return this.f29223b;
        }

        public final void g(@Nullable Object obj) {
            this.f29223b = obj;
        }

        public E next() {
            E e2 = this.f29223b;
            if (!(e2 instanceof Closed)) {
                E e3 = AbstractChannelKt.f29229f;
                if (e2 != e3) {
                    this.f29223b = e3;
                    return e2;
                }
                throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
            }
            throw StackTraceRecoveryKt.p(((Closed) e2).e1());
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\n\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00028\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0017\u001a\u00020\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "value", "a1", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "n0", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "c0", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Z", "Lkotlinx/coroutines/CancellableContinuation;", "X2", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class ReceiveElement<E> extends Receive<E> {
        @JvmField
        public final int X2;
        @NotNull
        @JvmField
        public final CancellableContinuation<Object> Z;

        public ReceiveElement(@NotNull CancellableContinuation<Object> cancellableContinuation, int i2) {
            this.Z = cancellableContinuation;
            this.X2 = i2;
        }

        public void Z0(@NotNull Closed<?> closed) {
            CancellableContinuation<Object> cancellableContinuation;
            Object a2;
            if (this.X2 == 1) {
                cancellableContinuation = this.Z;
                a2 = ChannelResult.b(ChannelResult.f29243b.a(closed.Z));
                Result.Companion companion = Result.X;
            } else {
                cancellableContinuation = this.Z;
                Result.Companion companion2 = Result.X;
                a2 = ResultKt.a(closed.e1());
            }
            cancellableContinuation.w(Result.b(a2));
        }

        @Nullable
        public final Object a1(E e2) {
            return this.X2 == 1 ? ChannelResult.b(ChannelResult.f29243b.c(e2)) : e2;
        }

        public void c0(E e2) {
            this.Z.u0(CancellableContinuationImplKt.f29156d);
        }

        @Nullable
        public Symbol n0(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            if (this.Z.P(a1(e2), prepareOp != null ? prepareOp.f29361c : null, Y0(e2)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.d();
            }
            return CancellableContinuationImplKt.f29156d;
        }

        @NotNull
        public String toString() {
            return "ReceiveElement@" + DebugStringsKt.b(this) + "[receiveMode=" + this.X2 + ']';
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00028\u0001`\n¢\u0006\u0004\b\f\u0010\rJ%\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00028\u0001`\n8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "", "receiveMode", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlinx/coroutines/CancellableContinuation;ILkotlin/jvm/functions/Function1;)V", "value", "", "Y0", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Y2", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class ReceiveElementWithUndeliveredHandler<E> extends ReceiveElement<E> {
        @NotNull
        @JvmField
        public final Function1<E, Unit> Y2;

        public ReceiveElementWithUndeliveredHandler(@NotNull CancellableContinuation<Object> cancellableContinuation, int i2, @NotNull Function1<? super E, Unit> function1) {
            super(cancellableContinuation, i2);
            this.Y2 = function1;
        }

        @Nullable
        public Function1<Throwable, Unit> Y0(E e2) {
            return OnUndeliveredElementKt.a(this.Y2, e2, this.Z.g());
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u00020\u00102\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00172\u0006\u0010\n\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00038\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "iterator", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "n0", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "c0", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "Lkotlin/Function1;", "", "Y0", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "()Ljava/lang/String;", "Z", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "X2", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class ReceiveHasNext<E> extends Receive<E> {
        @NotNull
        @JvmField
        public final CancellableContinuation<Boolean> X2;
        @NotNull
        @JvmField
        public final Itr<E> Z;

        public ReceiveHasNext(@NotNull Itr<E> itr, @NotNull CancellableContinuation<? super Boolean> cancellableContinuation) {
            this.Z = itr;
            this.X2 = cancellableContinuation;
        }

        @Nullable
        public Function1<Throwable, Unit> Y0(E e2) {
            Function1<E, Unit> function1 = this.Z.f29222a.s;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e2, this.X2.g());
            }
            return null;
        }

        public void Z0(@NotNull Closed<?> closed) {
            Object b2 = closed.Z == null ? CancellableContinuation.DefaultImpls.b(this.X2, Boolean.FALSE, (Object) null, 2, (Object) null) : this.X2.N(closed.e1());
            if (b2 != null) {
                this.Z.g(closed);
                this.X2.u0(b2);
            }
        }

        public void c0(E e2) {
            this.Z.g(e2);
            this.X2.u0(CancellableContinuationImplKt.f29156d);
        }

        @Nullable
        public Symbol n0(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            if (this.X2.P(Boolean.TRUE, prepareOp != null ? prepareOp.f29361c : null, Y0(e2)) == null) {
                return null;
            }
            if (prepareOp != null) {
                prepareOp.d();
            }
            return CancellableContinuationImplKt.f29156d;
        }

        @NotNull
        public String toString() {
            return "ReceiveHasNext@" + DebugStringsKt.b(this);
        }
    }

    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u00028\u00020\u00032\u00020\u0004BT\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012$\u0010\f\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00028\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00172\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ%\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0017\u0018\u00010 2\u0006\u0010\u0011\u001a\u00028\u0002H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\b%\u0010&R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00058\u0006X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00078\u0006X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R5\u0010\f\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0004¢\u0006\u0006\n\u0004\b-\u0010.\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", "E", "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/channels/AbstractChannel;", "channel", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "block", "", "receiveMode", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "value", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "n0", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "c0", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "m", "()V", "Lkotlin/Function1;", "", "Y0", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "", "toString", "()Ljava/lang/String;", "Z", "Lkotlinx/coroutines/channels/AbstractChannel;", "X2", "Lkotlinx/coroutines/selects/SelectInstance;", "Y2", "Lkotlin/jvm/functions/Function2;", "Z2", "I", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        @NotNull
        @JvmField
        public final SelectInstance<R> X2;
        @NotNull
        @JvmField
        public final Function2<Object, Continuation<? super R>, Object> Y2;
        @NotNull
        @JvmField
        public final AbstractChannel<E> Z;
        @JvmField
        public final int Z2;

        public ReceiveSelect(@NotNull AbstractChannel<E> abstractChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
            this.Z = abstractChannel;
            this.X2 = selectInstance;
            this.Y2 = function2;
            this.Z2 = i2;
        }

        @Nullable
        public Function1<Throwable, Unit> Y0(E e2) {
            Function1<E, Unit> function1 = this.Z.s;
            if (function1 != null) {
                return OnUndeliveredElementKt.a(function1, e2, this.X2.J().g());
            }
            return null;
        }

        public void Z0(@NotNull Closed<?> closed) {
            if (this.X2.y()) {
                int i2 = this.Z2;
                if (i2 == 0) {
                    this.X2.g0(closed.e1());
                } else if (i2 == 1) {
                    CancellableKt.f(this.Y2, ChannelResult.b(ChannelResult.f29243b.a(closed.Z)), this.X2.J(), (Function1) null, 4, (Object) null);
                }
            }
        }

        public void c0(E e2) {
            CancellableKt.e(this.Y2, this.Z2 == 1 ? ChannelResult.b(ChannelResult.f29243b.c(e2)) : e2, this.X2.J(), Y0(e2));
        }

        public void m() {
            if (Q0()) {
                this.Z.k0();
            }
        }

        @Nullable
        public Symbol n0(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.X2.i(prepareOp);
        }

        @NotNull
        public String toString() {
            return "ReceiveSelect@" + DebugStringsKt.b(this) + '[' + this.X2 + ",receiveMode=" + this.Z2 + ']';
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "Lkotlinx/coroutines/channels/Receive;", "receive", "<init>", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "", "cause", "", "b", "(Ljava/lang/Throwable;)V", "", "toString", "()Ljava/lang/String;", "s", "Lkotlinx/coroutines/channels/Receive;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private final class RemoveReceiveOnCancel extends BeforeResumeCancelHandler {
        @NotNull
        private final Receive<?> s;

        public RemoveReceiveOnCancel(@NotNull Receive<?> receive) {
            this.s = receive;
        }

        public void b(@Nullable Throwable th) {
            if (this.s.Q0()) {
                AbstractChannel.this.k0();
            }
        }

        public /* bridge */ /* synthetic */ Object f(Object obj) {
            b((Throwable) obj);
            return Unit.f28779a;
        }

        @NotNull
        public String toString() {
            return "RemoveReceiveOnCancel[" + this.s + ']';
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "", "k", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    protected static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public TryPollDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof Send)) {
                return AbstractChannelKt.f29229f;
            }
            return null;
        }

        @Nullable
        public Object j(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol a1 = ((Send) prepareOp.f29359a).a1(prepareOp);
            if (a1 == null) {
                return LockFreeLinkedList_commonKt.f29366a;
            }
            Object obj = AtomicKt.f29332b;
            if (a1 == obj) {
                return obj;
            }
            return null;
        }

        public void k(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            ((Send) lockFreeLinkedListNode).b1();
        }
    }

    public AbstractChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: private */
    public final boolean Z(Receive<? super E> receive) {
        boolean a0 = a0(receive);
        if (a0) {
            l0();
        }
        return a0;
    }

    private final <R> boolean b0(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i2) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i2);
        boolean Z = Z(receiveSelect);
        if (Z) {
            selectInstance.p0(receiveSelect);
        }
        return Z;
    }

    /* access modifiers changed from: private */
    public final <R> Object o0(int i2, Continuation<? super R> continuation) {
        CancellableContinuationImpl<? super R> b2 = CancellableContinuationKt.b(IntrinsicsKt.e(continuation));
        ReceiveElement receiveElement = this.s == null ? new ReceiveElement(b2, i2) : new ReceiveElementWithUndeliveredHandler(b2, i2, this.s);
        while (true) {
            if (!Z(receiveElement)) {
                Object m0 = m0();
                if (!(m0 instanceof Closed)) {
                    if (m0 != AbstractChannelKt.f29229f) {
                        b2.f0(receiveElement.a1(m0), receiveElement.Y0(m0));
                        break;
                    }
                } else {
                    receiveElement.Z0((Closed) m0);
                    break;
                }
            } else {
                q0(b2, receiveElement);
                break;
            }
        }
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y;
    }

    /* access modifiers changed from: private */
    public final <R> void p0(SelectInstance<? super R> selectInstance, int i2, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.I()) {
            if (!f0()) {
                Object n0 = n0(selectInstance);
                if (n0 != SelectKt.d()) {
                    if (!(n0 == AbstractChannelKt.f29229f || n0 == AtomicKt.f29332b)) {
                        r0(function2, selectInstance, i2, n0);
                    }
                } else {
                    return;
                }
            } else if (b0(selectInstance, function2, i2)) {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void q0(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.M(new RemoveReceiveOnCancel(receive));
    }

    private final <R> void r0(Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, SelectInstance<? super R> selectInstance, int i2, Object obj) {
        Object obj2;
        ChannelResult.Companion companion;
        boolean z = obj instanceof Closed;
        if (z) {
            if (i2 == 0) {
                throw StackTraceRecoveryKt.p(((Closed) obj).e1());
            } else if (i2 == 1 && selectInstance.y()) {
                companion = ChannelResult.f29243b;
            } else {
                return;
            }
        } else if (i2 == 1) {
            companion = ChannelResult.f29243b;
            if (!z) {
                obj2 = companion.c(obj);
                UndispatchedKt.d(function2, ChannelResult.b(obj2), selectInstance.J());
            }
        } else {
            UndispatchedKt.d(function2, obj, selectInstance.J());
            return;
        }
        obj2 = companion.a(((Closed) obj).Z);
        UndispatchedKt.d(function2, ChannelResult.b(obj2), selectInstance.J());
    }

    @NotNull
    public final Object B() {
        Object m0 = m0();
        if (m0 == AbstractChannelKt.f29229f) {
            return ChannelResult.f29243b.b();
        }
        return m0 instanceof Closed ? ChannelResult.f29243b.a(((Closed) m0).Z) : ChannelResult.f29243b.c(m0);
    }

    @Nullable
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", imports = {}))
    @LowPriorityInOverloadResolution
    public Object D(@NotNull Continuation<? super E> continuation) {
        return Channel.DefaultImpls.e(this, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object E(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = (kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1) r0
            int r1 = r0.Y2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Y2 = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1 r0 = new kotlinx.coroutines.channels.AbstractChannel$receiveCatching$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.Z
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Y2
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.n(r5)
            goto L_0x005b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.n(r5)
            java.lang.Object r5 = r4.m0()
            kotlinx.coroutines.internal.Symbol r2 = kotlinx.coroutines.channels.AbstractChannelKt.f29229f
            if (r5 == r2) goto L_0x0052
            boolean r0 = r5 instanceof kotlinx.coroutines.channels.Closed
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f29243b
            kotlinx.coroutines.channels.Closed r5 = (kotlinx.coroutines.channels.Closed) r5
            java.lang.Throwable r5 = r5.Z
            java.lang.Object r5 = r0.a(r5)
            goto L_0x0051
        L_0x004b:
            kotlinx.coroutines.channels.ChannelResult$Companion r0 = kotlinx.coroutines.channels.ChannelResult.f29243b
            java.lang.Object r5 = r0.c(r5)
        L_0x0051:
            return r5
        L_0x0052:
            r0.Y2 = r3
            java.lang.Object r5 = r4.o0(r3, r0)
            if (r5 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlinx.coroutines.channels.ChannelResult r5 = (kotlinx.coroutines.channels.ChannelResult) r5
            java.lang.Object r5 = r5.o()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.E(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ReceiveOrClosed<E> M() {
        ReceiveOrClosed<E> M = super.M();
        if (M != null && !(M instanceof Closed)) {
            k0();
        }
        return M;
    }

    @Nullable
    public final Object Q(@NotNull Continuation<? super E> continuation) {
        Object m0 = m0();
        return (m0 == AbstractChannelKt.f29229f || (m0 instanceof Closed)) ? o0(0, continuation) : m0;
    }

    /* renamed from: U */
    public final boolean d(@Nullable Throwable th) {
        boolean T = T(th);
        h0(T);
        return T;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final TryPollDesc<E> W() {
        return new TryPollDesc<>(r());
    }

    /* access modifiers changed from: protected */
    public boolean a0(@NotNull Receive<? super E> receive) {
        int V0;
        LockFreeLinkedListNode K0;
        if (d0()) {
            LockFreeLinkedListHead r = r();
            do {
                K0 = r.K0();
                if (!(!(K0 instanceof Send))) {
                    return false;
                }
            } while (!K0.B0(receive, r));
        } else {
            LockFreeLinkedListHead r2 = r();
            AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 = new AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(receive, this);
            do {
                LockFreeLinkedListNode K02 = r2.K0();
                if (!(!(K02 instanceof Send))) {
                    return false;
                }
                V0 = K02.V0(receive, r2, abstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1);
                if (V0 != 1) {
                }
            } while (V0 != 2);
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean c0() {
        return r().J0() instanceof ReceiveOrClosed;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        i((CancellationException) null);
    }

    /* access modifiers changed from: protected */
    public abstract boolean d0();

    /* access modifiers changed from: protected */
    public abstract boolean e0();

    /* access modifiers changed from: protected */
    public final boolean f0() {
        return !(r().J0() instanceof Send) && e0();
    }

    /* access modifiers changed from: protected */
    public void h0(boolean z) {
        Closed<?> q = q();
        if (q != null) {
            Object c2 = InlineList.c((Object) null, 1, (DefaultConstructorMarker) null);
            while (true) {
                LockFreeLinkedListNode K0 = q.K0();
                if (K0 instanceof LockFreeLinkedListHead) {
                    j0(c2, q);
                    return;
                } else if (!K0.Q0()) {
                    K0.L0();
                } else {
                    c2 = InlineList.h(c2, (Send) K0);
                }
            }
        } else {
            throw new IllegalStateException("Cannot happen".toString());
        }
    }

    public final void i(@Nullable CancellationException cancellationException) {
        if (!l()) {
            if (cancellationException == null) {
                cancellationException = new CancellationException(DebugStringsKt.a(this) + " was cancelled");
            }
            d(cancellationException);
        }
    }

    public boolean isEmpty() {
        return f0();
    }

    @NotNull
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    /* access modifiers changed from: protected */
    public void j0(@NotNull Object obj, @NotNull Closed<?> closed) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            ((Send) obj).Z0(closed);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 < size) {
                ((Send) arrayList.get(size)).Z0(closed);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k0() {
    }

    public boolean l() {
        return p() != null && e0();
    }

    /* access modifiers changed from: protected */
    public void l0() {
    }

    @NotNull
    public final SelectClause1<E> m() {
        return new AbstractChannel$onReceive$1(this);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object m0() {
        while (true) {
            Send N = N();
            if (N == null) {
                return AbstractChannelKt.f29229f;
            }
            if (N.a1((LockFreeLinkedListNode.PrepareOp) null) != null) {
                N.X0();
                return N.Y0();
            }
            N.b1();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object n0(@NotNull SelectInstance<?> selectInstance) {
        TryPollDesc W = W();
        Object i0 = selectInstance.i0(W);
        if (i0 != null) {
            return i0;
        }
        ((Send) W.o()).X0();
        return ((Send) W.o()).Y0();
    }

    @NotNull
    public final SelectClause1<ChannelResult<E>> o() {
        return new AbstractChannel$onReceiveCatching$1(this);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", imports = {}))
    @Nullable
    public E poll() {
        return Channel.DefaultImpls.d(this);
    }

    @NotNull
    public SelectClause1<E> z() {
        return Channel.DefaultImpls.b(this);
    }
}
