package com.google.firebase.installations;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ FirebaseInstallations s;

    public /* synthetic */ e(FirebaseInstallations firebaseInstallations, boolean z) {
        this.s = firebaseInstallations;
        this.X = z;
    }

    public final void run() {
        this.s.D(this.X);
    }
}
