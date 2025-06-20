package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.firebase.messaging.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0493i implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24914a;

    public /* synthetic */ C0493i(String str) {
        this.f24914a = str;
    }

    public final Task a(Object obj) {
        return ((TopicsSubscriber) obj).s(this.f24914a);
    }
}
