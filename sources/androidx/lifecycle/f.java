package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlinx.coroutines.Job;

public final /* synthetic */ class f implements LifecycleEventObserver {
    public final /* synthetic */ Job X;
    public final /* synthetic */ LifecycleController s;

    public /* synthetic */ f(LifecycleController lifecycleController, Job job) {
        this.s = lifecycleController;
        this.X = job;
    }

    public final void d(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.d(this.s, this.X, lifecycleOwner, event);
    }
}
