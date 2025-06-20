package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "Landroidx/lifecycle/GeneratedAdapter;", "generatedAdapters", "<init>", "([Landroidx/lifecycle/GeneratedAdapter;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "d", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "s", "[Landroidx/lifecycle/GeneratedAdapter;", "lifecycle-common"}, k = 1, mv = {1, 8, 0})
public final class CompositeGeneratedAdaptersObserver implements LifecycleEventObserver {
    @NotNull
    private final GeneratedAdapter[] s;

    public CompositeGeneratedAdaptersObserver(@NotNull GeneratedAdapter[] generatedAdapterArr) {
        Intrinsics.p(generatedAdapterArr, "generatedAdapters");
        this.s = generatedAdapterArr;
    }

    public void d(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Intrinsics.p(lifecycleOwner, "source");
        Intrinsics.p(event, NotificationCompat.I0);
        MethodCallsLogger methodCallsLogger = new MethodCallsLogger();
        for (GeneratedAdapter a2 : this.s) {
            a2.a(lifecycleOwner, event, false, methodCallsLogger);
        }
        for (GeneratedAdapter a3 : this.s) {
            a3.a(lifecycleOwner, event, true, methodCallsLogger);
        }
    }
}
