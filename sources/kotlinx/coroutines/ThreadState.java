package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lkotlinx/coroutines/ThreadState;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/Job;", "job", "<init>", "(Lkotlinx/coroutines/Job;)V", "", "state", "", "d", "(I)Ljava/lang/Void;", "h", "()V", "b", "g", "(Ljava/lang/Throwable;)V", "s", "Lkotlinx/coroutines/Job;", "Ljava/lang/Thread;", "kotlin.jvm.PlatformType", "X", "Ljava/lang/Thread;", "targetThread", "Lkotlinx/coroutines/DisposableHandle;", "Y", "Lkotlinx/coroutines/DisposableHandle;", "cancelHandle", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
final class ThreadState implements Function1<Throwable, Unit> {
    private static final /* synthetic */ AtomicIntegerFieldUpdater Z = AtomicIntegerFieldUpdater.newUpdater(ThreadState.class, "_state");
    private final Thread X = Thread.currentThread();
    @Nullable
    private DisposableHandle Y;
    @NotNull
    private volatile /* synthetic */ int _state = 0;
    @NotNull
    private final Job s;

    public ThreadState(@NotNull Job job) {
        this.s = job;
    }

    private final Void d(int i2) {
        throw new IllegalStateException(("Illegal state " + i2).toString());
    }

    public final void b() {
        while (true) {
            int i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        d(i2);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (Z.compareAndSet(this, i2, 1)) {
                DisposableHandle disposableHandle = this.Y;
                if (disposableHandle != null) {
                    disposableHandle.m();
                    return;
                }
                return;
            }
        }
    }

    public /* bridge */ /* synthetic */ Object f(Object obj) {
        g((Throwable) obj);
        return Unit.f28779a;
    }

    public void g(@Nullable Throwable th) {
        int i2;
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 != 1 && i2 != 2 && i2 != 3) {
                    d(i2);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!Z.compareAndSet(this, i2, 2));
        this.X.interrupt();
        this._state = 3;
    }

    public final void h() {
        int i2;
        this.Y = this.s.H(true, true, this);
        do {
            i2 = this._state;
            if (i2 != 0) {
                if (i2 != 2 && i2 != 3) {
                    d(i2);
                    throw new KotlinNothingValueException();
                }
                return;
            }
        } while (!Z.compareAndSet(this, i2, 0));
    }
}
