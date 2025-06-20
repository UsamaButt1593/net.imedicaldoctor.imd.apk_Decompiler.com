package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u00038\u0010X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/lifecycle/LifecycleCoroutineScopeImpl;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "(Landroidx/lifecycle/Lifecycle;Lkotlin/coroutines/CoroutineContext;)V", "", "m", "()V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "d", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "s", "Landroidx/lifecycle/Lifecycle;", "h", "()Landroidx/lifecycle/Lifecycle;", "X", "Lkotlin/coroutines/CoroutineContext;", "U", "()Lkotlin/coroutines/CoroutineContext;", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class LifecycleCoroutineScopeImpl extends LifecycleCoroutineScope implements LifecycleEventObserver {
    @NotNull
    private final CoroutineContext X;
    @NotNull
    private final Lifecycle s;

    public LifecycleCoroutineScopeImpl(@NotNull Lifecycle lifecycle, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.p(lifecycle, "lifecycle");
        Intrinsics.p(coroutineContext, "coroutineContext");
        this.s = lifecycle;
        this.X = coroutineContext;
        if (h().b() == Lifecycle.State.DESTROYED) {
            JobKt__JobKt.i(U(), (CancellationException) null, 1, (Object) null);
        }
    }

    @NotNull
    public CoroutineContext U() {
        return this.X;
    }

    public void d(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.p(lifecycleOwner, "source");
        Intrinsics.p(event, NotificationCompat.I0);
        if (h().b().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            h().d(this);
            JobKt__JobKt.i(U(), (CancellationException) null, 1, (Object) null);
        }
    }

    @NotNull
    public Lifecycle h() {
        return this.s;
    }

    public final void m() {
        Job unused = BuildersKt__Builders_commonKt.f(this, Dispatchers.e().i0(), (CoroutineStart) null, new LifecycleCoroutineScopeImpl$register$1(this, (Continuation<? super LifecycleCoroutineScopeImpl$register$1>) null), 2, (Object) null);
    }
}
