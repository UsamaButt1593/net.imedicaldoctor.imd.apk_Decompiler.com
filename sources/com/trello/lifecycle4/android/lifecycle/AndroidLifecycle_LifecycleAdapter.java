package com.trello.lifecycle4.android.lifecycle;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class AndroidLifecycle_LifecycleAdapter implements GeneratedAdapter {

    /* renamed from: a  reason: collision with root package name */
    final AndroidLifecycle f28244a;

    AndroidLifecycle_LifecycleAdapter(AndroidLifecycle androidLifecycle) {
        this.f28244a = androidLifecycle;
    }

    public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            return;
        }
        if (!z2 || methodCallsLogger.a("onEvent", 4)) {
            this.f28244a.onEvent(lifecycleOwner, event);
        }
    }
}
