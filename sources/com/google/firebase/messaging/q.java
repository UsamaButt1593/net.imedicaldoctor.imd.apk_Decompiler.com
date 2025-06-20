package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class q implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f24917a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24918b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f24919c;

    public /* synthetic */ q(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f24917a = firebaseMessaging;
        this.f24918b = str;
        this.f24919c = token;
    }

    public final Task a(Object obj) {
        return this.f24917a.L(this.f24918b, this.f24919c, (String) obj);
    }
}
