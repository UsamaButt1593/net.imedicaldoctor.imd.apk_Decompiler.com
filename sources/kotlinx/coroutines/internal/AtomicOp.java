package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0004\b\n\u0010\bJ!\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00028\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000f\u0010\bR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/AtomicOp;", "T", "Lkotlinx/coroutines/internal/OpDescriptor;", "<init>", "()V", "", "decision", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "affected", "i", "failure", "", "d", "(Ljava/lang/Object;Ljava/lang/Object;)V", "c", "f", "()Ljava/lang/Object;", "consensus", "", "h", "()Z", "isDecided", "", "g", "()J", "opSequence", "a", "()Lkotlinx/coroutines/internal/AtomicOp;", "atomicOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@InternalCoroutinesApi
public abstract class AtomicOp<T> extends OpDescriptor {

    /* renamed from: a  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f29333a = AtomicReferenceFieldUpdater.newUpdater(AtomicOp.class, Object.class, "_consensus");
    @NotNull
    private volatile /* synthetic */ Object _consensus = AtomicKt.f29331a;

    @NotNull
    public AtomicOp<?> a() {
        return this;
    }

    @Nullable
    public final Object c(@Nullable Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == AtomicKt.f29331a) {
            obj2 = e(i(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(T t, @Nullable Object obj);

    @Nullable
    public final Object e(@Nullable Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = AtomicKt.f29331a;
        if (obj2 != obj3) {
            return obj2;
        }
        return a.a(f29333a, this, obj3, obj) ? obj : this._consensus;
    }

    @Nullable
    public final Object f() {
        return this._consensus;
    }

    public long g() {
        return 0;
    }

    public final boolean h() {
        return this._consensus != AtomicKt.f29331a;
    }

    @Nullable
    public abstract Object i(T t);
}
