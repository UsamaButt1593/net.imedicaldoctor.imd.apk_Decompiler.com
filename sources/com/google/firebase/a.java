package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseApp f23343a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f23344b;

    public /* synthetic */ a(FirebaseApp firebaseApp, Context context) {
        this.f23343a = firebaseApp;
        this.f23344b = context;
    }

    public final Object get() {
        return this.f23343a.C(this.f23344b);
    }
}
