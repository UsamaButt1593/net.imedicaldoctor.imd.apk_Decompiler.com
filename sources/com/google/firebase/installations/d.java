package com.google.firebase.installations;

import java.util.concurrent.Callable;

public final /* synthetic */ class d implements Callable {
    public final /* synthetic */ FirebaseInstallations s;

    public /* synthetic */ d(FirebaseInstallations firebaseInstallations) {
        this.s = firebaseInstallations;
    }

    public final Object call() {
        return this.s.m();
    }
}
