package kotlinx.coroutines.sync;

import com.google.common.util.concurrent.I;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u0005H\b¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0004\b\u000f\u0010\u0010J,\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0004\b\u0013\u0010\u0014J$\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\nH\b¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "", "id", "prev", "", "pointers", "<init>", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "index", "", "u", "(I)Ljava/lang/Object;", "value", "", "w", "(ILjava/lang/Object;)V", "expected", "", "t", "(ILjava/lang/Object;Ljava/lang/Object;)Z", "v", "(ILjava/lang/Object;)Ljava/lang/Object;", "s", "(I)V", "", "toString", "()Ljava/lang/String;", "p", "()I", "maxSlots", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class SemaphoreSegment extends Segment<SemaphoreSegment> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    /* synthetic */ AtomicReferenceArray f29468e = new AtomicReferenceArray(SemaphoreKt.f29467f);

    public SemaphoreSegment(long j2, @Nullable SemaphoreSegment semaphoreSegment, int i2) {
        super(j2, semaphoreSegment, i2);
    }

    public int p() {
        return SemaphoreKt.f29467f;
    }

    public final void s(int i2) {
        this.f29468e.set(i2, SemaphoreKt.f29466e);
        q();
    }

    public final boolean t(int i2, @Nullable Object obj, @Nullable Object obj2) {
        return I.a(this.f29468e, i2, obj, obj2);
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + o() + ", hashCode=" + hashCode() + ']';
    }

    @Nullable
    public final Object u(int i2) {
        return this.f29468e.get(i2);
    }

    @Nullable
    public final Object v(int i2, @Nullable Object obj) {
        return this.f29468e.getAndSet(i2, obj);
    }

    public final void w(int i2, @Nullable Object obj) {
        this.f29468e.set(i2, obj);
    }
}
