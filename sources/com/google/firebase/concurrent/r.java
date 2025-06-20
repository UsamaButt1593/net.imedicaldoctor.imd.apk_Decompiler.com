package com.google.firebase.concurrent;

import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class r implements Provider {
    public final Object get() {
        return ExecutorsRegistrar.u(Executors.newCachedThreadPool(ExecutorsRegistrar.j("Firebase Blocking", 11)));
    }
}
