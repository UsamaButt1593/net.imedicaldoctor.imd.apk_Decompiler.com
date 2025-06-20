package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public final /* synthetic */ class a implements LifecycleEventObserver {
    public final /* synthetic */ SavedStateRegistry s;

    public /* synthetic */ a(SavedStateRegistry savedStateRegistry) {
        this.s = savedStateRegistry;
    }

    public final void d(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.f(this.s, lifecycleOwner, event);
    }
}
