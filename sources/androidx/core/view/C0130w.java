package androidx.core.view;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* renamed from: androidx.core.view.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0130w implements LifecycleEventObserver {
    public final /* synthetic */ MenuProvider X;
    public final /* synthetic */ MenuHostHelper s;

    public /* synthetic */ C0130w(MenuHostHelper menuHostHelper, MenuProvider menuProvider) {
        this.s = menuHostHelper;
        this.X = menuProvider;
    }

    public final void d(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.s.f(this.X, lifecycleOwner, event);
    }
}
