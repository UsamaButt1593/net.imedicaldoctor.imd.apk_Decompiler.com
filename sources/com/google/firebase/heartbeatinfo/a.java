package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f24393a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24394b;

    public /* synthetic */ a(Context context, String str) {
        this.f24393a = context;
        this.f24394b = str;
    }

    public final Object get() {
        return DefaultHeartBeatController.j(this.f24393a, this.f24394b);
    }
}
