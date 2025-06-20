package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "k", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1 extends LockFreeLinkedListNode.CondAddOp {

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ AbstractChannel f29221d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AbstractChannel$enqueueReceiveInternal$$inlined$addLastIfPrevAndIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, AbstractChannel abstractChannel) {
        super(lockFreeLinkedListNode);
        this.f29221d = abstractChannel;
    }

    @Nullable
    /* renamed from: k */
    public Object i(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.f29221d.e0()) {
            return null;
        }
        return LockFreeLinkedListKt.a();
    }
}
