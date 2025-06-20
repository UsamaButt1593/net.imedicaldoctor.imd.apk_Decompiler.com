package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.ArrayQueue;
import kotlinx.coroutines.internal.LimitedDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u0011\u001a\u00020\u00102\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0003R\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001eR\"\u0010#\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00048TX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\fR\u0014\u0010'\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\nR\u0011\u0010)\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b(\u0010\fR\u0011\u0010+\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b*\u0010\fR\u0011\u0010-\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b,\u0010\f¨\u0006."}, d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "()V", "", "unconfined", "", "r0", "(Z)J", "J0", "()J", "K0", "()Z", "L0", "Lkotlinx/coroutines/DispatchedTask;", "task", "", "s0", "(Lkotlinx/coroutines/DispatchedTask;)V", "B0", "(Z)V", "i0", "", "parallelism", "W", "(I)Lkotlinx/coroutines/CoroutineDispatcher;", "shutdown", "Y", "J", "useCount", "Z", "shared", "Lkotlinx/coroutines/internal/ArrayQueue;", "X2", "Lkotlinx/coroutines/internal/ArrayQueue;", "unconfinedQueue", "D0", "isEmpty", "x0", "nextTime", "b", "isActive", "G0", "isUnconfinedLoopActive", "I0", "isUnconfinedQueueEmpty", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class EventLoop extends CoroutineDispatcher {
    @Nullable
    private ArrayQueue<DispatchedTask<?>> X2;
    private long Y;
    private boolean Z;

    public static /* synthetic */ void C0(EventLoop eventLoop, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            eventLoop.B0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public static /* synthetic */ void q0(EventLoop eventLoop, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            eventLoop.i0(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long r0(boolean z) {
        return z ? 4294967296L : 1;
    }

    public final void B0(boolean z) {
        this.Y += r0(z);
        if (!z) {
            this.Z = true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean D0() {
        return I0();
    }

    public final boolean G0() {
        return this.Y >= r0(true);
    }

    public final boolean I0() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.X2;
        if (arrayQueue != null) {
            return arrayQueue.d();
        }
        return true;
    }

    public long J0() {
        return !K0() ? Long.MAX_VALUE : 0;
    }

    public final boolean K0() {
        DispatchedTask e2;
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.X2;
        if (arrayQueue == null || (e2 = arrayQueue.e()) == null) {
            return false;
        }
        e2.run();
        return true;
    }

    public boolean L0() {
        return false;
    }

    @NotNull
    public final CoroutineDispatcher W(int i2) {
        LimitedDispatcherKt.a(i2);
        return this;
    }

    public final boolean b() {
        return this.Y > 0;
    }

    public final void i0(boolean z) {
        long r0 = this.Y - r0(z);
        this.Y = r0;
        if (r0 <= 0 && this.Z) {
            shutdown();
        }
    }

    public final void s0(@NotNull DispatchedTask<?> dispatchedTask) {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.X2;
        if (arrayQueue == null) {
            arrayQueue = new ArrayQueue<>();
            this.X2 = arrayQueue;
        }
        arrayQueue.a(dispatchedTask);
    }

    public void shutdown() {
    }

    /* access modifiers changed from: protected */
    public long x0() {
        ArrayQueue<DispatchedTask<?>> arrayQueue = this.X2;
        return (arrayQueue != null && !arrayQueue.d()) ? 0 : Long.MAX_VALUE;
    }
}
