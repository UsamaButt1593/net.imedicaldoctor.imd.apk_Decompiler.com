package kotlinx.coroutines.scheduling;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J+\u0010\u001a\u001a\u00020\u00132\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u000f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0005H\u0000¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0013H\u0000¢\u0006\u0004\b\"\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8VX\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "", "corePoolSize", "maxPoolSize", "", "idleWorkerKeepAliveNs", "", "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "q0", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "R", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "S", "Lkotlinx/coroutines/scheduling/TaskContext;", "", "tailDispatch", "r0", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "close", "()V", "B0", "timeout", "x0", "(J)V", "s0", "Z", "I", "X2", "Y2", "J", "Z2", "Ljava/lang/String;", "a3", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "Ljava/util/concurrent/Executor;", "i0", "()Ljava/util/concurrent/Executor;", "executor", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class SchedulerCoroutineDispatcher extends ExecutorCoroutineDispatcher {
    private final int X2;
    private final long Y2;
    private final int Z;
    @NotNull
    private final String Z2;
    @NotNull
    private CoroutineScheduler a3;

    public SchedulerCoroutineDispatcher() {
        this(0, 0, 0, (String) null, 15, (DefaultConstructorMarker) null);
    }

    private final CoroutineScheduler q0() {
        return new CoroutineScheduler(this.Z, this.X2, this.Y2, this.Z2);
    }

    public final synchronized void B0() {
        this.a3.H(1000);
        this.a3 = q0();
    }

    public void R(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        CoroutineScheduler.r(this.a3, runnable, (TaskContext) null, false, 6, (Object) null);
    }

    public void S(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        CoroutineScheduler.r(this.a3, runnable, (TaskContext) null, true, 2, (Object) null);
    }

    public void close() {
        this.a3.close();
    }

    @NotNull
    public Executor i0() {
        return this.a3;
    }

    public final void r0(@NotNull Runnable runnable, @NotNull TaskContext taskContext, boolean z) {
        this.a3.q(runnable, taskContext, z);
    }

    public final void s0() {
        B0();
    }

    public final synchronized void x0(long j2) {
        this.a3.H(j2);
    }

    public SchedulerCoroutineDispatcher(int i2, int i3, long j2, @NotNull String str) {
        this.Z = i2;
        this.X2 = i3;
        this.Y2 = j2;
        this.Z2 = str;
        this.a3 = q0();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SchedulerCoroutineDispatcher(int r4, int r5, long r6, java.lang.String r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            int r4 = kotlinx.coroutines.scheduling.TasksKt.f29415c
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = kotlinx.coroutines.scheduling.TasksKt.f29416d
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            long r6 = kotlinx.coroutines.scheduling.TasksKt.f29417e
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            java.lang.String r8 = "CoroutineScheduler"
        L_0x001a:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r10 = r2
            r5.<init>(r6, r7, r8, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.SchedulerCoroutineDispatcher.<init>(int, int, long, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
