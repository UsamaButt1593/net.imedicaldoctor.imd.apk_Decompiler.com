package androidx.lifecycle;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u001b¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/ServiceLifecycleDispatcher;", "", "Landroidx/lifecycle/LifecycleOwner;", "provider", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "f", "(Landroidx/lifecycle/Lifecycle$Event;)V", "c", "()V", "b", "e", "d", "Landroidx/lifecycle/LifecycleRegistry;", "a", "Landroidx/lifecycle/LifecycleRegistry;", "registry", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Landroidx/lifecycle/ServiceLifecycleDispatcher$DispatchRunnable;", "Landroidx/lifecycle/ServiceLifecycleDispatcher$DispatchRunnable;", "lastDispatchRunnable", "Landroidx/lifecycle/Lifecycle;", "()Landroidx/lifecycle/Lifecycle;", "lifecycle", "DispatchRunnable", "lifecycle-service_release"}, k = 1, mv = {1, 8, 0})
public class ServiceLifecycleDispatcher {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleRegistry f8595a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8596b = new Handler();
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private DispatchRunnable f8597c;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/lifecycle/ServiceLifecycleDispatcher$DispatchRunnable;", "Ljava/lang/Runnable;", "Landroidx/lifecycle/LifecycleRegistry;", "registry", "Landroidx/lifecycle/Lifecycle$Event;", "event", "<init>", "(Landroidx/lifecycle/LifecycleRegistry;Landroidx/lifecycle/Lifecycle$Event;)V", "", "run", "()V", "s", "Landroidx/lifecycle/LifecycleRegistry;", "X", "Landroidx/lifecycle/Lifecycle$Event;", "a", "()Landroidx/lifecycle/Lifecycle$Event;", "", "Y", "Z", "wasExecuted", "lifecycle-service_release"}, k = 1, mv = {1, 8, 0})
    public static final class DispatchRunnable implements Runnable {
        @NotNull
        private final Lifecycle.Event X;
        private boolean Y;
        @NotNull
        private final LifecycleRegistry s;

        public DispatchRunnable(@NotNull LifecycleRegistry lifecycleRegistry, @NotNull Lifecycle.Event event) {
            Intrinsics.p(lifecycleRegistry, "registry");
            Intrinsics.p(event, NotificationCompat.I0);
            this.s = lifecycleRegistry;
            this.X = event;
        }

        @NotNull
        public final Lifecycle.Event a() {
            return this.X;
        }

        public void run() {
            if (!this.Y) {
                this.s.l(this.X);
                this.Y = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.p(lifecycleOwner, "provider");
        this.f8595a = new LifecycleRegistry(lifecycleOwner);
    }

    private final void f(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f8597c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f8595a, event);
        this.f8597c = dispatchRunnable2;
        Handler handler = this.f8596b;
        Intrinsics.m(dispatchRunnable2);
        handler.postAtFrontOfQueue(dispatchRunnable2);
    }

    @NotNull
    public Lifecycle a() {
        return this.f8595a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }
}
