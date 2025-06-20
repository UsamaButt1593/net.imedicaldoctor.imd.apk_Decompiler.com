package com.google.firebase.installations;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f24440a;

    public /* synthetic */ a(FirebaseApp firebaseApp) {
        this.f24440a = firebaseApp;
    }

    public final Object get() {
        return FirebaseInstallations.E(this.f24440a);
    }
}
