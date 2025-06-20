package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.EventLoopImplBase;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "<init>", "()V", "", "Q0", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "P0", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "Ljava/lang/Thread;", "N0", "()Ljava/lang/Thread;", "thread", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class EventLoopImplPlatform extends EventLoop {
    /* access modifiers changed from: protected */
    @NotNull
    public abstract Thread N0();

    /* access modifiers changed from: protected */
    public void P0(long j2, @NotNull EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.a3.Z0(j2, delayedTask);
    }

    /* access modifiers changed from: protected */
    public final void Q0() {
        Unit unit;
        Thread N0 = N0();
        if (Thread.currentThread() != N0) {
            AbstractTimeSource b2 = AbstractTimeSourceKt.b();
            if (b2 != null) {
                b2.g(N0);
                unit = Unit.f28779a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(N0);
            }
        }
    }
}
