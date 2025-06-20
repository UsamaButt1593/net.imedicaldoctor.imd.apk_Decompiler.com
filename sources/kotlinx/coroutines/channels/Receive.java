package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\t\u001a\u00020\b2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H&¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/Receive;", "E", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "<init>", "()V", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "Z0", "(Lkotlinx/coroutines/channels/Closed;)V", "value", "Lkotlin/Function1;", "", "Y0", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/Symbol;", "X0", "()Lkotlinx/coroutines/internal/Symbol;", "offerResult", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class Receive<E> extends LockFreeLinkedListNode implements ReceiveOrClosed<E> {
    @NotNull
    /* renamed from: X0 */
    public Symbol v() {
        return AbstractChannelKt.f29227d;
    }

    @Nullable
    public Function1<Throwable, Unit> Y0(E e2) {
        return null;
    }

    public abstract void Z0(@NotNull Closed<?> closed);
}
