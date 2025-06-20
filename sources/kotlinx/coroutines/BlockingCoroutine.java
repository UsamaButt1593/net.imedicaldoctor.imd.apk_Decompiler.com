package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00028\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168TX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Ljava/lang/Thread;", "blockedThread", "Lkotlinx/coroutines/EventLoop;", "eventLoop", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "", "state", "", "s0", "(Ljava/lang/Object;)V", "K1", "()Ljava/lang/Object;", "Y", "Ljava/lang/Thread;", "Z", "Lkotlinx/coroutines/EventLoop;", "", "Z0", "()Z", "isScopedCoroutine", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {
    @NotNull
    private final Thread Y;
    @Nullable
    private final EventLoop Z;

    public BlockingCoroutine(@NotNull CoroutineContext coroutineContext, @NotNull Thread thread, @Nullable EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.Y = thread;
        this.Z = eventLoop;
    }

    public final T K1() {
        Unit unit;
        AbstractTimeSource b2 = AbstractTimeSourceKt.b();
        if (b2 != null) {
            b2.d();
        }
        try {
            EventLoop eventLoop = this.Z;
            CompletedExceptionally completedExceptionally = null;
            if (eventLoop != null) {
                EventLoop.C0(eventLoop, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.Z;
                long J0 = eventLoop2 != null ? eventLoop2.J0() : Long.MAX_VALUE;
                if (!p()) {
                    AbstractTimeSource b3 = AbstractTimeSourceKt.b();
                    if (b3 != null) {
                        b3.c(this, J0);
                        unit = Unit.f28779a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, J0);
                    }
                } else {
                    EventLoop eventLoop3 = this.Z;
                    if (eventLoop3 != null) {
                        EventLoop.q0(eventLoop3, false, 1, (Object) null);
                    }
                    AbstractTimeSource b4 = AbstractTimeSourceKt.b();
                    if (b4 != null) {
                        b4.h();
                    }
                    T o = JobSupportKt.o(T0());
                    if (o instanceof CompletedExceptionally) {
                        completedExceptionally = (CompletedExceptionally) o;
                    }
                    if (completedExceptionally == null) {
                        return o;
                    }
                    throw completedExceptionally.f29164a;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            w0(interruptedException);
            throw interruptedException;
        } catch (Throwable th) {
            AbstractTimeSource b5 = AbstractTimeSourceKt.b();
            if (b5 != null) {
                b5.h();
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean Z0() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void s0(@Nullable Object obj) {
        Unit unit;
        if (!Intrinsics.g(Thread.currentThread(), this.Y)) {
            Thread thread = this.Y;
            AbstractTimeSource b2 = AbstractTimeSourceKt.b();
            if (b2 != null) {
                b2.g(thread);
                unit = Unit.f28779a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }
}
