package com.google.firebase.messaging;

import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;

public final /* synthetic */ class v implements RequestDeduplicator.GetTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f24957a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24958b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Store.Token f24959c;

    public /* synthetic */ v(FirebaseMessaging firebaseMessaging, String str, Store.Token token) {
        this.f24957a = firebaseMessaging;
        this.f24958b = str;
        this.f24959c = token;
    }

    public final Task start() {
        return this.f24957a.M(this.f24958b, this.f24959c);
    }
}
