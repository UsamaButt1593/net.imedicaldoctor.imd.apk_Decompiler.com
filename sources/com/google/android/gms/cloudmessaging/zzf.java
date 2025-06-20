package com.google.android.gms.cloudmessaging;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class zzf implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f19826a;

    public /* synthetic */ zzf(CountDownLatch countDownLatch) {
        this.f19826a = countDownLatch;
    }

    public final void a(Task task) {
        this.f19826a.countDown();
    }
}
