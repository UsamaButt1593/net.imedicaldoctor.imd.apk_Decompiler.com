package kotlinx.coroutines.channels;

import androidx.concurrent.futures.a;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.LockFreeLinkedList_commonKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004ijklB)\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u00020\u000b2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0014\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJX\u0010!\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u001b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c2\u0006\u0010\u000e\u001a\u00028\u00002(\u0010 \u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001eH\u0002ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0004\b&\u0010'J#\u0010(\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00028\u00002\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001cH\u0014¢\u0006\u0004\b(\u0010)J\u0011\u0010+\u001a\u0004\u0018\u00010*H\u0004¢\u0006\u0004\b+\u0010,J\u001d\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010-2\u0006\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b.\u0010/J#\u00102\u001a\u000e\u0012\u0002\b\u000300j\u0006\u0012\u0002\b\u0003`12\u0006\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b4\u0010\u0012J\u0017\u00106\u001a\u0002052\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b6\u00107J$\u00109\u001a\b\u0012\u0004\u0012\u00020\u0004082\u0006\u0010\u000e\u001a\u00028\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b9\u0010'J\u0019\u0010;\u001a\u0004\u0018\u00010\u001f2\u0006\u0010:\u001a\u00020*H\u0014¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u0002052\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b=\u0010>J)\u0010A\u001a\u00020\u00042\u0018\u0010@\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`?H\u0016¢\u0006\u0004\bA\u0010\bJ\u0017\u0010C\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020BH\u0014¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010-H\u0014¢\u0006\u0004\bE\u0010FJ\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000G2\u0006\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\bH\u0010IJ\u000f\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bK\u0010LR.\u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00058\u0004X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u001a\u0010S\u001a\u00020O8\u0004X\u0004¢\u0006\f\n\u0004\bA\u0010P\u001a\u0004\bQ\u0010RR\u0014\u0010V\u001a\u0002058BX\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010W\u001a\u00020J8BX\u0004¢\u0006\u0006\u001a\u0004\bM\u0010LR\u0014\u0010Y\u001a\u0002058$X¤\u0004¢\u0006\u0006\u001a\u0004\bX\u0010UR\u0014\u0010[\u001a\u0002058$X¤\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010UR\u001a\u0010^\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u001a\u0010`\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8DX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010]R\u0011\u0010b\u001a\u0002058F¢\u0006\u0006\u001a\u0004\ba\u0010UR#\u0010f\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020c8F¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020J8TX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010L\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006m"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "v", "(Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "element", "u", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)Ljava/lang/Throwable;", "L", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "w", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "cause", "x", "(Ljava/lang/Throwable;)V", "t", "(Lkotlinx/coroutines/channels/Closed;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "", "block", "J", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "", "g", "()I", "F", "(Ljava/lang/Object;)Ljava/lang/Object;", "H", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/Send;", "N", "()Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "K", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/internal/AddLastDesc;", "h", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "g0", "", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ChannelResult;", "Y", "send", "k", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "T", "(Ljava/lang/Throwable;)Z", "Lkotlinx/coroutines/channels/Handler;", "handler", "X", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "I", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "M", "()Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "j", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "", "toString", "()Ljava/lang/String;", "s", "Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "r", "()Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "C", "()Z", "isFullImpl", "queueDebugStateString", "y", "isBufferAlwaysFull", "A", "isBufferFull", "q", "()Lkotlinx/coroutines/channels/Closed;", "closedForSend", "p", "closedForReceive", "i0", "isClosedForSend", "Lkotlinx/coroutines/selects/SelectClause2;", "G", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "n", "bufferDebugString", "SendBuffered", "SendBufferedDesc", "SendSelect", "TryOfferDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class AbstractSendChannel<E> implements SendChannel<E> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater Y = AtomicReferenceFieldUpdater.newUpdater(AbstractSendChannel.class, Object.class, "onCloseHandler");
    @NotNull
    private final LockFreeLinkedListHead X = new LockFreeLinkedListHead();
    @NotNull
    private volatile /* synthetic */ Object onCloseHandler = null;
    @Nullable
    @JvmField
    protected final Function1<E, Unit> s;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "E", "Lkotlinx/coroutines/channels/Send;", "element", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "a1", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "X0", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Z", "Ljava/lang/Object;", "", "Y0", "()Ljava/lang/Object;", "pollResult", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class SendBuffered<E> extends Send {
        @JvmField
        public final E Z;

        public SendBuffered(E e2) {
            this.Z = e2;
        }

        public void X0() {
        }

        @Nullable
        public Object Y0() {
            return this.Z;
        }

        public void Z0(@NotNull Closed<?> closed) {
        }

        @Nullable
        public Symbol a1(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol symbol = CancellableContinuationImplKt.f29156d;
            if (prepareOp != null) {
                prepareOp.d();
            }
            return symbol;
        }

        @NotNull
        public String toString() {
            return "SendBuffered@" + DebugStringsKt.b(this) + ASCIIPropertyListParser.f18649g + this.Z + ASCIIPropertyListParser.f18650h;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0012\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00028\u0001¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendBufferedDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$AddLastDesc;", "Lkotlinx/coroutines/channels/AbstractSendChannel$SendBuffered;", "Lkotlinx/coroutines/internal/AddLastDesc;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "element", "<init>", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;Ljava/lang/Object;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static class SendBufferedDesc<E> extends LockFreeLinkedListNode.AddLastDesc<SendBuffered<? extends E>> {
        public SendBufferedDesc(@NotNull LockFreeLinkedListHead lockFreeLinkedListHead, E e2) {
            super(lockFreeLinkedListHead, new SendBuffered(e2));
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (lockFreeLinkedListNode instanceof ReceiveOrClosed) {
                return AbstractChannelKt.f29228e;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\u00020\u00032\u00020\u0004BX\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b\u0012(\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u00162\n\u0010\u001b\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u0018J\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010\u0005\u001a\u00028\u00018\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068\u0006X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R9\u0010\u000e\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\n8\u0006X\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b*\u0010+\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$SendSelect;", "E", "R", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/DisposableHandle;", "pollResult", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "channel", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/AbstractSendChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "a1", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "X0", "()V", "m", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "b1", "", "toString", "()Ljava/lang/String;", "Z", "Ljava/lang/Object;", "Y0", "()Ljava/lang/Object;", "X2", "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Y2", "Lkotlinx/coroutines/selects/SelectInstance;", "Z2", "Lkotlin/jvm/functions/Function2;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    private static final class SendSelect<E, R> extends Send implements DisposableHandle {
        @NotNull
        @JvmField
        public final AbstractSendChannel<E> X2;
        @NotNull
        @JvmField
        public final SelectInstance<R> Y2;
        private final E Z;
        @NotNull
        @JvmField
        public final Function2<SendChannel<? super E>, Continuation<? super R>, Object> Z2;

        public SendSelect(E e2, @NotNull AbstractSendChannel<E> abstractSendChannel, @NotNull SelectInstance<? super R> selectInstance, @NotNull Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
            this.Z = e2;
            this.X2 = abstractSendChannel;
            this.Y2 = selectInstance;
            this.Z2 = function2;
        }

        public void X0() {
            CancellableKt.f(this.Z2, this.X2, this.Y2.J(), (Function1) null, 4, (Object) null);
        }

        public E Y0() {
            return this.Z;
        }

        public void Z0(@NotNull Closed<?> closed) {
            if (this.Y2.y()) {
                this.Y2.g0(closed.f1());
            }
        }

        @Nullable
        public Symbol a1(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
            return (Symbol) this.Y2.i(prepareOp);
        }

        public void b1() {
            Function1<E, Unit> function1 = this.X2.s;
            if (function1 != null) {
                OnUndeliveredElementKt.b(function1, Y0(), this.Y2.J().g());
            }
        }

        public void m() {
            if (Q0()) {
                b1();
            }
        }

        @NotNull
        public String toString() {
            return "SendSelect@" + DebugStringsKt.b(this) + ASCIIPropertyListParser.f18649g + Y0() + ")[" + this.X2 + ", " + this.Y2 + ']';
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003`\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u0004\u0018\u00010\f2\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00028\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/channels/AbstractSendChannel$TryOfferDesc;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "element", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "queue", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "affected", "", "e", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "Lkotlinx/coroutines/internal/PrepareOp;", "prepareOp", "j", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Ljava/lang/Object;", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    protected static final class TryOfferDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<ReceiveOrClosed<? super E>> {
        @JvmField

        /* renamed from: e  reason: collision with root package name */
        public final E f29233e;

        public TryOfferDesc(E e2, @NotNull LockFreeLinkedListHead lockFreeLinkedListHead) {
            super(lockFreeLinkedListHead);
            this.f29233e = e2;
        }

        /* access modifiers changed from: protected */
        @Nullable
        public Object e(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
            if (lockFreeLinkedListNode instanceof Closed) {
                return lockFreeLinkedListNode;
            }
            if (!(lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                return AbstractChannelKt.f29228e;
            }
            return null;
        }

        @Nullable
        public Object j(@NotNull LockFreeLinkedListNode.PrepareOp prepareOp) {
            Symbol n0 = ((ReceiveOrClosed) prepareOp.f29359a).n0(this.f29233e, prepareOp);
            if (n0 == null) {
                return LockFreeLinkedList_commonKt.f29366a;
            }
            Object obj = AtomicKt.f29332b;
            if (n0 == obj) {
                return obj;
            }
            return null;
        }
    }

    public AbstractSendChannel(@Nullable Function1<? super E, Unit> function1) {
        this.s = function1;
    }

    /* access modifiers changed from: private */
    public final boolean C() {
        return !(this.X.J0() instanceof ReceiveOrClosed) && A();
    }

    /* access modifiers changed from: private */
    public final <R> void J(SelectInstance<? super R> selectInstance, E e2, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.I()) {
            if (C()) {
                SendSelect sendSelect = new SendSelect(e2, this, selectInstance, function2);
                Object k2 = k(sendSelect);
                if (k2 == null) {
                    selectInstance.p0(sendSelect);
                    return;
                } else if (k2 instanceof Closed) {
                    throw StackTraceRecoveryKt.p(u(e2, (Closed) k2));
                } else if (k2 != AbstractChannelKt.f29230g && !(k2 instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + k2 + ' ').toString());
                }
            }
            Object H = H(e2, selectInstance);
            if (H != SelectKt.d()) {
                if (H != AbstractChannelKt.f29228e && H != AtomicKt.f29332b) {
                    if (H == AbstractChannelKt.f29227d) {
                        UndispatchedKt.d(function2, this, selectInstance.J());
                        return;
                    } else if (H instanceof Closed) {
                        throw StackTraceRecoveryKt.p(u(e2, (Closed) H));
                    } else {
                        throw new IllegalStateException(("offerSelectInternal returned " + H).toString());
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object L(E e2, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl<? super Unit> b2 = CancellableContinuationKt.b(IntrinsicsKt.e(continuation));
        while (true) {
            if (C()) {
                Send sendElement = this.s == null ? new SendElement(e2, b2) : new SendElementWithUndeliveredHandler(e2, b2, this.s);
                Object k2 = k(sendElement);
                if (k2 == null) {
                    CancellableContinuationKt.c(b2, sendElement);
                    break;
                } else if (k2 instanceof Closed) {
                    w(b2, e2, (Closed) k2);
                    break;
                } else if (k2 != AbstractChannelKt.f29230g && !(k2 instanceof Receive)) {
                    throw new IllegalStateException(("enqueueSend returned " + k2).toString());
                }
            }
            Object F = F(e2);
            if (F == AbstractChannelKt.f29227d) {
                Result.Companion companion = Result.X;
                b2.w(Result.b(Unit.f28779a));
                break;
            } else if (F != AbstractChannelKt.f29228e) {
                if (F instanceof Closed) {
                    w(b2, e2, (Closed) F);
                } else {
                    throw new IllegalStateException(("offerInternal returned " + F).toString());
                }
            }
        }
        Object y = b2.y();
        if (y == IntrinsicsKt.l()) {
            DebugProbesKt.c(continuation);
        }
        return y == IntrinsicsKt.l() ? y : Unit.f28779a;
    }

    private final int g() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
        int i2 = 0;
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.I0(); !Intrinsics.g(lockFreeLinkedListNode, lockFreeLinkedListHead); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                i2++;
            }
        }
        return i2;
    }

    private final String s() {
        String str;
        LockFreeLinkedListNode J0 = this.X.J0();
        if (J0 == this.X) {
            return "EmptyQueue";
        }
        if (J0 instanceof Closed) {
            str = J0.toString();
        } else if (J0 instanceof Receive) {
            str = "ReceiveQueued";
        } else if (J0 instanceof Send) {
            str = "SendQueued";
        } else {
            str = "UNEXPECTED:" + J0;
        }
        LockFreeLinkedListNode K0 = this.X.K0();
        if (K0 == J0) {
            return str;
        }
        String str2 = str + ",queueSize=" + g();
        if (!(K0 instanceof Closed)) {
            return str2;
        }
        return str2 + ",closedForSend=" + K0;
    }

    private final void t(Closed<?> closed) {
        Object c2 = InlineList.c((Object) null, 1, (DefaultConstructorMarker) null);
        while (true) {
            LockFreeLinkedListNode K0 = closed.K0();
            Receive receive = K0 instanceof Receive ? (Receive) K0 : null;
            if (receive == null) {
                break;
            } else if (!receive.Q0()) {
                receive.L0();
            } else {
                c2 = InlineList.h(c2, receive);
            }
        }
        if (c2 != null) {
            if (!(c2 instanceof ArrayList)) {
                ((Receive) c2).Z0(closed);
            } else {
                ArrayList arrayList = (ArrayList) c2;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((Receive) arrayList.get(size)).Z0(closed);
                }
            }
        }
        I(closed);
    }

    private final Throwable u(E e2, Closed<?> closed) {
        UndeliveredElementException d2;
        t(closed);
        Function1<E, Unit> function1 = this.s;
        if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            return closed.f1();
        }
        ExceptionsKt.a(d2, closed.f1());
        throw d2;
    }

    private final Throwable v(Closed<?> closed) {
        t(closed);
        return closed.f1();
    }

    /* access modifiers changed from: private */
    public final void w(Continuation<?> continuation, E e2, Closed<?> closed) {
        Object a2;
        UndeliveredElementException d2;
        t(closed);
        Throwable f1 = closed.f1();
        Function1<E, Unit> function1 = this.s;
        if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, (UndeliveredElementException) null, 2, (Object) null)) == null) {
            Result.Companion companion = Result.X;
            a2 = ResultKt.a(f1);
        } else {
            ExceptionsKt.a(d2, f1);
            Result.Companion companion2 = Result.X;
            a2 = ResultKt.a(d2);
        }
        continuation.w(Result.b(a2));
    }

    private final void x(Throwable th) {
        Symbol symbol;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (symbol = AbstractChannelKt.f29231h) && a.a(Y, this, obj, symbol)) {
            ((Function1) TypeIntrinsics.q(obj, 1)).f(th);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean A();

    /* access modifiers changed from: protected */
    @NotNull
    public Object F(E e2) {
        ReceiveOrClosed M;
        do {
            M = M();
            if (M == null) {
                return AbstractChannelKt.f29228e;
            }
        } while (M.n0(e2, (LockFreeLinkedListNode.PrepareOp) null) == null);
        M.c0(e2);
        return M.v();
    }

    @NotNull
    public final SelectClause2<E, SendChannel<E>> G() {
        return new AbstractSendChannel$onSend$1(this);
    }

    /* access modifiers changed from: protected */
    @NotNull
    public Object H(E e2, @NotNull SelectInstance<?> selectInstance) {
        TryOfferDesc j2 = j(e2);
        Object i0 = selectInstance.i0(j2);
        if (i0 != null) {
            return i0;
        }
        ReceiveOrClosed receiveOrClosed = (ReceiveOrClosed) j2.o();
        receiveOrClosed.c0(e2);
        return receiveOrClosed.v();
    }

    /* access modifiers changed from: protected */
    public void I(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final ReceiveOrClosed<?> K(E e2) {
        LockFreeLinkedListNode K0;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
        SendBuffered sendBuffered = new SendBuffered(e2);
        do {
            K0 = lockFreeLinkedListHead.K0();
            if (K0 instanceof ReceiveOrClosed) {
                return (ReceiveOrClosed) K0;
            }
        } while (!K0.B0(sendBuffered, lockFreeLinkedListHead));
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ReceiveOrClosed<E> M() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode T0;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.I0();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof ReceiveOrClosed)) {
                if (((((ReceiveOrClosed) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.N0()) || (T0 = lockFreeLinkedListNode.T0()) == null) {
                    break;
                }
                T0.M0();
            }
        }
        lockFreeLinkedListNode = null;
        return (ReceiveOrClosed) lockFreeLinkedListNode;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Send N() {
        LockFreeLinkedListNode lockFreeLinkedListNode;
        LockFreeLinkedListNode T0;
        LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
        while (true) {
            lockFreeLinkedListNode = (LockFreeLinkedListNode) lockFreeLinkedListHead.I0();
            if (lockFreeLinkedListNode != lockFreeLinkedListHead && (lockFreeLinkedListNode instanceof Send)) {
                if (((((Send) lockFreeLinkedListNode) instanceof Closed) && !lockFreeLinkedListNode.N0()) || (T0 = lockFreeLinkedListNode.T0()) == null) {
                    break;
                }
                T0.M0();
            }
        }
        lockFreeLinkedListNode = null;
        return (Send) lockFreeLinkedListNode;
    }

    public boolean T(@Nullable Throwable th) {
        boolean z;
        Closed closed = new Closed(th);
        LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
        while (true) {
            LockFreeLinkedListNode K0 = lockFreeLinkedListHead.K0();
            z = true;
            if (!(K0 instanceof Closed)) {
                if (K0.B0(closed, lockFreeLinkedListHead)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (!z) {
            closed = (Closed) this.X.K0();
        }
        t(closed);
        if (z) {
            x(th);
        }
        return z;
    }

    public void X(@NotNull Function1<? super Throwable, Unit> function1) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = Y;
        if (!a.a(atomicReferenceFieldUpdater, this, (Object) null, function1)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.f29231h) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Closed<?> q = q();
        if (q != null && a.a(atomicReferenceFieldUpdater, this, function1, AbstractChannelKt.f29231h)) {
            function1.f(q.Z);
        }
    }

    @NotNull
    public final Object Y(E e2) {
        ChannelResult.Companion companion;
        Closed<?> closed;
        Object F = F(e2);
        if (F == AbstractChannelKt.f29227d) {
            return ChannelResult.f29243b.c(Unit.f28779a);
        }
        if (F == AbstractChannelKt.f29228e) {
            closed = q();
            if (closed == null) {
                return ChannelResult.f29243b.b();
            }
            companion = ChannelResult.f29243b;
        } else if (F instanceof Closed) {
            companion = ChannelResult.f29243b;
            closed = (Closed) F;
        } else {
            throw new IllegalStateException(("trySend returned " + F).toString());
        }
        return companion.a(v(closed));
    }

    @Nullable
    public final Object g0(E e2, @NotNull Continuation<? super Unit> continuation) {
        if (F(e2) == AbstractChannelKt.f29227d) {
            return Unit.f28779a;
        }
        Object L = L(e2, continuation);
        return L == IntrinsicsKt.l() ? L : Unit.f28779a;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final LockFreeLinkedListNode.AddLastDesc<?> h(E e2) {
        return new SendBufferedDesc(this.X, e2);
    }

    public final boolean i0() {
        return q() != null;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final TryOfferDesc<E> j(E e2) {
        return new TryOfferDesc<>(e2, this.X);
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Object k(@NotNull Send send) {
        int V0;
        LockFreeLinkedListNode K0;
        if (y()) {
            LockFreeLinkedListHead lockFreeLinkedListHead = this.X;
            do {
                K0 = lockFreeLinkedListHead.K0();
                if (K0 instanceof ReceiveOrClosed) {
                    return K0;
                }
            } while (!K0.B0(send, lockFreeLinkedListHead));
            return null;
        }
        LockFreeLinkedListHead lockFreeLinkedListHead2 = this.X;
        AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1 = new AbstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1(send, this);
        do {
            LockFreeLinkedListNode K02 = lockFreeLinkedListHead2.K0();
            if (K02 instanceof ReceiveOrClosed) {
                return K02;
            }
            V0 = K02.V0(send, lockFreeLinkedListHead2, abstractSendChannel$enqueueSend$$inlined$addLastIfPrevAndIf$1);
            if (V0 == 1) {
                return null;
            }
        } while (V0 != 2);
        return AbstractChannelKt.f29230g;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public String n() {
        return "";
    }

    public boolean offer(E e2) {
        UndeliveredElementException d2;
        try {
            return SendChannel.DefaultImpls.c(this, e2);
        } catch (Throwable th) {
            Function1<E, Unit> function1 = this.s;
            if (function1 == null || (d2 = OnUndeliveredElementKt.d(function1, e2, (UndeliveredElementException) null, 2, (Object) null)) == null) {
                throw th;
            }
            ExceptionsKt.a(d2, th);
            throw d2;
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Closed<?> p() {
        LockFreeLinkedListNode J0 = this.X.J0();
        Closed<?> closed = J0 instanceof Closed ? (Closed) J0 : null;
        if (closed == null) {
            return null;
        }
        t(closed);
        return closed;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Closed<?> q() {
        LockFreeLinkedListNode K0 = this.X.K0();
        Closed<?> closed = K0 instanceof Closed ? (Closed) K0 : null;
        if (closed == null) {
            return null;
        }
        t(closed);
        return closed;
    }

    /* access modifiers changed from: protected */
    @NotNull
    public final LockFreeLinkedListHead r() {
        return this.X;
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + ASCIIPropertyListParser.f18652j + s() + ASCIIPropertyListParser.f18653k + n();
    }

    /* access modifiers changed from: protected */
    public abstract boolean y();
}
