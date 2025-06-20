package com.google.firebase.messaging;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class y implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f24961a;

    public /* synthetic */ y(Qualified qualified) {
        this.f24961a = qualified;
    }

    public final Object a(ComponentContainer componentContainer) {
        return FirebaseMessagingRegistrar.lambda$getComponents$0(this.f24961a, componentContainer);
    }
}
