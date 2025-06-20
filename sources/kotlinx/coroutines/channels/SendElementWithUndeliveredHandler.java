package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u001c\u0010\t\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R*\u0010\t\u001a\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b8\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/SendElementWithUndeliveredHandler;", "E", "Lkotlinx/coroutines/channels/SendElement;", "pollResult", "Lkotlinx/coroutines/CancellableContinuation;", "", "cont", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;Lkotlin/jvm/functions/Function1;)V", "", "Q0", "()Z", "b1", "()V", "Y2", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class SendElementWithUndeliveredHandler<E> extends SendElement<E> {
    @NotNull
    @JvmField
    public final Function1<E, Unit> Y2;

    public SendElementWithUndeliveredHandler(E e2, @NotNull CancellableContinuation<? super Unit> cancellableContinuation, @NotNull Function1<? super E, Unit> function1) {
        super(e2, cancellableContinuation);
        this.Y2 = function1;
    }

    public boolean Q0() {
        if (!super.Q0()) {
            return false;
        }
        b1();
        return true;
    }

    public void b1() {
        OnUndeliveredElementKt.b(this.Y2, Y0(), this.X2.g());
    }
}
