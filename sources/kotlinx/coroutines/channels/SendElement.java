package kotlinx.coroutines.channels;

import com.dd.plist.ASCIIPropertyListParser;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImplKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0012\u001a\u00020\u00052\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00028\u00008\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/channels/SendElement;", "E", "Lkotlinx/coroutines/channels/Send;", "pollResult", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;", "otherOp", "Lkotlinx/coroutines/internal/Symbol;", "a1", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode$PrepareOp;)Lkotlinx/coroutines/internal/Symbol;", "X0", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "", "toString", "()Ljava/lang/String;", "Z", "Ljava/lang/Object;", "Y0", "()Ljava/lang/Object;", "X2", "Lkotlinx/coroutines/CancellableContinuation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class SendElement<E> extends Send {
    @NotNull
    @JvmField
    public final CancellableContinuation<Unit> X2;
    private final E Z;

    public SendElement(E e2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        this.Z = e2;
        this.X2 = cancellableContinuation;
    }

    public void X0() {
        this.X2.u0(CancellableContinuationImplKt.f29156d);
    }

    public E Y0() {
        return this.Z;
    }

    public void Z0(@NotNull Closed<?> closed) {
        CancellableContinuation<Unit> cancellableContinuation = this.X2;
        Result.Companion companion = Result.X;
        cancellableContinuation.w(Result.b(ResultKt.a(closed.f1())));
    }

    @Nullable
    public Symbol a1(@Nullable LockFreeLinkedListNode.PrepareOp prepareOp) {
        if (this.X2.r(Unit.f28779a, prepareOp != null ? prepareOp.f29361c : null) == null) {
            return null;
        }
        if (prepareOp != null) {
            prepareOp.d();
        }
        return CancellableContinuationImplKt.f29156d;
    }

    @NotNull
    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + ASCIIPropertyListParser.f18649g + Y0() + ASCIIPropertyListParser.f18650h;
    }
}
