package com.google.firebase.crashlytics.internal.metadata;

import java.util.concurrent.Callable;

public final /* synthetic */ class b implements Callable {
    public final /* synthetic */ UserMetadata s;

    public /* synthetic */ b(UserMetadata userMetadata) {
        this.s = userMetadata;
    }

    public final Object call() {
        return this.s.j();
    }
}
