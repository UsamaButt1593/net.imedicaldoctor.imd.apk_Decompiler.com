package com.google.firebase.messaging;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.messaging.FirebaseMessaging;

public final /* synthetic */ class x implements EventHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging.AutoInit f24960a;

    public /* synthetic */ x(FirebaseMessaging.AutoInit autoInit) {
        this.f24960a = autoInit;
    }

    public final void a(Event event) {
        this.f24960a.d(event);
    }
}
