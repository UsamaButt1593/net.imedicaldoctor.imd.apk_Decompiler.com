package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class w implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f23693a;

    public /* synthetic */ w(TaskCompletionSource taskCompletionSource) {
        this.f23693a = taskCompletionSource;
    }

    public final Object a(Task task) {
        return Utils.m(this.f23693a, task);
    }
}
