package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00028\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\r2\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010!\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#¨\u0006'"}, d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "", "closeCause", "<init>", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "a1", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "", "X0", "()V", "value", "n0", "(Ljava/lang/Object;Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "c0", "(Ljava/lang/Object;)V", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Z", "Ljava/lang/Throwable;", "f1", "()Ljava/lang/Throwable;", "sendException", "e1", "receiveException", "c1", "()Lkotlinx/coroutines/channels/Closed;", "offerResult", "d1", "pollResult", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    @Nullable
    @JvmField
    public final Throwable Z;

    public Closed(@Nullable Throwable th) {
        this.Z = th;
    }

    public void X0() {
    }

    public void Z0(@NotNull Closed<?> closed) {
    }

    @NotNull
    public Symbol a1(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f29156d;
        if (prepareOp != null) {
            prepareOp.d();
        }
        return symbol;
    }

    public void c0(E e2) {
    }

    @NotNull
    /* renamed from: c1 */
    public Closed<E> v() {
        return this;
    }

    @NotNull
    /* renamed from: d1 */
    public Closed<E> Y0() {
        return this;
    }

    @NotNull
    public final Throwable e1() {
        Throwable th = this.Z;
        return th == null ? new ClosedReceiveChannelException(ChannelsKt.f29247a) : th;
    }

    @NotNull
    public final Throwable f1() {
        Throwable th = this.Z;
        return th == null ? new ClosedSendChannelException(ChannelsKt.f29247a) : th;
    }

    @NotNull
    public Symbol n0(E e2, @Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
        Symbol symbol = CancellableContinuationImplKt.f29156d;
        if (prepareOp != null) {
            prepareOp.d();
        }
        return symbol;
    }

    @NotNull
    public String toString() {
        return "Closed@" + DebugStringsKt.b(this) + '[' + this.Z + ']';
    }
}
