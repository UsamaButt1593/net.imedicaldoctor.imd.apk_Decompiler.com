package com.google.firebase.sessions;

import com.google.android.datatransport.Transformer;

public final /* synthetic */ class b implements Transformer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ EventGDTLogger f25146a;

    public /* synthetic */ b(EventGDTLogger eventGDTLogger) {
        this.f25146a = eventGDTLogger;
    }

    public final Object apply(Object obj) {
        return this.f25146a.c((SessionEvent) obj);
    }
}
