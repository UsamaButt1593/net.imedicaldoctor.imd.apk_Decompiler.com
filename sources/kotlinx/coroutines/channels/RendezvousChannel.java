package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0006\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/RendezvousChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "", "d0", "()Z", "isBufferAlwaysEmpty", "e0", "isBufferEmpty", "y", "isBufferAlwaysFull", "A", "isBufferFull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class RendezvousChannel<E> extends AbstractChannel<E> {
    public RendezvousChannel(@Nullable Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* access modifiers changed from: protected */
    public final boolean A() {
        return true;
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
    public final boolean y() {
        return true;
    }
}
