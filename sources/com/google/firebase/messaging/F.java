package com.google.firebase.messaging;

import android.content.Context;
import com.google.android.gms.tasks.OnSuccessListener;

public final /* synthetic */ class F implements OnSuccessListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f24736a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f24737b;

    public /* synthetic */ F(Context context, boolean z) {
        this.f24736a = context;
        this.f24737b = z;
    }

    public final void a(Object obj) {
        ProxyNotificationPreferences.h(this.f24736a, this.f24737b);
    }
}
