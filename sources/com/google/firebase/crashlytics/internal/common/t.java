package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class t implements Continuation {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f23691a;

    public /* synthetic */ t(CountDownLatch countDownLatch) {
        this.f23691a = countDownLatch;
    }

    public final Object a(Task task) {
        return this.f23691a.countDown();
    }
}
