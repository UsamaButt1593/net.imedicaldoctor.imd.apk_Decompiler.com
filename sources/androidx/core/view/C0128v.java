package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0128v implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle.State X;
    public final /* synthetic */ MenuProvider Y;
    public final /* synthetic */ MenuHostHelper s;

    public /* synthetic */ C0128v(MenuHostHelper menuHostHelper, Lifecycle.State state, MenuProvider menuProvider) {
        this.s = menuHostHelper;
        this.X = state;
        this.Y = menuProvider;
    }

    public final void d(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.s.g(this.X, this.Y, lifecycleOwner, event);
    }
}
