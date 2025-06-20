package com.google.firebase.messaging;

import com.google.android.gms.tasks.OnSuccessListener;

/* renamed from: com.google.firebase.messaging.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0497m implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f24916a;

    public /* synthetic */ C0497m(FirebaseMessaging firebaseMessaging) {
        this.f24916a = firebaseMessaging;
    }

    public final void a(Object obj) {
        this.f24916a.U((TopicsSubscriber) obj);
    }
}
