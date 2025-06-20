package com.google.firebase.installations;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ FirebaseInstallations s;

    public /* synthetic */ b(FirebaseInstallations firebaseInstallations, boolean z) {
        this.s = firebaseInstallations;
        this.X = z;
    }

    public final void run() {
        this.s.B(this.X);
    }
}
