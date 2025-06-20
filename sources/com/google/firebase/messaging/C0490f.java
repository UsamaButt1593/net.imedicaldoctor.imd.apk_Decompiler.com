package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.messaging.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0490f implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f24911a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Intent f24912b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f24913c;

    public /* synthetic */ C0490f(Context context, Intent intent, boolean z) {
        this.f24911a = context;
        this.f24912b = intent;
        this.f24913c = z;
    }

    public final Object a(Task task) {
        return FcmBroadcastProcessor.j(this.f24911a, this.f24912b, this.f24913c, task);
    }
}
