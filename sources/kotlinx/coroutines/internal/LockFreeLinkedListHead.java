package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\t\u001a\u00020\u0007\"\u000e\b\u0000\u0010\u0005\u0018\u0001*\u00060\u0001j\u0002`\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\u0010\u0010\u0003R\u0011\u0010\u0014\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "Lkotlinx/coroutines/internal/Node;", "T", "Lkotlin/Function1;", "", "block", "X0", "(Lkotlin/jvm/functions/Function1;)V", "", "Z0", "()Ljava/lang/Void;", "P0", "()Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "a1", "", "Y0", "()Z", "isEmpty", "N0", "isRemoved", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public boolean N0() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public LockFreeLinkedListNode P0() {
        return null;
    }

    public /* bridge */ /* synthetic */ boolean Q0() {
        return ((Boolean) Z0()).booleanValue();
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void X0(Function1<? super T, Unit> function1) {
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) I0(); !Intrinsics.g(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.J0()) {
            Intrinsics.y(3, ExifInterface.d5);
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                function1.f(lockFreeLinkedListNode);
            }
        }
    }

    public final boolean Y0() {
        return I0() == this;
    }

    @NotNull
    public final Void Z0() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final void a1() {
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) I0();
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        while (!Intrinsics.g(lockFreeLinkedListNode, this)) {
            LockFreeLinkedListNode J0 = lockFreeLinkedListNode.J0();
            lockFreeLinkedListNode.W0(lockFreeLinkedListHead, J0);
            lockFreeLinkedListHead = lockFreeLinkedListNode;
            lockFreeLinkedListNode = J0;
        }
        W0(lockFreeLinkedListHead, (LockFreeLinkedListNode) I0());
    }
}
