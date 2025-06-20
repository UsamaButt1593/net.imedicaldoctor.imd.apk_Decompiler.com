package com.google.firebase.crashlytics.internal.metadata;

import java.util.List;
import java.util.concurrent.Callable;

public final /* synthetic */ class a implements Callable {
    public final /* synthetic */ List X;
    public final /* synthetic */ UserMetadata s;

    public /* synthetic */ a(UserMetadata userMetadata, List list) {
        this.s = userMetadata;
        this.X = list;
    }

    public final Object call() {
        return this.s.k(this.X);
    }
}
