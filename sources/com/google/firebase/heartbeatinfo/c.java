package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f24395a;

    public /* synthetic */ c(Qualified qualified) {
        this.f24395a = qualified;
    }

    public final Object a(ComponentContainer componentContainer) {
        return DefaultHeartBeatController.h(this.f24395a, componentContainer);
    }
}
