package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class s implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f23690a;

    public /* synthetic */ s(TaskCompletionSource taskCompletionSource) {
        this.f23690a = taskCompletionSource;
    }

    public final Object a(Task task) {
        return Utils.l(this.f23690a, task);
    }
}
