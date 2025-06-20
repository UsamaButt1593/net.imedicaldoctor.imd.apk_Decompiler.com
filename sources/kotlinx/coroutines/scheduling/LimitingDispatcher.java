package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B)\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0013\u001a\u00020\u00122\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0016\u001a\u00020\u00122\n\u0010\u0015\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001a2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0012H\u0016¢\u0006\u0004\b!\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\t\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010%\u001a\u0004\b)\u0010*R\u001e\u0010.\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0+8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "", "name", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILjava/lang/String;I)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "tailDispatch", "", "q0", "(Ljava/lang/Runnable;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "context", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "toString", "()Ljava/lang/String;", "w", "Z", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "X2", "I", "Y2", "Ljava/lang/String;", "Z2", "G", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "a3", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "i0", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    private static final /* synthetic */ AtomicIntegerFieldUpdater b3 = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    private final int X2;
    @Nullable
    private final String Y2;
    @NotNull
    private final ExperimentalCoroutineDispatcher Z;
    private final int Z2;
    @NotNull
    private final ConcurrentLinkedQueue<Runnable> a3 = new ConcurrentLinkedQueue<>();
    @NotNull
    private volatile /* synthetic */ int inFlightTasks = 0;

    public LimitingDispatcher(@NotNull ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i2, @Nullable String str, int i3) {
        this.Z = experimentalCoroutineDispatcher;
        this.X2 = i2;
        this.Y2 = str;
        this.Z2 = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK, PHI: r4 
      PHI: (r4v1 java.lang.Runnable) = (r4v0 java.lang.Runnable), (r4v5 java.lang.Runnable) binds: [B:0:0x0000, B:8:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void q0(java.lang.Runnable r4, boolean r5) {
        /*
            r3 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = b3
            int r1 = r0.incrementAndGet(r3)
            int r2 = r3.X2
            if (r1 > r2) goto L_0x0010
            kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher r0 = r3.Z
            r0.x0(r4, r3, r5)
            return
        L_0x0010:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r1 = r3.a3
            r1.add(r4)
            int r4 = r0.decrementAndGet(r3)
            int r0 = r3.X2
            if (r4 < r0) goto L_0x001e
            return
        L_0x001e:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r4 = r3.a3
            java.lang.Object r4 = r4.poll()
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            if (r4 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.LimitingDispatcher.q0(java.lang.Runnable, boolean):void");
    }

    public int G() {
        return this.Z2;
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        q0(runnable, false);
    }

    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        q0(runnable, true);
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void execute(@NotNull Runnable runnable) {
        q0(runnable, false);
    }

    @NotNull
    public Executor i0() {
        return this;
    }

    @NotNull
    public String toString() {
        String str = this.Y2;
        if (str != null) {
            return str;
        }
        return super.toString() + "[dispatcher = " + this.Z + ']';
    }

    public void w() {
        Runnable poll = this.a3.poll();
        if (poll != null) {
            this.Z.x0(poll, this, true);
            return;
        }
        b3.decrementAndGet(this);
        Runnable poll2 = this.a3.poll();
        if (poll2 != null) {
            q0(poll2, true);
        }
    }
}
