package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
@MainThread
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/lifecycle/LifecycleController;", "", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Landroidx/lifecycle/DispatchQueue;", "dispatchQueue", "Lkotlinx/coroutines/Job;", "parentJob", "<init>", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/DispatchQueue;Lkotlinx/coroutines/Job;)V", "", "c", "(Lkotlinx/coroutines/Job;)V", "b", "()V", "a", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/Lifecycle$State;", "Landroidx/lifecycle/DispatchQueue;", "Landroidx/lifecycle/LifecycleEventObserver;", "d", "Landroidx/lifecycle/LifecycleEventObserver;", "observer", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class LifecycleController {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Lifecycle f8526a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lifecycle.State f8527b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final DispatchQueue f8528c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final LifecycleEventObserver f8529d;

    public LifecycleController(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull DispatchQueue dispatchQueue, @NotNull Job job) {
        Intrinsics.p(lifecycle, "lifecycle");
        Intrinsics.p(state, "minState");
        Intrinsics.p(dispatchQueue, "dispatchQueue");
        Intrinsics.p(job, "parentJob");
        this.f8526a = lifecycle;
        this.f8527b = state;
        this.f8528c = dispatchQueue;
        f fVar = new f(this, job);
        this.f8529d = fVar;
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.b(job, (CancellationException) null, 1, (Object) null);
            b();
            return;
        }
        lifecycle.a(fVar);
    }

    private final void c(Job job) {
        Job.DefaultImpls.b(job, (CancellationException) null, 1, (Object) null);
        b();
    }

    /* access modifiers changed from: private */
    public static final void d(LifecycleController lifecycleController, Job job, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.p(lifecycleController, "this$0");
        Intrinsics.p(job, "$parentJob");
        Intrinsics.p(lifecycleOwner, "source");
        Intrinsics.p(event, "<anonymous parameter 1>");
        if (lifecycleOwner.a().b() == Lifecycle.State.DESTROYED) {
            Job.DefaultImpls.b(job, (CancellationException) null, 1, (Object) null);
            lifecycleController.b();
            return;
        }
        int compareTo = lifecycleOwner.a().b().compareTo(lifecycleController.f8527b);
        DispatchQueue dispatchQueue = lifecycleController.f8528c;
        if (compareTo < 0) {
            dispatchQueue.h();
        } else {
            dispatchQueue.i();
        }
    }

    @MainThread
    public final void b() {
        this.f8526a.d(this.f8529d);
        this.f8528c.g();
    }
}
