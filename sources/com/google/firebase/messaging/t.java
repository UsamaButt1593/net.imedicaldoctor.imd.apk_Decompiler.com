package com.google.firebase.messaging;

import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class t implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f24952a;

    public /* synthetic */ t(FirebaseMessaging firebaseMessaging) {
        this.f24952a = firebaseMessaging;
    }

    public final void a(Object obj) {
        this.f24952a.R((CloudMessage) obj);
    }
}
