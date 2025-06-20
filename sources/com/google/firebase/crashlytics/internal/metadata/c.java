package com.google.firebase.crashlytics.internal.metadata;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.concurrent.Callable;

public final /* synthetic */ class c implements Callable {
    public final /* synthetic */ UserMetadata.SerializeableKeysMap s;

    public /* synthetic */ c(UserMetadata.SerializeableKeysMap serializeableKeysMap) {
        this.s = serializeableKeysMap;
    }

    public final Object call() {
        return this.s.c();
    }
}
