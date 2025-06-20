package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class G implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RequestDeduplicator f24774a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f24775b;

    public /* synthetic */ G(RequestDeduplicator requestDeduplicator, String str) {
        this.f24774a = requestDeduplicator;
        this.f24775b = str;
    }

    public final Object a(Task task) {
        return this.f24774a.c(this.f24775b, task);
    }
}
