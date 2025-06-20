package androidx.lifecycle;

import androidx.annotation.AnyThread;
import androidx.annotation.MainThread;
import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\u0003J\u000f\u0010\n\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u0003J\u000f\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Landroidx/lifecycle/DispatchQueue;", "", "<init>", "()V", "Ljava/lang/Runnable;", "runnable", "", "f", "(Ljava/lang/Runnable;)V", "h", "i", "g", "e", "", "b", "()Z", "Lkotlin/coroutines/CoroutineContext;", "context", "c", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "a", "Z", "paused", "finished", "isDraining", "Ljava/util/Queue;", "d", "Ljava/util/Queue;", "queue", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class DispatchQueue {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8517a = true;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8518b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8519c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Runnable> f8520d = new ArrayDeque();

    /* access modifiers changed from: private */
    public static final void d(DispatchQueue dispatchQueue, Runnable runnable) {
        Intrinsics.p(dispatchQueue, "this$0");
        Intrinsics.p(runnable, "$runnable");
        dispatchQueue.f(runnable);
    }

    @MainThread
    private final void f(Runnable runnable) {
        if (this.f8520d.offer(runnable)) {
            e();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    @MainThread
    public final boolean b() {
        return this.f8518b || !this.f8517a;
    }

    @AnyThread
    public final void c(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.p(coroutineContext, "context");
        Intrinsics.p(runnable, "runnable");
        MainCoroutineDispatcher i0 = Dispatchers.e().i0();
        if (i0.T(coroutineContext) || b()) {
            i0.R(coroutineContext, new d(this, runnable));
        } else {
            f(runnable);
        }
    }

    @MainThread
    public final void e() {
        if (!this.f8519c) {
            boolean z = false;
            z = true;
            try {
                while (true) {
                    if (!(this.f8520d.isEmpty() ^ z)) {
                        break;
                    } else if (!b()) {
                        break;
                    } else {
                        Runnable poll = this.f8520d.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.f8519c = z;
            } finally {
                this.f8519c = z;
            }
        }
    }

    @MainThread
    public final void g() {
        this.f8518b = true;
        e();
    }

    @MainThread
    public final void h() {
        this.f8517a = true;
    }

    @MainThread
    public final void i() {
        if (this.f8517a) {
            if (!this.f8518b) {
                this.f8517a = false;
                e();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
