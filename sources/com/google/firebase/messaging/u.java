package com.google.firebase.messaging;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class u implements SuccessContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f24956a;

    public /* synthetic */ u(String str) {
        this.f24956a = str;
    }

    public final Task a(Object obj) {
        return ((TopicsSubscriber) obj).v(this.f24956a);
    }
}
