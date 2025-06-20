package kotlinx.coroutines.internal;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\f\b \u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0000¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\f¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/internal/Segment;I)V", "", "r", "()Z", "n", "", "q", "()V", "c", "J", "o", "()J", "p", "()I", "maxSlots", "g", "removed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class Segment<S extends Segment<S>> extends ConcurrentLinkedListNode<S> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f29390d = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");

    /* renamed from: c  reason: collision with root package name */
    private final long f29391c;
    @NotNull
    private volatile /* synthetic */ int cleanedAndPointers;

    public Segment(long j2, @Nullable S s, int i2) {
        super(s);
        this.f29391c = j2;
        this.cleanedAndPointers = i2 << 16;
    }

    public boolean g() {
        return this.cleanedAndPointers == p() && !i();
    }

    public final boolean n() {
        return f29390d.addAndGet(this, SupportMenu.f5941c) == p() && !i();
    }

    public final long o() {
        return this.f29391c;
    }

    public abstract int p();

    public final void q() {
        if (f29390d.incrementAndGet(this) == p() && !i()) {
            l();
        }
    }

    public final boolean r() {
        int i2;
        do {
            i2 = this.cleanedAndPointers;
            if (i2 == p() && !i()) {
                return false;
            }
        } while (!f29390d.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
